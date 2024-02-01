package com.xiaopeng.montecarlo.navcore.bean.location;

import com.autonavi.gbl.pos.model.LocInfo;
import com.autonavi.gbl.pos.model.LocMatchInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCoord3DDouble;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class XPLocInfo {
    private float mAlt;
    private float mAltAcc;
    private short mBindFlag;
    private float mCompassDir;
    private float mCourseAcc;
    private float mDistFromHeadLine;
    private float mErrorDist;
    private float mFittingCourse;
    private float mFittingCourseAcc;
    private float mGpsCoureAcc;
    private float mGpsCourse;
    private float mGpsDir;
    private XPCoord3DDouble mGpsPos;
    private int mIsHLocData;
    private boolean mIsLinkOnline;
    private int mIsSimulate;
    private int mIsUse;
    private long mLinkId;
    private int mLinkOnlineVersion;
    private long mMatchInfoCnt;
    private List<XPLocMatchInfo> mMatchInfoList = new ArrayList();
    private float mMatchRoadCourse;
    private int mNaviRouteId;
    private long mNearRoadId;
    private long mOverhead;
    private float mPosAcc;
    private int mRoadDir;
    private long mRoadId;
    private int mSegIdx;
    private float mShowPosAcc;
    private int mSourType;
    private float mSpeed;
    private XPCoord3DDouble mStDoorInPos;
    private XPCoord3DDouble mStMatchRoadPos;
    private int mStartDirType;
    private int mStartPosType;
    private BigInteger mTickTime;

    public XPLocInfo setAlt(float f) {
        this.mAlt = f;
        return this;
    }

    public XPLocInfo setAltAcc(float f) {
        this.mAltAcc = f;
        return this;
    }

    public XPLocInfo setBindFlag(short s) {
        this.mBindFlag = s;
        return this;
    }

    public XPLocInfo setCompassDir(float f) {
        this.mCompassDir = f;
        return this;
    }

    public XPLocInfo setCourseAcc(float f) {
        this.mCourseAcc = f;
        return this;
    }

    public XPLocInfo setDistFromHeadLine(float f) {
        this.mDistFromHeadLine = f;
        return this;
    }

    public XPLocInfo setErrorDist(float f) {
        this.mErrorDist = f;
        return this;
    }

    public XPLocInfo setFittingCourse(float f) {
        this.mFittingCourse = f;
        return this;
    }

    public XPLocInfo setFittingCourseAcc(float f) {
        this.mFittingCourseAcc = f;
        return this;
    }

    public XPLocInfo setGpsCoureAcc(float f) {
        this.mGpsCoureAcc = f;
        return this;
    }

    public XPLocInfo setGpsCourse(float f) {
        this.mGpsCourse = f;
        return this;
    }

    public XPLocInfo setGpsDir(float f) {
        this.mGpsDir = f;
        return this;
    }

    public XPLocInfo setGpsPos(XPCoord3DDouble xPCoord3DDouble) {
        this.mGpsPos = xPCoord3DDouble;
        return this;
    }

    public XPLocInfo setIsHLocData(int i) {
        this.mIsHLocData = i;
        return this;
    }

    public XPLocInfo setIsSimulate(int i) {
        this.mIsSimulate = i;
        return this;
    }

    public XPLocInfo setIsUse(int i) {
        this.mIsUse = i;
        return this;
    }

    public XPLocInfo setLinkId(long j) {
        this.mLinkId = j;
        return this;
    }

    public XPLocInfo setLinkOnline(boolean z) {
        this.mIsLinkOnline = z;
        return this;
    }

    public XPLocInfo setLinkOnlineVersion(int i) {
        this.mLinkOnlineVersion = i;
        return this;
    }

    public XPLocInfo setMatchInfoCnt(long j) {
        this.mMatchInfoCnt = j;
        return this;
    }

    public XPLocInfo setMatchInfoList(List<XPLocMatchInfo> list) {
        this.mMatchInfoList = list;
        return this;
    }

    public XPLocInfo setMatchRoadCourse(float f) {
        this.mMatchRoadCourse = f;
        return this;
    }

    public XPLocInfo setNaviRouteId(int i) {
        this.mNaviRouteId = i;
        return this;
    }

    public XPLocInfo setNearRoadId(long j) {
        this.mNearRoadId = j;
        return this;
    }

    public XPLocInfo setOverhead(long j) {
        this.mOverhead = j;
        return this;
    }

    public XPLocInfo setPosAcc(float f) {
        this.mPosAcc = f;
        return this;
    }

    public XPLocInfo setRoadDir(int i) {
        this.mRoadDir = i;
        return this;
    }

    public XPLocInfo setRoadId(long j) {
        this.mRoadId = j;
        return this;
    }

    public XPLocInfo setSegIdx(int i) {
        this.mSegIdx = i;
        return this;
    }

    public XPLocInfo setShowPosAcc(float f) {
        this.mShowPosAcc = f;
        return this;
    }

    public XPLocInfo setSourType(int i) {
        this.mSourType = i;
        return this;
    }

    public XPLocInfo setSpeed(float f) {
        this.mSpeed = f;
        return this;
    }

    public XPLocInfo setStDoorInPos(XPCoord3DDouble xPCoord3DDouble) {
        this.mStDoorInPos = xPCoord3DDouble;
        return this;
    }

    public XPLocInfo setStMatchRoadPos(XPCoord3DDouble xPCoord3DDouble) {
        this.mStMatchRoadPos = xPCoord3DDouble;
        return this;
    }

    public XPLocInfo setStartDirType(int i) {
        this.mStartDirType = i;
        return this;
    }

    public XPLocInfo setStartPosType(int i) {
        this.mStartPosType = i;
        return this;
    }

    public XPLocInfo setTickTime(BigInteger bigInteger) {
        this.mTickTime = bigInteger;
        return this;
    }

    public int getIsUse() {
        return this.mIsUse;
    }

    public int getIsSimulate() {
        return this.mIsSimulate;
    }

    public int getSourType() {
        return this.mSourType;
    }

    public float getAlt() {
        return this.mAlt;
    }

    public float getSpeed() {
        return this.mSpeed;
    }

    public float getPosAcc() {
        return this.mPosAcc;
    }

    public float getShowPosAcc() {
        return this.mShowPosAcc;
    }

    public float getAltAcc() {
        return this.mAltAcc;
    }

    public XPCoord3DDouble getGpsPos() {
        return this.mGpsPos;
    }

    public float getGpsCourse() {
        return this.mGpsCourse;
    }

    public int getNaviRouteId() {
        return this.mNaviRouteId;
    }

    public int getRoadDir() {
        return this.mRoadDir;
    }

    public long getRoadId() {
        return this.mRoadId;
    }

    public long getNearRoadId() {
        return this.mNearRoadId;
    }

    public int getSegIdx() {
        return this.mSegIdx;
    }

    public short getBindFlag() {
        return this.mBindFlag;
    }

    public float getDistFromHeadLine() {
        return this.mDistFromHeadLine;
    }

    public int getIsHLocData() {
        return this.mIsHLocData;
    }

    public long getLinkId() {
        return this.mLinkId;
    }

    public boolean isLinkOnline() {
        return this.mIsLinkOnline;
    }

    public int getLinkOnlineVersion() {
        return this.mLinkOnlineVersion;
    }

    public XPCoord3DDouble getStDoorInPos() {
        return this.mStDoorInPos;
    }

    public XPCoord3DDouble getStMatchRoadPos() {
        return this.mStMatchRoadPos;
    }

    public int getStartDirType() {
        return this.mStartDirType;
    }

    public float getMatchRoadCourse() {
        return this.mMatchRoadCourse;
    }

    public float getCompassDir() {
        return this.mCompassDir;
    }

    public float getGpsDir() {
        return this.mGpsDir;
    }

    public float getErrorDist() {
        return this.mErrorDist;
    }

    public int getStartPosType() {
        return this.mStartPosType;
    }

    public float getCourseAcc() {
        return this.mCourseAcc;
    }

    public float getGpsCoureAcc() {
        return this.mGpsCoureAcc;
    }

    public float getFittingCourse() {
        return this.mFittingCourse;
    }

    public float getFittingCourseAcc() {
        return this.mFittingCourseAcc;
    }

    public BigInteger getTickTime() {
        return this.mTickTime;
    }

    public long getOverhead() {
        return this.mOverhead;
    }

    public List<XPLocMatchInfo> getMatchInfoList() {
        return this.mMatchInfoList;
    }

    public long getMatchInfoCnt() {
        return this.mMatchInfoCnt;
    }

    public XPLocInfo(LocInfo locInfo) {
        this.mIsUse = locInfo.isUse;
        this.mIsSimulate = locInfo.isSimulate;
        this.mSourType = locInfo.sourType;
        this.mAlt = locInfo.alt;
        this.mSpeed = locInfo.speed;
        this.mPosAcc = locInfo.posAcc;
        this.mShowPosAcc = locInfo.showPosAcc;
        this.mAltAcc = locInfo.altAcc;
        this.mGpsPos = new XPCoord3DDouble(locInfo.gpsPos);
        this.mGpsCourse = locInfo.gpsCourse;
        this.mNaviRouteId = locInfo.naviRouteId;
        this.mRoadDir = locInfo.roadDir;
        this.mRoadId = locInfo.roadId;
        this.mNearRoadId = locInfo.nearRoadId;
        this.mSegIdx = locInfo.segIdx;
        this.mBindFlag = locInfo.bindFlag;
        this.mDistFromHeadLine = locInfo.distFromHeadLine;
        this.mIsHLocData = locInfo.isHLocData;
        this.mLinkId = locInfo.linkId;
        this.mIsLinkOnline = locInfo.isLinkOnline;
        this.mLinkOnlineVersion = locInfo.linkOnlineVersion;
        this.mStDoorInPos = new XPCoord3DDouble(locInfo.stDoorInPos);
        this.mStMatchRoadPos = new XPCoord3DDouble(locInfo.stMatchRoadPos);
        this.mStartDirType = locInfo.startDirType;
        this.mMatchRoadCourse = locInfo.matchRoadCourse;
        this.mCompassDir = locInfo.compassDir;
        this.mGpsDir = locInfo.gpsDir;
        this.mErrorDist = locInfo.errorDist;
        this.mStartPosType = locInfo.startPosType;
        this.mCourseAcc = locInfo.courseAcc;
        this.mGpsCoureAcc = locInfo.gpsCoureAcc;
        this.mFittingCourse = locInfo.fittingCourse;
        this.mFittingCourseAcc = locInfo.fittingCourseAcc;
        this.mTickTime = locInfo.tickTime;
        this.mOverhead = locInfo.overhead;
        Iterator<LocMatchInfo> it = locInfo.matchInfo.iterator();
        while (it.hasNext()) {
            this.mMatchInfoList.add(new XPLocMatchInfo(it.next()));
        }
        this.mMatchInfoCnt = locInfo.matchInfoCnt;
    }
}
