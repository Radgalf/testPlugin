package ru.alfabank.bcm.optionmanagment.model;

import net.java.ao.Entity;

public interface TeamMemberRolesRel extends Entity {

    TeamMember getTeamMember();

    void setTeamMember(TeamMember tm);

    TeamMemberRole getRole();

    void setRole(TeamMemberRole role);
}
