package com.appdevpwl.appserver.network;
import com.appdevpwl.appserver.model.StationItem;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface StationItemApi {

    @GET("station/findAll")
    Call<List<StationItem>> getStations();


}
