package com.jasper.caculator;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CashCalculator {

    private Integer amount;
    private Double unitPrice;
    private PromotionStrategy underlyingStrategy;

    CashCalculator(PromotionStrategy strategy){
        underlyingStrategy = strategy;
    }

    public double calculate(){
        double originalAmount = unitPrice * amount;
        underlyingStrategy.setOriginalAmount(originalAmount);
        return underlyingStrategy.execute();
    }
}
