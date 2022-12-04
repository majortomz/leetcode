package basic.agent;

import java.lang.instrument.Instrumentation;

/**
 * Created by zjw Description: Date: 2022/04/27 14:19
 */
public class PreMainAgent {

    public static void premain(String agentArgs, Instrumentation inst) {

        System.out.println("Premain Start");
        System.out.println("agentArgs:" + agentArgs);
    }

}
