package com.tw;

import java.util.*;

public class StudentService {

    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Map<String, String>> getStudentsSheet(List<String> studentsIds) {
        List<Map<String, String>> sheetList = new ArrayList<>();
        for (Student student : students) {
            if (studentsIds.contains(student.getId())) {
                Map<String, String> studentSheet = new HashMap<>();
                Map<String, Integer> scores = student.getScores();
                double average = scores.values().stream().mapToInt(score -> score).average().getAsDouble();
                int total = scores.values().stream().mapToInt(score -> score).sum();

                studentSheet.put("name", student.getName());
                studentSheet.put("average", String.valueOf(average));
                studentSheet.put("total", String.valueOf(total));
                scores.forEach((subject, score) -> studentSheet.put(subject, String.valueOf(score)));

                sheetList.add(studentSheet);
            }
        }
        return sheetList;
    }

    public double getAverageOfAllStudents() {
        if(students.isEmpty()){
            return 0;
        }
        List<Integer> scores = new ArrayList<>();
        for (Student student : students) {
            scores.addAll(student.getScores().values());
        }
        double average = scores.stream().mapToInt(s -> s).average().getAsDouble();
        return average;
    }

    public double getMedianOfAllStudents(){
        if(students.isEmpty()){
            return 0;
        }
        List<Integer> scores = new ArrayList<>();
        for (Student student : students) {
            scores.addAll(student.getScores().values());
        }
        Collections.sort(scores);
        double median = scores.get(scores.size() / 2);
        if (scores.size() % 2 == 0) {
            median = (median + scores.get(scores.size() / 2 - 1)) / 2;
        }
        return median;
    }

}
