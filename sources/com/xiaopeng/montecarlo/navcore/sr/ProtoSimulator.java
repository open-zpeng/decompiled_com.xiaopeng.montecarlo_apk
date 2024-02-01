package com.xiaopeng.montecarlo.navcore.sr;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.xiaopeng.montecarlo.navcore.bean.location.XPPosInfo;
import com.xiaopeng.montecarlo.navcore.search.param.CPSearchParam;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;
import xpilot.sr.proto.Overall;
import xpilot.sr.proto.Primitives;
/* loaded from: classes3.dex */
public class ProtoSimulator implements Handler.Callback {
    private static final int MSG_PAUSE = 3;
    private static final int MSG_RESUME = 2;
    private static final int MSG_SEEK_TO = 4;
    private static final int MSG_START = 1;
    public static final int SR_DATA_INTERVAL = 45;
    private static final L.Tag TAG = new L.Tag("ProtoSimulator");
    private int mCount;
    private Handler mHandler;
    private boolean mIsRunning;
    private long mLastFrameTime;
    private ModifyProtoBean mModifyProto;
    private Overall.total_overall.Builder mOverallBuilder;
    private int mProgress;
    private ProgressListener mProgressListener;
    private HandlerThread mProtoSimulatorThread;

    /* loaded from: classes3.dex */
    public interface ProgressListener {
        void onProgressChanged(int i);
    }

    private ProtoSimulator() {
        this.mLastFrameTime = 0L;
        this.mProgress = 0;
        this.mCount = 0;
        this.mIsRunning = false;
    }

    public void startModify(boolean z) {
        if (z) {
            this.mModifyProto = new ModifyProtoBean();
        } else {
            this.mModifyProto = null;
        }
    }

    private boolean isModifyProto() {
        return this.mModifyProto != null;
    }

    public void modify(int i, int i2) {
        L.Tag tag = TAG;
        L.i(tag, "modify rd = " + i + " value = " + i2);
        if (isModifyProto()) {
            this.mModifyProto.modify(i, i2);
            return;
        }
        L.Tag tag2 = TAG;
        L.e(tag2, "you should send start cmd first, modify rd = " + i + " value = " + i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class ModifyProtoBean {
        int rd_10;
        int rd_11;
        int rd_14;
        int rd_15;
        int rd_16;

        private ModifyProtoBean() {
            this.rd_10 = -1;
            this.rd_11 = -1;
            this.rd_14 = -1;
            this.rd_15 = -1;
            this.rd_16 = -1;
        }

        void modify(int i, int i2) {
            switch (i) {
                case 10:
                    this.rd_10 = i2;
                    return;
                case 11:
                    this.rd_11 = i2;
                    return;
                case 12:
                case 13:
                default:
                    return;
                case 14:
                    this.rd_14 = i2;
                    return;
                case 15:
                    this.rd_15 = i2;
                    return;
                case 16:
                    this.rd_16 = i2;
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class LazyHolder {
        private static final ProtoSimulator INSTANCE = new ProtoSimulator();

        private LazyHolder() {
        }
    }

    public static ProtoSimulator getInstance() {
        return LazyHolder.INSTANCE;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            readProtoData();
            return false;
        } else if (i == 2) {
            nextFrame();
            return false;
        } else if (i == 3) {
            pause();
            return false;
        } else if (i != 4) {
            return false;
        } else {
            seek(message);
            return false;
        }
    }

    public void setProgressListener(ProgressListener progressListener) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "setProgressListener progressListener = " + progressListener);
        }
        this.mProgressListener = progressListener;
    }

    public boolean isRunning() {
        return this.mIsRunning;
    }

    public void startSimulator(boolean z) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "startSimulator start = " + z);
        }
        if (z) {
            init();
        } else {
            release();
        }
    }

    public void play(boolean z) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "play = " + z);
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            this.mIsRunning = z;
            if (z) {
                this.mLastFrameTime = System.currentTimeMillis();
                this.mHandler.sendEmptyMessage(2);
                return;
            }
            handler.sendEmptyMessage(3);
        }
    }

    public void seekTo(int i) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "seekTo = " + i);
        }
        if (this.mHandler != null) {
            Message obtain = Message.obtain();
            obtain.what = 4;
            obtain.arg1 = i;
            this.mHandler.sendMessage(obtain);
        }
    }

    private void init() {
        if (this.mProtoSimulatorThread == null) {
            this.mProtoSimulatorThread = new HandlerThread("ProtoSimulatorThread");
            this.mProtoSimulatorThread.start();
            this.mHandler = new Handler(this.mProtoSimulatorThread.getLooper(), this);
            this.mHandler.sendEmptyMessage(1);
        }
    }

    private void release() {
        if (this.mProtoSimulatorThread != null) {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.removeMessages(1);
                this.mHandler.removeMessages(4);
                this.mHandler.removeMessages(3);
                this.mHandler.removeMessages(2);
                this.mHandler.removeCallbacksAndMessages(null);
            }
            this.mProtoSimulatorThread.quitSafely();
            this.mIsRunning = false;
            this.mOverallBuilder = null;
            this.mHandler = null;
            this.mProtoSimulatorThread = null;
        }
    }

    private void readProtoData() {
        try {
            String str = RootUtil.SD_CARD_NAVI_PATH + File.separator + "proto";
            if (L.ENABLE) {
                L.d(TAG, "dir = " + str);
            }
            File[] listFiles = new File(str).listFiles();
            Arrays.sort(listFiles, Comparator.comparing(new Function() { // from class: com.xiaopeng.montecarlo.navcore.sr.-$$Lambda$kCyoVs8f1BQue13GsNsOg7QJhsA
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return ((File) obj).getName();
                }
            }));
            this.mOverallBuilder = Overall.total_overall.newBuilder();
            if (listFiles != null) {
                if (L.ENABLE) {
                    L.d(TAG, "files = " + listFiles.length);
                }
                for (File file : listFiles) {
                    if (file.isFile() && file.exists()) {
                        if (L.ENABLE) {
                            L.d(TAG, "file = " + file.getName());
                        }
                        this.mOverallBuilder.addAllOverall(Overall.total_overall.parseFrom(new FileInputStream(file)).getOverallList());
                    }
                }
                this.mCount = this.mOverallBuilder.getOverallCount();
                if (L.ENABLE) {
                    L.d(TAG, "mOverallBuilder.getOverallCount() = " + this.mCount);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (L.ENABLE) {
                L.d(TAG, "thread is exception, exception = " + e.toString());
            }
        }
    }

    private void nextFrame() {
        int i = this.mCount;
        if (i <= 0 || this.mOverallBuilder == null) {
            return;
        }
        if (this.mProgress >= i) {
            this.mProgress = 0;
        }
        Overall.overall overall = this.mOverallBuilder.getOverall(this.mProgress);
        this.mProgress++;
        ProgressListener progressListener = this.mProgressListener;
        if (progressListener != null) {
            progressListener.onProgressChanged((this.mProgress * 100) / this.mCount);
        }
        if (overall != null) {
            if (isModifyProto()) {
                Overall.overall.Builder newBuilder = Overall.overall.newBuilder(overall);
                Primitives.StateManagement.Builder newBuilder2 = Primitives.StateManagement.newBuilder(overall.getSmInfo());
                if (this.mModifyProto.rd_10 > 0) {
                    newBuilder2.setRdmodulecom10State(this.mModifyProto.rd_10);
                }
                if (this.mModifyProto.rd_11 > 0) {
                    newBuilder2.setRdmodulecom11State(this.mModifyProto.rd_11);
                }
                if (this.mModifyProto.rd_14 > 0) {
                    newBuilder2.setRdmodulecom14State(this.mModifyProto.rd_14);
                }
                if (this.mModifyProto.rd_15 > 0) {
                    newBuilder2.setRdmodulecom15State(this.mModifyProto.rd_15);
                }
                if (this.mModifyProto.rd_16 > 0) {
                    newBuilder2.setRdmodulecom16State(this.mModifyProto.rd_16);
                }
                newBuilder.setSmInfo(newBuilder2);
                overall = newBuilder.build();
            }
            SRNaviManager.getInstance().simulatorProto(overall);
            String stringUtf8 = overall.getXpPosInfo() == null ? "" : overall.getXpPosInfo().toStringUtf8();
            if (!TextUtils.isEmpty(stringUtf8)) {
                XPPosInfo xPPosInfo = (XPPosInfo) GsonUtil.fromJson(stringUtf8, (Class<Object>) XPPosInfo.class);
                try {
                    JSONObject jSONObject = new JSONObject(stringUtf8).getJSONObject("mGnss").getJSONObject("stPt");
                    xPPosInfo.getGnss().point.lat = jSONObject.getDouble(CPSearchParam.PARAM_KEY_LAT);
                    xPPosInfo.getGnss().point.lon = jSONObject.getDouble(CPSearchParam.PARAM_KEY_LON);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (xPPosInfo != null) {
                    TBTManager.getInstance().getPosServiceWrapper().setAllPos(xPPosInfo);
                } else {
                    L.w(TAG, "The version of proto data is too old, please use newer. xpPosInfo = " + stringUtf8);
                }
            } else {
                L.w(TAG, "The version of proto data is too old, please use newer. xpPosInfo == null");
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j = (this.mLastFrameTime + 45) - currentTimeMillis;
            this.mLastFrameTime = currentTimeMillis;
            if (j < -45 && L.ENABLE) {
                L.w(TAG, "nextFrame cost too much time = " + (45 - j));
            }
            Handler handler = this.mHandler;
            if (handler != null) {
                if (j < 0) {
                    j = 0;
                }
                handler.sendEmptyMessageDelayed(2, j);
                return;
            }
            return;
        }
        nextFrame();
    }

    private void seek(Message message) {
        this.mProgress = (int) ((message.arg1 * this.mCount) / 100.0f);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "seekTo, arg1 = " + message.arg1 + ", mCount = " + this.mCount + ", mProgress = " + this.mProgress);
        }
    }

    private void pause() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeMessages(2);
        }
    }
}
