package com.xiaopeng.montecarlo.scenes.navi;

import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.navcore.control.base.IBizDynamicLevelListener;
import com.xiaopeng.montecarlo.navcore.state.StateManager;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes3.dex */
public class SRViewAngleOperator implements IBizDynamicLevelListener {
    public static final float SR_VIEW_ANGLE_OVERLOOK_DEGREE = 0.0f;
    public static final float SR_VIEW_ANGLE_SIDELOOK_CAMERA_DEGREE = 65.0f;
    public static final float SR_VIEW_ANGLE_SIDELOOK_DEGREE = 25.0f;
    private static final L.Tag TAG = new L.Tag("SRViewAngleOperator");
    private int mCurrentSRViewAngle = 1;
    protected MainContext mMainContext;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface SRViewAngle {
        public static final int SR_VIEW_ANGLE_DEFAULT = 1;
        public static final int SR_VIEW_ANGLE_OVERLOOK = 2;
        public static final int SR_VIEW_ANGLE_SIDELOOK = 3;
    }

    public SRViewAngleOperator(MainContext mainContext) {
        this.mMainContext = mainContext;
    }

    public void setSrViewAngle(int i) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "set srviewAngle to " + i);
        }
        this.mCurrentSRViewAngle = i;
        if (1 == this.mCurrentSRViewAngle) {
            return;
        }
        StateManager.getInstance().switchActiveState();
        this.mMainContext.getMapView().getBizControlManager().openDynamicLevel(false, (IBizDynamicLevelListener) this);
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizDynamicLevelListener
    public void onOpenDynamicLevelFinish() {
        UiHandlerUtil.getInstance().runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.SRViewAngleOperator.1
            @Override // java.lang.Runnable
            public void run() {
                if (SRViewAngleOperator.this.mCurrentSRViewAngle == 2) {
                    SRViewAngleOperator.this.switchToOverLookAngle();
                } else if (SRViewAngleOperator.this.mCurrentSRViewAngle == 3) {
                    SRViewAngleOperator.this.switchToSideLookAngle();
                }
            }
        });
    }

    public int getCurrentSRViewAngle() {
        return this.mCurrentSRViewAngle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchToOverLookAngle() {
        if (L.ENABLE) {
            L.d(TAG, "switchToOverLookAngle");
        }
        this.mMainContext.getMapView().setMapLevel(18.0f);
        this.mMainContext.getMapView().setCameraDegree(0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchToSideLookAngle() {
        if (L.ENABLE) {
            L.d(TAG, "switchToSideLookAngle");
        }
        this.mMainContext.getMapView().setMapLevel(19.0f);
        this.mMainContext.getMapView().setCameraDegree(65.0f);
        this.mMainContext.getMapView().setMapAngle(this.mMainContext.getMapView().getMapAngle() + 25.0f);
    }
}
