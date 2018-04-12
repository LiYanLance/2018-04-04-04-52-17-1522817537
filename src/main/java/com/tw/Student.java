package com.tw;

import java.util.Map;

public class Student {
    String name;
    String id;
    Map<String, Integer> scores;

    public Student(String name, String id, Map<String, Integer> scores) {
        this.name = name;
        this.id = id;
        this.scores = scores;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Map<String, Integer> getScores() {
        return scores;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            Student stu = (Student) obj;
            return id.equals(stu.getId());
        }
        return false;
    }
}
