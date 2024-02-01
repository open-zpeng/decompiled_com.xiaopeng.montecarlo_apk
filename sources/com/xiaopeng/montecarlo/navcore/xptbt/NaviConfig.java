package com.xiaopeng.montecarlo.navcore.xptbt;

import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class NaviConfig {
    private final ConcurrentHashMap<Integer, String> errorMap;

    /* loaded from: classes3.dex */
    private static class NaviConfigHolder {
        private static final NaviConfig INSTANCE = new NaviConfig();

        private NaviConfigHolder() {
        }
    }

    private NaviConfig() {
        this.errorMap = new ConcurrentHashMap<>();
    }

    public static final NaviConfig getInstance() {
        return NaviConfigHolder.INSTANCE;
    }

    public String getErrorString(int i) {
        if (this.errorMap.isEmpty()) {
            initErrorMap();
        }
        String str = this.errorMap.get(Integer.valueOf(i));
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public int getErrorMapSize() {
        if (this.errorMap.isEmpty()) {
            initErrorMap();
        }
        return this.errorMap.size();
    }

    private void initErrorMap() {
        this.errorMap.put(822083584, "解码器未初始化");
        this.errorMap.put(1, "路径计算不成功");
        this.errorMap.put(822083585, "网络失败");
        this.errorMap.put(822083586, "起点错误");
        this.errorMap.put(822083587, "请求协议非法");
        this.errorMap.put(822083588, "从呼叫中心获取信息失败");
        this.errorMap.put(822083589, "终点错误");
        this.errorMap.put(822083590, "算路服务端编码失败");
        this.errorMap.put(822083591, "路径数据缺乏预览数据");
        this.errorMap.put(822083592, "缓存数据格式错误");
        this.errorMap.put(822083593, "起点找不到道路");
        this.errorMap.put(822083595, "途经点找不到道路");
        this.errorMap.put(822083596, "算路失败（未知错误）");
        this.errorMap.put(822083597, "离线算路失败");
        this.errorMap.put(822083598, "用户取消");
        this.errorMap.put(822083599, "网络超时");
        this.errorMap.put(822083600, "没有网络连接");
        this.errorMap.put(822083601, "起点所在城市无离线数据");
        this.errorMap.put(822083602, "起点/终点/途经点的距离太长（距离>6000KM）");
        this.errorMap.put(822083603, "缺少离线途径城市数据");
        this.errorMap.put(822083604, "途经点错误");
        this.errorMap.put(822083605, "数据正在更新中");
        this.errorMap.put(822083606, "静默算路不满足条件目前只有限时禁行/道路关闭/车牌限行");
        this.errorMap.put(822083607, "终点所在城市无离线数据");
        this.errorMap.put(822083608, "途经点所在城市无离线数据");
        this.errorMap.put(822083609, "离线算路正在进行中，无法进行新的计算");
        this.errorMap.put(822083610, "离线算路参数错误，无法进行新的计算");
        this.errorMap.put(822083611, "没有路线推荐");
        this.errorMap.put(822083612, "多路线模式下没有算出备选路");
        this.errorMap.put(822083613, "多路线模式主路线列表为空或者还原失败");
        this.errorMap.put(822083614, "动态导航没有算出更优路线");
        this.errorMap.put(822083615, "异常动作引起的更新备选路，仍未消除异常动作");
        this.errorMap.put(822083616, "前方拥堵引起备选路更新，无躲避拥堵的路线");
        this.errorMap.put(822083617, "前方有危险事件引起重算，无安全的路线");
        this.errorMap.put(822083618, "算路超时");
        this.errorMap.put(822083619, "目的地太近");
        this.errorMap.put(822083620, "替换失败");
    }
}
