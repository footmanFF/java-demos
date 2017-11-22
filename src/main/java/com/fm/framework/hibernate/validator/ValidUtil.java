package com.fm.framework.hibernate.validator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValidUtil {
    private static final Logger log = LoggerFactory.getLogger(ValidUtil.class);

    private static Validator validator;

    static {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    public static <T> Map<String, StringBuffer> validate(T obj) {
        Map<String, StringBuffer> errorMap = null;
        Set<ConstraintViolation<T>> set = validator.validate(obj);
        if (set != null && set.size() > 0) {
            errorMap = new HashMap<>();
            String property;
            for (ConstraintViolation<T> cv : set) {
                //这里循环获取错误信息，可以自定义格式  
                property = cv.getPropertyPath().toString();
                
                if (errorMap.get(property) != null) {
                    errorMap.get(property).append("," + cv.getMessage());
                } else {
                    StringBuffer sb = new StringBuffer();
                    sb.append(cv.getMessage());
                    errorMap.put(property, sb);
                }
            }
        }
        return errorMap;
    }

    public static void main(String[] args) {
        SomeBean someBean = new SomeBean();
        someBean.setField("");
        long s = System.currentTimeMillis();
        Map<String, StringBuffer> map1 = validate(someBean);
        for (int i = 0; i < 100000; i++) {
            Map<String, StringBuffer> map = validate(someBean);
        }
        System.out.println("cost: " + (System.currentTimeMillis() - s));
    }

    @Data
    static class SomeBean {

        @NotBlank( message = "xxx" )
        private String field;

    }

}
