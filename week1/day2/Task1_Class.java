package week1.day2;

public class Task1_Class {

	public static void main(String[] args) {
		Task1_Mobile mobileObject = new Task1_Mobile();
		mobileObject.sendSms();
		System.out.println("From Class Tab to calling makeCall() and returning phone number: " + mobileObject.makeCall(6381258428l));
	}

}
