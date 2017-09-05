package com.example.suman.deposit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by suman on 2/8/2017.
 */
public class TransferActivity  extends Activity implements View.OnClickListener {
    String depamt;
    EditText deposit,transfer;
    TextView tvtransfer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);
        deposit= (EditText) findViewById(R.id.deposit);
        transfer= (EditText) findViewById(R.id.transfer);
        tvtransfer= (TextView) findViewById(R.id.tvtransfer);
        savedInstanceState=getIntent().getExtras();
  depamt = savedInstanceState.getString("depamt");

deposit.setText(depamt);
        tvtransfer.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int damt=Integer.parseInt(deposit.getText().toString());
        int tamt=Integer.parseInt(transfer.getText().toString());
        int netbal=damt-tamt;
        Intent i=new Intent();
        i.putExtra("nbal",netbal);
        setResult(1002,i);
        finish();


    }
}
