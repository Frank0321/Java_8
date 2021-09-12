import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StreamSample {

  public static void main(String[] args){

    var sources = List.of("1","2","3","4","5");

    var sb = new StringBuilder();
    for (String source : sources) {
      try {
        Integer integer = Integer.valueOf(source);
        int result = integer * 2;
        sb.append(result);
      } catch (NumberFormatException e) {
//        e.printStackTrace();  //禁止使用
        log.error("處理轉換成數字的過程錯誤",source, e);
        throw new RuntimeException(e);
      }
    }
    System.out.println(sb.toString());
    System.out.println("===========================");
    String result = sources.stream()
        .map(Integer::valueOf)
        .map(r -> r * 2)
        .map(Object::toString)
        .collect(Collectors.joining());
    System.out.println(result);
  }

}
