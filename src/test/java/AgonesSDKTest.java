import net.bemacized.agones_java_sdk.AgonesSDK;
import net.bemacized.agones_java_sdk.models.GameServer;

public class AgonesSDKTest {

    // I know I should use JUnit or w/e but I haven't done Java in forever and I just needed this quickly please don't judge
    public static void main(String[] args) {
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
    }
}
