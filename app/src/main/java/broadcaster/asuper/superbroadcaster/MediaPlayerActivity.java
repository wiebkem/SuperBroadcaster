package broadcaster.asuper.superbroadcaster;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.SeekBar;

public class MediaPlayerActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private double timeElapsed = 0, finalTime = 0;
    private int forwardTime = 30000, backwardTime= 30000;
    private Handler durationHandler= new Handler();
    private SeekBar seekbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);

        // create the mediaplayer
        mediaPlayer = MediaPlayer.create(this, R.raw.peterpanch1);
        // set the seekbar details
        finalTime = mediaPlayer.getDuration();
        seekbar = findViewById(R.id.seekBar);
        seekbar.setMax((int) finalTime);
        seekbar.setClickable(false);

        RelativeLayout unsharedSnippetLayout = findViewById(R.id.mediaPlayerLayout);
        unsharedSnippetLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MediaPlayerActivity.this, BeforeCreateSnippetActivity.class);
                startActivity(myIntent);
            }
        });

        final ImageButton playPauseButton = findViewById(R.id.playPauseButton);
        playPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    pauseAudioBook();
                    playPauseButton.setImageResource(R.drawable.pause);
                } else {
                    playAudioBook();
                    playPauseButton.setImageResource(R.drawable.playing);
                }
            }
        });

        ImageButton forwardButton = findViewById(R.id.forwardButton);
        forwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forwardMediaPlayer();
            }
        });

        ImageButton backwardButton = findViewById(R.id.backwardButton);
        backwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backwardMediaPlayer();
            }
        });
    }

    private void playAudioBook() {
        mediaPlayer.start();

        timeElapsed = mediaPlayer.getCurrentPosition();
        seekbar.setProgress((int) timeElapsed);

        durationHandler.postDelayed(updateSeekBarTime, 100);
    }

    private void pauseAudioBook(){
        mediaPlayer.pause();
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

    private void forwardMediaPlayer() {
       if((timeElapsed + forwardTime) <= finalTime){
           timeElapsed= timeElapsed - backwardTime;
           mediaPlayer.seekTo((int) timeElapsed);
       }
    }

    private void backwardMediaPlayer() {
        // TODO
    }
}
