package main;

import com.finalprojectjava.data.Clase;
import com.finalprojectjava.data.Student;
import com.finalprojectjava.data.Teacher;
import com.finalprojectjava.data.management.Management;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class University {
    public static Management management = new Management();

    public static void main(String[] args) {

        int option = 1;
        int assignedClass = 1;
        int assignedTeacher = 1;
        int studentListFlag=1;
        int studentIDFlag=1;
        String anotherStudent="Y";

        System.out.println("*************************************************************************************************");
        System.out.println("                                          UNIVERSITY                                             ");
        System.out.println("*************************************************************************************************");

        while (option > 0) {
            String answer = "Y";
            System.out.println("-------------------------------------------------------------------------------------------------");
            System.out.println("Please select one option"
                    + "\n1.Professor Information"
                    + "\n2.Class Information"
                    + "\n3.Create new Student and add it to and existing class"
                    + "\n4.Create new class and add a teacher and students"
                    + "\n5.List all classes where a student is included"
                    + "\n6.Exit");
            System.out.println("-------------------------------------------------------------------------------------------------");

            Scanner read = new Scanner(System.in);
            option = read.nextInt();


            switch (option) {
                case 1://Professor List
                    System.out.println("******************************  PROFESSOR LIST **************************************************");
                    System.out.println(".................................................................................................");
                    management.getTeachers().forEach(teacher -> System.out.println(teacher.toString()));

                    break;

                case 2://Classes list
                    System.out.println("*********************************  CLASS LIST  **************************************************");
                    System.out.println(".................................................................................................");
                    management.getClase().forEach(clase ->
                            System.out.println("Class name: " + clase.getName() + " ||Assigned Class room: " + clase.getAssignedClassRoom() + "||"));

                    while (answer == "Y") {
                        int subMenu = 1;
                        System.out.println(".................................................................................................");
                        System.out.println("Please select one option"
                                + "\n1.Information about Teacher and Students List"
                                + "\n2.Cancel");

                            while (subMenu > 0) {
                                Scanner optionFlag = new Scanner(System.in);
                                int selectedOption = optionFlag.nextInt();

                                switch (selectedOption) {
                                    case 1:
                                        System.out.println("Enter the class name:");
                                        Scanner classFlag = new Scanner(System.in);
                                        String className = classFlag.nextLine();

                                        boolean existClass = getExistClass(className);
                                        System.out.println(".................................................................................................");

                                            if (existClass) {
                                                getInformationRelatedWithTheSelectedClass(className);
                                                subMenu = 0;
                                            } else {
                                                System.out.println("Sorry...that class doesn't exist");
                                                subMenu=0;
                                            }
                                        break;

                                    case 2:
                                        subMenu = 0;
                                        answer = "N";
                                        break;

                                    default:
                                        System.out.println("Sorry...Incorrect Option!");
                                        subMenu = 0;
                                }
                            }
                        }

                    break;

                case 3://Create new Student and add it to and existing class
                    assignedClass=1;
                    System.out.println("*********************************  NEW STUDENT  *************************************************");
                    System.out.println(".................................................................................................");
                    System.out.println("Enter the name:");
                    Scanner nameFlag = new Scanner(System.in);
                    String nameStudent = nameFlag.nextLine();
                    int ageValidation = 1;

                    while (ageValidation==1) {

                        System.out.println("Enter the age: (Only numbers)");
                        Scanner ageFlag = new Scanner(System.in);
                        int ageStudent = ageFlag.nextInt();

                        if (ageStudent <= 0) {
                            System.out.println("The age should be greater than zero");
                            ageValidation=1;
                        }

                        else
                        {
                            while (studentIDFlag>0) {
                                System.out.println("Enter ID #: (Only numbers)");
                                Scanner idFlag = new Scanner(System.in);
                                int idStudent = idFlag.nextInt();

                                if (getIfTheStudentIdExist(idStudent)) {
                                    System.out.println("Sorry...That ID is already taken");
                                    studentIDFlag=1;
                                }
                                else {

                                    Student student = new Student(nameStudent, ageStudent, idStudent);
                                    System.out.println(".................................................................................................");
                                    System.out.println("New Student:");
                                    management.getStudents().add(student);
                                    System.out.println(student);
                                    System.out.println(".................................................................................................");
                                    System.out.println("CLASS LIST");
                                    System.out.println(".................................................................................................");
                                    management.getClase().forEach(clase->
                                            System.out.println("Class name: " + clase.getName() + " ||Assigned Class room: " + clase.getAssignedClassRoom() + "||"));
                                    System.out.println(".................................................................................................");

                                    while (assignedClass > 0) {

                                        System.out.println("Please enter the CLASS NAME to include the new student:");
                                        Scanner classFlag = new Scanner(System.in);
                                        String className = classFlag.nextLine();

                                        if (getExistClass(className)) {
                                            assignedNewStudentToOneClass(className, student);
                                            getInformationRelatedWithTheSelectedClass(className);
                                            assignedClass = 0;
                                        } else {
                                            System.out.println("Sorry...That class doesn't exist");
                                            assignedClass = 1;
                                        }
                                    }//while

                                    studentIDFlag=0;
                                    ageValidation=0;

                                }//else
                            }
                        }
                    }

                    break;

                case 4://New Class
                    anotherStudent="Y";
                    System.out.println("*********************************** NEW CLASS ***************************************************");
                    System.out.println(".................................................................................................");
                    System.out.println("Enter the class name:");
                    Scanner classFlag = new Scanner(System.in);
                    String nameClass = classFlag.nextLine();


                    System.out.println("Enter the assigned classroom:");
                    Scanner roomFlag = new Scanner(System.in);
                    int assignedRoom = roomFlag.nextInt();

                    if(getExistClass(nameClass))
                    {
                        System.out.println("Sorry...That class already exist!");
                    }

                    else{
                        System.out.println("Please select one teacher from List");
                        management.getTeachers().forEach(teacher -> System.out.println(teacher.toString()));
                        System.out.println(".................................................................................................");

                            while (assignedTeacher>0) {
                                System.out.println("Enter the teacher ID:");
                                Scanner teacherFlag = new Scanner(System.in);
                                int teacherID = teacherFlag.nextInt();

                                if (getExistTeacher(teacherID)) {
                                    Teacher teacher = (addTeacher(teacherID));

                                    List<Student> claseStudent = new ArrayList();

                                    Clase clase = new Clase(nameClass, assignedRoom,claseStudent, teacher);
                                    management.getClase().add(clase);

                                    System.out.println(".................................................................................................");
                                    System.out.println("STUDENT LIST");
                                    management.getStudents().forEach(student -> System.out.println(student.toString()));


                                    while (anotherStudent=="Y"){
                                        System.out.println(".................................................................................................");
                                        System.out.println("Enter the Student ID to include to the new class:");
                                        Scanner studentFlag = new Scanner(System.in);
                                        int studentIdIncluded = studentFlag.nextInt();

                                        if (getIdStudentExist(studentIdIncluded)) {
                                            System.out.println("Student add to " + clase.getName() + " class");
                                            getStudentToIncludeANewClass(clase, studentIdIncluded);


                                            System.out.println(".................................................................................................");
                                            System.out.println("New Class:");
                                            getInformationRelatedWithTheSelectedClass(nameClass);

                                            System.out.println(".................................................................................................");
                                            System.out.println("Do you want to include another student? Y/N");
                                            Scanner anotherStudentFlag = new Scanner(System.in);
                                            anotherStudent = anotherStudentFlag.nextLine();

                                                if (anotherStudent.equals("Y")) {
                                                    System.out.println(".................................................................................................");
                                                    System.out.println("STUDENT LIST");
                                                    getStudentListUpdated(studentIdIncluded,nameClass);
                                                    anotherStudent="Y"; }
                                                else { assignedTeacher = 0; anotherStudent="N"; }

                                        } else { System.out.println("Sorry...that student id No. " + studentIdIncluded + " doesn't exist"); }
                                  }//Another Student While

                                }
                                else {
                                    System.out.println("** That teacher doesn't exist **");
                                    System.out.println(".................................................................................................");
                                    assignedTeacher=1;
                                }
                            }

                    }
                    break;

                case 5://List all the classes in which a given student is included
                    studentListFlag=1;
                    System.out.println("STUDENTS LIST");
                    System.out.println(".................................................................................................");
                    for (Student studentList: management.getStudents()) {
                        System.out.println(studentList);
                    }

                    while(studentListFlag>0){
                        System.out.println(".................................................................................................");
                        System.out.println("Enter the student ID:");
                        Scanner studentFlag = new Scanner(System.in);
                        int idStudentFlag = studentFlag.nextInt();


                        if(getIdStudentExist(idStudentFlag))
                        {
                            System.out.println(".................................................................................................");
                            System.out.println("List all the classes in which the student is included:");

                            getClassListWhereAStudentBelong(idStudentFlag);
                            studentListFlag=0;
                        }
                        else {
                                 System.out.println("Sorry...That student ID doesn't exist");
                                 studentListFlag=1;
                        }

                    }
                    break;

                case 6://Exit
                    option=0;
                    System.out.println("See you soon!");
                    break;

                default:
                    System.out.println("Sorry...Incorrect Option!");
            }
        }//Main While
    }

    //Validate if the class exist
    public static boolean getExistClass(String className) {
        boolean existClass = false;
        for ( Clase clase :  management.getClase()) {
            if(clase.getName().equals(className)) {
                existClass=true;
            }
        }
        return existClass;
    }

    public static void getInformationRelatedWithTheSelectedClass (String className) {

        for ( Clase clase :  management.getClase()) {
            if(clase.getName().equals(className)) {
                System.out.println("Class Name:" + clase.getName() + " ||Assigned Class Room:" + clase.getAssignedClassRoom() + "||");
                System.out.println(".................................................................................................");
                System.out.println("Assigned Teacher:");
                System.out.println(clase.getTeacher().toString());
                System.out.println(".................................................................................................");
                System.out.println("Students List");
                for (Student student: clase.getStudents()) {
                    System.out.println(student);
                }
            }
        }
    }

    //Validate if the Student ID already exist
    public static boolean getIfTheStudentIdExist (int studentId) {
        boolean studentExist=false;

        for ( Student student :  management.getStudents()) {
            if(student.getId()==(studentId)) {
                studentExist=true;
            }
        }

        return studentExist;
    }

    //Assigned a new Student to a class
    public static void assignedNewStudentToOneClass(String className, Student student) {

        for ( Clase clase :  management.getClase()) {
            if(clase.getName().equals(className)) {
                clase.getStudents().add(student);
                System.out.println(".................................................................................................");
            }
        }
    }

    //Validate if the teacher exists
    public static boolean getExistTeacher(int teacherID) {
        boolean existTeacher = false;
        for ( Teacher teacher :  management.getTeachers()) {
            if(teacher.getId()==(teacherID)) {
                existTeacher=true;
            }
        }
        return existTeacher;
    }

    //Add a teacher to a new class
    public static Teacher addTeacher(int teacherId) {
        Teacher teacher = null;
        for ( Teacher teachers :  management.getTeachers()) {
            if(teachers.getId()==(teacherId)) {
                teacher= teachers;
                System.out.println(teacher.getName());
            }
        }
        return teacher;
    }

    public static boolean getIdStudentExist(int idStudent) {
        boolean studentBelong=false;

        for ( Student studentClass:  management.getStudents()) {
            if(studentClass.getId()==(idStudent)) {
                studentBelong= true;
            }
        }
        return studentBelong;
    }

    public static void getClassListWhereAStudentBelong (int idStudent) {
        for (Clase clase : management.getClase())
        {
            for (Student student : clase.getStudents()) {
                if (student.getId() == idStudent) {
                    System.out.println("Class Name: " + clase.getName() + " Assigned ClassRoom: " + clase.getAssignedClassRoom());
                }
            }
        }
    }


    public static void getStudentToIncludeANewClass (Clase clase, int studentIdIncluded) {
        for (Clase newClass : management.getClase()) {

            if (newClass.getName().equals(clase.getName())) {
                for (Student student : management.getStudents()) {
                    if (student.getId() == studentIdIncluded) {
                        newClass.getStudents().add(student);
                        System.out.println(newClass.getStudents());
                    }
                }
            }
        }
    }

    public static void getStudentListUpdated (int studentIdIncluded, String className)
    {
        int countList=0;
        for (Clase clase: management.getClase())
        {
            if(clase.getName()==className) {
                for (Student studentClass: clase.getStudents()) {
                    for (Student students : management.getStudents()) {

                        if (students.getId() == studentClass.getId()) {
                           countList++;
                        }

                        else
                        {
                            if(clase.getStudents().size() == countList) {
                                System.out.println(students);
                            }
                        }

                    }
                }
            }
        }
    }

}



