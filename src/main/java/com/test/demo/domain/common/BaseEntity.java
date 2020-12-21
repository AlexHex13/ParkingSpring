package com.test.demo.domain.common;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
}
