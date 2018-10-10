package broadcaster.asuper.superbroadcaster;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private SeekBar seekbar;
    private TextView startTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button playButton = findViewById(R.id.playButton);
        Button pauseButton = findViewById(R.id.pauseButton);
        Button backwardButton = findViewById(R.id.backButton);
        Button forwardButton = findViewById(R.id.forwardButton);
        seekbar = findViewById(R.id.seekBar);
        startTime = findViewById(R.id.startTextView);
        final TextView endTime = findViewById(R.id.endTextView);
    }
}
