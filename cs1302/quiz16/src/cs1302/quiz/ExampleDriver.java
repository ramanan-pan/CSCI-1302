package cs1302.quiz;

import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class ExampleDriver {

    public static void main(String[] args) {
        Example e = new Example();
        //Supplier<Example> se = Example::cubeIt;
        //UnaryOperator<Double> uf = e::cubeIt;
        //BinaryOperator<Double> uf =  Example::cubeIt;
        BiFunction<Example, Double, Double> bf = (Example ex, Double num) -> ex.cubeIt(num);
    } // main
} // ExampleDriver
