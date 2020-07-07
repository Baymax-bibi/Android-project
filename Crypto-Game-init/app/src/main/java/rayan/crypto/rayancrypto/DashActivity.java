package rayan.crypto.rayancrypto;

import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.github.mzule.fantasyslide.SideBar;
import com.github.mzule.fantasyslide.Transformer;

import rayan.crypto.rayancrypto.bottomNavigation.fragment_catalogue;
import rayan.crypto.rayancrypto.bottomNavigation.fragment_search;
import rayan.crypto.rayancrypto.navigation.fragment_about;
import rayan.crypto.rayancrypto.navigation.fragment_characters;
import rayan.crypto.rayancrypto.navigation.fragment_faq;
import rayan.crypto.rayancrypto.navigation.fragment_home;
import rayan.crypto.rayancrypto.navigation.fragment_password;
import rayan.crypto.rayancrypto.navigation.fragment_profile;
import rayan.crypto.rayancrypto.navigation.fragment_setting;
import rayan.crypto.rayancrypto.navigation.fragment_wallet;
import rayan.crypto.rayancrypto.search.fragment_search_partner;

public class DashActivity extends AppCompatActivity implements View.OnClickListener{

    Fragment fragment;
    ImageView img_hamburger;
    private DrawerLayout drawerLayout;
    TextView tv_home, tv_character, tv_wallet, tv_profile, tv_pass, tv_setting, tv_signout, tv_faq, tv_about;
    RelativeLayout rl_catalogue,rl_search;
    CardView cv_dash_thunder, cv_dash_coin;
    static TextView tv_dash_thunder_amount;
    static TextView tv_dash_wod_amount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        fragment = new fragment_home();
        loadFragment(fragment);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        img_hamburger = findViewById(R.id.img_hamburger);
        img_hamburger.setOnClickListener(this);

        animationRocket();

        tv_home = findViewById(R.id.tv_home);
        setTextViewDrawableColor(tv_home, R.color.green_btn);
        tv_character = findViewById(R.id.tv_character);
        setTextViewDrawableColor(tv_character, R.color.green_btn);
        tv_wallet = findViewById(R.id.tv_wallet);
        setTextViewDrawableColor(tv_wallet, R.color.green_btn);
        tv_profile = findViewById(R.id.tv_profile);
        setTextViewDrawableColor(tv_profile, R.color.green_btn);
        tv_pass = findViewById(R.id.tv_pass);
        setTextViewDrawableColor(tv_pass, R.color.green_btn);
        tv_setting = findViewById(R.id.tv_setting);
        setTextViewDrawableColor(tv_setting, R.color.green_btn);
        tv_signout = findViewById(R.id.tv_signout);
        setTextViewDrawableColor(tv_signout, R.color.green_btn);
        tv_faq = findViewById(R.id.tv_faq);
        setTextViewDrawableColor(tv_faq, R.color.green_btn);
        tv_about = findViewById(R.id.tv_about);
        setTextViewDrawableColor(tv_about, R.color.green_btn);
        setTransformer();

        rl_catalogue = findViewById(R.id.rl_catalogue);
        rl_catalogue.setOnClickListener(this);
        rl_search = findViewById(R.id.rl_search);
        rl_search.setOnClickListener(this);

        cv_dash_thunder = findViewById(R.id.cv_dash_thunder);
        cv_dash_thunder.setOnClickListener(this);
        cv_dash_coin = findViewById(R.id.cv_dash_coin);
        cv_dash_coin.setOnClickListener(this);

        tv_dash_thunder_amount = findViewById(R.id.tv_dash_thunder_amount);
        tv_dash_wod_amount = findViewById(R.id.tv_dash_wod_amount);
    }
    private void setTextViewDrawableColor(TextView textView, int color) {
        for (Drawable drawable : textView.getCompoundDrawables()) {
            if (drawable != null) {
                drawable.setColorFilter(new PorterDuffColorFilter(getColor(color), PorterDuff.Mode.SRC_IN));
            }
        }
    }

    private void animationRocket() {
        Animation animRotateAclk = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_animation);
        img_hamburger.startAnimation(animRotateAclk);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.img_hamburger:
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
                break;
            case R.id.cv_dash_thunder:
                fragment = new fragment_wallet();
                break;
            case R.id.cv_dash_coin:
                fragment = new fragment_wallet();
                break;
            case R.id.tv_home:
                fragment = new fragment_home();
                break;
            case R.id.tv_character:
                fragment = new fragment_characters();
                break;
            case R.id.tv_wallet:
                fragment = new fragment_wallet();
                break;
            case R.id.tv_profile:
                fragment = new fragment_profile();
                break;
            case R.id.tv_pass:
                fragment = new fragment_password();
                break;
            case R.id.tv_setting:
                fragment = new fragment_setting();
                break;
            case R.id.tv_faq:
                fragment = new fragment_faq();
                break;
            case R.id.tv_signout:
//                System.exit(0);
                showSettingsDialog();
                break;
            case R.id.tv_about:
                fragment = new fragment_about();
                break;
            case R.id.rl_catalogue:
                fragment = new fragment_catalogue();
                break;
            case R.id.rl_search:
                fragment = new fragment_search();
                break;
        }
        loadFragment(fragment);
    }

    private void showSettingsDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(DashActivity.this);
        builder.setTitle("Warn");
        builder.setCancelable(false);
        builder.setMessage("Will you close application?");
        builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                System.exit(0);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();
    }

    private boolean loadFragment(Fragment fragment){
        if (fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fl_navigation, fragment)
                    .commit();
            return true;
        }
        return false;
    }
    private void setTransformer() {
        final float spacing = getResources().getDimensionPixelSize(R.dimen.spacing);
        SideBar rightSideBar = (SideBar) findViewById(R.id.rightSideBar);
        rightSideBar.setTransformer(new Transformer() {
            private View lastHoverView;

            @Override
            public void apply(ViewGroup sideBar, View itemView, float touchY, float slideOffset, boolean isLeft) {
                boolean hovered = itemView.isPressed();
                if (hovered && lastHoverView != itemView) {
                    animateIn(itemView);
                    animateOut(lastHoverView);
                    lastHoverView = itemView;
                }
            }

            private void animateOut(View view) {
                if (view == null) {
                    return;
                }
                ObjectAnimator translationX = ObjectAnimator.ofFloat(view, "translationX", -spacing, 0);
                translationX.setDuration(200);
                translationX.start();
            }

            private void animateIn(View view) {
                ObjectAnimator translationX = ObjectAnimator.ofFloat(view, "translationX", 0, -spacing);
                translationX.setDuration(200);
                translationX.start();
            }
        });
    }
    public void onBackPressed() {}

    public static void wod_plus(int i){
        tv_dash_wod_amount.setText(String.valueOf(i));
    }
    public static void thu_plus(int i){
        tv_dash_thunder_amount.setText(String.valueOf(i));
    }
}
