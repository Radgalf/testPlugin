package ru.alfabank.bcm.optionmanagment.model;

import net.java.ao.Entity;
import net.java.ao.schema.Table;

@Table("RolesForMembers")
public interface TeamMemberRolesRel extends Entity {

    TeamMember getTeamMember();

    void setTeamMember(TeamMember tm);

    TeamMemberRole getRole();

    void setRole(TeamMemberRole role);
}
