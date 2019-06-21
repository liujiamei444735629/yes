package com.example.tione;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Fengzhuang {
    @Id(autoincrement = true)
    private long id;
    private String name;
    private String price;
    private Integer iv;

    @Override
    public String toString() {
        return "Fengzhuang{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", iv=" + iv +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getIv() {
        return iv;
    }

    public void setIv(Integer iv) {
        this.iv = iv;
    }
    @Keep
    public Fengzhuang(long id, String name, String price, Integer iv) {

        this.id = id;
        this.name = name;
        this.price = price;
        this.iv = iv;
    }

    @Generated(hash = 176043550)
    public Fengzhuang() {
    }
}
