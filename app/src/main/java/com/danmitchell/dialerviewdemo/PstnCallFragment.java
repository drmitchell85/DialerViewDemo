package com.danmitchell.dialerviewdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;

public class PstnCallFragment extends Fragment implements View.OnClickListener {
    private static final String TAG = "PstnCallFragment";

    private ImageButton btnSpeaker, btnMute, btnDialpad, btnEndCall, btnAddCall, btnHoldCall;
    private DialpadView mDialpadView;
    private boolean isDialpadVisible = false;
    private Context mContext = getActivity();
    private View mView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_pstn_call, container, false);
        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initWidgets();
    }

    private void initWidgets() {
        btnSpeaker = mView.findViewById(R.id.button_speaker);
        btnSpeaker.setOnClickListener(this);

        btnMute = mView.findViewById(R.id.button_mute_self);
        btnMute.setOnClickListener(this);

        btnDialpad = mView.findViewById(R.id.button_dial_pad);
        btnDialpad.setOnClickListener(this);

        btnEndCall = mView.findViewById(R.id.button_end_call);
        btnEndCall.setOnClickListener(this);

        btnAddCall = mView.findViewById(R.id.button_add_call);
        btnAddCall.setOnClickListener(this);

        btnHoldCall = mView.findViewById(R.id.button_hold_call);
        btnHoldCall.setOnClickListener(this);

        mDialpadView = mView.findViewById(R.id.dialpad);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_speaker:
                // do thing
                break;

            case R.id.button_mute_self:
                // do thing
                break;

            case R.id.button_dial_pad:
                // do thing
                toggleKeypad();
                break;

            case R.id.button_end_call:
                // do thing
                break;

            case R.id.button_add_call:
                // do thing
                break;

            case R.id.button_hold_call:
                // do thing
                break;

        }
    }

    private void toggleKeypad() {
        if (!isDialpadVisible) {
            isDialpadVisible = true;
            Animation slideBottomUp = AnimationUtils.loadAnimation(getActivity(), R.anim.fade_in);
            mDialpadView.startAnimation(slideBottomUp);
            mDialpadView.setVisibility(View.VISIBLE);

        } else {
            isDialpadVisible = false;
            Animation slideBottomOut = AnimationUtils.loadAnimation(getActivity(), R.anim.fade_out);
            mDialpadView.startAnimation(slideBottomOut);
            mDialpadView.setVisibility(View.GONE);

        }
    }

}
