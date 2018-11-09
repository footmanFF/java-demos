package com.footmanff.mockneat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author footmanff on 2018/8/17.
 */
public class User implements Serializable {

    private static final long serialVersionUID = 2236487330421768243L;
    
    private Double _Double;
    private double _double;
    private Float _Float;
    private float _float;
    private Integer integer;
    private int _int;
    private Long _Long;
    private long _long;
    private String string;
    private Date date;
    private BigDecimal bigDecimal;
    private Group group;
    private List<Group> groupList;

    public List<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Group> groupList) {
        this.groupList = groupList;
    }

    public Double get_Double() {
        return _Double;
    }

    public void set_Double(Double _Double) {
        this._Double = _Double;
    }

    public double get_double() {
        return _double;
    }

    public void set_double(double _double) {
        this._double = _double;
    }

    public Float get_Float() {
        return _Float;
    }

    public void set_Float(Float _Float) {
        this._Float = _Float;
    }

    public float get_float() {
        return _float;
    }

    public void set_float(float _float) {
        this._float = _float;
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }

    public int get_int() {
        return _int;
    }

    public void set_int(int _int) {
        this._int = _int;
    }

    public Long get_Long() {
        return _Long;
    }

    public void set_Long(Long _Long) {
        this._Long = _Long;
    }

    public long get_long() {
        return _long;
    }

    public void set_long(long _long) {
        this._long = _long;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getBigDecimal() {
        return bigDecimal;
    }

    public void setBigDecimal(BigDecimal bigDecimal) {
        this.bigDecimal = bigDecimal;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
