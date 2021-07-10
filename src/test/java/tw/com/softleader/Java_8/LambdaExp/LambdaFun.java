package tw.com.softleader.Java_8.LambdaExp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 常被用來撰寫成 Lambda
 * 基礎內建的有四種
 */
public class LambdaFun {

    //產生資料
    List<Person> creatData(){
        List<Person> personList = new ArrayList<Person>();
        personList.add(Person.builder()
                .id(1)
                .name("Rhys")
                .email("Rhys@email")
                .build());
        personList.add(Person.builder()
                .id(2)
                .name("Matt")
                .email("Matt@email")
                .build());
        personList.add(Person.builder()
                .id(3)
                .name("John")
                .email("John@email")
                .build());
        personList.add(Person.builder()
                .id(4)
                .name("Maggie")
                .email("Maggie@email")
                .build());
        personList.add(Person.builder()
                .id(5)
                .name("Ben")
                .email("Ben@email")
                .build());
        return personList;
    }

    @Test
    @DisplayName("功能型(匿名者)範例")
    void functionTest(){
        Function<Person, String> personStringFunction = new Function<Person, String>() {
            @Override
            public String apply(Person person) {
                return person.getName();
            }
        };
        for (Person p: creatData()) {
            System.out.println(personStringFunction.apply(p));
        }
    }

    //TODO : 補充匿名者寫法
    @Test
    @DisplayName("功能型(Function)範例")
    void functionLambdaTest(){
        //input Person -> output String
        Function<Person, String> personStringFunction = p -> p.getName();

         // 在簡化寫法
        //Function<Person, String> personStringFunction = Person::getName;

        for (Person p : creatData()){
            System.out.println(personStringFunction.apply(p));
        }
    }

    //TODO : 補充匿名者寫法
    @Test
    @DisplayName("消費型(Consumer)範例")
    void consumerLambdaTest(){
        //input Person -> none output (void)
        Consumer<Person> personConsumer = p -> p.printPerson();

        for (Person p : creatData()){
            personConsumer.accept(p);
        }
    }

    //TODO : 補充匿名者寫法
    @Test
    @DisplayName("評斷型(Predicate)範例")
    void predicateLambdaTest(){
        //input Person -> out boolean
        Predicate<Person> personPredicate = p -> p.getId() > 2;

        for (Person p: creatData()) {
            System.out.println(personPredicate.test(p)?p.getName():"none");
        }
    }

    //TODO : 補充匿名者寫法
    @Test
    @DisplayName("供應型(Supplier)範例")
    void supplierLambdaTest(){
        // none input -> out Person
        Supplier<Person> personSupplier = () ->
                Person.builder().
                        id(6).
                        name("Frank")
                        .email("Frank@email")
                        .build();
        System.out.println(personSupplier.get());
    }

}
