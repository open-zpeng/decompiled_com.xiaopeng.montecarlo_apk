package com.xiaopeng.montecarlo.service.navi;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.service.navi.binder.NaviServiceManager;
import com.xiaopeng.montecarlo.service.navi.resultsender.BroadcastResultSender;
import com.xiaopeng.montecarlo.service.navi.resultsender.CallbackResultSender;
import com.xiaopeng.montecarlo.service.navi.resultsender.IResultSender;
import com.xiaopeng.montecarlo.service.navi.resultsender.IpcResultSender;
import com.xiaopeng.montecarlo.service.navi.resultsender.LogResultSender;
import com.xiaopeng.montecarlo.service.navi.type.Request;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class LocalNaviService {
    private static LocalNaviService sInstance = new LocalNaviService();
    private IActivityLauncher mActivityLauncher;
    private BroadcastResultSender mBroadcastResultSender;
    private Application mContent;
    private IpcResultSender mIpcResultSender;
    private boolean mIsInited = false;
    private NaviServiceManager mNaviServiceManager;
    private ParserManager mParserManager;

    private LocalNaviService() {
    }

    public static LocalNaviService getInstance() {
        return sInstance;
    }

    private void init(@NonNull Context context) {
        if (this.mIsInited) {
            return;
        }
        this.mContent = (Application) context.getApplicationContext();
        this.mBroadcastResultSender = new BroadcastResultSender();
        this.mIpcResultSender = new IpcResultSender();
        this.mActivityLauncher = new ActivityLauncher(this.mContent);
        this.mParserManager = new ParserManager();
        this.mParserManager.init(this.mContent);
        this.mNaviServiceManager = new NaviServiceManager();
        this.mNaviServiceManager.onCreate(this.mContent);
        this.mIsInited = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onHandleRequest(@NonNull Context context, @NonNull Request request, @Nullable RemoteCallback remoteCallback, @NonNull Handler handler) {
        IResultSender iResultSender;
        IResultSender callbackResultSender;
        init(context);
        INaviParser parser = this.mParserManager.getParser(request.getWhat());
        ArrayList<Integer> findSupportBackType = this.mParserManager.findSupportBackType(request.getWhat());
        if (parser == null || findSupportBackType == null) {
            return;
        }
        int back_type = request.getBack_type();
        if (!findSupportBackType.contains(Integer.valueOf(back_type))) {
            back_type = findSupportBackType.get(0).intValue();
        }
        if (remoteCallback != null && back_type != 1) {
            remoteCallback.kill();
        }
        try {
            if (back_type == 2) {
                iResultSender = this.mBroadcastResultSender;
            } else if (back_type == 3) {
                iResultSender = new LogResultSender();
            } else if (back_type == 1) {
                if (remoteCallback == null) {
                    return;
                }
                callbackResultSender = new CallbackResultSender(remoteCallback, request, handler);
                parser.onHandleEvent(context, request.getContent(), new RequestEventCallback(this.mContent, request, callbackResultSender, this.mActivityLauncher, handler));
                return;
            } else if (back_type == 0) {
                iResultSender = this.mIpcResultSender;
            } else {
                iResultSender = this.mBroadcastResultSender;
            }
            parser.onHandleEvent(context, request.getContent(), new RequestEventCallback(this.mContent, request, callbackResultSender, this.mActivityLauncher, handler));
            return;
        } catch (Exception e) {
            L.Tag tag = NaviService.TAG;
            L.e(tag, "onHandleEvent Exception:" + e.toString());
            return;
        }
        callbackResultSender = iResultSender;
    }

    public IBinder getService(@NonNull Context context, String str) {
        init(context);
        return this.mNaviServiceManager.getService(str);
    }
}
