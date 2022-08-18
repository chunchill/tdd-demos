package com.jasper.caculator;

public class StrategyContextFactory {

    public static PromotionStrategy useStrategy(StrategyEnum strategyType){

        PromotionStrategy selectedStrategy;
        switch (strategyType){

            case RETURN:
                selectedStrategy = new ReturnStrategy();
                break;
            case DISCOUNT:
                selectedStrategy = new DiscountStrategy();
                break;
            default:
                selectedStrategy = new NonStrategy();
                break;
        }

        return selectedStrategy;
    }
}
