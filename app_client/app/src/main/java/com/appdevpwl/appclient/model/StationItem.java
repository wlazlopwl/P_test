package com.appdevpwl.appclient.model;

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

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(stationName);
        dest.writeString(gegrLat);
        dest.writeString(gegrLon);
        dest.writeString(addressStreet);
    }

    @Override
    public int describeContents() {
        return 0;
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
}