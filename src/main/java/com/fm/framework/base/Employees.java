package com.fm.framework.base;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

/**
 * Created by zhangli on 2017/5/1.
 */
@Entity
@Data
@Table(name = "employees")
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long emp_no;
    private Date birth_date;
    private String first_name;
    private String last_name;
    @Column(columnDefinition = "enum('F', 'M')")
    private String gender;
    private Date hire_date;

}
