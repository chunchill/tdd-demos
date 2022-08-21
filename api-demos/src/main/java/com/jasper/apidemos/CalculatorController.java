package com.jasper.apidemos;

import com.jasper.caculator.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/cashcalculator")
public class CalculatorController {

    @GetMapping("/hello")
    public String Hello(){
        return "Hello world";
    }

    @GetMapping("/calculate/discount")
    public Double calculateForDiscountStrategy(double unitPrice, int amount, double discountRate){
        Double totalAmount = 0d;
        CashCalculator calculator = new CashCalculator();
        calculator.setUnitPrice(unitPrice);
        calculator.setAmount(amount);
        DiscountStrategy underlyingStrategy = (DiscountStrategy) StrategyContextFactory.useStrategy(StrategyEnum.DISCOUNT);
        underlyingStrategy.setDiscountRate(discountRate);
        calculator.setUnderlyingStrategy(underlyingStrategy);
        totalAmount = calculator.calculate();
        return totalAmount;
    }

    @GetMapping("/calculate/normal")
    public Double calculateForNormalStrategy(double unitPrice, int amount){
        Double totalAmount = 0d;
        CashCalculator calculator = new CashCalculator();
        calculator.setUnitPrice(unitPrice);
        calculator.setAmount(amount);
        NonStrategy underlyingStrategy = (NonStrategy) StrategyContextFactory.useStrategy(StrategyEnum.NORMAL);
        calculator.setUnderlyingStrategy(underlyingStrategy);
        totalAmount = calculator.calculate();
        return totalAmount;
    }


    @GetMapping("/calculate/return")
    public Double calculateForReturnStrategy(double unitPrice, int amount, double threshold, double returnAmount){
        Double totalAmount = 0d;
        CashCalculator calculator = new CashCalculator();
        calculator.setUnitPrice(unitPrice);
        calculator.setAmount(amount);
        ReturnStrategy underlyingStrategy = (ReturnStrategy) StrategyContextFactory.useStrategy(StrategyEnum.RETURN);
        underlyingStrategy.setUp(threshold,returnAmount);
        calculator.setUnderlyingStrategy(underlyingStrategy);
        totalAmount = calculator.calculate();
        return totalAmount;
    }




}
