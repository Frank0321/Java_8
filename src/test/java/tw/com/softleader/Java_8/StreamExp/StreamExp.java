package tw.com.softleader.Java_8.StreamExp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tw.com.softleader.Java_8.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExp {
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
    @DisplayName("print each name which money > 30000")
    void Test1(){
        List<Person> personList = creatData();
        personList.stream()
                .filter(p -> p.getMoney() > 27000)
                .peek(person -> person.setMoney(50000))
                .peek(Person::printPerson)
                .filter(f -> f.getId()>3)
                .map(Person::getName)
                .forEach(e -> System.out.println(e));
    }
    @Test
    void Test2(){
        List<List<String>> lists = List.of(
                List.of("A","B","C"),
                List.of("D","E","F"),
                List.of("G", "H", "I"));

        List<String> list = lists.stream()
                            .flatMap(strings -> strings.stream())
                            .collect(Collectors.toList());
        list.stream().forEach(System.out::print);
    }
}
