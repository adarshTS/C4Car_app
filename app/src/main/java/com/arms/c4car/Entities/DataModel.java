package com.arms.c4car.Entities;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by SHIVAA on 15-10-2016.
 */

public class DataModel implements Parcelable {

    private int carId;
    private String carTitle;

    public DataModel(int carId, String carTitle) {
        this.carId = carId;
        this.carTitle = carTitle;
    }

    private String carDescription;
    private String carImage;
    private String carShort_description;

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getCarTitle() {
        return carTitle;
    }

    public void setCarTitle(String carTitle) {
        this.carTitle = carTitle;
    }

    public String getCarDescription() {
        return carDescription;
    }

    public void setCarDescription(String carDescription) {
        this.carDescription = carDescription;
    }

    public String getCarImage() {
        return carImage;
    }

    public void setCarImage(String carImage) {
        this.carImage = carImage;
    }

    public String getCarShort_description() {
        return carShort_description;
    }

    public void setCarShort_description(String carShort_description) {
        this.carShort_description = carShort_description;
    }

    public DataModel(int carId, String carTitle, String carDescription, String carImage, String carShort_description) {
        this.carId = carId;
        this.carTitle = carTitle;
        this.carDescription = carDescription;
        this.carImage = carImage;
        this.carShort_description = carShort_description;
    }

    protected DataModel(Parcel in) {
    }

    public static final Creator<DataModel> CREATOR = new Creator<DataModel>() {
        @Override
        public DataModel createFromParcel(Parcel in) {
            return new DataModel(in);
        }

        @Override
        public DataModel[] newArray(int size) {
            return new DataModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }
}
