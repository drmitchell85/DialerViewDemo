package com.danmitchell.dialerviewdemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DialerTestFragment extends Fragment {
    //implements View.OnClickListener

    private static final String TAG = "DialerTestFragment";
    private EditText mEditText;
    private View view;

    private Handler mHandler;

    // DialpadView
    private DialpadView mDialpadView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_dialer_test, container, false);
        Log.d(TAG, "onCreateView: called...");

        setupDialpadView();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "onViewCreated: called...");
        // initWidgets();

    }

    // DialpadView support
    private void setupDialpadView() {
        Log.d(TAG, "setupDialpadView: setting up dialpad view...");
        view.buildLayer();
        mDialpadView = view.findViewById(R.id.view_dialpad_test);


    }


    private void initWidgets() {
        Log.d(TAG, "initWidgets: initializing widgets...");

//        Button mBtnOne = view.findViewById(R.id.button_one);
//        mBtnOne.setOnClickListener(this);
//
//        Button mBtnTwo = view.findViewById(R.id.button_two);
//        mBtnTwo.setOnClickListener(this);
//
//        Button mBtnThree = view.findViewById(R.id.button_three);
//        mBtnThree.setOnClickListener(this);
//
//        Button mBtnFour = view.findViewById(R.id.button_four);
//        mBtnFour.setOnClickListener(this);
//
//        Button mBtnFive = view.findViewById(R.id.button_five);
//        mBtnFive.setOnClickListener(this);
//
//        Button mBtnSix = view.findViewById(R.id.button_six);
//        mBtnSix.setOnClickListener(this);
//
//        Button mBtnSeven = view.findViewById(R.id.button_seven);
//        mBtnSeven.setOnClickListener(this);
//
//        Button mBtnEight = view.findViewById(R.id.button_eight);
//        mBtnEight.setOnClickListener(this);
//
//        Button mBtnNine = view.findViewById(R.id.button_nine);
//        mBtnNine.setOnClickListener(this);
//
//        Button mBtnZero = view.findViewById(R.id.button_zero);
//        mBtnZero.setOnClickListener(this);
//
//        Button mBtnStar = view.findViewById(R.id.button_star);
//        mBtnStar.setOnClickListener(this);
//
//        Button mBtnPound = view.findViewById(R.id.button_pound);
//        mBtnPound.setOnClickListener(this);
//
//        Button mBtnDial = view.findViewById(R.id.button_dial);
//        mBtnDial.setOnClickListener(this);
//
//        Button mBtnX = view.findViewById(R.id.button_x);
//        mBtnX.setOnClickListener(this);
//
//        mEditText = view.findViewById(R.id.edit_text_input);
    }

//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.button_one:
//                onButtonClick(mEditText, "1");
//                break;
//
//            case R.id.button_two:
//                onButtonClick(mEditText, "2");
//                break;
//
//            case R.id.button_three:
//                onButtonClick(mEditText, "3");
//                break;
//
//            case R.id.button_four:
//                onButtonClick(mEditText, "4");
//                break;
//
//            case R.id.button_five:
//                onButtonClick(mEditText, "5");
//                break;
//
//            case R.id.button_six:
//                onButtonClick(mEditText, "6");
//                break;
//
//            case R.id.button_seven:
//                onButtonClick(mEditText, "7");
//                break;
//
//            case R.id.button_eight:
//                onButtonClick(mEditText, "8");
//                break;
//
//            case R.id.button_nine:
//                onButtonClick(mEditText, "9");
//                break;
//
//            case R.id.button_zero:
//                onButtonClick(mEditText, "0");
//                break;
//
//            case R.id.button_star:
//                onButtonClick(mEditText, "*");
//                break;
//
//            case R.id.button_pound:
//                onButtonClick(mEditText, "#");
//                break;
//
//            case R.id.button_dial:
//                // dial number
//                //dial();
//
//                // open TelephoneActivity
//                startTelephoneCallActivity();
//
//                break;
//
//            case R.id.button_x:
//                // delete text
//                mEditText.setText("");
//                break;
//        }
//    }

    private void onButtonClick(EditText inputNumber, String number) {
        String cache = mEditText.getText().toString();
        inputNumber.setText(cache + number);
    }

    private void dial() {
        if (mEditText.getText().length() <= 3) {
            Toast.makeText(getContext(), "Please enter a valid number", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(Intent.ACTION_DIAL);

            String hash = mEditText.getText().toString();
            if (hash.contains("#")) {
                hash.replace("#", "$23");
            }
            intent.setData(Uri.parse("tel:" + hash));

            // if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager)

            startActivity(intent);
        }
    }

    private void startTelephoneCallActivity() {
        // This will be our intended intent
        Intent intent = new Intent(getActivity(), TelephoneCallActivity.class);

        // Test intent to check CallInviteActivity is working fine
//         Intent intent = new Intent(getActivity(), CallInviteActivity.class);

        startActivity(intent);

    }

}
