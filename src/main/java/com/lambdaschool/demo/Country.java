package com.lambdaschool.demo;

public class Country {
    private String name;
    private  long population;
    private long landMassSize;
    private int medianAge;

    // Constructor
    public Country(String name, long population, long landMassSize, int medianAge) {
        this.name = name;
        this.population = population;
        this.landMassSize = landMassSize;
        this.medianAge = medianAge;
    }

    // Getter and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public long getLandMassSize() {
        return landMassSize;
    }

    public void setLandMassSize(long landMassSize) {
        this.landMassSize = landMassSize;
    }

    public int getMedianAge() {
        return medianAge;
    }

    public void setMedianAge(int medianAge) {
        this.medianAge = medianAge;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", population=" + population +
                ", landMassSize=" + landMassSize +
                ", medianAge=" + medianAge +
                '}';
    }
}

//* Create an array list for country objects
//        * Each country object will contain
//        * a country name, population, land mass size, and median age
//        * should contain the standard getter and setters
