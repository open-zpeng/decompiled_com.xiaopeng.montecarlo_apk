package com.xiaopeng.montecarlo.scenes.debugscene;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.DebugCacheConsts;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.montecarlo.util.Utils;
/* loaded from: classes2.dex */
public class CameraDegreeHelper implements Handler.Callback {
    private static final int MSG_DEGREE_DOWN = 2;
    private static final int MSG_DEGREE_UP = 1;
    private static final int MSG_LEVEL_DOWN = 6;
    private static final int MSG_LEVEL_UP = 5;
    private static final int MSG_RATIO_DOWN = 4;
    private static final int MSG_RATIO_UP = 3;
    private static final L.Tag TAG = new L.Tag("CameraDegreeHelper");
    private Activity mActivity;
    private float mCameraDegree;
    private ViewGroup mContainer;
    private float mLevel;
    private MapViewWrapper mMapViewWrapper;
    private float mRatio;
    private TextView mTvDegree;
    private TextView mTvLevel;
    private TextView mTvRatio;
    private Button mDegreeUp = null;
    private Activity mDegreeDown = null;
    private Handler mH = new Handler(WorkThreadUtil.getInstance().getDataProcessThreadLooper(), this);

    public CameraDegreeHelper(Activity activity, MapViewWrapper mapViewWrapper) {
        this.mActivity = null;
        this.mMapViewWrapper = null;
        this.mActivity = activity;
        this.mMapViewWrapper = mapViewWrapper;
    }

    public void showCameraDegreeBtn() {
        ViewGroup viewGroup = this.mContainer;
        if (viewGroup == null) {
            this.mContainer = (ViewGroup) this.mActivity.getLayoutInflater().inflate(R.layout.camera_degree_helper_layout, (ViewGroup) null);
            this.mContainer.findViewById(R.id.degree_up_btn).setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.CameraDegreeHelper.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CameraDegreeHelper.this.mCameraDegree += 1.0f;
                    CameraDegreeHelper.this.mH.removeMessages(1);
                    Message obtain = Message.obtain();
                    obtain.what = 1;
                    CameraDegreeHelper.this.mH.sendMessageDelayed(obtain, 400L);
                }
            });
            this.mContainer.findViewById(R.id.degree_down_btn).setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.CameraDegreeHelper.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CameraDegreeHelper.this.mCameraDegree -= 1.0f;
                    CameraDegreeHelper.this.mH.removeMessages(2);
                    Message obtain = Message.obtain();
                    obtain.what = 2;
                    CameraDegreeHelper.this.mH.sendMessageDelayed(obtain, 400L);
                }
            });
            this.mContainer.findViewById(R.id.ratio_up_btn).setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.CameraDegreeHelper.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CameraDegreeHelper.this.mRatio += 0.05f;
                    CameraDegreeHelper.this.mH.removeMessages(3);
                    Message obtain = Message.obtain();
                    obtain.what = 3;
                    CameraDegreeHelper.this.mH.sendMessageDelayed(obtain, 400L);
                }
            });
            this.mContainer.findViewById(R.id.ratio_down_btn).setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.CameraDegreeHelper.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CameraDegreeHelper.this.mRatio -= 0.05f;
                    CameraDegreeHelper.this.mH.removeMessages(4);
                    Message obtain = Message.obtain();
                    obtain.what = 4;
                    CameraDegreeHelper.this.mH.sendMessageDelayed(obtain, 400L);
                }
            });
            this.mContainer.findViewById(R.id.level_up_btn).setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.CameraDegreeHelper.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CameraDegreeHelper.this.mLevel += 0.1f;
                    CameraDegreeHelper.this.mH.removeMessages(5);
                    Message obtain = Message.obtain();
                    obtain.what = 5;
                    CameraDegreeHelper.this.mH.sendMessageDelayed(obtain, 400L);
                }
            });
            this.mContainer.findViewById(R.id.level_down_btn).setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.CameraDegreeHelper.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CameraDegreeHelper.this.mLevel -= 0.1f;
                    CameraDegreeHelper.this.mH.removeMessages(6);
                    Message obtain = Message.obtain();
                    obtain.what = 6;
                    CameraDegreeHelper.this.mH.sendMessageDelayed(obtain, 400L);
                }
            });
            this.mCameraDegree = 50.0f;
            this.mRatio = 0.5f;
            this.mLevel = 19.0f;
            this.mTvDegree = (TextView) this.mContainer.findViewById(R.id.degree);
            this.mTvDegree.setText(Utils.floatToString(this.mCameraDegree));
            this.mTvRatio = (TextView) this.mContainer.findViewById(R.id.ratio);
            this.mTvRatio.setText(Utils.floatToString(this.mRatio));
            this.mTvLevel = (TextView) this.mContainer.findViewById(R.id.level);
            this.mTvLevel.setText(Utils.floatToString(this.mLevel));
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 0, 0, -2);
            layoutParams.type = 2;
            layoutParams.flags = 524328;
            layoutParams.gravity = 85;
            layoutParams.x = 150;
            layoutParams.y = 120;
            ((WindowManager) this.mActivity.getSystemService("window")).addView(this.mContainer, layoutParams);
            return;
        }
        viewGroup.setEnabled(true);
        this.mContainer.setVisibility(0);
    }

    public void hideCameraDegreeBtn() {
        ViewGroup viewGroup = this.mContainer;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    public void initCameraDegreeView() {
        if (this.mActivity == null || this.mMapViewWrapper == null) {
            return;
        }
        if (DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.CACHE_IS_OPEN_CAMERA_DEGREE, DebugCacheConsts.DEFAULT_VALUE_CACHE_IS_OPEN_CAMERA_DEGREE)) {
            showCameraDegreeBtn();
        } else {
            hideCameraDegreeBtn();
        }
    }

    public void destroyCameraDegreeView() {
        if (this.mContainer != null) {
            ((WindowManager) this.mActivity.getSystemService("window")).removeView(this.mContainer);
            this.mContainer = null;
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
            case 2:
                handleDegreeChange();
                return false;
            case 3:
            case 4:
                handleRatioChange();
                return false;
            case 5:
            case 6:
                handleLevelChange();
                return false;
            default:
                return false;
        }
    }

    private void handleDegreeChange() {
        this.mMapViewWrapper.setCameraDegree(this.mCameraDegree);
        this.mMapViewWrapper.resetTickCount(1);
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.CameraDegreeHelper.7
            @Override // java.lang.Runnable
            public void run() {
                CameraDegreeHelper.this.mTvDegree.setText(String.valueOf(CameraDegreeHelper.this.mCameraDegree));
            }
        });
    }

    private void handleRatioChange() {
        MapViewWrapper mapViewWrapper = this.mMapViewWrapper;
        float f = this.mRatio;
        mapViewWrapper.setCarPositionRatio(f, f);
        this.mMapViewWrapper.resetTickCount(1);
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.CameraDegreeHelper.8
            @Override // java.lang.Runnable
            public void run() {
                CameraDegreeHelper.this.mTvRatio.setText(String.valueOf(CameraDegreeHelper.this.mRatio));
            }
        });
    }

    private void handleLevelChange() {
        this.mMapViewWrapper.setMapLevel(this.mLevel);
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.CameraDegreeHelper.9
            @Override // java.lang.Runnable
            public void run() {
                CameraDegreeHelper.this.mTvLevel.setText(String.valueOf(CameraDegreeHelper.this.mLevel));
            }
        });
    }
}
