package rayan.crypto.rayancrypto;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ForgetActivity  extends AppCompatActivity implements View.OnClickListener {

    TextView tv_to_signin;
    SpannableString spannableString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        tv_to_signin = findViewById(R.id.tv_to_signin);
        spannableString = new SpannableString(getResources().getText(R.string.to_signin));
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.white)), 0, 24, 0);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.dark_character_bg)), 24, spannableString.length(), 0);
        tv_to_signin.setText(spannableString);
        tv_to_signin.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_to_signin:
                Intent intent_signin = new Intent(ForgetActivity.this, SigninActivity.class);
                startActivity(intent_signin);
                finish();
                break;
        }
    }

    public void onBackPressed() {}
}
