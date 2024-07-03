package com.sanpang.behavior.observer;

import com.sanpang.behavior.observer.eventbus.Subscribe;

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
