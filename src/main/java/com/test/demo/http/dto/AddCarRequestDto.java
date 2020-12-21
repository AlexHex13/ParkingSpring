package com.test.demo.http.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddCarRequestDto {

    @NotNull
    private String nameCar;

    @NotNull
    private String numberCar;

}
