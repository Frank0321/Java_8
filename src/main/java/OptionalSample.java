import java.util.Optional;
import java.util.function.Supplier;

public class OptionalSample {

  public static void main(String[] args){
    for (int i = 0; i < 10; i++) {
      runOpt();
    }
    System.out.println("--------------");
    for (int i = 0; i < 10; i++) {
      runOpt2();
    }
    System.out.println("--------------");
    for (int i = 0; i < 10; i++) {
      runOpt3();
    }


    System.out.println("JDK11-------------");
    //JDK 11 多的內容
    runOpt4();
    runOpt5();
  }

  private static void runOpt(){
    String result = Optional.ofNullable(sometimesNullValue())
        .orElse("notGood");
    System.out.println(result);
  }


  private static void runOpt2(){
    String other = notGood();
    String result = maybeNullValue().orElse(other);
    System.out.println(result);
  }


  private static void runOpt3(){
    Supplier<String> stringSupplier = new Supplier<String>() {
      @Override
      public String get() {
        return notGood();
      }
    };
    String result = maybeNullValue().orElseGet(stringSupplier);
//    String result = maybeNullValue().orElseGet(OptionalSample::notGood);
    System.out.println(result);
  }

  private static void runOpt4(){
    maybeNullValue().ifPresentOrElse(
        s-> System.out.println(s),
        ()-> System.out.println(notGood())
    );
  }

  private static void runOpt5(){
    //用 or 表示前後兩個都會有可能為 null
    String s1 = maybeNullValue()
        .or(() -> maybeNullValue())
        .orElse(notGood());

    String s2 = maybeNullValue()
        .orElseGet(() -> maybeNullValue().orElseGet(() -> notGood()));


  }


  private static String notGood(){
    System.out.println("Prepare doing");
    return "not Good";
  }

  /**
   *
   * @return nullable String
   */
  public static String sometimesNullValue(){
    return Math.random() > 0.5 ? null : "good";
  }

  public static Optional<String> maybeNullValue(){
    return Math.random()>0.5 ? Optional.empty():Optional.of("good");
  }
}
