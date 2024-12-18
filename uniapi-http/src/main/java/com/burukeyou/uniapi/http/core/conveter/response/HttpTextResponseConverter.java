package com.burukeyou.uniapi.http.core.conveter.response;

import java.lang.reflect.Type;

import com.burukeyou.uniapi.http.core.http.response.UniHttpResponse;
import com.burukeyou.uniapi.http.core.response.HttpResponse;
import com.burukeyou.uniapi.http.core.response.HttpTextResponse;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

@Component
public class HttpTextResponseConverter  extends AbstractHttpResponseConverter {

    @Override
    protected boolean isConvert(UniHttpResponse response, MethodInvocation methodInvocation) {
        String contentType = getResponseContentType(response).trim();
        if (contentType.startsWith("text")){
            return true;
        }
        return String.class.equals(getBodyResultType(methodInvocation));
    }

    @Override
    protected HttpResponse<?> doConvert(ResponseConvertContext context) {
        String contentType = getResponseContentType(context.getResponse()).trim();
        Type bodyResultType = getBodyResultType(context.getMethodInvocation());
        if (!String.class.equals(bodyResultType)){
            throw new IllegalArgumentException("the corresponding body content of HTTP is " + contentType +
                    ", method return type must be defined as String type or HttpResponse<String>");
        }
        String bodyString = getResponseBodyString(context.getResponse());
        HttpTextResponse response = new HttpTextResponse(bodyString,context);
        bodyString = super.postAfterBodyString(bodyString,response,context);
        response.setTextValue(bodyString);
        response.setBodyResult(bodyString);
        return response;
    }
}
