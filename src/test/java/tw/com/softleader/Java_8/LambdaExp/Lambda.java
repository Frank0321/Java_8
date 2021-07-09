package tw.com.softleader.Java_8.LambdaExp;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda {

    //產生資料
    List<String> CreatData(){
        List<String> strs = new ArrayList<>();
        strs.add("A");
        strs.add("E");
        strs.add("F");
        strs.add("S");
        strs.add("Q");
        return strs;
    }

    @Test
    void originMethod(){
        List<String> strs = CreatData();
        Collections.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.print("匿名者類別 : ");
        strs.stream().forEach(s -> System.out.print(s));
        System.out.println();
    }

    @Test
    void lambdaMethod(){
        List<String> strs = CreatData();
        Collections.sort(strs, ((o1, o2) -> o1.compareTo(o2)));
        System.out.print("Lambda 寫法 : ");
        strs.stream().forEach(s -> System.out.print(s));
        System.out.println();
    }

    @Test
    void lambdaMethodThree(){
        List<String> strs = CreatData();
        Collections.sort(strs,
                ((o1, o2) -> {
                    int i = o1.compareTo(o2);
                    return i;
                }));
        System.out.print("Lambda 其他寫法 : ");
        strs.stream().forEach(s -> System.out.print(s));
        System.out.println();
    }

    @Test
    void lambdaMethodTwo(){
        List<String> strs = CreatData();
        Collections.sort(strs, String::compareTo);
        System.out.print("Lambda 其他寫法 : ");
        strs.stream().forEach(s -> System.out.print(s));
        System.out.println();
    }


}
