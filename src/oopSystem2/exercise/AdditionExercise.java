package oopSystem2.exercise;

import oopSystem2.equation.Equation;
import oopSystem2.equation.AdditionEquation;

public class AdditionExercise extends Exercise {

    @Override
    public Equation initAnEquation() {
        return new AdditionEquation();
    }
}

