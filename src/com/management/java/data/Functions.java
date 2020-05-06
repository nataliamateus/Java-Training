package com.management.java.data;
import com.organization.java.data.Clase;
import com.organization.java.data.Student;
import com.organization.java.data.Teacher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Functions {

    public static Management management = new Management();
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // MAIN MENU METHODS
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Option [2] All information about the the class
    public static void getClassList(){
        String answer="Y" ;
        management.getClase().forEach(clase ->
                System.out.println("Class ID: " + clase.getClassId() +" ||Class name: " + clase.getName() +" ||Assigned Class room: " + clase.getAssignedClassRoom() + "||"));

        while (answer == "Y") {
            int subMenu = 1;
            System.out.println(".................................................................................................");
            System.out.println("Please select one option"
                    + "\n[1]Information about Teacher and Students List"
                    + "\n[2]Cancel");

            while (subMenu > 0) {
                Scanner optionFlag = new Scanner(System.in);
                String selectedOption = optionFlag.nextLine();

                switch (selectedOption) {
                    case "1":
                        System.out.println("Enter the class ID from the list: (Only numbers)");
                        Scanner classIdFlag = new Scanner(System.in);
                        int classId = classIdFlag.nextInt();

                        boolean existClass = getExistClassId(classId);
                        System.out.println("........................................................................................................");

                        if (existClass) {
                            getInformationRelatedWithTheSelectedClass(classId);
                            subMenu = 0;
                        } else {
                            System.out.println("Sorry...that class doesn't exist");
                            subMenu = 0;
                        }
                        break;

                    case "2":
                        subMenu = 0;
                        answer = "N";
                        break;

                    default:
                        System.out.println("Sorry...Incorrect Option!");
                        subMenu = 0;
                }
            }
        }

    }

    //Option [3] Create new Student and add it to and existing class
    public static void createNewStudent() {
        int assignedClass = 1;
        int ageValidation = 1;
        int studentIDFlag = 1;
        int ageStudent = 1;
        int idStudent = 0;

        System.out.println("Enter the full name:");
        Scanner nameFlag = new Scanner(System.in);
        String nameStudent = nameFlag.nextLine();
        while (ageValidation == 1) {
            try {
                System.out.println("Enter the age: (Only numbers)");
                Scanner ageFlag = new Scanner(System.in);
                ageStudent = ageFlag.nextInt();

                if (ageStudent == 0 || ageStudent>99 ) {
                    System.out.println("The age should be greater than 0 and less than 99");
                    System.out.println("........................................................................................................");

                } else {
                    ageValidation = 0;
                }

            } catch (InputMismatchException e) {
                System.out.println("** Please enter a valid value **");
                System.out.println("........................................................................................................");

            }
        }

        while (studentIDFlag > 0) {
            try {
                System.out.println("Enter ID #: (Only numbers)");
                Scanner idFlag = new Scanner(System.in);
                idStudent = idFlag.nextInt();

                if (getIfTheStudentIdExist(idStudent)) {
                    System.out.println("Sorry...That ID is already taken");
                    System.out.println("........................................................................................................");

                } else {
                    studentIDFlag = 0;
                }

            } catch (InputMismatchException e) {
                System.out.println("** Please enter a valid value **");
                System.out.println("........................................................................................................");
            }
        }

        Student student = new Student(nameStudent, ageStudent, idStudent);
        System.out.println("........................................................................................................");
        System.out.println("New Student:");
        management.getStudents().add(student);
        System.out.println(student);
        System.out.println("........................................................................................................");
        System.out.println("CLASS LIST");
        System.out.println("........................................................................................................");
        management.getClase().forEach(clase ->
                System.out.println("Class ID: " + clase.getClassId() + " ||Class name: " + clase.getName() + " ||Assigned Class room: " + clase.getAssignedClassRoom() + "||"));
        System.out.println("........................................................................................................");

        while (assignedClass > 0) {
          try{
            System.out.println("Please enter the CLASS ID to include the new student:");
            Scanner classIdFlag = new Scanner(System.in);
            int classId = classIdFlag.nextInt();
            if (getExistClassId(classId)) {
                assignNewStudentToOneClass(classId, student);
                getInformationRelatedWithTheSelectedClass(classId);
                assignedClass = 0;
            } else {
                System.out.println("Sorry...That class doesn't exist");
                System.out.println("........................................................................................................");
                assignedClass = 1;
            }
          } catch(InputMismatchException e){
              System.out.println("** Please enter a valid value **");
              System.out.println("........................................................................................................");
          }
        }//while
        studentIDFlag = 0; ageValidation = 0;
    }

    //Option [4] Create new Class
    public static void createNewClass() {
        String anotherStudent = "Y";
        anotherStudent.toUpperCase();
        int assignedTeacher = 1;
        int classFlag = 1;
        int classIdValidate = 1;
        Clase clase = null;
        String nameClass = "";
        int classId = 0;
        int assignedRoom = 1;


        while (classFlag > 0) {
            System.out.println("Enter the class name:");
            Scanner classNameFlag = new Scanner(System.in);
            nameClass = classNameFlag.nextLine();

            if (getExistClass(nameClass)) {
                System.out.println("Sorry...That class name already exist!");
                System.out.println("........................................................................................................");
            } else {
                classFlag = 0;
            }
        }

        while (classIdValidate > 0) {
            try {
                System.out.println("Enter the class ID:(Only numbers)");
                Scanner classIdFlag = new Scanner(System.in);
                classId = classIdFlag.nextInt();

                if (getExistClassId(classId)) {
                    System.out.println("Sorry...That class ID already exist!");
                    System.out.println("........................................................................................................");

                } else {
                    classIdValidate = 0;
                }
            } catch (InputMismatchException e) {
                System.out.println("** Please enter a valid value **");
                System.out.println("........................................................................................................");
            }
        }

        while (assignedRoom > 0) {
            try {
                System.out.println("Enter the assigned classroom: (Only numbers)");
                Scanner roomFlag = new Scanner(System.in);
                assignedRoom = roomFlag.nextInt();
                assignedRoom=0;

            } catch (InputMismatchException e) {
                System.out.println("** Please enter a valid value **");
                System.out.println("........................................................................................................");
            }
        }

        while (assignedTeacher > 0){
            System.out.println("Please select one teacher from List:");
            management.getTeachers().forEach(teacher -> System.out.println(teacher.toString()));
            System.out.println("........................................................................................................");
            try {
                System.out.println("Enter the teacher ID:(Only numbers)");
                Scanner teacherFlag = new Scanner(System.in);
                int teacherID = teacherFlag.nextInt();

                if (getExistTeacher(teacherID)) {
                    Teacher teacher = (addTeacher(teacherID));
                    List<Student> claseStudent = new ArrayList();
                    clase = new Clase(nameClass, classId, assignedRoom, claseStudent, teacher);
                    management.getClase().add(clase);
                    assignedTeacher = 0;
                } else {
                    System.out.println("** That teacher doesn't exist **");
                    System.out.println("........................................................................................................");
                }
            }catch(InputMismatchException e){
                System.out.println("** Please enter a valid value **");
                System.out.println("........................................................................................................");
            }

        }


        while (anotherStudent.equals("Y") || anotherStudent.equals("y")) {
            System.out.println("........................................................................................................");
            System.out.println("STUDENT LIST");
            getStudentList(nameClass).forEach(student -> System.out.println(student.toString()));
            try {
                System.out.println("........................................................................................................");
                System.out.println("Enter the Student ID from the list to include to the new class:");
                Scanner studentFlag = new Scanner(System.in);
                int studentIdIncluded = studentFlag.nextInt();

                if (getIdStudentExist(studentIdIncluded)) {

                    if (!idStudentExistInClass(clase, studentIdIncluded)) {
                        System.out.println("........................................................................................................");
                        System.out.println("***Student add to the " + clase.getName() + " class***");
                        addStudentToANewClass(clase, studentIdIncluded);

                        System.out.println("........................................................................................................");
                        System.out.println("**** New Class ****:");
                        getInformationRelatedWithTheSelectedClass(clase.getClassId());

                        System.out.println("........................................................................................................");
                        System.out.println("Do you want to include another student? Y/N");
                        Scanner anotherStudentFlag = new Scanner(System.in);
                        anotherStudent = anotherStudentFlag.nextLine();
                        anotherStudent.toUpperCase();
                    } else {
                        System.out.println("Sorry...that student ID No. " + studentIdIncluded + " is already exist on the list");
                    }
                }
                else {
                    System.out.println("Sorry...that student ID No. " + studentIdIncluded + " doesn't exist");
                }
            }catch (InputMismatchException e){
                System.out.println("** Please enter a valid value **");
            }
        }//Another Student While
    }

    //Option [5] List all the classes in which a given student is included
    public static void listAllStudentsInAClass(){
        int studentListFlag = 1;
        int idStudentFlag=0;
        for (Student studentList : management.getStudents()) {
            System.out.println(studentList);
        }

        while (studentListFlag > 0) {
            try {
                System.out.println("........................................................................................................");
                System.out.println("Enter the student ID from the list:(Only numbers)");
                Scanner studentFlag = new Scanner(System.in);
                idStudentFlag = studentFlag.nextInt();

                if (getIdStudentExist(idStudentFlag)) {
                    System.out.println("........................................................................................................");
                    System.out.println("List all the classes in which the student is included:");
                    getClassListWhereAStudentBelong(idStudentFlag);
                    studentListFlag = 0;
                }
                else{
                    System.out.println("Sorry...That student ID doesn't exist");
                }
            }
            catch (InputMismatchException e){}
            System.out.println("Please enter a valid value");
            System.out.println("........................................................................................................");
        }
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // FUNCTIONAL METHODS
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Validate if the class name exists
    public static boolean getExistClass(String className) {
        boolean existClass = false;
        for (Clase clase : management.getClase()) {
            if (clase.getName().equals(className)) {
                existClass = true;
            }
        }
        return existClass;
    }

    //Validate if the class ID exists
    public static boolean getExistClassId(int classId) {
        boolean existClassId = false;
        for (Clase clase : management.getClase()) {
            if (clase.getClassId()==(classId)) {
                existClassId = true;
            }
        }
        return existClassId;
    }

    //Get all information of the class
    public static void getInformationRelatedWithTheSelectedClass(int classId) {

        for (Clase clase : management.getClase()) {
            if (clase.getClassId()==classId) {
                System.out.println("Class Name:" + clase.getName() + " ||Class ID: "+ clase.getClassId() + " ||Assigned Class Room:" + clase.getAssignedClassRoom() + "||");
                System.out.println("........................................................................................................");
                System.out.println("Assigned Teacher:");
                System.out.println(clase.getTeacher().toString());
                System.out.println("........................................................................................................");
                System.out.println("Students List:");
                for (Student student : clase.getStudents()) {
                    System.out.println(student);
                }
            }
        }
    }

    //Validate if the Student ID already exists
    public static boolean getIfTheStudentIdExist(int studentId) {
        boolean studentExist = false;

        for (Student student : management.getStudents()) {
            if (student.getId() == (studentId)) {
                studentExist = true;
            }
        }

        return studentExist;
    }

    //Assigned a new Student to a class
    public static void assignNewStudentToOneClass(int classId, Student student) {

        for (Clase clase : management.getClase()) {
            if (clase.getClassId()==classId) {
                clase.getStudents().add(student);
                System.out.println("........................................................................................................");
            }
        }
    }

    //Validate if the teacher exists
    public static boolean getExistTeacher(int teacherID) {
        boolean existTeacher = false;
        for (Teacher teacher : management.getTeachers()) {
            if (teacher.getId() == (teacherID)) {
                existTeacher = true;
            }
        }
        return existTeacher;
    }

    //Add a teacher to a new class
    public static Teacher addTeacher(int teacherId) {
        Teacher teacher = null;
        for (Teacher teachers : management.getTeachers()) {
            if (teachers.getId() == (teacherId)) {
                teacher = teachers;
                System.out.println(teacher.getName());
            }
        }
        return teacher;
    }

    //If the Student ID exist
    public static boolean getIdStudentExist(int idStudent) {
        boolean studentBelong = false;

        for (Student studentClass : management.getStudents()) {
            if (studentClass.getId() == (idStudent)) {
                studentBelong = true;
            }
        }
        return studentBelong;
    }

    //Get the Class List where a student belongs to
    public static void getClassListWhereAStudentBelong(int idStudent) {
        for (Clase clase : management.getClase()) {
            for (Student student : clase.getStudents()) {
                if (student.getId() == idStudent) {
                    System.out.println("Class Name: " + clase.getName() + " ||Class ID:" + clase.getClassId() + " ||Assigned ClassRoom: " + clase.getAssignedClassRoom());
                }
            }
        }
    }

    //Add student a new class
    public static void addStudentToANewClass(Clase clase, int studentIdIncluded) {
        for (Clase newClass : management.getClase()) {
            if (newClass.getName().equals(clase.getName())) {
                for (Student student : management.getStudents()) {
                    if (student.getId() == studentIdIncluded) {
                        newClass.getStudents().add(student);
                        System.out.println(student);
                    }
                }
            }
        }
    }

    //Validate if the student exists in the class
    public static boolean idStudentExistInClass(Clase clase, int idStudent) {
        boolean studentBelong = false;

        for (Student studentClass : clase.getStudents()) {
            if (studentClass.getId() == (idStudent)) {
                studentBelong = true;
            }
        }
        return studentBelong;
    }

    //Get the Student List which the selected student doesn't included
    public static List<Student> getStudentList(String className) {
        List<Student> studentList = new ArrayList<>();
        for (Clase clase : management.getClase()) {
            if (clase.getName() == className) {
                for (Student student : management.getStudents()) {
                    boolean validate = idStudentExistInClass(clase, student.getId());
                    if (!validate) {
                        studentList.add(student);
                    }

                }
            }
        }
        return studentList;
    }

}


