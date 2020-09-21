package com.example.cattask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Details_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_);
        TextView name = (TextView) findViewById(R.id.detail_name);
        TextView describtion = (TextView) findViewById(R.id.detail_describtion);
        ImageView image = (ImageView) findViewById(R.id.detail_image);

        Intent intent = getIntent();
        String IntentName = intent.getStringExtra("name");
        String IntentDescribtion = intent.getStringExtra("describtion");
        int IntentImage = intent.getIntExtra("image",0);
        name.setText(IntentName);
        describtion.setText(IntentDescribtion);
        image.setImageResource(IntentImage);

        ImageButton imageButton = (ImageButton) findViewById(R.id.back_arrow_Activity2);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Details_Activity.this, MainActivity.class);
                startActivity(intent1);
            }
        });
    }
}