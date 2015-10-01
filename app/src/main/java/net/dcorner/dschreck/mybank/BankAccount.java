package net.dcorner.dschreck.mybank;

import java.util.ArrayList;

/**
 * Created by dschreck on 2/17/15.
 */
abstract public class BankAccount {

	private static final String TAG = "BankAccount";

	private ArrayList<Double> mTransactions;

	public static final double OVERDRAFT_FEE = -30;

	public enum Type{
		CHECKING, SAVINGS
	}

	protected Type mType;

	BankAccount() {
		mTransactions =  new ArrayList<>();
	}


	public void withdraw(double amount) {
		// Take out the overdraft
		if(amount > 0) {
			amount = amount * -1;
		}

		mTransactions.add(amount);

		if(getBalance() < 0) {
			mTransactions.add(OVERDRAFT_FEE);
		}

	}

	public void deposit(double amount) {
		mTransactions.add(amount);
	}

	public double getBalance() {
		double total = 0;
		for(int i = 0; i < mTransactions.size(); i++) {
			total += mTransactions.get(i);
		}
		return total;
	}

	protected int numberOfWithdraws() {
		int count = 0;
		for (int i = 0; i < mTransactions.size(); i++) {
			if(mTransactions.get(i) < 0) {
				count++;
			}
		}
		return count;
	}

}
