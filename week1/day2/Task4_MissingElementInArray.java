package week1.day2;

import java.util.Arrays;

public class Task4_MissingElementInArray {

	public static void main(String[] args) {
		//Find the missing element in an array
		int[] arr = {1,3,2,4,7,6,8};
		int length = arr.length;
		Arrays.sort(arr);
		int small = arr[0];
		int largest = arr[length-1];
		int difference = largest - small;
		if(difference<largest) {
			for(int i=0;i<length-1;i++) {
				int differenceValue = arr[i+1]-arr[i];
				if(differenceValue!=1) {
					System.out.print("The Missing number is: ");
					System.out.print(arr[i]+1);
				}
			}
		}
	}

}
