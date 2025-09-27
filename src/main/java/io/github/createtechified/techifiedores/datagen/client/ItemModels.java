package io.github.createtechified.techifiedores.datagen.client;

import io.github.createtechified.techifiedores.registry.ModRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.BlockItem;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import static io.github.createtechified.techifiedores.TechifiedOresMod.MOD_ID;
import static io.github.createtechified.techifiedores.datagen.DataGenerators.getForm;

public class ItemModels extends ItemModelProvider {
    public ItemModels(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        ModRegistries.ITEMS.getEntries().forEach(entry -> {
            if (!(entry.get() instanceof BlockItem)) {
                String name = entry.getId().getPath();
                String form = getForm(name);

                ItemModelBuilder builder = withExistingParent(name, "item/generated");
                builder.texture("layer0", modLoc("item/material_sets/base/" + form));
                builder.texture("layer1", modLoc("item/material_sets/secondary/" + form));
                builder.texture("layer2", modLoc("item/material_sets/overlay/" + form));
            }
        });
    }
}
