package com.tw;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class ControllerTest {

    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private Student student;

    @Before
    public void setup(){

        Map<String, Integer> scores = new HashMap<>();
        scores.put("Math", 75);
        scores.put("Chinese", 95);
        scores.put("English", 80);
        scores.put("Program", 80);
        student = new Student("张三", "01", scores);
        
        System.setOut(new PrintStream(outputStream));
    }

    private String systemOut() {
        return outputStream.toString();
    }

    @Test
    public void should_print_added_when_have_correct_format() {
        InputHandler inputHandler = mock(InputHandler.class);
        when(inputHandler.getStudentInfoInput()).thenReturn(student);
        Controller controller = new Controller(new View(), inputHandler);

        controller.addStudentInfo();
        String addMessage = "学生张三的成绩被添加\n";

        assertThat(systemOut(), is(addMessage));
    }

    @Test
    public void should_print_add_prompt_when_have_wrong_format() {
        InputHandler inputHandler = mock(InputHandler.class);
        when(inputHandler.getStudentInfoInput()).thenReturn(null).thenReturn(student);
        Controller controller = new Controller(new View(), inputHandler);

        controller.addStudentInfo();
        String errMessage = "请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）：\n" + "" +
                "学生张三的成绩被添加\n";

        assertThat(systemOut(), is(errMessage));
    }

    @Test
    public void should_build_report_when_have_correct_ids() {
        InputHandler inputHandler = mock(InputHandler.class);
        List<String> ids = new ArrayList<>();
        ids.add("01");
        ids.add("02");
        when(inputHandler.getStudentIdsInput()).thenReturn(ids);
        View view = mock(View.class);
        Controller controller = new Controller(view, inputHandler);

        controller.buildReport();
        verify(view).printReport(Mockito.anyList(), Mockito.anyDouble(), Mockito.anyDouble());
    }

    @Test
    public void should_print_ids_prompt_when_have_wrong_format_ids() {
        InputHandler inputHandler = mock(InputHandler.class);
        List<String> ids = new ArrayList<>();
        ids.add("01");
        ids.add("02");
        when(inputHandler.getStudentIdsInput()).thenReturn(null).thenReturn(ids);
        Controller controller = new Controller(new View(), inputHandler);

        controller.buildReport();

        String errMessage = "请按正确的格式输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：\n";
        assertThat(systemOut().startsWith(errMessage), is(true));
    }


}