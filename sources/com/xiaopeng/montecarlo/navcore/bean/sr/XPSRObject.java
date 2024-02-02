package com.xiaopeng.montecarlo.navcore.bean.sr;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class XPSRObject implements Serializable {
    public static final int BL_OBJ_TYPE_ANIMAL = 2;
    public static final int BL_OBJ_TYPE_BICYCLE = 6;
    public static final int BL_OBJ_TYPE_BUS = 10;
    public static final int BL_OBJ_TYPE_CONEBARREL = 82;
    public static final int BL_OBJ_TYPE_CONSTRUCTIONFENCE = 81;
    public static final int BL_OBJ_TYPE_CRASHBARRELS = 80;
    public static final int BL_OBJ_TYPE_MOTORCYCLE = 8;
    public static final int BL_OBJ_TYPE_PERSON = 1;
    public static final int BL_OBJ_TYPE_PICKUP = 11;
    public static final int BL_OBJ_TYPE_SEDAN = 3;
    public static final int BL_OBJ_TYPE_SUV = 4;
    public static final int BL_OBJ_TYPE_TRICYCLE = 7;
    public static final int BL_OBJ_TYPE_TRUCK = 9;
    public static final int BL_OBJ_TYPE_UNKNOWN = 0;
    public static final int BL_OBJ_TYPE_VAN = 5;
    public static final int OBJ_TYPE_ANIMAL = 2;
    public static final int OBJ_TYPE_BARREL = 2;
    public static final int OBJ_TYPE_BARRIER = 3;
    public static final int OBJ_TYPE_BICYCLE = 6;
    public static final int OBJ_TYPE_BUS = 10;
    public static final int OBJ_TYPE_CONEBARREL = 1;
    public static final int OBJ_TYPE_MOTORCYCLE = 8;
    public static final int OBJ_TYPE_PERSON = 1;
    public static final int OBJ_TYPE_PICKUP = 11;
    public static final int OBJ_TYPE_SEDAN = 3;
    public static final int OBJ_TYPE_SUV = 4;
    public static final int OBJ_TYPE_TRICYCLE = 7;
    public static final int OBJ_TYPE_TRUCK = 9;
    public static final int OBJ_TYPE_UNKNOWN = 0;
    public static final int OBJ_TYPE_VAN = 5;
    private int mColor;
    private float mHeading;
    private boolean mIsHighLight;
    private int mObjectID;
    private boolean mStaticObj;
    private int mType;
    private XPRelativePos mXPRelativePos;
    private int mModelResID = -1;
    private int mTextureResID = -1;

    public int getObjectID() {
        return this.mObjectID;
    }

    public void setObjectID(int i) {
        this.mObjectID = i;
    }

    public int getModelResID() {
        return this.mModelResID;
    }

    public void setModelResID(int i) {
        this.mModelResID = i;
    }

    public int getTextureResID() {
        return this.mTextureResID;
    }

    public void setTextureResID(int i) {
        this.mTextureResID = i;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }

    public XPRelativePos getXPRelativePos() {
        return this.mXPRelativePos;
    }

    public void setXPRelativePos(XPRelativePos xPRelativePos) {
        this.mXPRelativePos = xPRelativePos;
    }

    public float getHeading() {
        return this.mHeading;
    }

    public void setHeading(float f) {
        this.mHeading = f;
    }

    public int getColor() {
        return this.mColor;
    }

    public void setColor(int i) {
        this.mColor = i;
    }

    public boolean isStaticObj() {
        return this.mStaticObj;
    }

    public void setStaticObj(boolean z) {
        this.mStaticObj = z;
    }

    public boolean isHighLight() {
        return this.mIsHighLight;
    }

    public void setHighLight(boolean z) {
        this.mIsHighLight = z;
    }
}
