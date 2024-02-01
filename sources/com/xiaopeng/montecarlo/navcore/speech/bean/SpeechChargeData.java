package com.xiaopeng.montecarlo.navcore.speech.bean;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.search.param.CPSearchParam;
import com.xiaopeng.montecarlo.scenes.searchscene.SearchSceneConstants;
import com.xiaopeng.speech.speechwidget.SpeechWidget;
import java.io.Serializable;
import java.util.List;
/* loaded from: classes3.dex */
public class SpeechChargeData implements Serializable {
    @SerializedName("count")
    private int mCount;
    @SerializedName("curPageOpenSerial")
    private int mCurPageOpenSerial;
    @SerializedName("currentPage")
    private int mCurrentPage;
    @SerializedName("duiWidget")
    private String mDuiWidget;
    @SerializedName(SpeechWidget.WIDGET_EXTRA)
    private ExtraBean mExtra;
    @SerializedName("intentName")
    private String mIntentName;
    @SerializedName("itemsPerPage")
    private int mItemsPerPage;
    @SerializedName("msgId")
    private String mMsgId;
    @SerializedName("name")
    private String mName;
    @SerializedName(SpeechWidget.WIDGET_SEARCH_CONTENT)
    private SearchContentBean mSearchContent;
    @SerializedName("searchText")
    private String mSearchText;
    @SerializedName("sessionId")
    private String mSessionId;
    @SerializedName("tipsTimeout")
    private int mTipsTimeout;
    @SerializedName("totalPages")
    private int mTotalPages;
    @SerializedName("type")
    private String mType;
    @SerializedName("widgetName")
    private String mWidgetName;

    public String getWidgetName() {
        return this.mWidgetName;
    }

    public void setWidgetName(String str) {
        this.mWidgetName = str;
    }

    public String getDuiWidget() {
        return this.mDuiWidget;
    }

    public void setDuiWidget(String str) {
        this.mDuiWidget = str;
    }

    public int getCount() {
        return this.mCount;
    }

    public void setCount(int i) {
        this.mCount = i;
    }

    public int getTipsTimeout() {
        return this.mTipsTimeout;
    }

    public void setTipsTimeout(int i) {
        this.mTipsTimeout = i;
    }

    public String getSessionId() {
        return this.mSessionId;
    }

    public void setSessionId(String str) {
        this.mSessionId = str;
    }

    public String getType() {
        return this.mType;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public int getCurPageOpenSerial() {
        return this.mCurPageOpenSerial;
    }

    public void setCurPageOpenSerial(int i) {
        this.mCurPageOpenSerial = i;
    }

    public int getItemsPerPage() {
        return this.mItemsPerPage;
    }

    public void setItemsPerPage(int i) {
        this.mItemsPerPage = i;
    }

    public ExtraBean getExtra() {
        return this.mExtra;
    }

    public void setExtra(ExtraBean extraBean) {
        this.mExtra = extraBean;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public int getTotalPages() {
        return this.mTotalPages;
    }

    public void setTotalPages(int i) {
        this.mTotalPages = i;
    }

    public int getCurrentPage() {
        return this.mCurrentPage;
    }

    public void setCurrentPage(int i) {
        this.mCurrentPage = i;
    }

    public SearchContentBean getSearchContent() {
        return this.mSearchContent;
    }

    public void setSearchContent(SearchContentBean searchContentBean) {
        this.mSearchContent = searchContentBean;
    }

    public String getMsgId() {
        return this.mMsgId;
    }

    public void setMsgId(String str) {
        this.mMsgId = str;
    }

    public String getSearchText() {
        return this.mSearchText;
    }

    public void setSearchText(String str) {
        this.mSearchText = str;
    }

    public String getIntentName() {
        return this.mIntentName;
    }

    public void setIntentName(String str) {
        this.mIntentName = str;
    }

    /* loaded from: classes3.dex */
    public static class ExtraBean {
        @SerializedName("extraType")
        private String mExtraType;
        @SerializedName(SpeechWidget.WIDGET_TITLE)
        private String mTitle;

        public String getTitle() {
            return this.mTitle;
        }

        public void setTitle(String str) {
            this.mTitle = str;
        }

        public String getExtraType() {
            return this.mExtraType;
        }

        public void setExtraType(String str) {
            this.mExtraType = str;
        }
    }

    /* loaded from: classes3.dex */
    public static class SearchContentBean {
        @SerializedName("aboveHint")
        private String mAboveHint;
        @SerializedName("belowHint")
        private String mBelowHint;
        @SerializedName("data")
        private DataBean mData;
        @SerializedName("searchType")
        private String mSearchType;

        public DataBean getData() {
            return this.mData;
        }

        public void setData(DataBean dataBean) {
            this.mData = dataBean;
        }

        public String getSearchType() {
            return this.mSearchType;
        }

        public void setSearchType(String str) {
            this.mSearchType = str;
        }

        public String getAboveHint() {
            return this.mAboveHint;
        }

        public void setAboveHint(String str) {
            this.mAboveHint = str;
        }

        public String getBelowHint() {
            return this.mBelowHint;
        }

        public void setBelowHint(String str) {
            this.mBelowHint = str;
        }

        /* loaded from: classes3.dex */
        public static class DataBean {
            @SerializedName(SearchSceneConstants.SEARCH_SAVESTATE_SEARCHDATA)
            private List<SearchDataBean> mSearchData;

            public List<SearchDataBean> getSearchData() {
                return this.mSearchData;
            }

            public void setSearchData(List<SearchDataBean> list) {
                this.mSearchData = list;
            }

            /* loaded from: classes3.dex */
            public static class SearchDataBean {
                @SerializedName("acFreeNums")
                private int mAcFreeNums;
                @SerializedName("acNums")
                private int mAcNums;
                @SerializedName("busiTime")
                private String mBusiTime;
                @SerializedName("chargingFee")
                private int mChargingFee;
                @SerializedName("dcFreeNums")
                private int mDcFreeNums;
                @SerializedName("dcNums")
                private int mDcNums;
                @SerializedName("displayDistance")
                private String mDisplayDistance;
                @SerializedName("distance")
                private double mDistance;
                @SerializedName("expRemainDis")
                private int mExpRemainDis;
                @SerializedName("locationDes")
                private String mLocationDes;
                @SerializedName("name")
                private String mName;
                @SerializedName("selfSupportFlag")
                private int mSelfSupportFlag;
                @SerializedName("serviceFee")
                private int mServiceFee;
                @SerializedName("stationAddr")
                private String mStationAddr;
                @SerializedName(CPSearchParam.PARAM_KEY_STATIONID)
                private String mStationId;

                public int getServiceFee() {
                    return this.mServiceFee;
                }

                public void setServiceFee(int i) {
                    this.mServiceFee = i;
                }

                public String getDisplayDistance() {
                    return this.mDisplayDistance;
                }

                public void setDisplayDistance(String str) {
                    this.mDisplayDistance = str;
                }

                public int getSelfSupportFlag() {
                    return this.mSelfSupportFlag;
                }

                public void setSelfSupportFlag(int i) {
                    this.mSelfSupportFlag = i;
                }

                public double getDistance() {
                    return this.mDistance;
                }

                public void setDistance(double d) {
                    this.mDistance = d;
                }

                public int getAcFreeNums() {
                    return this.mAcFreeNums;
                }

                public void setAcFreeNums(int i) {
                    this.mAcFreeNums = i;
                }

                public String getBusiTime() {
                    return this.mBusiTime;
                }

                public void setBusiTime(String str) {
                    this.mBusiTime = str;
                }

                public int getExpRemainDis() {
                    return this.mExpRemainDis;
                }

                public void setExpRemainDis(int i) {
                    this.mExpRemainDis = i;
                }

                public int getDcNums() {
                    return this.mDcNums;
                }

                public void setDcNums(int i) {
                    this.mDcNums = i;
                }

                public int getAcNums() {
                    return this.mAcNums;
                }

                public void setAcNums(int i) {
                    this.mAcNums = i;
                }

                public int getChargingFee() {
                    return this.mChargingFee;
                }

                public void setChargingFee(int i) {
                    this.mChargingFee = i;
                }

                public int getDcFreeNums() {
                    return this.mDcFreeNums;
                }

                public void setDcFreeNums(int i) {
                    this.mDcFreeNums = i;
                }

                public String getLocationDes() {
                    return this.mLocationDes;
                }

                public void setLocationDes(String str) {
                    this.mLocationDes = str;
                }

                public String getName() {
                    return this.mName;
                }

                public void setName(String str) {
                    this.mName = str;
                }

                public String getStationAddr() {
                    return this.mStationAddr;
                }

                public void setStationAddr(String str) {
                    this.mStationAddr = str;
                }

                public String getStationId() {
                    return this.mStationId;
                }

                public void setStationId(String str) {
                    this.mStationId = str;
                }
            }
        }
    }
}
