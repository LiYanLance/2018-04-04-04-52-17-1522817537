package com.tw;

public class Library {

    private View view;
    private InputHandler inputHandler;
    private Controller controller;

    public void init() {
        while (true) {
            view.printMessage(Config.MAIN_MENU);
            switch (inputHandler.getMainMenuInput()) {
                case 1:
                    view.printlnMessage(Config.ENTER_STUDENT_INFO);
                    controller.addStudentInfo();
                    break;
                case 2:
                    view.printlnMessage(Config.ENTER_STUDENT_IDS);
                    controller.buildReport();
                    break;
                case 3:
                    return;
                default:
                    break;
            }
        }
    }


    public static void main(String[] args){
        new Library().init();
    }


    public Library(View view, InputHandler inputHandler, Controller controller) {
        this.view = view;
        this.inputHandler = inputHandler;
        this.controller = controller;
    }

    public Library() {
        view = new View();
        inputHandler = new InputHandler();
        controller = new Controller(view, inputHandler);
    }
}
