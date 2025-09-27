package io.github.createtechified.techifiedores.datagen.server;

import io.github.createtechified.techifiedores.registry.ModRegistries;
import io.github.createtechified.techifiedores.utils.TintableMaterialBlock;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

import static io.github.createtechified.techifiedores.TechifiedOresMod.MOD_ID;

public class BlockTags extends BlockTagsProvider {
    public BlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        ModRegistries.BLOCKS.getEntries().forEach(entry -> {
            Block block = entry.get();
            this.tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(block);
            if (block instanceof TintableMaterialBlock tintableMaterialBlock) {
                int level = tintableMaterialBlock.getHarvestLevel();

                if (level >= 3) {
                    this.tag(net.minecraft.tags.BlockTags.NEEDS_DIAMOND_TOOL).add(block);
                } else if (level >= 2) {
                    this.tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL).add(block);
                } else if (level >= 1) {
                    this.tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(block);
                }
            }
        });
    }
}
