package com.organization.java.data;

import java.util.List;

public class Clase {

    private String name;
    private int classId;
    private int assignedClassRoom;
    private List<Student> students;
    private Teacher teacher;

    public Clase(String name, int classId, int assignedClassRoom, List<Student> students, Teacher teacher) {
        this.name = name;
        this.classId = classId;
        this.assignedClassRoom = assignedClassRoom;
        this.students = students;
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
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
                "ID: " + classId +
                " Assigned ClassRoom: " + assignedClassRoom +
                " Teacher: " + teacher +
                " Students: " + students;
    }

}
