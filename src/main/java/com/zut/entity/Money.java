package com.zut.entity;

public class Money {
    String time;
    Integer moneys;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getMoneys() {
        return moneys;
    }

    public void setMoneys(Integer moneys) {
        this.moneys = moneys;
    }

    @Override
    public String toString() {
        return "Money{" +
                "time='" + time + '\'' +
                ", moneys=" + moneys +
                '}';
    }
}
