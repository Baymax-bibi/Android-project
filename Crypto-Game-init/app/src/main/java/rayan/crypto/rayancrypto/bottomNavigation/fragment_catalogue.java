package rayan.crypto.rayancrypto.bottomNavigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import rayan.crypto.rayancrypto.R;
import rayan.crypto.rayancrypto.catalogue.fragment_common;
import rayan.crypto.rayancrypto.catalogue.fragment_mystery;
import rayan.crypto.rayancrypto.catalogue.fragment_rares;
import rayan.crypto.rayancrypto.catalogue.fragment_shifter;
import rayan.crypto.rayancrypto.catalogue.fragment_ultra;

public class fragment_catalogue extends Fragment implements View.OnClickListener{

    RelativeLayout rl_common, rl_rares, rl_ultra, rl_shifter, rl_mystery;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_catalogue, container, false);
        rl_common = root.findViewById(R.id.rl_common);
        rl_rares = root.findViewById(R.id.rl_rares);
        rl_ultra = root.findViewById(R.id.rl_ultra);
        rl_shifter = root.findViewById(R.id.rl_shifter);
        rl_mystery = root.findViewById(R.id.rl_mystery);
        return root;
    }
    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FragmentManager fragmentManager_common;
        FragmentTransaction transaction_common;
        fragmentManager_common = getActivity().getSupportFragmentManager();
        transaction_common = fragmentManager_common.beginTransaction();
        fragment_common fragment_common = new fragment_common();
        transaction_common.replace(R.id.fl_catalogue, fragment_common);
        transaction_common.addToBackStack(null);
        transaction_common.commit();

        rl_common.setOnClickListener(this);
        rl_rares.setOnClickListener(this);
        rl_ultra.setOnClickListener(this);
        rl_shifter.setOnClickListener(this);
        rl_mystery.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rl_common:
                FragmentManager fragmentManager_common;
                FragmentTransaction transaction_common;
                fragmentManager_common = getActivity().getSupportFragmentManager();
                transaction_common = fragmentManager_common.beginTransaction();
                fragment_common fragment_common = new fragment_common();
                transaction_common.replace(R.id.fl_catalogue, fragment_common);
                transaction_common.addToBackStack(null);
                transaction_common.commit();
                break;
            case R.id.rl_rares:
                FragmentManager fragmentManager_rares;
                FragmentTransaction transaction_rares;
                fragmentManager_rares = getActivity().getSupportFragmentManager();
                transaction_rares = fragmentManager_rares.beginTransaction();
                fragment_rares fragment_rares = new fragment_rares();
                transaction_rares.replace(R.id.fl_catalogue, fragment_rares);
                transaction_rares.addToBackStack(null);
                transaction_rares.commit();
                break;
            case R.id.rl_ultra:
                FragmentManager fragmentManager_ultra  = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction_ultra = fragmentManager_ultra.beginTransaction();
                fragment_ultra fragment_ultra = new fragment_ultra();
                transaction_ultra.replace(R.id.fl_catalogue, fragment_ultra);
                transaction_ultra.addToBackStack(null);
                transaction_ultra.commit();
                break;
            case R.id.rl_shifter:
                FragmentManager fragmentManager_shifter  = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction_shifter = fragmentManager_shifter.beginTransaction();
                fragment_shifter fragment_shifter = new fragment_shifter();
                transaction_shifter.replace(R.id.fl_catalogue, fragment_shifter);
                transaction_shifter.addToBackStack(null);
                transaction_shifter.commit();
                break;
            case R.id.rl_mystery:
                FragmentManager fragmentManager_mystery  = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction_mystery = fragmentManager_mystery.beginTransaction();
                fragment_mystery fragment_mystery = new fragment_mystery();
                transaction_mystery.replace(R.id.fl_catalogue, fragment_mystery);
                transaction_mystery.addToBackStack(null);
                transaction_mystery.commit();
                break;
        }
    }
}