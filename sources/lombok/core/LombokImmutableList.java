package lombok.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/core/LombokImmutableList.SCL.lombok */
public final class LombokImmutableList<T> implements Iterable<T> {
    private Object[] content;
    private static final LombokImmutableList<?> EMPTY = new LombokImmutableList<>(new Object[0]);

    public static <T> LombokImmutableList<T> of() {
        return (LombokImmutableList<T>) EMPTY;
    }

    public static <T> LombokImmutableList<T> of(T a) {
        return new LombokImmutableList<>(new Object[]{a});
    }

    public static <T> LombokImmutableList<T> of(T a, T b) {
        return new LombokImmutableList<>(new Object[]{a, b});
    }

    public static <T> LombokImmutableList<T> of(T a, T b, T c) {
        return new LombokImmutableList<>(new Object[]{a, b, c});
    }

    public static <T> LombokImmutableList<T> of(T a, T b, T c, T d) {
        return new LombokImmutableList<>(new Object[]{a, b, c, d});
    }

    public static <T> LombokImmutableList<T> of(T a, T b, T c, T d, T e) {
        return new LombokImmutableList<>(new Object[]{a, b, c, d, e});
    }

    public static <T> LombokImmutableList<T> of(T a, T b, T c, T d, T e, T f, T... tArr) {
        Object[] rest = tArr == null ? new Object[1] : tArr;
        Object[] val = new Object[rest.length + 6];
        System.arraycopy(rest, 0, val, 6, rest.length);
        val[0] = a;
        val[1] = b;
        val[2] = c;
        val[3] = d;
        val[4] = e;
        val[5] = f;
        return new LombokImmutableList<>(val);
    }

    public static <T> LombokImmutableList<T> copyOf(Collection<? extends T> list) {
        return new LombokImmutableList<>(list.toArray());
    }

    public static <T> LombokImmutableList<T> copyOf(Iterable<? extends T> iterable) {
        List<T> list = new ArrayList<>();
        for (T o : iterable) {
            list.add(o);
        }
        return copyOf((Collection) list);
    }

    public static <T> LombokImmutableList<T> copyOf(T[] tArr) {
        Object[] content = new Object[tArr.length];
        System.arraycopy(tArr, 0, content, 0, tArr.length);
        return new LombokImmutableList<>(content);
    }

    private LombokImmutableList(Object[] content) {
        this.content = content;
    }

    public LombokImmutableList<T> replaceElementAt(int idx, T newValue) {
        Object[] newContent = (Object[]) this.content.clone();
        newContent[idx] = newValue;
        return new LombokImmutableList<>(newContent);
    }

    public LombokImmutableList<T> append(T newValue) {
        int len = this.content.length;
        Object[] newContent = new Object[len + 1];
        System.arraycopy(this.content, 0, newContent, 0, len);
        newContent[len] = newValue;
        return new LombokImmutableList<>(newContent);
    }

    public LombokImmutableList<T> prepend(T newValue) {
        int len = this.content.length;
        Object[] newContent = new Object[len + 1];
        System.arraycopy(this.content, 0, newContent, 1, len);
        newContent[0] = newValue;
        return new LombokImmutableList<>(newContent);
    }

    public int indexOf(T val) {
        int len = this.content.length;
        if (val == null) {
            for (int i = 0; i < len; i++) {
                if (this.content[i] == null) {
                    return i;
                }
            }
            return -1;
        }
        for (int i2 = 0; i2 < len; i2++) {
            if (val.equals(this.content[i2])) {
                return i2;
            }
        }
        return -1;
    }

    public LombokImmutableList<T> removeElement(T val) {
        int idx = indexOf(val);
        return idx == -1 ? this : removeElementAt(idx);
    }

    public LombokImmutableList<T> removeElementAt(int idx) {
        int len = this.content.length;
        Object[] newContent = new Object[len - 1];
        if (idx > 0) {
            System.arraycopy(this.content, 0, newContent, 0, idx);
        }
        if (idx < len - 1) {
            System.arraycopy(this.content, idx + 1, newContent, idx, (len - idx) - 1);
        }
        return new LombokImmutableList<>(newContent);
    }

    public boolean isEmpty() {
        return this.content.length == 0;
    }

    public int size() {
        return this.content.length;
    }

    public T get(int idx) {
        return (T) this.content[idx];
    }

    public boolean contains(T in) {
        Object[] objArr;
        Object[] objArr2;
        if (in == null) {
            for (Object e : this.content) {
                if (e == null) {
                    return true;
                }
            }
            return false;
        }
        for (Object e2 : this.content) {
            if (in.equals(e2)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return new Iterator<T>() { // from class: lombok.core.LombokImmutableList.1
            private int idx = 0;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.idx < LombokImmutableList.this.content.length;
            }

            @Override // java.util.Iterator
            public T next() {
                if (this.idx < LombokImmutableList.this.content.length) {
                    Object[] objArr = LombokImmutableList.this.content;
                    int i = this.idx;
                    this.idx = i + 1;
                    return (T) objArr[i];
                }
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("List is immutable");
            }
        };
    }

    public String toString() {
        return Arrays.toString(this.content);
    }

    public boolean equals(Object obj) {
        if (obj instanceof LombokImmutableList) {
            if (obj == this) {
                return true;
            }
            return Arrays.equals(this.content, ((LombokImmutableList) obj).content);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.content);
    }
}
