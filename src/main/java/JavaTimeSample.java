import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.chrono.MinguoDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import jdk.jfr.Percentage;
import lombok.AllArgsConstructor;
import lombok.Getter;

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

    //日期的加減，可能會用到加一個工作天
    System.out.println(date.plusDays(1));  //加一天
    System.out.println(date.minusDays(1));  //減一天


    //加一個工作天
    System.out.println(plusWorkDate(LocalDate.now(), 1));
    //SELECT DATE FROM (SELECT DATE, ROWNUM ROW_NUM FROM HOLIDAYS WHERE DATE > START_DAY ORDER BY DATE) WHERE ROW_NU = 3;
    System.out.println(plusWorkDateOther(LocalDate.now(), 1));
  }


  //假日物件
  @Getter
  @AllArgsConstructor
  static class Holiday {
    LocalDate date;
    Boolean workDate;
  }

  //假日表
  static List<Holiday> HOLIDAYS = List.of(
      new Holiday(LocalDate.of(2021,9,1), true),
      new Holiday(LocalDate.of(2021,9,2), true),
      new Holiday(LocalDate.of(2021,9,3), true),
      new Holiday(LocalDate.of(2021,9,4), false),
      new Holiday(LocalDate.of(2021,9,5), false),
      new Holiday(LocalDate.of(2021,9,6), true),
      new Holiday(LocalDate.of(2021,9,7), true),
      new Holiday(LocalDate.of(2021,9,8), true),
      new Holiday(LocalDate.of(2021,9,9), true),
      new Holiday(LocalDate.of(2021,9,10), true),
      new Holiday(LocalDate.of(2021,9,11), true),
      new Holiday(LocalDate.of(2021,9,12), false),
      new Holiday(LocalDate.of(2021,9,13), true),
      new Holiday(LocalDate.of(2021,9,14), true),
      new Holiday(LocalDate.of(2021,9,15), true),
      new Holiday(LocalDate.of(2021,9,16), true),
      new Holiday(LocalDate.of(2021,9,17), true),
      new Holiday(LocalDate.of(2021,9,18), false),
      new Holiday(LocalDate.of(2021,9,19), false),
      new Holiday(LocalDate.of(2021,9,20), false),
      new Holiday(LocalDate.of(2021,9,21), false),
      new Holiday(LocalDate.of(2021,9,22), true),
      new Holiday(LocalDate.of(2021,9,23), true),
      new Holiday(LocalDate.of(2021,9,24), true),
      new Holiday(LocalDate.of(2021,9,25), false),
      new Holiday(LocalDate.of(2021,9,26), false),
      new Holiday(LocalDate.of(2021,9,27), true),
      new Holiday(LocalDate.of(2021,9,28), true),
      new Holiday(LocalDate.of(2021,9,29), true),
      new Holiday(LocalDate.of(2021,9,30), true)
  );

  public static LocalDate plusWorkDate(LocalDate start, int workDates){
    ArrayList<Holiday> holidays = new ArrayList<>(HOLIDAYS);
    holidays.sort(Comparator.comparing(Holiday::getDate));
    return holidays.stream()
        .filter(h -> h.date.isAfter(start))
        .filter(h -> h.workDate)
        .skip(workDates - 1)
        .findFirst()
        .map(Holiday::getDate)
        .orElseThrow(() -> new IllegalArgumentException(String.format("找不到此日期:%s+%d工作日的時間點", start, workDates)));
  }

  public static LocalDate plusWorkDateOther(LocalDate start, int workDates){
    ArrayList<Holiday> holidays = new ArrayList<>(HOLIDAYS);
    holidays.sort(Comparator.comparing(Holiday::getDate));

    int left = workDates;
    for(Holiday holiday: HOLIDAYS){
      if (!holiday.date.isAfter((start))){
        continue;
      }
      if(holiday.workDate){
        left--;
      }
      if(left == 0){
        return holiday.date;
      }

    }
    throw new IllegalArgumentException(String.format("找不到此日期:%s+%d工作日的時間點", start, workDates));

  }

}
