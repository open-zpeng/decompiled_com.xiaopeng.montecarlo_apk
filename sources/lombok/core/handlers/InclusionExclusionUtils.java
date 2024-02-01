package lombok.core.handlers;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.core.AST;
import lombok.core.AnnotationValues;
import lombok.core.LombokNode;
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/core/handlers/InclusionExclusionUtils.SCL.lombok */
public class InclusionExclusionUtils {
    private static List<Integer> createListOfNonExistentFields(List<String> list, LombokNode<?, ?, ?> type, boolean excludeStandard, boolean excludeTransient) {
        boolean[] matched = new boolean[list.size()];
        Iterator<?> it = type.down().iterator();
        while (it.hasNext()) {
            LombokNode<?, ?, ?> child = (LombokNode) it.next();
            if (list.isEmpty()) {
                break;
            } else if (child.getKind() == AST.Kind.FIELD && (!excludeStandard || (!child.isStatic() && !child.getName().startsWith("$")))) {
                if (!excludeTransient || !child.isTransient()) {
                    int idx = list.indexOf(child.getName());
                    if (idx > -1) {
                        matched[idx] = true;
                    }
                }
            }
        }
        List<Integer> problematic = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (!matched[i]) {
                problematic.add(Integer.valueOf(i));
            }
        }
        return problematic;
    }

    public static void checkForBogusFieldNames(LombokNode<?, ?, ?> type, AnnotationValues<?> annotation, List<String> excludes, List<String> includes) {
        if (excludes != null && !excludes.isEmpty()) {
            for (Integer num : createListOfNonExistentFields(excludes, type, true, false)) {
                int i = num.intValue();
                if (annotation != null) {
                    annotation.setWarning("exclude", "This field does not exist, or would have been excluded anyway.", i);
                }
            }
        }
        if (includes != null && !includes.isEmpty()) {
            for (Integer num2 : createListOfNonExistentFields(includes, type, false, false)) {
                int i2 = num2.intValue();
                if (annotation != null) {
                    annotation.setWarning("of", "This field does not exist.", i2);
                }
            }
        }
    }

    /* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/core/handlers/InclusionExclusionUtils$Included.SCL.lombok */
    public static class Included<L, I extends Annotation> {
        private final L node;
        private final I inc;
        private final boolean defaultInclude;
        private final boolean explicitRank;

        public Included(L node, I inc, boolean defaultInclude, boolean explicitRank) {
            this.node = node;
            this.inc = inc;
            this.defaultInclude = defaultInclude;
            this.explicitRank = explicitRank;
        }

        public L getNode() {
            return this.node;
        }

        public I getInc() {
            return this.inc;
        }

        public boolean isDefaultInclude() {
            return this.defaultInclude;
        }

        public boolean hasExplicitRank() {
            return this.explicitRank;
        }
    }

    private static String innerAnnName(Class<? extends Annotation> type) {
        String name = type.getSimpleName();
        Class<?> enclosingClass = type.getEnclosingClass();
        while (true) {
            Class<?> c = enclosingClass;
            if (c != null) {
                name = String.valueOf(c.getSimpleName()) + "." + name;
                enclosingClass = c.getEnclosingClass();
            } else {
                return name;
            }
        }
    }

    private static <A extends AST<A, L, N>, L extends LombokNode<A, L, N>, N, I extends Annotation> List<Included<L, I>> handleIncludeExcludeMarking(Class<I> inclType, String replaceName, Class<? extends Annotation> exclType, LombokNode<A, L, N> typeNode, AnnotationValues<?> annotation, LombokNode<A, L, N> annotationNode, boolean includeTransient) {
        List<String> oldExcludes = (annotation == null || !annotation.isExplicit("exclude")) ? null : annotation.getAsStringList("exclude");
        List<String> oldIncludes = (annotation == null || !annotation.isExplicit("of")) ? null : annotation.getAsStringList("of");
        boolean onlyExplicitlyIncluded = annotation != null ? annotation.getAsBoolean("onlyExplicitlyIncluded") : false;
        boolean memberAnnotationMode = onlyExplicitlyIncluded;
        List<Included<L, I>> members = new ArrayList<>();
        List<String> namesToAutoExclude = new ArrayList<>();
        if (typeNode == null || typeNode.getKind() != AST.Kind.TYPE) {
            return null;
        }
        checkForBogusFieldNames(typeNode, annotation, oldExcludes, oldIncludes);
        if (oldExcludes != null && oldIncludes != null) {
            oldExcludes = null;
            if (annotation != null) {
                annotation.setWarning("exclude", "exclude and of are mutually exclusive; the 'exclude' parameter will be ignored.");
            }
        }
        Iterator<L> it = typeNode.down().iterator();
        while (it.hasNext()) {
            L child = it.next();
            boolean markExclude = child.getKind() == AST.Kind.FIELD && child.hasAnnotation(exclType);
            AnnotationValues<I> markInclude = null;
            if (child.getKind() == AST.Kind.FIELD || child.getKind() == AST.Kind.METHOD) {
                markInclude = child.findAnnotation(inclType);
            }
            if (markExclude || markInclude != null) {
                memberAnnotationMode = true;
            }
            if (markInclude != null && markExclude) {
                child.addError("@" + innerAnnName(exclType) + " and @" + innerAnnName(inclType) + " are mutually exclusive; the @Include annotation will be ignored");
                markInclude = null;
            }
            String name = child.getName();
            if (markExclude) {
                if (onlyExplicitlyIncluded) {
                    child.addWarning("The @Exclude annotation is not needed; 'onlyExplicitlyIncluded' is set, so this member would be excluded anyway");
                } else if (child.isStatic()) {
                    child.addWarning("The @Exclude annotation is not needed; static fields aren't included anyway");
                } else if (name.startsWith("$")) {
                    child.addWarning("The @Exclude annotation is not needed; fields that start with $ aren't included anyway");
                }
            } else if (oldExcludes == null || !oldExcludes.contains(name)) {
                if (markInclude != null) {
                    I inc = markInclude.getInstance();
                    if (child.getKind() == AST.Kind.METHOD) {
                        if (child.countMethodParameters() > 0) {
                            child.addError("Methods included with @" + innerAnnName(inclType) + " must have no arguments; it will not be included");
                        } else {
                            String n = replaceName != null ? markInclude.getAsString(replaceName) : "";
                            if (n.isEmpty()) {
                                n = name;
                            }
                            namesToAutoExclude.add(n);
                        }
                    }
                    members.add(new Included<>(child, inc, false, markInclude.isExplicit("rank")));
                } else if (!onlyExplicitlyIncluded) {
                    if (oldIncludes != null) {
                        if (child.getKind() == AST.Kind.FIELD && oldIncludes.contains(name)) {
                            members.add(new Included<>(child, null, false, false));
                        }
                    } else if (child.getKind() == AST.Kind.FIELD && !child.isStatic() && (!child.isTransient() || includeTransient)) {
                        if (!name.startsWith("$") && !child.isEnumMember()) {
                            members.add(new Included<>(child, null, true, false));
                        }
                    }
                }
            }
        }
        Iterator<Included<L, I>> it2 = members.iterator();
        while (it2.hasNext()) {
            Included<L, I> m = it2.next();
            if (m.isDefaultInclude() && namesToAutoExclude.contains(m.getNode().getName())) {
                it2.remove();
            }
        }
        if (annotation == null || !annotation.isExplicit("exclude")) {
            oldExcludes = null;
        }
        if (annotation == null || !annotation.isExplicit("of")) {
            oldIncludes = null;
        }
        if (memberAnnotationMode && (oldExcludes != null || oldIncludes != null)) {
            annotationNode.addError("The old-style 'exclude/of' parameter cannot be used together with the new-style @Include / @Exclude annotations.");
            return null;
        }
        return members;
    }

    public static <A extends AST<A, L, N>, L extends LombokNode<A, L, N>, N> List<Included<L, ToString.Include>> handleToStringMarking(LombokNode<A, L, N> typeNode, AnnotationValues<ToString> annotation, LombokNode<A, L, N> annotationNode) {
        List<Included<L, ToString.Include>> members = handleIncludeExcludeMarking(ToString.Include.class, "name", ToString.Exclude.class, typeNode, annotation, annotationNode, true);
        Collections.sort(members, new Comparator<Included<L, ToString.Include>>() { // from class: lombok.core.handlers.InclusionExclusionUtils.1
            @Override // java.util.Comparator
            public /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                return compare((Included) ((Included) obj), (Included) ((Included) obj2));
            }

            public int compare(Included<L, ToString.Include> a, Included<L, ToString.Include> b) {
                int ra = a.getInc() == null ? 0 : a.getInc().rank();
                int rb = b.getInc() == null ? 0 : b.getInc().rank();
                return InclusionExclusionUtils.compareRankOrPosition(ra, rb, (LombokNode) a.getNode(), (LombokNode) b.getNode());
            }
        });
        return members;
    }

    public static <A extends AST<A, L, N>, L extends LombokNode<A, L, N>, N> List<Included<L, EqualsAndHashCode.Include>> handleEqualsAndHashCodeMarking(LombokNode<A, L, N> typeNode, AnnotationValues<EqualsAndHashCode> annotation, LombokNode<A, L, N> annotationNode) {
        List<Included<L, EqualsAndHashCode.Include>> members = handleIncludeExcludeMarking(EqualsAndHashCode.Include.class, "replaces", EqualsAndHashCode.Exclude.class, typeNode, annotation, annotationNode, false);
        Collections.sort(members, new Comparator<Included<L, EqualsAndHashCode.Include>>() { // from class: lombok.core.handlers.InclusionExclusionUtils.2
            @Override // java.util.Comparator
            public /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                return compare((Included) ((Included) obj), (Included) ((Included) obj2));
            }

            public int compare(Included<L, EqualsAndHashCode.Include> a, Included<L, EqualsAndHashCode.Include> b) {
                int ra = a.hasExplicitRank() ? a.getInc().rank() : HandlerUtil.defaultEqualsAndHashcodeIncludeRank(((LombokNode) ((Included) a).node).fieldOrMethodBaseType());
                int rb = b.hasExplicitRank() ? b.getInc().rank() : HandlerUtil.defaultEqualsAndHashcodeIncludeRank(((LombokNode) ((Included) b).node).fieldOrMethodBaseType());
                return InclusionExclusionUtils.compareRankOrPosition(ra, rb, (LombokNode) a.getNode(), (LombokNode) b.getNode());
            }
        });
        return members;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <A extends AST<A, L, N>, L extends LombokNode<A, L, N>, N> int compareRankOrPosition(int ra, int rb, LombokNode<A, L, N> nodeA, LombokNode<A, L, N> nodeB) {
        int pa;
        int pb;
        if (ra < rb) {
            return 1;
        }
        if (ra <= rb && (pa = nodeA.getStartPos()) >= (pb = nodeB.getStartPos())) {
            return pa > pb ? 1 : 0;
        }
        return -1;
    }
}
