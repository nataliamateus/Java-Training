package com.organization.java.data;

public class PartTimeTeacher extends Teacher {

    private int hoursPerWeek=0;

    public PartTimeTeacher(String name, double baseSalary, int id, int hoursPerWeek) {
        super(name, baseSalary, id);
        this.hoursPerWeek = hoursPerWeek;
    }

    public int getHoursPerWeek() {
        return hoursPerWeek;
    }

    public void setHoursPerWeek(int hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
    }

    @Override
    public double calculatedSalary() {
        double calculatedSalary = 0;
        calculatedSalary = getBaseSalary() * getHoursPerWeek();
        int value = (int) calculatedSalary;
        return (calculatedSalary);
    }

    @Override
    public String toString() {
        return  "Name: " + getName() +
                "|| ID: " + getId() +
                "|| Base salary: " + getBaseSalary() +
                "|| Hours Per Week: " + hoursPerWeek +
                "|| Calculated Salary: " + calculatedSalary() + "||" ;
    }


}
