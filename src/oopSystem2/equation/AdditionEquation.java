package oopSystem2.equation;

public class AdditionEquation extends Equation {

    //生成运算符号 加法运算符
    public void createOperator() {
            setOperator("+");
    }
    //计算答案
    public void countAnswer() {
            this.setAnswer(this.getLeftNumber() + this.getRightNumber());
    }
}
