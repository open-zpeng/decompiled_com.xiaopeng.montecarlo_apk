package com.autonavi.gbl.card;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.card.impl.ICardServiceImpl;
import com.autonavi.gbl.card.impl.ITextureManagerImpl;
import com.autonavi.gbl.card.model.CardInitParam;
import com.autonavi.gbl.map.MapView;
import com.autonavi.gbl.map.impl.IMapViewImpl;
import com.autonavi.gbl.map.model.MapEngineID;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.util.model.ServiceInitStatus;
import java.lang.reflect.Method;
@IntfAuto(target = ICardServiceImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class CardService implements IService {
    private static String PACKAGE = ReflexTool.PN(CardService.class);
    private ICardServiceImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected void clean() {
    }

    protected CardService(long j, boolean z) {
        this((ICardServiceImpl) ReflexTool.invokeDeclConstructorSafe(ICardServiceImpl.class, new Class[]{Long.TYPE, Boolean.TYPE}, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(CardService.class, this, this.mControl);
        }
    }

    public CardService(ICardServiceImpl iCardServiceImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iCardServiceImpl);
    }

    private void $constructor(ICardServiceImpl iCardServiceImpl) {
        if (iCardServiceImpl != null) {
            this.mControl = iCardServiceImpl;
            this.mTargetId = String.format("CardService_%s_%d", String.valueOf(ICardServiceImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected ICardServiceImpl getControl() {
        return this.mControl;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public boolean isRecycled() {
        ICardServiceImpl iCardServiceImpl = this.mControl;
        if (iCardServiceImpl != null) {
            return iCardServiceImpl.isRecycled();
        }
        return true;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public long getPtr() {
        ICardServiceImpl iCardServiceImpl = this.mControl;
        if (iCardServiceImpl != null) {
            return iCardServiceImpl.getPtr();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
        ICardServiceImpl iCardServiceImpl = this.mControl;
        if (iCardServiceImpl != null) {
            iCardServiceImpl.onCreate();
        }
    }

    public void unInit() {
        ICardServiceImpl iCardServiceImpl = this.mControl;
        if (iCardServiceImpl != null) {
            iCardServiceImpl.unInit();
        }
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    @ServiceInitStatus.ServiceInitStatus1
    public int isInit() {
        ICardServiceImpl iCardServiceImpl = this.mControl;
        if (iCardServiceImpl != null) {
            return iCardServiceImpl.isInit();
        }
        return Integer.MIN_VALUE;
    }

    public void setDebugMode(boolean z, @MapEngineID.MapEngineID1 int i) {
        ICardServiceImpl iCardServiceImpl = this.mControl;
        if (iCardServiceImpl != null) {
            iCardServiceImpl.setDebugMode(z, i);
        }
    }

    public void setDebugMode(boolean z) {
        ICardServiceImpl iCardServiceImpl = this.mControl;
        if (iCardServiceImpl != null) {
            iCardServiceImpl.setDebugMode(z);
        }
    }

    public void setDebugFileSaveMode(boolean z, String str) {
        ICardServiceImpl iCardServiceImpl = this.mControl;
        if (iCardServiceImpl != null) {
            iCardServiceImpl.setDebugFileSaveMode(z, str);
        }
    }

    public TextureManager getTextureManager(MapView mapView, CardInitParam cardInitParam) {
        ITextureManagerImpl textureManager;
        TypeHelper typeHelper;
        TypeHelper typeHelper2;
        try {
            Method method = CardService.class.getMethod("getTextureManager", MapView.class, CardInitParam.class);
            IMapViewImpl iMapViewImpl = (mapView == null || (typeHelper2 = this.mTypeHelper) == null) ? null : (IMapViewImpl) typeHelper2.transfer(method, 0, mapView);
            ICardServiceImpl iCardServiceImpl = this.mControl;
            if (iCardServiceImpl == null || (textureManager = iCardServiceImpl.getTextureManager(iMapViewImpl, cardInitParam)) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (TextureManager) typeHelper.transfer(method, -1, (Object) textureManager, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public void destroyTextureManager(TextureManager textureManager) {
        TypeHelper typeHelper;
        try {
            Method method = CardService.class.getMethod("destroyTextureManager", TextureManager.class);
            ITextureManagerImpl iTextureManagerImpl = null;
            if (textureManager != null && (typeHelper = this.mTypeHelper) != null) {
                iTextureManagerImpl = (ITextureManagerImpl) typeHelper.transfer(method, 0, textureManager);
            }
            ICardServiceImpl iCardServiceImpl = this.mControl;
            if (iCardServiceImpl != null) {
                iCardServiceImpl.destroyTextureManager(iTextureManagerImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public boolean setStrategyType(@MapEngineID.MapEngineID1 int i, int i2) {
        ICardServiceImpl iCardServiceImpl = this.mControl;
        if (iCardServiceImpl != null) {
            return iCardServiceImpl.setStrategyType(i, i2);
        }
        return false;
    }

    public void enableOperateTexture(@MapEngineID.MapEngineID1 int i, boolean z) {
        ICardServiceImpl iCardServiceImpl = this.mControl;
        if (iCardServiceImpl != null) {
            iCardServiceImpl.enableOperateTexture(i, z);
        }
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    protected synchronized void delete() {
        if (!this.mHasDestroy) {
            onDestroy();
        }
        if (this.mTypeHelper != null) {
            TypeHelper typeHelper = this.mTypeHelper;
            TypeHelper.unbindAllTarget(PACKAGE, this);
        }
        if (this.mControl != null) {
            this.mControl = null;
        }
        unbind();
    }
}
