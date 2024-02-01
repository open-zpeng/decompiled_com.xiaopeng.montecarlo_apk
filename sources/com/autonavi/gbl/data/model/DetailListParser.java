package com.autonavi.gbl.data.model;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.data.model.impl.DetailListParserImpl;
@IntfAuto(target = DetailListParserImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class DetailListParser {
    private static String PACKAGE = ReflexTool.PN(DetailListParser.class);
    private DetailListParserImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected void clean() {
    }

    protected DetailListParser(long j, boolean z) {
        this(new DetailListParserImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(DetailListParser.class, this, this.mControl);
        }
    }

    public DetailListParser(DetailListParserImpl detailListParserImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(detailListParserImpl);
    }

    private void $constructor(DetailListParserImpl detailListParserImpl) {
        if (detailListParserImpl != null) {
            this.mControl = detailListParserImpl;
            this.mTargetId = String.format("DetailListParser_%s_%d", String.valueOf(DetailListParserImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected DetailListParserImpl getControl() {
        return this.mControl;
    }

    public int getEhpValue() {
        DetailListParserImpl detailListParserImpl = this.mControl;
        if (detailListParserImpl != null) {
            return detailListParserImpl.getEhpValue();
        }
        return 0;
    }

    public int[] getAdcodeList() {
        DetailListParserImpl detailListParserImpl = this.mControl;
        if (detailListParserImpl != null) {
            return detailListParserImpl.getAdcodeList();
        }
        return null;
    }

    public String[] getVoiceList() {
        DetailListParserImpl detailListParserImpl = this.mControl;
        if (detailListParserImpl != null) {
            return detailListParserImpl.getVoiceList();
        }
        return null;
    }

    public String getMapDataVersion() {
        DetailListParserImpl detailListParserImpl = this.mControl;
        if (detailListParserImpl != null) {
            return detailListParserImpl.getMapDataVersion();
        }
        return null;
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
