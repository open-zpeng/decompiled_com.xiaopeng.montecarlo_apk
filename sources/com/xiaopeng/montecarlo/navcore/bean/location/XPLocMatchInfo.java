package com.xiaopeng.montecarlo.navcore.bean.location;

import com.autonavi.gbl.pos.model.LocMatchInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCoord3DDouble;
/* loaded from: classes2.dex */
public class XPLocMatchInfo {
    private float mCourse;
    private float mCourse3D;
    private float mElevation;
    private int mFormway;
    private int mIs3DValid;
    private int mIsOnGuideRoad;
    private int mLinkCur;
    private int mLinkType;
    private long mPathID;
    private XPCoord3DDouble mPosProj;
    private int mPostCur;
    private int mRoadClass;
    private float mRoadCourse;
    private int mSegmCur;
    private XPCoord3DDouble mSt3DPos;
    private XPCoord3DDouble mStPos;
    private int mWeight;

    public XPLocMatchInfo setCourse(float f) {
        this.mCourse = f;
        return this;
    }

    public XPLocMatchInfo setCourse3D(float f) {
        this.mCourse3D = f;
        return this;
    }

    public XPLocMatchInfo setElevation(float f) {
        this.mElevation = f;
        return this;
    }

    public XPLocMatchInfo setFormway(int i) {
        this.mFormway = i;
        return this;
    }

    public XPLocMatchInfo setIs3DValid(int i) {
        this.mIs3DValid = i;
        return this;
    }

    public XPLocMatchInfo setIsOnGuideRoad(int i) {
        this.mIsOnGuideRoad = i;
        return this;
    }

    public XPLocMatchInfo setLinkCur(int i) {
        this.mLinkCur = i;
        return this;
    }

    public XPLocMatchInfo setLinkType(int i) {
        this.mLinkType = i;
        return this;
    }

    public XPLocMatchInfo setPathID(long j) {
        this.mPathID = j;
        return this;
    }

    public XPLocMatchInfo setPosProj(XPCoord3DDouble xPCoord3DDouble) {
        this.mPosProj = xPCoord3DDouble;
        return this;
    }

    public XPLocMatchInfo setPostCur(int i) {
        this.mPostCur = i;
        return this;
    }

    public XPLocMatchInfo setRoadClass(int i) {
        this.mRoadClass = i;
        return this;
    }

    public XPLocMatchInfo setRoadCourse(float f) {
        this.mRoadCourse = f;
        return this;
    }

    public XPLocMatchInfo setSegmCur(int i) {
        this.mSegmCur = i;
        return this;
    }

    public XPLocMatchInfo setSt3DPos(XPCoord3DDouble xPCoord3DDouble) {
        this.mSt3DPos = xPCoord3DDouble;
        return this;
    }

    public XPLocMatchInfo setStPos(XPCoord3DDouble xPCoord3DDouble) {
        this.mStPos = xPCoord3DDouble;
        return this;
    }

    public XPLocMatchInfo setWeight(int i) {
        this.mWeight = i;
        return this;
    }

    public XPCoord3DDouble getStPos() {
        return this.mStPos;
    }

    public float getCourse() {
        return this.mCourse;
    }

    public float getRoadCourse() {
        return this.mRoadCourse;
    }

    public XPCoord3DDouble getSt3DPos() {
        return this.mSt3DPos;
    }

    public float getElevation() {
        return this.mElevation;
    }

    public float getCourse3D() {
        return this.mCourse3D;
    }

    public XPCoord3DDouble getPosProj() {
        return this.mPosProj;
    }

    public int getIs3DValid() {
        return this.mIs3DValid;
    }

    public int getFormway() {
        return this.mFormway;
    }

    public int getLinkType() {
        return this.mLinkType;
    }

    public int getRoadClass() {
        return this.mRoadClass;
    }

    public int getSegmCur() {
        return this.mSegmCur;
    }

    public int getLinkCur() {
        return this.mLinkCur;
    }

    public int getPostCur() {
        return this.mPostCur;
    }

    public int getIsOnGuideRoad() {
        return this.mIsOnGuideRoad;
    }

    public long getPathID() {
        return this.mPathID;
    }

    public int getWeight() {
        return this.mWeight;
    }

    public XPLocMatchInfo(LocMatchInfo locMatchInfo) {
        this.mStPos = new XPCoord3DDouble(locMatchInfo.stPos);
        this.mSt3DPos = new XPCoord3DDouble(locMatchInfo.st3DPos);
        this.mPosProj = new XPCoord3DDouble(locMatchInfo.posProj);
        this.mCourse = locMatchInfo.course;
        this.mRoadCourse = locMatchInfo.roadCourse;
        this.mElevation = locMatchInfo.elevation;
        this.mCourse3D = locMatchInfo.course3D;
        this.mIs3DValid = locMatchInfo.is3DValid;
        this.mFormway = locMatchInfo.formway;
        this.mLinkType = locMatchInfo.linkType;
        this.mRoadClass = locMatchInfo.roadClass;
        this.mSegmCur = locMatchInfo.segmCur;
        this.mLinkCur = locMatchInfo.linkCur;
        this.mPostCur = locMatchInfo.postCur;
        this.mIsOnGuideRoad = locMatchInfo.isOnGuideRoad;
        this.mPathID = locMatchInfo.pathID;
        this.mWeight = locMatchInfo.weight;
    }
}
