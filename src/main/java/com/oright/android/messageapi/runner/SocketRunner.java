package com.oright.android.messageapi.runner;

import com.oright.android.messageapi.properties.SocketProperties;
import com.oright.android.messageapi.socket.Client;
import com.oright.android.messageapi.socket.ClientInitTask;
import com.oright.android.messageapi.socket.ClientPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.net.ServerSocket;
import java.util.concurrent.*;

/**
 * 这个CommandLineRunner 只要继承他  他的子类 就会伴随着服务器一起启动 条件式 必须要
 * 注册到spring容器中 成为spring容器的component(组件)
 * 后端也没啥说的 就web 那几层
 *
 * controller
 * service
 * dao{
 *     model
 *     mapper
 * }
 */
@Component
public class SocketRunner implements CommandLineRunner {

    @Autowired
    private SocketProperties socketProperties;
    @Override
    public void run(String... args) throws Exception {
        ServerSocket server = new ServerSocket(socketProperties.getPort());
        ThreadPoolExecutor myThreadPool = new ThreadPoolExecutor(
                socketProperties.getPoolCore(),
                socketProperties.getPoolMax(),
                Integer.MAX_VALUE,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>());
        while (true) {
            Client client = new Client(server.accept());
            ClientInitTask clientInitTask = new ClientInitTask(client);
            myThreadPool.execute(clientInitTask);
            ClientPool.clients.add(client);
            System.out.println("------ClientCount:" + ClientPool.clients.size() + "------");
        }

    }
}
