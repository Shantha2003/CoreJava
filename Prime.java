import java.util.Scanner;

public class Prime{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number: ");
		int num = sc.nextInt();
		int i; 
		boolean flag = false;
		
		if(num == 0 || num == 1)
			flag = true;
		for(i = 2 ; i <= num / 2 ; ++i){
			if(num % i == 0){
				flag = true;
				break;
			}
		}

		if(!flag){
			System.out.println(num + " is a prime number.");
		}
		else{
			System.out.println(num + " is not a prime number."); 
		}
	}
}
