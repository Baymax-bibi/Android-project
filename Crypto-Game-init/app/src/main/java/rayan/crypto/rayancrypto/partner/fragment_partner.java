package rayan.crypto.rayancrypto.partner;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import rayan.crypto.rayancrypto.R;

import static android.content.Context.MODE_PRIVATE;

public class fragment_partner extends Fragment implements View.OnClickListener{

    TextView tv_fuse_require;
    ImageView img_close;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_partner, container, false);
        tv_fuse_require = root.findViewById(R.id.tv_fuse_require);
        img_close = root.findViewById(R.id.img_close);
        return root;
    }
    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tv_fuse_require.setOnClickListener(this);
        img_close.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_fuse_require:
                Toast.makeText(getContext(), "Your require submitted for Fuse", Toast.LENGTH_SHORT).show();
                tv_fuse_require.setText("Request sent...");
                insertBoolean(getString(R.string.FUSE_SEND), true);
                break;
            case R.id.img_close:
                getActivity().getSupportFragmentManager().popBackStack();
                break;
        }
    }

    public synchronized void insertBoolean(String key, boolean value) {
        SharedPreferences mSharedPreferences = getContext().getSharedPreferences(getString(R.string.RAYYAN_PREF), MODE_PRIVATE);
        SharedPreferences.Editor mEditor = mSharedPreferences.edit();
        mEditor.putBoolean(key, value);
        mEditor.apply();
    }
}
