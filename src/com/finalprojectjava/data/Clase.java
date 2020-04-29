package com.finalprojectjava.data;

import java.util.ArrayList;
import java.util.List;

public class Clase {

    private String name;
    private int assignedClassRoom;
    private List<Student> students;
    private Teacher teacher;

    public Clase(String name, int assignedClassRoom, List<Student> students, Teacher teacher) {
        this.name = name;
        this.assignedClassRoom = assignedClassRoom;
        this.students = students;
        this.teacher = teacher;
    }

    public Clase(String name, int assignedClassRoom, Teacher teacher) {
        this.name = name;
        this.assignedClassRoom = assignedClassRoom;
        this.students = new ArrayList<>();
        this.teacher = teacher;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAssignedClassRoom() {
        return assignedClassRoom;
    }

    public void setAssignedClassRoom(int assignedClassRoom) {
        this.assignedClassRoom = assignedClassRoom;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Class Name: " + name +
                " Assigned ClassRoom: " + assignedClassRoom +
                " Teacher: " + teacher +
                " Students: " + students;
    }

}
