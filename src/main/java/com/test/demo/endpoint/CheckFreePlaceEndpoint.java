package com.test.demo.endpoint;


import com.test.demo.exception.NotFoundException;

public interface CheckFreePlaceEndpoint {
    Boolean checkFreePlace() throws NotFoundException;
    Long getFreePlace() throws NotFoundException;
}
