package rayan.crypto.rayancrypto.navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import rayan.crypto.rayancrypto.DashActivity;
import rayan.crypto.rayancrypto.R;
import rayan.crypto.rayancrypto.cart.fragment_cart;

public class fragment_wallet  extends Fragment implements View.OnClickListener{

    TextView tv_thu_price, tv_wod_price;
    RelativeLayout rl_wod_1, rl_wod_2, rl_wod_3, rl_wod_4, rl_thu_1, rl_thu_2, rl_thu_3, rl_thu_4;
    LinearLayout ly_clear, ly_cart;
    int thu, wod;
    Fragment fragment;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_wallet, container, false);

        tv_thu_price = root.findViewById(R.id.tv_thu_price);
        tv_wod_price = root.findViewById(R.id.tv_wod_price);
        rl_wod_1 = root.findViewById(R.id.rl_wod_1);
        rl_wod_2 = root.findViewById(R.id.rl_wod_2);
        rl_wod_3 = root.findViewById(R.id.rl_wod_3);
        rl_wod_4 = root.findViewById(R.id.rl_wod_4);
        rl_thu_1 = root.findViewById(R.id.rl_thu_1);
        rl_thu_2 = root.findViewById(R.id.rl_thu_2);
        rl_thu_3 = root.findViewById(R.id.rl_thu_3);
        rl_thu_4 = root.findViewById(R.id.rl_thu_4);

        ly_clear = root.findViewById(R.id.ly_clear);
        ly_cart = root.findViewById(R.id.ly_cart);

        rl_wod_1.setOnClickListener(this);
        rl_wod_2.setOnClickListener(this);
        rl_wod_3.setOnClickListener(this);
        rl_wod_4.setOnClickListener(this);
        rl_thu_1.setOnClickListener(this);
        rl_thu_2.setOnClickListener(this);
        rl_thu_3.setOnClickListener(this);
        rl_thu_4.setOnClickListener(this);

        ly_clear.setOnClickListener(this);
        ly_cart.setOnClickListener(this);

        return root;
    }
    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rl_wod_1:
                wod = calcul_wod(50);
                tv_wod_price.setText(String.valueOf(wod));
//                DashActivity.wod_plus(wod);
                break;
            case R.id.rl_wod_2:
                wod = calcul_wod(500);
                tv_wod_price.setText(String.valueOf(wod));
//                DashActivity.wod_plus(wod);
                break;
            case R.id.rl_wod_3:
                wod = calcul_wod(1000);
                tv_wod_price.setText(String.valueOf(wod));
//                DashActivity.wod_plus(wod);
                break;
            case R.id.rl_wod_4:
                wod = calcul_wod(3000);
                tv_wod_price.setText(String.valueOf(wod));
//                DashActivity.wod_plus(wod);
                break;
            case R.id.rl_thu_1:
                thu = calcul_thu(50);
                tv_thu_price.setText(String.valueOf(thu));
//                DashActivity.thu_plus(thu);
                break;
            case R.id.rl_thu_2:
                thu = calcul_thu(500);
                tv_thu_price.setText(String.valueOf(thu));
//                DashActivity.thu_plus(thu);
                break;
            case R.id.rl_thu_3:
                thu = calcul_thu(1000);
                tv_thu_price.setText(String.valueOf(thu));
//                DashActivity.thu_plus(thu);
                break;
            case R.id.rl_thu_4:
                thu = calcul_thu(3000);
                tv_thu_price.setText(String.valueOf(thu));
//                DashActivity.thu_plus(thu);
                break;
            case R.id.ly_clear:
                tv_wod_price.setText(String.valueOf(0));
                tv_thu_price.setText(String.valueOf(0));
//                DashActivity.thu_plus(thu);
                break;
            case R.id.ly_cart:
                fragment = new fragment_cart();
                loadFragment(fragment);
//                DashActivity.thu_plus(thu);
                break;
        }
    }

    private int calcul_thu(int i) {
        return Integer.parseInt(tv_thu_price.getText().toString()) + i;
    }

    private int calcul_wod(int i) {
        return Integer.parseInt(tv_wod_price.getText().toString()) + i;
    }

    private boolean loadFragment(Fragment fragment){
        if (fragment != null){
            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fl_navigation, fragment)
                    .addToBackStack(null)
                    .commit();
            return true;
        }
        return false;
    }

}
