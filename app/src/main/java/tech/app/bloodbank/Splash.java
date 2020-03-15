package tech.app.bloodbank;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class Splash extends AppCompatActivity {
    Handler handler;
    ImageView iv;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        iv = findViewById(R.id.splashDrop);
        tv = findViewById(R.id.splashText);
        Animation drop = AnimationUtils.loadAnimation(this,R.anim.splash_drop);
        Animation text = AnimationUtils.loadAnimation(this,R.anim.splash_text);
        iv.startAnimation(drop);
        tv.startAnimation(text);
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, Login.class);
                startActivity(intent);
                finish();
            }
        }, 2500);
    }
}
