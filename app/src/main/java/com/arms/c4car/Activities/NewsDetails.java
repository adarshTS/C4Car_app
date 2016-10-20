package com.arms.c4car.Activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.arms.c4car.R;

public class NewsDetails extends AppCompatActivity {
    public TextView itemname;
    public TextView itemShort_desc;
    public ImageView itemImage;
    String title,desc;
    int image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);
        title="News in detaials";
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        setupActionBar();
        itemname = (TextView) findViewById(R.id.textViewCarname);
        itemShort_desc = (TextView) findViewById(R.id.textViewShortdesc);
        itemImage = (ImageView) findViewById(R.id.imageViewCar);
        Intent intent=getIntent();
        title=intent.getStringExtra("title");
        desc=intent.getStringExtra("desc");
        image=Integer.parseInt(intent.getStringExtra("image"));
        itemname.setText(title);
        itemShort_desc.setText(desc);
        itemImage.setImageResource(image);

    }

    private void setupActionBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            // Show the Up button in the action bar.
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
            System.out.println("Activity Finished");
            finish();
            // overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

        }


    }

    protected void onResume()
    {
        //finish();
        super.onResume();

        overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
    }

    protected void onPause()
    {
        //finish();
        super.onPause();

        overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_down);
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                FragmentManager fm = getSupportFragmentManager();
                System.out.println("back stack entry" + fm.getBackStackEntryCount());
                if (fm.getBackStackEntryCount() > 0) {
                    fm.popBackStack();
                    // super.onBackPressed();
                    // return;
                } else {
                    System.out.println("Activity Finished");
                    finish();
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                }
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
