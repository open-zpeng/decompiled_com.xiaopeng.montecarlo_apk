package com.xiaopeng.montecarlo.navcore.speech.bean;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.speech.speechwidget.SpeechWidget;
import java.io.Serializable;
import java.util.List;
/* loaded from: classes3.dex */
public class SpeechData implements Serializable {
    @SerializedName("centerPoi")
    private SpeechDataCenterPoi mCenterPoi;
    @SerializedName("content")
    private List<SpeechDataContentItem> mContent;
    @SerializedName("count")
    private int mCount;
    @SerializedName("currentPage")
    private int mCurrentPage;
    @SerializedName(SpeechWidget.WIDGET_DATA_SOURCE)
    private String mDataSource;
    @SerializedName("duiWidget")
    private String mDuiWidget;
    @SerializedName(SpeechWidget.WIDGET_EXTRA)
    private SpeechDataExtra mExtra;
    @SerializedName("intentName")
    private String mIntentName;
    @SerializedName("itemsPerPage")
    private int mItemsPerPage;
    @SerializedName("msgId")
    private String mMsgId;
    @SerializedName("name")
    private String mName;
    @SerializedName("recommendations")
    private List<String> mRecommendations;
    @SerializedName("recordId")
    private String mRecordId;
    @SerializedName("searchText")
    private String mSearchText;
    @SerializedName("segment")
    private List<SpeechDataSegmentItem> mSegment;
    @SerializedName("sessionId")
    private String mSessionId;
    @SerializedName("totalPages")
    private int mTotalPages;
    @SerializedName("type")
    private String mType;
    @SerializedName("widgetId")
    private String mWidgetId;
    @SerializedName("widgetName")
    private String mWidgetName;

    public String getRecordId() {
        return this.mRecordId;
    }

    public void setRecordId(String str) {
        this.mRecordId = str;
    }

    public String getDataSource() {
        return this.mDataSource;
    }

    public void setDataSource(String str) {
        this.mDataSource = str;
    }

    public int getCount() {
        return this.mCount;
    }

    public void setCount(int i) {
        this.mCount = i;
    }

    public SpeechDataExtra getExtra() {
        return this.mExtra;
    }

    public void setExtra(SpeechDataExtra speechDataExtra) {
        this.mExtra = speechDataExtra;
    }

    public String getWidgetName() {
        return this.mWidgetName;
    }

    public void setWidgetName(String str) {
        this.mWidgetName = str;
    }

    public List<SpeechDataSegmentItem> getSegment() {
        return this.mSegment;
    }

    public void setSegment(List<SpeechDataSegmentItem> list) {
        this.mSegment = list;
    }

    public String getDuiWidget() {
        return this.mDuiWidget;
    }

    public void setDuiWidget(String str) {
        this.mDuiWidget = str;
    }

    public String getType() {
        return this.mType;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public List<SpeechDataContentItem> getContent() {
        return this.mContent;
    }

    public void setContent(List<SpeechDataContentItem> list) {
        this.mContent = list;
    }

    public String getSessionId() {
        return this.mSessionId;
    }

    public void setSessionId(String str) {
        this.mSessionId = str;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public List<String> getRecommendations() {
        return this.mRecommendations;
    }

    public void setRecommendations(List<String> list) {
        this.mRecommendations = list;
    }

    public int getCurrentPage() {
        return this.mCurrentPage;
    }

    public void setCurrentPage(int i) {
        this.mCurrentPage = i;
    }

    public String getIntentName() {
        return this.mIntentName;
    }

    public void setIntentName(String str) {
        this.mIntentName = str;
    }

    public int getTotalPages() {
        return this.mTotalPages;
    }

    public void setTotalPages(int i) {
        this.mTotalPages = i;
    }

    public int getItemsPerPage() {
        return this.mItemsPerPage;
    }

    public void setItemsPerPage(int i) {
        this.mItemsPerPage = i;
    }

    public String getSearchText() {
        return this.mSearchText;
    }

    public void setSearchText(String str) {
        this.mSearchText = str;
    }

    public String getMsgId() {
        return this.mMsgId;
    }

    public void setMsgId(String str) {
        this.mMsgId = str;
    }

    public SpeechDataCenterPoi getCenterPoi() {
        return this.mCenterPoi;
    }

    public void setCenterPoi(SpeechDataCenterPoi speechDataCenterPoi) {
        this.mCenterPoi = speechDataCenterPoi;
    }

    public String getWidgetId() {
        return this.mWidgetId;
    }

    public void setWidgetId(String str) {
        this.mWidgetId = str;
    }
}
