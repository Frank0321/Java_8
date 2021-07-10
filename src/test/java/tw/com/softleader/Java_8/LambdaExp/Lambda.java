package tw.com.softleader.Java_8.LambdaExp;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 利用 Lambda 實作文字的排序範例
 */

public class Lambda {

    //產生資料
    List<String> CreatData(){
        List<String> strs = new ArrayList<>();
        strs.add("A");
        strs.add("Z");
        strs.add("C");
        strs.add("F");
        strs.add("D");
        return strs;
    }

    /**
     * 使用匿名者類別，實作排序功能
     */
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

    /**
     * 使用 lambda 的方法，實作排序功能
     * 參數不宣告類型(不需要特別宣告類型就可以識別參數)
     */
    @Test
    void lambdaMethodOne(){
        List<String> strs = CreatData();
        Collections.sort(strs, ((o1, o2) -> o1.compareTo(o2)));
        System.out.print("Lambda 寫法 : ");
        strs.stream().forEach(s -> System.out.print(s));
        System.out.println();
    }


    /**
     * 使用 lambda 的方法，實作排序功能
     * 實作內容超過一行以上時，需要 {} + return
     */
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

    /**
     * TODO : 解釋
     */
    @Test
    void lambdaMethodTwo(){
        List<String> strs = CreatData();
        Collections.sort(strs, String::compareTo);
        System.out.print("Lambda 其他寫法 : ");
        strs.stream().forEach(s -> System.out.print(s));
        System.out.println();
    }


}
