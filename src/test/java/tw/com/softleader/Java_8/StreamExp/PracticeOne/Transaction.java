package tw.com.softleader.Java_8.StreamExp.PracticeOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 交易
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    //交易員
    private Trader trader;
    //交易日期
    private int year;
    //交易金額
    private int value;
}
