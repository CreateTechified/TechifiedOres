package io.github.createtechified.techifiedores.utils;

public class MaterialDef {
    private final String name;
    private final int color;

    private boolean hasIngot;
    private boolean hasNugget;
    private boolean hasOverworldOre;
    private boolean hasNetherOre;
    private boolean hasEndOre;
    private boolean hasRawOre;
    private boolean hasRawOreBlock;
    private boolean hasBlock;
    private boolean hasGemstone;
    private boolean hasDust;
    private boolean hasGear;
    private boolean hasRod;
    private boolean hasPlate;
    private boolean hasLongRod;

    private MaterialDef(String name, int color) {
        this.name = name;
        this.color = color;
    }

    public static MaterialDef of(String name, int color) {
        return new MaterialDef(name, color);
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

    public MaterialDef mainlinetesting() {
        this.hasIngot = true;
        this.hasBlock = true;
        this.hasOverworldOre = true;
        this.hasDust = true;
        return this;
    }

    // Getters
    public String name() { return name; }
    public int color() { return color; }
    public boolean hasIngot() { return hasIngot; }
    public boolean hasNugget() { return hasNugget; }
    public boolean hasOverworldOre() { return hasOverworldOre; }
    public boolean hasNetherOre() { return hasNetherOre; }
    public boolean hasEndOre() { return hasEndOre; }
    public boolean hasRawOre() { return hasRawOre; }
    public boolean hasRawOreBlock() { return hasRawOreBlock; }
    public boolean hasBlock() { return hasBlock; }
    public boolean hasGemstone() { return hasGemstone; }
    public boolean hasDust() { return hasDust; }
    public boolean hasGear() { return hasGear; }
    public boolean hasRod() { return hasRod; }
    public boolean hasPlate() { return hasPlate; }
    public boolean hasLongRod() { return hasLongRod; }
}
