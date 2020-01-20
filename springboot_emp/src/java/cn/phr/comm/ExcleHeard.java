package cn.phr.comm;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
//标题的自定义注解
@Target(ElementType.TYPE)//作用在类上
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcleHeard {

       //是title为默认的
       String title() default "";
}
