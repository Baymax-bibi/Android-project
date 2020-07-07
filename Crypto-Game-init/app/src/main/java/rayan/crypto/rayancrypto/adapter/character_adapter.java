package rayan.crypto.rayancrypto.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import rayan.crypto.rayancrypto.R;
import rayan.crypto.rayancrypto.model.character_model;

public class character_adapter extends BaseAdapter implements Filterable {

    private Context context;
    private static ArrayList<character_model> characterArrayList;
    private ArrayList<character_model> itemsFiltered;
    private ArrayList<character_model> mData;
    private ArrayList<character_model> items;
//    private ValueFilter valueFilter;


    public character_adapter(Context _context, ArrayList<character_model> _characterArrayList){
        this.context = _context;
        characterArrayList = _characterArrayList;
        itemsFiltered = _characterArrayList;
    }
    @Override
    public int getCount() {
        return characterArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return characterArrayList.get(position);
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
            convertView = inflater.inflate(R.layout.list_item_gender, null, true);
            viewHolder.character_img = convertView.findViewById(R.id.img_character);
            viewHolder.character_name = convertView.findViewById(R.id.tv_character_name);
            viewHolder.character_price_wod = convertView.findViewById(R.id.tv_character_price_wod);
            viewHolder.character_price_eth = convertView.findViewById(R.id.tv_character_price_eth);
//            viewHolder.character_age = convertView.findViewById(R.id.tv_character_age);
//            viewHolder.character_droppingTime = convertView.findViewById(R.id.tv_character_dropping);

            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.character_img.setImageResource(characterArrayList.get(position).getCharacter_img());
        viewHolder.character_name.setText(characterArrayList.get(position).getCharacter_name());
        viewHolder.character_price_wod.setText(String.valueOf(characterArrayList.get(position).getCharacter_price_wod()));
        viewHolder.character_price_eth.setText(String.valueOf(characterArrayList.get(position).getCharacter_price_eth()));
//        viewHolder.character_age.setText("Age : " + characterArrayList.get(position).getCharacter_age());
//        viewHolder.character_droppingTime.setText("Dropping : " + characterArrayList.get(position).getCharacter_dropping() + " h");

        return convertView;
    }

    private class ViewHolder {
        ImageView character_img;
        TextView character_name;
        TextView character_price_wod;
        TextView character_price_eth;
//        TextView character_age;
//        TextView character_droppingTime;
        TextView character_intro;
    }

//    public Filter getFilter() {
//        if (valueFilter == null) {
//            valueFilter = new ValueFilter();
//        }
//        return valueFilter;
//    }
//
//    private class ValueFilter extends Filter {
//        @Override
//        protected FilterResults performFiltering(CharSequence constraint) {
//            FilterResults results = new FilterResults();
//
//            if (constraint != null && constraint.length() > 0) {
//                ArrayList<character_model> filterList = new ArrayList<>();
//                for (int i = 0; i < characterArrayList.size(); i++) {
//                    if ((characterArrayList.get(i).getCharacter_name().toUpperCase()).contains(constraint.toString().toUpperCase())) {
//                        filterList.add(characterArrayList.get(i));
//                    }
//                }
//                results.count = filterList.size();
//                results.values = filterList;
//            } else {
//                results.count = characterArrayList.size();
//                results.values = characterArrayList;
//            }
//            return results;
//
//        }
//
//        @Override
//        protected void publishResults(CharSequence constraint,
//                                      FilterResults results) {
//            mData = (ArrayList<character_model>) results.values;
//            notifyDataSetChanged();
//        }
//
//    }
    @Override
    public Filter getFilter(){
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String query = charSequence.toString();

                ArrayList<character_model> filtered = new ArrayList<>();

                if (query.isEmpty()){
                    filtered = itemsFiltered;
                }else {
                    for (int i = 0; i < characterArrayList.size(); i++){
                        if (characterArrayList.get(i).getCharacter_name().toLowerCase().contains(query.toLowerCase())){
                            filtered.add(characterArrayList.get(i));
                        }
                    }
                }

                FilterResults results = new FilterResults();
                results.count = filtered.size();
                results.values = filtered;
                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                characterArrayList = (ArrayList<character_model>) results.values;
                notifyDataSetChanged();
            }
        };
    }
}
