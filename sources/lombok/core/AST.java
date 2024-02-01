package lombok.core;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import lombok.Lombok;
import lombok.core.AST;
import lombok.core.LombokNode;
import lombok.core.configuration.ConfigurationKey;
import lombok.core.debug.HistogramTracker;
import lombok.permit.Permit;
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/core/AST.SCL.lombok */
public abstract class AST<A extends AST<A, L, N>, L extends LombokNode<A, L, N>, N> {
    private L top;
    private final String fileName;
    private final String packageDeclaration;
    private final ImportList imports;
    private TypeResolver importsAsResolver;
    Map<N, N> identityDetector = new IdentityHashMap();
    private Map<N, L> nodeMap = new IdentityHashMap();
    private boolean changed = false;
    private final Collection<Class<? extends N>> statementTypes;
    private static final HistogramTracker configTracker;
    private static final ConcurrentMap<Class<?>, FieldAccess[]> fieldsOfASTClasses;

    /* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/core/AST$Kind.SCL.lombok */
    public enum Kind {
        COMPILATION_UNIT,
        TYPE,
        FIELD,
        INITIALIZER,
        METHOD,
        ANNOTATION,
        ARGUMENT,
        LOCAL,
        STATEMENT,
        TYPE_USE;

        /* renamed from: values  reason: to resolve conflict with enum method */
        public static Kind[] valuesCustom() {
            Kind[] valuesCustom = values();
            int length = valuesCustom.length;
            Kind[] kindArr = new Kind[length];
            System.arraycopy(valuesCustom, 0, kindArr, 0, length);
            return kindArr;
        }
    }

    public abstract URI getAbsoluteFileLocation();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract L buildTree(N n, Kind kind);

    static {
        configTracker = System.getProperty("lombok.timeConfig") == null ? null : new HistogramTracker("lombok.config");
        fieldsOfASTClasses = new ConcurrentHashMap();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AST(String fileName, String packageDeclaration, ImportList imports, Collection<Class<? extends N>> statementTypes) {
        this.fileName = fileName == null ? "(unknown).java" : fileName;
        this.packageDeclaration = packageDeclaration;
        this.imports = imports;
        this.statementTypes = statementTypes;
    }

    public void setChanged() {
        this.changed = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clearChanged() {
        this.changed = false;
    }

    public boolean isChanged() {
        return this.changed;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setTop(L top) {
        this.top = top;
    }

    public final String getPackageDeclaration() {
        return this.packageDeclaration;
    }

    public final ImportList getImportList() {
        return this.imports;
    }

    public final TypeResolver getImportListAsTypeResolver() {
        if (this.importsAsResolver != null) {
            return this.importsAsResolver;
        }
        TypeResolver typeResolver = new TypeResolver(getImportList());
        this.importsAsResolver = typeResolver;
        return typeResolver;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public L putInMap(L node) {
        this.nodeMap.put(node.get(), node);
        this.identityDetector.put(node.get(), node.get());
        return node;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Map<N, L> getNodeMap() {
        return this.nodeMap;
    }

    protected void clearState() {
        this.identityDetector = new IdentityHashMap();
        this.nodeMap = new IdentityHashMap();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean setAndGetAsHandled(N node) {
        return this.identityDetector.put(node, node) != null;
    }

    public String getFileName() {
        return this.fileName;
    }

    public L top() {
        return this.top;
    }

    public L get(N node) {
        return this.nodeMap.get(node);
    }

    public int getSourceVersion() {
        return 6;
    }

    public int getLatestJavaSpecSupported() {
        return 6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public L replaceNewWithExistingOld(Map<N, L> oldNodes, L newNode) {
        L oldNode = oldNodes.get(newNode.get());
        L targetNode = oldNode == null ? newNode : oldNode;
        List children = new ArrayList();
        Iterator<L> it = newNode.children.iterator();
        while (it.hasNext()) {
            L child = it.next();
            L oldChild = replaceNewWithExistingOld(oldNodes, child);
            children.add(oldChild);
            oldChild.parent = targetNode;
        }
        targetNode.children = LombokImmutableList.copyOf((Collection) children);
        return targetNode;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/core/AST$FieldAccess.SCL.lombok */
    public static class FieldAccess {
        public final Field field;
        public final int dim;

        FieldAccess(Field field, int dim) {
            this.field = field;
            this.dim = dim;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FieldAccess[] fieldsOf(Class<?> c) {
        FieldAccess[] fields = fieldsOfASTClasses.get(c);
        if (fields != null) {
            return fields;
        }
        List<FieldAccess> fieldList = new ArrayList<>();
        getFields(c, fieldList);
        fieldsOfASTClasses.putIfAbsent(c, (FieldAccess[]) fieldList.toArray(new FieldAccess[0]));
        return fieldsOfASTClasses.get(c);
    }

    private void getFields(Class<?> c, Collection<FieldAccess> fields) {
        Field[] declaredFields;
        if (c == Object.class || c == null) {
            return;
        }
        for (Field f : c.getDeclaredFields()) {
            if (!Modifier.isStatic(f.getModifiers())) {
                Class<?> t = f.getType();
                int dim = 0;
                if (t.isArray()) {
                    while (t.isArray()) {
                        dim++;
                        t = t.getComponentType();
                    }
                } else {
                    while (Collection.class.isAssignableFrom(t)) {
                        dim++;
                        t = getComponentType(f.getGenericType());
                    }
                }
                if (shouldDrill(c, t, f.getName())) {
                    Permit.setAccessible(f);
                    fields.add(new FieldAccess(f, dim));
                }
            }
        }
        getFields(c.getSuperclass(), fields);
    }

    private Class<?> getComponentType(Type type) {
        if (type instanceof ParameterizedType) {
            Type component = ((ParameterizedType) type).getActualTypeArguments()[0];
            return component instanceof Class ? (Class) component : Object.class;
        }
        return Object.class;
    }

    private boolean shouldDrill(Class<?> parentType, Class<?> childType, String fieldName) {
        for (Class<?> statementType : this.statementTypes) {
            if (statementType.isAssignableFrom(childType)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Collection<L> buildWithField(Class<L> nodeType, N statement, FieldAccess fa) {
        List<L> list = new ArrayList<>();
        buildWithField0(nodeType, statement, fa, list);
        return list;
    }

    protected boolean replaceStatementInNode(N statement, N oldN, N newN) {
        FieldAccess[] fieldsOf;
        for (FieldAccess fa : fieldsOf(statement.getClass())) {
            if (replaceStatementInField(fa, statement, oldN, newN)) {
                return true;
            }
        }
        return false;
    }

    private boolean replaceStatementInField(FieldAccess fa, N statement, N oldN, N newN) {
        try {
            Object o = fa.field.get(statement);
            if (o == null) {
                return false;
            }
            if (o == oldN) {
                fa.field.set(statement, newN);
                return true;
            } else if (fa.dim > 0) {
                if (o.getClass().isArray()) {
                    return replaceStatementInArray(o, oldN, newN);
                }
                if (Collection.class.isInstance(o)) {
                    return replaceStatementInCollection(fa.field, statement, new ArrayList(), (Collection) o, oldN, newN);
                }
                return false;
            } else {
                return false;
            }
        } catch (IllegalAccessException e) {
            throw Lombok.sneakyThrow(e);
        }
    }

    private boolean replaceStatementInCollection(Field field, Object fieldRef, List<Collection<?>> chain, Collection<?> collection, N oldN, N newN) throws IllegalAccessException {
        if (collection == null) {
            return false;
        }
        int idx = -1;
        for (Object o : collection) {
            idx++;
            if (o != null) {
                if (Collection.class.isInstance(o)) {
                    Collection<?> newC = (Collection) o;
                    List<Collection<?>> newChain = new ArrayList<>(chain);
                    newChain.add(newC);
                    if (replaceStatementInCollection(field, fieldRef, newChain, newC, oldN, newN)) {
                        return true;
                    }
                }
                if (o == oldN) {
                    setElementInASTCollection(field, fieldRef, chain, collection, idx, newN);
                    return true;
                }
            }
        }
        return false;
    }

    protected void setElementInASTCollection(Field field, Object fieldRef, List<Collection<?>> chain, Collection<?> collection, int idx, N newN) throws IllegalAccessException {
        if (collection instanceof List) {
            ((List) collection).set(idx, newN);
        }
    }

    private boolean replaceStatementInArray(Object array, N oldN, N newN) {
        if (array == null) {
            return false;
        }
        int len = Array.getLength(array);
        for (int i = 0; i < len; i++) {
            Object o = Array.get(array, i);
            if (o != null) {
                if (o.getClass().isArray()) {
                    if (replaceStatementInArray(o, oldN, newN)) {
                        return true;
                    }
                } else if (o == oldN) {
                    Array.set(array, i, newN);
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void buildWithField0(Class<L> nodeType, N child, FieldAccess fa, Collection<L> list) {
        try {
            Object o = fa.field.get(child);
            if (o == null) {
                return;
            }
            if (fa.dim == 0) {
                L node = buildTree(o, Kind.STATEMENT);
                if (node != null) {
                    list.add(nodeType.cast(node));
                }
            } else if (o.getClass().isArray()) {
                buildWithArray(nodeType, o, list, fa.dim);
            } else if (Collection.class.isInstance(o)) {
                buildWithCollection(nodeType, o, list, fa.dim);
            }
        } catch (IllegalAccessException e) {
            throw Lombok.sneakyThrow(e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void buildWithArray(Class<L> nodeType, Object array, Collection<L> list, int dim) {
        Object v;
        Object[] objArr;
        L node;
        if (dim == 1) {
            for (Object v2 : (Object[]) array) {
                if (v2 != null && (node = buildTree(v2, Kind.STATEMENT)) != null) {
                    list.add(nodeType.cast(node));
                }
            }
            return;
        }
        Object[] objArr2 = (Object[]) array;
        int length = objArr2.length;
        for (int i = 0; i < length && (v = objArr2[i]) != null; i++) {
            buildWithArray(nodeType, v, list, dim - 1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void buildWithCollection(Class<L> nodeType, Object collection, Collection<L> list, int dim) {
        L node;
        if (dim == 1) {
            for (Object v : (Collection) collection) {
                if (v != null && (node = buildTree(v, Kind.STATEMENT)) != null) {
                    list.add(nodeType.cast(node));
                }
            }
            return;
        }
        for (Object v2 : (Collection) collection) {
            buildWithCollection(nodeType, v2, list, dim - 1);
        }
    }

    public final <T> T readConfiguration(ConfigurationKey<T> key) {
        long start = configTracker == null ? 0L : configTracker.start();
        try {
            T t = (T) LombokConfiguration.read((ConfigurationKey<Object>) key, (AST<?, ?, ?>) this);
            if (configTracker != null) {
                configTracker.end(start);
            }
            return t;
        } catch (Throwable th) {
            if (configTracker != null) {
                configTracker.end(start);
            }
            throw th;
        }
    }
}
