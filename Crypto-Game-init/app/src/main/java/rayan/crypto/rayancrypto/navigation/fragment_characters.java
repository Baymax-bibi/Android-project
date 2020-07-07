package rayan.crypto.rayancrypto.navigation;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

import rayan.crypto.rayancrypto.R;
import rayan.crypto.rayancrypto.adapter.character_adapter_my;
import rayan.crypto.rayancrypto.bottomNavigation.fragment_search;
import rayan.crypto.rayancrypto.fuse.fragment_fuse;
import rayan.crypto.rayancrypto.model.character_model_my;
import rayan.crypto.rayancrypto.sale.fragment_sale;
import rayan.crypto.rayancrypto.search.fragment_search_partner;
import rayan.crypto.rayancrypto.search.fragment_search_sale;

import static android.content.Context.MODE_PRIVATE;

public class fragment_characters extends Fragment implements AdapterView.OnItemClickListener {

    ListView lv_myCharacter;
    ArrayList<character_model_my> arrayOfCharacter_my;
    Fragment fragment;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_characters, container, false);

        lv_myCharacter = root.findViewById(R.id.lv_myCharacter);
        return root;
    }
    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        arrayOfCharacter_my = new ArrayList<>();

        character_model_my character_param_1 = new character_model_my();

        character_param_1.setCharacter_img_my(R.drawable.character);
        character_param_1.setCharacter_name_my("my chakura");
        character_param_1.setCharacter_intro_my("this is own character intro");
        character_param_1.setFuse_get(true);
        character_param_1.setFuse_send(false);
        arrayOfCharacter_my.add(character_param_1);

        character_model_my character_param_2 = new character_model_my();

        character_param_2.setCharacter_img_my(R.drawable.character);
        character_param_2.setCharacter_name_my("my chakura 1");
        character_param_2.setCharacter_intro_my("this is own character intro 1");
        character_param_2.setFuse_get(false);
        character_param_2.setFuse_send(true);
        arrayOfCharacter_my.add(character_param_2);

        character_adapter_my adapter_my = new character_adapter_my(getContext(), arrayOfCharacter_my);
        lv_myCharacter.setAdapter(adapter_my);
        lv_myCharacter.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getContext(), "Clicked " + position, Toast.LENGTH_SHORT).show();

        final Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.dialog_template);
        dialog.setTitle("Detail");

        ImageView img_close = (ImageView) dialog.findViewById(R.id.img_close);
        img_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        TextView tv_fuse = dialog.findViewById(R.id.tv_fuse);
        if (getBoolean(getString(R.string.FUSE_SEND))){
            tv_fuse.setText(getString(R.string.SENT));
        }else {
            tv_fuse.setText(getString(R.string.FIND_PARTNER));
        }
        tv_fuse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getBoolean(getString(R.string.FUSE_SEND))){
                    fragment = new fragment_fuse();
                    loadFragment(fragment);
                    dialog.dismiss();
                }else {
                    fragment = new fragment_search();
                    loadFragment(fragment);
                    dialog.dismiss();
                }
            }
        });

        TextView tv_sell = dialog.findViewById(R.id.tv_sell);

        tv_sell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (getBoolean(getString(R.string.AUCTION))){
//                    Toast.makeText(getContext(), "This Character is on Auction", Toast.LENGTH_SHORT).show();
//                }else {
                    fragment = new fragment_sale();
                    loadFragment(fragment);
                    dialog.dismiss();
//                }
            }
        });
        dialog.setCancelable(false);
        dialog.show();

        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(dialog.getWindow().getAttributes());
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT;
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setAttributes(layoutParams);
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


    public synchronized boolean getBoolean(String key) {
        SharedPreferences mSharedPreferences = getContext().getSharedPreferences(getString(R.string.RAYYAN_PREF), MODE_PRIVATE);
        Boolean  selected =  mSharedPreferences.getBoolean(key, false);
        return selected;
    }
}
