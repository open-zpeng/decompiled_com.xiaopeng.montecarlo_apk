package com.xiaopeng.montecarlo.scenes.debugscene.page;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.location.sensor.ImuSensor;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.scenes.debugscene.AutoListView;
import com.xiaopeng.montecarlo.scenes.debugscene.DebugItemTag;
import java.util.Locale;
/* loaded from: classes2.dex */
public class BLPropertyPage extends BasePage {
    private static final int DEBUG_LOAD_THREADS_COUNT = 5;
    private static final int DEBUG_MAP_CACHE_FACTOR = 8;
    private static final int DEBUG_MAP_IMU_DEALY_TIME = 10;
    private static final int DEBUG_MAP_RENDER_FPS = 6;
    private static final int DEBUG_MAP_SAMPLES = 3;
    private static final int DEBUG_MAP_TEXT_SCALE = 2;
    private static final int DEBUG_MAP_ZOOM_SCALE = 1;
    private static final int DEBUG_RENDER_FPS_ANIMATION = 2;
    private static final int DEBUG_RENDER_FPS_GESTURE = 3;
    private static final int DEBUG_RENDER_FPS_NAVI = 0;
    private static final int DEBUG_RENDER_FPS_NORMAL = 1;
    private Context mContext;
    private int mCurrentRenderFpsMode;
    private static final L.Tag TAG = new L.Tag("BLPropertyPage");
    private static boolean sRealCityEnable = false;
    private static boolean sFblEnable = true;

    @DebugItemTag(initMethod = "initLoadThreadsCount", value = R.string.debug_load_threads_count)
    public void menu5_BlProperty(View view) {
    }

    @DebugItemTag(initMethod = "initRenderFps", value = R.string.debug_navigation_frames_up)
    public void menu6_BlProperty(View view) {
    }

    @DebugItemTag(initMethod = "initIMUDelay", value = R.string.debug_imu_sensor_delay_time)
    public void menu9_BlPropertyImuDelay(View view) {
    }

    @Override // com.xiaopeng.montecarlo.scenes.debugscene.page.BasePage
    public void onViewCreated(View view) {
    }

    @Override // com.xiaopeng.montecarlo.scenes.debugscene.page.BasePage
    public View onCreateView(LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        this.mContext = viewGroup.getContext();
        AutoListView autoListView = new AutoListView(this.mContext, null, 16842868);
        autoListView.setItemObj(this, R.layout.debug_blproperty_item, R.id.debug_list_item_text);
        return autoListView;
    }

    @DebugItemTag(initMethod = "initWhetherShow3dConstruction", value = R.string.debug_whether_show_3d_construction)
    public void menu0_BlProperty(View view) {
        Switch r3 = (Switch) view.findViewById(R.id.debug_list_item_switch);
        boolean isChecked = r3.isChecked();
        r3.setChecked(!isChecked);
        setWhetherShow3dConstruction(!isChecked);
    }

    public void initWhetherShow3dConstruction(View view, int i) {
        Switch showSwitch = showSwitch(view);
        boolean bldAndModelVisibility = this.mMainContext.getMapView().getBldAndModelVisibility();
        if (showSwitch != null) {
            showSwitch.setChecked(bldAndModelVisibility);
            L.Tag tag = TAG;
            L.i(tag, " initWhetherShow3dConstruction --" + bldAndModelVisibility);
        }
    }

    private void setWhetherShow3dConstruction(boolean z) {
        this.mMainContext.getMapView().setBldAndModelVisibility(z);
    }

    @DebugItemTag(initMethod = "initMapZoomScale", value = R.string.debug_map_zoom_scale_ratio)
    public void menu1_BlProperty(View view, int i) {
        ((Switch) view.findViewById(R.id.debug_list_item_switch)).setChecked(true);
    }

    public void initMapZoomScale(View view, int i) {
        showSeekBar(view, i, 0.5f, 1.0f, 0.1f, 1.0f, DataSetHelper.GlobalSet.getFloat(DataSetHelper.GlobalSet.DEBUG_MAP_ZOOM_SCALE_RATIO, 1.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setZoomScale(float f) {
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.DEBUG_MAP_ZOOM_SCALE_RATIO, f);
    }

    @DebugItemTag(initMethod = "initMapTextScaleSetting", value = R.string.debug_map_textscale_setting)
    public void menu2_BlProperty(View view) {
        ((Switch) view.findViewById(R.id.debug_list_item_switch)).setChecked(true);
    }

    public void initMapTextScaleSetting(View view, int i) {
        showSeekBar(view, i, 0.8f, 2.0f, 0.1f, 1.5f, DataSetHelper.GlobalSet.getFloat(DataSetHelper.GlobalSet.DEBUG_MAP_TEXTSCALE_SETTING, 1.5f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTextScale(float f) {
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.DEBUG_MAP_TEXTSCALE_SETTING, f);
    }

    @DebugItemTag(initMethod = "initMapSamples", value = R.string.debug_anti_aliasing)
    public void menu3_BlProperty(View view) {
        ((Switch) view.findViewById(R.id.debug_list_item_switch)).setChecked(true);
    }

    public void initMapSamples(View view, int i) {
        showSeekBar(view, i, 2.0f, 4.0f, 2.0f, 4.0f, DataSetHelper.GlobalSet.getFloat(DataSetHelper.GlobalSet.DEBUG_MAP_SAMPLES, 4.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMapSamples(int i) {
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.DEBUG_MAP_SAMPLES, i);
    }

    @DebugItemTag(initMethod = "initRealCityEnable", value = R.string.debug_real_city_enable)
    public void menu4_BlProperty(View view) {
        Switch r3 = (Switch) view.findViewById(R.id.debug_list_item_switch);
        boolean isChecked = r3.isChecked();
        r3.setChecked(!isChecked);
        setRealCityEnable(!isChecked);
    }

    public void initRealCityEnable(View view, int i) {
        Switch showSwitch = showSwitch(view);
        if (showSwitch != null) {
            showSwitch.setChecked(sRealCityEnable);
            L.Tag tag = TAG;
            L.i(tag, " initRealCityEnable --" + sRealCityEnable);
        }
    }

    private void setRealCityEnable(boolean z) {
        if (this.mMainContext.getMapView().setRealCityEnable(z)) {
            sRealCityEnable = z;
        }
    }

    public void initLoadThreadsCount(View view, int i) {
        showSeekBar(view, i, 2.0f, 8.0f, 1.0f, 8.0f, DataSetHelper.GlobalSet.getFloat(DataSetHelper.GlobalSet.DEBUG_ASYNCTASK_THREADCOUNT, 8.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMapAyncThreadsCount(int i) {
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.DEBUG_ASYNCTASK_THREADCOUNT, i);
    }

    public void initRenderFps(View view, int i) {
        this.mCurrentRenderFpsMode = 0;
        showSeekBar(view, i, 10.0f, 60.0f, 5.0f, 10.0f, 10.0f);
        showRenderFpsRadioGroup(view, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void renderModeChanged(View view, int i, int i2) {
        float f;
        switch (i2) {
            case R.id.animation_radio /* 2131296368 */:
                this.mCurrentRenderFpsMode = 2;
                f = 30.0f;
                break;
            case R.id.curise_raido /* 2131296547 */:
                this.mCurrentRenderFpsMode = 1;
                f = 15.0f;
                break;
            case R.id.gesture_radio /* 2131296668 */:
                this.mCurrentRenderFpsMode = 3;
                f = 40.0f;
                break;
            case R.id.guide_radio /* 2131296690 */:
                this.mCurrentRenderFpsMode = 0;
            default:
                f = 10.0f;
                break;
        }
        showSeekBar(view, i, 10.0f, 60.0f, 5.0f, f, f);
        showRenderFpsRadioGroup(view, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNaviRenderFps(int i) {
        this.mMainContext.getMapView().setRenderFpsByMode(this.mCurrentRenderFpsMode, i);
    }

    @DebugItemTag(initMethod = "initFboControl", value = R.string.debug_fbo_control)
    public void menu7_BlProperty(View view) {
        Switch r3 = (Switch) view.findViewById(R.id.debug_list_item_switch);
        boolean isChecked = r3.isChecked();
        r3.setChecked(!isChecked);
        setFboEnable(!isChecked);
    }

    public void initFboControl(View view, int i) {
        Switch showSwitch = showSwitch(view);
        if (showSwitch != null) {
            showSwitch.setChecked(sFblEnable);
            L.Tag tag = TAG;
            L.i(tag, " initFboControl --" + sFblEnable);
        }
    }

    private void setFboEnable(boolean z) {
        if (this.mMainContext.getMapView().setFboEnable(z)) {
            sFblEnable = z;
        }
    }

    @DebugItemTag(initMethod = "initMapCacheFactor", value = R.string.debug_map_cache_factor)
    public void menu8_BlProperty(View view) {
        ((Switch) view.findViewById(R.id.debug_list_item_switch)).setChecked(true);
    }

    public void initMapCacheFactor(View view, int i) {
        showSeekBar(view, i, 0.5f, 4.0f, 0.1f, 2.0f, DataSetHelper.GlobalSet.getFloat(DataSetHelper.GlobalSet.DEBUG_MAP_CACHE_FACTOR, 2.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMapCacheFactor(float f) {
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.DEBUG_MAP_CACHE_FACTOR, f);
    }

    @DebugItemTag(initMethod = "initReboot", value = R.string.debug_map_note)
    public void menu9_BlProperty(View view) {
        ((Switch) view.findViewById(R.id.debug_list_item_switch)).setChecked(true);
    }

    public void initReboot(View view, int i) {
        showReboot(view);
    }

    public void initIMUDelay(View view, int i) {
        showSeekBar(view, i, 0.0f, 1000.0f, 100.0f, (float) ImuSensor.sIMUDelayTime, (float) ImuSensor.sIMUDelayTime);
    }

    private void showSeekBar(View view, int i, float f, float f2, float f3, float f4, float f5) {
        resetView(view);
        View findViewById = view.findViewById(R.id.debug_list_item_seekbar_des_container);
        SeekBar seekBar = (SeekBar) view.findViewById(R.id.debug_list_item_seekbar);
        TextView textView = (TextView) view.findViewById(R.id.debug_list_item_float_text);
        ((TextView) view.findViewById(R.id.debug_list_item_seekbar_default_Value)).setText(String.format(Locale.US, "default:%.1f", Float.valueOf(f4)));
        ((TextView) view.findViewById(R.id.debug_list_item_seekbar_minValue)).setText(String.format(Locale.US, "min:%.1f", Float.valueOf(f)));
        ((TextView) view.findViewById(R.id.debug_list_item_seekbar_maxValue)).setText(String.format(Locale.US, "max:%.1f", Float.valueOf(f2)));
        seekBar.setMax((int) ((f2 - f) / f3));
        seekBar.setProgress((int) ((f5 - f) / f3));
        textView.setText(String.format(Locale.US, "cur:%.1f", Float.valueOf(f5)));
        seekBar.setVisibility(0);
        findViewById.setVisibility(0);
        seekBar.setOnSeekBarChangeListener(new MySeekBarListener(i, f, f3, textView));
    }

    private void hideSeekBar(View view) {
        View findViewById = view.findViewById(R.id.debug_list_item_seekbar_des_container);
        ((SeekBar) view.findViewById(R.id.debug_list_item_seekbar)).setVisibility(8);
        findViewById.setVisibility(8);
    }

    private Switch showSwitch(View view) {
        resetView(view);
        Switch r2 = (Switch) view.findViewById(R.id.debug_list_item_switch);
        if (r2 != null) {
            r2.setVisibility(0);
        }
        return r2;
    }

    private void hideSwitch(View view) {
        ((Switch) view.findViewById(R.id.debug_list_item_switch)).setVisibility(8);
    }

    private void showRenderFpsRadioGroup(final View view, final int i) {
        RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.renderfps_radiogroup);
        radioGroup.setVisibility(0);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.page.BLPropertyPage.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup2, int i2) {
                BLPropertyPage.this.renderModeChanged(view, i, i2);
            }
        });
    }

    private void hideRadioGroup(View view) {
        ((RadioGroup) view.findViewById(R.id.renderfps_radiogroup)).setVisibility(8);
    }

    private void resetView(View view) {
        hideSwitch(view);
        hideSeekBar(view);
        hideRadioGroup(view);
        hideReboot(view);
    }

    private void showReboot(View view) {
        resetView(view);
        view.findViewById(R.id.debug_list_item_reboot_container).setVisibility(0);
        ((Button) view.findViewById(R.id.debug_list_item_reboot_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.page.BLPropertyPage.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                BLPropertyPage.this.reboot();
            }
        });
        ((Button) view.findViewById(R.id.debug_list_item_reset_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.page.BLPropertyPage.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                BLPropertyPage.this.reset();
            }
        });
    }

    private void hideReboot(View view) {
        view.findViewById(R.id.debug_list_item_reboot_container).setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.DEBUG_MAP_ZOOM_SCALE_RATIO, 1.0f);
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.DEBUG_MAP_TEXTSCALE_SETTING, 1.5f);
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.DEBUG_MAP_SAMPLES, 4);
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.DEBUG_ASYNCTASK_THREADCOUNT, 8);
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.DEBUG_MAP_CACHE_FACTOR, 2.0f);
        RootUtil.delayExitApp(RootUtil.KILL_NAVI_RESET_BL_PROPERTY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reboot() {
        RootUtil.delayExitApp(RootUtil.KILL_NAVI_RESET_BL_PROPERTY);
    }

    /* loaded from: classes2.dex */
    public class MySeekBarListener implements SeekBar.OnSeekBarChangeListener {
        private float mFactor;
        private TextView mFloatTextView;
        private int mPos;
        private float mStartValue;

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        public MySeekBarListener(int i, float f, float f2, TextView textView) {
            this.mPos = i;
            this.mStartValue = f;
            this.mFactor = f2;
            this.mFloatTextView = textView;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            this.mFloatTextView.setText(String.format(Locale.US, "cur:%.1f", Float.valueOf((i * this.mFactor) + this.mStartValue)));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            float progress = (seekBar.getProgress() * this.mFactor) + this.mStartValue;
            L.Tag tag = BLPropertyPage.TAG;
            L.i(tag, "onStopTrackingTouch: " + this.mPos);
            int i = this.mPos;
            if (i == 1) {
                L.Tag tag2 = BLPropertyPage.TAG;
                L.i(tag2, "onStopTrackingTouch DEBUG_MAP_ZOOM_SCALE " + progress);
                BLPropertyPage.this.setZoomScale(progress);
            } else if (i == 2) {
                L.Tag tag3 = BLPropertyPage.TAG;
                L.i(tag3, "onStopTrackingTouch DEBUG_MAP_TEXT_SCALE " + progress);
                BLPropertyPage.this.setTextScale(progress);
            } else if (i == 3) {
                L.Tag tag4 = BLPropertyPage.TAG;
                L.i(tag4, "onStopTrackingTouch DEBUG_MAP_SAMPLES " + progress);
                BLPropertyPage.this.setMapSamples((int) progress);
            } else if (i == 5) {
                BLPropertyPage.this.setMapAyncThreadsCount((int) progress);
                L.Tag tag5 = BLPropertyPage.TAG;
                L.i(tag5, "onStopTrackingTouch DEBUG_ASYNCTASK_THREADCOUNT " + progress);
            } else if (i == 6) {
                L.Tag tag6 = BLPropertyPage.TAG;
                L.i(tag6, "onStopTrackingTouch DEBUG_NAVI_RENDER_FPS " + progress);
                BLPropertyPage.this.setNaviRenderFps((int) progress);
            } else if (i == 8) {
                L.Tag tag7 = BLPropertyPage.TAG;
                L.i(tag7, "onStopTrackingTouch DEBUG_MAP_CACHE_FACTOR " + progress);
                BLPropertyPage.this.setMapCacheFactor(progress);
            } else if (i != 10) {
            } else {
                ImuSensor.sIMUDelayTime = progress;
                L.Tag tag8 = BLPropertyPage.TAG;
                L.i(tag8, "onStopTrackingTouch DEBUG_MAP_IMU_DEALY_TIME: " + ImuSensor.sIMUDelayTime);
            }
        }
    }
}
