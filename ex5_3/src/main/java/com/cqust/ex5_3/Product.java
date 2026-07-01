package com.cqust.ex5_3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
//implements Serializable这个类支持序列化和反序列化，转二进制
public class Product implements Serializable {
    private Integer id;
    private String name;
    private String brand;
    private Double price;
}
