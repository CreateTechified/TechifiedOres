package io.github.createtechified.techifiedores.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static io.github.createtechified.techifiedores.TechifiedOresMod.MOD_ID;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);
    public static final RegistryObject<CreativeModeTab> TECHIFIEDORES = CREATIVE_TABS.register("techifiedores", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.techifiedores.creativeTab"))
            .icon(() -> new ItemStack(Items.DIAMOND_ORE))
            .displayItems(((itemDisplayParameters, output) -> {
                ModRegistries.ITEMS.getEntries().forEach(item -> output.accept(item.get()));
                ModRegistries.BLOCKS.getEntries().forEach(block -> output.accept(block.get().asItem()));
            }))
            .build());
}
