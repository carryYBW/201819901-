package oopSystem2.test;

import oopSystem2.equation.SubtractionEquation;
import org.junit.Test;

public class SubtractionEquationTest {

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
        SubtractionEquation subtractionEquation = new SubtractionEquation();
        subtractionEquation.createOperator();
        System.out.println(subtractionEquation.getOperator());
    }

    @Test
    public void countAnswer() {

        SubtractionEquation subtractionEquation = new SubtractionEquation();
        subtractionEquation.createOperator();
        subtractionEquation.createRightNumber(100);
        subtractionEquation.createLeftNumber(100);
        subtractionEquation.countAnswer();
        System.out.println(subtractionEquation.toString() +"=" + subtractionEquation.getAnswer());

    }
}