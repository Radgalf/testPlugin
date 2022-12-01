package ru.alfabank.bcm.optionmanagment.services;

import com.atlassian.activeobjects.tx.Transactional;
import ru.alfabank.bcm.optionmanagment.model.TeamMemberRole;

@Transactional
public interface TeamMemberRoleService {
    TeamMemberRole add(long roleId);

    TeamMemberRole getByRowId(int id);

    TeamMemberRole getByRoleId(long roleId);


}
