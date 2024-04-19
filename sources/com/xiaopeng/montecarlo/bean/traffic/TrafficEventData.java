package com.xiaopeng.montecarlo.bean.traffic;

import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class TrafficEventData {
    private String mIncidentDes1;
    private String mIncidentDes2;
    private String mIncidentDes3;
    private String mIncidentSubTitle;
    private String mIncidentTitle;
    private boolean mIsOfficial;
    private String mLayerTag;
    private int mTrafficIconId;
    List<String> mUrlList;

    public TrafficEventData() {
        this.mIsOfficial = false;
        this.mUrlList = new ArrayList();
    }

    private TrafficEventData(Builder builder) {
        this.mIsOfficial = false;
        this.mUrlList = new ArrayList();
        this.mTrafficIconId = builder.mTrafficIconId;
        this.mLayerTag = builder.mLayerTag;
        this.mIncidentTitle = builder.mIncidentTitle;
        this.mIncidentSubTitle = builder.mIncidentSubTitle;
        this.mIncidentDes1 = builder.mIncidentDes1;
        this.mIncidentDes2 = builder.mIncidentDes2;
        this.mIncidentDes3 = builder.mIncidentDes3;
        this.mIsOfficial = builder.mIsOfficial;
        if (CollectionUtils.isNotEmpty(builder.mUrlList)) {
            this.mUrlList.addAll(builder.mUrlList);
        }
    }

    public int getTrafficIconId() {
        return this.mTrafficIconId;
    }

    public String getIncidentTitle() {
        return this.mIncidentTitle;
    }

    public String getIncidentSubTitle() {
        return this.mIncidentSubTitle;
    }

    public String getIncidentDes1() {
        return this.mIncidentDes1;
    }

    public String getIncidentDes2() {
        return this.mIncidentDes2;
    }

    public String getIncidentDes3() {
        return this.mIncidentDes3;
    }

    public String getLayerTag() {
        return this.mLayerTag;
    }

    public boolean isOfficial() {
        return this.mIsOfficial;
    }

    public List<String> getUrls() {
        return this.mUrlList;
    }

    public String toString() {
        return "traffic title: " + this.mIncidentTitle + ", sub title: " + this.mIncidentSubTitle + ", des: " + this.mIncidentDes1 + ", des2: " + this.mIncidentDes2 + ", des3: " + this.mIncidentDes3;
    }

    /* loaded from: classes2.dex */
    public static final class Builder {
        private String mIncidentDes1;
        private String mIncidentDes2;
        private String mIncidentDes3;
        private String mIncidentSubTitle;
        private String mIncidentTitle;
        private boolean mIsOfficial;
        private String mLayerTag;
        private int mTrafficIconId;
        private List<String> mUrlList = new ArrayList();

        public Builder setTrafficIconId(int i) {
            this.mTrafficIconId = i;
            return this;
        }

        public Builder setLayerTag(String str) {
            this.mLayerTag = str;
            return this;
        }

        public Builder setIncidentTitle(String str) {
            this.mIncidentTitle = str;
            return this;
        }

        public Builder setIncidentSubTitle(String str) {
            this.mIncidentSubTitle = str;
            return this;
        }

        public Builder setIncidentDes1(String str) {
            this.mIncidentDes1 = str;
            return this;
        }

        public Builder setIncidentDes2(String str) {
            this.mIncidentDes2 = str;
            return this;
        }

        public Builder setIncidentDes3(String str) {
            this.mIncidentDes3 = str;
            return this;
        }

        public Builder setIsOfficial(boolean z) {
            this.mIsOfficial = z;
            return this;
        }

        public Builder addIconUrls(List<String> list) {
            if (CollectionUtils.isNotEmpty(list)) {
                this.mUrlList.addAll(list);
            }
            return this;
        }

        public TrafficEventData build() {
            return new TrafficEventData(this);
        }
    }
}
