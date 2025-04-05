package com.myself.listener;

import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionBindingListener;

/**
 * @author polar
 * @version 1.0
 * @since 2025/3/30 14:44
 */
public class SessionBindingListener implements HttpSessionBindingListener {
    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        HttpSessionBindingListener.super.valueBound(event);
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        HttpSessionBindingListener.super.valueUnbound(event);
    }
}
