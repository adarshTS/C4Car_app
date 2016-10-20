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

import com.arms.c4car.Activities.NewsDetails;
import com.arms.c4car.Adapters.All_NewsRecyclerViewAdapter;
import com.arms.c4car.Entities.DataModel;
import com.arms.c4car.Entities.News;
import com.arms.c4car.R;
import com.arms.c4car.Utils.NetworkUtil;

import java.util.ArrayList;
import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link NewsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link NewsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    List<News> all_news_List = null;
    All_NewsRecyclerViewAdapter adapter;
    private ArrayList<DataModel> dataModels;
    RecyclerView all_list;
    private OnFragmentInteractionListener mListener;

    public NewsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NewsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NewsFragment newInstance(String param1, String param2) {
        NewsFragment fragment = new NewsFragment();
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
        View v= inflater.inflate(R.layout.fragment_news, container, false);
        all_list= (RecyclerView) v.findViewById(R.id.RecyclerViewCarNews);
        all_list.setLayoutManager(new LinearLayoutManager(getActivity()));
        int conn = NetworkUtil.getConnectivityStatus(getActivity());
        if (conn == NetworkUtil.TYPE_NOT_CONNECTED) {
            new SweetAlertDialog(getActivity(), SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("Not Internet connection")
                    .setContentText("You need an internet connection")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                            sweetAlertDialog.cancel();

                        }
                    })
                    .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            sDialog.cancel();
                        }
                    })
                    .show();
        }

        else
        {
            getAllNews();
        }
        return v;
    }

    public void getAllNews()
    {
        all_news_List = new ArrayList<>();
        all_news_List.add(new News(1, "Mercedes-Benz GLA 220 d 4MATIC ‘Activity Edition’ Launched At Rs 38.51 Lakh".toUpperCase(),"The country’s largest luxury carmaker Mercedes-Benz inched further towards its target of bringing 12 new cars to India this year by launching the GLA 220 d 4MATIC ‘Activity Edition’ for a price of Rs 38.51 lakh (ex-showroom, Pune) on Monday. With this, the 4MATIC all-wheel drive has also made its debut on the GLA in the country, according to a press release.\n" +
                "\n" +
                "This is the German carmaker’s sixth SUV launch in India and its ninth new product for 2016. On the occasion, Roland Forger, managing director and CEO of the company’s Indian arm, pointed at the widening fan base for SUVs in India as the reason behind the company’s latest move.\n" +
                "\n" +
                "“The GLA was a key addition to our SUV portfolio as it not only generated volumes for us, but also opened the SUV segment to a much younger customer base. We have sold over 3500 units of the GLA since its market introduction and with the launch of the GLA 220 d 4MATIC Activity Edition, we expect the volumes to scale even further and add more value to the consumer,” he said.\n" +
                "\n" +
                "\n" +
                "He also revealed that the GLA 220 d will now be available with the 4MATIC and off-road package as standard. Power will be supplied to the AWD via the 2143cc, in-line, four-cylinder diesel mill, which is good for 170PS and 350Nm, when mated to a 7G-DCT transmission. This set-up propels the car to 100kmph from a dead halt within 7.7 seconds.\n" +
                "\n" +
                "On the outside, the additions to the latest version of the GLA include black decals on the door, longitudinal chrome elements and 18-inch alloys, apart from the ‘Activity Edition’ badging. The car will also be offered in a new colour option – Mountain Grey – added the release. \n" +
                "\n" +
                "A new eight-inch media display with Smartphone Integration package, the keyless GO starting function, Easy Pack Tailgate, rain-sensing wipers, stowage package and load compartment package with multiple storage facilities, along with a 12 V socket in the boot are among other notable features on the car.",String.valueOf(R.drawable.news1image)));


        all_news_List.add(new News(2, "Indian Exports On The Rise: Hyundai, Ford Lead Charge".toUpperCase(),"After being spotted testing in the country recently, the imminent launch of the next-gen Volkswagen Passat is set to take place by January 2017, according to multiple reports. The car, in its GTE Hybrid avatar, was showcased at the 2016 Auto Expo in Delhi earlier this year and is expected to breathe some more life into the luxury sedan segment.\n" +
                "\n" +
                "Launched back in 2007, the Passat has never really been radically upgraded in India. But it would only be fair to accredit this to the low sales volumes in the segment over the years. However, thanks to the likes of the Toyota Camry, and also the new Skoda Superb, the Indian buyer has been showing greater interest in these posher sedans. And with Honda also set to bring in the Accord Hybrid during the festive period, it would be oblivious of Volkswagen to hold back its horses any longer.\n" +
                "\n" +
                "In terms of looks, the car gets a stronger dose of style than the outgoing model. Built on the German carmaker’s MQB platform, the Passat is built on the company’s latest design language, with a sporty bumper and LED fog lamps on the front fascia. The redesigned rear is also packed with new pentagonal LED lamps and a bulkier bumper.\n" +
                "\n" +
                "In its eighth iteration globally, the car will reportedly be powered by a diesel engine initially, to be later followed by a plug-in hybrid version. The diesel mill will be the company's familiar 1,968cc TDI four-cylinder engine that delivers 170PS of power and 320Nm of torque when mated to the 7-speed DSG transmission as standard. \n",String.valueOf(R.drawable.news2image)));


        all_news_List.add(new News(3,"Next-Gen Volkswagen Passat In India By January 2017","After being spotted testing in the country recently, the imminent launch of the next-gen Volkswagen Passat is set to take place by January 2017, according to multiple reports. The car, in its GTE Hybrid avatar, was showcased at the 2016 Auto Expo in Delhi earlier this year and is expected to breathe some more life into the luxury sedan segment.\n" +
                "\n" +
                "Launched back in 2007, the Passat has never really been radically upgraded in India. But it would only be fair to accredit this to the low sales volumes in the segment over the years. However, thanks to the likes of the Toyota Camry, and also the new Skoda Superb, the Indian buyer has been showing greater interest in these posher sedans. And with Honda also set to bring in the Accord Hybrid during the festive period, it would be oblivious of Volkswagen to hold back its horses any longer.\n" +
                "\n" +
                "In terms of looks, the car gets a stronger dose of style than the outgoing model. Built on the German carmaker’s MQB platform, the Passat is built on the company’s latest design language, with a sporty bumper and LED fog lamps on the front fascia. The redesigned rear is also packed with new pentagonal LED lamps and a bulkier bumper.\n" +
                "\n" +
                "In its eighth iteration globally, the car will reportedly be powered by a diesel engine initially, to be later followed by a plug-in hybrid version. The diesel mill will be the company's familiar 1,968cc TDI four-cylinder engine that delivers 170PS of power and 320Nm of torque when mated to the 7-speed DSG transmission as standard. \n",String.valueOf(R.drawable.new3image)));

        all_news_List.add(new News(4,"Datsun Recalls 932 Units Of redi-GO","Datsun has issued a voluntary recall for its entry level offering – the redi-GO. This means that, alongside the 50,000 (approx.) units of the Renault Kwid, 932 units of the Datsun redi-GO are being recalled. The problem stated is with the fuel hose clip, and both the Kwid and the redi-GO are being recalled to address the same issue. Underneath their widely varying exteriors, the Kwid and the redi-GO are practically the same. They are built on the same platform and use the same engine in similar tunes. The repair of the fuel hose clip will be free of cost to the owners. The statement issued by Datsun says, “Datsun is conducting a voluntary recall campaign on certain India-manufactured Datsun redi-GO vehicles to inspect the fuel hose and fix a clip at no cost to the customer.”\n" +
                "\n" +
                "Datsun had banked on the success of the redi-GO to remain in the market. So far, the redi-GO has been clocking good numbers and has become the highest selling car for Datsun. With the launch of the 'Sport' edition, these sales are expected to rise further. The car comes with a 799cc three-cylinder engine which produces 53PS of power and 72Nm of torque. This engine is mated to a five-speed manual transmission. This is the same engine that is used in the Kwid as well.\n" +
                "The 'Sport' edition retains these mechanicals but features cosmetic updates. Outside, the car gets racing stripes which go across the length of the car. It also gets side stripes, black-painted wheel caps and grille (both with red highlights) and a roof spoiler. Inside too, there are prominent changes. The hatchback gets all-black dashboard upholstery with red accents. Among the list of additions is a Bluetooth-enabled music system, remote keyless entry and rear parking sensors.",String.valueOf(R.drawable.news4image)));

        all_news_List.add(new News(5,"Meet The Fifth-Generation Honda CR-V","The 2017 CR-V shares its platform with the latest-gen Civic and features a turbocharged petrol for the first time ever since its inception in 1997! \n" +
                "\n" +
                "Honda has taken wraps off the 2017, fifth-generation CR-V in an event in Detroit. It will go on sale in the States by late 2016. The new CR-V is based on Honda’s compact global platform, which made its debut with the tenth generation Civic. Also, it will be pulled by the Japanese automaker’s latest family of turbocharged petrol engines – VTEC Turbo – globally along with the existing powertrains. The European market launch is likely to take place next year, while its Indian debut is expected in a couple of years. Here’s what we know so far about the 2017 CR-V. \n" +
                "\n" +
                "The CR-V borrows design cues from the latest Hondas (especially the current-gen Civic), featuring a ‘windswept’ front end. It now has a longer bonnet compared to the previous model and offers all-LED headlights with wing-shaped LED daytime running lights, both found on the India-bound face-lifted Accord and the Civic. Its chrome grille is closely flanked by the headlamps and has active shutters that lower aerodynamic drag, which is a first for Honda.  \n" +
                "\n" +
                "The CR-V borrows design cues from the latest Hondas (especially the current-gen Civic), featuring a ‘windswept’ front end. It now has a longer bonnet compared to the previous model and offers all-LED headlights with wing-shaped LED daytime running lights, both found on the India-bound face-lifted Accord and the Civic. Its chrome grille is closely flanked by the headlamps and has active shutters that lower aerodynamic drag, which is a first for Honda.  \n" +
                "\n" +
                "Like we have mentioned before, the 2017 CR-V is based on Honda’s latest global compact platform and courtesy of it, the CR-V has grown nearly 38mm in length. And with shorter overhangs along with wheels placed to the extremities, the wheelbase of the new SUV has grown by a whopping 40mm. \n" +
                "\n" +
                "As is the case with the exterior, the 2017 CR-V features completely redesigned interiors, incorporating upgraded materials such as a new soft-touch instrument panel and more intricately stitched seats. The cabin shares its bits and pieces with the latest Hondas, again largely with the Civic. However, the essence of the previous generations of the CR-V has been retained with elements like the dash-mounted gearshift lever.\n" +
                "\n" +
                " ",String.valueOf(R.drawable.news5image)));

        updateRecylerView();

    }

    public void  updateRecylerView()
    {
        if (dataModels != null) {
            dataModels.clear();
        } else {
            dataModels = new ArrayList<DataModel>();

        }
        for (News news : all_news_List) {
            dataModels.add(new DataModel(news.getId(),news.getTitle(),news.getDescription(),news.getImage(),news.getDescription()));


        }

        initRecyclerView();



    }

    public void initRecyclerView()
    {
        adapter=new All_NewsRecyclerViewAdapter(getActivity(),dataModels);
        all_list.setAdapter(adapter);
        adapter.setOnItemClickListener(new All_NewsRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, DataModel viewModel) {

                String title=viewModel.getCarTitle();
                String desc=viewModel.getCarDescription();
                String img=viewModel.getCarImage();
                Intent intent=new Intent(getActivity(), NewsDetails.class);

                intent.putExtra("title",title);
                intent.putExtra("desc",desc);
                intent.putExtra("image",img);
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
