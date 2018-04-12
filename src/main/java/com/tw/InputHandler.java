package com.tw;

import java.util.*;

public class InputHandler {

    private Scanner scanner;

    public InputHandler() {
        scanner = new Scanner(System.in);
    }

    public InputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public int getMainMenuInput() {
        try {
            int input = Integer.parseInt(scanner.nextLine());
            if (input >= 1 && input <= 3) {
                return input;
            } else {
                return 0;
            }
        }catch (Exception e){
            return 0;
        }
    }

    public Student getStudentInfoInput() {
        String inputStudent = scanner.nextLine();
        Map<String, String> subjects = Config.getSubjectsMap();
        String[] info = inputStudent.split(", ");
        try {
            String name = info[0].trim(), id = info[1].trim();
            Map<String, Integer> scores = new HashMap<>();
            for (int i = 2; i < 6; i++) {
                int score = Integer.parseInt(info[i].replaceAll("[^\\d]", ""));
                String subject = subjects.get(info[i].substring(0, info[i].indexOf(":")).trim());
                scores.put(subject, score);
            }
            return scores.size() == 4 ? new Student(name, id, scores) : null;
        } catch (Exception e) {
            return null;
        }
    }


    public List<String> getStudentIdsInput() {
        String inputStudentIds = scanner.nextLine();
        String temp = inputStudentIds.replaceAll("[\\d,\\s]", "");
        boolean formatError = temp.length() != 0;
        return formatError ? null : new ArrayList<>(Arrays.asList(inputStudentIds.split(", ")));
    }
}
