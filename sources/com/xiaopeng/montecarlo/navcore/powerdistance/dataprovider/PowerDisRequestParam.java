package com.xiaopeng.montecarlo.navcore.powerdistance.dataprovider;

import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IPathResult;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IVariantPath;
import com.xiaopeng.montecarlo.root.dataprovider.BaseParameter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes3.dex */
public class PowerDisRequestParam extends BaseParameter {
    public static final int INIT_OFFLINE_DATA = 2;
    public static final int PARAM_TYPE_INVALID = -1;
    public static final int REFRESH_ONLINE_K = 0;
    public static final int REFRESH_WITH_OFFLINE_K = 1;
    public static final int UPDATE_OFFLINE_DATA = 3;
    private int mDisToTarget;
    private PdExternalData mExternalData;
    private int mParamType = -1;
    private IVariantPath mPath;
    private IPathResult mPathResult;
    private int mStartLinkIndex;
    private int mStartSegIndex;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface ParamType {
    }

    public PowerDisRequestParam setDisToTarget(int i) {
        this.mDisToTarget = i;
        return this;
    }

    public PowerDisRequestParam setExternalData(PdExternalData pdExternalData) {
        this.mExternalData = pdExternalData;
        return this;
    }

    public PowerDisRequestParam setParamType(int i) {
        this.mParamType = i;
        return this;
    }

    public PowerDisRequestParam setPath(IVariantPath iVariantPath) {
        this.mPath = iVariantPath;
        return this;
    }

    public PowerDisRequestParam setPathResult(IPathResult iPathResult) {
        this.mPathResult = iPathResult;
        return this;
    }

    public PowerDisRequestParam setStartLinkIndex(int i) {
        this.mStartLinkIndex = i;
        return this;
    }

    public PowerDisRequestParam setStartSegIndex(int i) {
        this.mStartSegIndex = i;
        return this;
    }

    public int getParamType() {
        return this.mParamType;
    }

    public int getStartSegIndex() {
        return this.mStartSegIndex;
    }

    public int getStartLinkIndex() {
        return this.mStartLinkIndex;
    }

    public int getDisToTarget() {
        return this.mDisToTarget;
    }

    public IVariantPath getPath() {
        return this.mPath;
    }

    public IPathResult getPathResult() {
        return this.mPathResult;
    }

    public PdExternalData getExternalData() {
        return this.mExternalData;
    }
}
