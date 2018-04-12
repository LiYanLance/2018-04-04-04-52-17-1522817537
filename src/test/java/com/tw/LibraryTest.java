package com.tw;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class LibraryTest {

    @Before
    public void setup(){
        System.setOut(new PrintStream(new ByteArrayOutputStream()));
    }
   
    @Test
    public void should_invoke_addStudentInfo_when_input_1(){
        InputHandler mockInputHandler = mock(InputHandler.class);
        when(mockInputHandler.getMainMenuInput()).thenReturn(1).thenReturn(3);

        Controller mockController = mock(Controller.class);

        new Library(new View(), mockInputHandler, mockController).init();
        verify(mockController).addStudentInfo();
    }

    @Test
    public void should_invoke_buildReport_when_input_2(){
        InputHandler mockInputHandler = mock(InputHandler.class);
        when(mockInputHandler.getMainMenuInput()).thenReturn(2).thenReturn(3);

        Controller mockController = mock(Controller.class);

        new Library(new View(), mockInputHandler, mockController).init();
        verify(mockController).buildReport();
    }

    
}
