package com.test.demo.exception;

import com.test.demo.exception.common.BaseException;
import lombok.Getter;

@Getter
public class NotFoundException extends BaseException {
    private Class clazz;
    private Object value;
    private Object attribute;

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(Class clazz,
                             Object value,
                             Object attribute
    ) {
        super(String.format("Запись не найдена: %s: по %s='%s'", clazz.getSimpleName(), attribute.toString(), value.toString()));

        this.clazz = clazz;
        this.value = value;
        this.attribute = attribute;
    }
}
