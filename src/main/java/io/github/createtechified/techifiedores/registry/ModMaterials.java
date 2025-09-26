package io.github.createtechified.techifiedores.registry;

import io.github.createtechified.techifiedores.utils.MaterialDef;

import java.util.List;

public class ModMaterials {
    public static final List<MaterialDef> MATERIALS = List.of(
            MaterialDef.of("zinc", 0xC2E6D5).noGemstone().noNetherOre().noEndOre(),
            MaterialDef.of("uranium", 0x9FFF85).noGemstone().noNetherOre().noEndOre()
    );
}
