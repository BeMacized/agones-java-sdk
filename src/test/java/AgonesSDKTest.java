import net.bemacized.agones_java_sdk.AgonesSDK;

public class AgonesSDKTest {

    // I know I should use JUnit or w/e but I haven't done Java in forever and I just needed this quickly please don't judge
    public static void main(String[] args) {
        AgonesSDK sdk = new AgonesSDK();
        sdk.ready();
        sdk.health();
        sdk.allocate();
        sdk.setAnnotation("foo", "bar");
        sdk.setLabel("hello", "world");
        System.out.println(sdk.getGameServer());
        sdk.shutdown();
    }
}
