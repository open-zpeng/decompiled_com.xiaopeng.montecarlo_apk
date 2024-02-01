package com.autonavi.gbl.common.path;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.model.CalcRouteResultData;
import com.autonavi.gbl.common.path.impl.DrivePathDecoderImpl;
import com.autonavi.gbl.common.path.option.PathInfo;
import com.autonavi.gbl.util.model.BinaryStream;
import java.util.ArrayList;
@IntfAuto(target = DrivePathDecoderImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class DrivePathDecoder {
    private static String PACKAGE = ReflexTool.PN(DrivePathDecoder.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private DrivePathDecoderImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected void clean() {
    }

    protected DrivePathDecoder(long j, boolean z) {
        this(new DrivePathDecoderImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(DrivePathDecoder.class, this, this.mControl);
        }
    }

    public DrivePathDecoder() {
        this(new DrivePathDecoderImpl());
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(DrivePathDecoder.class, this, this.mControl);
        }
    }

    public DrivePathDecoder(DrivePathDecoderImpl drivePathDecoderImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(drivePathDecoderImpl);
    }

    private void $constructor(DrivePathDecoderImpl drivePathDecoderImpl) {
        if (drivePathDecoderImpl != null) {
            this.mControl = drivePathDecoderImpl;
            this.mTargetId = String.format("DrivePathDecoder_%s_%d", String.valueOf(DrivePathDecoderImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected DrivePathDecoderImpl getControl() {
        return this.mControl;
    }

    public static ArrayList<PathInfo> decodeRouteData(byte[] bArr) {
        if (bArr != null && bArr.length == 0) {
            bArr = null;
        }
        return DrivePathDecoderImpl.decodeRouteData(bArr);
    }

    public static ArrayList<PathInfo> decodeMultiRouteData(CalcRouteResultData calcRouteResultData) {
        return DrivePathDecoderImpl.decodeMultiRouteData(calcRouteResultData);
    }

    public static ArrayList<PathInfo> assembleGuideDataToPath(BinaryStream binaryStream) {
        return DrivePathDecoderImpl.assembleGuideDataToPath(binaryStream);
    }

    public static ArrayList<PathInfo> assembleOddDataToPath(BinaryStream binaryStream) {
        return DrivePathDecoderImpl.assembleOddDataToPath(binaryStream);
    }

    public static ArrayList<PathInfo> decodePBDrivePlan(BinaryStream binaryStream) {
        return DrivePathDecoderImpl.decodePBDrivePlan(binaryStream);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
    }

    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    public synchronized void delete() {
        if (!this.mHasDestroy) {
            onDestroy();
        }
        if (this.mTypeHelper != null) {
            TypeHelper typeHelper = this.mTypeHelper;
            TypeHelper.unbindAllTarget(PACKAGE, this);
        }
        if (this.mControl != null) {
            ReflexTool.invokeDeclMethodSafe(this.mControl, RequestParameters.SUBRESOURCE_DELETE, null, null);
            this.mControl = null;
        }
        unbind();
    }
}
