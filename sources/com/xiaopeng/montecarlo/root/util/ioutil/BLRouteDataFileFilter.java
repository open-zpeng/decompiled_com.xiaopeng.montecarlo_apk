package com.xiaopeng.montecarlo.root.util.ioutil;

import java.io.File;
import java.io.FileFilter;
/* loaded from: classes3.dex */
public class BLRouteDataFileFilter implements FileFilter {
    @Override // java.io.FileFilter
    public boolean accept(File file) {
        return !file.isDirectory() && file.getName().endsWith(".dat");
    }
}
