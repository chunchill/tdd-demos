package com.jasper.caculator;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ReturnStrategy extends PromotionStrategy {

    private Double thresholdAmount;
    private Double returnAmount;

    @Override
    public Double execute() {
        if (getOriginalAmount() > thresholdAmount) {
            return getOriginalAmount() - Math.floor((getOriginalAmount() / thresholdAmount)) * returnAmount;
        }
        return 0d;
    }


    public void setUp(Double thresholdAmount, Double returnAmount) {
        this.thresholdAmount = thresholdAmount;
        this.returnAmount = returnAmount;

    }
}
