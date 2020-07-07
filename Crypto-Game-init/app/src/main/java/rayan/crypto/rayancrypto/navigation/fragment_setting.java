package rayan.crypto.rayancrypto.navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import rayan.crypto.rayancrypto.R;

public class fragment_setting extends Fragment implements View.OnClickListener{
    ToggleButton tg_mode, tg_sound;
    boolean isChecked = true;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_setting, container, false);

        tg_mode = root.findViewById(R.id.tg_mode);
        tg_sound = root.findViewById(R.id.tg_sound);
        return root;
    }
    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tg_mode.setOnClickListener(this);
        tg_sound.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tg_mode:
                Toast.makeText(getContext(), "Toggle " + isChecked, Toast.LENGTH_SHORT).show();
                isChecked = !isChecked;
        }
    }
}
