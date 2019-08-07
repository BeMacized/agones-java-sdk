package net.bemacized.agones_java_sdk.models;

import com.google.api.client.util.Key;

public class SpecHealth {

    @Key
    public boolean disabled;
    @Key
    public int period_seconds;
    @Key
    public int failure_threshold;
    @Key
    public int initial_delay_seconds;


    @Override
    public String toString() {
        return "SpecHealth{" +
                "disabled=" + disabled +
                ", period_seconds=" + period_seconds +
                ", failure_threshold=" + failure_threshold +
                ", initial_delay_seconds=" + initial_delay_seconds +
                '}';
    }
}
