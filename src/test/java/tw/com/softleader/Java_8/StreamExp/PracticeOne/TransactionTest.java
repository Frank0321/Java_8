package tw.com.softleader.Java_8.StreamExp.PracticeOne;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

public class TransactionTest {
    //https://codertw.com/%E7%A8%8B%E5%BC%8F%E8%AA%9E%E8%A8%80/79735/
    //建立資料

    static List<Transaction> beforeAll(){
        List<Transaction> transactionList = List.of(
                Transaction.builder().trader(Trader.builder().name("Brian").city("Cambridge").build()).year(2011).value(300).build(),
                Transaction.builder().trader(Trader.builder().name("Raoul").city("Cambridge").build()).year(2012).value(1000).build(),
                Transaction.builder().trader(Trader.builder().name("Raoul").city("Cambridge").build()).year(2011).value(400).build(),
                Transaction.builder().trader(Trader.builder().name("Mario").city("Milan").build()).year(2012).value(710).build(),
                Transaction.builder().trader(Trader.builder().name("Mario").city("Milan").build()).year(2012).value(700).build(),
                Transaction.builder().trader(Trader.builder().name("Alan").city("Cambridge").build()).year(2012).value(950).build()
        );
        return transactionList;

    }

    //1. 找出2011年發生的所有交易，並按交易額排序（從低到高），並印出名字 (Brian、Raoul)
    //2. 交易員都在哪些不同的城市工作過? 並印出城市名稱  (Cambridge、Milan)
    //3. 查詢所有來自劍橋的交易員，並按姓名排序
    //4. 返回所有交易員的姓名字串，按字母順序排序
    //5. 有沒有交易員是在米蘭工作的？
    //6. 列印生活在劍橋的交易員的所有交易額
    //7. 所有交易中，最高的交易額是多少
    //8. 找到交易額最小的交易

    //1. 找出2011年發生的所有交易，並按交易額排序（從低到高），並印出名字
    @Test
    void test1(){
        var list = beforeAll();
        // 年分 == 2011
        // 按照金額排序
        // 轉成最內層的名字
        list.stream()
                .filter(y -> y.getYear()==2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .forEach(System.out::println);
    }

    //2. 交易員都在哪些不同的城市工作過？
    @Test
    void test2(){
        var list = beforeAll();
        //轉成最內層的名字
        //去重複
        list.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct()
                .forEach(System.out::println);
    }

}
