package refactoring.repace_primative_by_class_SOLUTION;

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


class ATMCardState {
	
	private final String state;
	
	public final static ATMCardState CARD_ENTERED = new ATMCardState("CARD ENTERED");
	public final static ATMCardState VALID_CARD = new ATMCardState("VALID CARD");
	public final static ATMCardState VALID_PIN = new ATMCardState("VALID PIN");
	public final static ATMCardState VALID_CASH_REQUEST = new ATMCardState("VALID CASH REQUEST");
	public final static ATMCardState DENIED = new ATMCardState("DENIED");
	
	public final static int CARD_NUMBER = 123456789;
	public final static int PIN_NUMBER = 1234;
	public final static double CARD_BALANCE = 1000.00;
	

	public ATMCardState(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}

	@Override
	public String toString() {
		return state;
	}

	
	
}

class ATMAccess {
	private ATMCardState state;
	
	public ATMAccess() {		
		state  = ATMCardState.CARD_ENTERED;		
	}
	
	
	
	public String getState() {
		return state.toString();
	}



	public void setState(ATMCardState state) {
		this.state = state;
	}

	public void ATMAccessBad() {
		setState(ATMCardState.CARD_ENTERED);
	}

	public void verifyCard(int cardNumber) {
		
		if(getState().equals(ATMCardState.CARD_ENTERED.toString())) {
			if (ATMCardState.CARD_NUMBER == cardNumber) {
				setState(ATMCardState.VALID_CARD);
			} else {
				setState(ATMCardState.DENIED);
			}	
		}
	}

	public void verifyPin(int pinNumber) {
		if(getState().equals(ATMCardState.VALID_CARD.toString())) {
			if (ATMCardState.PIN_NUMBER == pinNumber) {
				setState(ATMCardState.VALID_PIN);
			} else {
				setState( ATMCardState.DENIED);
			}
		}	
	}


	public void verifyWithdrawalAmount(double withdrawalRequest) {
		if (getState().equals(ATMCardState.VALID_PIN.toString())) {
			if(withdrawalRequest <= ATMCardState.CARD_BALANCE) {
				setState(ATMCardState.VALID_CASH_REQUEST);
			} else {
				setState(ATMCardState.DENIED);

			}
		}
	}
	

}