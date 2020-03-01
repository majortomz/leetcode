package test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by zjw on 2018/01/18 11:07
 * Description:
 */
public class SteamTest {

    public static void main(String[] args) {
        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6)
        );
        inputStream.
                flatMap((childList) -> childList.stream()).forEach(System.out::println);
    }

}
