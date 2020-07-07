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
import rayan.crypto.rayancrypto.search.fragment_search_all;
import rayan.crypto.rayancrypto.search.fragment_search_partner;
import rayan.crypto.rayancrypto.search.fragment_search_sale;

public class fragment_search extends Fragment implements View.OnClickListener{
    RelativeLayout rl_sale, rl_partner, rl_all;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_search, container, false);
        rl_sale = root.findViewById(R.id.rl_sale);
        rl_partner = root.findViewById(R.id.rl_partner);
        rl_all = root.findViewById(R.id.rl_all);
        return root;
    }
    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        rl_sale.setBackgroundColor(getResources().getColor(R.color.black_overlay));
        rl_partner.setBackgroundColor(getResources().getColor(R.color.full_transparent));
        rl_all.setBackgroundColor(getResources().getColor(R.color.full_transparent));
        FragmentManager fragmentManager_sale = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction_sale = fragmentManager_sale.beginTransaction();
        fragment_search_sale fragment_sale = new fragment_search_sale();
        transaction_sale.replace(R.id.fl_search, fragment_sale);
        transaction_sale.addToBackStack(null);
        transaction_sale.commit();

        rl_sale.setOnClickListener(this);
        rl_partner.setOnClickListener(this);
        rl_all.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rl_sale:
                rl_sale.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                rl_partner.setBackgroundColor(getResources().getColor(R.color.full_transparent));
                rl_all.setBackgroundColor(getResources().getColor(R.color.full_transparent));
                FragmentManager fragmentManager_sale = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction_sale = fragmentManager_sale.beginTransaction();
                fragment_search_sale fragment_sale = new fragment_search_sale();
                transaction_sale.replace(R.id.fl_search, fragment_sale);
                transaction_sale.addToBackStack(null);
                transaction_sale.commit();
                break;
            case R.id.rl_partner:
                rl_sale.setBackgroundColor(getResources().getColor(R.color.full_transparent));
                rl_partner.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                rl_all.setBackgroundColor(getResources().getColor(R.color.full_transparent));
                FragmentManager fragmentManager_partner = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction_partner = fragmentManager_partner.beginTransaction();
                fragment_search_partner fragment_partner = new fragment_search_partner();
                transaction_partner.replace(R.id.fl_search, fragment_partner);
                transaction_partner.addToBackStack(null);
                transaction_partner.commit();
                break;
            case R.id.rl_all:
                rl_sale.setBackgroundColor(getResources().getColor(R.color.full_transparent));
                rl_partner.setBackgroundColor(getResources().getColor(R.color.full_transparent));
                rl_all.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                FragmentManager fragmentManager_all = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction_all = fragmentManager_all.beginTransaction();
                fragment_search_all fragment_all = new fragment_search_all();
                transaction_all.replace(R.id.fl_search, fragment_all);
                transaction_all.addToBackStack(null);
                transaction_all.commit();
                break;
        }
    }
}