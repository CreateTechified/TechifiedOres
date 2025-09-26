package io.github.createtechified.techifiedores;

import io.github.createtechified.techifiedores.registry.ModCreativeTabs;
import io.github.createtechified.techifiedores.registry.ModMaterials;
import io.github.createtechified.techifiedores.registry.ModRegistries;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(TechifiedOresMod.MOD_ID)
public class TechifiedOresMod {
    public static final String MOD_ID = "techifiedores";
    public static final Logger LOGGER = LogManager.getLogger();
    public TechifiedOresMod() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();

        System.out.println("Materials: " + ModMaterials.MATERIALS.size());
        ModRegistries.register(modBus);
        ModCreativeTabs.CREATIVE_TABS.register(modBus);
        // Stuff will go here, eventually...
    }
}
