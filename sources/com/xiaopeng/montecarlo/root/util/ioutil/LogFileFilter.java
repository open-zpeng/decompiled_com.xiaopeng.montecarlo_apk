package com.xiaopeng.montecarlo.root.util.ioutil;

import com.xiaopeng.montecarlo.root.util.RootUtil;
import java.io.File;
import java.io.FileFilter;
/* loaded from: classes2.dex */
public class LogFileFilter implements FileFilter {
    @Override // java.io.FileFilter
    public boolean accept(File file) {
        return file.getPath().contains(RootUtil.NAVI_LOG_DIR_CKR_NAME) || !file.getName().endsWith(".dat");
    }
}
