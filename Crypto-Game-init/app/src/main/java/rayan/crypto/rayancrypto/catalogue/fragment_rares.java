package rayan.crypto.rayancrypto.catalogue;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import rayan.crypto.rayancrypto.R;
import rayan.crypto.rayancrypto.adapter.character_adapter;
import rayan.crypto.rayancrypto.model.character_model;

public class fragment_rares extends Fragment implements View.OnClickListener{
    GridView gridview;
    ArrayList<character_model> arrayOfCharacters;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_catalogue_rares, container, false);
        gridview = root.findViewById(R.id.gridview);

        return root;
    }
    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        gridview = view.findViewById(R.id.gridview);
        arrayOfCharacters = new ArrayList<>();

        character_model character_param1 = new character_model();
        character_param1.setCharacter_img(R.drawable.character);
        character_param1.setCharacter_name("naruto k");
        character_param1.setCharacter_age(1);
        character_param1.setCharacter_dropping(2);
//        character_param.setCharacter_intro("this is text");
        character_param1.setCharacter_price_wod(200);
        character_param1.setCharacter_price_eth(10);

        arrayOfCharacters.add(character_param1);


        character_model character_param2 = new character_model();
        character_param2.setCharacter_img(R.drawable.coin);
        character_param2.setCharacter_name("naruto k");
        character_param2.setCharacter_age(1);
        character_param2.setCharacter_dropping(2);
//        character_param.setCharacter_intro("this is text");
        character_param2.setCharacter_price_wod(200);
        character_param2.setCharacter_price_eth(10);

        arrayOfCharacters.add(character_param2);

        character_adapter adapter = new character_adapter(getContext(), arrayOfCharacters);
        gridview.setAdapter(adapter);
    }
    @Override
    public void onClick(View v) {

    }
}