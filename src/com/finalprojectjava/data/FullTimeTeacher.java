package com.finalprojectjava.data;


import java.util.List;

public class FullTimeTeacher extends Teacher{

    private int experienceYears = 0;

    public FullTimeTeacher(String name, double baseSalary, int id, int experienceYears) {
        super(name, baseSalary, id);
        this.experienceYears=experienceYears;
    }


    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    @Override
    public double calculatedSalary() {
        double calculatedSalary = 0;
        calculatedSalary = getBaseSalary() * 1.1 * getExperienceYears();
        return (calculatedSalary);
    }

    @Override
    public String toString() {
        return  "Name: " + getName() +
                "||ID: " + getId() +
                "|| Base salary: " + getBaseSalary() +
                "|| Experience Years: " + experienceYears  +
                "|| Calculated Salary: " + calculatedSalary()+ "||" ;

    }
}
