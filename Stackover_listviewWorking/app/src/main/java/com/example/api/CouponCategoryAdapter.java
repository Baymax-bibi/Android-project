package com.example.api;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class CouponCategoryAdapter extends ArrayAdapter<CouponCategory>{

    public CouponCategoryAdapter(Context context, List<CouponCategory> couponcategory) {
        super(context, 0, couponcategory);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.coupon_list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        final CouponCategory currentCouponCategory = getItem(position);


        // Find the TextView in the earthquake_list_item.xml layout with the ID version_name
        TextView storenameTextView = (TextView) listItemView.findViewById(R.id.storename);
        storenameTextView.setText(currentCouponCategory.getStoreName());

        // Find the TextView in the earthquake_list_item.xml layout with the ID version_name
        TextView promocodeTextView = (TextView) listItemView.findViewById(R.id.promocode);
        promocodeTextView.setText(currentCouponCategory.getPromoCode());

        // Find the TextView in the earthquake_list_item.xml layout with the ID version_name
        Button descriptionTextView = (Button) listItemView.findViewById(R.id.go_to_store);
        descriptionTextView.setText(currentCouponCategory.getDescription());
        descriptionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getContext(), "ohhh", Toast.LENGTH_SHORT).show();
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(currentCouponCategory.getDescription()));
                getContext().startActivity(browserIntent);
            }
        });

//        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(goto_store));
//        context.startActivity(browserIntent);

        // Return list view
        return listItemView;
    }


}
