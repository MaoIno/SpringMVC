package com.Test1.vi;

public class Student {
    private String rname;
    private Integer rage;

    @Override
    public String toString() {
        return "Student{" +
                "rname='" + rname + '\'' +
                ", rage=" + rage +
                '}';
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public Integer getRage() {
        return rage;
    }

    public void setRage(Integer rage) {
        this.rage = rage;
    }
}
