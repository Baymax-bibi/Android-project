package rayan.crypto.rayancrypto.sale;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.SyncStateContract;
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

public class fragment_sale  extends Fragment implements View.OnClickListener{
    ImageView img_close;
    TextView tv_sell;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_sale, container, false);

        img_close = root.findViewById(R.id.img_close);
        tv_sell = root.findViewById(R.id.tv_sell);
        return root;
    }
    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        img_close.setOnClickListener(this);
        tv_sell.setOnClickListener(this);
    }
        @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_close:
                getActivity().getSupportFragmentManager().popBackStack();
                break;
            case R.id.tv_sell:
                Toast.makeText(getContext(), "Its going Auction", Toast.LENGTH_SHORT).show();
                insertBoolean(getString(R.string.AUCTION), true);
        }
    }

    public synchronized void insertBoolean(String key, boolean value) {
        SharedPreferences mSharedPreferences = getContext().getSharedPreferences(getString(R.string.RAYYAN_PREF), MODE_PRIVATE);
        SharedPreferences.Editor mEditor = mSharedPreferences.edit();
        mEditor.putBoolean(key, value);
        mEditor.apply();
    }
}
