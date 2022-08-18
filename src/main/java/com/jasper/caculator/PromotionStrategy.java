package com.jasper.caculator;

import lombok.Data;

import java.math.BigDecimal;

@Data
public abstract class PromotionStrategy {

    private Double originalAmount;
    public abstract Double execute();
}