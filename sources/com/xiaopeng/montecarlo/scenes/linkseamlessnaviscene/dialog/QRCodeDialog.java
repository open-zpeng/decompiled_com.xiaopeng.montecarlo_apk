package com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dialog;

import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.event.AccountEvent;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.ILinkQRCodeContract;
import com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.LinkQRCodePresenter;
import com.xiaopeng.montecarlo.util.QrCodeUtil;
import com.xiaopeng.montecarlo.views.QRRefreshButton;
import com.xiaopeng.xui.app.XToast;
import com.xiaopeng.xui.theme.XThemeManager;
import com.xiaopeng.xui.utils.XDialogUtils;
import com.xiaopeng.xui.widget.XImageView;
import com.xiaopeng.xui.widget.XTextView;
import com.xiaopeng.xui.widget.dialogview.XDialogView;
import com.xiaopeng.xui.widget.dialogview.XDialogViewInterface;
import java.lang.reflect.Field;
/* loaded from: classes3.dex */
public class QRCodeDialog extends DialogFragment implements ILinkQRCodeContract.LogicView {
    public static final String INTENT_KEY_QR_BITMAP = "intent_key_qr_bitmap";
    public static final String INTENT_KEY_QR_TYPE = "intent_key_qr_type";
    public static final int QR_TYPE_AMAP = 2;
    public static final int QR_TYPE_WECHAT = 1;
    public static final int REFRESH_AMAP_QRCODE = 1;
    public static final int REFRESH_AMAP_QRCODE_DELAY_TIME = 900000;
    private static final L.Tag TAG = new L.Tag("QRCodeDialog");
    private Bitmap mBitmap;
    private Handler mHandler;
    private XImageView mIvQRCode;
    private ILinkQRCodeContract.Presenter mPresenter;
    private QRRefreshButton mQRRefreshBtn;
    private XTextView mTvScanLogin;
    private int mType;

    @Override // androidx.fragment.app.DialogFragment
    @StyleRes
    public int getTheme() {
        return R.style.dialog_style;
    }

    public static QRCodeDialog newInstance(int i, Bitmap bitmap) {
        QRCodeDialog qRCodeDialog = new QRCodeDialog();
        qRCodeDialog.mBitmap = bitmap;
        Bundle bundle = new Bundle();
        bundle.putInt(INTENT_KEY_QR_TYPE, i);
        qRCodeDialog.setArguments(bundle);
        return qRCodeDialog;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        XDialogView xDialogView = new XDialogView(getContext());
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.fragment_qr_code, xDialogView.getContentView(), false);
        initData();
        initViews(inflate);
        xDialogView.setCustomView(inflate);
        xDialogView.setCloseVisibility(true);
        xDialogView.setOnDismissListener(new XDialogViewInterface.OnDismissListener() { // from class: com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dialog.-$$Lambda$QRCodeDialog$4HPImxjcI0G3FTPkPL3pKWM3xQo
            @Override // com.xiaopeng.xui.widget.dialogview.XDialogViewInterface.OnDismissListener
            public final void onDismiss(XDialogView xDialogView2) {
                QRCodeDialog.this.lambda$onCreateView$0$QRCodeDialog(xDialogView2);
            }
        });
        XDialogUtils.setSystemDialog(getDialog(), 2008);
        return xDialogView.getContentView();
    }

    public /* synthetic */ void lambda$onCreateView$0$QRCodeDialog(XDialogView xDialogView) {
        dismiss();
    }

    private void initData() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mType = arguments.getInt(INTENT_KEY_QR_TYPE);
        }
        this.mPresenter = new LinkQRCodePresenter(this);
        this.mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dialog.QRCodeDialog.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (1 != message.what || QRCodeDialog.this.mPresenter == null) {
                    return false;
                }
                QRCodeDialog.this.mPresenter.requestAmapQRCode();
                return false;
            }
        });
    }

    private void initViews(View view) {
        Handler handler;
        this.mIvQRCode = (XImageView) view.findViewById(R.id.iv_qrcode);
        this.mQRRefreshBtn = (QRRefreshButton) view.findViewById(R.id.rb_qrcode);
        this.mTvScanLogin = (XTextView) view.findViewById(R.id.tv_scan_login);
        int i = this.mType;
        if (1 == i) {
            this.mTvScanLogin.setText(R.string.link_seamless_wechat_scan_bind);
        } else if (2 == i) {
            this.mTvScanLogin.setText(R.string.link_seamless_amap_scan_login);
        }
        if (this.mBitmap == null) {
            this.mIvQRCode.setVisibility(8);
            this.mQRRefreshBtn.setVisibility(0);
        } else {
            this.mIvQRCode.setVisibility(0);
            this.mIvQRCode.setImageBitmap(this.mBitmap);
            this.mQRRefreshBtn.setVisibility(8);
            if (2 == this.mType && (handler = this.mHandler) != null) {
                handler.sendEmptyMessageDelayed(1, 900000L);
            }
        }
        this.mQRRefreshBtn.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dialog.QRCodeDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (QRCodeDialog.this.mPresenter == null) {
                    return;
                }
                QRCodeDialog.this.showRefresh();
                if (1 == QRCodeDialog.this.mType) {
                    QRCodeDialog.this.mPresenter.requestWechatQRCode();
                } else if (2 == QRCodeDialog.this.mType) {
                    QRCodeDialog.this.mPresenter.requestAmapQRCode();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showRefresh() {
        QRRefreshButton qRRefreshButton = this.mQRRefreshBtn;
        if (qRRefreshButton == null) {
            return;
        }
        qRRefreshButton.start();
    }

    private void cancelRefresh() {
        QRRefreshButton qRRefreshButton = this.mQRRefreshBtn;
        if (qRRefreshButton == null) {
            return;
        }
        qRRefreshButton.stop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.ILinkQRCodeContract.LogicView
    public void onWechatQRCodeSuccess(String str) {
        XImageView xImageView;
        cancelRefresh();
        if (TextUtils.isEmpty(str) || (xImageView = this.mIvQRCode) == null || this.mQRRefreshBtn == null) {
            return;
        }
        xImageView.setVisibility(0);
        this.mIvQRCode.setImageBitmap(QrCodeUtil.createQRCodeBitmap(str, 216, 216));
        this.mQRRefreshBtn.setVisibility(8);
    }

    @Override // com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.ILinkQRCodeContract.LogicView
    public void onAmapQRCodeSuccess(AccountEvent accountEvent) {
        XImageView xImageView;
        cancelRefresh();
        if (accountEvent == null || (xImageView = this.mIvQRCode) == null || this.mQRRefreshBtn == null) {
            return;
        }
        xImageView.setVisibility(0);
        this.mIvQRCode.setImageBitmap(accountEvent.getBitmap());
        this.mQRRefreshBtn.setVisibility(8);
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(1, 900000L);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.ILinkQRCodeContract.LogicView
    public void onError(String str) {
        cancelRefresh();
        XImageView xImageView = this.mIvQRCode;
        if (xImageView != null && this.mQRRefreshBtn != null) {
            xImageView.setVisibility(8);
            this.mQRRefreshBtn.setVisibility(0);
        }
        XToast.showShort((int) R.string.network_abnormal);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (getDialog() == null || getDialog().getWindow() == null) {
            return;
        }
        XThemeManager.setWindowBackgroundResource(configuration, getDialog().getWindow(), R.drawable.x_bg_dialog);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.mPresenter = null;
        this.mTvScanLogin = null;
        this.mQRRefreshBtn = null;
        this.mIvQRCode = null;
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        Handler handler = this.mHandler;
        if (handler != null && handler.hasMessages(1)) {
            this.mHandler.removeMessages(1);
        }
        this.mHandler = null;
    }

    public void showAllowingStateLoss(FragmentManager fragmentManager, String str) {
        try {
            Field declaredField = DialogFragment.class.getDeclaredField("mDismissed");
            declaredField.setAccessible(true);
            declaredField.set(this, false);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        }
        try {
            Field declaredField2 = DialogFragment.class.getDeclaredField("mShownByMe");
            declaredField2.setAccessible(true);
            declaredField2.set(this, true);
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        } catch (NoSuchFieldException e4) {
            e4.printStackTrace();
        }
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.add(this, str);
        beginTransaction.commitAllowingStateLoss();
    }
}
