package tw.com.softleader.Java_8.StreamExp.PracticeOne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class StreamExp {
    public static void main(String[] args) {
//        System.out.println("abc");
        String s = "acddc";
        System.out.println(s.chars().filter(c -> c=='a').count()
                            + s.chars().filter( c-> c=='c').count()*3
                            + s.chars().filter( c-> c=='d').count()*4);

        var letterCount = Arrays.stream(s.split(""))
                                            .collect(groupingBy(s1 -> s1.toString(), counting()));
        System.out.println(letterCount);

        List<String> strings = List.of("A", "B", "C", "A", "B", "C", "A");
        System.out.println(strings.stream()
                //把 List 依照內容重複的次數，組合成一個 Map<String, Long>
                .collect(groupingBy(String::toString, counting())));
    }
}
