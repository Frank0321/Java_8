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

## Data Time API


## 參考資料  
- [深入淺出 Java 8](https://www.gss.com.tw/blog/java8)
- [~~Java 8 新特性簡單介紹~~](https://morosedog.gitlab.io/java-8-20200330-java8-0/)
- [~~Java 8 新特性 (菜鳥教程)~~](https://www.runoob.com/java/java8-new-features.html)
- [Java8 新特性](https://www.jianshu.com/p/5b800057f2d8) 
- [跟上 Java，知呼](https://zhuanlan.zhihu.com/p/33253953)
  
- 李昱賞 JavaSE 上課講義

## 補充
- 未 commit 的檔案 : 藍色
- 未 加入 github 的檔案 : 紅色