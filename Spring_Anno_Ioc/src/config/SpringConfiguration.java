package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Spring的配置类，作用相当于bean.xml文件
 * @Configuration
 * 它就相当于表明当前类是spring的配置类。
 * 如果只是写到AnnotationConfigApplicationContext构造函数中的字节码，可以不写。
 * 如果是加载要扫描的包时，需要读到此类的配置，同时又没把此类的字节码提供给AnnotationConfigApplicationContext构造函数，则必须写。
 */
//@Configuration
@ComponentScan({"com.wangyu","config"})//指定创建容器时要扫描的包
@Import(JdbcConfig.class)//用于导入其他的配置类
@PropertySource("config/jdbcConfig.properties")//导入配置文件，早起版本应写为"classpath:config/jdbcConfig.propertie"
public class SpringConfiguration {

    /**
     * 在spring 4.3以前的版本，需要手动配置占位符解析器
     * @return
     */
//    @Bean
//    public static PropertySourcesPlaceholderConfigurer create(){
//        return new PropertySourcesPlaceholderConfigurer();
//    }
}
