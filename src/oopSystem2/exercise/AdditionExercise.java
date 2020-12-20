package oopSystem2.exercise;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import oopSystem2.equation.AdditionEquation;
import oopSystem2.equation.Equation;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.SplittableRandom;

public class AdditionExercise extends Exercise {

    @Override
    public Equation initAnEquation() {
        return new AdditionEquation();
    }


}

