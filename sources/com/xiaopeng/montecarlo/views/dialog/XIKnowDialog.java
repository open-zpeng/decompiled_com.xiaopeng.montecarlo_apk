package com.xiaopeng.montecarlo.views.dialog;

import android.content.Context;
import android.view.View;
import com.xiaopeng.lib.bughunter.anr.UILooperObserver;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.timer.XCountDownTimer;
import com.xiaopeng.montecarlo.util.Utils;
/* loaded from: classes3.dex */
public class XIKnowDialog extends XTextDialog implements XCountDownTimer.ITimerCallback {
    private String mButtonText;
    private XCountDownTimer mDialogTimer;

    public XIKnowDialog(Context context, String str) {
        super(context);
        this.mDialogTimer = new XCountDownTimer(UILooperObserver.ANR_TRIGGER_TIME, this);
        setTitle(R.string.dialog_title_tips);
        setOkButtonText(R.string.dialog_i_know_btn_name);
        setContentText(str);
        showCancelButton(false);
        showClose(false);
        setOkButtonClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.views.dialog.XIKnowDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (XIKnowDialog.this.mDialogTimer != null) {
                    XIKnowDialog.this.mDialogTimer.stop();
                }
                XIKnowDialog.this.dismiss();
            }
        });
        this.mButtonText = ContextUtils.getContext().getString(R.string.dialog_i_know_btn_name);
    }

    @Override // com.xiaopeng.xui.app.XDialog
    public void show() {
        super.show();
        this.mDialogTimer.start();
    }

    @Override // com.xiaopeng.montecarlo.root.util.timer.XCountDownTimer.ITimerCallback
    public void onTick(long j) {
        if (isShowing()) {
            setOkButtonText(Utils.getTimeOutText((int) j, this.mButtonText));
        }
    }

    @Override // com.xiaopeng.montecarlo.root.util.timer.XCountDownTimer.ITimerCallback
    public void onTimeOut() {
        dismiss();
    }

    @Override // com.xiaopeng.xui.app.XDialog
    public void dismiss() {
        super.dismiss();
        this.mDialogTimer.stop();
    }
}
