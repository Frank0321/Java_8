package tw.com.softleader.Java_8.StreamExp;

import org.junit.jupiter.api.Test;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class StreamMatt {

    @Test
    void stream(){
        List<YearMonth> month = new ArrayList<>();
        month.add(YearMonth.of(2020,3));
        month.add(YearMonth.of(2020,7));
        month.add(YearMonth.of(2021,10));

        // 找出屬於傳入年份的月份, 將其天數累加

        int totalDays = 0;
        int year = 2020;

        for (YearMonth m : month) { // loop
            if (m.getYear() == year) { // 過濾
                final int days = m.lengthOfMonth(); // 轉換
                totalDays = totalDays + days; // 累加
            }
        }

        System.out.println(totalDays);

        int answer =
                month.stream() // loop
                        .filter(yearMonth -> yearMonth.getYear() == year) // 過濾
                        .map(YearMonth::lengthOfMonth) // 轉換
                        // 常用的中繼 operation:
                        //						.mapToDouble()
                        //            .mapToLong()
                        //            .mapToInt(YearMonth::lengthOfMonth)
                        //						.distinct()
                        //						.sorted()
                        //						.peek()
                        // 常用的結束 operation:
                        //		.forEach(System.out::println);
                        //		.anyMatch()
                        //		.noneMatch()
                        //		.allMatch()
                        //		.findFirst()
                        //    .collect(Collectors.toList()); // 可以有比較進階的應用
                        .reduce(0, (total, days) -> total + days); // 累加

        // create stream:
        // Collection.stream() //
        // Stream.of(....);

        //    List<List<Integer>> doubleList = List.of(List.of(1, 2, 3), List.of(4, 5, 6));
        //    doubleList.stream()
        //				.flatMap(l -> l.stream())
        //				.reduce((total, days) -> total + days);
    }
}
