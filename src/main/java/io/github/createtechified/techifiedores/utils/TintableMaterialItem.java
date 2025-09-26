package io.github.createtechified.techifiedores.utils;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class TintableMaterialItem extends Item {
    private final MaterialDef material;
    private final String form;

    public TintableMaterialItem(MaterialDef material, String form, Properties props) {
        super(props);
        this.material = material;
        this.form = form;
    }

    public MaterialDef getMaterial() {
        return material;
    }

    public ResourceLocation getBaseTexture() {
        return new ResourceLocation("techifiedores", "item/material_sets/base_" + form);
    }

    public ResourceLocation getOverlayTexture() {
        return new ResourceLocation("techifiedores", "item/material_sets/overlay_" + form);
    }
}
