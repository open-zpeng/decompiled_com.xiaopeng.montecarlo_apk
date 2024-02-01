package com.xiaopeng.montecarlo.util;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.root.util.timer.XCountDownTimer;
import com.xiaopeng.montecarlo.views.dialog.XTextDialog;
/* loaded from: classes3.dex */
public class DialogUtils {
    private static final long TIMEOUT_MILLIS = 15000;

    public static void showUnbindDialog(final Context context) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.util.DialogUtils.1
            @Override // java.lang.Runnable
            public void run() {
                final XTextDialog xTextDialog = new XTextDialog(context);
                final XCountDownTimer xCountDownTimer = new XCountDownTimer(DialogUtils.TIMEOUT_MILLIS, new XCountDownTimer.ITimerCallback() { // from class: com.xiaopeng.montecarlo.util.DialogUtils.1.1
                    @Override // com.xiaopeng.montecarlo.root.util.timer.XCountDownTimer.ITimerCallback
                    public void onTick(long j) {
                        xTextDialog.setOkButtonText(context.getString(R.string.i_know_btn_name_seconds, Long.valueOf(j)));
                    }

                    @Override // com.xiaopeng.montecarlo.root.util.timer.XCountDownTimer.ITimerCallback
                    public void onTimeOut() {
                        xTextDialog.dismiss();
                    }
                });
                xTextDialog.setTitle(R.string.dialog_title_tips);
                xTextDialog.setOkButtonText(R.string.dialog_i_know_btn_name);
                xTextDialog.setContentText(R.string.dialog_unbinded_content);
                xTextDialog.showClose(false);
                xTextDialog.showCancelButton(false);
                xTextDialog.setOkButtonClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.util.DialogUtils.1.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        xTextDialog.dismiss();
                    }
                });
                xTextDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.xiaopeng.montecarlo.util.DialogUtils.1.3
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        xCountDownTimer.stop();
                    }
                });
                xTextDialog.show();
                xCountDownTimer.start();
            }
        });
    }
}
