package broadcaster.asuper.superbroadcaster;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;

public class MediaPlayerActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private double timeElapsed = 0, finalTime = 0;
    private Handler durationHandler= new Handler();
    private SeekBar seekbar;

    // jumping 30 seconds
    private int forwardTime = 30000, backwardTime= 30000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);

        // create the mediaplayer
        mediaPlayer = MediaPlayer.create(this, R.raw.peterpanch1);
        // set the seekbar details
        finalTime = mediaPlayer.getDuration();
        Log.d("mediaPlayer", "final time for the media player: " + finalTime);
        seekbar = findViewById(R.id.seekBar);
        seekbar.setMax((int) finalTime);
        seekbar.setClickable(true);

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(seekBar.getProgress());
            }
        });

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
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
        Log.d("mediaPlayer", "play audio book");
        mediaPlayer.start();

        timeElapsed = mediaPlayer.getCurrentPosition();
        seekbar.setProgress((int) timeElapsed);

        durationHandler.postDelayed(updateSeekBarTime, 100);
    }

    private void pauseAudioBook(){
        Log.d("mediaPlayer", "pause audio book");
        mediaPlayer.pause();
    }

    private Runnable updateSeekBarTime = new Runnable() {
        @Override
        public void run() {
        timeElapsed = mediaPlayer.getCurrentPosition();
        seekbar.setProgress((int) timeElapsed);
        durationHandler.postDelayed(this,100);
        }
    };

    private void forwardMediaPlayer() {
        Log.d("mediaPlayer", "forward media player");
        int duration = mediaPlayer.getDuration();
        Log.d("mediaPlayer", "duration: " + duration);
        Log.d("mediaPlayer", "duration + forward time: " + duration + forwardTime);
        Log.d("mediaPlayer", "final time: " + finalTime);
        if((duration + forwardTime) <= finalTime) {
            timeElapsed = timeElapsed + forwardTime;
            Log.d("mediaPlayer", "forward time elapsed: " + timeElapsed);
            mediaPlayer.seekTo((int) timeElapsed);
            seekbar.setProgress((int) timeElapsed);
        }
    }

    private void backwardMediaPlayer() {
        int duration = mediaPlayer.getDuration();
        if((duration - backwardTime) > 0) {
            timeElapsed = timeElapsed - backwardTime;
            Log.d("mediaPlayer", "backward time elapsed: " + timeElapsed);
            mediaPlayer.seekTo((int) timeElapsed);
            seekbar.setProgress((int) timeElapsed);
        }
    }
}
