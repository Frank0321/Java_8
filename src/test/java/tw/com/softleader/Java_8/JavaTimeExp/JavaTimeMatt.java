package tw.com.softleader.Java_8.JavaTimeExp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTestContextBootstrapper;
import org.springframework.test.context.BootstrapWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.*;
import java.time.chrono.MinguoDate;

@BootstrapWith(SpringBootTestContextBootstrapper.class)
@ExtendWith({SpringExtension.class})
public class JavaTimeMatt {

    @Test
    void JavaTime(){
        // 常用的

        LocalDate date = null;
        LocalDateTime time = null;
        Duration duration = null;
        Period period = null;

        Instant instant = null;
        MinguoDate minguo = null;
    }
}
