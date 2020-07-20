package com.example.api;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    public static void main(String []args) throws IOException{
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("https://api")
                .method("POST", body)
                .addHeader("base64_header", "NmE5NDgyMGVmZGM4NWNjNDVmNjdmNzhiNjM4ZmVkOjc4OTMwNzJiOWMyMTYwOWQyZjNjZTUyN2Q1YzE4MA==")
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create a fake list of earthquakes.
        ArrayList<CouponCategory> couponcategory = CouponUtils.extractCouponcategory();

        // Find a reference to the {@link ListView} in the layout
        ListView couponcategoryListView = (ListView) findViewById(R.id.list);


        // Create a new {@link ArrayAdapter} of earthquakes
        CouponCategoryAdapter adapter = new CouponCategoryAdapter(this, couponcategory);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        couponcategoryListView.setAdapter(adapter);

//        couponcategoryListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, final View view,
//                                    int position, long id) {
//                final String item = (String) parent.getItemAtPosition(position);
////                view.animate().setDuration(2000).alpha(0)
////                        .withEndAction(new Runnable() {
////                            @Override
////                            public void run() {
////                                list.remove(item);
////                                adapter.notifyDataSetChanged();
////                                view.setAlpha(1);
////                            }
////                        });
//            }
//
//        });
    }

}