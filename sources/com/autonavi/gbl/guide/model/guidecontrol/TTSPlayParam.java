package com.autonavi.gbl.guide.model.guidecontrol;

import java.io.Serializable;
/* loaded from: classes.dex */
public class TTSPlayParam extends BaseParam implements Serializable {
    public int changePlayType = 0;
    public int style = 2;
    public int adcode = 0;
    public boolean enableAll = true;
    public boolean enable = true;
    public boolean enableADCode = true;
    public boolean enableLane = true;
    public boolean enableFacility = true;
    public boolean enableIntervalCamera = true;
    public boolean enableTunnel = true;
    public boolean enableSAPA = true;
    public boolean enableBridge = true;
    public boolean enableNaviCamera = true;
    public boolean enableScene = false;
    public boolean isVUIWorking = false;
    public boolean isDay = true;
    public boolean enableSignLimit = true;
    public boolean isOpenLight = false;
    public int fatiguedTTS = 0;
    public boolean fatiguedStatus = false;

    public TTSPlayParam() {
        this.paramType = 11;
    }
}
