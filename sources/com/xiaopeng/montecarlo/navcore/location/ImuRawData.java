package com.xiaopeng.montecarlo.navcore.location;
/* loaded from: classes3.dex */
public class ImuRawData {
    private float[] mAcc = new float[3];
    private float[] mGyro = new float[3];
    private float mImuAccelStX;
    private float mImuAccelStY;
    private float mImuAccelStZ;
    private float mImuCounter;
    private float mImuGAccelerationSt;
    private float mImuGmeterNoiseSt;
    private float mImuGmeterRangeSt;
    private float mImuGmeterRateSt;
    private float mImuGyroNoiseSt;
    private float mImuGyroRangeSt;
    private float mImuGyroRateSt;
    private float mImuGyroStX;
    private float mImuGyroStY;
    private float mImuGyroStZ;
    private float mImuHWVer;
    private float mImuInitFailure;
    private float mImuOutputRateSt;
    private float mImuPacketLossSt;
    private float mImuPowVoltage;
    private float mImuSWVersion;
    private float mImuSdeltamsec;
    private float mImuSelfCheck;
    private float mImuTemperature;
    private float mImuTemperatureSt;
    private float mImuVoltageSt;
    private long mReceivedTime;

    public ImuRawData setAcc(float[] fArr) {
        this.mAcc = fArr;
        return this;
    }

    public ImuRawData setGyro(float[] fArr) {
        this.mGyro = fArr;
        return this;
    }

    public ImuRawData setImuAccelStX(float f) {
        this.mImuAccelStX = f;
        return this;
    }

    public ImuRawData setImuAccelStY(float f) {
        this.mImuAccelStY = f;
        return this;
    }

    public ImuRawData setImuAccelStZ(float f) {
        this.mImuAccelStZ = f;
        return this;
    }

    public ImuRawData setImuCounter(float f) {
        this.mImuCounter = f;
        return this;
    }

    public ImuRawData setImuGAccelerationSt(float f) {
        this.mImuGAccelerationSt = f;
        return this;
    }

    public ImuRawData setImuGmeterNoiseSt(float f) {
        this.mImuGmeterNoiseSt = f;
        return this;
    }

    public ImuRawData setImuGmeterRangeSt(float f) {
        this.mImuGmeterRangeSt = f;
        return this;
    }

    public ImuRawData setImuGmeterRateSt(float f) {
        this.mImuGmeterRateSt = f;
        return this;
    }

    public ImuRawData setImuGyroNoiseSt(float f) {
        this.mImuGyroNoiseSt = f;
        return this;
    }

    public ImuRawData setImuGyroRangeSt(float f) {
        this.mImuGyroRangeSt = f;
        return this;
    }

    public ImuRawData setImuGyroRateSt(float f) {
        this.mImuGyroRateSt = f;
        return this;
    }

    public ImuRawData setImuGyroStX(float f) {
        this.mImuGyroStX = f;
        return this;
    }

    public ImuRawData setImuGyroStY(float f) {
        this.mImuGyroStY = f;
        return this;
    }

    public ImuRawData setImuGyroStZ(float f) {
        this.mImuGyroStZ = f;
        return this;
    }

    public ImuRawData setImuHWVer(float f) {
        this.mImuHWVer = f;
        return this;
    }

    public ImuRawData setImuInitFailure(float f) {
        this.mImuInitFailure = f;
        return this;
    }

    public ImuRawData setImuOutputRateSt(float f) {
        this.mImuOutputRateSt = f;
        return this;
    }

    public ImuRawData setImuPacketLossSt(float f) {
        this.mImuPacketLossSt = f;
        return this;
    }

    public ImuRawData setImuPowVoltage(float f) {
        this.mImuPowVoltage = f;
        return this;
    }

    public ImuRawData setImuSWVersion(float f) {
        this.mImuSWVersion = f;
        return this;
    }

    public ImuRawData setImuSdeltamsec(float f) {
        this.mImuSdeltamsec = f;
        return this;
    }

    public ImuRawData setImuSelfCheck(float f) {
        this.mImuSelfCheck = f;
        return this;
    }

    public ImuRawData setImuTemperature(float f) {
        this.mImuTemperature = f;
        return this;
    }

    public ImuRawData setImuTemperatureSt(float f) {
        this.mImuTemperatureSt = f;
        return this;
    }

    public ImuRawData setImuVoltageSt(float f) {
        this.mImuVoltageSt = f;
        return this;
    }

    public ImuRawData setReceivedTime(long j) {
        this.mReceivedTime = j;
        return this;
    }

    public float getImuInitFailure() {
        return this.mImuInitFailure;
    }

    public float getImuOutputRateSt() {
        return this.mImuOutputRateSt;
    }

    public float getImuPacketLossSt() {
        return this.mImuPacketLossSt;
    }

    public float getImuSelfCheck() {
        return this.mImuSelfCheck;
    }

    public float getImuPowVoltage() {
        return this.mImuPowVoltage;
    }

    public float getImuTemperature() {
        return this.mImuTemperature;
    }

    public float getImuTemperatureSt() {
        return this.mImuTemperatureSt;
    }

    public float getImuVoltageSt() {
        return this.mImuVoltageSt;
    }

    public float getImuGmeterNoiseSt() {
        return this.mImuGmeterNoiseSt;
    }

    public float getImuGmeterRangeSt() {
        return this.mImuGmeterRangeSt;
    }

    public float getImuGAccelerationSt() {
        return this.mImuGAccelerationSt;
    }

    public float getImuGmeterRateSt() {
        return this.mImuGmeterRateSt;
    }

    public float getImuGyroNoiseSt() {
        return this.mImuGyroNoiseSt;
    }

    public float getImuGyroRangeSt() {
        return this.mImuGyroRangeSt;
    }

    public float getImuGyroRateSt() {
        return this.mImuGyroRateSt;
    }

    public float getImuCounter() {
        return this.mImuCounter;
    }

    public float getImuHWVer() {
        return this.mImuHWVer;
    }

    public float getImuSWVersion() {
        return this.mImuSWVersion;
    }

    public float getImuAccelStX() {
        return this.mImuAccelStX;
    }

    public float getImuGyroStX() {
        return this.mImuGyroStX;
    }

    public float getImuAccelStY() {
        return this.mImuAccelStY;
    }

    public float getImuGyroStY() {
        return this.mImuGyroStY;
    }

    public float getImuAccelStZ() {
        return this.mImuAccelStZ;
    }

    public float getImuGyroStZ() {
        return this.mImuGyroStZ;
    }

    public float getImuSdeltamsec() {
        return this.mImuSdeltamsec;
    }

    public float[] getAcc() {
        return this.mAcc;
    }

    public float[] getGyro() {
        return this.mGyro;
    }

    public long getReceivedTime() {
        return this.mReceivedTime;
    }

    public float getImuAccelX() {
        return this.mAcc[0];
    }

    public float getImuAccelY() {
        return this.mAcc[1];
    }

    public float getImuAccelZ() {
        return this.mAcc[2];
    }

    public float getImuAngRateX() {
        return this.mGyro[0];
    }

    public float getImuAngRateY() {
        return this.mGyro[1];
    }

    public float getImuAngRateZ() {
        return this.mGyro[2];
    }

    public void setAcc(float f, float f2, float f3) {
        float[] fArr = this.mAcc;
        fArr[0] = f;
        fArr[1] = f2;
        fArr[2] = f3;
    }

    public void setGyro(float f, float f2, float f3) {
        float[] fArr = this.mGyro;
        fArr[0] = f;
        fArr[1] = f2;
        fArr[2] = f3;
    }
}
