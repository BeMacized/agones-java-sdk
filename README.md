# Agones SDK for Java

Library for calling functions with the Agones sidecar.

## Add to your project

### Maven

Add repository
```xml
<repositories>
    ...
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

Add dependency
```xml
<dependencies>
    ...
    <dependency>
	    <groupId>com.github.BeMacized</groupId>
	    <artifactId>agones-java-sdk</artifactId>
	    <version>Tag</version>
	</dependency>

</dependencies>
```

## Usage

```java
// Instantiate SDK object
AgonesSDK sdk = new AgonesSDK();
// Mark game server as ready
sdk.ready();
// Declare game server as healthy
sdk.health();
// Allocate game server
sdk.allocate();
// Set an annotation on the game server
sdk.setAnnotation("foo", "bar");
// Set a label on the game server
sdk.setLabel("hello", "world");
// Get the game server object
GameServer gameServer = sdk.getGameServer();
// Mark the game server as shutting down
sdk.shutdown();
```