package com.xiaopeng.speech.protocol.query.speech.carstatus;

import com.xiaopeng.speech.IQueryCaller;
/* loaded from: classes3.dex */
public interface ISpeechCarstatusQueryCaller extends IQueryCaller {
    int getAcCirculationMode();

    boolean getAcPowerStatus();

    boolean getAcQualityPurgeStatus();

    float getAcTempDriverValue();

    float getAcTempPsnValue();

    int getAcWindBlowMode();

    int getAcWindSpeedLevel();

    int getCurrentMode();
}
