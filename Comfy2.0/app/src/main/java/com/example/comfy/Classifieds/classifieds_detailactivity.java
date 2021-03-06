package com.example.comfy.Classifieds;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.comfy.R;

public class classifieds_detailactivity extends AppCompatActivity {

    TextView detail_Title;
    TextView detail_description;
    ImageView detail_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ads_detail_activity);

        detail_Title=(TextView)findViewById(R.id.ads_detail_title);
        detail_description=(TextView)findViewById(R.id.ads_detail_description);
        detail_image=(ImageView)findViewById(R.id.ads_detail_image);

        detail_description.setMovementMethod(new ScrollingMovementMethod());

        Bundle pBundle = getIntent().getExtras();

        if(pBundle!=null)
        {
            detail_Title.setText(pBundle.getString("Title"));
            detail_description.setText(pBundle.getString("Description"));
            detail_image.setImageResource(pBundle.getInt("Image"));
        }
    }
}
