package com.lifengming.bean.service;

import org.springframework.context.SmartLifecycle;

/**
 * @author lifengming
 * @since 2019.11.24
 */
public class ContainerLife implements SmartLifecycle {

    public void start() {
        System.out.println("start-xxxxxxxxxxxx");
    }

    public void stop() {

    }

    public boolean isRunning() {
        return false;
    }

    public boolean isAutoStartup() {
        return true;
    }

    public void stop(Runnable callback) {
        System.out.println("xxxxxxxxxxxxxxxx-stop");
        callback.run();

    }

    public int getPhase() {
        return 0;
    }
}
