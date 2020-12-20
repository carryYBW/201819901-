package oopSystem2.equation;

import oopSystem2.equation.Equation;

public class SubtractionEquation extends Equation {
    //生成运算符号 加法运算符
    public void createOperator() {
        setOperator("-");
    }
    //计算答案
    public void countAnswer() {
        this.setAnswer(this.getLeftNumber() - this.getRightNumber());
    }

}
