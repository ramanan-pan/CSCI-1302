package cs1302.generics;

public class Pair <T,U> {

    private T first;
    private U second;

    public Pair(T elem1, U elem2) {
        this.first = elem1;
        this.second = elem2;
    } // Pair

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    public void setFirst(T elem) {
        this.first = elem;
    }

    public void setSecond(U elem) {
        this.second = elem;
    }

} // Pair <T,U>
