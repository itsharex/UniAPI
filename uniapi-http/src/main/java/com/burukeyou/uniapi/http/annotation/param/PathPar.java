package com.burukeyou.uniapi.http.annotation.param;

import java.lang.annotation.*;

/**
 * 支持标记的参数类型举例:
 *       普通值            @HeaderPar("id")   String
 *
 *
 * @author caizhihao
 */
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PathPar {

    String value() default "";
}