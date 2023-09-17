package com.example.thumbdownloader;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    EditText ytlink;
    Button bLoad, buttonSave;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ytlink = findViewById(R.id.ytlink);
        bLoad = findViewById(R.id.bLoad);
        buttonSave = findViewById(R.id.buttonSave);
        imageView = findViewById(R.id.imageView);

        bLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String originalLink = ytlink.getText().toString();
                String video_id = "";

                if(originalLink.contains("v="))
                {
                    video_id = originalLink.split("v=") [1];
                }
                else if (originalLink.contains("youtu.be/"))
                {
                    video_id = originalLink.split("youtu.be/") [1];
                }
                else
                {
                    video_id = originalLink;
                }

                String thLink = "https://img.youtube.com/vi/" +video_id+ "/0.jpg";
                Picasso.get().load(thLink).into(imageView);


            }
        });


    }
}