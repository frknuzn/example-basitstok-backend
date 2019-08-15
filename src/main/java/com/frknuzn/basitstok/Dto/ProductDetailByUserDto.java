package com.frknuzn.basitstok.Dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Product Data Transfer Object")
public class ProductDetailByUserDto {

    @ApiModelProperty(required = true,value = "ID")
    private Long id;

    @ApiModelProperty(required = true,value = "Product Name")
    private String productName;

    @ApiModelProperty(required = true,value = "Product quantities")
    private int quantities;
    @ApiModelProperty(required = true,value = "Product Price")
    private float price;

    private LoginUserDto user;
}
