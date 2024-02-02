package com.xiaopeng.montecarlo.root.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.xiaopeng.montecarlo.root.util.L;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes2.dex */
public class GsonUtil {
    private static final L.Tag TAG = new L.Tag("GsonUtil");
    private static Gson sGSon = new GsonBuilder().registerTypeAdapterFactory(new CustomTypeAdapterFactory()).registerTypeAdapterFactory(new NullStringToEmptyAdapterFactory()).create();
    private static Gson sGsonExclude = new GsonBuilder().registerTypeAdapterFactory(new CustomTypeAdapterFactory()).excludeFieldsWithoutExposeAnnotation().create();
    private static Gson sGsonMap = new GsonBuilder().registerTypeAdapter(new TypeToken<Map<String, Object>>() { // from class: com.xiaopeng.montecarlo.root.util.GsonUtil.1
    }.getType(), new MapTypeAdapter()).create();

    public static Map<String, Object> fromJson2Map(String str) {
        return (Map) sGsonMap.fromJson(str, new TypeToken<Map<String, Object>>() { // from class: com.xiaopeng.montecarlo.root.util.GsonUtil.2
        }.getType());
    }

    public static String toJson(Object obj) {
        return sGSon.toJson(obj);
    }

    public static String toJson(Object obj, boolean z) {
        return (z ? sGsonExclude : sGSon).toJson(obj);
    }

    public static <T> T fromJson(String str, Class<T> cls) {
        try {
            return (T) sGSon.fromJson(str, (Class<Object>) cls);
        } catch (Exception e) {
            L.Tag tag = TAG;
            L.w(tag, e.getMessage() + ": " + str);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [T, java.lang.Object] */
    public static <T> T fromJson(String str, Class<T> cls, boolean z) {
        try {
            str = (T) (z ? sGsonExclude : sGSon).fromJson(str, (Class<Object>) cls);
            return str;
        } catch (Exception unused) {
            L.Tag tag = TAG;
            L.w(tag, "not json string: " + str);
            return null;
        }
    }

    public static <T> T fromJson(JsonElement jsonElement, Class<T> cls) {
        return (T) sGSon.fromJson(jsonElement, (Class<Object>) cls);
    }

    public static <T> T fromJson(JsonElement jsonElement, Class<T> cls, boolean z) {
        return (T) (z ? sGsonExclude : sGSon).fromJson(jsonElement, (Class<Object>) cls);
    }

    public static <T> T fromJson(String str, Type type) {
        try {
            return (T) sGSon.fromJson(str, type);
        } catch (JsonParseException e) {
            L.Tag tag = TAG;
            L.w(tag, "fromJson String exception : " + str + " e ：" + e.toString());
            return null;
        }
    }

    public static <T> T fromJson(JsonElement jsonElement, Type type) {
        try {
            return (T) sGSon.fromJson(jsonElement, type);
        } catch (JsonParseException e) {
            L.Tag tag = TAG;
            L.w(tag, "fromJson JsonElement exception : " + jsonElement + " e ：" + e.toString());
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public static class FloatAdapter extends TypeAdapter<Float> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Float read(JsonReader jsonReader) throws IOException {
            float f = 0.0f;
            if (jsonReader.peek() == JsonToken.STRING || jsonReader.peek() == JsonToken.NUMBER) {
                String nextString = jsonReader.nextString();
                try {
                    f = new BigDecimal(nextString).floatValue();
                } catch (Exception unused) {
                    L.Tag tag = GsonUtil.TAG;
                    L.w(tag, "FloatAdapter json error value:" + nextString);
                }
            } else {
                jsonReader.skipValue();
            }
            return Float.valueOf(f);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Float f) throws IOException {
            jsonWriter.value(f);
        }
    }

    /* loaded from: classes2.dex */
    public static class DoubleAdapter extends TypeAdapter<Double> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Double read(JsonReader jsonReader) throws IOException {
            double d = 0.0d;
            if (jsonReader.peek() == JsonToken.STRING || jsonReader.peek() == JsonToken.NUMBER) {
                String nextString = jsonReader.nextString();
                try {
                    d = new BigDecimal(nextString).doubleValue();
                } catch (Exception unused) {
                    L.Tag tag = GsonUtil.TAG;
                    L.w(tag, "DoubleAdapter json error value:" + nextString);
                }
            } else {
                jsonReader.skipValue();
            }
            return Double.valueOf(d);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Double d) throws IOException {
            jsonWriter.value(d);
        }
    }

    /* loaded from: classes2.dex */
    public static class CustomTypeAdapterFactory<T> implements TypeAdapterFactory {
        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            Class<? super T> rawType = typeToken.getRawType();
            if (rawType == Float.class || rawType == Float.TYPE) {
                return new FloatAdapter();
            }
            if (rawType == Double.class || rawType == Double.TYPE) {
                return new DoubleAdapter();
            }
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public static class NullStringToEmptyAdapterFactory<T> implements TypeAdapterFactory {
        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() != String.class) {
                return null;
            }
            return new StringNullAdapter();
        }
    }

    /* loaded from: classes2.dex */
    public static class MapTypeAdapter extends TypeAdapter<Object> {
        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Object obj) throws IOException {
        }

        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader jsonReader) throws IOException {
            switch (jsonReader.peek()) {
                case BEGIN_ARRAY:
                    ArrayList arrayList = new ArrayList();
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        arrayList.add(read(jsonReader));
                    }
                    jsonReader.endArray();
                    return arrayList;
                case BEGIN_OBJECT:
                    LinkedTreeMap linkedTreeMap = new LinkedTreeMap();
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        linkedTreeMap.put(jsonReader.nextName(), read(jsonReader));
                    }
                    jsonReader.endObject();
                    return linkedTreeMap;
                case STRING:
                    return jsonReader.nextString();
                case NUMBER:
                    double nextDouble = jsonReader.nextDouble();
                    if (nextDouble > 9.223372036854776E18d) {
                        return Double.valueOf(nextDouble);
                    }
                    long j = (long) nextDouble;
                    if (nextDouble == j) {
                        return Long.valueOf(j);
                    }
                    return Double.valueOf(nextDouble);
                case BOOLEAN:
                    return Boolean.valueOf(jsonReader.nextBoolean());
                case NULL:
                    jsonReader.nextNull();
                    return null;
                default:
                    throw new IllegalStateException();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class StringNullAdapter extends TypeAdapter<String> {
        @Override // com.google.gson.TypeAdapter
        public String read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return "";
            }
            String nextString = jsonReader.nextString();
            return "null".equals(nextString) ? "" : nextString;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, String str) throws IOException {
            if (str == null) {
                jsonWriter.nullValue();
            } else if ("null".equals(str)) {
                jsonWriter.value("");
            } else {
                jsonWriter.value(str);
            }
        }
    }
}
