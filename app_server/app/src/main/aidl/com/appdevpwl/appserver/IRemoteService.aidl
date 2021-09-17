// IRemoteService.aidl
package com.appdevpwl.appserver;
import com.appdevpwl.appserver.StationItem;


// Declare any non-default types here with import statements

interface IRemoteService {
    List<StationItem> getStations();

}