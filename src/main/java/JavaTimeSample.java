import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.chrono.MinguoDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class JavaTimeSample {

  public  static void main(String[] args){

    LocalDateTime time = LocalDateTime.now();
    //只有日期，沒有時間
    LocalDate date = LocalDate.now();

    LocalTime now = LocalTime.now();

    //設置時間區間
    LocalDateTime start = LocalDate.of(2021, 9, 1).atTime(LocalTime.MIN);
    LocalDateTime end = LocalDate.of(2021, 9, 30).atTime(LocalTime.MAX);

    //年月
    YearMonth yearMonth = YearMonth.now();
//    System.out.println(yearMonth);

    //時間從比較細的部分，轉至比較粗的部分
    System.out.println(YearMonth.from(start));

    //與舊版的日期做轉換
    Date oldDate = new Date();
    Instant instant = oldDate.toInstant();
    System.out.println(instant);   //因為時區的關係，要減去 8

    //處理時間的方式
    //systemDefault 系統時間
    System.out.println(LocalDateTime.ofInstant(instant, ZoneId.systemDefault()));

    //處理民國年
    //只有 MinguoDate 沒有 MinguoTime 的原因 => 只有年會被轉換，小時不會被改變
    System.out.println(MinguoDate.from(start));

    System.out.println(time.format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));
    System.out.println(MinguoDate.from(time).format(DateTimeFormatter.ofPattern("[民國] yyy/MM/dd")));
    //format 在哪邊做轉換會比較好 ? 以 MVC 來說，建議在 controller 做轉換會比較好
    //在前後端分離部屬

    //ISO 的時間格式
    System.out.println(time.format(DateTimeFormatter.ISO_DATE_TIME));


  }

}
