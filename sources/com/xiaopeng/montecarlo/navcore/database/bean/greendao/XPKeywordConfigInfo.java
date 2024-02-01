package com.xiaopeng.montecarlo.navcore.database.bean.greendao;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.speech.voicefusion.VoiceFusionUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.speech.vui.constants.VuiConstants;
import java.util.List;
/* loaded from: classes3.dex */
public class XPKeywordConfigInfo {
    public static final String KEYWORD_CONFIG_CATEGORY_CAR_WASH = "100101";
    public static final String KEYWORD_CONFIG_CATEGORY_CHARGE = "100100";
    public static final String KEYWORD_CONFIG_CATEGORY_DELIVERY_CENTER = "100104";
    public static final String KEYWORD_CONFIG_CATEGORY_EXP_CENTER = "100102";
    public static final String KEYWORD_CONFIG_CATEGORY_INTEGRATED_SERVER_CENTER = "100105";
    public static final String KEYWORD_CONFIG_CATEGORY_SERVER_CENTER = "100103";
    private static final L.Tag TAG = new L.Tag("XPKeywordConfigInfo");
    @SerializedName("category")
    private String category;
    @SerializedName("description")
    private String description;
    @SerializedName(VuiConstants.ELEMENT_ID)
    private Long id;
    @SerializedName(VoiceFusionUtil.KEY_KEYWORD)
    private String keyword;
    @SerializedName("keywordList")
    private List<String> keywordList;

    public XPKeywordConfigInfo(Long l, String str, String str2, String str3) {
        this.id = l;
        this.category = str;
        this.keyword = str2;
        this.description = str3;
    }

    public XPKeywordConfigInfo() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public String getKeyword() {
        return this.keyword;
    }

    public void setKeyword(String str) {
        this.keyword = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public List<String> getKeywordList() {
        return this.keywordList;
    }

    public void setKeywordList(List<String> list) {
        this.keywordList = list;
    }
}
