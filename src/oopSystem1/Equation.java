package oopSystem1;

import java.util.Random;

public class Equation {
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

    public void setLeftNumber(int leftNumber) {
        this.leftNumber = leftNumber;
    }

    public void setRightNumber(int rightNumber) {
        this.rightNumber = rightNumber;
    }

    public String getOperator() {
        return operator;
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
        setLeftNumber(createRandomNumber(range));

    }

    //生成rightNumber
    public void createRightNumber(int range) {
        setRightNumber(createRandomNumber(range));
    }

    //生成运算符号 传入百分数0~100,加法的比例
    public void createOperator(int percent) {
        int random = createRandomNumber(100);
        if (random < percent) {
            setOperator("+");
        } else {
            setOperator("-");
        }
    }

    //检查答案是否合规
    public boolean checkRange(int floor, int ceiling) {
        if (answer > ceiling || answer < floor) {
            return false;
        }
        return true;
    }

    //计算答案
    public void countAnswer() {
        if (getOperator().equals("+")) {
            this.answer = this.leftNumber + this.rightNumber;
        } else if (getOperator().equals("-")) {
            this.answer = this.leftNumber - this.rightNumber;
        } else {
            System.out.println("countAnswer方法出现错误，符号不匹配");
        }
    }

    //返回算式
    @Override
    public String toString() {
        String s = this.leftNumber + this.operator + this.rightNumber;
        return s;
    }
}
