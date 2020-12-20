package oopSystem1;

import static org.junit.Assert.*;

public class EquationTest {

    @org.junit.Before
    public void setUp() throws Exception {
        System.out.println("测试开始");
    }

    @org.junit.After
    public void tearDown() throws Exception {
        System.out.println("测试结束\n");
    }


    @org.junit.Test
    public void createLeftNumber() {
        Equation equation = new Equation();
        equation.createLeftNumber(100);
        System.out.println(equation.getLeftNumber());

    }

    @org.junit.Test
    public void createRightNumber() {
        Equation equation = new Equation();
        equation.createRightNumber(100);
        System.out.println(equation.getRightNumber());
    }

    @org.junit.Test
    public void createOperator() {
        Equation equation = new Equation();
        System.out.println("测试内容：createOperator()");
        for(int i =0; i < 10;i++){
            equation.createOperator(50);
            System.out.printf("%s\t", equation.getOperator());
        }
    }

    @org.junit.Test
    public void checkRange() {
        Equation equation = new Equation();
//        equation.setCeiling(100);
//        equation.setFloor(0);
        equation.setAnswer(23);
        System.out.println(equation.checkRange(0,100));
    }

    @org.junit.Test
    public void countAnswer() {
        Equation equation = new Equation();
        equation.setLeftNumber(10);
        equation.setRightNumber(20);
        equation.setOperator("-");
        equation.countAnswer();
        System.out.println(equation.getLeftNumber() + equation.getOperator() + equation.getRightNumber() + "=" + equation.getAnswer());
    }

    @org.junit.Test
    public void testToString() {
        Equation equation = new Equation();
        equation.setLeftNumber(10);
        equation.setRightNumber(20);
        equation.setOperator("-");
        System.out.println(equation.toString());
    }
}