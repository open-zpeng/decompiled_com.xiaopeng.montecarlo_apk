package lombok.eclipse.agent;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import lombok.patcher.ClassRootFinder;
import lombok.patcher.Hook;
import lombok.patcher.MethodTarget;
import lombok.patcher.ScriptManager;
import lombok.patcher.StackRequest;
import lombok.patcher.scripts.ScriptBuilder;
/* loaded from: xp_Montecarlo-benchEdward.apk:lombok/eclipse/agent/EclipseLoaderPatcher.SCL.lombok */
public class EclipseLoaderPatcher {
    private static final String TRANSPLANTS_CLASS_NAME = "lombok.eclipse.agent.EclipseLoaderPatcherTransplants";
    static final String[] OSGI_TYPES = {"org/eclipse/osgi/internal/baseadaptor/DefaultClassLoader", "org/eclipse/osgi/framework/adapter/core/AbstractClassLoader", "org/eclipse/osgi/internal/loader/ModuleClassLoader"};

    public static void patchEquinoxLoaders(ScriptManager sm, Class<?> launchingContext) {
        sm.addScript(ScriptBuilder.exitEarly().target(new MethodTarget("org.eclipse.osgi.internal.baseadaptor.DefaultClassLoader", "loadClass", "java.lang.Class", "java.lang.String", TypedValues.Custom.S_BOOLEAN)).target(new MethodTarget("org.eclipse.osgi.framework.adapter.core.AbstractClassLoader", "loadClass", "java.lang.Class", "java.lang.String", TypedValues.Custom.S_BOOLEAN)).target(new MethodTarget("org.eclipse.osgi.internal.loader.ModuleClassLoader", "loadClass", "java.lang.Class", "java.lang.String", TypedValues.Custom.S_BOOLEAN)).decisionMethod(new Hook(TRANSPLANTS_CLASS_NAME, "overrideLoadDecide", TypedValues.Custom.S_BOOLEAN, "java.lang.ClassLoader", "java.lang.String", TypedValues.Custom.S_BOOLEAN)).valueMethod(new Hook(TRANSPLANTS_CLASS_NAME, "overrideLoadResult", "java.lang.Class", "java.lang.ClassLoader", "java.lang.String", TypedValues.Custom.S_BOOLEAN)).transplant().request(StackRequest.THIS, StackRequest.PARAM1, StackRequest.PARAM2).build());
        sm.addScript(ScriptBuilder.addField().setPublic().setVolatile().fieldType("Ljava/lang/ClassLoader;").fieldName("lombok$shadowLoader").targetClass("org.eclipse.osgi.internal.baseadaptor.DefaultClassLoader").targetClass("org.eclipse.osgi.framework.adapter.core.AbstractClassLoader").targetClass("org.eclipse.osgi.internal.loader.ModuleClassLoader").build());
        sm.addScript(ScriptBuilder.addField().setPublic().setVolatile().setStatic().fieldType("Ljava/lang/Class;").fieldName("lombok$shadowLoaderClass").targetClass("org.eclipse.osgi.internal.baseadaptor.DefaultClassLoader").targetClass("org.eclipse.osgi.framework.adapter.core.AbstractClassLoader").targetClass("org.eclipse.osgi.internal.loader.ModuleClassLoader").build());
        sm.addScript(ScriptBuilder.addField().setPublic().setStatic().setFinal().fieldType("Ljava/lang/String;").fieldName("lombok$location").targetClass("org.eclipse.osgi.internal.baseadaptor.DefaultClassLoader").targetClass("org.eclipse.osgi.framework.adapter.core.AbstractClassLoader").targetClass("org.eclipse.osgi.internal.loader.ModuleClassLoader").value(ClassRootFinder.findClassRootOfClass(launchingContext)).build());
    }
}
