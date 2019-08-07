package net.bemacized.agones_java_sdk.models;

import com.google.api.client.util.Key;

import java.util.Map;

public class ObjectMeta {

    @Key
    public String name;
    @Key
    public String namespace;
    @Key
    public String uid;
    @Key
    public String resource_version;
    @Key
    public String generation;
    @Key
    public String creation_timestamp;
    @Key
    public String deletion_timestamp;
    @Key
    public Map<String, String> annotations;
    @Key
    public Map<String, String> labels;

    @Override
    public String toString() {
        return "ObjectMeta{" +
                "name='" + name + '\'' +
                ", namespace='" + namespace + '\'' +
                ", uid='" + uid + '\'' +
                ", resource_version='" + resource_version + '\'' +
                ", generation='" + generation + '\'' +
                ", creation_timestamp='" + creation_timestamp + '\'' +
                ", deletion_timestamp='" + deletion_timestamp + '\'' +
                ", annotations=" + annotations +
                ", labels=" + labels +
                '}';
    }
}
