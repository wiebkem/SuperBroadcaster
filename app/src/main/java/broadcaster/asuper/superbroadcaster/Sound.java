/*
public class Sound extends AppCompatActivity {
    private Handler myHandler = new Handler();
    public static int oneTimeOnly = 0;
    private MediaPlayer mediaPlayer;
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

        mediaPlayer = MediaPlayer.create(this, R.raw.peterpanch1);

        final int duration = mediaPlayer.getDuration();
        final int forwardTime = 5000; // 5 seconds
        final int backwardTime = 5000; // 5 seconds

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();

                int currentPosition = mediaPlayer.getCurrentPosition();

                if (oneTimeOnly == 0) {
                    seekbar.setMax(duration);
                    oneTimeOnly = 1;
                }
                seekbar.setProgress(currentPosition);

                endTime.setText(
                        String.format("%d min, %d sec", TimeUnit.MILLISECONDS.toMinutes((long) duration),
                                TimeUnit.MILLISECONDS.toSeconds((long) duration) -
                                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) duration)))
                );

                startTime.setText(String.format("%d min, %d sec",
                        TimeUnit.MILLISECONDS.toMinutes((long) currentPosition),
                        TimeUnit.MILLISECONDS.toSeconds((long) currentPosition) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                                        currentPosition)))
                );

                myHandler.postDelayed(UpdateSongTime,100);
            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
            }
        });

        forwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentPosition = mediaPlayer.getCurrentPosition();

                if((currentPosition + forwardTime) <= duration){
                    currentPosition = currentPosition + forwardTime;
                    mediaPlayer.seekTo(currentPosition);
                }else{
                    Toast.makeText(getApplicationContext(),"Cannot jump forward 5 seconds",Toast.LENGTH_SHORT).show();
                }
            }
        });

        backwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentPosition = mediaPlayer.getCurrentPosition();

                if((currentPosition - backwardTime) > 0){
                    currentPosition = currentPosition - backwardTime;
                    mediaPlayer.seekTo(currentPosition);
                }else{
                    Toast.makeText(getApplicationContext(),"Cannot jump backward 5 seconds",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private Runnable UpdateSongTime = new Runnable() {
        public void run() {
            int currentPosition = mediaPlayer.getCurrentPosition();
            startTime.setText(String.format("%d min, %d sec",
                    TimeUnit.MILLISECONDS.toMinutes((long) currentPosition),
                    TimeUnit.MILLISECONDS.toSeconds((long) currentPosition) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
                                    toMinutes((long) currentPosition)))
            );
            seekbar.setProgress(currentPosition);
            myHandler.postDelayed(this, 100);
        }
    };
}
*/