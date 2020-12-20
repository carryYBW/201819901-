package oopSystem2.equation;

import java.util.Random;

public abstract class Equation {
    //定义算式的包含属性 两个数字，一个符号，一个答案
    private int leftNumber;
    private int rightNumber;
    private String operator;
    private int answer;

    //Get，Set方法
    public int getRightNumber() {
        return rightNumber;
    }

    public int getLeftNumber() {
        return leftNumber;
    }

    public String getOperator() {
        return operator;
    }

    public void setLeftNumber(int leftNumber) {
        this.leftNumber = leftNumber;
    }

    public void setRightNumber(int rightNumber) {
        this.rightNumber = rightNumber;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    //生成指定范围的随机数
    private int createRandomNumber(int range) {
        Random random = new Random();
        return random.nextInt(range);
    }
    //生成leftNumber
    public void createLeftNumber(int range) {
        this.leftNumber = createRandomNumber(range);
    }
    //生成rightNumber
    public void createRightNumber(int range) {
        this.rightNumber = createRandomNumber(range);
    }
    //检查答案是否合规
    public boolean checkRange(int floor, int ceiling) {
        if (answer > ceiling || answer < floor) {
            return false;
        }
        return true;
    }

    //返回算式
    @Override
    public String toString() {
        String s = this.leftNumber + this.operator + this.rightNumber;
        return s;
    }
    //生成运算符号
    public abstract void createOperator();
    //计算答案
    public abstract void countAnswer();
}

