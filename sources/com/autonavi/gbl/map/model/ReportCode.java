package com.autonavi.gbl.map.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class ReportCode {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int ReportCodeAddressNull = 11;
    public static final int ReportCodeDecoderError = 10001;
    public static final int ReportCodeFIleFlushError = 24;
    public static final int ReportCodeFailCloseDb = 1002;
    public static final int ReportCodeFailCondition = 1001;
    public static final int ReportCodeFailOpenDb = 1003;
    public static final int ReportCodeFailPixelShader = 1006;
    public static final int ReportCodeFailUpdateDb = 1004;
    public static final int ReportCodeFailVertexShader = 1005;
    public static final int ReportCodeFileError = 27;
    public static final int ReportCodeFileMakeDirError = 28;
    public static final int ReportCodeFileNotExist = 21;
    public static final int ReportCodeFileReadError = 22;
    public static final int ReportCodeFileRenameError = 26;
    public static final int ReportCodeFileSeekError = 25;
    public static final int ReportCodeFileWriteError = 23;
    public static final int ReportCodeNoMemory = 1;
    public static final int ReportCodeOutMemory = 2;
    public static final int ReportCodeStringOutRange = 41;
    public static final int ReportCodeTextureDataModify = 52;
    public static final int ReportCodeTextureIdModify = 51;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface ReportCode1 {
    }
}
