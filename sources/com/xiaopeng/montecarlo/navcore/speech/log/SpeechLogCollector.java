package com.xiaopeng.montecarlo.navcore.speech.log;

import android.os.Process;
import com.autonavi.common.tool.FDManager;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes2.dex */
public class SpeechLogCollector implements ILogCollector {
    private static final DateFormat sDateFormat = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.CHINA);
    private ConcurrentLinkedQueue<String> mSpeechLogList = new ConcurrentLinkedQueue<>();

    @Override // com.xiaopeng.montecarlo.navcore.speech.log.ILogCollector
    public void record(int i, String str) {
        SpeechLogRecord speechLogRecord = new SpeechLogRecord();
        speechLogRecord.setWhat(i).setTimeStr(sDateFormat.format(new Date())).setProcessThread(Process.myPid()).setChildThread(Process.myTid()).setMsg(str);
        this.mSpeechLogList.add(speechLogRecord.toString());
    }

    @Override // com.xiaopeng.montecarlo.navcore.speech.log.ILogCollector
    public void record(int i, String str, String str2, String... strArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(LocationUtils.DR_RECORD_VALUE_SPLIT_CHAR);
        sb.append(str2);
        sb.append(" ");
        for (String str3 : strArr) {
            sb.append(str3);
            sb.append(" ");
        }
        SpeechLogRecord speechLogRecord = new SpeechLogRecord();
        speechLogRecord.setWhat(i).setTimeStr(sDateFormat.format(new Date())).setProcessThread(Process.myPid()).setChildThread(Process.myTid()).setMsg(sb.toString().trim());
        this.mSpeechLogList.add(speechLogRecord.toString());
    }

    @Override // com.xiaopeng.montecarlo.navcore.speech.log.ILogCollector
    public String getLogStr() {
        return String.join(FDManager.LINE_SEPERATOR, this.mSpeechLogList);
    }
}
