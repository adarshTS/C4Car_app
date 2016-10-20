package com.arms.c4car.Activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.arms.c4car.Adapters.All_CarsListRecyclerViewAdapter;
import com.arms.c4car.Entities.CarList;
import com.arms.c4car.Entities.DataModel;
import com.arms.c4car.R;

import java.util.ArrayList;
import java.util.List;

public class CarListActivity extends AppCompatActivity {
    public ArrayList<DataModel> dataModels;
    List<CarList> subCarList = null;
    String title;
    int id;
    All_CarsListRecyclerViewAdapter adapter;
    RecyclerView all_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_list);
        all_list= (RecyclerView) findViewById(R.id.RecyclerViewCarList);
        all_list.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        Intent intent = getIntent();
        id=intent.getIntExtra("id",0);
        title=intent.getStringExtra("title");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        setupActionBar();
        getAllCars();

    }

    public void getAllCars()
    {
        subCarList = new ArrayList<>();
        if(id==1) {

            subCarList.add(new CarList(1, "datsun redi go".toUpperCase()));
            subCarList.add(new CarList(2, "Hyundai Xcent".toUpperCase()));
            subCarList.add(new CarList(3, "Mahindra KUV100".toUpperCase()));
            subCarList.add(new CarList(4, "maruti celerio".toUpperCase()));

        }


        if(id==2) {

            subCarList.add(new CarList(5, "Chevrolet Sail".toUpperCase()));
            subCarList.add(new CarList(6, "Fiat Linea Classic".toUpperCase()));
            subCarList.add(new CarList(7, "Ford aspire".toUpperCase()));
            subCarList.add(new CarList(8, "Honda Amaze".toUpperCase()));
            subCarList.add(new CarList(9, "Volkswagen Ameo".toUpperCase()));
        }

        if(id==3) {

            subCarList.add(new CarList(10, "Audi A4".toUpperCase()));
            subCarList.add(new CarList(11, "BMW 3 Series".toUpperCase()));
            subCarList.add(new CarList(12, "Jaguar XE".toUpperCase()));
            subCarList.add(new CarList(13, "Mercedes-Benz C-Class".toUpperCase()));
            subCarList.add(new CarList(14, "Volvo S60".toUpperCase()));
        }

        if(id==4) {

            subCarList.add(new CarList(15, "Audi R8 V10 Plus".toUpperCase()));
            subCarList.add(new CarList(16, "BMW i8".toUpperCase()));
            subCarList.add(new CarList(17, "Jaguar F-Type".toUpperCase()));
            subCarList.add(new CarList(18, "Lamborghini Aventador LP700-4".toUpperCase()));
            subCarList.add(new CarList(19, "Porsche Cayman S".toUpperCase()));
        }

        if(id==5) {

            subCarList.add(new CarList(20, "Force Gurkha 4x4 Hard Top".toUpperCase()));
            subCarList.add(new CarList(21, "mahindra thar".toUpperCase()));
          //  subCarList.add(new CarList(22, "Mahindra Scorpio S10 4WD".toUpperCase()));

        }
        updateRecylerView();

    }
    public void  updateRecylerView()
    {
        if (dataModels != null) {
            dataModels.clear();
        } else {
            dataModels = new ArrayList<DataModel>();

        }
        for (CarList car : subCarList) {
            dataModels.add(new DataModel(car.getId(), car.getTitle()));


        }

        initRecyclerView();



    }

    public void initRecyclerView()
    {
        adapter=new All_CarsListRecyclerViewAdapter(getApplicationContext(),dataModels);
        all_list.setAdapter(adapter);
        adapter.setOnItemClickListener(new All_CarsListRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, DataModel viewModel) {
            int id=viewModel.getCarId();
                String title=viewModel.getCarTitle();
                Intent intent=new Intent(CarListActivity.this,CarDetailsActivity.class);
                intent.putExtra("id",id);
                intent.putExtra("title",title);
                startActivity(intent);

            }
        });
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
