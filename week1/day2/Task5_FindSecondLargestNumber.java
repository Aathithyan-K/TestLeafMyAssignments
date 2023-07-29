package week1.day2;

public class Task5_FindSecondLargestNumber {

	public static void main(String[] args) {
		int[] data = {3,2,11,4,6,7};
		int tempValue = 0;
		for(int i=0;i<data.length;i++) {
			for(int j=i+1;j<data.length;j++) {
				if(data[i]>data[j]) {
					tempValue = data[i];
					data[i] = data[j];
					data[j] = tempValue;
				}
			}
		}
		System.out.print("The Second largest number is: ");
		System.out.print(data[data.length-2]);
	}
}
