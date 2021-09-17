package com.appdevpwl.appclient;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.appdevpwl.appserver.IRemoteService;


public class MainActivity extends AppCompatActivity {


    Button button;
    private RecyclerView recyclerView;

    private MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        recyclerView = findViewById(R.id.stations_rv);
        initAIDLService();


        button = findViewById(R.id.get_stations_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    getStations();


                } catch (RemoteException e) {
                    Log.e("result", "Fail ", e);
                    e.printStackTrace();
                }
            }
        });
    }


    private void initAIDLService() {
        Intent intent = new Intent("com.appdevpwl.appserver.IMathManager");
        intent.setPackage("com.appdevpwl.appserver");
        bindService(intent, viewModel.getServiceConnection(), Context.BIND_AUTO_CREATE);
    }

    private void getStations() throws RemoteException {
        viewModel.getManager().observe(this, new Observer<IRemoteService>() {
            @Override
            public void onChanged(IRemoteService iRemoteService) {
                try {
                    MainActivityAdapter adapter = new MainActivityAdapter(iRemoteService.getStations());
                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, true));
                    recyclerView.setNestedScrollingEnabled(false);
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setAdapter(adapter);

                    adapter.notifyDataSetChanged();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
    }


}