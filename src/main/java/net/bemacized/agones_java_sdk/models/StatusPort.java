package net.bemacized.agones_java_sdk.models;

import com.google.api.client.util.Key;

public class StatusPort {

    @Key
    public String name;
    @Key
    public int port;

    @Override
    public String toString() {
        return "StatusPort{" +
                "name='" + name + '\'' +
                ", port=" + port +
                '}';
    }
}
