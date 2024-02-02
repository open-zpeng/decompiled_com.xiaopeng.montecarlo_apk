package com.xiaopeng.montecarlo.views.dialog;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.xui.widget.XTextFields;
import com.xiaopeng.xui.widget.XTextView;
/* loaded from: classes3.dex */
public class XManualActivateDialog extends XBaseDialog {
    private static final int DIAL_NUM_END = 27;
    private static final int DIAL_NUM_START = 17;
    private static final L.Tag TAG = new L.Tag("XManualActivateDialog");
    private XTextView mActivateResult;
    private XTextView mActivateTips;
    private XTextView mActivateTipsTitle;
    private XTextView mActivateUuid;
    private XTextView mActivateUuidTitle;
    private Editable mLoginCode;
    private XTextFields mLoginCodeInput;
    private TextWatcher mLoginCodeInputListener;
    private View mRootView;
    private Editable mUserCode;
    private XTextFields mUserCodeInput;
    private TextView.OnEditorActionListener mUserCodeInputActionListner;
    private TextWatcher mUserCodeInputListener;

    public XManualActivateDialog(Context context) {
        super(context, -1, R.style.dialog_style, false, false);
        this.mUserCodeInputListener = new TextWatcher() { // from class: com.xiaopeng.montecarlo.views.dialog.XManualActivateDialog.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                XManualActivateDialog.this.mUserCode = editable;
                XManualActivateDialog.this.updateOkButtonStatus();
            }
        };
        this.mLoginCodeInputListener = new TextWatcher() { // from class: com.xiaopeng.montecarlo.views.dialog.XManualActivateDialog.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                XManualActivateDialog.this.mLoginCode = editable;
                XManualActivateDialog.this.updateOkButtonStatus();
            }
        };
        this.mUserCodeInputActionListner = new TextView.OnEditorActionListener() { // from class: com.xiaopeng.montecarlo.views.dialog.XManualActivateDialog.3
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (5 == i) {
                    XManualActivateDialog.this.mLoginCodeInput.requestFocus();
                    return true;
                }
                return false;
            }
        };
        initCustomContentView();
        setContentView(this.mRootView, true);
        this.mUserCodeInput.addTextChangedListener(this.mUserCodeInputListener);
        this.mLoginCodeInput.addTextChangedListener(this.mLoginCodeInputListener);
        this.mLoginCodeInput.setErrorEnable(false);
        if (this.mUserCodeInput.getEditText() != null) {
            this.mUserCodeInput.getEditText().setOnEditorActionListener(this.mUserCodeInputActionListner);
        }
    }

    @Override // com.xiaopeng.montecarlo.views.dialog.XBaseDialog
    public void initDialog() {
        super.initDialog();
        showCancelButton(false);
        setCanceledOnTouchOutside(false);
        setPositiveButtonInterceptDismiss(true);
        showClose(false);
        setGravity(17);
    }

    public View initCustomContentView() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(ContextUtils.getContext()).inflate(R.layout.layout_manual_activate, (ViewGroup) null);
            this.mUserCodeInput = (XTextFields) this.mRootView.findViewById(R.id.manual_activate_usercode_input);
            this.mLoginCodeInput = (XTextFields) this.mRootView.findViewById(R.id.manual_activate_logincode_input);
            this.mActivateResult = (XTextView) this.mRootView.findViewById(R.id.manual_activate_result);
            this.mActivateUuidTitle = (XTextView) this.mRootView.findViewById(R.id.manual_activate_uuid_title);
            this.mActivateUuid = (XTextView) this.mRootView.findViewById(R.id.manual_activate_uuid);
            this.mActivateTipsTitle = (XTextView) this.mRootView.findViewById(R.id.manual_activate_tips_title);
            this.mActivateTips = (XTextView) this.mRootView.findViewById(R.id.manual_activate_tips);
        }
        return this.mRootView;
    }

    @Override // com.xiaopeng.montecarlo.views.dialog.XBaseDialog
    public void setIsNight(boolean z) {
        super.setIsNight(z);
        L.Tag tag = TAG;
        L.i(tag, "setIsNight: night = " + z);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(ContextUtils.getContext().getString(R.string.activate_manual_tips));
        spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.xiaopeng.montecarlo.views.dialog.XManualActivateDialog.4
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                String charSequence = XManualActivateDialog.this.mActivateTips.getText().subSequence(17, 27).toString();
                L.Tag tag2 = XManualActivateDialog.TAG;
                L.i(tag2, ">>> manual activate dial num click = " + charSequence);
                Intent intent = new Intent("android.intent.action.CALL", Uri.parse("tel:" + charSequence));
                intent.setFlags(268435456);
                ContextUtils.startExternalActivity(intent);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setUnderlineText(false);
            }
        }, 17, 27, 33);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextUtils.getColor(R.color.primary_forward_color_normal)), 17, 27, 33);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextUtils.getColor(R.color.main_title_text_color)), 0, 17, 33);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextUtils.getColor(R.color.main_title_text_color)), 27, spannableStringBuilder.length(), 33);
        this.mActivateTips.setMovementMethod(LinkMovementMethod.getInstance());
        this.mActivateTips.setText(spannableStringBuilder);
        updateOkButtonStatus();
    }

    @Override // com.xiaopeng.xui.app.XDialog
    public void dismiss() {
        super.dismiss();
        hideIme();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateOkButtonStatus() {
        if (TextUtils.isEmpty(this.mLoginCode) || TextUtils.isEmpty(this.mUserCode)) {
            setOkButtonEnable(false);
        } else {
            setOkButtonEnable(true);
        }
    }

    private void hideIme() {
        InputMethodManager inputMethodManager = (InputMethodManager) ContextUtils.getContext().getSystemService("input_method");
        if (this.mUserCodeInput.hasFocus()) {
            inputMethodManager.hideSoftInputFromWindow(this.mUserCodeInput.getWindowToken(), 0);
        } else if (this.mLoginCodeInput.hasFocus()) {
            inputMethodManager.hideSoftInputFromWindow(this.mLoginCodeInput.getWindowToken(), 0);
        }
    }

    public void setManualActivateResult(String str) {
        if (this.mActivateResult != null) {
            if (TextUtils.isEmpty(str)) {
                this.mActivateResult.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mActivateUuidTitle.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.addRule(3, R.id.manual_activate_logincode_input);
                    this.mActivateUuidTitle.setLayoutParams(layoutParams);
                }
            } else {
                this.mActivateResult.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mActivateUuidTitle.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.addRule(3, R.id.manual_activate_result);
                    this.mActivateUuidTitle.setLayoutParams(layoutParams2);
                }
            }
            this.mActivateResult.setText(str);
        }
    }

    public void setManualActivateResultTextColor(int i) {
        XTextView xTextView = this.mActivateResult;
        if (xTextView != null) {
            xTextView.setTextColor(i);
        }
    }

    public void setManualActivateUuid(String str) {
        XTextView xTextView = this.mActivateUuid;
        if (xTextView != null) {
            xTextView.setText(str);
        }
    }

    public void setManualActivateTips(String str) {
        XTextView xTextView = this.mActivateTips;
        if (xTextView != null) {
            xTextView.setText(str);
        }
    }

    public String getUserCode() {
        Editable editable = this.mUserCode;
        return editable != null ? editable.toString() : "";
    }

    public String getLoginCode() {
        Editable editable = this.mLoginCode;
        return editable != null ? editable.toString() : "";
    }
}
