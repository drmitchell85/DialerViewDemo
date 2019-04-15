package com.danmitchell.dialerviewdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class TelephoneCallActivity extends AppCompatActivity implements RoomSetupFragment.RoomSetupEventListener {
    private static final String TAG = "TelephoneCallActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telephone_call);

        handleIntent();
    }

    /**
     * Convenience method to handle intent with which this activity was launched
     * Inbound call or Outbound call
     */
    private void handleIntent() {
        RoomSetupFragment fragment = new RoomSetupFragment();
        fragment.setRoomSetupEventListener(this);
        replace(fragment);
    }

    @Override
    public void startOutBoundCall() {
        Log.d(TAG, "startOutBoundCall: starting outbound call...");

        PstnCallFragment fragment = new PstnCallFragment();
        replace(fragment);
    }

    @Override
    public void onRoomSetupError() {

    }

    @Override
    public void answerInBoundCall() {

    }

    // Boilerplate code to replace a fragment
    private void replace(Fragment fragment) {
        Log.d(TAG, "replace: replacing fragment...");

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment).commitAllowingStateLoss();
    }

}
