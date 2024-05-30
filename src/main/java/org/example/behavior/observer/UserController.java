package org.example.behavior.observer;

public class UserController {
    private UserServer userServer;
    private PromotionService promotionService;
    private NotificationService notificationService;

    public UserController(UserServer userServer, PromotionService promotionService, NotificationService notificationService){
        this.userServer = userServer;
        this.notificationService = notificationService;
        this.promotionService = promotionService;
    }

    public Long register(String telephone, String password){
        long UserId = userServer.register(telephone, password);
        promotionService.issueNewUserExperienceCash(UserId);
        notificationService.sendInboxMessage(UserId, "Welcome to ...");
        return UserId;
    }
}
