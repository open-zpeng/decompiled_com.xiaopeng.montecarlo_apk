package com.xiaopeng.montecarlo.base.scene;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.HashMap;
/* loaded from: classes2.dex */
public final class XPBroadcastImpl implements IXPBroadcast {
    private static final L.Tag TAG = new L.Tag("XPBroadcastImpl");
    private final Context mContext;
    private IXPBroadcastReceiver mXPBroadcastReceiver;
    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() { // from class: com.xiaopeng.montecarlo.base.scene.XPBroadcastImpl.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            HashMap<String, String> hashMap;
            String action = intent.getAction();
            String[] dataKeys = XPBroadcastImpl.this.mXPBroadcastReceiver.getDataKeys();
            if (dataKeys != null) {
                hashMap = new HashMap<>();
                for (String str : dataKeys) {
                    hashMap.put(str, intent.getStringExtra(str));
                }
            } else {
                hashMap = null;
            }
            XPBroadcastImpl.this.mXPBroadcastReceiver.onReceive(action, hashMap);
        }
    };
    private boolean mIsRegistered = false;

    public XPBroadcastImpl(@NonNull Context context) {
        this.mContext = context;
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IXPBroadcast
    public void register() {
        if (this.mIsRegistered) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        for (String str : this.mXPBroadcastReceiver.getActions()) {
            intentFilter.addAction(str);
        }
        this.mContext.registerReceiver(this.mBroadcastReceiver, intentFilter);
        this.mIsRegistered = true;
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IXPBroadcast
    public void unregister() {
        L.i(TAG, "unregister-----------------------");
        if (this.mIsRegistered) {
            this.mContext.unregisterReceiver(this.mBroadcastReceiver);
            this.mIsRegistered = false;
        }
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IXPBroadcast
    public void setReceiver(IXPBroadcastReceiver iXPBroadcastReceiver) {
        this.mXPBroadcastReceiver = iXPBroadcastReceiver;
    }
}
