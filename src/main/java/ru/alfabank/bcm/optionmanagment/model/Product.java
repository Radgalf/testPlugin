package ru.alfabank.bcm.optionmanagment.model;

import net.java.ao.Entity;

public interface Product extends Entity {
    String getName();

    void setName(String name);

    long getAge();

    void setAge(long age);
}
