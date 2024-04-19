package com.autonavi.gbl.common.path;

import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.model.CalcRouteResultData;
import com.autonavi.gbl.common.path.impl.DrivePathDecoderImpl;
import com.autonavi.gbl.common.path.option.PathInfo;
import com.autonavi.gbl.common.path.option.impl.PathInfoImpl;
import java.lang.reflect.Method;
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
        try {
            Method method = DrivePathDecoder.class.getMethod("decodeRouteData", byte[].class);
            ArrayList<PathInfoImpl> decodeRouteData = DrivePathDecoderImpl.decodeRouteData(bArr);
            if (decodeRouteData != null) {
                TypeHelper typeHelper = gTypeHelper;
                r0 = typeHelper != null ? (ArrayList) typeHelper.transfer(method, -1, (ArrayList) decodeRouteData, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.common.path.DrivePathDecoder.1
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public static ArrayList<PathInfo> decodeMultiRouteData(CalcRouteResultData calcRouteResultData) {
        try {
            Method method = DrivePathDecoder.class.getMethod("decodeMultiRouteData", CalcRouteResultData.class);
            ArrayList<PathInfoImpl> decodeMultiRouteData = DrivePathDecoderImpl.decodeMultiRouteData(calcRouteResultData);
            if (decodeMultiRouteData != null) {
                TypeHelper typeHelper = gTypeHelper;
                r0 = typeHelper != null ? (ArrayList) typeHelper.transfer(method, -1, (ArrayList) decodeMultiRouteData, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.common.path.DrivePathDecoder.2
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.common.path.DrivePathDecoder.3
        });
        objArr[1] = String.valueOf(this.mTypeHelper != null);
        DebugTool.d("%s: mTypeHelper=%s", objArr);
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

    protected void clean() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.common.path.DrivePathDecoder.4
        }));
    }

    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.common.path.DrivePathDecoder.5
        }));
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
