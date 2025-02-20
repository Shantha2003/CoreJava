import java.util.Scanner;

public class ReverseSum{
	public static void main(String args[]){
	 	int rev =0;
		int sum =0;
		int rem;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number: ");
		int num = sc.nextInt();

		while(num > 0) {

			rem = num % 10;

			rev = rev * 10 + rem;

			sum = sum + rem;
	
			num = num / 10;
		}
		System.out.println("Reversed number is " + rev);
		System.out.println("Sum of these number is " + sum);
	}
}
