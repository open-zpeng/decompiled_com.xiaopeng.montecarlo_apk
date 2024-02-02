package com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.autonavi.gbl.user.account.model.AccountAosResult;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.base.BaseScene;
import com.xiaopeng.montecarlo.base.scene.IBaseScene;
import com.xiaopeng.montecarlo.bridge.LinkPlatformBridge;
import com.xiaopeng.montecarlo.navcore.account.XPAccountServiceWrapper;
import com.xiaopeng.montecarlo.navcore.event.AccountEvent;
import com.xiaopeng.montecarlo.navcore.search.offlinedata.XPOfflineDataManager;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.root.datalog.PageType;
import com.xiaopeng.montecarlo.root.network.XPNetworkManager;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.ILinkPlatformContract;
import com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dialog.ProtocolDialog;
import com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dialog.QRCodeDialog;
import com.xiaopeng.montecarlo.stat.NaviGuiderStatUtil;
import com.xiaopeng.montecarlo.util.QrCodeUtil;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.montecarlo.util.Utils;
import com.xiaopeng.xui.app.XDialog;
import com.xiaopeng.xui.app.XDialogInterface;
import com.xiaopeng.xui.app.XLoadingDialog;
import com.xiaopeng.xui.app.XToast;
import com.xiaopeng.xui.utils.XDialogUtils;
import com.xiaopeng.xui.widget.XImageButton;
import com.xiaopeng.xui.widget.XImageView;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XLoading;
import com.xiaopeng.xui.widget.XRelativeLayout;
import com.xiaopeng.xui.widget.XTextView;
/* loaded from: classes2.dex */
public class LinkPlatformFragment extends BaseScene implements ILinkPlatformContract.LogicView {
    private static final L.Tag TAG = new L.Tag("LinkPlatformFragment");
    private static final int TAG_AMAP_BTN_BIND = 0;
    private static final int TAG_AMAP_BTN_LOGIN = 1;
    private static final int TAG_AMAP_BTN_UNBIND = 3;
    private static final String TAG_AMAP_QRCODE_DIALOG = "tag_link_platform_amap_bind_amap_dialog";
    private static final int TAG_REFRESH_WECHAT_QRCODE = 4;
    private static final String TAG_WECHAT_QRCODE_DIALOG = "tag_link_platform_wechat_qrcode_dialog";
    private static final int TAG_XP_BTN_LOGIN = 2;
    private static final String URL_AMAP = "/gaode";
    private static final String URL_BAIDU = "/baidu";
    private static final String URL_DAY_SUFFIX = "/index.html";
    private static final String URL_DIANPING = "/dianping";
    private static final String URL_MEITUAN = "/meituan";
    private static final String URL_NIGHT_SUFFIX = "/index_night.html";
    private static final String URL_WECHAT = "/wechat";
    private static final String URL_XIAOPENG = "/xiaopeng";
    private AccountAosResult mAccountAosResult;
    private QRCodeDialog mAmapQRCodeDialog;
    private ViewGroup mBaseView;
    private String mBoundAmapAccount;
    @BindView(R.id.ll_fail)
    public XLinearLayout mFailLayout;
    @BindView(R.id.iv_close)
    XImageButton mIbClose;
    @BindView(R.id.iv_fail)
    public XImageView mIvFail;
    @BindView(R.id.layout_agreement)
    public XLinearLayout mLayoutAgreement;
    @BindView(R.id.rl_main_content)
    public XRelativeLayout mLayoutMain;
    @BindView(R.id.loading)
    public XLoading mLoadingView;
    private int mPlatformType;
    private String mPlatformUrl;
    private LinkPlatformPresent mPresenter;
    private QRCodeDialog mQRCodeDialog;
    @BindView(R.id.tv_agreement)
    public XTextView mTvAgreement;
    @BindView(R.id.tv_agreement_declare)
    public XTextView mTvAgreementDeclare;
    @BindView(R.id.tv_bind_action)
    public XTextView mTvBindAction;
    @BindView(R.id.tv_bound_account)
    public XTextView mTvBoundAccount;
    @BindView(R.id.tv_fail_explain)
    public XTextView mTvFail;
    @BindView(R.id.tv_refresh)
    public XTextView mTvRefresh;
    @BindView(R.id.tv_title)
    public XTextView mTvTitle;
    private Unbinder mUnbinder;
    public WebView mWvPlatform;
    private XLoadingDialog mXLoadingDialog;

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public void hide() {
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public void show() {
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IBaseScene
    public boolean showCover() {
        return true;
    }

    public static BaseScene newInstance() {
        return new LinkPlatformFragment();
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene
    protected View onSceneCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.layout_link_platform, viewGroup, true);
        this.mBaseView = viewGroup;
        this.mUnbinder = ButterKnife.bind(this, inflate);
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneViewCreated(View view, @Nullable Bundle bundle) {
        super.onSceneViewCreated(view, bundle);
        initData(getBridge().getBundle());
        initViews();
        initSpecialViews();
        initWebView();
        initListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneAttach(Context context) {
        super.onSceneAttach(context);
        updateSettingView(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneDetach() {
        super.onSceneDetach();
        updateSettingView(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneResume() {
        this.mPresenter.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public void onScenePause() {
        this.mPresenter.onPause();
    }

    private void updateSettingView(boolean z) {
        IBaseScene sceneByType = getSceneByType(PageType.NAVI_MESSAGE_NAVI_SYNC);
        if (sceneByType != null) {
            sceneByType.getSceneContainer().setVisibility(z ? 8 : 0);
        }
    }

    private void initSpecialViews() {
        ViewGroup viewGroup;
        if (!Utils.isLandscape() || (viewGroup = this.mBaseView) == null) {
            return;
        }
        viewGroup.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.-$$Lambda$-l5-bwGKjKbgqiJ45rJC8V_zgj0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LinkPlatformFragment.this.onClickClose(view);
            }
        });
    }

    private void initData(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        this.mPlatformType = bundle.getInt(LinkPlatformBridge.PLATFORM_TYPE_KEY);
        this.mPresenter.initData(this.mPlatformType);
        if (258 == this.mPlatformType) {
            showLoadingDialog();
            this.mPresenter.getUserInfo();
        }
    }

    private void initViews() {
        String string;
        switch (this.mPlatformType) {
            case 256:
                NaviGuiderStatUtil.bIXpAccountPager();
                this.mPlatformUrl = URL_XIAOPENG;
                string = getString(R.string.link_seamless_platform_xiaopeng);
                break;
            case 257:
                NaviGuiderStatUtil.bIWeChatPager();
                this.mPlatformUrl = URL_WECHAT;
                string = getString(R.string.link_seamless_platform_wechat);
                this.mTvBindAction.setTag(4);
                this.mTvBindAction.setText(R.string.link_seamless_wechat_bind);
                this.mTvBindAction.setVisibility(0);
                break;
            case 258:
                NaviGuiderStatUtil.bIBindAmapPager();
                this.mPlatformUrl = URL_AMAP;
                string = getString(R.string.link_seamless_platform_amap);
                this.mTvBindAction.setTag(2);
                break;
            case 259:
                this.mPlatformUrl = URL_BAIDU;
                string = getString(R.string.link_seamless_platform_baidu);
                break;
            case 260:
                this.mPlatformUrl = URL_DIANPING;
                string = getString(R.string.link_seamless_platform_dianping);
                break;
            case 261:
                this.mPlatformUrl = URL_MEITUAN;
                string = getString(R.string.link_seamless_platform_meituan);
                break;
            default:
                string = null;
                break;
        }
        this.mTvTitle.setText(getString(R.string.link_seamless_send_address_from_platform, string));
    }

    private void initWebView() {
        this.mWvPlatform = new WebView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(2, R.id.tv_bind_action);
        layoutParams.addRule(3, R.id.ll_header);
        this.mLayoutMain.addView(this.mWvPlatform, layoutParams);
        this.mWvPlatform.setBackgroundColor(0);
        if (this.mWvPlatform.getBackground() != null) {
            this.mWvPlatform.getBackground().setAlpha(0);
        }
        this.mWvPlatform.setVerticalScrollBarEnabled(true);
        this.mWvPlatform.setHorizontalScrollBarEnabled(false);
        this.mWvPlatform.getSettings().setJavaScriptEnabled(true);
        this.mWvPlatform.setWebViewClient(new WebViewClient() { // from class: com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.LinkPlatformFragment.1
            boolean mLoadFail = false;

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                LinkPlatformFragment.this.showLoadingView(true);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                L.Tag tag = LinkPlatformFragment.TAG;
                L.i(tag, "onReceivedError errorCode : " + i + ", description : " + str + ", failingUrl : " + str2);
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                onReceivedError(str2);
            }

            public void onReceivedError(String str) {
                L.Tag tag = LinkPlatformFragment.TAG;
                L.w(tag, "load failed failingUrl : " + str);
                this.mLoadFail = true;
                LinkPlatformFragment.this.showLoadingView(false);
                LinkPlatformFragment.this.showFailView();
                LinkPlatformFragment.this.initSeamlessData();
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                LinkPlatformFragment.this.showLoadingView(false);
                if (this.mLoadFail) {
                    LinkPlatformFragment.this.showFailView();
                } else {
                    LinkPlatformFragment.this.hideFailView();
                }
                this.mLoadFail = false;
            }
        });
        loadUrl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initSeamlessData() {
        WorkThreadUtil.getInstance().executeIOTask(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.LinkPlatformFragment.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    XPOfflineDataManager.getInstance().clearSeamlessData();
                    XPOfflineDataManager.getInstance().initDataOnce(5);
                } catch (Exception unused) {
                    L.w(LinkPlatformFragment.TAG, "init seamless fail");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showFailView() {
        WebView webView = this.mWvPlatform;
        if (webView != null) {
            webView.setVisibility(8);
        }
        XLinearLayout xLinearLayout = this.mFailLayout;
        if (xLinearLayout != null) {
            xLinearLayout.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideFailView() {
        WebView webView = this.mWvPlatform;
        if (webView != null) {
            webView.setVisibility(0);
        }
        XLinearLayout xLinearLayout = this.mFailLayout;
        if (xLinearLayout != null) {
            xLinearLayout.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView(boolean z) {
        XLoading xLoading = this.mLoadingView;
        if (xLoading != null) {
            xLoading.setVisibility(z ? 0 : 8);
        }
    }

    private void loadUrl() {
        String seamlessDataPath = SettingWrapper.getSeamlessDataPath();
        if (TextUtils.isEmpty(seamlessDataPath)) {
            seamlessDataPath = RootUtil.getDataPath() + RootUtil.SD_CARD_DIR_SEAMLESS_ASSETS_DATA_PATH;
        }
        StringBuilder sb = new StringBuilder("file:///");
        sb.append(seamlessDataPath);
        sb.append(this.mPlatformUrl);
        if (ThemeWatcherUtil.isDayMode()) {
            sb.append(URL_DAY_SUFFIX);
        } else {
            sb.append(URL_NIGHT_SUFFIX);
        }
        L.i(TAG, "load url seamless local path : " + sb.toString());
        this.mWvPlatform.loadUrl(sb.toString());
    }

    private void initListener() {
        this.mTvAgreement.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.-$$Lambda$LinkPlatformFragment$pJDSTlZFzx2Cu2P9NkGLCOsUxsY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LinkPlatformFragment.this.lambda$initListener$0$LinkPlatformFragment(view);
            }
        });
        this.mTvBindAction.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.-$$Lambda$LinkPlatformFragment$fN3p8fjAnBbFt3s0q3irzyyDII0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LinkPlatformFragment.this.lambda$initListener$2$LinkPlatformFragment(view);
            }
        });
    }

    public /* synthetic */ void lambda$initListener$0$LinkPlatformFragment(View view) {
        ProtocolDialog.showProtocol(getContext(), 0);
    }

    public /* synthetic */ void lambda$initListener$2$LinkPlatformFragment(View view) {
        if (!isNetConnected()) {
            runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.-$$Lambda$LinkPlatformFragment$N8HA0NJRwz7eBTZuIxO22oR-snQ
                @Override // java.lang.Runnable
                public final void run() {
                    XToast.showShort((int) R.string.network_disconnect);
                }
            });
        } else if (preventMultiClick(this.mTvBindAction)) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (intValue == 0) {
                showLoadingDialog();
                this.mPresenter.oneSecBindAmap();
            } else if (intValue == 1) {
                NaviGuiderStatUtil.bIBindAmapClick();
                showLoadingDialog();
                this.mPresenter.requestAmapQrcode();
            } else if (intValue == 2) {
                this.mPresenter.xpQuickLogin();
            } else if (intValue == 3) {
                NaviGuiderStatUtil.bIUnbindAmapBtn();
                showUnbindDialog();
            } else if (intValue != 4) {
            } else {
                NaviGuiderStatUtil.bIBindWechatClick();
                showLoadingDialog();
                this.mPresenter.requestWechatQrcode();
            }
        }
    }

    private boolean isNetConnected() {
        return XPNetworkManager.INSTANCE.isNetworkConnected();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.DayNightFragment
    public void onThemeSwitchDelegate(int i) {
        super.onThemeSwitchDelegate(i);
        renderViewByTheme();
        loadUrl();
    }

    private void renderViewByTheme() {
        if (isSceneLegal()) {
            renderAmapBindActionBtn();
        }
    }

    private void renderAmapBindActionBtn() {
        XTextView xTextView = this.mTvBindAction;
        if (xTextView == null || 258 != this.mPlatformType) {
            return;
        }
        if (3 == ((Integer) xTextView.getTag()).intValue()) {
            this.mTvBindAction.setVisibility(0);
            this.mTvBindAction.setText(R.string.link_seamless_amap_unbind);
            this.mLayoutAgreement.setVisibility(8);
            if (TextUtils.isEmpty(this.mBoundAmapAccount)) {
                this.mTvBoundAccount.setVisibility(8);
            } else {
                this.mTvBoundAccount.setVisibility(0);
                this.mTvBoundAccount.setText(getString(R.string.link_seamless_amap_bound_account, this.mBoundAmapAccount));
            }
            this.mTvBindAction.setBackgroundResource(ThemeWatcherUtil.getDrawableResId(R.drawable.layer_link_seamless_unbind_btn_bg));
            this.mTvBindAction.setTextColor(ThemeWatcherUtil.getColor(R.color.primary_text01));
            return;
        }
        this.mTvBindAction.setVisibility(0);
        this.mTvBindAction.setText(R.string.link_seamless_amap_bind);
        this.mLayoutAgreement.setVisibility(0);
        this.mTvBoundAccount.setVisibility(8);
        this.mTvBindAction.setBackgroundResource(ThemeWatcherUtil.getDrawableResId(R.drawable.layer_common_gradient_btn_bg));
        this.mTvBindAction.setTextColor(ThemeWatcherUtil.getColor(R.color.link_seamless_btn_text_color));
    }

    @OnClick({R.id.iv_close})
    public void onClickClose(View view) {
        super.goBack();
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    /* renamed from: getPresenter */
    public LinkPlatformPresent mo96getPresenter() {
        return this.mPresenter;
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public void setPresenter(LinkPlatformPresent linkPlatformPresent) {
        this.mPresenter = linkPlatformPresent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneDestroyView() {
        super.onSceneDestroyView();
        this.mPresenter.onDestroy();
        WebView webView = this.mWvPlatform;
        if (webView != null) {
            this.mLayoutMain.removeView(webView);
            this.mWvPlatform.destroy();
            this.mWvPlatform = null;
        }
        this.mUnbinder.unbind();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneStop() {
        super.onSceneStop();
        dismissDialog();
    }

    private void dismissDialog() {
        dismissLoadingDialog();
        hideAmapQRCodeDialog();
        hideWechatQRCodeDialog();
    }

    private void hideWechatQRCodeDialog() {
        QRCodeDialog qRCodeDialog = this.mQRCodeDialog;
        if (qRCodeDialog != null) {
            qRCodeDialog.dismissAllowingStateLoss();
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.ILinkPlatformContract.LogicView
    public void onGetUserInfoSuccess(String str, boolean z) {
        if (isSceneLegal()) {
            if (z) {
                dismissLoadingDialog();
                this.mTvBindAction.setTag(2);
                renderAmapBindActionBtn();
                return;
            }
            this.mPresenter.checkBindAMapStatus();
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.ILinkPlatformContract.LogicView
    public void onCheckBindAMapStatusSuccess(boolean z) {
        if (isSceneLegal()) {
            if (z) {
                this.mPresenter.getAmapAccount();
                return;
            }
            this.mBoundAmapAccount = null;
            if (XPAccountServiceWrapper.getInstance().isLoginXp()) {
                this.mPresenter.checkIsAmapAccount();
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.ILinkPlatformContract.LogicView
    public void onCheckIsAmapAccountSuccess(boolean z) {
        dismissLoadingDialog();
        if (z) {
            this.mTvBindAction.setTag(0);
        } else {
            this.mTvBindAction.setTag(1);
        }
        renderAmapBindActionBtn();
    }

    @Override // com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.ILinkPlatformContract.LogicView
    public void onLoginSuccess(String str, boolean z) {
        if (isSceneLegal()) {
            this.mBoundAmapAccount = null;
            this.mTvBindAction.setTag(Integer.valueOf(z ? 2 : 1));
            renderAmapBindActionBtn();
            this.mPresenter.checkBindAMapStatus();
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.ILinkPlatformContract.LogicView
    public void onWechatQrCodeSuccess(String str) {
        if (isSceneLegal()) {
            dismissLoadingDialog();
            showWechatQRCodeDialog(QrCodeUtil.createQRCodeBitmap(str, 216, 216));
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.ILinkPlatformContract.LogicView
    public void onAmapQrCodeSuccess(AccountEvent accountEvent) {
        if (isSceneLegal()) {
            dismissLoadingDialog();
            if (accountEvent == null) {
                return;
            }
            showAmapQRCodeDialog(accountEvent.getBitmap());
            this.mAccountAosResult = accountEvent.getAccountAosResult();
            this.mPresenter.loginByAMapQRCode(accountEvent.getAccountAosResult());
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.ILinkPlatformContract.LogicView
    public void onAmapAccountSuccess(String str) {
        if (isSceneLegal()) {
            dismissLoadingDialog();
            this.mTvBindAction.setTag(3);
            this.mBoundAmapAccount = str;
            renderAmapBindActionBtn();
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.ILinkPlatformContract.LogicView
    public void onLoginAmapSuccess(boolean z, boolean z2) {
        L.Tag tag = TAG;
        L.i(tag, "bindmap onLoginAmapSuccess isLogin=" + z + " isQuickLogin=" + z2);
        if (isSceneLegal()) {
            if (!z2) {
                if (z) {
                    this.mPresenter.bindAmap(z2);
                } else {
                    this.mPresenter.loginByAMapQRCode(this.mAccountAosResult);
                }
            } else if (z) {
                dismissLoadingDialog();
                this.mTvBindAction.setTag(3);
                renderAmapBindActionBtn();
                if (TextUtils.isEmpty(this.mBoundAmapAccount)) {
                    this.mPresenter.getAmapAccount();
                }
            } else {
                this.mPresenter.oneSecBindAmap();
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.ILinkPlatformContract.LogicView
    public void onBindAmapSuccess(boolean z) {
        dismissLoadingDialog();
        hideAmapQRCodeDialog();
        if (z) {
            this.mPresenter.getAmapAccount();
        } else {
            this.mPresenter.checkIsAmapAccount();
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.ILinkPlatformContract.LogicView
    public void onBindAmapFailed() {
        dismissLoadingDialog();
        XToast.showShort((int) R.string.link_seamless_bind_amap_fail_hint);
    }

    @Override // com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.ILinkPlatformContract.LogicView
    public void onUnbindAmapFailed() {
        dismissLoadingDialog();
        XToast.showShort((int) R.string.link_seamless_unbind_amap_fail_hint);
    }

    @Override // com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.ILinkPlatformContract.LogicView
    public void onRequestWechatFailed() {
        dismissLoadingDialog();
        XToast.showShort((int) R.string.network_abnormal);
    }

    @Override // com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.ILinkPlatformContract.LogicView
    public void onLoginAMapFail() {
        dismissLoadingDialog();
        AccountAosResult accountAosResult = this.mAccountAosResult;
        if (accountAosResult != null) {
            this.mPresenter.loginByAMapQRCode(accountAosResult);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.ILinkPlatformContract.LogicView
    public void onStateActive() {
        getMainContext().onStateActive();
    }

    @Override // com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.ILinkPlatformContract.LogicView
    public void onStateImmersion() {
        getMainContext().onStateImmersion();
        goBackMapCenter();
    }

    @Override // com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.ILinkPlatformContract.LogicView
    public void onDataFetchTimeout() {
        dismissLoadingDialog();
        getMainContext().showPrompt(R.string.offline_pop_toast);
    }

    public void goBackMapCenter() {
        if (isSceneLegal()) {
            getMainContext().getMapView().restoreCarPosition();
            getMainContext().getMapView().goBackCenter();
        }
    }

    public void showLoadingDialog() {
        XLoadingDialog xLoadingDialog = this.mXLoadingDialog;
        if (xLoadingDialog == null) {
            this.mXLoadingDialog = XLoadingDialog.show(getContext(), getString(R.string.search_result_loading_text));
        } else {
            xLoadingDialog.show();
        }
    }

    public void dismissLoadingDialog() {
        XLoadingDialog xLoadingDialog = this.mXLoadingDialog;
        if (xLoadingDialog != null) {
            xLoadingDialog.dismiss();
        }
    }

    private void showWechatQRCodeDialog(Bitmap bitmap) {
        this.mQRCodeDialog = QRCodeDialog.newInstance(1, bitmap);
        this.mQRCodeDialog.showAllowingStateLoss(getFragmentManager(), TAG_WECHAT_QRCODE_DIALOG);
    }

    private void showAmapQRCodeDialog(Bitmap bitmap) {
        this.mAmapQRCodeDialog = QRCodeDialog.newInstance(2, bitmap);
        this.mAmapQRCodeDialog.showAllowingStateLoss(getFragmentManager(), TAG_AMAP_QRCODE_DIALOG);
    }

    private void hideAmapQRCodeDialog() {
        QRCodeDialog qRCodeDialog = this.mAmapQRCodeDialog;
        if (qRCodeDialog != null) {
            qRCodeDialog.dismissAllowingStateLoss();
        }
    }

    private void showUnbindDialog() {
        new XDialog(getContext(), XDialog.Parameters.Builder().setTheme(R.style.dialog_style)).setTitle(R.string.setting_account_unbind_map_btn_name).setMessage(R.string.unbind_amap_dialog_content).setPositiveButton(getString(R.string.link_seamless_dialog_ok), new XDialogInterface.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.LinkPlatformFragment.4
            @Override // com.xiaopeng.xui.app.XDialogInterface.OnClickListener
            public void onClick(XDialog xDialog, int i) {
                xDialog.dismiss();
                if (LinkPlatformFragment.this.mPresenter != null) {
                    LinkPlatformFragment.this.showLoadingDialog();
                    LinkPlatformFragment.this.mPresenter.unBindAmap();
                }
            }
        }).setNegativeButton(getString(R.string.link_seamless_dialog_cancel), new XDialogInterface.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.LinkPlatformFragment.3
            @Override // com.xiaopeng.xui.app.XDialogInterface.OnClickListener
            public void onClick(XDialog xDialog, int i) {
                xDialog.dismiss();
            }
        }).show();
        XDialogUtils.handleSoftInput(this.mXLoadingDialog);
    }
}
