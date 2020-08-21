package com.createsapp.riderappjava.Callback;

import com.createsapp.riderappjava.model.DriverGeoModel;

public interface IFirebaseDriverInfoListener {
    void onDriverInfoLoadSuccess(DriverGeoModel driverGeoModel);
}
