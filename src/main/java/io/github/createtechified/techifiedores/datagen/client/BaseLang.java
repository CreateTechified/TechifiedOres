package io.github.createtechified.techifiedores.datagen.client;

import io.github.createtechified.techifiedores.registry.ModRegistries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.Arrays;
import java.util.stream.Collectors;

import static io.github.createtechified.techifiedores.TechifiedOresMod.MOD_ID;

public class BaseLang extends LanguageProvider {
    public BaseLang(PackOutput output, String locale) {
        super(output, MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        ModRegistries.ITEMS.getEntries().forEach(entry -> {
            add(entry.get(), toDisplayName(entry.getId().getPath()));
        });

        add("itemGroup.techifiedores.creativeTab", "TechifiedOres");
    }

    private static String toDisplayName(String name) {
        return Arrays.stream(name.split("_"))
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .collect(Collectors.joining(" "));
    }
}
