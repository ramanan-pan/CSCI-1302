package cs1302.generics;

public class QuizDriver {
    public static void main(String[] args) {
        // Pair p = new Pair(7.2, 4);
        // Pair p<String, Boolean> = new Pair<String, Boolean>("Brad", true);
        // Pair p = new Pair("Sally", "Joe");
        // Pair<String, Boolean> p = new Pair("Brad", true);
        // Pair<> p = new Pair<String, String>("Bred's", "Fern");
        Pair<Pair<Integer, Double>, String> p = new Pair<>(new Pair<Integer, Double>(4, 5.0), "yas");


    } // main
}
