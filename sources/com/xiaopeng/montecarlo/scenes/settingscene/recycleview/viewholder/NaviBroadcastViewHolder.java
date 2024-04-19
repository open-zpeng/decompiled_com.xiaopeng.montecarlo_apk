package com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder;

import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.setting.constant.NaviBroadcastTypeEnum;
import com.xiaopeng.montecarlo.scenes.settingscene.CommonTabChangeListener;
import com.xiaopeng.montecarlo.scenes.settingscene.recycleview.SettingPreferenceAdapterView;
import com.xiaopeng.montecarlo.stat.SettingStatUtil;
import com.xiaopeng.xui.widget.XTabLayout;
import com.xiaopeng.xui.widget.XTextView;
/* loaded from: classes3.dex */
public class NaviBroadcastViewHolder extends BaseSettingViewHolder {
    @BindView(R.id.setting_navi_broadcast_xindicator)
    XTabLayout mBroadcastXIndicator;
    private boolean mFromRecover;
    @BindView(R.id.setting_navi_explanation)
    XTextView mSettingNaviExplanation;
    @BindView(R.id.setting_navi_title)
    XTextView mSettingNaviTitle;

    public NaviBroadcastViewHolder(View view, SettingPreferenceAdapterView settingPreferenceAdapterView) {
        super(view, settingPreferenceAdapterView);
        this.mFromRecover = false;
        ButterKnife.bind(this, view);
        this.mBroadcastXIndicator.setOnTabChangeListener(new OnTabChangeListenerForNaviBroadcast(this, null));
    }

    @Override // com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.BaseSettingViewHolder
    public void refreshViewFromData() {
        NaviBroadcastTypeEnum naviBroadcastType = this.mAdapter.getProvider().getNaviBroadcastType();
        this.mBroadcastXIndicator.selectTab(naviBroadcastType.getId());
        setNaviBroadcastDesc(naviBroadcastType);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.NaviBroadcastViewHolder$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$xiaopeng$montecarlo$navcore$setting$constant$NaviBroadcastTypeEnum = new int[NaviBroadcastTypeEnum.values().length];

        static {
            try {
                $SwitchMap$com$xiaopeng$montecarlo$navcore$setting$constant$NaviBroadcastTypeEnum[NaviBroadcastTypeEnum.NAVI_DETAIL_BROADCAST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$navcore$setting$constant$NaviBroadcastTypeEnum[NaviBroadcastTypeEnum.NAVI_NORMAL_BROADCAST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$navcore$setting$constant$NaviBroadcastTypeEnum[NaviBroadcastTypeEnum.NAVI_SIMPLE_BROADCAST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNaviBroadcastDesc(NaviBroadcastTypeEnum naviBroadcastTypeEnum) {
        int i = AnonymousClass1.$SwitchMap$com$xiaopeng$montecarlo$navcore$setting$constant$NaviBroadcastTypeEnum[naviBroadcastTypeEnum.ordinal()];
        if (i == 1) {
            this.mSettingNaviExplanation.setText(R.string.setting_navi_explanation_detail_content);
        } else if (i == 2) {
            this.mSettingNaviExplanation.setText(R.string.setting_navi_explanation_normal_content);
        } else if (i != 3) {
        } else {
            this.mSettingNaviExplanation.setText(R.string.setting_navi_explanation_ultra_simple_content);
        }
    }

    /* loaded from: classes3.dex */
    private class OnTabChangeListenerForNaviBroadcast extends CommonTabChangeListener {
        private OnTabChangeListenerForNaviBroadcast() {
        }

        /* synthetic */ OnTabChangeListenerForNaviBroadcast(NaviBroadcastViewHolder naviBroadcastViewHolder, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.xiaopeng.montecarlo.scenes.settingscene.CommonTabChangeListener
        public void onTabSelected(int i) {
            if (i == 0) {
                SettingStatUtil.sendStatDataNaviDetailBroadcast(true);
                NaviBroadcastViewHolder.this.mAdapter.getProvider().setNaviBroadcastType(NaviBroadcastTypeEnum.NAVI_DETAIL_BROADCAST);
                NaviBroadcastViewHolder.this.mAdapter.modifySettingPreference(4, true);
                NaviBroadcastViewHolder.this.mAdapter.modifySettingPreference(5, false);
                NaviBroadcastViewHolder.this.mAdapter.modifySettingPreference(20, false);
                NaviBroadcastViewHolder.this.setNaviBroadcastDesc(NaviBroadcastTypeEnum.NAVI_DETAIL_BROADCAST);
            } else if (i == 1) {
                SettingStatUtil.sendStatDataNormalBroadcast(true);
                NaviBroadcastViewHolder.this.mAdapter.getProvider().setNaviBroadcastType(NaviBroadcastTypeEnum.NAVI_NORMAL_BROADCAST);
                NaviBroadcastViewHolder.this.mAdapter.modifySettingPreference(4, false);
                NaviBroadcastViewHolder.this.mAdapter.modifySettingPreference(5, true);
                NaviBroadcastViewHolder.this.mAdapter.modifySettingPreference(20, false);
                NaviBroadcastViewHolder.this.setNaviBroadcastDesc(NaviBroadcastTypeEnum.NAVI_NORMAL_BROADCAST);
            } else if (i == 2) {
                SettingStatUtil.sendStatDataUltraSimpleBroadcast(true);
                NaviBroadcastViewHolder.this.mAdapter.getProvider().setNaviBroadcastType(NaviBroadcastTypeEnum.NAVI_SIMPLE_BROADCAST);
                NaviBroadcastViewHolder.this.mAdapter.modifySettingPreference(4, false);
                NaviBroadcastViewHolder.this.mAdapter.modifySettingPreference(5, false);
                NaviBroadcastViewHolder.this.mAdapter.modifySettingPreference(20, true);
                NaviBroadcastViewHolder.this.setNaviBroadcastDesc(NaviBroadcastTypeEnum.NAVI_SIMPLE_BROADCAST);
            }
            NaviBroadcastViewHolder.this.mAdapter.saveSettingPreference();
        }
    }
}
