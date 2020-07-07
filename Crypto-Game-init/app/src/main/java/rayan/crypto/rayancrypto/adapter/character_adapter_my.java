package rayan.crypto.rayancrypto.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import rayan.crypto.rayancrypto.R;
import rayan.crypto.rayancrypto.model.character_model_my;

import static android.content.Context.MODE_PRIVATE;

public class character_adapter_my extends BaseAdapter {

    private Context context;
    public static ArrayList<character_model_my> characterArrayList_my;

    public character_adapter_my(Context _context, ArrayList<character_model_my> _characterarrayList_my){
        this.context = _context;
        characterArrayList_my = _characterarrayList_my;
    }
    @Override
    public int getCount() {
        return characterArrayList_my.size();
    }

    @Override
    public Object getItem(int position) {
        return characterArrayList_my.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            assert inflater != null;
            convertView = inflater.inflate(R.layout.list_item, null, true);
            viewHolder.img_character = convertView.findViewById(R.id.img_character);
            viewHolder.tv_character_name = convertView.findViewById(R.id.tv_character_name);
            viewHolder.tv_character_intro = convertView.findViewById(R.id.tv_character_intro);
            viewHolder.tv_character_more = convertView.findViewById(R.id.tv_character_more);
            viewHolder.tv_state = convertView.findViewById(R.id.tv_state);

            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.img_character.setImageResource(characterArrayList_my.get(position).getCharacter_img_my());
        viewHolder.tv_character_name.setText(characterArrayList_my.get(position).getCharacter_name_my());
        viewHolder.tv_character_intro.setText(characterArrayList_my.get(position).getCharacter_intro_my());
        viewHolder.tv_character_intro.setText(characterArrayList_my.get(position).getCharacter_intro_my());
        //if (getBoolean(String.valueOf(R.string.FUSE_GET))){
        if (characterArrayList_my.get(position).getFuse_get()){
            viewHolder.tv_state.setText("You received fuse request.");
        }
        if (characterArrayList_my.get(position).getFuse_send()){
            viewHolder.tv_state.setText("You sent fuse request.");
        }
       // }


        return convertView;
    }

    private class ViewHolder{
        ImageView img_character;
        TextView tv_character_name;
        TextView tv_character_intro;
        TextView tv_character_more;
        TextView tv_state;
    }


}
