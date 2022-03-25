package edu.fppi.idinner;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;


public class InitScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init_screen);
        findViewById(R.id.Splash_Main).setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN);

        findViewById(R.id.Splash_Logo).startAnimation(AnimationUtils.loadAnimation(this, R.anim.logo_anim));
        findViewById(R.id.Splash_Logo_Text).startAnimation(AnimationUtils.loadAnimation(this, R.anim.logo_text_anim));
        findViewById(R.id.Splash_Button).startAnimation(AnimationUtils.loadAnimation(this, R.anim.button_anim));

        findViewById(R.id.Splash_Button).setOnClickListener(view -> {
            ((Button) view).setTextColor(Color.WHITE);
            view.setEnabled(false);
            new Handler().postDelayed(() -> {
                startActivity(new Intent(InitScreen.this, MainActivity.class));
                overridePendingTransition(R.anim.slide_up_in, R.anim.slide_up_out);
                finish();
                ((Button) view).setTextColor(ResourcesCompat.getColor(getResources(),R.color.bg_yellow,null));
            }, 500);
        });


    }
}