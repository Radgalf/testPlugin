package ru.alfabank.bcm.optionmanagment.model;

import net.java.ao.Entity;
import net.java.ao.ManyToMany;
import net.java.ao.schema.Table;

@Table("TeamMembers")
public interface TeamMember extends Entity {
    Long getMemberObjectId();

    void setMemberObjectId(Long memberObjectId);

    Long getMainObjectForTeamId();

    void setMainObjectForTeamId(Long mainObjectForTeamId);

    @ManyToMany(value = TeamMemberRolesRel.class)
    TeamMemberRole[] getRoles();
}
