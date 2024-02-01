package com.xiaopeng.montecarlo.navcore.aimessage.bean;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.gson.annotations.SerializedName;
/* loaded from: classes2.dex */
public class OneParkItemBean {
    public static String COLOR_BLUE = "blue";
    public static String COLOR_GRAY = "gray";
    public static String COLOR_GREEN = "green";
    public static String COLOR_YELLOW = "yellow";
    @SerializedName("distance")
    private String mDistance;
    @SerializedName("label1")
    private LabelBean mLabel1;
    @SerializedName("label2")
    private LabelBean mLabel2;
    @SerializedName("name")
    private String mName;

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public LabelBean getLabel1() {
        return this.mLabel1;
    }

    public void setLabel1(LabelBean labelBean) {
        this.mLabel1 = labelBean;
    }

    public LabelBean getLabel2() {
        return this.mLabel2;
    }

    public void setLabel2(LabelBean labelBean) {
        this.mLabel2 = labelBean;
    }

    public String getDistance() {
        return this.mDistance;
    }

    public void setDistance(String str) {
        this.mDistance = str;
    }

    /* loaded from: classes2.dex */
    public static class LabelBean {
        @SerializedName(TypedValues.Custom.S_COLOR)
        private String mColor;
        @SerializedName("name")
        private String mName;

        public String getName() {
            return this.mName;
        }

        public void setName(String str) {
            this.mName = str;
        }

        public String getColor() {
            return this.mColor;
        }

        public void setColor(String str) {
            this.mColor = str;
        }
    }
}
