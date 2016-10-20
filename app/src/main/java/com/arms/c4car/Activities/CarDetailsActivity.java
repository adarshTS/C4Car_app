package com.arms.c4car.Activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.arms.c4car.Adapters.SlidingImage_Adapter;
import com.arms.c4car.Entities.CarSpec;
import com.arms.c4car.R;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class CarDetailsActivity extends AppCompatActivity {
    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    int id;
    private static final Integer[] IMAGES= {R.drawable.car,R.drawable.eco,R.drawable.sed,R.drawable.sports};
    ArrayList<Integer> stringArrayList = null;
    String title;
    TextView
    top_Speed,
    acceleration,
    engineDisplacement,
    maximumPower,
    maximumTorque,
    engineDescription,
    turningRadius,
    cylindersNum,
    driveType,
    turboCharger,
    superCharger,
    valvesPerCylinder,
    compressionRatio,
    fuelSupplySystem,
    gearBox,
    steeringGearType,
    seatingCapacity,
     NumDoors,
    length,
     lengthWidth,
     lengthHeight,
     groundClearance,
     wheelBase,
     frontTread,
     rearTread,
     kerbWeight,
     grossWeight,
    frontHeadroom,
    frontLegroom,
    rearHeadroom,
     rearLegroom,
    fuelTankCapacity,
    cargoVolume,
    tyreSize,
    tyreType,
    wheelSize,
    alloyWheelSize,
    NumFloors,
     borexStroke,
     synchronizers,
    clutchType,

    emissionNormCompliance,
    emissionControlSystem,
    countryofAssembly,
     countryofManufacture,
    warrantyTime,
     warrantyDistance,
    price;

    List<CarSpec> carSpec = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_details);
        Intent intent=getIntent();
        id=intent.getIntExtra("id",0);
        title=intent.getStringExtra("title");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        setupActionBar();
        top_Speed= (TextView) findViewById(R.id.textViewspeed);
        acceleration=(TextView) findViewById(R.id.textViewAccelaration);
        engineDisplacement=(TextView) findViewById(R.id.textViewEngineDisplacement);
        maximumPower=(TextView) findViewById(R.id.textViewMaximumPower);
        maximumTorque=(TextView) findViewById(R.id.textViewMaximumTorque);
        engineDescription=(TextView) findViewById(R.id.textViewEngineDescription);
        turningRadius=(TextView) findViewById(R.id.textViewTurningRadius);
        cylindersNum=(TextView) findViewById(R.id.textViewCylinders);
        driveType=(TextView) findViewById(R.id.textViewDriveType);
        turboCharger=(TextView) findViewById(R.id.textViewTurboCharger);
        superCharger=(TextView) findViewById(R.id.textViewSuperCharger);
        valvesPerCylinder=(TextView) findViewById(R.id.textViewValvesPerCylinder);
        compressionRatio=(TextView) findViewById(R.id.textViewCompressionRatio);
        fuelSupplySystem=(TextView) findViewById(R.id.textViewFuelSupplySystem);
        gearBox=(TextView) findViewById(R.id.textViewGearbox);
        steeringGearType=(TextView) findViewById(R.id.textViewSteeringGearType);
        seatingCapacity=(TextView) findViewById(R.id.textViewSeatingCapacity);
        NumDoors=(TextView) findViewById(R.id.textViewDoors);
        length=(TextView) findViewById(R.id.textViewLength);
        lengthWidth=(TextView) findViewById(R.id.textViewWidth);
        lengthHeight=(TextView) findViewById(R.id.textViewHeight);
        groundClearance=(TextView) findViewById(R.id.textViewGroundClearance);
        wheelBase=(TextView) findViewById(R.id.textViewWheelBase);
        frontTread=(TextView) findViewById(R.id.textViewFrontTreads);
        rearTread=(TextView) findViewById(R.id.textViewRearTread);
        kerbWeight=(TextView) findViewById(R.id.textViewKerbWeight);
        grossWeight=(TextView) findViewById(R.id.textViewGrossWeight);
        frontHeadroom=(TextView) findViewById(R.id.textViewFrontHeadroom);
        frontLegroom=(TextView) findViewById(R.id.textViewFrontLegroom);
        rearHeadroom=(TextView) findViewById(R.id.textViewRearHeadroom);
        rearLegroom=(TextView) findViewById(R.id.textViewRearLegroom);
        fuelTankCapacity=(TextView) findViewById(R.id.textViewFuelTankCapacity);
        cargoVolume=(TextView) findViewById(R.id.textViewCargoVolume);
        tyreSize=(TextView) findViewById(R.id.textViewTyreSize);
        tyreType=(TextView) findViewById(R.id.textViewTyreType);
        wheelSize=(TextView) findViewById(R.id.textViewWheelSize);
        alloyWheelSize=(TextView) findViewById(R.id.textViewAlloyWheelSize);
        NumFloors=(TextView) findViewById(R.id.textViewFloors);
        borexStroke=(TextView) findViewById(R.id.textViewSBoreStroke);
        synchronizers=(TextView) findViewById(R.id.textViewSynchronizers);
        clutchType=(TextView) findViewById(R.id.textViewClutchType);
        emissionNormCompliance=(TextView) findViewById(R.id.textViewEmissionNormCompliance);
        emissionControlSystem=(TextView) findViewById(R.id.textViewHeightEmissionControlSystem);
        countryofAssembly=(TextView) findViewById(R.id.textViewCountryofAssembly);
        countryofManufacture=(TextView) findViewById(R.id.textViewCountryofManufacture);
        warrantyTime=(TextView) findViewById(R.id.textViewWarrantyTime);
        warrantyDistance=(TextView) findViewById(R.id.textViewWarrantyDistance);
        price= (TextView) findViewById(R.id.textViewprice);
        stringArrayList = new ArrayList<>();
        init();
        getAllCars();
    }

    public void getAllCars() {
        carSpec = new ArrayList<>();
        if (id == 1) {

            carSpec.add(new CarSpec("-", "-","799","53bhp@5678rpm","72Nm@4388rpm","0.8-litre 53bhp 12V Petrol Engine",
                    "4.7mm","3","2WD","No","No","4","-","MPFi","5-Speed","-","5","5","3429mm","1560mm","1541mm","185mm",
                    "2348mm","-","-","-","-","-","-","-","-","35","222 Ltrs","-","-","13 Inch","-","-","-","-","-",
                    "BS IV","-","India","India","2 Years","Unlimited",String.valueOf(R.drawable.datsun1),
                    String.valueOf(R.drawable.datsun2),String.valueOf(R.drawable.datsun3),"2.43 - 3.49 Lakh"));

        }

        if (id == 2) {

            carSpec.add(new CarSpec("156", "18.6","1120","71bhp@4000rpm","180.4Nm@1750-2500rpm","1.1-litre 71bhp 12V U2 CRDI Diesel Engine",
                    "4.7metres","3","FWD","Yes","No","4","-","CRDI","5-Speed","-","5","4","3995mm","1660mm","1520mm","165mm",
                    "2425mm","1479","1493","-","-","-","-","-","-","43","407 Ltrs","165/65 R14","Tubeless","14 Inch","-","-","-","-","-",
                    "BS IV","-","India","India","2 Years","Unlimited",String.valueOf(R.drawable.eco),
                    String.valueOf(R.drawable.hyundai),String.valueOf(R.drawable.hyundai1),"5.49 - 8.14 Lakh"));

        }

        if (id ==3 ) {

            carSpec.add(new CarSpec("160kmph", "14.5 seconds","1198","77bhp@3750rpm","190Nm@1750-2250rpm","1.2-litre 77bhp 12V mFALCON D75 Engine",
                    "5.05","3","FWD","Yes","No","4","-","CRDi","5-Speed","Rack & Pinion","6","5","3675mm","1705mm","1635mm","170mm",
                    "2385mm","1490mm","1490mm","-","-","-","-","-","-","35","243 Ltrs","185/65 R14","Tubeless,Radial","14 Inch","-","-","-","-","-",
                    "BS IV","-","India","India","2 Years","Unlimited",String.valueOf(R.drawable.mahindra),
                    String.valueOf(R.drawable.mahindra1),String.valueOf(R.drawable.mahindra2),"4.65 - 7.2 Lakh"));

        }

        if (id ==4 ) {

            carSpec.add(new CarSpec("130 KMph", "21.9 Seconds","793","47bhp@3500rpm","125Nm@2000rpm","0.8-litre 47bhp 8V DDiS Diesel Engine",
                    "4.7metres","2","FWD","No","No","4","15.0:1","CRDi","5-Speed","-","5","5","3600mm","1600mm","1560mm","165mm",
                    "2425mm","1420mm","1410mm","880kg","1310kg","-","-","-","-","35","235 Ltrs","155/80 R13","Tubeless, Radial","13 Inch","-","-","77.0 X 85.1 mm","-","-",
                    "BS IV","-","India","India","2 Years","40000 kms",String.valueOf(R.drawable.celerio),
                    String.valueOf(R.drawable.celerio1),String.valueOf(R.drawable.celerio2),"4.16 - 6.07 Lakh"));

        }


        if (id ==5 ) {

            carSpec.add(new CarSpec("160 Kmph", "16 seconds","1248","74bhp@4000rpm","190Nm@1750rpm","1.3-litre 74bhp 16V SMARTECH Diesel Engine",
                    "5.15 metres","4","FWD","yes","No","4","-","CRDi","5-Speed","Rack & Pinion","5","4","4249mm","1690mm","1503mm","168mm",
                    "2465mm","-","-","1124kg","-","-","-","-","-","40","370 Ltrs","175/70 R14","Tubeless,Radial","-","17 Inch","-","-","-","-",
                    "BS IV","-","INDIA","INDIA","3 Years","100000 kms",String.valueOf(R.drawable.sail),
                    String.valueOf(R.drawable.sed),String.valueOf(R.drawable.sail1),"5.8 - 8.5 Lakh"));

        }

        if (id ==6 ) {

            carSpec.add(new CarSpec("170 Kmph", "11.4 seconds","1248","75bhp@4000rpm","197Nm@1750rpm","1.3-litre 75bhp 16V Multijet Diesel Engine",
                    "5.4 metres","4","FWD","yes","No","4","-","CRDi","5-Speed","Rack & Pinion","5","4","4560mm","1730mm","1487mm","185mm",
                    "2603mm","-","-","1210kg","-","-","-","-","-","45","500 Ltrs","175/70 R14","Tubeless,Radial","14 Inch","-","-","-","-","-",
                    "BS IV","-","INDIA","-","3 Years","100000 kms",String.valueOf(R.drawable.linea),
                    String.valueOf(R.drawable.linea1),String.valueOf(R.drawable.linea),"7.63 - 6.56 Lakh"));


        }


        if (id ==7 ) {

            carSpec.add(new CarSpec("170 Kmph", "11.6 seconds","1498","99bhp@3750rpm","215Nm@1750-3000rpm","1.5-litre 99bhp 8V TDCI Diesel Engine",
                    "4.9 metres","4","FWD","yes","No","2","16.0:1","Common Rail","5-Speed","Rack & Pinion","5","4","3995mm","1695mm","174mm","2491mm",
                    "1492mm","1484","-","-","-","-","-","-","-","40","359 Ltrs","175/65 R14","Tubeless","14 Inch","-","-","-","-","-",
                    "BS IV","-","INDIA","INDIA","2 Years","100000 kms",String.valueOf(R.drawable.aspire),
                    String.valueOf(R.drawable.aspire1),String.valueOf(R.drawable.aspire2),"40.3 - 48.47 Lakh"));



        }

        if (id ==8 ) {

            carSpec.add(new CarSpec("170 Kmph", "17 seconds","1498","98.6bhp@3600rpm","200Nm@1750rpm","1.5-litre 98.6bhp 16V i-DTEC Diesel Engine",
                    "4.7 metres","4","FWD","yes","No","4","-","CRDi","5-Speed","Rack & Pinion","5","4","3990mm","1680mm","1505mm","165mm",
                    "2405mm","-","-","1050kg","-","-","-","-","-","35","400 Ltrs","175/65 R14","Tubeless,Radial","14 Inch","-","-","-","-","-",
                    "BS IV","-","INDIA","INDIA","2 Years","40000 kms",String.valueOf(R.drawable.amaze),
                    String.valueOf(R.drawable.amaze1),String.valueOf(R.drawable.amaze2),"5.64 - 8.54 Lakh"));



        }

        if (id ==9 ) {

            carSpec.add(new CarSpec("-", "-","1498","103.5bhp@4400rpm","250Nm@1500-2500rpm","1.5-litre 103.5bhp 16V TDI Diesel Engine",
                    "-","4","FWD","yes","No","4","16.5:1","CRDi","5-Speed","Rack & Pinion","5","4","3998mm","1682mm","1469mm","163mm",
                    "2553mm","1457mm","1500mm","1193kg","1750kg","-","-","-","-","45","330 Ltrs","175/70 R14","Tubeless,Radial","14 Inch","-","-","79.5 x 80.5mm","-","-",
                    "BS IV","-","INDIA","INDIA","2 Years","Unlimited kms",String.valueOf(R.drawable.ameo),
                    String.valueOf(R.drawable.ameo1),String.valueOf(R.drawable.ameo2),"5.51 - 9.33 Lakh"));



        }



        if (id ==10 ) {

            carSpec.add(new CarSpec("210 kmph", "8.5","1395","150bhp@5000-6000rpm","250Nm@1500-3500rpm","104-litre 150bhp 16V TFSI Petrol Engine",
                    "5.8 metres","4","FWD","yes","No","4","-","Direct Injection","7 Speed","Rack & pinion","5","4","4726mm","1842mm","1427mm","1842mm",
                    "1427mm","165mm","2820mm","1572mm","1555mm","1450kg","1945kg","-","-","54","480 Ltrs","250/50 R17","Tubeless,Radial","-","-","-","-","-","-",
                    "Euro V","-","-","-","-","-",String.valueOf(R.drawable.audi),
                    String.valueOf(R.drawable.audi1),String.valueOf(R.drawable.audi2),"38.1 - 41.2 Lakh"));

        }

        if (id ==11 ) {

            carSpec.add(new CarSpec("230 Kmph", "7.2 seconds","1995","190bhp@4000rpm","400Nm@1750-2750rpm","2.0-litre 190bhp 16V Diesel Engine",
                    "5.5 meters","4","RWD","yes","No","4","-","CRDi","8-Speed","Rack & Pinion","5","4","4633mm","2031mm","1429mm","157mm",
                    "2810mm","1544","1583","-","-","1023mm","-","957mm","-","57","480 Ltrs","225/55 R16","Tubeless,Radial","-","16 Inch","-","-","-","-",
                    "Euro VI","-","Germany","Germany","2 Years","Unlimited",String.valueOf(R.drawable.bmw),
                    String.valueOf(R.drawable.bmw1),String.valueOf(R.drawable.bmw2),"36.9 - 45.9 Lakh"));

        }


        if (id ==12 ) {

            carSpec.add(new CarSpec("237 Kmph", "7.7 seconds","1999","197bhp@5500rpm","320Nm@1750rpm","2.0-litre 190bhp 16V Petrol Engine",
                    "-","4","FWD","yes","No","4","-","-","8-Speed","Rack & Pinion","-","4","4795mm","2075mm","1416mm","-",
                    "2835mm","-","-","1547kg","2120kg","-","-","-","-","68","485 Ltrs","225/45 R17","Tubeless,Radial","-","17 Inch","-","-","-","-",
                    "BS IV","-","INDIA","INDIA","2 Years","Unlimited",String.valueOf(R.drawable.jaguar),
                    String.valueOf(R.drawable.jaguar1),String.valueOf(R.drawable.jaguar2),"40.3 - 48.47 Lakh"));

        }


        if (id ==13 ) {

            carSpec.add(new CarSpec("233 Kmph", "7.4 seconds","2143","170bhp@3000-4200rpm","400Nm@1400-2800rpm","2.2-litre 170bhp 16V In-line Engine",
                    "5.61metres","4","RWD","yes","No","4","-","CRDi","7-Speed","Direct Steer System","5","4","4686mm","2020mm","1442mm","157mm",
                    "2840mm","1588mm","1570mm","1655kg","2135kg","1039mm","286mm","942mm","343mm","66","480 Ltrs","225/55 R16","Tubeless,Radial","-","16 Inch","-","-","-","-",
                    "Euro V","-","INDIA","INDIA","2 Years","Unlimited",String.valueOf(R.drawable.benz),
                    String.valueOf(R.drawable.benz1),String.valueOf(R.drawable.benz2),"38.25 Lakh* - 1.08 Cr*"));


        }




        if (id ==14 ) {

            carSpec.add(new CarSpec("215 Kmph", "9.2 seconds","1969","181bhp@4250rpm","400Nm@1750-2500rpm","2.0-litre 181bhp 16V Turbo Diesel Engine",
                    "5.65metres","4","FWD","yes","No","4","-","CRDi","8-Speed","Rack & Pinion","5","4","4635mm","2097mm","1484mm","136mm",
                    "2776mm","1588mm","1585mm","1652kg","2060kg","999mm","1064mm","951mm","852mm","67","380 Ltrs","215/50 R17","Tubeless,Radial","-","17 Inch","-","82 x 93.2mm","-","-",
                    "Euro VI","-","INDIA","-","2 Years","Unlimited",String.valueOf(R.drawable.volvo),
                    String.valueOf(R.drawable.volvo1),String.valueOf(R.drawable.volvo2),"34.4 - 43.26 Lakh"));

        }

        if (id ==15 ) {

            carSpec.add(new CarSpec("205 kmph", "3.2 seconds","5204","601.4bhp@8250rpm","560Nm@6500rpm","5.2-litre 601.4bhp 40V Petrol Engine",
                    "5.9 metres","10","AWD","no","yes","4","-","Direct Injection","7-Speed","Rack & Pinion","2","2","4426mm","2037mm","1240mm","110mm",
                    "2650mm","1638mm","1599mm","1555kg","1895kg","977","-","-","-","73","112 Ltrs","245/35 R19,295/35 R19","Tubeless,Radial","-","19 Inch","-","-","-","-",
                    "Euro VI","-","INDIA","INDIA","2 Years","Unlimited kms",String.valueOf(R.drawable.audi8),
                    String.valueOf(R.drawable.audi81),String.valueOf(R.drawable.audi82),"2.56 Cr*"));


        }

        if (id ==16 ) {

            carSpec.add(new CarSpec("250 kmph", "4.4 seconds","1499","231bhp@5800rpm","320Nm@3700rpm","1.5-litre 231bhp 12V Hybrid Engine",
                    "6.15 metres","3","4WD","yes","no","4","9.5:1","MPFI","6-Speed","Rack & Pinion","4","2","4689mm","1942mm","1291mm","117mm",
                    "2800mm","1644mm","1721mm","1560kg","1930kg","983","-","824mm","-","42","154 Ltrs","195/50 R20","Tubeless,Radial","-","20 Inch","-","82 X 94.6 mm","-","-",
                    "EU 6","-","INDIA","Germany","2 Years","Unlimited kms",String.valueOf(R.drawable.bmw8),
                    String.valueOf(R.drawable.bmw81),String.valueOf(R.drawable.bmw82),"2.14 Cr*"));



        }

        if (id ==17 ) {

            carSpec.add(new CarSpec("260 kmph", "5.3 seconds","2995","335.25bhp@6500rpm","450Nm@3500-5000rpm","3.0-litre 335.25bhp 24V V-Type Supercharged Engine",
                    "5.45 metres","6","RWD","no","yes","4","10.5:1","Direct Injection","8-Speed","Rack & Pinion","2","2","4470mm","2042mm","1309mm","113mm",
                    "2622mm","1597mm","1649mm","-","1577kg","1577kg","-","-","-","70","407 Ltrs","245/45 R18","Tubeless,Radial","-","18 Inch","-","-","-","-",
                    "BS IV","-","INDIA","INDIA","3 Years","100000 kms",String.valueOf(R.drawable.jag),
                    String.valueOf(R.drawable.jag1),String.valueOf(R.drawable.jag2),"1.25 - 1.87 Cr*"));



        }


        if (id ==18 ) {

            carSpec.add(new CarSpec("350 kmph", "2.9 seconds","6498","690.63bhp@5500rpm","690Nm@5500rpm","6.5-litre 690.63bhp 48V V12 Petrol Engine",
                    "6.25 metres","12","4WD","yes","no","4","11.8:1","MPI","7-Speed","-","2","2","4780mm","2265mm","1136mm","125mm",
                    "2700mm","1720mm","1700mm","1575kg","-","-","-","-","-","90","110 Ltrs","255/35 R19,335/30 R20","Tubeless,Radial","-","20 Inch","-","95 X 76.4 mm","-","Dry Double plate",
                    "Euro VI","-","Italy","Italy","-","-",String.valueOf(R.drawable.lambo),
                    String.valueOf(R.drawable.sports),String.valueOf(R.drawable.lambo1),"5.29Cr"));

        }

        if (id ==19 ) {

            carSpec.add(new CarSpec("281 kmph", "4.9 seconds","3436","325bhp@7400rpm","370Nm@4500-5800rpm","3.4-litre 325bhp 24V Petrol Engine",
                    "5.5 metres","6","RWD","no","no","4","12.5:1","Direct Fuel Injection ","7-Speed","Rack & Pinion","2","2","4380mm","1801mm","1295mm","109mm",
                    "2475mm","-","-","1415kg","1665","-","-","-","-","64","425 Ltrs","235/40 R19,265/40 R19","Tubeless,Radial","-","19 Inch","-","-","-","-",
                    "Euro IV","Catalytic Converter","Germany","Germany","2 years","Unlimited kms",String.valueOf(R.drawable.por),
                    String.valueOf(R.drawable.por1),String.valueOf(R.drawable.por2),"1.07 - 1.31 Cr"));


        }


        if (id ==20 ) {

            carSpec.add(new CarSpec("160 Kmph", "15.7 seconds","2596","80.8bhp@3200rpm","230Nm@1800-2000rpm","2.6-litre 80.5bhp OM616 Turbo Diesel Engine",
                    "5.8metres","4","RWD","yes","No","4","18:1","Direct Injection","5-Speed","-","6","3","3992mm","1820mm","2055mm","210mm",
                    "2400mm","1485mm","1440mm","-","2510kg","-","-","-","-","63","500 Ltrs","235/70 R16","Tubeless","-","16 Inch","-","-","-","-",
                    "BS III","-","INDIA","INDIA","3 Years","100000 kms",String.valueOf(R.drawable.force),
                    String.valueOf(R.drawable.off),String.valueOf(R.drawable.force1),"6.32 - 8.59 Lakh"));



        }


        if (id ==20 ) {

            carSpec.add(new CarSpec("160 Kmph", "15.7 seconds","2596","80.8bhp@3200rpm","230Nm@1800-2000rpm","2.6-litre 80.5bhp OM616 Turbo Diesel Engine",
                    "5.8metres","4","RWD","yes","No","4","18:1","Direct Injection","5-Speed","-","6","3","3992mm","1820mm","2055mm","210mm",
                    "2400mm","1485mm","1440mm","-","2510kg","-","-","-","-","63","500 Ltrs","235/70 R16","Tubeless","-","16 Inch","-","-","-","-",
                    "BS III","-","INDIA","INDIA","3 Years","100000 kms",String.valueOf(R.drawable.force),
                    String.valueOf(R.drawable.off),String.valueOf(R.drawable.force1),"6.32 - 8.59 Lakh"));



        }
        if (id ==20 ) {

            carSpec.add(new CarSpec("160 Kmph", "15.7 seconds","2596","80.8bhp@3200rpm","230Nm@1800-2000rpm","2.6-litre 80.5bhp OM616 Turbo Diesel Engine",
                    "5.8metres","4","RWD","yes","No","4","18:1","Direct Injection","5-Speed","-","6","3","3992mm","1820mm","2055mm","210mm",
                    "2400mm","1485mm","1440mm","-","2510kg","-","-","-","-","63","500 Ltrs","235/70 R16","Tubeless","-","16 Inch","-","-","-","-",
                    "BS III","-","INDIA","INDIA","3 Years","100000 kms",String.valueOf(R.drawable.force),
                    String.valueOf(R.drawable.off),String.valueOf(R.drawable.force1),"6.32 - 8.59 Lakh"));



        }
        if (id ==21 ) {

            carSpec.add(new CarSpec("150 Kmph", "11 seconds","2523","63bhp@3200rpm","182.5Nm@1500-1800rpm","2.6-litre 63bhp 16V MDI 3200TC Engine",
                    "6.28metres","4","RWD","yes","No","4","-","Direct Injection","5-Speed","-","7","3","3760mm","1640mm","1904mm","187mm",
                    "2430mm","1314mm","1295mm","-","-","-","-","-","-","45","384 Ltrs","185/85 R16","Tubeless","-","16 Inch","-","-","88.9 x 101.6mm","-",
                    "BS III","-","INDIA","INDIA","1 Years","Unlimited kms",String.valueOf(R.drawable.thar),
                    String.valueOf(R.drawable.thar1),String.valueOf(R.drawable.thar2),"5.98 - 8.86 Lakh"));




        }

        /*if (id ==22 ) {

            carSpec.add(new CarSpec("160 Kmph", "15.7 seconds","2596","80.8bhp@3200rpm","230Nm@1800-2000rpm","2.6-litre 80.5bhp OM616 Turbo Diesel Engine",
                    "5.8metres","4","RWD","yes","No","4","18:1","Direct Injection","5-Speed","-","6","3","3992mm","1820mm","2055mm","210mm",
                    "2400mm","1485mm","1440mm","-","2510kg","-","-","-","-","63","500 Ltrs","235/70 R16","Tubeless","-","16 Inch","-","-","-","-",
                    "BS III","-","INDIA","INDIA","3 Years","100000 kms",String.valueOf(R.drawable.force),
                    String.valueOf(R.drawable.off),String.valueOf(R.drawable.force1),"6.32 - 8.59 Lakh"));



        }*/



        updateUI();

    }

    public void updateUI()
    {
        for (CarSpec car : carSpec) {

                    top_Speed.setText(car.getTop_Speed());
                    acceleration.setText(car.getAcceleration());
                    engineDisplacement.setText(car.getEngineDisplacement());
                    maximumPower.setText(car.getMaximumPower());
                    maximumTorque.setText(car.getMaximumTorque());
                    engineDescription.setText(car.getEngineDescription());
                    turningRadius.setText(car.getTurningRadius());
                    cylindersNum.setText(car.getCylindersNum());
                    driveType.setText(car.getDriveType());
                    turboCharger.setText(car.getTurboCharger());
                    superCharger.setText(car.getSuperCharger());
                    valvesPerCylinder.setText(car.getValvesPerCylinder());
                    compressionRatio.setText(car.getCompressionRatio());
                    fuelSupplySystem.setText(car.getFuelSupplySystem());
                    gearBox.setText(car.getGearBox());
                    steeringGearType.setText(car.getSteeringGearType());
                    seatingCapacity.setText(car.getSeatingCapacity());
                    NumDoors.setText(car.getNumDoors());
                    length.setText(car.getLength());
                    lengthWidth.setText(car.getLengthWidth());
                    lengthHeight.setText(car.getLengthHeight());
                    groundClearance.setText(car.getGroundClearance());
                    wheelBase.setText(car.getWheelBase());
                    frontTread.setText(car.getFrontTread());
                    rearTread.setText(car.getRearTread());
                    kerbWeight.setText(car.getKerbWeight());
                    grossWeight.setText(car.getGrossWeight());
                    frontHeadroom.setText(car.getFrontHeadroom());
                    frontLegroom.setText(car.getFrontLegroom());
                    rearHeadroom.setText(car.getRearHeadroom());
                    rearLegroom.setText(car.getRearLegroom());
                    fuelTankCapacity.setText(car.getFuelTankCapacity());
                    cargoVolume.setText(car.getCargoVolume());
                    tyreSize.setText(car.getTyreSize());
                    tyreType.setText(car.getTyreType());
                    wheelSize.setText(car.getWheelSize());
                    alloyWheelSize.setText(car.getAlloyWheelSize());
                    NumFloors.setText(car.getNumFloors());
                    borexStroke.setText(car.getBorexStroke());
                    synchronizers.setText(car.getSynchronizers());
                    clutchType.setText(car.getClutchType());
                    emissionNormCompliance.setText(car.getEmissionNormCompliance());
                    emissionControlSystem.setText(car.getEmissionControlSystem());
                    countryofAssembly.setText(car.getCountryofAssembly());
                    countryofManufacture.setText(car.getCountryofManufacture());
                    warrantyTime.setText(car.getWarrantyTime());
                    warrantyDistance.setText(car.getWarrantyDistance());
                    price.setText(car.getPrice());
            stringArrayList.add(Integer.parseInt(car.getImage1()));
            stringArrayList.add(Integer.parseInt(car.getImage2()));
            stringArrayList.add(Integer.parseInt(car.getImage3()));
            init();

        }
    }
    private void init() {

        mPager = (ViewPager) findViewById(R.id.pager);


        mPager.setAdapter(new SlidingImage_Adapter(CarDetailsActivity.this,stringArrayList));


        CirclePageIndicator indicator = (CirclePageIndicator)
                findViewById(R.id.indicator);

        indicator.setViewPager(mPager);

        final float density = getResources().getDisplayMetrics().density;

//Set circle indicator radius
        indicator.setRadius(5 * density);

        NUM_PAGES =IMAGES.length;

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000, 3000);

        // Pager listener over indicator
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;

            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

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
