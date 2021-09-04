# Java 8 更新的語法
- 為了方便執行程式，本次範例程式放置 test 檔案夾內
- 放置程式檔案目錄 :
  ```
  ├─ src                  
  │ ├─ test 
  │ │ ├─ java
  │ │ │ ├─ tw.com.softleader.Java_8      
  ```


## 新增 Optional 類別
- 主要處理並判斷回傳是否為 null 的問題，若不處理，則會產生 NullPointerExpection
- 

## 介面的靜態方法及預設方法

## Lambda
- 主要用來實作interface method(方法定義)使用匿名函式使的語法上更精簡!
  - 匿名函數也就是沒有名稱的方法
  - @FunctionalInterface : 單一函式介面 annotation
- 必須包含三個部分 : 
  1. 方法參數
  2. 箭頭符號
  3. 方法內容
- 透過把函式作為方法的參數傳遞，使的程式碼變的更加簡潔
- 運用參照方法的方式來定義 Lambda 方法實作(四種方式)
  1. 方法是靜態(static)方法
     - 語法 -> ConcreteClassName :: staticMethodName
  2. 方法是實例(instance)方法，來自lambda表示式之「外」的參考變數
     - 語法 -> objectReference :: instanceMethodName
  3. 方法是實例(instance)方法，來自lambda表示式之「內」的參考變數
     - 語法 -> ObjectReferenceType :: instanceMethodName
  4. 使用 new 呼叫(帶參數)建構子
    - 語法 -> ClassName :: new
- Java 8 之後的 interface，常被用來撰寫成 Lambda
  1. Function (功能型)
     - 傳入參數 T -> 傳出參數 R
     - input int -> output string
  2. Consumer (消費型)
     - 傳入參數 T -> "沒有"傳出
     - input int -> none output
  3. Predicate (評斷型)
     - 傳入參數 T -> 傳出 True/false
     - input int -> boolean
  4. Supplier (供應型)  
     - "沒有"傳入 -> 傳出參數 R 
     - none input -> output int
    

## Stream API
- 先定義資料來源，再分段處理，主要分成三種作業
- 中間作業 : 0 ~ N 個
  - filter()
    - 檢查集合中的每個元素是否符合你的期望時
      
  - map()
    - 輸入的資料，轉換成另一種格式 
    - input T -> output R  
  - peek()
    - 通過時，可以針對 value 進行調整、或是印出來
  - sorted()
    - 要對集合內容進行排序時
  - flatMap()  
    - 將不同集合中的資料串接在一起，成為在一起的一組集合 (攤平處理)
- 終端作業 : 1 個
  - forEach()
    - 將最後結果跑 for loop
  - count()
    - 計算集合的元素數量
  - sum()、average()
  - min()、max()
    - 集合中的最大值或最小值
  - collect()  
- 短路型終端作業 : 1 個
  - findFirst()、findAny()
  - anyMatch()、allMatch()、noneMatch()  
- 相關練習題目
  - [Java8-Stream-練習](https://codertw.com/%E7%A8%8B%E5%BC%8F%E8%AA%9E%E8%A8%80/79735/)
  - [Java 8 stream練習](https://www.twblogs.net/a/5e944436bd9eee34209023ab)  
    

## Java Time
- 範例 : JavaTimeSample
- 常見的三種格式 LocalDateTime、LocalDate、LocalTime
- 常給 user 設定的狀態為 LocalDate，很少設定到 時分秒
- Day.js : 前端的日期函數，與 Moment.js 相識，但效能 Day.js 較好
- 只有 MinguoDate 沒有 MinguoTime 的原因 => 只有年會被轉換，小時不會被改變
- format 在哪邊做轉換會比較好 ? 以 MVC 來說，建議在 controller 做轉換會比較好
- 通常時間的格式，是用 ISO 格式拋出去 (2021-09-03T23:49:37.8329223)
- LocalDate 裡面的 isAfter() 方法 : 不包含當天

## 補充資料
- 在分離部屬中，各自的架構皆有屬於自己的 MVC，以後端來說 view 代表的是拋出去的 Json
- boolean & Boolean
  - 在 getter 的用法上，boolean 是用 is 來接，Boolean 是用 get 來接
  ```java
  
  @Getter
  class Test{
    booean workA; 
    Boolean workB;
  }
  //......
  Test test = new Test();
  test.isWorkA();
  test.getWorkB();
  ```
- 為了避免 null 的狀況發生，跟別人資料連接，或是跟資料庫連接，一律使用大寫型別
- UnsupportedOperationException : 在使用 Arrays.asList("","","").add("") 會發生
- 
## 參考資料  
- [深入淺出 Java 8](https://www.gss.com.tw/blog/java8)
- [~~Java 8 新特性簡單介紹~~](https://morosedog.gitlab.io/java-8-20200330-java8-0/)
- [~~Java 8 新特性 (菜鳥教程)~~](https://www.runoob.com/java/java8-new-features.html)
- [Java8 新特性](https://www.jianshu.com/p/5b800057f2d8) 
- [跟上 Java，知呼](https://zhuanlan.zhihu.com/p/33253953)
- [stream 介紹](http://blog.tonycube.com/2015/10/java-java8-3-stream.html)
- [softleader 2018_Q1_stream](https://github.com/softleader/softleader-training-course/tree/master/2018/Q1/stream-adv)
- [softleader 2016_Q1_stream](https://github.com/softleader/softleader-training-course/blob/master/2016/Q1/stream-and-lambda)
- [深入淺出 Java 8 新語法特性 叡揚資訊](https://www.gss.com.tw/blog/java8)
  
- 李昱賞 JavaSE 上課講義
