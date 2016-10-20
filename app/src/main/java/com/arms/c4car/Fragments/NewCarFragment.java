package com.arms.c4car.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arms.c4car.Activities.CarListActivity;
import com.arms.c4car.Adapters.All_CarsRecyclerViewAdapter;
import com.arms.c4car.Entities.Car;
import com.arms.c4car.Entities.DataModel;
import com.arms.c4car.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link NewCarFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link NewCarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewCarFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    List<Car> all_car_List = null;
    public List<Car> all_carItems;
    private ArrayList<DataModel> dataModels;
    RecyclerView all_list;

    All_CarsRecyclerViewAdapter adapter;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public NewCarFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NewCarFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NewCarFragment newInstance(String param1, String param2) {
        NewCarFragment fragment = new NewCarFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_new_car, container, false);
        all_list= (RecyclerView) v.findViewById(R.id.RecyclerViewCars);
        all_list.setLayoutManager(new LinearLayoutManager(getActivity()));
        getAllCars();
        return  v;
    }

    public void getAllCars()
    {
        all_car_List = new ArrayList<>();
        all_car_List.add(new Car(1, "Economy cars".toUpperCase(),"",String.valueOf(R.drawable.celerio2),"MICROCAR ,HATCHBACKS,ULTRACOMPACT,CITY….. "));
        all_car_List.add(new Car(2, "Sedan".toUpperCase(),"",String.valueOf(R.drawable.sed),"LARGE,CROSSOVER SUV, MINIVANS……"));
        all_car_List.add(new Car(3, "Luxuary".toUpperCase(),"",String.valueOf(R.drawable.car),"COMPACT EXECUTIVE, EXECUTIVE,MID LUXURY, LUXURY  …."));
        all_car_List.add(new Car(4, "Sports Cars".toUpperCase(),"",String.valueOf(R.drawable.sports),"HOT HATCH,SPORT SEDAN, GRAND TAUREN…."));
        all_car_List.add(new Car(5,"off roaders".toUpperCase(),"",String.valueOf(R.drawable.off),""));

        updateRecylerView();

    }

    public void  updateRecylerView()
    {
        if (dataModels != null) {
            dataModels.clear();
        } else {
            dataModels = new ArrayList<DataModel>();

        }
        for (Car car : all_car_List) {
            dataModels.add(new DataModel(car.getId(),car.getTitle(),car.getDescription(),car.getImage(),car.getShort_description()));


        }

        initRecyclerView();



    }

    public void initRecyclerView()
    {
        adapter=new All_CarsRecyclerViewAdapter(getActivity(),dataModels);
        all_list.setAdapter(adapter);
        adapter.setOnItemClickListener(new All_CarsRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, DataModel viewModel) {
                int id=viewModel.getCarId();
                String title=viewModel.getCarTitle();
                Intent intent=new Intent(getActivity(), CarListActivity.class);
                intent.putExtra("id",id);
                intent.putExtra("title",title);
                startActivity(intent);


            }
        });
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
