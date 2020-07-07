package rayan.crypto.rayancrypto;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ChooseCharacterGroupActivity extends AppCompatActivity implements View.OnClickListener{

    TextView btn_character_1;
    Button btn_home;
    TextView tv_to_signin;
    SpannableString spannableString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_character_group);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btn_character_1 = findViewById(R.id.btn_character_1);
        btn_character_1.setOnClickListener(this);

        btn_home = findViewById(R.id.btn_home);
        btn_home.setOnClickListener(this);

        tv_to_signin = findViewById(R.id.tv_to_signin);
        spannableString = new SpannableString(getResources().getText(R.string.back_to_signin));
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.white)), 0, 5, 0);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.dark_character_bg)), 5, spannableString.length(), 0);
        tv_to_signin.setText(spannableString);
        tv_to_signin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_character_1:
                Intent intent_chooseOne = new Intent(ChooseCharacterGroupActivity.this, ChooseCharacterActivity.class);
                startActivity(intent_chooseOne);
                finish();
                break;
            case R.id.btn_home:
                Intent intent_home = new Intent(ChooseCharacterGroupActivity.this, DashActivity.class);
                startActivity(intent_home);
                finish();
                break;
            case R.id.tv_to_signin:
                Intent intent_signin = new Intent(ChooseCharacterGroupActivity.this, SigninActivity.class);
                startActivity(intent_signin);
                finish();
                break;

        }
    }

    public void onBackPressed() {}
}
