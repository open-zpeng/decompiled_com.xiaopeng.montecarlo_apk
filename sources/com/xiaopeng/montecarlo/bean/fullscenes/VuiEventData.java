package com.xiaopeng.montecarlo.bean.fullscenes;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.IntentActions;
import com.xiaopeng.speech.vui.constants.VuiConstants;
import java.io.Serializable;
import java.util.List;
/* loaded from: classes.dex */
public class VuiEventData implements Serializable {
    @SerializedName(VuiConstants.SCENE_ELEMENTS)
    private List<ElementsBean> mElements;
    @SerializedName(VuiConstants.SCENE_ID)
    private String mSceneId;

    public String getSceneId() {
        return this.mSceneId;
    }

    public void setSceneId(String str) {
        this.mSceneId = str;
    }

    public List<ElementsBean> getElements() {
        return this.mElements;
    }

    public void setElements(List<ElementsBean> list) {
        this.mElements = list;
    }

    /* loaded from: classes.dex */
    public static class ElementsBean {
        @SerializedName(IntentActions.ActionsKey.KEY_ACTION)
        private String mAction;
        @SerializedName(VuiConstants.SCENE_ELEMENTS)
        private List<?> mElements;
        @SerializedName(VuiConstants.ELEMENT_ID)
        private String mId;
        @SerializedName("label")
        private String mLabel;
        @SerializedName(VuiConstants.ELEMENT_PROPS)
        private PropsBean mProps;
        @SerializedName("type")
        private String mType;

        /* loaded from: classes.dex */
        public static class PropsBean {
        }

        public String getAction() {
            return this.mAction;
        }

        public void setAction(String str) {
            this.mAction = str;
        }

        public String getId() {
            return this.mId;
        }

        public void setId(String str) {
            this.mId = str;
        }

        public String getLabel() {
            return this.mLabel;
        }

        public void setLabel(String str) {
            this.mLabel = str;
        }

        public String getType() {
            return this.mType;
        }

        public void setType(String str) {
            this.mType = str;
        }

        public PropsBean getProps() {
            return this.mProps;
        }

        public void setProps(PropsBean propsBean) {
            this.mProps = propsBean;
        }

        public List<?> getElements() {
            return this.mElements;
        }

        public void setElements(List<?> list) {
            this.mElements = list;
        }

        public String toString() {
            return "ElementsBean{mAction='" + this.mAction + "', mId='" + this.mId + "', mLabel='" + this.mLabel + "', mType='" + this.mType + "', mProps=" + this.mProps + ", mElements=" + this.mElements + '}';
        }
    }
}
