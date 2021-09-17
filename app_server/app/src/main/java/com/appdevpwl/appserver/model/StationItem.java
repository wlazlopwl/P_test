package com.appdevpwl.appserver.model;

import android.os.Parcel;
import android.os.Parcelable;

public class StationItem implements Parcelable {
    public int id;
    public String stationName;
    public String gegrLat;
    public String gegrLon;
    public String addressStreet;

    protected StationItem(Parcel in) {
        id = in.readInt();
        stationName = in.readString();
        gegrLat = in.readString();
        gegrLon = in.readString();
        addressStreet = in.readString();
    }

    public static final Creator<StationItem> CREATOR = new Creator<StationItem>() {
        @Override
        public StationItem createFromParcel(Parcel in) {
            return new StationItem(in);
        }

        @Override
        public StationItem[] newArray(int size) {
            return new StationItem[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(stationName);
        parcel.writeString(gegrLat);
        parcel.writeString(gegrLon);
        parcel.writeString(addressStreet);
    }
}
