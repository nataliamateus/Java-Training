package com.finalprojectjava.data.management;

import com.finalprojectjava.data.Clase;

import com.finalprojectjava.data.Student;
import com.finalprojectjava.data.Teacher;

import java.util.List;

import static utils.IntElements.*;

public class Management {

    private List<Teacher> teachers;
    private List<Student> students;
    private List<Clase> clase;

        public Management() {
            this.teachers = intTeacherList();
            this.students= intStudentList();
            this.clase= intClassesList();
        }

    public List<Teacher> getTeachers() {
            return teachers;
        }

    public void setTeachers(List<Teacher> teachers) {
            this.teachers = teachers;
        }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) { this.students = students; }

    public List<Clase> getClase() {
        return clase;
    }

    public void setClase(List<Clase> clase) {
        this.clase = clase;
    }
}
