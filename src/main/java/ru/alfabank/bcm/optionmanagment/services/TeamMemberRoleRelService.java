package ru.alfabank.bcm.optionmanagment.services;

import com.atlassian.activeobjects.tx.Transactional;
import ru.alfabank.bcm.optionmanagment.model.TeamMember;
import ru.alfabank.bcm.optionmanagment.model.TeamMemberRole;
import ru.alfabank.bcm.optionmanagment.model.TeamMemberRolesRel;

import java.util.List;

@Transactional
public interface TeamMemberRoleRelService {
    TeamMemberRolesRel add(TeamMember member, TeamMemberRole role);

    List<TeamMemberRolesRel> get(TeamMember member, TeamMemberRole role);
}
