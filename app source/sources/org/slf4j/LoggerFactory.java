package org.slf4j;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.event.SubstituteLoggingEvent;
import org.slf4j.helpers.NOPLoggerFactory;
import org.slf4j.helpers.SubstituteLogger;
import org.slf4j.helpers.SubstituteLoggerFactory;
import org.slf4j.helpers.Util;
import org.slf4j.impl.StaticLoggerBinder;

public final class LoggerFactory {
    private static final String[] API_COMPATIBILITY_LIST;
    static final String CODES_PREFIX = "http://www.slf4j.org/codes.html";
    static boolean DETECT_LOGGER_NAME_MISMATCH = Util.safeGetBooleanSystemProperty(DETECT_LOGGER_NAME_MISMATCH_PROPERTY);
    static final String DETECT_LOGGER_NAME_MISMATCH_PROPERTY = "slf4j.detectLoggerNameMismatch";
    static final int FAILED_INITIALIZATION = 2;
    static volatile int INITIALIZATION_STATE = 0;
    static final String JAVA_VENDOR_PROPERTY = "java.vendor.url";
    static final String LOGGER_NAME_MISMATCH_URL = "http://www.slf4j.org/codes.html#loggerNameMismatch";
    static final String MULTIPLE_BINDINGS_URL = "http://www.slf4j.org/codes.html#multiple_bindings";
    static final NOPLoggerFactory NOP_FALLBACK_FACTORY;
    static final int NOP_FALLBACK_INITIALIZATION = 4;
    static final String NO_STATICLOGGERBINDER_URL = "http://www.slf4j.org/codes.html#StaticLoggerBinder";
    static final String NULL_LF_URL = "http://www.slf4j.org/codes.html#null_LF";
    static final int ONGOING_INITIALIZATION = 1;
    static final String REPLAY_URL = "http://www.slf4j.org/codes.html#replay";
    private static String STATIC_LOGGER_BINDER_PATH = "org/slf4j/impl/StaticLoggerBinder.class";
    static final String SUBSTITUTE_LOGGER_URL = "http://www.slf4j.org/codes.html#substituteLogger";
    static final SubstituteLoggerFactory SUBST_FACTORY;
    static final int SUCCESSFUL_INITIALIZATION = 3;
    static final int UNINITIALIZED = 0;
    static final String UNSUCCESSFUL_INIT_MSG = "org.slf4j.LoggerFactory in failed state. Original exception was thrown EARLIER. See also http://www.slf4j.org/codes.html#unsuccessfulInit";
    static final String UNSUCCESSFUL_INIT_URL = "http://www.slf4j.org/codes.html#unsuccessfulInit";
    static final String VERSION_MISMATCH = "http://www.slf4j.org/codes.html#version_mismatch";

    static {
        SubstituteLoggerFactory substituteLoggerFactory;
        NOPLoggerFactory nOPLoggerFactory;
        new SubstituteLoggerFactory();
        SUBST_FACTORY = substituteLoggerFactory;
        new NOPLoggerFactory();
        NOP_FALLBACK_FACTORY = nOPLoggerFactory;
        String[] strArr = new String[2];
        strArr[0] = "1.6";
        String[] strArr2 = strArr;
        strArr2[1] = "1.7";
        API_COMPATIBILITY_LIST = strArr2;
    }

    private LoggerFactory() {
    }

    static void reset() {
        INITIALIZATION_STATE = 0;
    }

    private static final void performInitialization() {
        bind();
        if (INITIALIZATION_STATE == 3) {
            versionSanityCheck();
        }
    }

    private static boolean messageContainsOrgSlf4jImplStaticLoggerBinder(String str) {
        String msg = str;
        if (msg == null) {
            return false;
        }
        if (msg.contains("org/slf4j/impl/StaticLoggerBinder")) {
            return true;
        }
        if (msg.contains("org.slf4j.impl.StaticLoggerBinder")) {
            return true;
        }
        return false;
    }

    private static final void bind() {
        Throwable th;
        Set<URL> staticLoggerBinderPathSet = null;
        try {
            if (!isAndroid()) {
                staticLoggerBinderPathSet = findPossibleStaticLoggerBinderPathSet();
                reportMultipleBindingAmbiguity(staticLoggerBinderPathSet);
            }
            StaticLoggerBinder singleton = StaticLoggerBinder.getSingleton();
            INITIALIZATION_STATE = 3;
            reportActualBinding(staticLoggerBinderPathSet);
            postBindCleanUp();
        } catch (NoClassDefFoundError e) {
            NoClassDefFoundError ncde = e;
            if (messageContainsOrgSlf4jImplStaticLoggerBinder(ncde.getMessage())) {
                INITIALIZATION_STATE = 4;
                Util.report("Failed to load class \"org.slf4j.impl.StaticLoggerBinder\".");
                Util.report("Defaulting to no-operation (NOP) logger implementation");
                Util.report("See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.");
                postBindCleanUp();
                return;
            }
            failedBinding(ncde);
            throw ncde;
        } catch (NoSuchMethodError e2) {
            NoSuchMethodError nsme = e2;
            String msg = nsme.getMessage();
            if (msg != null && msg.contains("org.slf4j.impl.StaticLoggerBinder.getSingleton()")) {
                INITIALIZATION_STATE = 2;
                Util.report("slf4j-api 1.6.x (or later) is incompatible with this binding.");
                Util.report("Your binding is version 1.5.5 or earlier.");
                Util.report("Upgrade your binding to version 1.6.x.");
            }
            throw nsme;
        } catch (Exception e3) {
            Exception e4 = e3;
            failedBinding(e4);
            Throwable th2 = th;
            new IllegalStateException("Unexpected initialization failure", e4);
            throw th2;
        } catch (Throwable th3) {
            postBindCleanUp();
            throw th3;
        }
    }

    private static void postBindCleanUp() {
        fixSubstituteLoggers();
        replayEvents();
        SUBST_FACTORY.clear();
    }

    /* JADX INFO: finally extract failed */
    private static void fixSubstituteLoggers() {
        SubstituteLoggerFactory substituteLoggerFactory = SUBST_FACTORY;
        SubstituteLoggerFactory substituteLoggerFactory2 = substituteLoggerFactory;
        synchronized (substituteLoggerFactory) {
            try {
                SUBST_FACTORY.postInitialization();
                for (SubstituteLogger substLogger : SUBST_FACTORY.getLoggers()) {
                    substLogger.setDelegate(getLogger(substLogger.getName()));
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                SubstituteLoggerFactory substituteLoggerFactory3 = substituteLoggerFactory2;
                throw th2;
            }
        }
    }

    static void failedBinding(Throwable t) {
        INITIALIZATION_STATE = 2;
        Util.report("Failed to instantiate SLF4J LoggerFactory", t);
    }

    private static void replayEvents() {
        List<SubstituteLoggingEvent> list;
        LinkedBlockingQueue<SubstituteLoggingEvent> queue = SUBST_FACTORY.getEventQueue();
        int queueSize = queue.size();
        int count = 0;
        new ArrayList<>(128);
        List<SubstituteLoggingEvent> eventList = list;
        while (queue.drainTo(eventList, 128) != 0) {
            for (SubstituteLoggingEvent event : eventList) {
                replaySingleEvent(event);
                int i = count;
                count++;
                if (i == 0) {
                    emitReplayOrSubstituionWarning(event, queueSize);
                }
            }
            eventList.clear();
        }
    }

    private static void emitReplayOrSubstituionWarning(SubstituteLoggingEvent substituteLoggingEvent, int i) {
        SubstituteLoggingEvent event = substituteLoggingEvent;
        int queueSize = i;
        if (event.getLogger().isDelegateEventAware()) {
            emitReplayWarning(queueSize);
        } else if (!event.getLogger().isDelegateNOP()) {
            emitSubstitutionWarning();
        }
    }

    private static void replaySingleEvent(SubstituteLoggingEvent substituteLoggingEvent) {
        Throwable th;
        SubstituteLoggingEvent event = substituteLoggingEvent;
        if (event != null) {
            SubstituteLogger substLogger = event.getLogger();
            String loggerName = substLogger.getName();
            if (substLogger.isDelegateNull()) {
                Throwable th2 = th;
                new IllegalStateException("Delegate logger cannot be null at this state.");
                throw th2;
            } else if (!substLogger.isDelegateNOP()) {
                if (substLogger.isDelegateEventAware()) {
                    substLogger.log(event);
                } else {
                    Util.report(loggerName);
                }
            }
        }
    }

    private static void emitSubstitutionWarning() {
        Util.report("The following set of substitute loggers may have been accessed");
        Util.report("during the initialization phase. Logging calls during this");
        Util.report("phase were not honored. However, subsequent logging calls to these");
        Util.report("loggers will work as normally expected.");
        Util.report("See also http://www.slf4j.org/codes.html#substituteLogger");
    }

    private static void emitReplayWarning(int eventCount) {
        StringBuilder sb;
        new StringBuilder();
        Util.report(sb.append("A number (").append(eventCount).append(") of logging calls during the initialization phase have been intercepted and are").toString());
        Util.report("now being replayed. These are subject to the filtering rules of the underlying logging system.");
        Util.report("See also http://www.slf4j.org/codes.html#replay");
    }

    private static final void versionSanityCheck() {
        StringBuilder sb;
        try {
            String requested = StaticLoggerBinder.REQUESTED_API_VERSION;
            boolean match = false;
            String[] strArr = API_COMPATIBILITY_LIST;
            int length = strArr.length;
            for (int i = 0; i < length; i++) {
                if (requested.startsWith(strArr[i])) {
                    match = true;
                }
            }
            if (!match) {
                new StringBuilder();
                Util.report(sb.append("The requested version ").append(requested).append(" by your slf4j binding is not compatible with ").append(Arrays.asList(API_COMPATIBILITY_LIST).toString()).toString());
                Util.report("See http://www.slf4j.org/codes.html#version_mismatch for further details.");
            }
        } catch (NoSuchFieldError e) {
            NoSuchFieldError noSuchFieldError = e;
        } catch (Throwable th) {
            Util.report("Unexpected problem occured during version sanity check", th);
        }
    }

    static Set<URL> findPossibleStaticLoggerBinderPathSet() {
        Set<URL> set;
        Enumeration<URL> paths;
        new LinkedHashSet();
        Set<URL> staticLoggerBinderPathSet = set;
        try {
            ClassLoader loggerFactoryClassLoader = LoggerFactory.class.getClassLoader();
            if (loggerFactoryClassLoader == null) {
                paths = ClassLoader.getSystemResources(STATIC_LOGGER_BINDER_PATH);
            } else {
                paths = loggerFactoryClassLoader.getResources(STATIC_LOGGER_BINDER_PATH);
            }
            while (paths.hasMoreElements()) {
                boolean add = staticLoggerBinderPathSet.add(paths.nextElement());
            }
        } catch (IOException e) {
            Util.report("Error getting resources from path", e);
        }
        return staticLoggerBinderPathSet;
    }

    private static boolean isAmbiguousStaticLoggerBinderPathSet(Set<URL> binderPathSet) {
        return binderPathSet.size() > 1;
    }

    private static void reportMultipleBindingAmbiguity(Set<URL> set) {
        StringBuilder sb;
        Set<URL> binderPathSet = set;
        if (isAmbiguousStaticLoggerBinderPathSet(binderPathSet)) {
            Util.report("Class path contains multiple SLF4J bindings.");
            for (URL path : binderPathSet) {
                new StringBuilder();
                Util.report(sb.append("Found binding in [").append(path).append("]").toString());
            }
            Util.report("See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
        }
    }

    private static boolean isAndroid() {
        String vendor = Util.safeGetSystemProperty(JAVA_VENDOR_PROPERTY);
        if (vendor == null) {
            return false;
        }
        return vendor.toLowerCase().contains("android");
    }

    private static void reportActualBinding(Set<URL> set) {
        StringBuilder sb;
        Set<URL> binderPathSet = set;
        if (binderPathSet != null && isAmbiguousStaticLoggerBinderPathSet(binderPathSet)) {
            new StringBuilder();
            Util.report(sb.append("Actual binding is of type [").append(StaticLoggerBinder.getSingleton().getLoggerFactoryClassStr()).append("]").toString());
        }
    }

    public static Logger getLogger(String name) {
        return getILoggerFactory().getLogger(name);
    }

    public static Logger getLogger(Class<?> cls) {
        Class<?> autoComputedCallingClass;
        Class<?> clazz = cls;
        Logger logger = getLogger(clazz.getName());
        if (DETECT_LOGGER_NAME_MISMATCH && (autoComputedCallingClass = Util.getCallingClass()) != null && nonMatchingClasses(clazz, autoComputedCallingClass)) {
            Object[] objArr = new Object[2];
            objArr[0] = logger.getName();
            Object[] objArr2 = objArr;
            objArr2[1] = autoComputedCallingClass.getName();
            Util.report(String.format("Detected logger name mismatch. Given name: \"%s\"; computed name: \"%s\".", objArr2));
            Util.report("See http://www.slf4j.org/codes.html#loggerNameMismatch for an explanation");
        }
        return logger;
    }

    private static boolean nonMatchingClasses(Class<?> clazz, Class<?> autoComputedCallingClass) {
        return !autoComputedCallingClass.isAssignableFrom(clazz);
    }

    public static ILoggerFactory getILoggerFactory() {
        Throwable th;
        Throwable th2;
        if (INITIALIZATION_STATE == 0) {
            Class<LoggerFactory> cls = LoggerFactory.class;
            Class<LoggerFactory> cls2 = cls;
            synchronized (cls) {
                try {
                    if (INITIALIZATION_STATE == 0) {
                        INITIALIZATION_STATE = 1;
                        performInitialization();
                    }
                } catch (Throwable th3) {
                    while (true) {
                        Throwable th4 = th3;
                        Class<LoggerFactory> cls3 = cls2;
                        throw th4;
                    }
                }
            }
        }
        switch (INITIALIZATION_STATE) {
            case 1:
                return SUBST_FACTORY;
            case 2:
                Throwable th5 = th;
                new IllegalStateException(UNSUCCESSFUL_INIT_MSG);
                throw th5;
            case 3:
                return StaticLoggerBinder.getSingleton().getLoggerFactory();
            case 4:
                return NOP_FALLBACK_FACTORY;
            default:
                Throwable th6 = th2;
                new IllegalStateException("Unreachable code");
                throw th6;
        }
    }
}
