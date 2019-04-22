package com.danmitchell.dialerviewdemo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

public class DialpadView extends LinearLayout implements View.OnClickListener {
    private static final String TAG = "DialpadView";

    private EditText mEditText;
    private ImageButton mDelete;

    public DialpadView(Context context) {
        super(context);
    }

    public DialpadView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DialpadView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        Log.d(TAG, "onFinishInflate: inflating...");
        initWidgets();

    }

    public EditText getDigits() {
        return mEditText;
    }

    public ImageButton getDeleteButton() {
        return mDelete;
    }

    // TODO add on key event listeners

    private void initWidgets() {
        Log.d(TAG, "initWidgets: initializing widgets...");

        Button mBtnOne = findViewById(R.id.button_one);
        mBtnOne.setOnClickListener(this);

        Button mBtnTwo = findViewById(R.id.button_two);
        mBtnTwo.setOnClickListener(this);

        Button mBtnThree = findViewById(R.id.button_three);
        mBtnThree.setOnClickListener(this);

        Button mBtnFour = findViewById(R.id.button_four);
        mBtnFour.setOnClickListener(this);

        Button mBtnFive = findViewById(R.id.button_five);
        mBtnFive.setOnClickListener(this);

        Button mBtnSix = findViewById(R.id.button_six);
        mBtnSix.setOnClickListener(this);

        Button mBtnSeven = findViewById(R.id.button_seven);
        mBtnSeven.setOnClickListener(this);

        Button mBtnEight = findViewById(R.id.button_eight);
        mBtnEight.setOnClickListener(this);

        Button mBtnNine = findViewById(R.id.button_nine);
        mBtnNine.setOnClickListener(this);

        Button mBtnZero = findViewById(R.id.button_zero);
        mBtnZero.setOnClickListener(this);

        Button mBtnStar = findViewById(R.id.button_star);
        mBtnStar.setOnClickListener(this);

        Button mBtnPound = findViewById(R.id.button_pound);
        mBtnPound.setOnClickListener(this);

        Button mBtnDial = findViewById(R.id.button_dial);
        mBtnDial.setOnClickListener(this);

//        Button mBtnX = findViewById(R.id.button_x);
//        mBtnX.setOnClickListener(this);

        mEditText = findViewById(R.id.edit_text_input);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_one:
                onButtonClick(mEditText, "1");
                break;

            case R.id.button_two:
                onButtonClick(mEditText, "2");
                break;

            case R.id.button_three:
                onButtonClick(mEditText, "3");
                break;

            case R.id.button_four:
                onButtonClick(mEditText, "4");
                break;

            case R.id.button_five:
                onButtonClick(mEditText, "5");
                break;

            case R.id.button_six:
                onButtonClick(mEditText, "6");
                break;

            case R.id.button_seven:
                onButtonClick(mEditText, "7");
                break;

            case R.id.button_eight:
                onButtonClick(mEditText, "8");
                break;

            case R.id.button_nine:
                onButtonClick(mEditText, "9");
                break;

            case R.id.button_zero:
                onButtonClick(mEditText, "0");
                break;

            case R.id.button_star:
                onButtonClick(mEditText, "*");
                break;

            case R.id.button_pound:
                onButtonClick(mEditText, "#");
                break;

            case R.id.button_dial:
                // dial number
                mListener.startDial();

                break;

//            case R.id.button_x:
//                // delete text
//                mEditText.setText("");
//                break;
        }
    }

    private void onButtonClick(EditText inputNumber, String number) {
        String cache = mEditText.getText().toString();
        inputNumber.setText(cache + number);
    }

    private DialpadViewEventListener mListener;

    public void setDialpadViewEventListener(DialpadViewEventListener listener) {
        mListener = listener;
    }

    public interface DialpadViewEventListener {
        void startDial();
    }

}
