package broadcaster.asuper.superbroadcaster;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private Fragment currentFragment;
    private FragmentTransaction ft;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment currentFragment;
            switch (item.getItemId()) {
                case R.id.navigation_myloan:
                    mTextMessage.setText(R.string.myloan);
                    currentFragment = new Myloan();
                    loadFragment(currentFragment);
                    return true;
                case R.id.navigation_discover:
                    mTextMessage.setText(R.string.Discover);
                    return true;
                case R.id.navigation_currentbook:
                    mTextMessage.setText(R.string.Currentbook);
                    return true;
                case R.id.navigation_snippetbookshelf:
                    mTextMessage.setText(R.string.Snippetbookshelf);
                    currentFragment = new SnippetShelf();
                    loadFragment(currentFragment);
                    return true;
                case R.id.navigation_more:
                    mTextMessage.setText(R.string.More);
                    return true;
            }
            return false;
        }
    };

    // load the specified fragment
    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
