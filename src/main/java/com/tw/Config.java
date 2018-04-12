package com.tw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Config {

    public static final String MAIN_MENU = "1. 添加学生\n2. 生成成绩单\n3. 退出\n请输入你的选择（1～3）：";
    public static final String ENTER_STUDENT_INFO = "请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：";
    public static final String WRONG_FORMAT_OF_STUDENT_INFO = "请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）：";
    public static final String ENTER_STUDENT_IDS = "请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：";
    public static final String WRONG_FORMAT_OF_STUDENT_ID = "请按正确的格式输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：";
    public static final String SCORE_LIST = "成绩单\n姓名|数学|语文|英语|编程|平均分|总分";
    public static final String DELIMITER = "========================";
    public static final String AVERAGE_OF_ALL_STUDENTS = "全班总分平均数：";
    public static final String MEDIAN_OF_ALL_STUDENTS = "全班总分中位数：";

    public static List<String> displayOrder;
    public static Map<String, String> subjects;

    static{
        displayOrder = new ArrayList<>();
        displayOrder.add("name");
        displayOrder.add("Math");
        displayOrder.add("Chinese");
        displayOrder.add("English");
        displayOrder.add("Program");
        displayOrder.add("average");
        displayOrder.add("total");
    }
    static{
        subjects = new HashMap<>();
        subjects.put("语文","Chinese");
        subjects.put("数学","Math");
        subjects.put("英语","English");
        subjects.put("编程","Program");
    }

    public static List<String> getStudentSheetOrder(){
        return displayOrder;
    }

    public static Map<String,String> getSubjectsMap() {
        return subjects;
    }

}
