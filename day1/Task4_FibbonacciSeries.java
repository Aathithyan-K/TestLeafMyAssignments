package week1.day1;

public class Task4_FibbonacciSeries {

	public static void main(String[] args) {
		int firstNum = 0, sum = 0; 
		int secNum = 1;
		System.out.print(firstNum + " ");
		for(int i = 1; i < 11; i++) {
			sum = firstNum + secNum;
			System.out.print(sum + " ");
			firstNum = secNum;
			secNum = sum;
		}
	}
}
