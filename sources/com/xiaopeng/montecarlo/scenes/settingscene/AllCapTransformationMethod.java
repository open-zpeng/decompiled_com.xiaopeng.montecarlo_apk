package com.xiaopeng.montecarlo.scenes.settingscene;

import android.text.method.ReplacementTransformationMethod;
/* loaded from: classes3.dex */
public class AllCapTransformationMethod extends ReplacementTransformationMethod {
    private boolean mAllUpper;
    private char[] mLower = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private char[] mUpper = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public AllCapTransformationMethod(boolean z) {
        this.mAllUpper = false;
        this.mAllUpper = z;
    }

    @Override // android.text.method.ReplacementTransformationMethod
    protected char[] getOriginal() {
        if (this.mAllUpper) {
            return this.mLower;
        }
        return this.mUpper;
    }

    @Override // android.text.method.ReplacementTransformationMethod
    protected char[] getReplacement() {
        if (this.mAllUpper) {
            return this.mUpper;
        }
        return this.mLower;
    }
}
