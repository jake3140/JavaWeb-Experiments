package com.cqust.ex5_1;

import jakarta.servlet.http.HttpServlet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data//记得刷新maven才有
@NoArgsConstructor//无参构造
@AllArgsConstructor//全参构造
public class student implements Serializable {
    private Integer stuId;
    private String name;
    private String gender;
    private LocalDate birthday;
    private String phone;
}
