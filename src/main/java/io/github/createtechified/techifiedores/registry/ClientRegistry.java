package io.github.createtechified.techifiedores.registry;

import io.github.createtechified.techifiedores.TechifiedOresMod;
import io.github.createtechified.techifiedores.utils.TintableMaterialBlock;
import io.github.createtechified.techifiedores.utils.TintableMaterialItem;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.BlockItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;

import static io.github.createtechified.techifiedores.TechifiedOresMod.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientRegistry {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            ForgeRegistries.BLOCKS.getValues().stream()
                    .filter(b -> MOD_ID.equals(ForgeRegistries.BLOCKS.getKey(b).getNamespace()))
                    .forEach(b -> ItemBlockRenderTypes.setRenderLayer(b, RenderType.cutout()));
        });
    }

    @SubscribeEvent
    public static void registerBlockColors(RegisterColorHandlersEvent.Block event) {
        ForgeRegistries.BLOCKS.getValues().stream().filter(b -> MOD_ID.equals(ForgeRegistries.BLOCKS.getKey(b).getNamespace())).forEach(block -> {
            if (block instanceof TintableMaterialBlock tb) {
                event.register((state, world, pos, tintIndex) -> tintIndex == 0 ? tb.getMaterial().color() : 0xFFFFFFFF, block);
            }
        });
    }

    @SubscribeEvent
    public static void registerItemColors(RegisterColorHandlersEvent.Item event) {
        ForgeRegistries.ITEMS.getValues().stream().filter(b -> MOD_ID.equals(ForgeRegistries.ITEMS.getKey(b).getNamespace())).forEach(item -> {
            if (item instanceof TintableMaterialItem ti) {
                event.register((stack, index) ->
                                index == 0 ? ti.getMaterial().color() : 0xFFFFFFFF,
                        item
                );
            } else if (item instanceof BlockItem bi && bi.getBlock() instanceof TintableMaterialBlock tb) {
                event.register((stack, index) ->
                                index == 0 ? tb.getMaterial().color() : 0xFFFFFFFF,
                        item
                );
            }
        });
    }
}
