package io.github.createtechified.techifiedores.registry;

import io.github.createtechified.techifiedores.utils.MaterialDef;
import io.github.createtechified.techifiedores.utils.TintableMaterialBlock;
import io.github.createtechified.techifiedores.utils.TintableMaterialItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static io.github.createtechified.techifiedores.TechifiedOresMod.MOD_ID;

public class ModRegistries {
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
        if (mat.hasBlock()) registerBlock(mat, "block", Blocks.IRON_BLOCK);
        if (mat.hasRawOreBlock()) registerBlock(mat, "raw_block", Blocks.RAW_IRON_BLOCK);

        // Ores
        if (mat.hasOverworldOre()) registerBlock(mat, "ore", Blocks.STONE);
        if (mat.hasNetherOre()) registerBlock(mat, "nether_ore", Blocks.NETHERRACK);
        if (mat.hasEndOre()) registerBlock(mat, "end_ore", Blocks.END_STONE);

        // Items
        if (mat.hasIngot()) registerItem(mat, "ingot");
        if (mat.hasNugget()) registerItem(mat, "nugget");
        if (mat.hasGemstone()) registerItem(mat, "gem");
        if (mat.hasDust()) registerItem(mat, "dust");
        if (mat.hasGear()) registerItem(mat, "gear");
        if (mat.hasRod()) registerItem(mat, "rod");
        if (mat.hasLongRod()) registerItem(mat, "long_rod");
        if (mat.hasPlate()) registerItem(mat, "plate");
        if (mat.hasRawOre()) registerItem(mat, "raw_ore");
    }

    private static void registerBlock(MaterialDef mat, String form, Block template) {
        String name = mat.name() + "_" + form;
        RegistryObject<Block> block = BLOCKS.register(name, () -> new TintableMaterialBlock(mat, form, BlockBehaviour.Properties.copy(template).requiresCorrectToolForDrops()));
        ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    private static void registerItem(MaterialDef mat, String form) {
        String name = mat.name() + "_" + form;
        ITEMS.register(name, () -> new TintableMaterialItem(mat, form, new Item.Properties()));
    }
}
