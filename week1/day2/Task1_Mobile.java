package week1.day2;

public class Task1_Mobile {
	public void sendSms() {
		System.out.println("From oppo");
	}
	public long makeCall(long phoneNumber) {
		return phoneNumber;
	}
	public static void main(String[] args) {
		Task1_Mobile mobileObject = new Task1_Mobile();
		mobileObject.sendSms();
		System.out.println("Returned Phone Number is : " + mobileObject.makeCall(6381258428l));
	}

}
