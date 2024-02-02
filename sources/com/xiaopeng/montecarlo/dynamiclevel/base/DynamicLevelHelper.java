package com.xiaopeng.montecarlo.dynamiclevel.base;

import android.os.Handler;
import android.os.Message;
import com.xiaopeng.montecarlo.navcore.mapdisplay.IMapPreviewListener;
import com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
/* loaded from: classes2.dex */
public abstract class DynamicLevelHelper implements Handler.Callback, IMapPreviewListener {
    private static final float LEVEL_ACCURACY = 0.001f;
    private static final int MSG_CAMERA_DEGREE_REFRESH = 2;
    private static final int MSG_LEVEL_REFRESH = 1;
    private static final int MSG_UPDATE_NAVI_INFO = 3;
    private static final int REFRESH_INTERVAL = 40;
    private static final L.Tag TAG = new L.Tag("DynamicLevelHelper");
    private float mDegreeInterval = -1.0f;
    private long mDegreeUpdateStartMills;
    protected final DynamicLevelSetting mDynamicLevelSetting;
    protected int mGradualTimeCounts;
    private final Handler mH;
    private volatile boolean mIsEnable;
    protected boolean mIsGradualChange;
    private boolean mIsHeadUp3D;
    private volatile boolean mIsShowMapPreview;
    protected float mLevelInterval;
    private MapViewWrapper mMapViewWrapper;
    private float mPreLevel;
    private float mStartDegree;
    private float mToDegree;
    private float mToLevel;

    protected abstract boolean isNeedUpdate();

    protected abstract void reset();

    protected abstract void startDynamicLevel();

    protected abstract void stopDynamicLevel();

    protected abstract void updateInfo(Object obj);

    public DynamicLevelHelper(MapViewWrapper mapViewWrapper, DynamicLevelSetting dynamicLevelSetting) {
        this.mMapViewWrapper = mapViewWrapper;
        if (dynamicLevelSetting == null) {
            throw new IllegalArgumentException(" DynamicLevelSetting should not be null");
        }
        this.mDynamicLevelSetting = dynamicLevelSetting;
        this.mH = new Handler(WorkThreadUtil.getInstance().getDynamicLevelThreadLooper(), this);
        this.mMapViewWrapper.addMapPreviewListener(this);
    }

    public final synchronized void enableDynamicLevel() {
        if (this.mIsEnable) {
            L.i(TAG, "DynamicLevel is already enabled");
            return;
        }
        if (L.ENABLE) {
            L.d(TAG, "enableDynamicLevel");
        }
        this.mIsEnable = true;
        this.mPreLevel = this.mMapViewWrapper.getMapLevelF();
        startDynamicLevel();
    }

    public final synchronized void disableDynamicLevel() {
        if (!this.mIsEnable) {
            L.i(TAG, "DynamicLevel is already disabled !");
            return;
        }
        if (L.ENABLE) {
            L.d(TAG, "disableDynamicLevel");
        }
        this.mIsEnable = false;
        stopDynamicLevel();
        clearMessageQueue();
    }

    @Override // android.os.Handler.Callback
    public final synchronized boolean handleMessage(Message message) {
        int i = message.what;
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    handleUpdateInfoMsg(message.obj);
                }
            } else if (this.mIsEnable) {
                refreshDegree();
                this.mH.removeMessages(2);
                this.mH.sendEmptyMessageDelayed(2, 40L);
            } else {
                clearMessageQueue();
            }
        } else if (this.mIsEnable) {
            refreshLevel();
            this.mH.removeMessages(1);
            this.mH.sendEmptyMessageDelayed(1, 40L);
        } else {
            clearMessageQueue();
        }
        return true;
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.IMapPreviewListener
    public synchronized void onBeforeMapPreviewEnter() {
        if (this.mIsEnable) {
            this.mIsShowMapPreview = true;
            disableDynamicLevel();
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.IMapPreviewListener
    public synchronized void onAfterMapPreviewEnter() {
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.IMapPreviewListener
    public synchronized void onBeforeMapPreviewExit() {
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.IMapPreviewListener
    public synchronized void onAfterMapPreviewExit() {
        if (this.mIsShowMapPreview) {
            this.mIsShowMapPreview = false;
            enableDynamicLevel();
        }
    }

    public synchronized void sendUpdateInfoMsg() {
        sendUpdateInfoMsg(null);
    }

    public synchronized void sendUpdateInfoMsg(Object obj) {
        if (this.mIsEnable) {
            Message obtain = Message.obtain();
            obtain.what = 3;
            obtain.obj = obj;
            this.mH.sendMessage(obtain);
        }
    }

    public synchronized void release() {
        disableDynamicLevel();
        this.mMapViewWrapper.removeMapPreviewListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void sendUpdateInfoMsgDelayed(int i) {
        if (this.mIsEnable) {
            this.mH.sendEmptyMessageDelayed(3, i * 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized boolean isHeadUp3D() {
        return this.mIsHeadUp3D;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized boolean isNorthUp() {
        return this.mMapViewWrapper.getMapMode() == 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void sendRefreshMsg() {
        if (this.mIsEnable) {
            this.mMapViewWrapper.finishAllAnimation();
            this.mH.sendEmptyMessage(1);
            if (this.mDynamicLevelSetting.isEnableDynamicDegree()) {
                this.mH.sendEmptyMessage(2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void sendLevelRefreshMsg() {
        if (this.mIsEnable) {
            this.mH.sendEmptyMessage(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized boolean updateInterval(int i) {
        return updateLevelInterval(i) || updateDegreeInterval(i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
        if (r0 > r4.mToLevel) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private synchronized boolean canLevelRefresh() {
        /*
            r4 = this;
            monitor-enter(r4)
            float r0 = r4.mPreLevel     // Catch: java.lang.Throwable -> L34
            float r1 = r4.mLevelInterval     // Catch: java.lang.Throwable -> L34
            float r0 = r0 - r1
            float r1 = r4.mToLevel     // Catch: java.lang.Throwable -> L34
            float r1 = r0 - r1
            float r1 = java.lang.Math.abs(r1)     // Catch: java.lang.Throwable -> L34
            r2 = 981668463(0x3a83126f, float:0.001)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            r2 = 0
            if (r1 >= 0) goto L18
            monitor-exit(r4)
            return r2
        L18:
            float r1 = r4.mLevelInterval     // Catch: java.lang.Throwable -> L34
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 >= 0) goto L25
            float r1 = r4.mToLevel     // Catch: java.lang.Throwable -> L34
            int r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r1 < 0) goto L31
        L25:
            float r1 = r4.mLevelInterval     // Catch: java.lang.Throwable -> L34
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 <= 0) goto L32
            float r1 = r4.mToLevel     // Catch: java.lang.Throwable -> L34
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L32
        L31:
            r2 = 1
        L32:
            monitor-exit(r4)
            return r2
        L34:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.dynamiclevel.base.DynamicLevelHelper.canLevelRefresh():boolean");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized boolean updateLevelInterval(int i) {
        float level = this.mDynamicLevelSetting.getLevel();
        this.mLevelInterval = 0.0f;
        boolean z = false;
        if (level >= 0.0f) {
            this.mToLevel = level;
            if (Math.abs(this.mPreLevel - level) < LEVEL_ACCURACY) {
                this.mPreLevel = level;
                this.mMapViewWrapper.setMapLevel(level);
                return false;
            }
            if (!RootUtil.compareFloat(this.mPreLevel, level)) {
                this.mLevelInterval = this.mDynamicLevelSetting.getGradientInterval(this.mPreLevel, level, i, 40);
                z = true;
            }
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.v(tag, " updateLevelInterval  seconds:" + i + "  fromLevel:" + this.mPreLevel + " toLevel:" + level + " mToLevel:" + this.mToLevel + " mLevelInterval:" + this.mLevelInterval);
            }
        }
        if (L.ENABLE) {
            L.Tag tag2 = TAG;
            L.v(tag2, " updateLevelInterval  ret:" + z);
        }
        return z;
    }

    private synchronized void refreshLevel() {
        if (!RootUtil.compareFloat(this.mLevelInterval, 0.0f)) {
            if (canLevelRefresh()) {
                float f = this.mPreLevel - this.mLevelInterval;
                if (L.ENABLE) {
                    L.Tag tag = TAG;
                    L.v(tag, " refreshLevel  fromLevel:" + this.mPreLevel + "  toLevel:" + f + "  mToLevel" + this.mToLevel + "   mLevelInterval:" + this.mLevelInterval);
                }
                this.mPreLevel = f;
                this.mMapViewWrapper.setMapLevel(f);
            } else {
                this.mH.removeMessages(1);
                if (!RootUtil.compareFloat(this.mPreLevel, this.mToLevel) && this.mToLevel > 0.0f && Math.abs(this.mPreLevel - this.mToLevel) < 0.1d) {
                    if (L.ENABLE) {
                        L.Tag tag2 = TAG;
                        L.v(tag2, " refreshLevel  fromLevel:" + this.mPreLevel + "  mToLevel" + this.mToLevel);
                    }
                    this.mMapViewWrapper.setMapLevel(this.mToLevel);
                }
            }
        }
    }

    private synchronized boolean updateDegreeInterval(int i) {
        boolean z;
        z = false;
        if (this.mIsHeadUp3D && this.mDynamicLevelSetting.isEnableDynamicDegree()) {
            float cameraDegree = this.mMapViewWrapper.getCameraDegree();
            float cameraDegree2 = this.mDynamicLevelSetting.getCameraDegree();
            this.mDegreeInterval = 0.0f;
            if (cameraDegree2 != 10000.0f) {
                this.mToDegree = cameraDegree2;
                if (!RootUtil.compareFloat(cameraDegree, cameraDegree2) && Math.abs(cameraDegree - cameraDegree2) > 1.0f) {
                    this.mDegreeInterval = this.mDynamicLevelSetting.getGradientInterval(cameraDegree, cameraDegree2, i, 40);
                    this.mDegreeUpdateStartMills = System.currentTimeMillis();
                    this.mStartDegree = cameraDegree;
                    z = true;
                }
                if (L.ENABLE) {
                    L.Tag tag = TAG;
                    L.v(tag, " updateDegreeInterval  fromDegree:" + cameraDegree + "  toDegree:" + cameraDegree2 + "  mToDegree" + this.mToDegree + "   mDegreeInterval:" + this.mDegreeInterval);
                }
            }
        }
        if (L.ENABLE) {
            L.Tag tag2 = TAG;
            L.v(tag2, " updateDegreeInterval  toDegree:" + this.mIsHeadUp3D + "  ret:" + z);
        }
        return z;
    }

    private synchronized void refreshDegree() {
        if (this.mIsHeadUp3D) {
            if (!RootUtil.compareFloat(this.mDegreeInterval, 0.0f)) {
                float cameraDegree = this.mMapViewWrapper.getCameraDegree();
                float currentTimeMillis = this.mStartDegree - (this.mDegreeInterval * ((int) ((System.currentTimeMillis() - this.mDegreeUpdateStartMills) / 40)));
                if (Math.abs(cameraDegree - currentTimeMillis) > 5.0f) {
                    this.mH.removeMessages(2);
                    this.mDynamicLevelSetting.refreshFail();
                    return;
                }
                if (Math.abs(cameraDegree - this.mToDegree) > 1.0f && ((this.mDegreeInterval > 0.0f && currentTimeMillis > this.mToDegree) || (this.mDegreeInterval < 0.0f && currentTimeMillis < this.mToDegree))) {
                    this.mMapViewWrapper.setCameraDegree(currentTimeMillis);
                    if (L.ENABLE) {
                        L.Tag tag = TAG;
                        L.v(tag, " refreshDegree  fromDegree:" + cameraDegree + "  toDegree:" + currentTimeMillis + "   mDegreeInterval:" + this.mDegreeInterval + "  mToDegree:" + this.mToDegree);
                    }
                } else {
                    this.mH.removeMessages(2);
                    if (!RootUtil.compareFloat(cameraDegree, this.mToDegree) && this.mToDegree > 0.0f && Math.abs(cameraDegree - this.mToDegree) < 5.0f) {
                        if (L.ENABLE) {
                            L.Tag tag2 = TAG;
                            L.v(tag2, " refreshDegree  fromDegree:" + cameraDegree + "  mToDegree:" + this.mToDegree);
                        }
                        this.mMapViewWrapper.setCameraDegree(this.mToDegree);
                    }
                }
            }
        }
    }

    private synchronized void handleUpdateInfoMsg(Object obj) {
        clearMessageQueue();
        this.mIsHeadUp3D = this.mMapViewWrapper.getMapMode() == 2;
        if (this.mIsEnable && isNeedUpdate()) {
            updateInfo(obj);
            return;
        }
        reset();
    }

    private synchronized void clearMessageQueue() {
        this.mH.removeMessages(1);
        this.mH.removeMessages(2);
        this.mH.removeMessages(3);
    }
}
