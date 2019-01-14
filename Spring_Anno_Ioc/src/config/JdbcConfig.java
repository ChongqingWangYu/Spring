package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.wangyu.util.DBAssit;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * 和jdbc相关的配置类
 */
public class JdbcConfig {
    @Value("${jdbc.driver}")
    private String jdbcDriver;
    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${jdbc.username}")
    private String userName;
    @Value("${jdbc.password}")
    private String passwrod;

    /**
     * @param dataSource
     * @return
     * @Bean注解： 作用：把当前方法的返回值作为bean对象存入spring容器之中。
     * 属性：
     * name：用于指定bean的id。如果没写该属性的话，默认值是当前的方法名。
     * Spring框架给带有bean注解的方法创建对象时，如果方法有参数，会用方法参数的数据类型前往容器中查找。
     * 如果能找到唯一的一个类型匹配，则直接给方法的参数注入。
     * 如果找不到，就报错
     * 如果找到多个，就需要借助Qualifier注解，此时它可以独立使用
     */
    @Bean("dbAssit")
    public DBAssit createDBAssit(@Qualifier("dataSource") DataSource dataSource) {
        return new DBAssit(dataSource);
    }

    /**
     * 创建数据源
     *
     * @return
     */
    @Bean("dataSource")
    public DataSource createDataSource() {
        try {
            ComboPooledDataSource ds = new ComboPooledDataSource();
            ds.setDriverClass(jdbcDriver);
            ds.setJdbcUrl(jdbcUrl);
            ds.setUser(userName);
            ds.setPassword(passwrod);
            return ds;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
