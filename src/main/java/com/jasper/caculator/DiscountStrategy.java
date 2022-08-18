package com.jasper.caculator;
import lombok.Data;

@Data
public class DiscountStrategy extends PromotionStrategy {

    private Double discountRate;
    @Override
    public Double execute() {
        return discountRate * getOriginalAmount();
    }
}
