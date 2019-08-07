package net.bemacized.agones_java_sdk.models;

import com.google.api.client.util.Key;

public class GameServerSpec {

    @Key
    public SpecHealth health;

    @Override
    public String toString() {
        return "GameServerSpec{" +
                "health=" + health +
                '}';
    }
}
