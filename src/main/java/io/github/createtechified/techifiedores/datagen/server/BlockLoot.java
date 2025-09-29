package io.github.createtechified.techifiedores.datagen.server;

import io.github.createtechified.techifiedores.registry.ModRegistries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

import static io.github.createtechified.techifiedores.datagen.DataGenerators.getForm;
import static io.github.createtechified.techifiedores.datagen.DataGenerators.getMaterial;

public class BlockLoot extends BlockLootSubProvider {
    public BlockLoot() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        ModRegistries.BLOCKS.getEntries().forEach(entry -> {
            Block block = entry.get();
            String name = entry.getId().getPath();
            String form = getForm(name);
            String material = getMaterial(name, form);

            switch (form) {
                case "block", "raw_ore_block" -> this.dropSelf(block);
                case "ore", "nether_ore", "end_ore" -> {
                    String rawItemKey = material + "_raw_ore";
                    String dustItemKey = material + "_dust";
                    RegistryObject<Item> rawItemEntry = ModRegistries.ITEMS.getEntries().stream().filter(e -> e.getId().getPath().equals(rawItemKey)).findFirst().orElse(null);
                    RegistryObject<Item> dustItemEntry = ModRegistries.ITEMS.getEntries().stream().filter(e -> e.getId().getPath().equals(dustItemKey)).findFirst().orElse(null);
                    if (rawItemEntry != null) {
                        Item rawItem = rawItemEntry.get();
                        this.add(block, createOreDrop(block, rawItem));
                    } else if (material.equals("graphite")) {
                        Item dustItem = dustItemEntry.get();
                        this.add(block, createOreDrop(block, dustItem));
                    } else {
                        this.dropSelf(block);
                    }
                }
            }
        });
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModRegistries.BLOCKS.getEntries().stream().map(RegistryObject::get).toList();
    }
}
