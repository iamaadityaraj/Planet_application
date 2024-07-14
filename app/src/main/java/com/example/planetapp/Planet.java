package com.example.planetapp;

public class Planet {
    private String PlanetName;
    private String MoonCount;
    private int PlanetImage;

    public Planet(String planetName, String moonCount, int planetImage) {
        PlanetName = planetName;
        MoonCount = moonCount;
        PlanetImage = planetImage;
    }

    public String getPlanetName() {
        return PlanetName;
    }

    public void setPlanetName(String planetName) {
        PlanetName = planetName;
    }

    public String getMoonCount() {
        return MoonCount;
    }

    public void setMoonCount(String moonCount) {
        MoonCount = moonCount;
    }

    public int getPlanetImage() {
        return PlanetImage;
    }

    public void setPlanetImage(int planetImage) {
        PlanetImage = planetImage;
    }
}
