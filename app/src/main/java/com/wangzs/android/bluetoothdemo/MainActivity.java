package com.wangzs.android.bluetoothdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private SimpleHeadsetReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_HEADSET_PLUG);
        intentFilter.addAction(AudioManager.ACTION_AUDIO_BECOMING_NOISY);
        intentFilter.addAction(BluetoothAdapter.ACTION_STATE_CHANGED);
        intentFilter.addAction(BluetoothHeadset.ACTION_CONNECTION_STATE_CHANGED);
        intentFilter.addAction(BluetoothA2dp.ACTION_CONNECTION_STATE_CHANGED);
        intentFilter.addAction(BluetoothDevice.ACTION_ACL_CONNECTED);
        intentFilter.addAction(BluetoothDevice.ACTION_ACL_DISCONNECTED);
        if (receiver == null) {
            receiver = new SimpleHeadsetReceiver();
        }
        registerReceiver(receiver, intentFilter);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    public void startPlay(View view) {
        File file = new File(SimpleAudioManager.getApplication().getExternalCacheDir(), "auto_1111.m4a");
        SimpleAudioPlayer.getInstance().startPlay(this,file.getAbsolutePath(), new SimpleAudioPlayer.PlayCallback() {
            @Override
            public void onCompletion(Boolean success) {

            }

            @Override
            public void progress(int curr, int max) {

            }

            @Override
            public void prepare(int duration) {

            }
        }, 0);
    }

    public void stopPlay(View view) {
        SimpleAudioPlayer.getInstance().stopPlay();
    }

    public void startRecord(View view) {
        SimpleAudioRecorder.getInstance().startRecord(this, new SimpleAudioRecorder.RecordCallback() {
            @Override
            public void onStart() {

            }

            @Override
            public void onCompletion(SimpleAudioRecorder audio, String outPath) {

            }

            @Override
            public void recordingDB(double db) {

            }

            @Override
            public void recordingWatch(int second) {

            }

            @Override
            public void onError(Exception e) {

            }
        });
    }

    public void stopRecord(View view) {
        SimpleAudioRecorder.getInstance().stopRecord();
    }


}