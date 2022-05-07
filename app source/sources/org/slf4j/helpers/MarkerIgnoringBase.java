package org.slf4j.helpers;

import org.slf4j.Logger;
import org.slf4j.Marker;

public abstract class MarkerIgnoringBase extends NamedLoggerBase implements Logger {
    private static final long serialVersionUID = 9044267456635152283L;

    public MarkerIgnoringBase() {
    }

    public /* bridge */ /* synthetic */ String getName() {
        return super.getName();
    }

    public boolean isTraceEnabled(Marker marker) {
        Marker marker2 = marker;
        return isTraceEnabled();
    }

    public void trace(Marker marker, String msg) {
        Marker marker2 = marker;
        trace(msg);
    }

    public void trace(Marker marker, String format, Object arg) {
        Marker marker2 = marker;
        trace(format, arg);
    }

    public void trace(Marker marker, String format, Object arg1, Object arg2) {
        Marker marker2 = marker;
        trace(format, arg1, arg2);
    }

    public void trace(Marker marker, String format, Object... arguments) {
        Marker marker2 = marker;
        trace(format, arguments);
    }

    public void trace(Marker marker, String msg, Throwable t) {
        Marker marker2 = marker;
        trace(msg, t);
    }

    public boolean isDebugEnabled(Marker marker) {
        Marker marker2 = marker;
        return isDebugEnabled();
    }

    public void debug(Marker marker, String msg) {
        Marker marker2 = marker;
        debug(msg);
    }

    public void debug(Marker marker, String format, Object arg) {
        Marker marker2 = marker;
        debug(format, arg);
    }

    public void debug(Marker marker, String format, Object arg1, Object arg2) {
        Marker marker2 = marker;
        debug(format, arg1, arg2);
    }

    public void debug(Marker marker, String format, Object... arguments) {
        Marker marker2 = marker;
        debug(format, arguments);
    }

    public void debug(Marker marker, String msg, Throwable t) {
        Marker marker2 = marker;
        debug(msg, t);
    }

    public boolean isInfoEnabled(Marker marker) {
        Marker marker2 = marker;
        return isInfoEnabled();
    }

    public void info(Marker marker, String msg) {
        Marker marker2 = marker;
        info(msg);
    }

    public void info(Marker marker, String format, Object arg) {
        Marker marker2 = marker;
        info(format, arg);
    }

    public void info(Marker marker, String format, Object arg1, Object arg2) {
        Marker marker2 = marker;
        info(format, arg1, arg2);
    }

    public void info(Marker marker, String format, Object... arguments) {
        Marker marker2 = marker;
        info(format, arguments);
    }

    public void info(Marker marker, String msg, Throwable t) {
        Marker marker2 = marker;
        info(msg, t);
    }

    public boolean isWarnEnabled(Marker marker) {
        Marker marker2 = marker;
        return isWarnEnabled();
    }

    public void warn(Marker marker, String msg) {
        Marker marker2 = marker;
        warn(msg);
    }

    public void warn(Marker marker, String format, Object arg) {
        Marker marker2 = marker;
        warn(format, arg);
    }

    public void warn(Marker marker, String format, Object arg1, Object arg2) {
        Marker marker2 = marker;
        warn(format, arg1, arg2);
    }

    public void warn(Marker marker, String format, Object... arguments) {
        Marker marker2 = marker;
        warn(format, arguments);
    }

    public void warn(Marker marker, String msg, Throwable t) {
        Marker marker2 = marker;
        warn(msg, t);
    }

    public boolean isErrorEnabled(Marker marker) {
        Marker marker2 = marker;
        return isErrorEnabled();
    }

    public void error(Marker marker, String msg) {
        Marker marker2 = marker;
        error(msg);
    }

    public void error(Marker marker, String format, Object arg) {
        Marker marker2 = marker;
        error(format, arg);
    }

    public void error(Marker marker, String format, Object arg1, Object arg2) {
        Marker marker2 = marker;
        error(format, arg1, arg2);
    }

    public void error(Marker marker, String format, Object... arguments) {
        Marker marker2 = marker;
        error(format, arguments);
    }

    public void error(Marker marker, String msg, Throwable t) {
        Marker marker2 = marker;
        error(msg, t);
    }

    public String toString() {
        StringBuilder sb;
        new StringBuilder();
        return sb.append(getClass().getName()).append("(").append(getName()).append(")").toString();
    }
}
