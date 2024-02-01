package com.autonavi.gbl.layer.model;

import android.util.Log;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.card.CardService;
import com.autonavi.gbl.card.impl.ICardServiceImpl;
import com.autonavi.gbl.layer.observer.IDynamicLayerObserver;
import com.autonavi.gbl.layer.observer.impl.IDynamicLayerObserverImpl;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Set;
/* loaded from: classes2.dex */
public class DynamicInitParamEx implements Serializable {
    private ICardServiceImpl cardService;
    private int defaultStyleID;
    private IDynamicLayerObserverImpl dynamicObserver;
    private HashMap<Integer, String> initStyleDSLs;
    private TypeHelper mTypeHelper;

    public void delete() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
    }

    private void initTypeHelper() {
        this.mTypeHelper = new TypeHelper("DynamicInitParamEx" + hashCode());
    }

    private void recordByIntfAuto() {
        getCardService();
        getDynamicObserver();
    }

    public void setDefaultStyleID(int i) {
        this.defaultStyleID = i;
    }

    public int getDefaultStyleID() {
        return this.defaultStyleID;
    }

    public void setCardService(CardService cardService) {
        ReflexTool.EM(new Object() { // from class: com.autonavi.gbl.layer.model.DynamicInitParamEx.1
        });
        try {
            Method method = getClass().getMethod("setCardService", CardService.class);
            TypeHelper typeHelper = this.mTypeHelper;
            if (typeHelper != null) {
                Set bindSet = typeHelper.getBindSet(method, 0);
                bindSet.remove(cardService);
                this.cardService = (ICardServiceImpl) this.mTypeHelper.transfer(method, 0, cardService);
                this.mTypeHelper.unbindSet(method, 0, bindSet);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public CardService getCardService() {
        if (this.mTypeHelper != null && this.cardService != null) {
            ReflexTool.EM(new Object() { // from class: com.autonavi.gbl.layer.model.DynamicInitParamEx.2
            });
            try {
                return (CardService) this.mTypeHelper.transfer(getClass().getMethod("getCardService", new Class[0]), -1, (Object) this.cardService, true);
            } catch (Exception e) {
                Log.w("INTFAUTO", Log.getStackTraceString(e));
            }
        }
        return null;
    }

    public void setDynamicObserver(IDynamicLayerObserver iDynamicLayerObserver) {
        ReflexTool.EM(new Object() { // from class: com.autonavi.gbl.layer.model.DynamicInitParamEx.3
        });
        try {
            Method method = getClass().getMethod("setDynamicObserver", IDynamicLayerObserver.class);
            TypeHelper typeHelper = this.mTypeHelper;
            if (typeHelper != null) {
                Set bindSet = typeHelper.getBindSet(method, 0);
                bindSet.remove(iDynamicLayerObserver);
                this.dynamicObserver = (IDynamicLayerObserverImpl) this.mTypeHelper.transfer(method, 0, iDynamicLayerObserver);
                this.mTypeHelper.unbindSet(method, 0, bindSet);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public IDynamicLayerObserver getDynamicObserver() {
        if (this.mTypeHelper != null && this.dynamicObserver != null) {
            ReflexTool.EM(new Object() { // from class: com.autonavi.gbl.layer.model.DynamicInitParamEx.4
            });
            try {
                return (IDynamicLayerObserver) this.mTypeHelper.transfer(getClass().getMethod("getDynamicObserver", new Class[0]), -1, (Object) this.dynamicObserver, true);
            } catch (Exception e) {
                Log.w("INTFAUTO", Log.getStackTraceString(e));
            }
        }
        return null;
    }

    public void setInitStyleDSLs(HashMap<Integer, String> hashMap) {
        this.initStyleDSLs = hashMap;
    }

    public HashMap<Integer, String> getInitStyleDSLs() {
        return this.initStyleDSLs;
    }

    public DynamicInitParamEx() {
        initTypeHelper();
        this.defaultStyleID = 0;
        this.cardService = null;
        this.dynamicObserver = null;
        this.initStyleDSLs = new HashMap<>();
        recordByIntfAuto();
    }

    protected DynamicInitParamEx(int i, ICardServiceImpl iCardServiceImpl, IDynamicLayerObserverImpl iDynamicLayerObserverImpl, HashMap<Integer, String> hashMap) {
        initTypeHelper();
        this.defaultStyleID = i;
        this.cardService = iCardServiceImpl;
        this.dynamicObserver = iDynamicLayerObserverImpl;
        this.initStyleDSLs = hashMap;
        recordByIntfAuto();
    }

    public DynamicInitParamEx(int i, CardService cardService, IDynamicLayerObserver iDynamicLayerObserver, HashMap<Integer, String> hashMap) {
        initTypeHelper();
        Constructor EC = ReflexTool.EC(new Object() { // from class: com.autonavi.gbl.layer.model.DynamicInitParamEx.5
        });
        this.defaultStyleID = i;
        TypeHelper typeHelper = this.mTypeHelper;
        this.cardService = typeHelper != null ? (ICardServiceImpl) typeHelper.transfer(EC, 1, cardService) : null;
        TypeHelper typeHelper2 = this.mTypeHelper;
        this.dynamicObserver = typeHelper2 != null ? (IDynamicLayerObserverImpl) typeHelper2.transfer(EC, 2, iDynamicLayerObserver) : null;
        this.initStyleDSLs = hashMap;
        recordByIntfAuto();
    }
}
