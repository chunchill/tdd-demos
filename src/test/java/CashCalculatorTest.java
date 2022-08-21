import com.jasper.caculator.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CashCalculatorTest {

    private CashCalculator calculator;
    private Double totalAmount = 0d;

    @Before
    public void setUp() {
        calculator = new CashCalculator();
        calculator.setAmount(5);
        calculator.setUnitPrice(200d);
    }

    @Test
    public void should_return_1000d_if_try_a_normal_pay(){
        NonStrategy underlyingStrategy = (NonStrategy) StrategyContextFactory.useStrategy(StrategyEnum.NORMAL);
        calculator.setUnderlyingStrategy(underlyingStrategy);
        totalAmount = calculator.calculate();
        assertEquals(1000d, totalAmount,0);
    }

    @Test
    public void should_return_700d_if_try_a_30off_discount_promotion() {
        DiscountStrategy underlyingStrategy = (DiscountStrategy) StrategyContextFactory.useStrategy(StrategyEnum.DISCOUNT);
        underlyingStrategy.setDiscountRate(0.7);
        calculator.setUnderlyingStrategy(underlyingStrategy);
        totalAmount = calculator.calculate();
        assertEquals(700d, totalAmount,0);
    }

    @Test
    public void should_return_750d_if_we_try_a_above_200_return_50_promotion(){
        ReturnStrategy underlyingStrategy = (ReturnStrategy) StrategyContextFactory.useStrategy(StrategyEnum.RETURN);
        underlyingStrategy.setUp(200d,50d);
        calculator.setUnderlyingStrategy(underlyingStrategy);
        totalAmount = calculator.calculate();
        assertEquals(750d, totalAmount,0);
    }

}
