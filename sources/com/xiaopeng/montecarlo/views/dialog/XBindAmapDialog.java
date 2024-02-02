package com.xiaopeng.montecarlo.views.dialog;

import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.fragment.app.DialogFragment;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.xui.app.XToast;
import com.xiaopeng.xui.theme.XThemeManager;
import com.xiaopeng.xui.utils.XDialogUtils;
import com.xiaopeng.xui.widget.XTextView;
import com.xiaopeng.xui.widget.dialogview.XDialogView;
import com.xiaopeng.xui.widget.dialogview.XDialogViewInterface;
/* loaded from: classes3.dex */
public class XBindAmapDialog extends DialogFragment {
    private static final L.Tag TAG = new L.Tag("XBindAmapDialog");
    private XTextView mAgreementTv;
    private View.OnClickListener mCancelOnClickListener;
    private OnXBindAmapDialogListener mListener;
    private Dialog mLoadingDialog;
    private View.OnClickListener mOkOnClickListener;
    private View.OnClickListener mOpenProtocolClick;
    private XDialogView mXDialog;

    /* loaded from: classes3.dex */
    public interface OnXBindAmapDialogListener {
        void onXBindAmapDialogDismiss(XDialogView xDialogView);

        void onXBindAmapDialogShow(XDialogView xDialogView);
    }

    @Override // androidx.fragment.app.DialogFragment
    @StyleRes
    public int getTheme() {
        return R.style.dialog_style;
    }

    public void setXBindAmapDialogListener(OnXBindAmapDialogListener onXBindAmapDialogListener) {
        this.mListener = onXBindAmapDialogListener;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.mXDialog = new XDialogView(getContext());
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.bind_amap_protocol_layout, this.mXDialog.getContentView(), false);
        initViews(inflate);
        this.mXDialog.setTitleVisibility(false).setCustomView(inflate);
        this.mXDialog.setCloseVisibility(false);
        this.mXDialog.setPositiveButton(getString(R.string.one_sec_bind_btn_name), new XDialogViewInterface.OnClickListener() { // from class: com.xiaopeng.montecarlo.views.dialog.XBindAmapDialog.2
            @Override // com.xiaopeng.xui.widget.dialogview.XDialogViewInterface.OnClickListener
            public void onClick(XDialogView xDialogView, int i) {
                if (XBindAmapDialog.this.mOkOnClickListener != null) {
                    XBindAmapDialog.this.mOkOnClickListener.onClick(null);
                }
            }
        }).setNegativeButton(getString(R.string.no_binding_btn_name), new XDialogViewInterface.OnClickListener() { // from class: com.xiaopeng.montecarlo.views.dialog.XBindAmapDialog.1
            @Override // com.xiaopeng.xui.widget.dialogview.XDialogViewInterface.OnClickListener
            public void onClick(XDialogView xDialogView, int i) {
                if (XBindAmapDialog.this.mCancelOnClickListener != null) {
                    XBindAmapDialog.this.mCancelOnClickListener.onClick(null);
                }
            }
        });
        this.mXDialog.setOnDismissListener(new XDialogViewInterface.OnDismissListener() { // from class: com.xiaopeng.montecarlo.views.dialog.XBindAmapDialog.3
            @Override // com.xiaopeng.xui.widget.dialogview.XDialogViewInterface.OnDismissListener
            public void onDismiss(XDialogView xDialogView) {
                XBindAmapDialog.this.dismiss();
            }
        });
        XDialogUtils.setSystemDialog(getDialog(), 2008);
        return this.mXDialog.getContentView();
    }

    private void initViews(View view) {
        this.mAgreementTv = (XTextView) view.findViewById(R.id.bind_map_dialog_agreement);
        this.mAgreementTv.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.views.dialog.XBindAmapDialog.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (XBindAmapDialog.this.mOpenProtocolClick != null) {
                    XBindAmapDialog.this.mOpenProtocolClick.onClick(null);
                }
            }
        });
    }

    public void setCancelOnClickListener(View.OnClickListener onClickListener) {
        this.mCancelOnClickListener = onClickListener;
    }

    public void setOkOnClickListener(View.OnClickListener onClickListener) {
        this.mOkOnClickListener = onClickListener;
    }

    public void openProtocolView(View.OnClickListener onClickListener) {
        this.mOpenProtocolClick = onClickListener;
    }

    public void onSuccessBindAMap() {
        if (L.ENABLE) {
            L.d(TAG, "bindmap onSuccessBindAMap");
        }
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.views.dialog.XBindAmapDialog.5
            @Override // java.lang.Runnable
            public void run() {
                XToast.showShort((int) R.string.bind_amap_success_msg);
                if (XBindAmapDialog.this.mLoadingDialog != null) {
                    XBindAmapDialog.this.mLoadingDialog.dismiss();
                }
                XBindAmapDialog.this.dismiss();
            }
        });
    }

    public void onFailBindAMap() {
        if (L.ENABLE) {
            L.d(TAG, "bindmap onFailBindAMap");
        }
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.views.dialog.XBindAmapDialog.6
            @Override // java.lang.Runnable
            public void run() {
                if (XBindAmapDialog.this.mLoadingDialog != null) {
                    XBindAmapDialog.this.mLoadingDialog.dismiss();
                }
                XToast.showShort((int) R.string.bind_amap_fail_msg);
                XBindAmapDialog.this.dismiss();
            }
        });
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (getDialog() == null || getDialog().getWindow() == null) {
            return;
        }
        XThemeManager.setWindowBackgroundResource(configuration, getDialog().getWindow(), R.drawable.x_bg_dialog);
    }

    public void setLoadingDialog(Dialog dialog) {
        this.mLoadingDialog = dialog;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        OnXBindAmapDialogListener onXBindAmapDialogListener = this.mListener;
        if (onXBindAmapDialogListener != null) {
            onXBindAmapDialogListener.onXBindAmapDialogShow(this.mXDialog);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        OnXBindAmapDialogListener onXBindAmapDialogListener = this.mListener;
        if (onXBindAmapDialogListener != null) {
            onXBindAmapDialogListener.onXBindAmapDialogDismiss(this.mXDialog);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        setXBindAmapDialogListener(null);
    }
}
