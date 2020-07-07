package rayan.crypto.rayancrypto;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import me.tankery.lib.circularseekbar.CircularSeekBar;

public class MainActivity extends AppCompatActivity {

//    ImageView imageView;
CircularSeekBar circle_bar;
    TextView tv_percent, tv_loading;
    private int pStatus = 0;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        tv_loading = findViewById(R.id.tv_loading);

        circle_bar = findViewById(R.id.circle_bar);
        tv_percent = findViewById(R.id.tv_percent);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (pStatus <= 100) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            circle_bar.setProgress(pStatus);
                            tv_percent.setText(pStatus + " %");
                        }
                    });
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    pStatus++;
                }
                Intent intent_google = new Intent(MainActivity.this, SigninActivity.class);
                startActivity(intent_google);
                finish();
            }
        }).start();
    }

}
