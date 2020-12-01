package com.example.comfy.Explore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.comfy.R;

public class explore_detailactivity extends AppCompatActivity {

    TextView detail_title;
    TextView detail_description;
    TextView detail_price;
    ImageView detail_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.explore_detail_activity);

        detail_description=(TextView)findViewById(R.id.detail_description);
        detail_title=(TextView)findViewById(R.id.detail_title);
        detail_image=(ImageView)findViewById(R.id.detail_image);
        detail_price=(TextView)findViewById(R.id.detail_price);

        Bundle pBundle = getIntent().getExtras();

        if(pBundle!=null)
        {
            detail_title.setText(pBundle.getString("Title"));
            detail_price.setText(pBundle.getString("Price"));
            detail_description.setText(pBundle.getString("Description"));
            detail_image.setImageResource(pBundle.getInt("Image"));
        }
    }
}
