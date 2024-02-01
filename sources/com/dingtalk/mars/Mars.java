package com.dingtalk.mars;

import android.content.Context;
import android.os.Handler;
import com.dingtalk.mars.comm.PlatformComm;
import com.dingtalk.mobile.common.transport.utils.BifrostLogCatUtil;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class Mars {
    private static ArrayList<String[]> libModules = new ArrayList<>();
    private static volatile boolean hasInitialized = false;

    public static void loadDefaultMarsLibrary() {
        try {
            System.loadLibrary("stlport_shared");
            System.loadLibrary("Bifrost");
        } catch (Throwable th) {
            BifrostLogCatUtil.error("bifrost.Mars", "", th);
        }
    }

    public static synchronized void checkLoadedModules(ArrayList<String> arrayList, String str) {
        synchronized (Mars.class) {
            if (arrayList == null) {
                return;
            }
            int i = 0;
            String[] strArr = new String[0];
            BifrostLogCatUtil.info(str, "loaded modules: " + Arrays.toString(arrayList.toArray(strArr)));
            Arrays.sort(strArr);
            libModules.add(strArr);
            boolean z = true;
            for (int i2 = 0; i2 < libModules.size(); i2++) {
                if (!Arrays.equals(libModules.get(i2), libModules.get(0))) {
                    z = false;
                }
            }
            if (!z) {
                while (i < libModules.size()) {
                    int i3 = i + 1;
                    boolean z2 = z;
                    for (int i4 = i3; i4 < libModules.size() && (!hasInterSection(libModules.get(i), libModules.get(i4))); i4++) {
                    }
                    z = z2;
                    if (!z) {
                        break;
                    }
                    i = i3;
                }
            }
            if (z) {
                return;
            }
            throw new IllegalStateException("mars lib module custom made error, pls check your *.so.");
        }
    }

    public static void init(Context context, Handler handler) {
        PlatformComm.init(context, handler);
        hasInitialized = true;
    }

    public static void onCreate(boolean z) {
        if (z && hasInitialized) {
            BaseEvent.onCreate();
        } else if (!z) {
            BaseEvent.onCreate();
        } else {
            throw new IllegalStateException("function MarsCore.init must be executed before Mars.onCreate when application firststartup.");
        }
    }

    public static void onDestroy() {
        BaseEvent.onDestroy();
    }

    private static boolean hasInterSection(String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(str);
        }
        for (String str2 : strArr2) {
            if (arrayList.contains(str2)) {
                return true;
            }
        }
        return false;
    }
}
