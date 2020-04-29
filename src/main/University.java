package main;

import com.management.java.data.Functions;
import com.organization.java.data.Clase;
import com.organization.java.data.Student;
import com.organization.java.data.Teacher;
import com.management.java.data.Management;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class University {
    public static Management management = new Management();
    public static Functions functions = new Functions();

    public static void main(String[] args) {

        String option = "1";

        System.out.println("********************************************************************************************************");
        System.out.println("                                          UNIVERSITY                                                    ");
        System.out.println("********************************************************************************************************");

        while (option != "0" ) {
            System.out.println("--------------------------------------------------------------------------------------------------------");
            System.out.println("Please select one option"
                    + "\n[1]Professor Information"
                    + "\n[2]Class Information"
                    + "\n[3]Create new Student and add it to and existing class"
                    + "\n[4]Create new class and add a teacher and students"
                    + "\n[5]List all classes where a student is included"
                    + "\n[6]Exit");
            System.out.println("--------------------------------------------------------------------------------------------------------");

            Scanner read = new Scanner(System.in);
            option = read.nextLine();


            switch (option) {
                case "1"://Professor List
                    System.out.println("******************************* PROFESSOR LIST *********************************************************");
                    System.out.println("........................................................................................................");
                    management.getTeachers().forEach(teacher -> System.out.println(teacher.toString()));

                    break;

                case "2"://Classes list
                    System.out.println("*********************************  CLASS LIST  *********************************************************");
                    System.out.println("........................................................................................................");
                    functions.getClassList();

                    break;

                case "3"://Create new Student and add it to and existing class
                    System.out.println("*********************************** NEW STUDENT ********************************************************");
                    System.out.println("........................................................................................................");
                    functions.createNewStudent();

                    break;

                case "4"://New Class
                    System.out.println("*********************************** NEW CLASS **********************************************************");
                    System.out.println("........................................................................................................");
                    functions.createNewClass();
                    break;

                case "5"://List all the classes in which a given student is included
                    System.out.println("STUDENTS LIST");
                    System.out.println("........................................................................................................");
                    functions.listAllStudentsInAClass();
                    break;

                case "6"://Exit
                    option = "0";
                    System.out.println("SEE YOU SOON");
                    break;

                default:
                    System.out.println("Sorry...Incorrect Option!");
            }
        }//Main While
    }

}//End University Class





