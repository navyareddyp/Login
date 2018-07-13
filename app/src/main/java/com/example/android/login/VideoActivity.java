package com.example.android.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

    VideoView videoView;
    String MY_VIDEO = "http://www.ebookfrenzy.com/android_book/movie.mp4";

    // MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

//        videoView =(VideoView) findViewById(R.id.video_view);
//    //  mediaPlayer = MediaPlayer.create(VideoActivity.this,R.raw.song);
//    }
//    public void play(View view) {
//        boolean internet = checkinternet(); // this is the coding for checking internet connection
//        if (internet) {
//            try {
//                // Start the MediaController
//                MediaController mediacontroller = new MediaController(VideoActivity.this);
//                mediacontroller.setAnchorView(videoView);
//
//                // Get the URL from String VideoURL
//                Uri video = Uri.parse(MY_VIDEO);
//                videoView.setMediaController(mediacontroller);
//                videoView.setVideoURI(video);
//                videoView.start();
//                } catch (Exception e) {
//                Log.e("Error", e.getMessage());
//                e.printStackTrace();
//                }
//        }
//        else {
//
//            Toast.makeText(this, "Turn On Internet", Toast.LENGTH_SHORT).show();
//
//        }
//
//    }
//
//    public boolean checkinternet(){
//
//        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
//
//        return connectivityManager.getActiveNetworkInfo().isConnectedOrConnecting();
//
//    }
    }
}
