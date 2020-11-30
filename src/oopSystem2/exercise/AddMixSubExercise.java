package oopSystem2.exercise;

import oopSystem2.equation.AdditionEquation;
import oopSystem2.equation.Equation;
import oopSystem2.equation.SubtractionEquation;

import java.util.Random;

public class AddMixSubExercise extends Exercise {

    @Override
    public Equation initAnEquation() {
        Random random = new Random();
        if(random.nextInt(100)< this.getPercent()){
            return new AdditionEquation();
        }else{
            return new SubtractionEquation();
        }
    }
}
