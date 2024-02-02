package com.autonavi.gbl.guide.model;

import com.autonavi.gbl.common.path.model.CameraType;
import com.autonavi.gbl.guide.model.CruiseSoundType;
import com.autonavi.gbl.guide.model.NaviType;
import com.autonavi.gbl.guide.model.PlayRingType;
import com.autonavi.gbl.guide.model.SoundCategory;
import com.autonavi.gbl.guide.model.TTSScenePlay;
import com.autonavi.gbl.guide.model.TtsActionType;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class SoundInfo implements Serializable {
    @TtsActionType.TtsActionType1
    public int actionType;
    public String appendData;
    public long appendType;
    public ArrayList<SoundContent> contentList;
    @CruiseSoundType.CruiseSoundType1
    public int cruiseSoundType;
    public boolean isCameraOverSpeed;
    public short isManualPlay;
    public int limitSpeed;
    public int manualRequestID;
    public int maxValidDis;
    public int minValidDis;
    @NaviType.NaviType1
    public int naviType;
    public int remDistOfGPoint;
    @PlayRingType.PlayRingType1
    public int ringType;
    @TTSScenePlay.TTSScenePlay1
    public int sceneType;
    public int soundFlag;
    public int soundType;
    @CameraType.CameraType1
    public int subCameraType;
    @SoundCategory.SoundCategory1
    public int subCategory;
    public int subSoundType;
    public String text;
    public ArrayList<voiceTask> voiceText;

    public SoundInfo() {
        this.text = "";
        this.voiceText = new ArrayList<>();
        this.sceneType = -1;
        this.naviType = 0;
        this.soundType = -1;
        this.subSoundType = 0;
        this.subCameraType = 0;
        this.subCategory = 0;
        this.maxValidDis = 0;
        this.minValidDis = 0;
        this.contentList = new ArrayList<>();
        this.cruiseSoundType = 0;
        this.ringType = 0;
        this.isManualPlay = (short) 0;
        this.manualRequestID = -1;
        this.soundFlag = 0;
        this.actionType = 0;
        this.appendType = 0L;
        this.appendData = "";
        this.remDistOfGPoint = 0;
        this.isCameraOverSpeed = false;
        this.limitSpeed = 0;
    }

    public SoundInfo(String str, ArrayList<voiceTask> arrayList, @TTSScenePlay.TTSScenePlay1 int i, @NaviType.NaviType1 int i2, int i3, int i4, @CameraType.CameraType1 int i5, @SoundCategory.SoundCategory1 int i6, int i7, int i8, ArrayList<SoundContent> arrayList2, @CruiseSoundType.CruiseSoundType1 int i9, @PlayRingType.PlayRingType1 int i10, short s, int i11, int i12, @TtsActionType.TtsActionType1 int i13, long j, String str2, int i14, boolean z, int i15) {
        this.text = str;
        this.voiceText = arrayList;
        this.sceneType = i;
        this.naviType = i2;
        this.soundType = i3;
        this.subSoundType = i4;
        this.subCameraType = i5;
        this.subCategory = i6;
        this.maxValidDis = i7;
        this.minValidDis = i8;
        this.contentList = arrayList2;
        this.cruiseSoundType = i9;
        this.ringType = i10;
        this.isManualPlay = s;
        this.manualRequestID = i11;
        this.soundFlag = i12;
        this.actionType = i13;
        this.appendType = j;
        this.appendData = str2;
        this.remDistOfGPoint = i14;
        this.isCameraOverSpeed = z;
        this.limitSpeed = i15;
    }
}
