package broadcaster.asuper.superbroadcaster;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private boolean snippetIsAdded;

    private Fragment currentFragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_myloan:
                    currentFragment = new MyloanFragment();
                    loadFragment(currentFragment);
                    return true;
                case R.id.navigation_discover:
                    currentFragment = new BlankMenuFragment();
                    loadFragment(currentFragment);
                    return true;
                case R.id.navigation_currentbook:
                    currentFragment = new BlankMenuFragment();
                    loadFragment(currentFragment);
                    return true;
                case R.id.navigation_snippetbookshelf:
                    currentFragment = new SnippetShelf();
                    loadFragment(currentFragment);
                    return true;
                case R.id.navigation_more:
                    currentFragment = new BlankMenuFragment();
                    loadFragment(currentFragment);
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

        snippetIsAdded = false;

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Bundle intentExtras = getIntent().getExtras();
        if (intentExtras != null) {
            int intentFragment = intentExtras.getInt("frgToLoad");
            Log.d("intentFragment", intentFragment + "");
            switch (intentFragment) {
                case R.id.navigation_snippetbookshelf:
                    snippetIsAdded = true;
                    navigation.setSelectedItemId(R.id.navigation_snippetbookshelf);
                    break;
                default:
                    navigation.setSelectedItemId(R.id.navigation_discover);
                    break;
            }
        } else {
            currentFragment = new MyloanFragment();
            loadFragment(currentFragment);
        }
    }

    public boolean snippetIsAdded() {
        return snippetIsAdded;
    }
}
