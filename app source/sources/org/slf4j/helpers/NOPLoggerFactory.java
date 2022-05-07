package org.slf4j.helpers;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

public class NOPLoggerFactory implements ILoggerFactory {
    public NOPLoggerFactory() {
    }

    public Logger getLogger(String str) {
        String str2 = str;
        return NOPLogger.NOP_LOGGER;
    }
}
