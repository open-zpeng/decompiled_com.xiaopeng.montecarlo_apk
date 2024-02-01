package com.xiaopeng.montecarlo.navcore.httpclient.dto;

import com.google.gson.annotations.SerializedName;
/* loaded from: classes3.dex */
public class AssistantDateInfo {
    @SerializedName("date")
    private String mDate;
    @SerializedName("festival")
    private String mFestival;
    @SerializedName("holiday")
    private Boolean mHoliday;
    @SerializedName("week")
    private Integer mWeek;
    @SerializedName("workingDay")
    private boolean mWorkingDay;

    protected boolean canEqual(Object obj) {
        return obj instanceof AssistantDateInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AssistantDateInfo) {
            AssistantDateInfo assistantDateInfo = (AssistantDateInfo) obj;
            if (assistantDateInfo.canEqual(this) && isWorkingDay() == assistantDateInfo.isWorkingDay()) {
                Integer week = getWeek();
                Integer week2 = assistantDateInfo.getWeek();
                if (week != null ? week.equals(week2) : week2 == null) {
                    Boolean holiday = getHoliday();
                    Boolean holiday2 = assistantDateInfo.getHoliday();
                    if (holiday != null ? holiday.equals(holiday2) : holiday2 == null) {
                        String date = getDate();
                        String date2 = assistantDateInfo.getDate();
                        if (date != null ? date.equals(date2) : date2 == null) {
                            String festival = getFestival();
                            String festival2 = assistantDateInfo.getFestival();
                            return festival != null ? festival.equals(festival2) : festival2 == null;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        int i = isWorkingDay() ? 79 : 97;
        Integer week = getWeek();
        int hashCode = ((i + 59) * 59) + (week == null ? 43 : week.hashCode());
        Boolean holiday = getHoliday();
        int hashCode2 = (hashCode * 59) + (holiday == null ? 43 : holiday.hashCode());
        String date = getDate();
        int hashCode3 = (hashCode2 * 59) + (date == null ? 43 : date.hashCode());
        String festival = getFestival();
        return (hashCode3 * 59) + (festival != null ? festival.hashCode() : 43);
    }

    public AssistantDateInfo setDate(String str) {
        this.mDate = str;
        return this;
    }

    public AssistantDateInfo setFestival(String str) {
        this.mFestival = str;
        return this;
    }

    public AssistantDateInfo setHoliday(Boolean bool) {
        this.mHoliday = bool;
        return this;
    }

    public AssistantDateInfo setWeek(Integer num) {
        this.mWeek = num;
        return this;
    }

    public AssistantDateInfo setWorkingDay(boolean z) {
        this.mWorkingDay = z;
        return this;
    }

    public String toString() {
        return "AssistantDateInfo(mDate=" + getDate() + ", mWorkingDay=" + isWorkingDay() + ", mWeek=" + getWeek() + ", mFestival=" + getFestival() + ", mHoliday=" + getHoliday() + ")";
    }

    public String getDate() {
        return this.mDate;
    }

    public boolean isWorkingDay() {
        return this.mWorkingDay;
    }

    public Integer getWeek() {
        return this.mWeek;
    }

    public String getFestival() {
        return this.mFestival;
    }

    public Boolean getHoliday() {
        return this.mHoliday;
    }
}
