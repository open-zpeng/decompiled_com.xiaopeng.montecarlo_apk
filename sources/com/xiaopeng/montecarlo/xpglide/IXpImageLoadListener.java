package com.xiaopeng.montecarlo.xpglide;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public interface IXpImageLoadListener {
    void onLoadFailed();

    void onLoadStarted();

    void onLoadSuccess(@NonNull Bitmap bitmap);
}
