package tw.com.softleader.Java_8;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private int id;

    private String name;

    private String email;

    private int money;

    public void printPerson(){
        System.out.println(this);
    }

}
