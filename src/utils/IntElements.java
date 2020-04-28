package utils;

import com.finalprojectjava.data.*;

import java.util.ArrayList;
import java.util.List;

public class IntElements {

    public static List<Teacher> intTeacherList() {

        List<Teacher> teacherList = new ArrayList();
        FullTimeTeacher teacher1 = new FullTimeTeacher("Alvaro Rico", 2000, 1001, 6);
        FullTimeTeacher teacher2 = new FullTimeTeacher("Julio Ramirez", 3500, 1002,8);
        PartTimeTeacher teacher3= new PartTimeTeacher("Camila Jimenez", 800,1003, 20);
        PartTimeTeacher teacher4= new PartTimeTeacher("Felipe Bernate", 500,1004,30);
        teacherList.add(teacher1);
        teacherList.add(teacher2);
        teacherList.add(teacher3);
        teacherList.add(teacher4);

        return teacherList;
    }


    public static List<Student> intStudentList(){
        List<Student> students = new ArrayList();
        Student student1 = new Student("Martina Corredor", 18, 101);
        Student student2 = new Student("Raul Gonzalez", 22, 102);
        Student student3 = new Student("Federico Calderon", 25, 103);
        Student student4 = new Student("Eliana Giraldo", 16, 104);
        Student student5 = new Student("Camila Prieto", 23, 105);
        Student student6 = new Student("Sebastian Perez", 20, 106);
        Student student7 = new Student("Carmen Villalobos", 30, 107);
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        students.add(student6);
        students.add(student7);

        return students;

    }

    public static List<Clase> intClassesList()
    {
        List<Clase> clase  = new ArrayList();

        List <Student> students1 = new ArrayList();
        students1.add(intStudentList().get(2));
        students1.add(intStudentList().get(1));
        students1.add(intStudentList().get(0));

        List <Student> students2 = new ArrayList();
        students2.add(intStudentList().get(1));
        students2.add(intStudentList().get(3));
        students2.add(intStudentList().get(4));

        List <Student> students3 = new ArrayList();
        students3.add(intStudentList().get(3));
        students3.add(intStudentList().get(5));
        students3.add(intStudentList().get(6));

        List <Student> students4 = new ArrayList();
        students4.add(intStudentList().get(0));
        students4.add(intStudentList().get(4));
        students4.add(intStudentList().get(2));


        Clase math = new Clase("Math", 201,students1,intTeacherList().get(0));
        Clase english = new Clase("English", 301, students2, intTeacherList().get(2));
        Clase physics = new Clase("Physics", 401, students3, intTeacherList().get(1));
        Clase systems = new Clase("Systems", 501, students4, intTeacherList().get(3));

        clase.add(math);
        clase.add(english);
        clase.add(physics);
        clase.add(systems);

        return clase;
    }


}
