package com.xiaopeng.montecarlo.scenes.cruisescene.util;

import android.view.ViewGroup;
import com.xiaopeng.montecarlo.util.Utils;
/* loaded from: classes3.dex */
public class ToggleShowCardConflictHelper {

    /* loaded from: classes3.dex */
    public interface IConflictControlView {
        ViewGroup getToggleView();

        void setCanShowByOther(boolean z);

        default boolean hasData() {
            return getToggleView() != null && getToggleView().getChildCount() > 0;
        }
    }

    public static void toggleViewShow(boolean z, IConflictControlView... iConflictControlViewArr) {
        if (Utils.isLandscape()) {
            for (IConflictControlView iConflictControlView : iConflictControlViewArr) {
                if (iConflictControlView != null && iConflictControlView.getToggleView() != null) {
                    ViewGroup toggleView = iConflictControlView.getToggleView();
                    iConflictControlView.setCanShowByOther(z);
                    toggleView.setVisibility((z && iConflictControlView.hasData()) ? 0 : 8);
                }
            }
        }
    }
}
