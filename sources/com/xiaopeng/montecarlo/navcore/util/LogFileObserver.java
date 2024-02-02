package com.xiaopeng.montecarlo.navcore.util;

import android.os.FileObserver;
import androidx.annotation.Nullable;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.ioutil.FileUtil;
import java.io.File;
/* loaded from: classes2.dex */
public class LogFileObserver extends FileObserver {
    private static final L.Tag TAG = new L.Tag("LogFileObserver");
    private String mPath;

    public LogFileObserver(String str) {
        super(str, 256);
        this.mPath = str;
        if (L.ENABLE) {
            L.d(TAG, str);
        }
    }

    @Override // android.os.FileObserver
    public void onEvent(int i, @Nullable String str) {
        String str2 = this.mPath + File.separatorChar + str;
        if ((i & 256) != 0) {
            L.i(TAG, i + " " + str2);
            FileUtil.setFileWith755Permission(new File(str2));
            UserLogControl.INSTANCE.outputFileList(str2);
        }
    }
}
