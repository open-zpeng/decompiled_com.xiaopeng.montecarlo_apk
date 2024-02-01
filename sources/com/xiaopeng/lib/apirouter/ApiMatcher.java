package com.xiaopeng.lib.apirouter;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
class ApiMatcher {
    private static final String PROCESS_TAG_DIVIDER = "@";
    private ConcurrentHashMap<String, RemoteOperator> mRemoteOperators = new ConcurrentHashMap<>();

    public synchronized void publishUri(@NonNull UriStruct uriStruct, @NonNull RemoteOperator remoteOperator) {
        String str;
        RemoteOperator put;
        String str2 = uriStruct.processTag;
        if (!TextUtils.isEmpty(str2)) {
            str = str2 + PROCESS_TAG_DIVIDER + uriStruct.targetUid;
        } else {
            str = "" + uriStruct.targetUid;
        }
        String str3 = uriStruct.applicationId + "." + uriStruct.serviceName;
        RemoteOperator put2 = put(str, str3, remoteOperator);
        if (put2 != null) {
            put2.unLinkToDeath("getAuthority");
        }
        if (!str3.equals(remoteOperator.getDescription()) && (put = put(str, remoteOperator.getDescription(), remoteOperator)) != null) {
            put.unLinkToDeath("getDescription");
        }
        remoteOperator.linkToDeath();
    }

    public synchronized void unpublishUri(@NonNull UriStruct uriStruct) {
        String str;
        RemoteOperator remoteOperator = getRemoteOperator(uriStruct);
        if (remoteOperator != null) {
            String str2 = uriStruct.processTag;
            if (!TextUtils.isEmpty(str2)) {
                str = str2 + PROCESS_TAG_DIVIDER + uriStruct.targetUid;
            } else {
                str = "" + uriStruct.targetUid;
            }
            String str3 = uriStruct.applicationId + "." + uriStruct.serviceName;
            remove(str, str3);
            if (!str3.equals(remoteOperator.getDescription())) {
                remove(str, remoteOperator.getDescription());
            }
            remoteOperator.unLinkToDeath("unpublishUri");
        }
    }

    public synchronized RemoteOperator matchRemoteOperator(@NonNull UriStruct uriStruct) {
        return getRemoteOperator(uriStruct);
    }

    private RemoteOperator put(String str, String str2, RemoteOperator remoteOperator) {
        if (str2.startsWith("com.xiaopeng.homespace")) {
            Log.i("ApiMatcher", "Don't cache homespace app!!");
            return remoteOperator;
        }
        if (!TextUtils.isEmpty(str)) {
            str2 = str + PROCESS_TAG_DIVIDER + str2;
        }
        return this.mRemoteOperators.put(str2, remoteOperator);
    }

    private void remove(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            str2 = str + PROCESS_TAG_DIVIDER + str2;
        }
        this.mRemoteOperators.remove(str2);
    }

    private RemoteOperator getRemoteOperator(@NonNull UriStruct uriStruct) {
        Set<Map.Entry<String, RemoteOperator>> entrySet = this.mRemoteOperators.entrySet();
        String str = uriStruct.processTag;
        String str2 = !TextUtils.isEmpty(str) ? str + PROCESS_TAG_DIVIDER + uriStruct.targetUid : "" + uriStruct.targetUid;
        String str3 = !TextUtils.isEmpty(str2) ? str2 + PROCESS_TAG_DIVIDER + uriStruct.applicationId + "." : uriStruct.applicationId + ".";
        String str4 = "." + uriStruct.serviceName;
        for (Map.Entry<String, RemoteOperator> entry : entrySet) {
            String key = entry.getKey();
            if (key.startsWith(str3) && key.endsWith(str4)) {
                return entry.getValue();
            }
        }
        return null;
    }
}
