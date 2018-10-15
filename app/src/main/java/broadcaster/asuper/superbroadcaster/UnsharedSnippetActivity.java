package broadcaster.asuper.superbroadcaster;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class UnsharedSnippet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unshared_snippet);

        RelativeLayout unsharedSnippetLayout = findViewById(R.id.unsharedSnippetLayout);
        unsharedSnippetLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("UnsharedSnippet", "unshared snippet onclick fired");
                AlertDialog alertDialog = new AlertDialog.Builder(getApplicationContext()).create();
                alertDialog.setTitle("Snippet shared");
                alertDialog.setMessage("The snippet is shared!");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                //finish();
                            }
                        });
                alertDialog.show();
            }
        });
    }
}
