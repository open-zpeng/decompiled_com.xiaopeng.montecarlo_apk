package com.xiaopeng.montecarlo.root.util.storage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.storage.StorageManager;
import android.text.TextUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.montecarlo.root.util.config.DebugConfiguration;
import java.io.File;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes3.dex */
public class USBUtil {
    private static final L.Tag TAG = new L.Tag("USBUtil");
    private static final String USB_DEVICE_TAG = "/storage/";
    private IntentFilter mUsbDeviceStateFilter;
    private String mUsbPath;
    private final List<IUsbStorageListener> mListeners = new CopyOnWriteArrayList();
    BroadcastReceiver mUsbReceiver = new BroadcastReceiver() { // from class: com.xiaopeng.montecarlo.root.util.storage.USBUtil.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("android.intent.action.MEDIA_MOUNTED".equals(action) || DebugConfiguration.RegisterAction.MOUNTED_USB.equals(action)) {
                Uri data = intent.getData();
                String path = data != null ? data.getPath() : null;
                L.Tag tag = USBUtil.TAG;
                L.i(tag, "receive mountpath:" + path);
                if (!TextUtils.isEmpty(path) && path.contains(USBUtil.USB_DEVICE_TAG)) {
                    USBUtil.this.mUsbPath = path;
                    WorkThreadUtil.getInstance().executeIOTask(new Runnable() { // from class: com.xiaopeng.montecarlo.root.util.storage.USBUtil.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            for (IUsbStorageListener iUsbStorageListener : USBUtil.this.mListeners) {
                                iUsbStorageListener.onMount(USBUtil.this.mUsbPath);
                            }
                        }
                    });
                }
                L.Tag tag2 = USBUtil.TAG;
                L.i(tag2, "mount:" + USBUtil.this.mUsbPath);
            } else if ("android.intent.action.MEDIA_UNMOUNTED".equals(action)) {
                if (L.ENABLE) {
                    L.d(USBUtil.TAG, action);
                }
                WorkThreadUtil.getInstance().executeIOTask(new Runnable() { // from class: com.xiaopeng.montecarlo.root.util.storage.USBUtil.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        for (IUsbStorageListener iUsbStorageListener : USBUtil.this.mListeners) {
                            iUsbStorageListener.onUnmount();
                        }
                    }
                });
                USBUtil.this.mUsbPath = null;
            }
        }
    };

    public USBUtil() {
        this.mUsbDeviceStateFilter = null;
        this.mUsbPath = null;
        if (this.mUsbDeviceStateFilter == null) {
            this.mUsbDeviceStateFilter = new IntentFilter();
            this.mUsbDeviceStateFilter.addDataScheme("file");
            this.mUsbDeviceStateFilter.addAction("android.intent.action.MEDIA_MOUNTED");
            this.mUsbDeviceStateFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
            this.mUsbDeviceStateFilter.addAction("android.intent.action.MEDIA_EJECT");
            this.mUsbDeviceStateFilter.addAction(DebugConfiguration.RegisterAction.MOUNTED_USB);
            ContextUtils.getContext().registerReceiver(this.mUsbReceiver, this.mUsbDeviceStateFilter);
            this.mUsbPath = getUDiskPath(ContextUtils.getContext());
            L.Tag tag = TAG;
            L.i(tag, "register usbDeviceStateFilter init usb path:" + this.mUsbPath);
        }
    }

    public String getUsbPath() {
        return this.mUsbPath;
    }

    public void addUsbStorageListener(IUsbStorageListener iUsbStorageListener) {
        if (iUsbStorageListener == null || this.mListeners.contains(iUsbStorageListener)) {
            return;
        }
        this.mListeners.add(iUsbStorageListener);
    }

    public void removeUsbStorageListener(IUsbStorageListener iUsbStorageListener) {
        this.mListeners.remove(iUsbStorageListener);
    }

    private String getUDiskPath(Context context) {
        StorageManager storageManager = (StorageManager) context.getSystemService("storage");
        if (storageManager != null) {
            try {
                Class<?> cls = Class.forName("android.os.storage.VolumeInfo");
                Method method = storageManager.getClass().getMethod("getVolumes", new Class[0]);
                Method method2 = cls.getMethod("getDisk", new Class[0]);
                Method method3 = cls.getMethod("getPath", new Class[0]);
                Method method4 = Class.forName("android.os.storage.DiskInfo").getMethod("isUsb", new Class[0]);
                List list = (List) method.invoke(storageManager, new Object[0]);
                if (list != null) {
                    for (Object obj : list) {
                        L.Tag tag = TAG;
                        L.i(tag, "volumeInfo:" + obj.toString());
                        Object invoke = method2.invoke(obj, new Object[0]);
                        if (invoke != null && ((Boolean) method4.invoke(invoke, new Object[0])).booleanValue()) {
                            File file = (File) method3.invoke(obj, new Object[0]);
                            if (file != null) {
                                return file.getPath();
                            }
                            return null;
                        }
                    }
                }
            } catch (Exception e) {
                L.w(TAG, e.toString());
            }
        }
        return null;
    }
}
