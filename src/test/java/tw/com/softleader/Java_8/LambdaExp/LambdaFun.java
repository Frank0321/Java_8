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
    List<Person> CreatData(){
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
    @DisplayName("功能型(Function)範例")
    void FunctionLambdaTest(){
        //input Person -> output String
        Function<Person, String> personStringFunction = p -> p.getName();

        for (Person p : CreatData()){
            System.out.println(personStringFunction.apply(p));
        }
    }

    @Test
    @DisplayName("消費型(Consumer)範例")
    void ConsumerLambdaTest(){
        //input Person -> none output (void)
        Consumer<Person> personConsumer = p -> p.printPerson();

        for (Person p : CreatData()){
            personConsumer.accept(p);
        }
    }

    @Test
    @DisplayName("評斷型(Predicate)範例")
    void PredicateLambdaTest (){
        //input Person -> out boolean
        Predicate<Person> personPredicate = p -> p.getId() > 2;

        for (Person p: CreatData()) {
            System.out.println(personPredicate.test(p)?p.getName():"none");
        }
    }

    @Test
    @DisplayName("供應型(Supplier)範例")
    void SupplierLambdaTest(){
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
