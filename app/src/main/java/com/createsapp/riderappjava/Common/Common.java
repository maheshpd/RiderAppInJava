package com.createsapp.riderappjava.Common;

import com.createsapp.riderappjava.model.RiderModel;

public class Common {
    public static final String RIDER_INFO_REFERENCE = "Riders";
    public static RiderModel currentRider;

    public static String buildwelcomeMessage() {
        if (Common.currentRider != null) {
            return new StringBuilder("Welcome ")
                    .append(Common.currentRider.getFirstName())
                    .append("")
                    .append(Common.currentRider.getLastName()).toString();
        } else
            return "";
    }
}
