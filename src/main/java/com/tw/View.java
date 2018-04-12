package com.tw;

import java.util.List;
import java.util.Map;

public class View {

    public void printMessage(String message) {
        System.out.print(message);
    }

    public void printlnMessage(String message) {
        System.out.print(message + "\n");
    }

    public void printReport(List<Map<String, String>> studentsSheet, double averageOfAllStudents, double medianOfAllStudents){
        printlnMessage(Config.SCORE_LIST);
        printlnMessage(Config.DELIMITER);
        List<String> order = Config.getStudentSheetOrder();
        studentsSheet.forEach(map->{
            String stuSheet = "";
            for (int i = 0; i < map.size(); i++) {
                stuSheet = stuSheet.concat(map.get(order.get(i))).concat("|");
            }
            stuSheet = stuSheet.substring(0, stuSheet.length() - 1);
            printlnMessage(stuSheet);
        });
        printlnMessage(Config.DELIMITER);
        printlnMessage(Config.AVERAGE_OF_ALL_STUDENTS + averageOfAllStudents);
        printlnMessage(Config.MEDIAN_OF_ALL_STUDENTS + medianOfAllStudents);
    }
}
