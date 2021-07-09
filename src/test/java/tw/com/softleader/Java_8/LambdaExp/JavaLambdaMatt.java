package tw.com.softleader.Java_8.LambdaExp;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class JavaLambdaMatt {
    @Test
    void lambda(){
        // input -> output

        List<Integer> ints = new ArrayList<>();
        for (int i= 1; i < 6; i++) {
            ints.add(i);
        }
        Collections.sort(
                ints,
                new Comparator<Integer>() {
                    public int compare(Integer o1, Integer o2) {
                        return Integer.compare(o1, o2);
                    }
                });
        Collections.sort(ints, (o1, o2) -> o1 - o2);

        Collections.sort(
                ints,
                (o1, o2) -> { // 超過一行需要 {} + return
                    final int i = o1 - o2;
                    return i;
                });

        Collections.sort(ints, Integer::compare);

        // 限制:
        // jdk8
        // interface 只能有一個 method 未實作

        // 常用 lambda 的 java 8 之後的 interface
        Function<Integer, String> function = null; // input int -> output string
        Consumer<Integer> consumer = null; // input int -> none output
        Predicate<Integer> predicate = null; // input int -> boolean
        Supplier<Integer> supplier = null; // none input -> output int

        // 擴充 java lambda: https://github.com/jOOQ/jOOL
    }
}
