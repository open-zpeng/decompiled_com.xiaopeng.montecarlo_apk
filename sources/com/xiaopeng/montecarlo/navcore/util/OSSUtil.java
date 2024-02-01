package com.xiaopeng.montecarlo.navcore.util;

import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.remotestorage.Callback;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.remotestorage.StorageException;
import com.xiaopeng.montecarlo.navcore.httpclient.HttpClientManager;
import com.xiaopeng.montecarlo.root.util.L;
import java.io.File;
/* loaded from: classes3.dex */
public class OSSUtil {
    private static final L.Tag TAG = new L.Tag("OSSUtil");

    public static void download(String str, String str2, String str3, Callback callback) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "download bucket:" + str + " url:" + str2 + " dest:" + str3);
        }
        try {
            File parentFile = new File(str3).getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            HttpClientManager.getInstance().getRemoteStorage().downloadWithPathAndCallback(str, str2, str3, callback);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static OSSResult downloadSync(String str, String str2, String str3) {
        final OSSResult oSSResult = new OSSResult();
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "downloadSync bucket:" + str + " url:" + str2 + " dest:" + str3);
        }
        final Object obj = new Object();
        Callback callback = new Callback() { // from class: com.xiaopeng.montecarlo.navcore.util.OSSUtil.1
            @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.remotestorage.Callback
            public void onStart(String str4, String str5) {
            }

            @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.remotestorage.Callback
            public void onSuccess(String str4, String str5) {
                if (L.ENABLE) {
                    L.d(OSSUtil.TAG, "downloadSync onSuccess");
                }
                OSSResult.this.setLocalFilePath(str5);
                synchronized (obj) {
                    obj.notify();
                }
            }

            @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.remotestorage.Callback
            public void onFailure(String str4, String str5, StorageException storageException) {
                if (L.ENABLE) {
                    L.Tag tag2 = OSSUtil.TAG;
                    L.d(tag2, "downloadSync onFailure:" + storageException.getMessage());
                }
                synchronized (obj) {
                    obj.notify();
                }
            }
        };
        try {
            File parentFile = new File(str3).getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            HttpClientManager.getInstance().getRemoteStorage().downloadWithPathAndCallback(str, str2, str3, callback);
            synchronized (obj) {
                obj.wait();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return oSSResult;
    }

    /* loaded from: classes3.dex */
    public static class OSSResult {
        private String mLocalFilePath;

        public synchronized String getLocalFilePath() {
            return this.mLocalFilePath;
        }

        public synchronized void setLocalFilePath(String str) {
            this.mLocalFilePath = str;
        }
    }
}
