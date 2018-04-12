package com.tw;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ViewTest {

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private List<Map<String, String>> sheetList = new ArrayList<>();

    @Before
    public void setup(){

        System.setOut(new PrintStream(outputStream));

        Map<String, String> studentSheet = new HashMap<>();
        studentSheet.put("name", "张三");
        studentSheet.put("Math", "75");
        studentSheet.put("Chinese", "95");
        studentSheet.put("English", "80");
        studentSheet.put("Program", "80");
        studentSheet.put("average", String.valueOf((75 + 95 + 80 + 80) / 4.0));
        studentSheet.put("total", String.valueOf(75 + 95 + 80 + 80));
        sheetList.add(studentSheet);

        Map<String, String> studentSheet2 = new HashMap<>();
        studentSheet2.put("name", "李四");
        studentSheet2.put("Math", "85");
        studentSheet2.put("Chinese", "80");
        studentSheet2.put("English", "70");
        studentSheet2.put("Program", "90");
        studentSheet2.put("average", String.valueOf((85 + 80 + 70 + 90) / 4.0));
        studentSheet2.put("total", String.valueOf(85 + 80 + 70 + 90));
        sheetList.add(studentSheet2);
    }

    private String systemOut() {
        return outputStream.toString();
    }

    @Test
    public void printReport() {
        View view = new View();
        StudentService mockedService = mock(StudentService.class);
        List<String> ids = new ArrayList<>(Arrays.asList(new String[]{"01", "02"}));
        when(mockedService.getStudentsSheet(ids)).thenReturn(sheetList);
        when(mockedService.getAverageOfAllStudents()).thenReturn(81.875);
        when(mockedService.getMedianOfAllStudents()).thenReturn(80.0);

        String transcript = "成绩单\n" +
                "姓名|数学|语文|英语|编程|平均分|总分\n" +
                "========================\n" +
                "张三|75|95|80|80|82.5|330\n" +
                "李四|85|80|70|90|81.25|325\n" +
                "========================\n" +
                "全班总分平均数：81.875\n" +
                "全班总分中位数：80.0\n";

        view.printReport(mockedService.getStudentsSheet(ids),
                mockedService.getAverageOfAllStudents(), mockedService.getMedianOfAllStudents());

        assertThat(systemOut(), is(transcript));
    }
}