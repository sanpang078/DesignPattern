package org.example.behavior.observer;

public class RegPromotionObserver implements IRegObserver{
    private PromotionService promotionService;
    public RegPromotionObserver(PromotionService promotionService) {
        this.promotionService = promotionService;
    }
    @Override
    public void handleRegSuccess(final Long userId) {

         promotionService.issueNewUserExperienceCash(userId);

    }
}
