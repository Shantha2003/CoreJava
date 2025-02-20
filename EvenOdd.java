import java.util.Scanner;

public class EvenOdd{
	
	public static void main(String agrs[]){
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number: ");
		int num = sc.nextInt();
		if(num % 2 == 0){
			System.out.println(num + " is a even number.");
		}
		else
			System.out.println(num + " is a odd number.");
	}
}	
