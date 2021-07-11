package tw.com.softleader.Java_8.LambdaExp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tw.com.softleader.Java_8.Person;

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
        List<Person> personList = List.of(
                Person.builder().id(1).name("Rhys").email("Rhys@email").money(25000).build(),
                Person.builder().id(2).name("Matt").email("Matt@email").money(30000).build(),
                Person.builder().id(3).name("John").email("John@email").money(27000).build(),
                Person.builder().id(4).name("Maggie").email("Maggie@email").money(35000).build(),
                Person.builder().id(5).name("Ben").email("Ben@email").money(40000).build()
        );
        return personList;
    }

    @Test
    @DisplayName("Function Anonymous Ex")
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

    @Test
    @DisplayName("Function Lambda Ex")
    void functionLambdaTest(){
        //input Person -> output String
        Function<Person, String> personStringFunction = p -> p.getName();

         // 在簡化寫法
        //Function<Person, String> personStringFunction = Person::getName;

        for (Person p : creatData()){
            System.out.println(personStringFunction.apply(p));
        }
    }

    //==============================================================================================

    @Test
    @DisplayName("Consumer Anonymous Ex")
    void consumerTest(){
        Consumer<Person> personConsumer = new Consumer<Person>() {
            @Override
            public void accept(Person person) {
                person.printPerson();
            }
        };
        for (Person p: creatData()) {
            personConsumer.accept(p);
        }
    }

    @Test
    @DisplayName("Consumer Lambda Ex")
    void consumerLambdaTest(){
        //input Person -> none output (void)
        Consumer<Person> personConsumer = p -> p.printPerson();

        for (Person p : creatData()){
            personConsumer.accept(p);
        }
    }

    //==============================================================================================

    @Test
    @DisplayName("Predicate Anonymous Ex")
    void predicateTest(){
        Predicate<Person> personPredicate = new Predicate<Person>() {
            @Override
            public boolean test(Person person) {
                return person.getId()>2;
            }
        };
        for (Person p: creatData()) {
            System.out.println(personPredicate.test(p)?p.getName():"none");
        }
    }

    @Test
    @DisplayName("Predicate Lambda Ex")
    void predicateLambdaTest(){
        //input Person -> out boolean
        Predicate<Person> personPredicate = p -> p.getId() > 2;

        for (Person p: creatData()) {
            System.out.println(personPredicate.test(p)?p.getName():"none");
        }
    }

    //==============================================================================================

    @Test
    @DisplayName("Supplier Anonymous Ex")
    void supplierTest(){
        Supplier<Person> personSupplier = new Supplier<Person>() {
            @Override
            public Person get() {
                return Person.builder()
                        .id(6)
                        .name("Frank")
                        .email("Frank@mail")
                        .build();
            }
        };
        System.out.println(personSupplier.get());
    }

    @Test
    @DisplayName("SupplierLambda Ex")
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
