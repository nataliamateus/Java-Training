package com.organization.java.data;

import java.util.List;

public abstract class Teacher {

    private String name;
    private double baseSalary;
    private int id;

    public Teacher(String name, double baseSalary, int id) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Teacher: " + name + " ID: " + id + " BaseSalary: " + baseSalary;
    }

    public abstract double calculatedSalary();

}
