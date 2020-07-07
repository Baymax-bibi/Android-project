package rayan.crypto.rayancrypto.fuse;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import pl.droidsonroids.gif.GifImageView;
import rayan.crypto.rayancrypto.R;

public class fragment_fuse extends Fragment implements View.OnClickListener , Animation.AnimationListener{

    RelativeLayout rl_curtain;
    Button btn_private_time;
    Animation animationslide;
    GifImageView gif_heart;
    ImageView img_egg;
    LinearLayout ly_left_time;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_fuse, container, false);

        rl_curtain = root.findViewById(R.id.rl_curtain);
        btn_private_time = root.findViewById(R.id.btn_private_time);
        gif_heart = root.findViewById(R.id.gif_heart);
        img_egg = root.findViewById(R.id.img_egg);
        ly_left_time = root.findViewById(R.id.ly_left_time);
        return root;
    }
    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btn_private_time.setOnClickListener(this);
        animationslide = AnimationUtils.loadAnimation(getContext(), R.anim.slide_left_right);
        animationslide.setAnimationListener(this);

        ly_left_time.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_private_time:
                gif_heart.setVisibility(View.VISIBLE);
                rl_curtain.setVisibility(View.VISIBLE);
                rl_curtain.setAnimation(animationslide);

                break;
            case R.id.ly_left_time:
                img_egg.setVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
