package com.tw;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class InputHandlerTest {

    @Test
    public void should_return_student_when_input_is_correct() {

        String input = "张三, 01, 语文: 80, 英语: 80, 数学: 70, 编程: 90";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Map<String, Integer> scores = new HashMap<>();
        scores.put("Math", 75);
        scores.put("Chinese", 95);
        scores.put("English", 80);
        scores.put("Program", 80);
        Student student = new Student("张三", "01", scores);

        InputHandler inputHandler = new InputHandler();
        assertThat(student, is(inputHandler.getStudentInfoInput()));
    }

    @Test
    public void should_return_null_when_student_info_format_is_wrong() {

        String input = "张三, 01, 语文=80, 英语: 80, 数学: 70, 编程: 90";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        InputHandler inputHandler = new InputHandler();
        assertThat(null, is(inputHandler.getStudentInfoInput()));
    }

    @Test
    public void should_return_id_list_when_input_is_correct() {
        String input = "01, 02";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        List<String> ids = new ArrayList<>();
        ids.add("01");
        ids.add("02");

        InputHandler inputHandler = new InputHandler();
        assertThat(ids, is(inputHandler.getStudentIdsInput()));
    }

    @Test
    public void should_return_null_when_ids_format_is_wrong() {
        String input = "01# 02";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        List<String> ids = null;

        InputHandler inputHandler = new InputHandler();
        assertThat(ids, is(inputHandler.getStudentIdsInput()));
    }
}