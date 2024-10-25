import java.util.*;
import java.util.stream.*;
public class Main {
    public static int test(){
        System.out.println("Hello World!");
        Scanner s = new Scanner(System.in);
        int one = s.nextInt();
        int two = s.nextInt();
        System.out.println(one * two);
        return one * two;
    }

    public static int betterTest(){
        return Stream.of(new int[1])
                .peek(ret -> System.out.println("Hello World!"))
                .peek(ret -> Stream.of(new Scanner(System.in))
                        .forEach(s -> Stream.of(s.nextInt())
                            .forEach(one -> Stream.of(s.nextInt())
                                    .peek(two -> System.out.println(one * two))
                                    .forEach(two -> ret[0] = one * two))))
                .findFirst().get()[0];
    }
}