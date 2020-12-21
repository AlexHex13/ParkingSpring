package com.test.demo.domain;


import com.sun.istack.NotNull;
import com.test.demo.domain.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "cars")
public class Car extends BaseEntity {

    @NotNull
    @Column(name = "name_car")
    private String nameCar;

    @NotNull
    @Column(name = "number_car")
    private String numberCar;

}
