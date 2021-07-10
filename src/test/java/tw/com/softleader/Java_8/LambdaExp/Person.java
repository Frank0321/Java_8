package tw.com.softleader.Java_8.LambdaExp;

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

    public void printPerson(){
        System.out.println(this);
    }

}
