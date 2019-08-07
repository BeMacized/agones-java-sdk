package net.bemacized.agones_java_sdk.models;

import com.google.api.client.util.Key;

public class GameServer {

    @Key
    public GameServerStatus status;
    @Key
    public GameServerSpec spec;
    @Key
    public ObjectMeta object_meta;


    @Override
    public String toString() {
        return "GameServer{" +
                "status=" + status +
                ", spec=" + spec +
                ", object_meta=" + object_meta +
                '}';
    }
}
