package com.tw;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StudentServiceTest {

    private Student student, student2;

    @Before
    public void setup() {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Math", 75);
        scores.put("Chinese", 95);
        scores.put("English", 80);
        scores.put("Program", 80);
        student = new Student("张三", "01", scores);

        Map<String, Integer> scores2 = new HashMap<>();
        scores2.put("Math", 85);
        scores2.put("Chinese", 80);
        scores2.put("English", 70);
        scores2.put("Program", 90);
        student2 = new Student("李四", "02", scores2);
    }


    @Test
    public void getStudentsSheet() {
        StudentService studentService = new StudentService();
        studentService.addStudent(student);

        Map<String, String> studentSheet = new HashMap<>();
        studentSheet.put("name", "张三");
        studentSheet.put("Math", "75");
        studentSheet.put("Chinese", "95");
        studentSheet.put("English", "80");
        studentSheet.put("Program", "80");
        studentSheet.put("average", String.valueOf((75 + 95 + 80 + 80) / 4.0));
        studentSheet.put("total", String.valueOf(75 + 95 + 80 + 80));

        List<String> ids = new ArrayList<>(Arrays.asList(new String[]{"01"}));
        assertThat(studentService.getStudentsSheet(ids).get(0), is(studentSheet));
    }

    @Test
    public void getAverageOfAllStudents() {
        StudentService studentService = new StudentService();
        studentService.addStudent(student);
        studentService.addStudent(student2);
        double average = (75 + 95 + 80 + 80 + 85 + 80 + 70 + 90) / 8.0;
        assertThat(studentService.getAverageOfAllStudents(), is(average));
    }

    @Test
    public void getMedianOfAllStudents() {
        StudentService studentService = new StudentService();
        studentService.addStudent(student);
        studentService.addStudent(student2);
        assertThat(studentService.getMedianOfAllStudents(), is(80.0));
    }

}