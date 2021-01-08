package cs1302.quiz;

import java.util.function.IntFunction;
import java.util.function.Function;

public class ArrayUtility<T> {
    public static <T> T[] makeArray(IntFunction<T[]> gen, int length) {
        return gen.apply(length);
    } // makeArray

    public static void main(String[] args) {
        //Integer[] ia = ArrayUtility.makeArray(Integer[]::new, 2);
        //Double[] da = ArrayUtility.makeArray(Integer[]::new, 3);

        //Function<Integer, Integer[]> f = len -> ArrayUtility.makeArray(Integer[]::new, len);
        //Integer[] ia = ArrayUtility.makeArray(f::apply, 42);

//Integer[] ia = ArrayUtility.makeArray(Integer::new, 7);

        //IntFunction<Double[]> dgen = Double[]::new;
        //Double[] da = ArrayUtility.makeArray(dgen, 3);

        //Function<Integer, Integer[]> f = Integer[]::new;
        //Integer[] ia = ArrayUtility.makeArray(f::apply, 5);

        //Integer[] ia = ArrayUtility.makeArray(len -> new Integer[len], 6);

        //IntFunction<String[]> sgen = len -> new String[len];
        //String[] sa = ArrayUtility.makeArray(sgen, 1);

        IntFunction<Character[]> cgen = new Character[len];
        Character[] sa = ArrayUtility.makeArray(cgen, 4);

    }
}
