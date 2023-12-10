package com.ajay.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {
    TextView txtVersion;
    ImageView imgLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        initView();
    }
//    This function finds the IDs of all views.

    private void initView() {
        imgLogo = findViewById(R.id.imgLogo);
        txtVersion = findViewById(R.id.txtVersion);

        // get  version of application
        PackageManager manager = this.getPackageManager();
        PackageInfo info;
        try {
            info = manager.getPackageInfo(this.getPackageName(), PackageManager.GET_ACTIVITIES);
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException(e);
        }
        String Version = this.getResources().getString(R.string.version) + info.versionName;
        txtVersion.setText(Version);

//        Intent handler function.
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashScreen.this, AddPlayers.class);
            startActivity(intent);
            finish();
        }, 5000);
    }
}