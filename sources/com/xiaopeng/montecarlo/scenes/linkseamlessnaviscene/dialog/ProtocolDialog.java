package com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.montecarlo.views.XpNetworkImageView;
import com.xiaopeng.montecarlo.views.dialog.XBaseDialog;
import com.xiaopeng.xui.app.XDialogInterface;
import com.xiaopeng.xui.widget.XTextView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public class ProtocolDialog extends XBaseDialog {
    public static final int PROTOCOL_AGREEMENT = 1;
    public static final int PROTOCOL_DEFAULT = -1;
    public static final int PROTOCOL_SERVICE = 2;
    public static final int PROTOCOL_XP = 0;
    public XTextView mBackBtn;
    private boolean mClearHistory;
    public View mFailureRootView;
    View mLoadRootView;
    public XpNetworkImageView mProgressView;
    private int mProtocolType;
    private String mRefreshUrl;
    public WebView mWebView;
    private static final String[] PROTOCOL = {"https://login.xiaopeng.com/account_binding.html", "https://cache.amap.com/h5/h5/publish/238/index.html", "https://cache.amap.com/h5/h5/publish/241/index.html"};
    private static final String[] PROTOCOL_DARK = {"https://login.xiaopeng.com/account_binding.html?type=dark", "https://cache.amap.com/h5/h5/publish/238/index.html?type=auto", "https://cache.amap.com/h5/h5/publish/241/index.html?type=auto"};

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface ProtocolType {
    }

    public ProtocolDialog(Context context, int i) {
        super(context, 2131755449, 2131755386, true, true);
        this.mProtocolType = -1;
        this.mClearHistory = false;
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_protocol, (ViewGroup) null);
        setContentView(inflate, false);
        initView(inflate);
        setCloseVisibility(true);
        setTitleVisibility(false);
        setPositiveButton(context.getString(R.string.link_seamless_dialog_ok), (XDialogInterface.OnClickListener) null);
        setNegativeButton(context.getString(R.string.link_seamless_dialog_cancel));
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dialog.-$$Lambda$ProtocolDialog$YCvUeG2VwNkbeKzWsyDCH3hJPvI
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                ProtocolDialog.this.lambda$new$0$ProtocolDialog(dialogInterface);
            }
        });
        if (i <= -1 || i >= PROTOCOL.length) {
            return;
        }
        this.mProtocolType = i;
        loadContent();
    }

    public /* synthetic */ void lambda$new$0$ProtocolDialog(DialogInterface dialogInterface) {
        dismiss();
    }

    public static void showProtocol(Context context, int i) {
        new ProtocolDialog(context, i).show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.app.XDialog
    public void finalize() throws Throwable {
        super.finalize();
        WebView webView = this.mWebView;
        if (webView != null) {
            webView.destroy();
            LinearLayout linearLayout = (LinearLayout) this.mWebView.getParent();
            if (linearLayout != null) {
                linearLayout.removeAllViews();
            }
            this.mWebView = null;
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void initView(View view) {
        this.mWebView = (WebView) view.findViewById(R.id.xbind_webview);
        this.mBackBtn = (XTextView) view.findViewById(R.id.xbind_back_btn);
        this.mBackBtn.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dialog.-$$Lambda$ProtocolDialog$er9sLkX5TiBOGtQxYEpL3rnI0X4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ProtocolDialog.this.lambda$initView$1$ProtocolDialog(view2);
            }
        });
        this.mProgressView = (XpNetworkImageView) view.findViewById(R.id.bind_protocol_progress);
        this.mFailureRootView = view.findViewById(R.id.bind_protocol_load_fail_layout);
        this.mFailureRootView.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dialog.-$$Lambda$ProtocolDialog$Mu2tO7zLyEsXdy1fR9sxAxQ6Qsg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ProtocolDialog.this.lambda$initView$2$ProtocolDialog(view2);
            }
        });
        this.mLoadRootView = view.findViewById(R.id.bind_protocol_load_layout);
        this.mWebView.setBackgroundColor(0);
        this.mWebView.getSettings().setJavaScriptEnabled(true);
        this.mWebView.setWebViewClient(new WebViewClient() { // from class: com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dialog.ProtocolDialog.1
            boolean mIsLoadFail = false;

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                ProtocolDialog.this.showProgressView(false);
                ProtocolDialog.this.mRefreshUrl = str2;
                this.mIsLoadFail = true;
                ProtocolDialog.this.showFailureView(true);
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                ProtocolDialog.this.showProgressView(true);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                if (ProtocolDialog.this.mClearHistory) {
                    ProtocolDialog.this.mClearHistory = false;
                    ProtocolDialog.this.mWebView.clearHistory();
                }
                super.onPageFinished(webView, str);
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (str.contains("http") && !this.mIsLoadFail) {
                    ProtocolDialog.this.showFailureView(false);
                    ProtocolDialog.this.showProgressView(false);
                }
                this.mIsLoadFail = false;
            }
        });
    }

    public /* synthetic */ void lambda$initView$1$ProtocolDialog(View view) {
        onBackClick();
    }

    public /* synthetic */ void lambda$initView$2$ProtocolDialog(View view) {
        onFailRefreshClick();
    }

    private void loadContent() {
        boolean isDayMode = ThemeWatcherUtil.isDayMode();
        int i = this.mProtocolType;
        if (i > -1) {
            String[] strArr = PROTOCOL;
            if (i < strArr.length) {
                this.mWebView.loadUrl(isDayMode ? strArr[i] : PROTOCOL_DARK[i]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showFailureView(boolean z) {
        View view = this.mFailureRootView;
        if (view != null) {
            if (z) {
                view.setVisibility(0);
                WebView webView = this.mWebView;
                if (webView != null) {
                    webView.setVisibility(4);
                }
                XTextView xTextView = this.mBackBtn;
                if (xTextView != null) {
                    xTextView.setVisibility(8);
                    return;
                }
                return;
            }
            view.setVisibility(8);
            if (this.mWebView != null) {
                this.mLoadRootView.setVisibility(0);
                this.mWebView.setVisibility(0);
                if (this.mWebView.canGoBack()) {
                    this.mBackBtn.setVisibility(0);
                } else {
                    this.mBackBtn.setVisibility(8);
                }
            }
        }
    }

    private void changeUrl() {
        WebView webView = this.mWebView;
        if (webView != null) {
            webView.clearHistory();
            showProgressView(true);
            this.mClearHistory = true;
            this.mFailureRootView.setVisibility(4);
            loadContent();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showProgressView(boolean z) {
        XpNetworkImageView xpNetworkImageView = this.mProgressView;
        if (xpNetworkImageView != null) {
            if (z) {
                xpNetworkImageView.setVisibility(0);
                this.mFailureRootView.setVisibility(8);
                this.mLoadRootView.setVisibility(4);
                return;
            }
            xpNetworkImageView.setVisibility(8);
        }
    }

    public void onBackClick() {
        if (this.mWebView.canGoBack()) {
            this.mWebView.goBack();
            this.mWebView.invalidate();
        }
    }

    public void onFailRefreshClick() {
        WebView webView = this.mWebView;
        if (webView != null) {
            webView.loadUrl(this.mRefreshUrl);
        }
    }

    @Override // com.xiaopeng.montecarlo.views.dialog.XBaseDialog
    public void setIsNight(boolean z) {
        super.setIsNight(z);
        exchangeDayNight();
    }

    private void exchangeDayNight() {
        changeUrl();
    }
}
