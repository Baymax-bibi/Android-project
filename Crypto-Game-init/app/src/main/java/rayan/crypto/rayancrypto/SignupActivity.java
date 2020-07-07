package rayan.crypto.rayancrypto;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity  extends AppCompatActivity implements View.OnClickListener {

    CheckBox chk_term;
    SpannableString spannableString;
    TextView tv_to_signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        chk_term = findViewById(R.id.chk_term);
        spannableString = new SpannableString(getResources().getText(R.string.term));
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.white)), 0, 9, 0);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.dark_character_bg)), 9, spannableString.length(), 0);
        chk_term.setText(spannableString);

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
                Intent intent_signin = new Intent(SignupActivity.this, SigninActivity.class);
                startActivity(intent_signin);
                finish();
                break;
        }
    }

    public void onBackPressed() {}
}
