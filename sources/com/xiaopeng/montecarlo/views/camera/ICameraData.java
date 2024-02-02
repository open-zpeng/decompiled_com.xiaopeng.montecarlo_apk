package com.xiaopeng.montecarlo.views.camera;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public interface ICameraData {
    Drawable getCameraDrawable();

    int getPredefinedCameraDrawableRes();

    int getRemainDistance();

    int getRestrictSpeed();

    boolean hasDrawable();

    boolean hasSameDrawableWith(@NonNull ICameraData iCameraData);

    boolean isRestrictSpeed();
}
