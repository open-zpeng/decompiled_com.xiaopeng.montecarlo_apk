package com.xiaopeng.montecarlo.service.navi.binder;

import android.content.Context;
import android.os.IBinder;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class NaviServiceManager {
    public static final String NAVI_STATUS = "NAVI_STATUS";
    private static final HashMap<String, Class<?>> sServices = new HashMap<>();
    private HashMap<String, IBinderService> mMap;

    static {
        sServices.put(NAVI_STATUS, NaviStatusService.class);
    }

    public IBinder getService(String str) {
        IBinderService iBinderService = this.mMap.get(str);
        if (iBinderService != null) {
            return iBinderService.getBinder();
        }
        return null;
    }

    public void onCreate(Context context) {
        this.mMap = new HashMap<>();
        for (String str : sServices.keySet()) {
            Class<?> cls = sServices.get(str);
            if (cls != null) {
                try {
                    IBinderService iBinderService = (IBinderService) cls.newInstance();
                    iBinderService.onCreate(context);
                    this.mMap.put(str, iBinderService);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void onDestroy() {
        for (String str : this.mMap.keySet()) {
            IBinderService iBinderService = this.mMap.get(str);
            if (iBinderService != null) {
                iBinderService.onDestroy();
            }
        }
        this.mMap.clear();
    }
}
