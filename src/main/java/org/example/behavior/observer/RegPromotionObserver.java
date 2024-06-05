package org.example.behavior.observer;

import org.example.behavior.observer.eventbus.Subscribe;

public class RegPromotionObserver{
    private PromotionService promotionService;
    public RegPromotionObserver(PromotionService promotionService) {
        this.promotionService = promotionService;
    }
    @Subscribe
    public void handleRegSuccess(final Long userId) {
         promotionService.issueNewUserExperienceCash(userId);

    }
}
