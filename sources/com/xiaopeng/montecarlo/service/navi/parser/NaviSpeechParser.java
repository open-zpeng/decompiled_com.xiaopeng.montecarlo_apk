package com.xiaopeng.montecarlo.service.navi.parser;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.xiaopeng.lib.apirouter.server.IServicePublisher;
import com.xiaopeng.lib.apirouter.server.Publish;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.service.navi.INaviParser;
import com.xiaopeng.montecarlo.service.navi.IRequestEventCallback;
import com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand;
import com.xiaopeng.montecarlo.speech.manager.MergeException;
import com.xiaopeng.montecarlo.speech.manager.NaviSpeechManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public final class NaviSpeechParser implements INaviParser, IServicePublisher {
    private static final L.Tag TAG = new L.Tag("NaviSpeechParser");

    @Override // com.xiaopeng.montecarlo.service.navi.INaviParser
    public void onCreate(@NonNull Context context) {
    }

    @Publish
    public void handleSpeechCmdFromApiRouter(final String str) {
        L.Tag tag = TAG;
        L.i(tag, "handleSpeechCmdFromApiRouter, content=" + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        UiHandlerUtil.getInstance().runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.service.navi.parser.NaviSpeechParser.1
            @Override // java.lang.Runnable
            public void run() {
                NaviSpeechParser.this.handleSpeechCmd(str);
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.service.navi.INaviParser
    @Deprecated
    public void onHandleEvent(@NonNull Context context, @NonNull String str, @NonNull IRequestEventCallback iRequestEventCallback) {
        handleSpeechCmd(str);
        iRequestEventCallback.allWorkEnd();
    }

    public void handleSpeechCmd(String str) {
        List<BaseSpeechCommand> createCommands = NaviSpeechManager.getInstance().getSpeechSchedue().createCommands(str);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "createCommands: " + getCommandListStr(createCommands));
        }
        handleCommandList(createCommands);
    }

    public void handleCommandList(List<BaseSpeechCommand> list) {
        if (list == null) {
            L.w(TAG, "handleCommandList, commands is null");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        List<BaseSpeechCommand> fixCommands = fixCommands(list);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "fixCommands: " + getCommandListStr(fixCommands));
        }
        List<BaseSpeechCommand> mergeCommands = mergeCommands(fixCommands);
        if (L.ENABLE) {
            L.Tag tag2 = TAG;
            L.d(tag2, "mergeCommands: " + getCommandListStr(mergeCommands));
        }
        List<BaseSpeechCommand> sortCommands = sortCommands(mergeCommands);
        if (L.ENABLE) {
            L.Tag tag3 = TAG;
            L.d(tag3, "sortCommands: " + getCommandListStr(sortCommands));
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        L.Tag tag4 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("handleCommandList cost ");
        sb.append(currentTimeMillis2 - currentTimeMillis);
        sb.append(" ms to create operate list, list size=");
        sb.append(sortCommands != null ? Integer.valueOf(sortCommands.size()) : "null");
        L.i(tag4, sb.toString());
        if (sortCommands != null) {
            NaviSpeechManager.getInstance().getSpeechSchedue().scheduleCommands(sortCommands);
        }
    }

    private String getCommandListStr(List<BaseSpeechCommand> list) {
        if (list == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        for (BaseSpeechCommand baseSpeechCommand : list) {
            sb.append(baseSpeechCommand.getClass().getSimpleName());
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    private List<BaseSpeechCommand> fixCommands(List<BaseSpeechCommand> list) {
        if (list == null) {
            L.w(TAG, "fixCommands failed, commands is null");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        for (BaseSpeechCommand baseSpeechCommand : list) {
            List<Class<? extends BaseSpeechCommand>> fixContextList = baseSpeechCommand.getFixContextList();
            if (fixContextList != null) {
                for (int i = 0; i < fixContextList.size(); i++) {
                    Class<? extends BaseSpeechCommand> cls = fixContextList.get(i);
                    if (BaseSpeechCommand.class.isAssignableFrom(cls)) {
                        try {
                            BaseSpeechCommand newInstance = cls.newInstance();
                            if (!newInstance.isAchieveGoals()) {
                                arrayList.add(newInstance);
                            }
                        } catch (IllegalAccessException | InstantiationException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        list.clear();
        return arrayList;
    }

    private List<BaseSpeechCommand> mergeCommands(List<BaseSpeechCommand> list) {
        if (list == null) {
            L.w(TAG, "mergeCommands failed, commands is null");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        ArrayList arrayList2 = new ArrayList(Collections.nCopies(arrayList.size(), false));
        ArrayList arrayList3 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            if (!((Boolean) arrayList2.get(i)).booleanValue()) {
                BaseSpeechCommand baseSpeechCommand = (BaseSpeechCommand) arrayList.get(i);
                arrayList2.set(i, true);
                ArrayList arrayList4 = new ArrayList();
                arrayList4.add(baseSpeechCommand);
                for (int i2 = i; i2 < arrayList.size(); i2++) {
                    if (!((Boolean) arrayList2.get(i2)).booleanValue()) {
                        BaseSpeechCommand baseSpeechCommand2 = (BaseSpeechCommand) arrayList.get(i2);
                        try {
                            if (baseSpeechCommand.canMergeCommand(baseSpeechCommand2) || baseSpeechCommand2.canMergeCommand(baseSpeechCommand)) {
                                arrayList2.set(i2, true);
                                arrayList4.add(baseSpeechCommand2);
                            }
                        } catch (MergeException unused) {
                            notifyMergeException(baseSpeechCommand, baseSpeechCommand2);
                            list.clear();
                            return null;
                        }
                    }
                }
                arrayList3.add(arrayList4);
            }
        }
        ArrayList arrayList5 = new ArrayList();
        Iterator it = arrayList3.iterator();
        while (it.hasNext()) {
            ArrayList arrayList6 = (ArrayList) it.next();
            if (!arrayList6.isEmpty()) {
                BaseSpeechCommand baseSpeechCommand3 = (BaseSpeechCommand) arrayList6.get(0);
                for (int i3 = 1; i3 < arrayList6.size(); i3++) {
                    baseSpeechCommand3 = baseSpeechCommand3.mergeCommand(arrayList6.get(i3));
                }
                arrayList5.add(baseSpeechCommand3);
            }
        }
        list.clear();
        return arrayList5;
    }

    private void notifyMergeException(BaseSpeechCommand baseSpeechCommand, BaseSpeechCommand baseSpeechCommand2) {
        L.Tag tag = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("merge conflict: ");
        sb.append(baseSpeechCommand != null ? baseSpeechCommand.getClass().getSimpleName() : null);
        sb.append(" ");
        sb.append(baseSpeechCommand2 != null ? baseSpeechCommand2.getClass().getSimpleName() : null);
        L.w(tag, sb.toString());
    }

    private List<BaseSpeechCommand> sortCommands(List<BaseSpeechCommand> list) {
        if (list == null) {
            L.w(TAG, "sortCommands failed, commands is null");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        Collections.sort(arrayList, new Comparator<BaseSpeechCommand>() { // from class: com.xiaopeng.montecarlo.service.navi.parser.NaviSpeechParser.2
            @Override // java.util.Comparator
            public int compare(BaseSpeechCommand baseSpeechCommand, BaseSpeechCommand baseSpeechCommand2) {
                if (baseSpeechCommand == null || baseSpeechCommand2 == null) {
                    return 0;
                }
                return baseSpeechCommand.getPriority() > baseSpeechCommand2.getPriority() ? 1 : -1;
            }
        });
        list.clear();
        return arrayList;
    }
}
