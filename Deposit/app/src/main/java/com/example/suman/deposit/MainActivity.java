package com.example.suman.deposit;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {
EditText deposit;
TextView tvdeposit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        deposit = (EditText) findViewById(R.id.deposit);
        tvdeposit = (TextView) findViewById(R.id.tvdeposit);
        tvdeposit.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        String depamt=deposit.getText().toString();
        Intent depact=new Intent(MainActivity.this,TransferActivity.class);
         depact.putExtra("depamt",depamt);
        startActivityForResult(depact,1001);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1001 && resultCode==1002);
        {
            Bundle b=data.getExtras();
            int nbal= b.getInt("nbal");
            deposit.setText("" +nbal);
        }
    }
}

