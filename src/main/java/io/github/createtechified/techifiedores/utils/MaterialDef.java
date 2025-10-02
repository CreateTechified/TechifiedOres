package io.github.createtechified.techifiedores.utils;

public class MaterialDef {

    private final String name;
    private final int color;
    private int harvestLevel = 0; //0-wood/gold 1-stone 2-iron 3-diamond
    private String materialSet;

    private boolean hasIngot = true;
    private boolean hasNugget = true;
    private boolean hasOverworldOre = true;
    private boolean hasNetherOre = true;
    private boolean hasEndOre = true;
    private boolean hasRawOre = true;
    private boolean hasRawOreBlock = true;
    private boolean hasBlock = true;
    private boolean hasGemstone = true;
    private boolean hasDust = true;
    private boolean hasGear = true;
    private boolean hasRod = true;
    private boolean hasPlate = true;
    private boolean hasLongRod = true;

    private MaterialDef(
        String name,
        int color,
        int harvestLevel,
        String materialSet
    ) {
        this.name = name;
        this.color = color;
        this.harvestLevel = harvestLevel;
        this.materialSet = materialSet;
    }

    public static MaterialDef of(
        String name,
        int color,
        int harvestLevel,
        String materialSet
    ) {
        return new MaterialDef(name, color, harvestLevel, materialSet);
    }

    // Toggles!
    public MaterialDef noIngot() {
        this.hasIngot = false;
        return this;
    }

    public MaterialDef noNugget() {
        this.hasNugget = false;
        return this;
    }

    public MaterialDef noOverworldOre() {
        this.hasOverworldOre = false;
        return this;
    }

    public MaterialDef noNetherOre() {
        this.hasNetherOre = false;
        return this;
    }

    public MaterialDef noEndOre() {
        this.hasEndOre = false;
        return this;
    }

    public MaterialDef noRawOre() {
        this.hasRawOre = false;
        return this;
    }

    public MaterialDef noRawOreBlock() {
        this.hasRawOreBlock = false;
        return this;
    }

    public MaterialDef noBlock() {
        this.hasBlock = false;
        return this;
    }

    public MaterialDef noGemstone() {
        this.hasGemstone = false;
        return this;
    }

    public MaterialDef noDust() {
        this.hasDust = false;
        return this;
    }

    public MaterialDef noGear() {
        this.hasGear = false;
        return this;
    }

    public MaterialDef noRod() {
        this.hasRod = false;
        return this;
    }

    public MaterialDef noPlate() {
        this.hasPlate = false;
        return this;
    }

    public MaterialDef noLongRod() {
        this.hasLongRod = false;
        return this;
    }

    // Getters
    public String name() {
        return name;
    }

    public int color() {
        return color;
    }

    public int harvestLevel() {
        return harvestLevel;
    }

    public String materialSet() {
        return materialSet;
    }

    public boolean hasIngot() {
        return hasIngot;
    }

    public boolean hasNugget() {
        return hasNugget;
    }

    public boolean hasOverworldOre() {
        return hasOverworldOre;
    }

    public boolean hasNetherOre() {
        return hasNetherOre;
    }

    public boolean hasEndOre() {
        return hasEndOre;
    }

    public boolean hasRawOre() {
        return hasRawOre;
    }

    public boolean hasRawOreBlock() {
        return hasRawOreBlock;
    }

    public boolean hasBlock() {
        return hasBlock;
    }

    public boolean hasGemstone() {
        return hasGemstone;
    }

    public boolean hasDust() {
        return hasDust;
    }

    public boolean hasGear() {
        return hasGear;
    }

    public boolean hasRod() {
        return hasRod;
    }

    public boolean hasPlate() {
        return hasPlate;
    }

    public boolean hasLongRod() {
        return hasLongRod;
    }
}
