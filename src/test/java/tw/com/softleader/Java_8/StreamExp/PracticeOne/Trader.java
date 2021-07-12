package tw.com.softleader.Java_8.StreamExp.PracticeOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * 交易員
 */
@Data
@Builder
@AllArgsConstructor
public class Trader {

    private String name;

    private String city;
}
