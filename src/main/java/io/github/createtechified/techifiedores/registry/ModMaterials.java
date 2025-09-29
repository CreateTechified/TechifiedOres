package io.github.createtechified.techifiedores.registry;

import io.github.createtechified.techifiedores.utils.MaterialDef;

import java.util.List;

public class ModMaterials {
    public static final List<MaterialDef> MATERIALS = List.of(
            // FORMAT FOR MID: String name, 0xHEX color, int harvestlevel. HARVEST LEVEL 0 is WOOD OR GOLD, 1 is STONE, 2 is IRON, 3 IS DIAMOND.
            MaterialDef.of("zinc", 0xC2E6D5, 1).noGemstone().noNetherOre().noEndOre(),
            MaterialDef.of("uranium", 0x9FFF85, 1).noGemstone().noNetherOre().noEndOre(),
            MaterialDef.of("tin", 0x3795A8, 1).noGemstone().noNetherOre().noEndOre(),
            MaterialDef.of("steel", 0x7D7D7D, 1).noGemstone().noOverworldOre().noNetherOre().noEndOre().noRawOre().noRawOreBlock(),
            MaterialDef.of("silver", 0xE0E5FF, 1).noGemstone().noNetherOre().noEndOre(),
            MaterialDef.of("platinum", 0xB8E8FF, 1).noGemstone().noOverworldOre().noNetherOre().noEndOre().noRawOre().noRawOreBlock(),
            MaterialDef.of("osmium", 0x889EC3, 1).noGemstone().noNetherOre().noEndOre(),
            MaterialDef.of("nickel", 0xFFFFBD, 1).noGemstone().noNetherOre().noEndOre(),
            MaterialDef.of("lead", 0x686CB6, 1).noGemstone().noNetherOre().noEndOre(),
            MaterialDef.of("graphite", 0x41424C, 1).noGemstone().noIngot().noNugget().noNetherOre().noEndOre(),
            MaterialDef.of("electrum", 0xFFFF85, 1).noGemstone().noOverworldOre().noNetherOre().noEndOre().noRawOre().noRawOreBlock(),
            MaterialDef.of("constantan", 0xFFC266, 1).noGemstone().noOverworldOre().noNetherOre().noEndOre().noRawOre().noRawOreBlock(),
            MaterialDef.of("bronze", 0x875C00, 1).noGemstone().noOverworldOre().noNetherOre().noEndOre().noRawOre().noRawOreBlock(),
            MaterialDef.of("brass", 0xFFBF1F, 1).noGemstone().noOverworldOre().noNetherOre().noEndOre().noRawOre().noRawOreBlock(),
            MaterialDef.of("aluminum", 0xB3E0FF, 1).noGemstone().noNetherOre().noEndOre()
    );
}
