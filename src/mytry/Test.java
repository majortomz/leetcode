package mytry;

/**
 * Created by zhou on 2017/5/12.
 */
public class Test {

    public static void main(String[] args) {
        String s = "2452,,44,|,,,";
        String[] sl = s.split(",|#");
        for (String ss: sl)
            System.out.println(ss);
    }
}
