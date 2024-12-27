package com.burukeyou.uniapi.http.annotation.param;

import java.lang.annotation.*;

/**
 * Mark the HTTP request body content in binary form: corresponding content type is application/octet stream
 *
 * <pre>
 *  Support parameter types for tags：
 *      InputStream
 *      File
 *      InputStreamSource
 *      byte[]
 *</pre>
 *
 * @author caizhihao
 */
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BodyBinaryPar {

}
