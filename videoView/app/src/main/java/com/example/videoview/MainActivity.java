package com.example.videoview;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VideoView vview = findViewById(R.id.videoView);

        String path = "android.resources://"+getPackageName()+"/raw/video";
        String onlinePath = "https://www.youtube.com/watch?v=u64gyCdqawU";

//        Uri mainPath = Uri.parse(path);
        Uri onlinePth = Uri.parse(onlinePath);
        vview.setVideoURI(onlinePth);
        vview.start();

        MediaController mc = new MediaController(this);
        vview.setMediaController(mc);
        mc.setAnchorView(vview);

    }
}