package ru.alfabank.bcm.optionmanagment.model;

import net.java.ao.Entity;

public interface Todo extends Entity {
    String getDescription();

    void setDescription(String description);

    boolean isComplete();

    void setComplete(boolean complete);
}
