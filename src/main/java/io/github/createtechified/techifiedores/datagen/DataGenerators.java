package io.github.createtechified.techifiedores.datagen;

import io.github.createtechified.techifiedores.datagen.client.BaseLang;
import io.github.createtechified.techifiedores.datagen.client.BlockStates;
import io.github.createtechified.techifiedores.datagen.client.ItemModels;
import io.github.createtechified.techifiedores.datagen.server.BlockLoot;
import io.github.createtechified.techifiedores.datagen.server.BlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static io.github.createtechified.techifiedores.TechifiedOresMod.MOD_ID;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = MOD_ID)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        PackOutput out = gen.getPackOutput();
        ExistingFileHelper efh = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookup = event.getLookupProvider();

        if (event.includeClient()) {
            gen.addProvider(true, new BaseLang(out, "en_us"));
            gen.addProvider(true, new BlockStates(out, efh));
            gen.addProvider(true, new ItemModels(out, efh));
        }

        if (event.includeServer()) {
            gen.addProvider(true, new BlockTags(out, lookup, efh));
            gen.addProvider(true, ModLootTableProvider.create(out));
        }
    }

    private static final List<String> FORMS = List.of(
            "raw_ore_block", "nether_ore", "end_ore", "raw_ore",
            "long_rod", "ingot", "nugget", "gem", "dust",
            "gear", "rod", "plate", "block", "ore"
    );

    public static String getForm(String name) {
        for (String form : FORMS) {
            if (name.endsWith("_" + form)) {
                return form;
            }
        }
        return "item"; // just in case plus it breaks if this doesnt exist
    }

    public static String getMaterial(String name, String form) {
        if (name.endsWith("_" + form)) {
            return name.substring(0, name.length() - form.length() - 1);
        }
        return name; // eeep :P
    }
}
