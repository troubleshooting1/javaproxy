package com.conquer.dynamicproxy.CGliblazyload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Description:
 * author: chenqiang
 * date: 2018/7/31 13:15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {
    private String courseName;

    private Date courseTime;
}
