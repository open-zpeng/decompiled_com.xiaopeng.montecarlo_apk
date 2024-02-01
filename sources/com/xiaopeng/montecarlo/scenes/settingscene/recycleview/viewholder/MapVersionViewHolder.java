package com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder;

import android.content.Intent;
import android.os.SystemClock;
import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.bridge.DebugBridge;
import com.xiaopeng.montecarlo.navcore.sr.SRNaviManager;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dialog.ProtocolDialog;
import com.xiaopeng.montecarlo.scenes.settingscene.recycleview.SettingPreferenceAdapterView;
import com.xiaopeng.montecarlo.views.XpGroup;
import com.xiaopeng.xui.widget.XImageButton;
import com.xiaopeng.xui.widget.XTextView;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes3.dex */
public class MapVersionViewHolder extends BaseSettingViewHolder {
    private static final int MAX_CLICK_COUNT = 7;
    private static final int MAX_CLICK_TIME_INTERVAL = 2000;
    @BindView(R.id.setting_map_version_explanation)
    XTextView mAboutUs;
    @BindView(R.id.setting_about_auto_privacy_agreement)
    XTextView mAgreement;
    private LinkedBlockingQueue<Long> mHitsLinkQueue;
    @BindView(R.id.setting_lane_map_introduction)
    XTextView mLaneIntroduceV;
    @BindView(R.id.setting_map_version_content_title)
    XTextView mSettingMapVersionContentTitle;
    @BindView(R.id.setting_map_version_desc)
    XTextView mSettingMapVersionDesc;
    @BindView(R.id.setting_map_version_title)
    XTextView mSettingMapVersionTitle;
    @BindView(R.id.setting_about_auto_terms_service)
    XTextView mTermService;
    @BindView(R.id.setting_map_version_content)
    XpGroup mVersionContent;
    @BindView(R.id.setting_map_version_expand)
    XImageButton mVersionExpand;

    public MapVersionViewHolder(View view, SettingPreferenceAdapterView settingPreferenceAdapterView) {
        super(view, settingPreferenceAdapterView);
        this.mHitsLinkQueue = null;
        ButterKnife.bind(this, view);
        if (CarServiceManager.getInstance().isNGPOn() && SRNaviManager.getInstance().isLaneEnabled()) {
            this.mLaneIntroduceV.setVisibility(0);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.BaseSettingViewHolder
    public void refreshViewFromData() {
        this.mAboutUs.setText(this.mAdapter.getProvider().getMapVersion());
        this.mSettingMapVersionDesc.setText(this.mAdapter.getProvider().getMapVersionDescription());
    }

    @OnClick({R.id.setting_map_version_explanation, R.id.setting_map_version_expand, R.id.setting_map_version_container, R.id.setting_map_version_desc, R.id.setting_about_auto_privacy_agreement, R.id.setting_about_auto_terms_service, R.id.setting_lane_map_introduction})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.setting_about_auto_privacy_agreement /* 2131297228 */:
                if (preventMultiClick(view)) {
                    showAutoAgreementDialog(1);
                    return;
                }
                return;
            case R.id.setting_about_auto_terms_service /* 2131297229 */:
                if (preventMultiClick(view)) {
                    showAutoAgreementDialog(2);
                    return;
                }
                return;
            case R.id.setting_lane_map_introduction /* 2131297263 */:
                if (preventMultiClick(view)) {
                    openUserBook();
                    return;
                }
                return;
            case R.id.setting_map_version_container /* 2131297286 */:
            case R.id.setting_map_version_expand /* 2131297290 */:
            case R.id.setting_map_version_explanation /* 2131297291 */:
                expandOrCollapseVersion();
                return;
            case R.id.setting_map_version_desc /* 2131297289 */:
                if (RootUtil.isTabletApp()) {
                    this.mAdapter.startScene(new DebugBridge().enableOverMode());
                    return;
                } else if (RootUtil.isDebugMenuEnabled()) {
                    if (this.mHitsLinkQueue == null) {
                        this.mHitsLinkQueue = new LinkedBlockingQueue<>(7);
                    }
                    try {
                        this.mHitsLinkQueue.add(Long.valueOf(SystemClock.uptimeMillis()));
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                    }
                    if (SystemClock.uptimeMillis() - (this.mHitsLinkQueue.size() == 7 ? this.mHitsLinkQueue.poll().longValue() : 0L) <= 2000) {
                        this.mHitsLinkQueue = null;
                        this.mAdapter.startScene(new DebugBridge().enableOverMode());
                        return;
                    }
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    private void showAutoAgreementDialog(int i) {
        if (this.mAdapter == null || this.mAdapter.getContext() == null) {
            return;
        }
        ProtocolDialog.showProtocol(this.mAdapter.getContext(), i);
    }

    private void expandOrCollapseVersion() {
        if (this.mVersionContent.getVisibility() == 8) {
            this.mVersionExpand.animate().rotation(-90.0f).start();
            this.mVersionContent.setVisibility(0);
        } else {
            this.mVersionExpand.animate().rotation(90.0f).start();
            this.mVersionContent.setVisibility(8);
        }
        this.mAdapter.scrollToEnd();
    }

    public static void openUserBook() {
        Intent intent = new Intent("com.xiaopeng.usermanual.ACTION_LAUNCH");
        intent.setPackage("com.xiaopeng.usermanual");
        intent.putExtra("name", "KEY_WORD");
        intent.putExtra("words", ContextUtils.getString(R.string.setting_lane_map_function));
        intent.putExtra("callJump", true);
        intent.putExtra("jump", true);
        ContextUtils.getContext().sendBroadcast(intent);
    }
}
