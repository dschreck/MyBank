package net.dcorner.dschreck.mybank;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    EditText etAmount;
    Button btnWithdraw;
    Button btnDeposit;
    TextView tvAccountBalance;
	BankAccount mCurrentAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

	    mCurrentAccount = new SavingsAccount();

	    etAmount = (EditText) findViewById(R.id.etAmount);
        btnWithdraw = (Button) findViewById(R.id.btnWithdraw);
        btnDeposit = (Button) findViewById(R.id.btnDeposit);
        tvAccountBalance = (TextView) findViewById(R.id.tvAccountBalance);

        btnWithdraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
				String amount = etAmount.getText().toString();
				mCurrentAccount.withdraw(Double.parseDouble(amount));
	            tvAccountBalance.setText("Balance is " + mCurrentAccount.getBalance());
            }
        });

        btnDeposit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
	            String amount = etAmount.getText().toString();
	            mCurrentAccount.deposit(Double.parseDouble(amount));
	            tvAccountBalance.setText("Balance is " + mCurrentAccount.getBalance());
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
