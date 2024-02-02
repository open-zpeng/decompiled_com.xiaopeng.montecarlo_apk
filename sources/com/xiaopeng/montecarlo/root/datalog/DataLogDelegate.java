package com.xiaopeng.montecarlo.root.datalog;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.xiaopeng.datalog.DataLogModuleEntry;
import com.xiaopeng.datalog.MoleEvent;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEventBuilder;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import java.util.Map;
/* loaded from: classes2.dex */
public class DataLogDelegate implements Handler.Callback {
    private static final long INTERVAL = 1800000;
    private static final int MSG_UPLOAD = 1;
    protected static final L.Tag TAG = new L.Tag("DataLogDelegate");
    private boolean mIsTableApp;
    private long mStepID;
    private long mSessionId = -1;
    private Handler mH = new Handler(WorkThreadUtil.getInstance().getDataProcessThreadLooper(), this);

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataLogDelegate(boolean z) {
        this.mIsTableApp = z;
        Module.register(DataLogModuleEntry.class, new DataLogModuleEntry(ContextUtils.getContext()));
    }

    public void onStart() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.mSessionId;
        if (currentTimeMillis - j > INTERVAL || j == -1) {
            this.mSessionId = System.currentTimeMillis();
            this.mStepID = 1L;
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            DataLogMessage dataLogMessage = (DataLogMessage) message.obj;
            sendStatData(dataLogMessage.getEventName(), dataLogMessage.getPageId(), dataLogMessage.getButtonId(), dataLogMessage.getLevel(), dataLogMessage.getParaMap());
        }
        return true;
    }

    public void sendStatData(DataLogMessage dataLogMessage) {
        if (dataLogMessage != null) {
            Message obtainMessage = this.mH.obtainMessage();
            obtainMessage.what = 1;
            obtainMessage.obj = dataLogMessage;
            this.mH.sendMessage(obtainMessage);
        }
    }

    private void sendStatData(String str, String str2, String str3, int i, Map<String, Object> map) {
        IDataLog iDataLog;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        String str4 = null;
        if (map != null && map.size() > 0) {
            str4 = GsonUtil.toJson(map);
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.v(tag, "sendStatData eventName:" + str + "  pageId:" + str2 + "  buttonId:" + str3 + " para:" + str4);
        }
        if (this.mIsTableApp || (iDataLog = (IDataLog) Module.get(DataLogModuleEntry.class).get(IDataLog.class)) == null) {
            return;
        }
        IStatEventBuilder property = iDataLog.buildStat().setEventName(str).setProperty("session_id", Long.valueOf(this.mSessionId));
        long j = this.mStepID;
        this.mStepID = 1 + j;
        IStatEventBuilder property2 = property.setProperty("step_id", Long.valueOf(j)).setProperty("csid", Long.valueOf(System.currentTimeMillis())).setProperty(MoleEvent.KEY_PAGE_ID, str2).setProperty(MoleEvent.KEY_BUTTON_ID, str3).setProperty("level", Integer.valueOf(i));
        if (!TextUtils.isEmpty(str4)) {
            property2 = property2.setProperty("para", str4);
        }
        iDataLog.sendStatData(property2.build());
    }
}
