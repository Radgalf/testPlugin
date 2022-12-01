package ru.alfabank.bcm.optionmanagment.model;

import net.java.ao.Entity;
import net.java.ao.ManyToMany;

public interface TeamMemberRole extends Entity {

    @ManyToMany(value = TeamMemberRolesRel.class)
    TeamMember[] getMembers();

    long getRoleId();

    void setRoleId(long roleId);
}
