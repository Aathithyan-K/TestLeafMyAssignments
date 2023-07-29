package week1.day2;

public class Task2_FindDuplicateNumbers {
	public static void main(String[] args) {
		//To Find the duplicate numbers in an array
		int[] numbers = {2, 5, 7, 7, 5, 9, 2, 2, 3, 7, 7, 5, 5, 5, 9, 5, 9};
		int duplicateValuesCount = 0;
		System.out.println("The duplicate numbers are: ");
		for(int i=0;i<numbers.length;i++) {
			duplicateValuesCount = 0;
			for(int j=i+1;j<numbers.length;j++) {
				if(numbers[i]==numbers[j] && numbers[i]>0) {
					duplicateValuesCount++;
					numbers[j]=0;
				}
			}
			if(duplicateValuesCount>0) {
				System.out.print(numbers[i] + " ");
			}
		}
	}
}
