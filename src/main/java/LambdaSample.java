import java.util.ArrayList;
import java.util.List;

public class LambdaSample {

  public static void main (String [] args){

    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
    System.out.println(summarize(numbers, new DoAdd()));
    System.out.println(summarize(numbers, new DoMinus()));
    int r3 = summarize(numbers, new DoCalc() {
      @Override
      public int calc(int x, int y) {
        return x * y;
      }
    });
    System.out.println(r3);
    //Lambda 簡化
    System.out.println(summarize(numbers, (x, y) -> x * y));
  }

  public static int summarize(List<Integer> ints, DoCalc doCalc){
    ArrayList<Integer> integers = new ArrayList<>(ints);
    int result = integers.remove(0);
    for (Integer i : integers) {
       result = doCalc.calc(result, i);
    }
    return result;

  }

  //計算的方法
  static interface DoCalc{
    int calc(int x, int y);
  }

  static class DoAdd implements DoCalc{
    @Override
    public int calc(int x, int y) {
      return x + y;
    }
  }

  static class DoMinus implements DoCalc{
    @Override
    public int calc(int x, int y) {
      return x - y;
    }
  }



}
