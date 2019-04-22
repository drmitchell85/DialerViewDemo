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

public class DialerTestFragment extends Fragment implements DialpadView.DialpadViewEventListener {
    //implements View.OnClickListener

    private static final String TAG = "DialerTestFragment";
    private EditText mEditText;
    private View view;

    private Handler mHandler;

    // DialpadView
    private DialpadView mDialpadView;

    private boolean isDebug = false;

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
        mDialpadView.setDialpadViewEventListener(this);


    }

    @Override
    public void startDial() {
        if (isDebug) {
            debugUseAndroidDialer();
        }

        Intent intent = new Intent(getActivity(), TelephoneCallActivity.class);
        startActivity(intent);
    }

    private void debugUseAndroidDialer() {
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
}
