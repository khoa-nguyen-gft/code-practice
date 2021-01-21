package refactoring.repace_primative_by_class_ISSUE;

public class Client {
	public static void main(String[] args) {
		ATMAccess user = new ATMAccess();		
		System.out.println(user.getState());
		
		user.verifyCard(123456789);
		System.out.println(user.getState());
		
		user.verifyPin(1234);
		System.out.println(user.getState());

		user.verifyWithdrawalAmount(99);
		System.out.println(user.getState());
	}
}


class ATMAccess {
	private String state;
	
	public final static String CARD_ENTERED = "CARD ENTERED";
	public final static String VALID_CARD = "VALID CARD";
	public final static String VALID_PIN = "VALID PIN";
	public final static String VALID_CASH_REQUEST = "VALID CASH REQUEST";
	public final static String DENIED = "DENIED";
	public final static int CARD_NUMBER = 123456789;
	public final static int PIN_NUMBER = 1234;
	public final static double CARD_BALANCE = 1000.00;
	
	
	public String getState() {
		return state;
	}

	public ATMAccess() {
		state = CARD_ENTERED;
		
	}
	
	public void verifyCard(int cardNumber) {
		if (CARD_NUMBER == cardNumber) {
			state = VALID_CARD;
		} else {
			state = DENIED;
		}	
	}

	public void verifyPin(int pinNumber) {
		if (PIN_NUMBER == pinNumber) {
			state = VALID_PIN;
		} else {
			state = DENIED;
		}	
	}

	

	public void verifyWithdrawalAmount(double withdrawalRequest) {
		if (CARD_BALANCE > withdrawalRequest) {
			state = VALID_CASH_REQUEST;
		} else {
			state = DENIED;
		}	
	}
}