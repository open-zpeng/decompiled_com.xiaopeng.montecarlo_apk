package com.xiaopeng.montecarlo.root.util;

import android.text.TextUtils;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes2.dex */
public class NaviVersion {
    public static final String DEV_TAG_SUFFIX = "_dev";
    public static final int NAVI_VERSION_INVALID = -1;
    protected static final L.Tag TAG = new L.Tag("NaviVersion");
    private int mBuildVersion;
    private boolean mIsDev;
    private int mMajorVersion;
    private int mMinorVersion;
    private int mPatchVersion;

    public NaviVersion(String str) {
        this.mMajorVersion = -1;
        this.mMinorVersion = -1;
        this.mPatchVersion = -1;
        this.mBuildVersion = -1;
        this.mIsDev = false;
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.v(tag, "version name is " + str);
        }
        try {
            if (!TextUtils.isEmpty(str) && 'V' == str.charAt(0)) {
                String[] split = str.split("_|-");
                if (split.length == 0) {
                    return;
                }
                if (L.ENABLE) {
                    L.Tag tag2 = TAG;
                    L.v(tag2, "versionParts[0] is " + split[0]);
                }
                String[] split2 = split[0].split("\\.|V");
                if (4 > split2.length) {
                    return;
                }
                if (split2[1] != null) {
                    this.mMajorVersion = Integer.valueOf(split2[1]).intValue();
                }
                if (split2[2] != null) {
                    this.mMinorVersion = Integer.valueOf(split2[2]).intValue();
                }
                if (split2[3] != null) {
                    this.mPatchVersion = Integer.valueOf(split2[3]).intValue();
                }
                if (split2.length == 5 && split2[4] != null) {
                    this.mBuildVersion = Integer.valueOf(split2[4]).intValue();
                } else {
                    this.mBuildVersion = 0;
                }
                if (str.endsWith(DEV_TAG_SUFFIX)) {
                    this.mIsDev = true;
                }
            }
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
        }
    }

    public int getMajorVersion() {
        return this.mMajorVersion;
    }

    public int getMinorVersion() {
        return this.mMinorVersion;
    }

    public int getPatchVersion() {
        return this.mPatchVersion;
    }

    public int getBuildVersion() {
        return this.mBuildVersion;
    }

    public boolean isDevVersion() {
        return this.mIsDev;
    }

    public boolean isValid() {
        return (-1 == this.mMajorVersion || -1 == this.mMinorVersion || -1 == this.mPatchVersion || -1 == this.mBuildVersion) ? false : true;
    }

    public boolean equals(NaviVersion naviVersion) {
        return naviVersion != null && this.mMajorVersion == naviVersion.getMajorVersion() && this.mMinorVersion == naviVersion.getMinorVersion() && this.mPatchVersion == naviVersion.getPatchVersion() && this.mBuildVersion == naviVersion.getBuildVersion();
    }

    public boolean greaterThan(NaviVersion naviVersion) {
        if (naviVersion == null) {
            return true;
        }
        return this.mMajorVersion != naviVersion.getMajorVersion() ? this.mMajorVersion > naviVersion.getMajorVersion() : this.mMinorVersion != naviVersion.getMinorVersion() ? this.mMinorVersion > naviVersion.getMinorVersion() : this.mPatchVersion != naviVersion.getPatchVersion() ? this.mPatchVersion > naviVersion.getPatchVersion() : this.mBuildVersion != naviVersion.getBuildVersion() && this.mBuildVersion > naviVersion.getBuildVersion();
    }

    public String toString() {
        return " [" + this.mMajorVersion + ", " + this.mMinorVersion + ", " + this.mPatchVersion + ", " + this.mBuildVersion + "] ([major, minor, patch, build])";
    }
}
