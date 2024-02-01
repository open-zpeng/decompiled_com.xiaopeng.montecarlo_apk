package com.autonavi.gbl.consis;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.consis.impl.IChannelMsgSyncControllerImpl;
import com.autonavi.gbl.consis.impl.IChannelServiceImpl;
import com.autonavi.gbl.consis.model.ChannelInitParam;
import com.autonavi.gbl.consis.model.CustomChannelMessageParam;
import com.autonavi.gbl.consis.observer.ChannelProxyAdapter;
import com.autonavi.gbl.consis.observer.IChannelMessageObserver;
import com.autonavi.gbl.consis.observer.IChannelObserver;
import com.autonavi.gbl.consis.observer.IChannelProxyObserver;
import com.autonavi.gbl.consis.observer.IConsisMessageAdapter;
import com.autonavi.gbl.consis.observer.IConsisObserver;
import com.autonavi.gbl.consis.observer.impl.IChannelMessageObserverImpl;
import com.autonavi.gbl.consis.observer.impl.IChannelObserverImpl;
import com.autonavi.gbl.consis.observer.impl.IChannelProxyAdapterImpl;
import com.autonavi.gbl.consis.observer.impl.IChannelProxyObserverImpl;
import com.autonavi.gbl.consis.observer.impl.IConsisMessageAdapterImpl;
import com.autonavi.gbl.consis.observer.impl.IConsisObserverImpl;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.util.model.ServiceInitStatus;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
@IntfAuto(target = IChannelServiceImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class ChannelService implements IService {
    private static String PACKAGE = ReflexTool.PN(ChannelService.class);
    private IChannelServiceImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected ChannelService(long j, boolean z) {
        this((IChannelServiceImpl) ReflexTool.invokeDeclConstructorSafe(IChannelServiceImpl.class, new Class[]{Long.TYPE, Boolean.TYPE}, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(ChannelService.class, this, this.mControl);
        }
    }

    public ChannelService(IChannelServiceImpl iChannelServiceImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iChannelServiceImpl);
    }

    private void $constructor(IChannelServiceImpl iChannelServiceImpl) {
        if (iChannelServiceImpl != null) {
            this.mControl = iChannelServiceImpl;
            this.mTargetId = String.format("ChannelService_%s_%d", String.valueOf(IChannelServiceImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IChannelServiceImpl getControl() {
        return this.mControl;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public boolean isRecycled() {
        IChannelServiceImpl iChannelServiceImpl = this.mControl;
        if (iChannelServiceImpl != null) {
            return iChannelServiceImpl.isRecycled();
        }
        return true;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public long getPtr() {
        IChannelServiceImpl iChannelServiceImpl = this.mControl;
        if (iChannelServiceImpl != null) {
            return iChannelServiceImpl.getPtr();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
        IChannelServiceImpl iChannelServiceImpl = this.mControl;
        if (iChannelServiceImpl != null) {
            iChannelServiceImpl.onCreate();
        }
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    @ServiceInitStatus.ServiceInitStatus1
    public int isInit() {
        IChannelServiceImpl iChannelServiceImpl = this.mControl;
        if (iChannelServiceImpl != null) {
            return iChannelServiceImpl.isInit();
        }
        return Integer.MIN_VALUE;
    }

    public int init(ChannelInitParam channelInitParam) {
        IChannelServiceImpl iChannelServiceImpl = this.mControl;
        if (iChannelServiceImpl != null) {
            return iChannelServiceImpl.init(channelInitParam);
        }
        return 0;
    }

    public void unInit() {
        IChannelServiceImpl iChannelServiceImpl = this.mControl;
        if (iChannelServiceImpl != null) {
            iChannelServiceImpl.unInit();
        }
    }

    public int connectChannel(String str, int i) {
        IChannelServiceImpl iChannelServiceImpl = this.mControl;
        if (iChannelServiceImpl != null) {
            return iChannelServiceImpl.connectChannel(str, i);
        }
        return Integer.MIN_VALUE;
    }

    public boolean isMaster() {
        IChannelServiceImpl iChannelServiceImpl = this.mControl;
        if (iChannelServiceImpl != null) {
            return iChannelServiceImpl.isMaster();
        }
        return false;
    }

    public String getSdkName() {
        IChannelServiceImpl iChannelServiceImpl = this.mControl;
        if (iChannelServiceImpl != null) {
            return iChannelServiceImpl.getSdkName();
        }
        return null;
    }

    public boolean addChannel(String str, IChannelMessageObserver iChannelMessageObserver) {
        TypeHelper typeHelper;
        try {
            Method method = ChannelService.class.getMethod("addChannel", String.class, IChannelMessageObserver.class);
            IChannelMessageObserverImpl iChannelMessageObserverImpl = null;
            if (iChannelMessageObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iChannelMessageObserverImpl = (IChannelMessageObserverImpl) typeHelper.transfer(method, 1, iChannelMessageObserver);
            }
            IChannelServiceImpl iChannelServiceImpl = this.mControl;
            if (iChannelServiceImpl != null) {
                return iChannelServiceImpl.addChannel(str, iChannelMessageObserverImpl);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public boolean removeChannel(String str) {
        IChannelServiceImpl iChannelServiceImpl = this.mControl;
        if (iChannelServiceImpl != null) {
            return iChannelServiceImpl.removeChannel(str);
        }
        return false;
    }

    public boolean sendMessage(CustomChannelMessageParam customChannelMessageParam) {
        IChannelServiceImpl iChannelServiceImpl = this.mControl;
        if (iChannelServiceImpl != null) {
            return iChannelServiceImpl.sendMessage(customChannelMessageParam);
        }
        return false;
    }

    public int addChannelProxy(ChannelProxyAdapter channelProxyAdapter) {
        TypeHelper typeHelper;
        try {
            Method method = ChannelService.class.getMethod("addChannelProxy", ChannelProxyAdapter.class);
            IChannelProxyAdapterImpl iChannelProxyAdapterImpl = null;
            if (channelProxyAdapter != null && (typeHelper = this.mTypeHelper) != null) {
                iChannelProxyAdapterImpl = (IChannelProxyAdapterImpl) typeHelper.transfer(method, 0, channelProxyAdapter);
            }
            IChannelServiceImpl iChannelServiceImpl = this.mControl;
            if (iChannelServiceImpl != null) {
                return iChannelServiceImpl.addChannelProxy(iChannelProxyAdapterImpl);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    public int removeChannelProxy(ChannelProxyAdapter channelProxyAdapter) {
        TypeHelper typeHelper;
        try {
            Method method = ChannelService.class.getMethod("removeChannelProxy", ChannelProxyAdapter.class);
            IChannelProxyAdapterImpl iChannelProxyAdapterImpl = null;
            if (channelProxyAdapter != null && (typeHelper = this.mTypeHelper) != null) {
                iChannelProxyAdapterImpl = (IChannelProxyAdapterImpl) typeHelper.transfer(method, 0, channelProxyAdapter);
            }
            IChannelServiceImpl iChannelServiceImpl = this.mControl;
            if (iChannelServiceImpl != null) {
                return iChannelServiceImpl.removeChannelProxy(iChannelProxyAdapterImpl);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    public int handleMessage(byte[] bArr, ChannelProxyAdapter channelProxyAdapter) {
        TypeHelper typeHelper;
        IChannelProxyAdapterImpl iChannelProxyAdapterImpl = null;
        if (bArr != null && bArr.length == 0) {
            bArr = null;
        }
        try {
            Method method = ChannelService.class.getMethod("handleMessage", byte[].class, ChannelProxyAdapter.class);
            if (channelProxyAdapter != null && (typeHelper = this.mTypeHelper) != null) {
                iChannelProxyAdapterImpl = (IChannelProxyAdapterImpl) typeHelper.transfer(method, 1, channelProxyAdapter);
            }
            IChannelServiceImpl iChannelServiceImpl = this.mControl;
            if (iChannelServiceImpl != null) {
                return iChannelServiceImpl.handleMessage(bArr, iChannelProxyAdapterImpl);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    public ChannelMsgSyncController setAdapter(IConsisMessageAdapter iConsisMessageAdapter) {
        IChannelMsgSyncControllerImpl adapter;
        TypeHelper typeHelper;
        TypeHelper typeHelper2;
        try {
            Method method = ChannelService.class.getMethod("setAdapter", IConsisMessageAdapter.class);
            IConsisMessageAdapterImpl iConsisMessageAdapterImpl = (iConsisMessageAdapter == null || (typeHelper2 = this.mTypeHelper) == null) ? null : (IConsisMessageAdapterImpl) typeHelper2.transfer(method, 0, iConsisMessageAdapter);
            IChannelServiceImpl iChannelServiceImpl = this.mControl;
            if (iChannelServiceImpl == null || (adapter = iChannelServiceImpl.setAdapter(iConsisMessageAdapterImpl)) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (ChannelMsgSyncController) typeHelper.transfer(method, -1, (Object) adapter, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public boolean addObserver(IChannelProxyObserver iChannelProxyObserver) {
        TypeHelper typeHelper;
        try {
            Method method = ChannelService.class.getMethod("addObserver", IChannelProxyObserver.class);
            IChannelProxyObserverImpl iChannelProxyObserverImpl = null;
            if (iChannelProxyObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iChannelProxyObserverImpl = (IChannelProxyObserverImpl) typeHelper.transfer(method, 0, iChannelProxyObserver);
            }
            IChannelServiceImpl iChannelServiceImpl = this.mControl;
            if (iChannelServiceImpl != null) {
                return iChannelServiceImpl.addObserver(iChannelProxyObserverImpl);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public boolean removeObserver(IChannelProxyObserver iChannelProxyObserver) {
        TypeHelper typeHelper;
        try {
            Method method = ChannelService.class.getMethod("removeObserver", IChannelProxyObserver.class);
            IChannelProxyObserverImpl iChannelProxyObserverImpl = null;
            if (iChannelProxyObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iChannelProxyObserverImpl = (IChannelProxyObserverImpl) typeHelper.transfer(method, 0, iChannelProxyObserver);
            }
            IChannelServiceImpl iChannelServiceImpl = this.mControl;
            if (iChannelServiceImpl != null) {
                boolean removeObserver = iChannelServiceImpl.removeObserver(iChannelProxyObserverImpl);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iChannelProxyObserver);
                }
                TypeHelper typeHelper3 = this.mTypeHelper;
                if (typeHelper3 != null) {
                    typeHelper3.unbind(method, 0, iChannelProxyObserver);
                }
                TypeHelper typeHelper4 = this.mTypeHelper;
                if (typeHelper4 != null) {
                    typeHelper4.unbind(method, 0, iChannelProxyObserver);
                }
                return removeObserver;
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public boolean addObserver(IChannelObserver iChannelObserver) {
        TypeHelper typeHelper;
        try {
            Method method = ChannelService.class.getMethod("addObserver", IChannelObserver.class);
            IChannelObserverImpl iChannelObserverImpl = null;
            if (iChannelObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iChannelObserverImpl = (IChannelObserverImpl) typeHelper.transfer(method, 0, iChannelObserver);
            }
            IChannelServiceImpl iChannelServiceImpl = this.mControl;
            if (iChannelServiceImpl != null) {
                return iChannelServiceImpl.addObserver(iChannelObserverImpl);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public boolean removeObserver(IChannelObserver iChannelObserver) {
        TypeHelper typeHelper;
        try {
            Method method = ChannelService.class.getMethod("removeObserver", IChannelObserver.class);
            IChannelObserverImpl iChannelObserverImpl = null;
            if (iChannelObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iChannelObserverImpl = (IChannelObserverImpl) typeHelper.transfer(method, 0, iChannelObserver);
            }
            IChannelServiceImpl iChannelServiceImpl = this.mControl;
            if (iChannelServiceImpl != null) {
                boolean removeObserver = iChannelServiceImpl.removeObserver(iChannelObserverImpl);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iChannelObserver);
                }
                TypeHelper typeHelper3 = this.mTypeHelper;
                if (typeHelper3 != null) {
                    typeHelper3.unbind(method, 0, iChannelObserver);
                }
                TypeHelper typeHelper4 = this.mTypeHelper;
                if (typeHelper4 != null) {
                    typeHelper4.unbind(method, 0, iChannelObserver);
                }
                return removeObserver;
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public boolean addObserver(IConsisObserver iConsisObserver) {
        TypeHelper typeHelper;
        try {
            Method method = ChannelService.class.getMethod("addObserver", IConsisObserver.class);
            IConsisObserverImpl iConsisObserverImpl = null;
            if (iConsisObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iConsisObserverImpl = (IConsisObserverImpl) typeHelper.transfer(method, 0, iConsisObserver);
            }
            IChannelServiceImpl iChannelServiceImpl = this.mControl;
            if (iChannelServiceImpl != null) {
                return iChannelServiceImpl.addObserver(iConsisObserverImpl);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public boolean removeObserver(IConsisObserver iConsisObserver) {
        TypeHelper typeHelper;
        try {
            Method method = ChannelService.class.getMethod("removeObserver", IConsisObserver.class);
            IConsisObserverImpl iConsisObserverImpl = null;
            if (iConsisObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iConsisObserverImpl = (IConsisObserverImpl) typeHelper.transfer(method, 0, iConsisObserver);
            }
            IChannelServiceImpl iChannelServiceImpl = this.mControl;
            if (iChannelServiceImpl != null) {
                boolean removeObserver = iChannelServiceImpl.removeObserver(iConsisObserverImpl);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iConsisObserver);
                }
                TypeHelper typeHelper3 = this.mTypeHelper;
                if (typeHelper3 != null) {
                    typeHelper3.unbind(method, 0, iConsisObserver);
                }
                TypeHelper typeHelper4 = this.mTypeHelper;
                if (typeHelper4 != null) {
                    typeHelper4.unbind(method, 0, iConsisObserver);
                }
                return removeObserver;
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
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

    protected void clean() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            Iterator it = ((HashSet) typeHelper.getBindSet("com.autonavi.gbl.consis.observer.IChannelProxyObserver")).iterator();
            while (it.hasNext()) {
                removeObserver((IChannelProxyObserver) it.next());
            }
        }
        TypeHelper typeHelper2 = this.mTypeHelper;
        if (typeHelper2 != null) {
            Iterator it2 = ((HashSet) typeHelper2.getBindSet("com.autonavi.gbl.consis.observer.IChannelObserver")).iterator();
            while (it2.hasNext()) {
                removeObserver((IChannelObserver) it2.next());
            }
        }
        TypeHelper typeHelper3 = this.mTypeHelper;
        if (typeHelper3 != null) {
            Iterator it3 = ((HashSet) typeHelper3.getBindSet("com.autonavi.gbl.consis.observer.IConsisObserver")).iterator();
            while (it3.hasNext()) {
                removeObserver((IConsisObserver) it3.next());
            }
        }
        TypeHelper typeHelper4 = this.mTypeHelper;
        if (typeHelper4 != null) {
            Iterator it4 = ((HashSet) typeHelper4.getBindSet("com.autonavi.gbl.consis.observer.IChannelProxyObserver")).iterator();
            while (it4.hasNext()) {
                removeObserver((IChannelProxyObserver) it4.next());
            }
        }
        TypeHelper typeHelper5 = this.mTypeHelper;
        if (typeHelper5 != null) {
            Iterator it5 = ((HashSet) typeHelper5.getBindSet("com.autonavi.gbl.consis.observer.IChannelObserver")).iterator();
            while (it5.hasNext()) {
                removeObserver((IChannelObserver) it5.next());
            }
        }
        TypeHelper typeHelper6 = this.mTypeHelper;
        if (typeHelper6 != null) {
            Iterator it6 = ((HashSet) typeHelper6.getBindSet("com.autonavi.gbl.consis.observer.IConsisObserver")).iterator();
            while (it6.hasNext()) {
                removeObserver((IConsisObserver) it6.next());
            }
        }
        TypeHelper typeHelper7 = this.mTypeHelper;
        if (typeHelper7 != null) {
            Iterator it7 = ((HashSet) typeHelper7.getBindSet("com.autonavi.gbl.consis.observer.IChannelProxyObserver")).iterator();
            while (it7.hasNext()) {
                removeObserver((IChannelProxyObserver) it7.next());
            }
        }
        TypeHelper typeHelper8 = this.mTypeHelper;
        if (typeHelper8 != null) {
            Iterator it8 = ((HashSet) typeHelper8.getBindSet("com.autonavi.gbl.consis.observer.IChannelObserver")).iterator();
            while (it8.hasNext()) {
                removeObserver((IChannelObserver) it8.next());
            }
        }
        TypeHelper typeHelper9 = this.mTypeHelper;
        if (typeHelper9 != null) {
            Iterator it9 = ((HashSet) typeHelper9.getBindSet("com.autonavi.gbl.consis.observer.IConsisObserver")).iterator();
            while (it9.hasNext()) {
                removeObserver((IConsisObserver) it9.next());
            }
        }
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
