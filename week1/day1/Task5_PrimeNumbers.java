package week1.day1;

public class Task5_PrimeNumbers {

	public static void main(String[] args) {
		int num = 20;
		boolean isPrime = true;
		//any number can divisible by 1, so we calculate from 2.
		for(int i = 2; i < num - 1; i++)
		{
			if((num % i) == 0) {
				isPrime = false;
			}
		}
		if(isPrime) {
			System.out.println(num + " is Prime Number");
		}
		else {
			System.out.println(num + " is not a Prime Number");
		}
	}

}
