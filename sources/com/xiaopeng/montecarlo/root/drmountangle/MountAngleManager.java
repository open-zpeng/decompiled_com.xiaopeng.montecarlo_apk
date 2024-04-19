package com.xiaopeng.montecarlo.root.drmountangle;

import java.util.HashMap;
/* loaded from: classes3.dex */
public class MountAngleManager {
    public static final HashMap<Integer, MountAngle> XP_CAR_MOUNT_ANGLE_MAP = new HashMap<Integer, MountAngle>() { // from class: com.xiaopeng.montecarlo.root.drmountangle.MountAngleManager.1
        {
            put(0, new MountAngle(new IMUAngle(0.0f, 0.0f, 0.0f), new IMUAngleConvertType(0, 0, 0), new IMUAngle(0.0f, 0.0f, 0.0f), false, new IMUAngle(0.0f, 0.0f, 0.0f), new IMUAngleConvertType(0, 0, 0), new IMUAngle(0.0f, 0.0f, 0.0f), true));
            put(1, new MountAngle(new IMUAngle(28.3f, -4.87f, 7.84f), new IMUAngleConvertType(0, 2, 1), new IMUAngle(-1.0f, -1.0f, -1.0f), false, new IMUAngle(0.0f, 0.0f, 0.0f), new IMUAngleConvertType(0, 0, 0), new IMUAngle(0.0f, 0.0f, 0.0f), false));
            put(2, new MountAngle(new IMUAngle(28.3f, -4.87f, 7.84f), new IMUAngleConvertType(1, 2, 0), new IMUAngle(1.0f, 1.0f, 1.0f), false, new IMUAngle(0.0f, 0.0f, 0.0f), new IMUAngleConvertType(0, 0, 0), new IMUAngle(0.0f, 0.0f, 0.0f), false));
            put(3, new MountAngle(new IMUAngle(28.3f, -4.87f, 7.84f), new IMUAngleConvertType(1, 2, 0), new IMUAngle(1.0f, 1.0f, 1.0f), false, new IMUAngle(0.0f, 0.0f, 0.0f), new IMUAngleConvertType(0, 0, 0), new IMUAngle(0.0f, 0.0f, 0.0f), false));
            put(4, new MountAngle(new IMUAngle(28.3f, -4.87f, 7.84f), new IMUAngleConvertType(1, 2, 0), new IMUAngle(1.0f, 1.0f, 1.0f), false, new IMUAngle(0.0f, 0.0f, 0.0f), new IMUAngleConvertType(0, 0, 0), new IMUAngle(0.0f, 0.0f, 0.0f), false));
            put(5, new MountAngle(new IMUAngle(28.3f, -4.87f, 7.84f), new IMUAngleConvertType(1, 2, 0), new IMUAngle(1.0f, -1.0f, -1.0f), false, new IMUAngle(0.0f, 0.0f, 0.0f), new IMUAngleConvertType(0, 0, 0), new IMUAngle(0.0f, 0.0f, 0.0f), false));
            put(6, new MountAngle(new IMUAngle(0.0f, 0.0f, 0.0f), new IMUAngleConvertType(1, 0, 2), new IMUAngle(1.0f, -1.0f, 1.0f), false, new IMUAngle(0.0f, 0.0f, 0.0f), new IMUAngleConvertType(1, 0, 2), new IMUAngle(-1.0f, 1.0f, 1.0f), true));
            put(7, new MountAngle(new IMUAngle(33.0f, 0.0f, 0.0f), new IMUAngleConvertType(0, 2, 1), new IMUAngle(1.0f, 1.0f, -1.0f), false, new IMUAngle(2.75f, 0.0f, 0.0f), new IMUAngleConvertType(1, 0, 2), new IMUAngle(-1.0f, 1.0f, 1.0f), true));
            put(10, new MountAngle(new IMUAngle(28.3f, -4.87f, 7.84f), new IMUAngleConvertType(1, 2, 0), new IMUAngle(1.0f, -1.0f, -1.0f), false, new IMUAngle(0.0f, 0.0f, 0.0f), new IMUAngleConvertType(0, 0, 0), new IMUAngle(0.0f, 0.0f, 0.0f), false));
            put(8, new MountAngle(new IMUAngle(-6.456f, -1.489f, 0.0f), new IMUAngleConvertType(0, 1, 2), new IMUAngle(-1.0f, -1.0f, 1.0f), true, new IMUAngle(0.0f, 0.0f, 0.0f), new IMUAngleConvertType(1, 0, 2), new IMUAngle(1.0f, -1.0f, 1.0f), true));
            put(11, new MountAngle(new IMUAngle(0.0f, 0.0f, 0.0f), new IMUAngleConvertType(0, 1, 2), new IMUAngle(-1.0f, 1.0f, -1.0f), true, new IMUAngle(2.75f, 0.0f, 0.0f), new IMUAngleConvertType(1, 0, 2), new IMUAngle(-1.0f, 1.0f, 1.0f), true));
            put(12, new MountAngle(new IMUAngle(-6.456f, -1.489f, 0.0f), new IMUAngleConvertType(0, 1, 2), new IMUAngle(-1.0f, -1.0f, 1.0f), true, new IMUAngle(0.0f, 0.0f, 0.0f), new IMUAngleConvertType(1, 0, 2), new IMUAngle(1.0f, -1.0f, 1.0f), true));
        }
    };

    /* loaded from: classes3.dex */
    public static class IMUAngle {
        private float mX;
        private float mY;
        private float mZ;

        public float getX() {
            return this.mX;
        }

        public float getY() {
            return this.mY;
        }

        public float getZ() {
            return this.mZ;
        }

        IMUAngle(float f, float f2, float f3) {
            this.mX = f;
            this.mY = f2;
            this.mZ = f3;
        }
    }

    /* loaded from: classes3.dex */
    public static class IMUAngleConvertType {
        private int mX;
        private int mY;
        private int mZ;

        public int getX() {
            return this.mX;
        }

        public int getY() {
            return this.mY;
        }

        public int getZ() {
            return this.mZ;
        }

        IMUAngleConvertType(int i, int i2, int i3) {
            this.mX = i;
            this.mY = i2;
            this.mZ = i3;
        }
    }

    /* loaded from: classes3.dex */
    public static class MountAngle {
        private IMUAngle mAutoPolitIMU;
        private IMUAngle mAutoPolitIMUConvertRatio;
        private IMUAngleConvertType mAutoPolitIMUConvertType;
        private boolean mIsAutoPolitIMUFromCan;
        private boolean mIsRawIMUFromCan;
        private IMUAngle mRawIMU;
        private IMUAngle mRawIMUConvertRatio;
        private IMUAngleConvertType mRawIMUConvertType;

        public IMUAngle getRawIMU() {
            return this.mRawIMU;
        }

        public IMUAngleConvertType getRawIMUConvertType() {
            return this.mRawIMUConvertType;
        }

        public IMUAngle getRawIMUConvertRatio() {
            return this.mRawIMUConvertRatio;
        }

        public boolean isRawIMUFromCan() {
            return this.mIsRawIMUFromCan;
        }

        public IMUAngle getAutoPolitIMU() {
            return this.mAutoPolitIMU;
        }

        public IMUAngleConvertType getAutoPolitIMUConvertType() {
            return this.mAutoPolitIMUConvertType;
        }

        public IMUAngle getAutoPolitIMUConvertRatio() {
            return this.mAutoPolitIMUConvertRatio;
        }

        public boolean isAutoPolitIMUFromCan() {
            return this.mIsAutoPolitIMUFromCan;
        }

        MountAngle(IMUAngle iMUAngle, IMUAngleConvertType iMUAngleConvertType, IMUAngle iMUAngle2, boolean z, IMUAngle iMUAngle3, IMUAngleConvertType iMUAngleConvertType2, IMUAngle iMUAngle4, boolean z2) {
            this.mRawIMU = iMUAngle;
            this.mRawIMUConvertType = iMUAngleConvertType;
            this.mRawIMUConvertRatio = iMUAngle2;
            this.mIsRawIMUFromCan = z;
            this.mAutoPolitIMU = iMUAngle3;
            this.mAutoPolitIMUConvertType = iMUAngleConvertType2;
            this.mAutoPolitIMUConvertRatio = iMUAngle4;
            this.mIsAutoPolitIMUFromCan = z2;
        }
    }
}
