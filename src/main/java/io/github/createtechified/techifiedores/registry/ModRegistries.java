package io.github.createtechified.techifiedores.registry;

import io.github.createtechified.techifiedores.utils.MaterialDef;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRegistries {
    public static final String MOD_ID = "techifiedores";

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);

    public static void register(IEventBus modBus) {
        for (MaterialDef mat : ModMaterials.MATERIALS) {
            registerMaterial(mat);
        }

        BLOCKS.register(modBus);
        ITEMS.register(modBus);
    }

    private static void registerMaterial(MaterialDef mat) {
        // Blocks
        if (mat.hasBlock()) registerBlock(mat.name() + "_block", Blocks.IRON_BLOCK);
        if (mat.hasRawOreBlock()) registerBlock(mat.name() + "_raw_block", Blocks.RAW_IRON_BLOCK);

        // Ores
        if (mat.hasOverworldOre()) registerBlock(mat.name() + "_ore", Blocks.STONE);
        if (mat.hasNetherOre()) registerBlock(mat.name() + "_nether_ore", Blocks.NETHERRACK);
        if (mat.hasEndOre()) registerBlock(mat.name() + "_end_ore", Blocks.END_STONE);

        // Items
        if (mat.hasIngot()) registerItem(mat.name() + "_ingot");
        if (mat.hasNugget()) registerItem(mat.name() + "_nugget");
        if (mat.hasGemstone()) registerItem(mat.name() + "_gem");
        if (mat.hasDust()) registerItem(mat.name() + "_dust");
        if (mat.hasGear()) registerItem(mat.name() + "_gear");
        if (mat.hasRod()) registerItem(mat.name() + "_rod");
        if (mat.hasLongRod()) registerItem(mat.name() + "_long_rod");
        if (mat.hasPlate()) registerItem(mat.name() + "_plate");
        if (mat.hasRawOre()) registerItem(mat.name() + "_raw_ore");
    }

    private static void registerBlock(String name, Block template) {
        RegistryObject<Block> block = BLOCKS.register(name, () -> new Block(BlockBehaviour.Properties.copy(template).requiresCorrectToolForDrops()));
        ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    private static void registerItem(String name) {
        ITEMS.register(name, () -> new Item(new Item.Properties()));
    }
}
