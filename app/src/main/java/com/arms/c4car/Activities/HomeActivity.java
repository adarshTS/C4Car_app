package com.arms.c4car.Activities;

import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.arms.c4car.Fragments.HomeFragment;
import com.arms.c4car.Fragments.NavigationDrawerFragment;
import com.arms.c4car.R;


public class HomeActivity extends AppCompatActivity implements NavigationDrawerFragment.FragmentDrawerListener {
    private static String TAG = HomeActivity.class.getSimpleName();
    private CoordinatorLayout coordinatorLayout;
    private Toolbar mToolbar;
    private NavigationDrawerFragment drawerFragment;
    private boolean doubleBackToExitPressedOnce = false;
    LinearLayout log, rws;
    TextView logtext;

    String userId;
    IntentFilter mIntentFilter;
    String title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);

       // log = (LinearLayout) findViewById(R.id.layout_log);
        rws = (LinearLayout) findViewById(R.id.layout_logg);






        rws.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mIntentFilter = new IntentFilter();
        mIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        mIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        drawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);

        // display the first navigation drawer view on app launch

        displayView(0);

    }

    @Override
    protected void onResume() {

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        super.onResume();
        overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);

    }

    @Override
    protected void onPause() {

        super.onPause();
        overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_down);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       /* if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);
    }

    private void displayView(int position) {
        Fragment fragment = null;


            title = getString(R.string.app_name);
            if (position == 0) {
                fragment = new HomeFragment();
                title = getString(R.string.app_name);
            }



        // title = HomeMenu.titles[position];

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.commit();

            // set the toolbar title
            getSupportActionBar().setTitle(title);
        }
    }

    public void onBackPressed() {

        FragmentManager fm = getSupportFragmentManager();
        System.out.println("back stack entry" + fm.getBackStackEntryCount());

        if (fm.getBackStackEntryCount() > 0) {
            fm.popBackStack();
            // super.onBackPressed();
            // return;
        } else {
            if (doubleBackToExitPressedOnce) {
                fm.popBackStack();
                super.onBackPressed();
                return;
            }

            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, "Press one more time to exit",
                    Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {

                    doubleBackToExitPressedOnce = false;
                }
            }, 3000);

        }

    }


}