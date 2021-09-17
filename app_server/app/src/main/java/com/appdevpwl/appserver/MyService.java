package com.appdevpwl.appserver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.Nullable;


import com.appdevpwl.appserver.model.StationItem;
import com.appdevpwl.appserver.network.RetrofitService;
import com.appdevpwl.appserver.network.StationItemApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyService extends Service {

    List<StationItem> stationsList;


    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();


        StationItemApi stationItemApi = RetrofitService.createService(StationItemApi.class);
        Call<List<StationItem>> items = stationItemApi.getStations();


        items.enqueue(new Callback<List<StationItem>>() {
            @Override
            public void onResponse(Call<List<StationItem>> call, Response<List<StationItem>> response) {
                stationsList = response.body();

            }

            @Override
            public void onFailure(Call<List<StationItem>> call, Throwable t) {
                Log.d("errr", t.toString());
            }
        });
    }

    private final MyImpl impl = new MyImpl();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return impl;
    }

    private class MyImpl extends IRemoteService.Stub {


        @Override
        public List<StationItem> getStations() throws RemoteException {
            return stationsList;
        }
    }

}
