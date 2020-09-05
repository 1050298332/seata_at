package cn.tedu.db_init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.SQLException;


@SpringBootApplication
public class DbInitApplication {
    @Autowired
    private DataSource dataSource;

    public static void main(String[] args) {
        SpringApplication.run(DbInitApplication.class, args);
    }
    @PostConstruct//springboot初始化完成后会自动 运行这个方法
    public void init()throws Exception {
        exec("sql/account.sql");
        exec("sql/order.sql");
        exec("sql/seata-server.sql");
        exec("sql/storage.sql");
    }
    private void exec(String s) throws Exception {
        ClassPathResource r = new ClassPathResource(s,DbInitApplication.class.getClassLoader());
        EncodedResource er = new EncodedResource(r,"UTF-8");
        ScriptUtils.executeSqlScript(dataSource.getConnection(),er);

    }
}
