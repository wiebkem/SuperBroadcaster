package broadcaster.asuper.superbroadcaster;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class MediaPlayerActivity extends AppCompatActivity {
    Button button;
    private MediaPlayer mediaPlayer;
    public TextView songName, songDetail1, songDetail2;
    private double timeElapsed = 0, finalTime = 0;
    private int forwardTime = 2000, backwardTime= 2000;
    private Handler durationHandler= new Handler();
    private SeekBar seekbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);
        button = (Button)findViewById(R.id.button);
            button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BeforeCreateSnippetActivity.class);
                startActivity(intent);
            }
        });

          initializeViews();

    }

    public void initializeViews(){
        songName= findViewById(R.id.songName);
        mediaPlayer= MediaPlayer.create(this, R.raw.peterpanch1);
        finalTime = mediaPlayer.getDuration();
        songDetail1= findViewById(R.id. songDetail1);
        songDetail2= findViewById(R.id. songDetail2);
        seekbar= findViewById(R.id.seekBar3);
        songName.setText("A Game of Thrones");
        songDetail1.setText("Book1 of A Song of Ice and Fire");
        songDetail2.setText("Chapter 3");
        seekbar.setMax((int) finalTime);
        seekbar.setClickable(false);


    }

    public void play (View view){
        mediaPlayer.start();
        timeElapsed= mediaPlayer.getCurrentPosition();
        seekbar.setProgress((int) timeElapsed);
        durationHandler.postDelayed(updateSeekBarTime, 100);
    }
    private Runnable updateSeekBarTime = new Runnable() {
        @Override
        public void run() {
            timeElapsed = mediaPlayer.getCurrentPosition();
            seekbar.setProgress((int) timeElapsed);
            double timeRemaining = finalTime - timeElapsed;
            durationHandler.postDelayed(this,100);
        }
    };
   public void pause (View view){
       mediaPlayer.pause();
   }

   public void forward (View view){
       if((timeElapsed + forwardTime) <= finalTime){
           timeElapsed= timeElapsed - backwardTime;
           mediaPlayer.seekTo((int) timeElapsed);
       }
   }
}
