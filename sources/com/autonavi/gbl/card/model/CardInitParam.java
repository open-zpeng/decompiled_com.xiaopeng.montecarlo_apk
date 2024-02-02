package com.autonavi.gbl.card.model;

import android.util.Log;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.card.observer.IFileContentLoader;
import com.autonavi.gbl.card.observer.impl.IFileContentLoaderImpl;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Set;
/* loaded from: classes.dex */
public class CardInitParam implements Serializable {
    private IFileContentLoaderImpl fileLoader;
    private ArrayList<CardFontInfo> fontInfoList;
    private CmbLoaderInitParam loaderParam;
    private TypeHelper mTypeHelper;

    public void delete() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
    }

    private void initTypeHelper() {
        this.mTypeHelper = new TypeHelper("CardInitParam" + hashCode());
    }

    private void recordByIntfAuto() {
        getFileLoader();
    }

    public void setFontInfoList(ArrayList<CardFontInfo> arrayList) {
        this.fontInfoList = arrayList;
    }

    public ArrayList<CardFontInfo> getFontInfoList() {
        return this.fontInfoList;
    }

    public void setFileLoader(IFileContentLoader iFileContentLoader) {
        ReflexTool.EM(new Object() { // from class: com.autonavi.gbl.card.model.CardInitParam.1
        });
        try {
            Method method = getClass().getMethod("setFileLoader", IFileContentLoader.class);
            TypeHelper typeHelper = this.mTypeHelper;
            if (typeHelper != null) {
                Set bindSet = typeHelper.getBindSet(method, 0);
                bindSet.remove(iFileContentLoader);
                this.fileLoader = (IFileContentLoaderImpl) this.mTypeHelper.transfer(method, 0, iFileContentLoader);
                this.mTypeHelper.unbindSet(method, 0, bindSet);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public IFileContentLoader getFileLoader() {
        if (this.mTypeHelper != null && this.fileLoader != null) {
            ReflexTool.EM(new Object() { // from class: com.autonavi.gbl.card.model.CardInitParam.2
            });
            try {
                return (IFileContentLoader) this.mTypeHelper.transfer(getClass().getMethod("getFileLoader", new Class[0]), -1, (Object) this.fileLoader, true);
            } catch (Exception e) {
                Log.w("INTFAUTO", Log.getStackTraceString(e));
            }
        }
        return null;
    }

    public void setLoaderParam(CmbLoaderInitParam cmbLoaderInitParam) {
        this.loaderParam = cmbLoaderInitParam;
    }

    public CmbLoaderInitParam getLoaderParam() {
        return this.loaderParam;
    }

    public CardInitParam() {
        initTypeHelper();
        this.fontInfoList = new ArrayList<>();
        this.fileLoader = null;
        this.loaderParam = new CmbLoaderInitParam();
        recordByIntfAuto();
    }

    protected CardInitParam(ArrayList<CardFontInfo> arrayList, IFileContentLoaderImpl iFileContentLoaderImpl, CmbLoaderInitParam cmbLoaderInitParam) {
        initTypeHelper();
        this.fontInfoList = arrayList;
        this.fileLoader = iFileContentLoaderImpl;
        this.loaderParam = cmbLoaderInitParam;
        recordByIntfAuto();
    }

    public CardInitParam(ArrayList<CardFontInfo> arrayList, IFileContentLoader iFileContentLoader, CmbLoaderInitParam cmbLoaderInitParam) {
        initTypeHelper();
        Constructor EC = ReflexTool.EC(new Object() { // from class: com.autonavi.gbl.card.model.CardInitParam.3
        });
        this.fontInfoList = arrayList;
        TypeHelper typeHelper = this.mTypeHelper;
        this.fileLoader = typeHelper != null ? (IFileContentLoaderImpl) typeHelper.transfer(EC, 1, iFileContentLoader) : null;
        this.loaderParam = cmbLoaderInitParam;
        recordByIntfAuto();
    }
}
