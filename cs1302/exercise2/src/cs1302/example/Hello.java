package cs1302.example;
import cs1302.utility;

public class Hello {
    public static void main(String[] args) {
	java.util.Scanner keyboard = new java.util.Scanner(System.in);
	String userName = keyboard.nextLine();
	System.out.println("Hello, " + userName);

	int num1 = keyboard.nextInt();
	int num2 = keyboard.nextInt();
	keyboard.nextLine();
	System.out.println(MyMethods. max(num1, num2));
        }

}
