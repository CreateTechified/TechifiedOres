package io.github.createtechified.techifiedores.datagen.client;

import io.github.createtechified.techifiedores.registry.ModRegistries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import static io.github.createtechified.techifiedores.TechifiedOresMod.MOD_ID;

public class BlockStates extends BlockStateProvider {
    public BlockStates(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        ModRegistries.BLOCKS.getEntries().forEach(entry -> {
            String modelPath = pickModelFor(entry.getId().getPath());
            simpleBlockWithItem(entry.get(), models().getExistingFile(modLoc(modelPath)));
        });
    }

    private static String pickModelFor(String name) {
        // Pick the correct shared model based on name
        if (name.endsWith("_raw_ore_block")) return "block/raw_ore_block";
        if (name.endsWith("_ore")) return "block/stone_ore";
        if (name.endsWith("_block")) return "block/storage_block";
        // i guess we do need error handling
        return "block/default_block";
    }
}
