package oopSystem2.exercise;

import oopSystem2.equation.Equation;
import oopSystem2.equation.SubtractionEquation;


public class SubtractionExercise extends Exercise {
    @Override
    public Equation initAnEquation() {
        return new SubtractionEquation();
    }
}
