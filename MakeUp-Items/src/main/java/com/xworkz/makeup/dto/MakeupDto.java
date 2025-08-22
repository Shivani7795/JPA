package com.xworkz.makeup.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Data
public class MakeupDto {

    private Integer productId;

    @Size(min=2,max=20)
    private String productName;

    @Size(min=2,max=20)
    private String brand;

    @Min(100)@Max(50000)
    private Double price;

    @Min(1)@Max(10)
    private Integer itemCount;
}
