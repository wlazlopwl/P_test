package com.appdevpwl.appclient;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.appdevpwl.appclient.model.StationItem;

import java.util.List;

public class MainActivityAdapter extends RecyclerView.Adapter<MainActivityAdapter.ViewHolder> {

    private final List<StationItem> stationItemList;


    public MainActivityAdapter(List<StationItem> stationItemList) {
        this.stationItemList = stationItemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.stations_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.stationName.setText(stationItemList.get(position).stationName);
    }

    @Override
    public int getItemCount() {
        return stationItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView stationName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            stationName = itemView.findViewById(R.id.station_name);
        }
    }
}
