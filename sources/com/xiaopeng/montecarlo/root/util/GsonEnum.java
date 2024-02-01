package com.xiaopeng.montecarlo.root.util;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.Enum;
import java.lang.reflect.Type;
/* loaded from: classes3.dex */
public interface GsonEnum<E extends Enum<E>> extends JsonSerializer<E>, JsonDeserializer<E> {
    String getValue();

    E parse(String str);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.gson.JsonSerializer
    /* bridge */ /* synthetic */ default JsonElement serialize(Object obj, Type type, JsonSerializationContext jsonSerializationContext) {
        return serialize((GsonEnum<E>) ((Enum) obj), type, jsonSerializationContext);
    }

    default JsonElement serialize(E e, Type type, JsonSerializationContext jsonSerializationContext) {
        return jsonSerializationContext.serialize(getValue());
    }

    @Override // com.google.gson.JsonDeserializer
    default E deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return parse(jsonElement.getAsString());
    }
}
