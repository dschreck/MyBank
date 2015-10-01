package net.dcorner.dschreck.mybank;

import android.util.Log;

/**
 * Created by dschreck on 10/1/15.
 */
public class SavingsAccount extends BankAccount {
	private static final String TAG = "SavingsAccount";

	SavingsAccount() {
		mType = Type.SAVINGS;
	}

	@Override
	public void withdraw(double amount) {
		if(numberOfWithdraws() >= 3) {
			return;
		}
		super.withdraw(amount);
	}
}
