package com.danmitchell.dialerviewdemo;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

public class RoomSetupFragment extends Fragment {
    private static final String TAG = "RoomSetupFragment";

    private ProgressBar spinner;
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_room_setup, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initWidgets();

        attemptCall();
    }

    private void initWidgets() {
        spinner = view.findViewById(R.id.progress_bar);
    }

    private void attemptCall() {

        Log.d(TAG, "attemptCall: attempting call using listener...");

        // simulate call with delay...
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mListener.startOutBoundCall();
            }
        }, 1000);

        // mListener.startOutBoundCall();

    }

    private RoomSetupEventListener mListener;
    public interface RoomSetupEventListener {

        void startOutBoundCall();

        void onRoomSetupError();

        void answerInBoundCall();

    }

    public void setRoomSetupEventListener(RoomSetupEventListener listener) {
        mListener = listener;
    }

    // TODO add forIncoming and forOutgoing call methods

}
