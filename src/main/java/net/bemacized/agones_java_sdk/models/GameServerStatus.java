package net.bemacized.agones_java_sdk.models;

import com.google.api.client.util.Key;

import java.util.List;

public class GameServerStatus {

    @Key
    public String state;
    @Key
    public String address;
    @Key
    public List<StatusPort> ports;

    @Override
    public String toString() {
        return "GameServerStatus{" +
                "state='" + state + '\'' +
                ", address='" + address + '\'' +
                ", ports=" + ports +
                '}';
    }
}
