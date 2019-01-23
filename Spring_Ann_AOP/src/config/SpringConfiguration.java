package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * spring的配置类，相当于bean.xml
 *
 * @author WangYu
 * @create 2019/01/23 20:02
 */
@Configuration
@ComponentScan("com.wangyu")
@EnableAspectJAutoProxy
public class SpringConfiguration {

}
