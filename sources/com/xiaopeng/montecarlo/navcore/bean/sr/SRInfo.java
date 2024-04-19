package com.xiaopeng.montecarlo.navcore.bean.sr;

import androidx.lifecycle.MutableLiveData;
import com.autonavi.gbl.pos.model.LocAllFusionPos;
import com.xiaopeng.montecarlo.navcore.sr.TrafficLightState;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class SRInfo implements Serializable {
    private int mCruiseSpeed;
    private boolean mHaveFlashSignal;
    private int mLaneChangedType;
    private int mLimitSpeed;
    private int mNGPInfoTips1Status;
    private int mNGPLCTips1Status;
    private int mNGPLCTips1TTSStatus;
    private int mNGPLaneChangedStatus;
    private int mNGPOpeButtonStatus;
    private LocAllFusionPos mPosFusionResultExternal;
    private int mQuitNGPODDStatus;
    private XPLocPulse mXPLocPulse;
    private int mSRDisplayState = 2;
    private int mSRSpdViewMode = 0;
    private int mSRLcViewMode = 0;
    private int mDriveMode = 0;
    private boolean mLCCLight = false;
    private boolean mDriveModeChangeToNgp = false;
    private boolean isLcTipsChange = false;
    private final MutableLiveData<TrafficLightState> mTrafficLightLiveData = new MutableLiveData<>();
    private boolean mIsIntersection = false;

    public void reset() {
        this.mXPLocPulse = null;
        this.mPosFusionResultExternal = null;
        this.mSRDisplayState = 2;
        this.mSRSpdViewMode = 0;
        this.mSRLcViewMode = 0;
        this.mDriveMode = 0;
        this.mLimitSpeed = 0;
        this.mCruiseSpeed = 0;
        this.mQuitNGPODDStatus = 0;
        this.mNGPOpeButtonStatus = 0;
        this.mNGPLCTips1Status = 0;
        this.mNGPLCTips1TTSStatus = 0;
        this.mNGPInfoTips1Status = 0;
        this.mNGPLaneChangedStatus = 0;
        this.mLaneChangedType = 1;
        this.mDriveModeChangeToNgp = false;
        this.isLcTipsChange = false;
        this.mTrafficLightLiveData.postValue(TrafficLightState.NONE);
        this.mIsIntersection = false;
    }

    public int getSRDisplayState() {
        return this.mSRDisplayState;
    }

    public void setSRDisplayState(int i) {
        this.mSRDisplayState = i;
    }

    public int getSRSpdViewMode() {
        return this.mSRSpdViewMode;
    }

    public void setSRSpdViewMode(int i) {
        this.mSRSpdViewMode = i;
    }

    public int getSRLcViewMode() {
        return this.mSRLcViewMode;
    }

    public void setSRLcViewMode(int i) {
        this.mSRLcViewMode = i;
    }

    public XPLocPulse getXPLocPulse() {
        return this.mXPLocPulse;
    }

    public void setXPLocPulse(XPLocPulse xPLocPulse) {
        this.mXPLocPulse = xPLocPulse;
    }

    public LocAllFusionPos getPosFusionResultExternal() {
        return this.mPosFusionResultExternal;
    }

    public void setPosFusionResultExternal(LocAllFusionPos locAllFusionPos) {
        this.mPosFusionResultExternal = locAllFusionPos;
    }

    public int getLimitSpeed() {
        return this.mLimitSpeed;
    }

    public void setLimitSpeed(int i) {
        this.mLimitSpeed = i;
    }

    public int getCruiseSpeed() {
        return this.mCruiseSpeed;
    }

    public void setCruiseSpeed(int i) {
        this.mCruiseSpeed = i;
    }

    public int getQuitNGPODDStatus() {
        return this.mQuitNGPODDStatus;
    }

    public void setQuitNGPODDStatus(int i) {
        this.mQuitNGPODDStatus = i;
    }

    public int getNGPOpeButtonStatus() {
        return this.mNGPOpeButtonStatus;
    }

    public void setNGPOpeButtonStatus(int i) {
        this.mNGPOpeButtonStatus = i;
    }

    public int getNGPLCTips1Status() {
        return this.mNGPLCTips1Status;
    }

    public void setNGPLCTips1Status(int i) {
        this.mNGPLCTips1Status = i;
    }

    public int getNGPLCTips1TTSStatus() {
        return this.mNGPLCTips1TTSStatus;
    }

    public void setNGPLCTips1TTSStatus(int i) {
        this.mNGPLCTips1TTSStatus = i;
    }

    public int getNGPInfoTips1Status() {
        return this.mNGPInfoTips1Status;
    }

    public void setNGPInfoTips1Status(int i) {
        this.mNGPInfoTips1Status = i;
    }

    public boolean isHaveFlashSignal() {
        return this.mHaveFlashSignal;
    }

    public void setHaveFlashSignal(boolean z) {
        this.mHaveFlashSignal = z;
    }

    public int getNGPLaneChangedStatus() {
        return this.mNGPLaneChangedStatus;
    }

    public void setNGPLaneChangedStatus(int i) {
        this.mNGPLaneChangedStatus = i;
    }

    public int getLaneChangedType() {
        return this.mLaneChangedType;
    }

    public void setLaneChangedType(int i) {
        this.mLaneChangedType = i;
    }

    public boolean isIntersection() {
        return this.mIsIntersection;
    }

    public void setIntersection(boolean z) {
        this.mIsIntersection = z;
    }

    public int getDriveMode() {
        return this.mDriveMode;
    }

    public void setDriveMode(int i) {
        this.mDriveMode = i;
    }

    public boolean isLCCLight() {
        return this.mLCCLight;
    }

    public void setLCCLight(boolean z) {
        this.mLCCLight = z;
    }

    public boolean isDriveModeChangeToNgp() {
        return this.mDriveModeChangeToNgp;
    }

    public void setDriveModeChangeToNgp(boolean z) {
        this.mDriveModeChangeToNgp = z;
    }

    public boolean isLcTipsChange() {
        return this.isLcTipsChange;
    }

    public void setLcTipsChange(boolean z) {
        this.isLcTipsChange = z;
    }

    public MutableLiveData<TrafficLightState> getTrafficLightLiveData() {
        return this.mTrafficLightLiveData;
    }

    public void setTrafficLight(TrafficLightState trafficLightState) {
        if (this.mTrafficLightLiveData.getValue() != trafficLightState) {
            this.mTrafficLightLiveData.postValue(trafficLightState);
        }
    }
}
