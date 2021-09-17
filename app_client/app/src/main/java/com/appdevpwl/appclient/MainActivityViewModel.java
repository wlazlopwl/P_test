package com.appdevpwl.appclient;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.appdevpwl.appserver.IRemoteService;


public class MainActivityViewModel extends ViewModel {

    private final MutableLiveData<IRemoteService> _manager = new MutableLiveData<>();

    private final ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IRemoteService iRemoteService = IRemoteService.Stub.asInterface(iBinder);
            _manager.postValue(iRemoteService);
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    public LiveData<IRemoteService> getManager() {
        return _manager;
    }

    public ServiceConnection getServiceConnection() {
        return serviceConnection;
    }


}
