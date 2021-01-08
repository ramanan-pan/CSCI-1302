package cs1302.quiz;

public class Test {

    public static void forEachPrintln(Object ... objs) {
        for (Object obj : objs) {
            System.out.println(obj);
        } // for
    } // forEachPrintln

    public static void main(String[] args) {
        String a = "hello";
        Object b = a;
        Object c = b;
        Object d = c;
        forEachPrintln(d, null);
        System.out.println();
        String a1 = "hello";
        Integer b1 = Integer.valueOf(42);
        Object c1 = a1;
        String d1 = String.format("(%s, %s, %s)", a1, b1, c1);
        forEachPrintln(a1, a1, a1);
        System.out.println();
        String a2 = "hello";
        Integer b2 = Integer.valueOf(42);
        Object c2 = a2;
        String d2 = String.format("(%s, %s, %s)", a2, b2, c2);
        forEachPrintln(a2, b2, c2, d2);
        System.out.println();
        String a3 = "hello";
        Object b3 = a3;
        Object c3 = b3;
        Object d3 = c3;
        forEachPrintln(null, a3);
        System.out.println();

    } // main
} // Test
