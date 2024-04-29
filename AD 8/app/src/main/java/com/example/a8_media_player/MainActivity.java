package com.example.a8_media_player;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaplay=null;
    }
    public void Music(View view) {
        switch (view.getId()){
            case R.id.Playbtn:
                if(mediaplay==null){
                    mediaplay = MediaPlayer.create(this,R.raw.satranga);
                }
                mediaplay.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                  @Override
                  public void onCompletion(MediaPlayer mediaPlayer) {
                      stopMusic();
                  }
              });
                mediaplay.start();
                break;
            case R.id.Pausebtn:
                if(mediaplay != null)
                    mediaplay.pause();
                break;
            case R.id.Stopbtn:
                if(mediaplay != null){
                    mediaplay.stop();
                    stopMusic();
                }
                break;
        }
    }
    private void stopMusic() {
        mediaplay.release();
        mediaplay=null;
    }
    @Override
    protected void onStop() {
        super.onStop();
        stopMusic();
    }
}
