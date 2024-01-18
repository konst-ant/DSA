package btreeplus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by KAntipin on 06.10.2015.
 */
public class DebugStopper {

    static void stop() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.format("Going to stop debug. Press any key to continue", 1);
        reader.readLine();
    }
}
