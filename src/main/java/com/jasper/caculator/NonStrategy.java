package com.jasper.caculator;

public class NonStrategy extends PromotionStrategy{
    @Override
    public Double execute() {
        return getOriginalAmount();
    }
}
