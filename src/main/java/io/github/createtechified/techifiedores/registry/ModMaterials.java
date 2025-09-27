package io.github.createtechified.techifiedores.registry;

import io.github.createtechified.techifiedores.utils.MaterialDef;

import java.util.List;

public class ModMaterials {
    public static final List<MaterialDef> MATERIALS = List.of(
            // FORMAT FOR MID: String name, 0xHEX color, int harvestlevel. HARVEST LEVEL 0 is WOOD OR GOLD, 1 is STONE, 2 is IRON, 3 IS DIAMOND.
            MaterialDef.of("zinc", 0xC2E6D5, 1).noGemstone().noNetherOre().noEndOre(),
            MaterialDef.of("uranium", 0x9FFF85, 1).noGemstone().noNetherOre().noEndOre()
    );
}
