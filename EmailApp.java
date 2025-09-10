package emailApp;

import java.util.Scanner;

public class EmailApp {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Email em1 = new Email();
		System.out.println(em1.showInfo());
	}

}
