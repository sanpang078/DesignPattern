package org.example.behavior.observer;

public class Demo {
    public static void main(String[] args) {
        UserController userController = new UserController(new UserServer(), new PromotionService(), new NotificationService());
        userController.register("15088889999", "1234");
    }
}
