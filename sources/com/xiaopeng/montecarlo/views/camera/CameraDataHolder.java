package com.xiaopeng.montecarlo.views.camera;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.FacilityInfoProvider;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCameraInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPFacilityInfo;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.util.ResUtil;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.montecarlo.views.camera.data.DataParseHelper;
/* loaded from: classes3.dex */
public class CameraDataHolder implements ICameraData {
    Drawable mCameraDrawable;
    FacilityInfoProvider mFacilityInfo;

    public CameraDataHolder(FacilityInfoProvider facilityInfoProvider) {
        this.mFacilityInfo = facilityInfoProvider;
    }

    @Override // com.xiaopeng.montecarlo.views.camera.ICameraData
    public int getRemainDistance() {
        return this.mFacilityInfo.getXPRemainDistance();
    }

    @Override // com.xiaopeng.montecarlo.views.camera.ICameraData
    public int getRestrictSpeed() {
        return this.mFacilityInfo.getRestrictSpeed();
    }

    @Override // com.xiaopeng.montecarlo.views.camera.ICameraData
    public boolean isRestrictSpeed() {
        return this.mFacilityInfo.getXPCameraType() == this.mFacilityInfo.getRestrictSpeedType();
    }

    @Override // com.xiaopeng.montecarlo.views.camera.ICameraData
    public boolean hasSameDrawableWith(@NonNull ICameraData iCameraData) {
        return isRestrictSpeed() ? iCameraData.isRestrictSpeed() && getRestrictSpeed() == iCameraData.getRestrictSpeed() : !iCameraData.isRestrictSpeed() && getPredefinedCameraDrawableRes() == iCameraData.getPredefinedCameraDrawableRes();
        return false;
    }

    @Override // com.xiaopeng.montecarlo.views.camera.ICameraData
    public boolean hasDrawable() {
        return isRestrictSpeed() || getPredefinedCameraDrawableRes() != -1;
    }

    @Override // com.xiaopeng.montecarlo.views.camera.ICameraData
    public Drawable getCameraDrawable() {
        Drawable drawable = this.mCameraDrawable;
        if (drawable != null) {
            return drawable;
        }
        if (isRestrictSpeed()) {
            this.mCameraDrawable = createRestrictSpeedDrawable();
        } else {
            this.mCameraDrawable = getPredefinedCameraDrawable();
        }
        return this.mCameraDrawable;
    }

    @Override // com.xiaopeng.montecarlo.views.camera.ICameraData
    public int getPredefinedCameraDrawableRes() {
        FacilityInfoProvider facilityInfoProvider = this.mFacilityInfo;
        if (facilityInfoProvider instanceof XPCameraInfo) {
            return ResUtil.getCameraTypeResource(facilityInfoProvider.getXPCameraType());
        }
        if (facilityInfoProvider instanceof XPFacilityInfo) {
            return ResUtil.getCruiseCameraTypeResId(facilityInfoProvider.getXPCameraType());
        }
        return -1;
    }

    private Drawable getPredefinedCameraDrawable() {
        int predefinedCameraDrawableRes = getPredefinedCameraDrawableRes();
        if (predefinedCameraDrawableRes == -1) {
            return null;
        }
        return ThemeWatcherUtil.getDrawable(predefinedCameraDrawableRes);
    }

    private Drawable createRestrictSpeedDrawable() {
        int restrictSpeed = getRestrictSpeed();
        RestrictSpeedTextDrawable restrictSpeedTextDrawable = new RestrictSpeedTextDrawable(getTextSize(restrictSpeed), DataParseHelper.SHOW_RESTRICT_SPEED_COLOR, getTypeFace(restrictSpeed));
        restrictSpeedTextDrawable.setText(restrictSpeed <= 0 ? DataParseHelper.SHOW_RESTRICT_SPEED_TEXT_UNKOWN : String.valueOf(restrictSpeed));
        return restrictSpeedTextDrawable;
    }

    private Typeface getTypeFace(int i) {
        return Typeface.create(ContextUtils.getString(i <= 0 ? DataParseHelper.SHOW_RESTRIC_SPEED_TEXT_FONT_NAME : DataParseHelper.SHOW_RESTRIC_SPEED_NUM_FONT_NAME), 0);
    }

    private int getTextSize(int i) {
        return i <= 0 ? DataParseHelper.SHOW_RESTRICT_SPEED_TEXT_SIZE : DataParseHelper.SHOW_RESTRICT_SPEED_NUMBER_SIZE;
    }
}
