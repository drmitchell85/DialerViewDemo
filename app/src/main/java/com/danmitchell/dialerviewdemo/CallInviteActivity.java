package com.danmitchell.dialerviewdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class CallInviteActivity extends ModalActivity implements View.OnClickListener {
    private static final String TAG = "CallInviteActivity";

    // widgets
    private ImageButton mBtnAccept, mBtnDecline;
    private EditText mPhoneNumber;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_invite);

        initWidgets();
    }

    private void initWidgets() {
        mBtnAccept = findViewById(R.id.button_accept_call);
        mBtnAccept.setOnClickListener(this);
        mBtnDecline = findViewById(R.id.button_decline_call);
        mBtnDecline.setOnClickListener(this);
        mPhoneNumber = findViewById(R.id.phone_number);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_accept_call:
                // Launch TelephoneCallActivity
                // Intent must have flag to tell next activity to set up PSTN call for inboundcall
                Intent intent = new Intent(this, TelephoneCallActivity.class);
                startActivity(intent);
                finish();
                break;

            case R.id.button_decline_call:
                // for now just close activity
                finish();
                break;

            default:
                break;
        }
    }
}
