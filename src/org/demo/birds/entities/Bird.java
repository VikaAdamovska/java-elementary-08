package org.demo.birds.entities;

public class Bird {

    private String name;
    private String livingArea;
    private double size;

    public Bird(String name, String livingArea, double size) {
        this.name = name;
        this.livingArea = livingArea;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public String getLivingArea() {
        return livingArea;
    }

    public double getSize() {
        return size;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLivingArea(String livingArea) {
        this.livingArea = livingArea;
    }

    public void setSize(double size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Bird{" +
                "name='" + name + '\'' +
                ", livingArea='" + livingArea + '\'' +
                ", size=" + size +
                '}';
    }
}
