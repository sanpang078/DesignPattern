package org.example.behavior.observer;

public class PromotionService {
    public void issueNewUserExperienceCash(long userId) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发放新用户体验金");

    }
}
