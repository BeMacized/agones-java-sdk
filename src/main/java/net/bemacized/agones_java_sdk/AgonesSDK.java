package net.bemacized.agones_java_sdk;

import com.google.api.client.http.*;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.http.json.JsonHttpContent;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.common.reflect.TypeToken;
import net.bemacized.agones_java_sdk.models.GameServer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AgonesSDK {

    private HttpTransport httpTransport;
    private JacksonFactory jsonFactory;
    private String sidecarHost;
    private int sidecarPort;

    public AgonesSDK(String sidecarHost, int sidecarPort) {
        this.sidecarHost = sidecarHost;
        this.sidecarPort = sidecarPort;
        // Setup http client
        httpTransport = new NetHttpTransport();
        jsonFactory = new JacksonFactory();

    }

    public AgonesSDK() {
        this("localhost", 59358);
    }

    public void ready() {
        try {
            postJson("/ready", null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void allocate() {
        try {
            postJson("/allocate", null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void health() {
        try {
            postJson("/health", null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void shutdown() {
        try {
            postJson("/shutdown", null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setAnnotation(String key, String value) {
        Map<String, String> json = new HashMap<>();
        json.put("key", key);
        json.put("value", value);
        try {
            putJson("/metadata/annotation", json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setLabel(String key, String value) {
        Map<String, String> json = new HashMap<>();
        json.put("key", key);
        json.put("value", value);
        try {
            putJson("/metadata/label", json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public GameServer getGameServer() {
        try {
            HttpRequestFactory httpRequestFactory = httpTransport.createRequestFactory((HttpRequest request) -> {
                request.setParser(new JsonObjectParser(jsonFactory));
            });
            GenericUrl url = new GenericUrl("http://" + sidecarHost + ":" + sidecarPort + "/gameserver");
            HttpRequest request = httpRequestFactory.buildGetRequest(url);
            Type type = new TypeToken<GameServer>() {
            }.getType();
            return (GameServer) request.execute().parseAs(type);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private HttpResponse postJson(String path, Map<String, ?> body) throws IOException {
        HttpRequestFactory httpRequestFactory = httpTransport.createRequestFactory();
        GenericUrl url = new GenericUrl("http://" + sidecarHost + ":" + sidecarPort + path);
        final HttpContent content = new JsonHttpContent(new JacksonFactory(), body == null ? new HashMap<>() : body);
        return httpRequestFactory.buildPostRequest(url, content).execute();
    }

    private HttpResponse putJson(String path, Map<String, ?> body) throws IOException {
        HttpRequestFactory httpRequestFactory = httpTransport.createRequestFactory();
        GenericUrl url = new GenericUrl("http://" + sidecarHost + ":" + sidecarPort + path);
        final HttpContent content = new JsonHttpContent(new JacksonFactory(), body == null ? new HashMap<>() : body);
        return httpRequestFactory.buildPutRequest(url, content).execute();
    }

}
