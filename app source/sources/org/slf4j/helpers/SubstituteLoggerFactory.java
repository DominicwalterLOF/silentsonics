package org.slf4j.helpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.event.SubstituteLoggingEvent;

public class SubstituteLoggerFactory implements ILoggerFactory {
    final LinkedBlockingQueue<SubstituteLoggingEvent> eventQueue;
    final Map<String, SubstituteLogger> loggers;
    boolean postInitialization = false;

    public SubstituteLoggerFactory() {
        Map<String, SubstituteLogger> map;
        LinkedBlockingQueue<SubstituteLoggingEvent> linkedBlockingQueue;
        new HashMap();
        this.loggers = map;
        new LinkedBlockingQueue<>();
        this.eventQueue = linkedBlockingQueue;
    }

    public synchronized Logger getLogger(String str) {
        SubstituteLogger substituteLogger;
        SubstituteLogger substituteLogger2;
        String name = str;
        synchronized (this) {
            SubstituteLogger logger = this.loggers.get(name);
            if (logger == null) {
                new SubstituteLogger(name, this.eventQueue, this.postInitialization);
                logger = substituteLogger2;
                SubstituteLogger put = this.loggers.put(name, logger);
            }
            substituteLogger = logger;
        }
        return substituteLogger;
    }

    public List<String> getLoggerNames() {
        List<String> list;
        new ArrayList(this.loggers.keySet());
        return list;
    }

    public List<SubstituteLogger> getLoggers() {
        List<SubstituteLogger> list;
        new ArrayList(this.loggers.values());
        return list;
    }

    public LinkedBlockingQueue<SubstituteLoggingEvent> getEventQueue() {
        return this.eventQueue;
    }

    public void postInitialization() {
        this.postInitialization = true;
    }

    public void clear() {
        this.loggers.clear();
        this.eventQueue.clear();
    }
}
