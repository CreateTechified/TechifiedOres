package io.github.createtechified.techifiedores.utils;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class TintableMaterialBlock extends Block {
    private final MaterialDef material;
    private final String form;
    private final int harvestLevel;

    public TintableMaterialBlock(MaterialDef material, String form, int harvestLevel, BlockBehaviour.Properties props) {
        super(props);
        this.material = material;
        this.form = form;
        this.harvestLevel = harvestLevel;
    }

    public MaterialDef getMaterial() {
        return material;
    }

    public int getHarvestLevel() {
        return harvestLevel;
    }

    public ResourceLocation getBaseTexture() {
        return new ResourceLocation("techifiedores", "item/material_sets/base_" + form);
    }

    public ResourceLocation getOverlayTexture() {
        return new ResourceLocation("techifiedores", "item/material_sets/overlay_" + form);
    }
}
