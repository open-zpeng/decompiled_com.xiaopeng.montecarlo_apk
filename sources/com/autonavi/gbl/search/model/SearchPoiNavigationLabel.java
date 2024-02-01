package com.autonavi.gbl.search.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class SearchPoiNavigationLabel {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int EmergencyEntrance = 9;
    public static final int EmergencyEntranceExit = 10;
    public static final int EmergencyExit = 8;
    public static final int NoNavigationInfo = 0;
    public static final int NonPassableDoor = 18;
    public static final int PedestrianEntrance = 12;
    public static final int PedestrianEntranceExit = 4;
    public static final int PedestrianExit = 11;
    public static final int RestrictedEntrance = 14;
    public static final int RestrictedEntranceExit = 15;
    public static final int RestrictedExit = 13;
    public static final int VehicleEntrance = 2;
    public static final int VehicleEntranceExit = 3;
    public static final int VehicleEntrancePedestrianEntranceExit = 17;
    public static final int VehicleExit = 1;
    public static final int VehicleExitPedestrianEntranceExit = 16;
    public static final int VehiclePedestrianEntrance = 6;
    public static final int VehiclePedestrianEntranceExit = 7;
    public static final int VehiclePedestrianExit = 5;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface SearchPoiNavigationLabel1 {
    }
}
