package rayan.crypto.rayancrypto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

public class ChooseCharacterActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener{
    ImageView img_hamburger_back;
    RelativeLayout rl_buy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_character);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        img_hamburger_back = findViewById(R.id.img_hamburger_back);
        img_hamburger_back.setOnClickListener(this);

        rl_buy = findViewById(R.id.rl_buy);
        rl_buy.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_hamburger_back:
                Intent intent_characterGroup = new Intent(ChooseCharacterActivity.this, ChooseCharacterGroupActivity.class);
                startActivity(intent_characterGroup);
                finish();
                break;
            case R.id.rl_buy:
                Intent intent_dash = new Intent(ChooseCharacterActivity.this, DashActivity.class);
                startActivity(intent_dash);
                finish();
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    public void onBackPressed() {}
}
