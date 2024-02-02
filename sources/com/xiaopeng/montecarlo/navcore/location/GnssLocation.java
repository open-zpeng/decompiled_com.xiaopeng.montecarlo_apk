package com.xiaopeng.montecarlo.navcore.location;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public class GnssLocation {
    public static final byte LOC_INVALID = 86;
    public static final byte LOC_VALID = 65;
    private float mAccuracy;
    private float mAltitude;
    private int mConstellation;
    private float mCourse;
    private int mDay;
    private byte mEastWest;
    private boolean mGgaEnable;
    private int mGgaUtcTime;
    private boolean mGsaEnable;
    private boolean mGstEnable;
    private float mHdop;
    private int mHour;
    private double mLatitude;
    private double mLongitude;
    private int mMinute;
    private int mMonth;
    private byte mNorthSouth;
    private int mNumSV;
    private float mPdop;
    private boolean mRmcEnable;
    private int mRmcUtcTime;
    private int mSecond;
    private float mSpeed;
    private byte mStatus;
    private float mVdop;
    private int mYear;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface LocStatus {
    }

    public GnssLocation setAccuracy(float f) {
        this.mAccuracy = f;
        return this;
    }

    public GnssLocation setAltitude(float f) {
        this.mAltitude = f;
        return this;
    }

    public GnssLocation setConstellation(int i) {
        this.mConstellation = i;
        return this;
    }

    public GnssLocation setCourse(float f) {
        this.mCourse = f;
        return this;
    }

    public GnssLocation setDay(int i) {
        this.mDay = i;
        return this;
    }

    public GnssLocation setEastWest(byte b) {
        this.mEastWest = b;
        return this;
    }

    public GnssLocation setGgaEnable(boolean z) {
        this.mGgaEnable = z;
        return this;
    }

    public GnssLocation setGgaUtcTime(int i) {
        this.mGgaUtcTime = i;
        return this;
    }

    public GnssLocation setGsaEnable(boolean z) {
        this.mGsaEnable = z;
        return this;
    }

    public GnssLocation setGstEnable(boolean z) {
        this.mGstEnable = z;
        return this;
    }

    public GnssLocation setHdop(float f) {
        this.mHdop = f;
        return this;
    }

    public GnssLocation setHour(int i) {
        this.mHour = i;
        return this;
    }

    public GnssLocation setLatitude(double d) {
        this.mLatitude = d;
        return this;
    }

    public GnssLocation setLongitude(double d) {
        this.mLongitude = d;
        return this;
    }

    public GnssLocation setMinute(int i) {
        this.mMinute = i;
        return this;
    }

    public GnssLocation setMonth(int i) {
        this.mMonth = i;
        return this;
    }

    public GnssLocation setNorthSouth(byte b) {
        this.mNorthSouth = b;
        return this;
    }

    public GnssLocation setNumSV(int i) {
        this.mNumSV = i;
        return this;
    }

    public GnssLocation setPdop(float f) {
        this.mPdop = f;
        return this;
    }

    public GnssLocation setRmcEnable(boolean z) {
        this.mRmcEnable = z;
        return this;
    }

    public GnssLocation setRmcUtcTime(int i) {
        this.mRmcUtcTime = i;
        return this;
    }

    public GnssLocation setSecond(int i) {
        this.mSecond = i;
        return this;
    }

    public GnssLocation setSpeed(float f) {
        this.mSpeed = f;
        return this;
    }

    public GnssLocation setStatus(byte b) {
        this.mStatus = b;
        return this;
    }

    public GnssLocation setVdop(float f) {
        this.mVdop = f;
        return this;
    }

    public GnssLocation setYear(int i) {
        this.mYear = i;
        return this;
    }

    public int getRmcUtcTime() {
        return this.mRmcUtcTime;
    }

    public int getConstellation() {
        return this.mConstellation;
    }

    public int getHour() {
        return this.mHour;
    }

    public int getMinute() {
        return this.mMinute;
    }

    public int getSecond() {
        return this.mSecond;
    }

    public byte getStatus() {
        return this.mStatus;
    }

    public double getLatitude() {
        return this.mLatitude;
    }

    public byte getNorthSouth() {
        return this.mNorthSouth;
    }

    public double getLongitude() {
        return this.mLongitude;
    }

    public byte getEastWest() {
        return this.mEastWest;
    }

    public float getSpeed() {
        return this.mSpeed;
    }

    public float getCourse() {
        return this.mCourse;
    }

    public int getDay() {
        return this.mDay;
    }

    public int getMonth() {
        return this.mMonth;
    }

    public int getYear() {
        return this.mYear;
    }

    public boolean isRmcEnable() {
        return this.mRmcEnable;
    }

    public int getGgaUtcTime() {
        return this.mGgaUtcTime;
    }

    public int getNumSV() {
        return this.mNumSV;
    }

    public float getAltitude() {
        return this.mAltitude;
    }

    public boolean isGgaEnable() {
        return this.mGgaEnable;
    }

    public float getPdop() {
        return this.mPdop;
    }

    public float getHdop() {
        return this.mHdop;
    }

    public float getVdop() {
        return this.mVdop;
    }

    public boolean isGsaEnable() {
        return this.mGsaEnable;
    }

    public float getAccuracy() {
        return this.mAccuracy;
    }

    public boolean isGstEnable() {
        return this.mGstEnable;
    }

    public void reset() {
        this.mRmcUtcTime = 0;
        this.mConstellation = 0;
        this.mHour = 0;
        this.mMinute = 0;
        this.mSecond = 0;
        this.mStatus = LOC_INVALID;
        this.mLatitude = 0.0d;
        this.mNorthSouth = (byte) 78;
        this.mLongitude = 0.0d;
        this.mEastWest = (byte) 69;
        this.mSpeed = 0.0f;
        this.mCourse = 0.0f;
        this.mDay = 0;
        this.mMonth = 0;
        this.mYear = 0;
        this.mRmcEnable = false;
        this.mGgaUtcTime = 0;
        this.mNumSV = 0;
        this.mAltitude = 0.0f;
        this.mGgaEnable = false;
        this.mPdop = 0.0f;
        this.mHdop = 0.0f;
        this.mVdop = 0.0f;
        this.mGsaEnable = false;
        this.mAccuracy = 0.0f;
        this.mGstEnable = false;
    }
}
