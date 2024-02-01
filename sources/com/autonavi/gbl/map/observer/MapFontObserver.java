package com.autonavi.gbl.map.observer;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.model.FontMetrics;
import com.autonavi.gbl.map.model.FontMetricsRequestParam;
import com.autonavi.gbl.map.model.GlyphMetrics;
import com.autonavi.gbl.map.model.GlyphRaster;
import com.autonavi.gbl.map.model.GlyphRequestParam;
import com.autonavi.gbl.map.observer.impl.IMapFontObserverImpl;
import com.autonavi.gbl.map.router.MapFontObserverRouter;
@IntfAuto(target = MapFontObserverRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes2.dex */
public class MapFontObserver implements IMapFontObserver {
    private static String PACKAGE = ReflexTool.PN(MapFontObserver.class);
    private boolean mHasDestroy;
    private IMapFontObserverImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected void clean() {
    }

    protected MapFontObserver(long j, boolean z) {
        this(new MapFontObserverRouter("MapFontObserver", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IMapFontObserver.class}, new Object[]{this});
    }

    public MapFontObserver() {
        this(new MapFontObserverRouter("MapFontObserver", null));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IMapFontObserver.class}, new Object[]{this});
    }

    public MapFontObserver(IMapFontObserverImpl iMapFontObserverImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(iMapFontObserverImpl);
    }

    private void $constructor(IMapFontObserverImpl iMapFontObserverImpl) {
        if (iMapFontObserverImpl != null) {
            this.mService = iMapFontObserverImpl;
            this.mTargetId = String.format("MapFontObserver_%s_%d", String.valueOf(IMapFontObserverImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IMapFontObserverImpl getService() {
        return this.mService;
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
        if (this.mService != null) {
            if (this.mTypeHelper != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                TypeHelper.unbindAllTarget(ReflexTool.PN(this.mService.getClass()), this.mService);
            }
            ReflexTool.invokeDeclMethodSafe(this.mService, RequestParameters.SUBRESOURCE_DELETE, null, null);
            this.mService = null;
        }
        unbind();
    }

    @Override // com.autonavi.gbl.map.observer.IMapFontObserver
    public GlyphMetrics getGlyphMetrics(GlyphRequestParam glyphRequestParam) {
        GlyphMetrics glyphMetrics = new GlyphMetrics();
        if (Boolean.valueOf(getGlyphMetrics(glyphRequestParam, glyphMetrics)).booleanValue()) {
            return glyphMetrics;
        }
        return null;
    }

    private boolean getGlyphMetrics(GlyphRequestParam glyphRequestParam, GlyphMetrics glyphMetrics) {
        IMapFontObserverImpl iMapFontObserverImpl = this.mService;
        if (iMapFontObserverImpl == null || iMapFontObserverImpl.isCMemOwn()) {
            return false;
        }
        return this.mService.$explicit_getGlyphMetrics(glyphRequestParam, glyphMetrics);
    }

    @Override // com.autonavi.gbl.map.observer.IMapFontObserver
    public GlyphRaster getGlyphRaster(GlyphRequestParam glyphRequestParam) {
        GlyphRaster glyphRaster = new GlyphRaster();
        if (Boolean.valueOf(getGlyphRaster(glyphRequestParam, glyphRaster)).booleanValue()) {
            return glyphRaster;
        }
        return null;
    }

    private boolean getGlyphRaster(GlyphRequestParam glyphRequestParam, GlyphRaster glyphRaster) {
        IMapFontObserverImpl iMapFontObserverImpl = this.mService;
        if (iMapFontObserverImpl == null || iMapFontObserverImpl.isCMemOwn()) {
            return false;
        }
        return this.mService.$explicit_getGlyphRaster(glyphRequestParam, glyphRaster);
    }

    @Override // com.autonavi.gbl.map.observer.IMapFontObserver
    public FontMetrics getFontMetrics(FontMetricsRequestParam fontMetricsRequestParam) {
        FontMetrics fontMetrics = new FontMetrics();
        if (Boolean.valueOf(getFontMetrics(fontMetricsRequestParam, fontMetrics)).booleanValue()) {
            return fontMetrics;
        }
        return null;
    }

    private boolean getFontMetrics(FontMetricsRequestParam fontMetricsRequestParam, FontMetrics fontMetrics) {
        IMapFontObserverImpl iMapFontObserverImpl = this.mService;
        if (iMapFontObserverImpl == null || iMapFontObserverImpl.isCMemOwn()) {
            return false;
        }
        return this.mService.$explicit_getFontMetrics(fontMetricsRequestParam, fontMetrics);
    }
}
