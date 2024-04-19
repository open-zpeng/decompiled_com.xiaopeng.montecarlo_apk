package com.xiaopeng.lib.apirouter.server;

import android.os.IBinder;
import android.util.Pair;
import androidx.annotation.Keep;
import java.util.HashMap;
@Keep
/* loaded from: classes2.dex */
public class ManifestHelper {
    public static HashMap<String, Pair<IBinder, String>> mapping = new HashMap<>();

    static {
        Pair<IBinder, String> pair = new Pair<>(new NaviSpeechParser_Stub(), NaviSpeechParser_Manifest.toJsonManifest());
        for (String str : NaviSpeechParser_Manifest.getKey()) {
            mapping.put(str, pair);
        }
        Pair<IBinder, String> pair2 = new Pair<>(new FullScenesObserver_Stub(), FullScenesObserver_Manifest.toJsonManifest());
        for (String str2 : FullScenesObserver_Manifest.getKey()) {
            mapping.put(str2, pair2);
        }
        Pair<IBinder, String> pair3 = new Pair<>(new AosService_Stub(), AosService_Manifest.toJsonManifest());
        for (String str3 : AosService_Manifest.getKey()) {
            mapping.put(str3, pair3);
        }
        Pair<IBinder, String> pair4 = new Pair<>(new SpeechOverallObserver_Stub(), SpeechOverallObserver_Manifest.toJsonManifest());
        for (String str4 : SpeechOverallObserver_Manifest.getKey()) {
            mapping.put(str4, pair4);
        }
        Pair<IBinder, String> pair5 = new Pair<>(new GuideInfoService_Stub(), GuideInfoService_Manifest.toJsonManifest());
        for (String str5 : GuideInfoService_Manifest.getKey()) {
            mapping.put(str5, pair5);
        }
        Pair<IBinder, String> pair6 = new Pair<>(new RouteByPhoneService_Stub(), RouteByPhoneService_Manifest.toJsonManifest());
        for (String str6 : RouteByPhoneService_Manifest.getKey()) {
            mapping.put(str6, pair6);
        }
        Pair<IBinder, String> pair7 = new Pair<>(new MapStatusService_Stub(), MapStatusService_Manifest.toJsonManifest());
        for (String str7 : MapStatusService_Manifest.getKey()) {
            mapping.put(str7, pair7);
        }
        Pair<IBinder, String> pair8 = new Pair<>(new AccountDataService_Stub(), AccountDataService_Manifest.toJsonManifest());
        for (String str8 : AccountDataService_Manifest.getKey()) {
            mapping.put(str8, pair8);
        }
        Pair<IBinder, String> pair9 = new Pair<>(new SearchService_Stub(), SearchService_Manifest.toJsonManifest());
        for (String str9 : SearchService_Manifest.getKey()) {
            mapping.put(str9, pair9);
        }
        Pair<IBinder, String> pair10 = new Pair<>(new CallThirdPartLoginService_Stub(), CallThirdPartLoginService_Manifest.toJsonManifest());
        for (String str10 : CallThirdPartLoginService_Manifest.getKey()) {
            mapping.put(str10, pair10);
        }
        Pair<IBinder, String> pair11 = new Pair<>(new MapVPAService_Stub(), MapVPAService_Manifest.toJsonManifest());
        for (String str11 : MapVPAService_Manifest.getKey()) {
            mapping.put(str11, pair11);
        }
        Pair<IBinder, String> pair12 = new Pair<>(new MapMarkService_Stub(), MapMarkService_Manifest.toJsonManifest());
        for (String str12 : MapMarkService_Manifest.getKey()) {
            mapping.put(str12, pair12);
        }
        Pair<IBinder, String> pair13 = new Pair<>(new CarGreetingInfoService_Stub(), CarGreetingInfoService_Manifest.toJsonManifest());
        for (String str13 : CarGreetingInfoService_Manifest.getKey()) {
            mapping.put(str13, pair13);
        }
        Pair<IBinder, String> pair14 = new Pair<>(new ChargeStationService_Stub(), ChargeStationService_Manifest.toJsonManifest());
        for (String str14 : ChargeStationService_Manifest.getKey()) {
            mapping.put(str14, pair14);
        }
        Pair<IBinder, String> pair15 = new Pair<>(new LicensePlateService_Stub(), LicensePlateService_Manifest.toJsonManifest());
        for (String str15 : LicensePlateService_Manifest.getKey()) {
            mapping.put(str15, pair15);
        }
        Pair<IBinder, String> pair16 = new Pair<>(new FatigueDrivingAssistanceService_Stub(), FatigueDrivingAssistanceService_Manifest.toJsonManifest());
        for (String str16 : FatigueDrivingAssistanceService_Manifest.getKey()) {
            mapping.put(str16, pair16);
        }
        Pair<IBinder, String> pair17 = new Pair<>(new IpcRouterService_Stub(), IpcRouterService_Manifest.toJsonManifest());
        for (String str17 : IpcRouterService_Manifest.getKey()) {
            mapping.put(str17, pair17);
        }
    }
}
