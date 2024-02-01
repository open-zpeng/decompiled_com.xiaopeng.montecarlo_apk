package com.autonavi.gbl.consis.model;

import android.util.Log;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.consis.ChannelParcel;
import com.autonavi.gbl.consis.impl.ChannelParcelImpl;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Set;
/* loaded from: classes.dex */
public class CustomChannelMessageParam implements Serializable {
    private ChannelParcelImpl customData;
    private TypeHelper mTypeHelper;
    private String receiverChannelName;
    private String senderChannelName;

    public void delete() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
    }

    private void initTypeHelper() {
        this.mTypeHelper = new TypeHelper("CustomChannelMessageParam" + hashCode());
    }

    private void recordByIntfAuto() {
        getCustomData();
    }

    public void setSenderChannelName(String str) {
        this.senderChannelName = str;
    }

    public String getSenderChannelName() {
        return this.senderChannelName;
    }

    public void setReceiverChannelName(String str) {
        this.receiverChannelName = str;
    }

    public String getReceiverChannelName() {
        return this.receiverChannelName;
    }

    public void setCustomData(ChannelParcel channelParcel) {
        ReflexTool.EM(new Object() { // from class: com.autonavi.gbl.consis.model.CustomChannelMessageParam.1
        });
        try {
            Method method = getClass().getMethod("setCustomData", ChannelParcel.class);
            TypeHelper typeHelper = this.mTypeHelper;
            if (typeHelper != null) {
                Set bindSet = typeHelper.getBindSet(method, 0);
                bindSet.remove(channelParcel);
                this.customData = (ChannelParcelImpl) this.mTypeHelper.transfer(method, 0, channelParcel);
                this.mTypeHelper.unbindSet(method, 0, bindSet);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public ChannelParcel getCustomData() {
        if (this.mTypeHelper != null && this.customData != null) {
            ReflexTool.EM(new Object() { // from class: com.autonavi.gbl.consis.model.CustomChannelMessageParam.2
            });
            try {
                return (ChannelParcel) this.mTypeHelper.transfer(getClass().getMethod("getCustomData", new Class[0]), -1, (Object) this.customData, true);
            } catch (Exception e) {
                Log.w("INTFAUTO", Log.getStackTraceString(e));
            }
        }
        return null;
    }

    public CustomChannelMessageParam() {
        initTypeHelper();
        this.senderChannelName = "";
        this.receiverChannelName = "";
        this.customData = null;
        recordByIntfAuto();
    }

    protected CustomChannelMessageParam(String str, String str2, ChannelParcelImpl channelParcelImpl) {
        initTypeHelper();
        this.senderChannelName = str;
        this.receiverChannelName = str2;
        this.customData = channelParcelImpl;
        recordByIntfAuto();
    }

    public CustomChannelMessageParam(String str, String str2, ChannelParcel channelParcel) {
        initTypeHelper();
        Constructor EC = ReflexTool.EC(new Object() { // from class: com.autonavi.gbl.consis.model.CustomChannelMessageParam.3
        });
        this.senderChannelName = str;
        this.receiverChannelName = str2;
        TypeHelper typeHelper = this.mTypeHelper;
        this.customData = typeHelper != null ? (ChannelParcelImpl) typeHelper.transfer(EC, 2, channelParcel) : null;
        recordByIntfAuto();
    }
}
