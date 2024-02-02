package com.xiaopeng.montecarlo.speech.command;

import com.xiaopeng.montecarlo.speech.manager.MergeException;
import java.util.List;
/* loaded from: classes3.dex */
public interface ICommandFunction {
    <T extends BaseSpeechCommand> boolean canMergeCommand(T t);

    List<Class<? extends BaseSpeechCommand>> getFixContextList();

    <T, S extends BaseSpeechCommand> S mergeCommand(T t) throws MergeException;
}
