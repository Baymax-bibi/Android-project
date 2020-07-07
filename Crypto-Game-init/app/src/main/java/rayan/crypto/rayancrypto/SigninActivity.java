package rayan.crypto.rayancrypto;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SigninActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_signin;
    TextView tv_to_register;
    static SpannableString spannableString;
    TextView tv_forgetpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_login);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btn_signin = findViewById(R.id.btn_signin);
        btn_signin.setOnClickListener(this);

        tv_to_register = findViewById(R.id.tv_to_register);
        tv_to_register.setOnClickListener(this);

        tv_forgetpass = findViewById(R.id.tv_forgetpass);
        tv_forgetpass.setOnClickListener(this);

        spannableString = new SpannableString(getResources().getText(R.string.to_signup));
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.white)), 0, 22, 0);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.dark_character_bg)), 22, spannableString.length(), 0);
        tv_to_register.setText(spannableString);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_signin:
                Intent intent_chooseGroup = new Intent(SigninActivity.this, ChooseCharacterGroupActivity.class);
                startActivity(intent_chooseGroup);
                finish();
                break;
            case R.id.tv_to_register:
                Intent intent_signup = new Intent(SigninActivity.this, SignupActivity.class);
                startActivity(intent_signup);
                finish();
                break;
            case R.id.tv_forgetpass:
                Intent intent_forgetpass = new Intent(SigninActivity.this, ForgetActivity.class);
                startActivity(intent_forgetpass);
                finish();
                break;
        }
    }

    public void onBackPressed() {}
}