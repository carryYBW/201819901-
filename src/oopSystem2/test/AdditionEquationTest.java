package oopSystem2.test;

import oopSystem2.equation.AdditionEquation;
import org.junit.Test;

public class AdditionEquationTest {

    @org.junit.Before
    public void setUp() throws Exception {
        System.out.println("测试开始");
    }
    @org.junit.After
    public void tearDown() throws Exception {
        System.out.println("测试结束\n");
    }
    @Test
    public void createOperator() {
        AdditionEquation additionEquation = new AdditionEquation();
        additionEquation.createOperator();

        System.out.println(additionEquation.getOperator());
    }
    @Test
    public void countAnswer() {
        AdditionEquation additionEquation = new AdditionEquation();
        additionEquation.createRightNumber(100);
        additionEquation.createLeftNumber(100);
        additionEquation.createOperator();
        additionEquation.countAnswer();
        System.out.println(additionEquation.toString() +"=" + additionEquation.getAnswer());

    }
}