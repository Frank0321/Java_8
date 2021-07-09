package tw.com.softleader.Java_8.Future;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTestContextBootstrapper;
import org.springframework.test.context.BootstrapWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@BootstrapWith(SpringBootTestContextBootstrapper.class)
@ExtendWith({SpringExtension.class})
public class JavaFutureMatt {
    @Test
    void future(){
        // watch: https://youtu.be/_EqitUOUpes

        // 同步, 非同步:
        //    - sync: 下載 3 location 的 html, 分析, 寫入 db
        //    - ansyc: 產生新的執行緒去處理你要處理的事, 同時下載 3 location html, 分析, 寫 db
        // 阻塞, 非阻塞: blocking, non-blocking

        Future future = null; // -> java 6?
        CompletableFuture cf = null; // java 8, 把 future 加上 stream 改念
        //    SimpleFuture sf =
        //        null; // 公司出的, 簡單版的的 CompletableFuture: 只 expose 常用的 API, 以及把部分 API 重新命名成 stream
        // naming
    }
}
