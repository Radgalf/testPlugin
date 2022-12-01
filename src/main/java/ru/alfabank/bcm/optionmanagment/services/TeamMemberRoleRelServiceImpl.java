package ru.alfabank.bcm.optionmanagment.services;

import com.atlassian.activeobjects.external.ActiveObjects;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import net.java.ao.EntityStreamCallback;
import net.java.ao.Query;
import org.apache.commons.compress.utils.Lists;
import ru.alfabank.bcm.optionmanagment.model.TeamMember;
import ru.alfabank.bcm.optionmanagment.model.TeamMemberRole;
import ru.alfabank.bcm.optionmanagment.model.TeamMemberRolesRel;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class TeamMemberRoleRelServiceImpl implements TeamMemberRoleRelService {

    private final ActiveObjects ao;

    @Inject
    public TeamMemberRoleRelServiceImpl(@ComponentImport ActiveObjects ao) {
        this.ao = ao;
    }

    @Override
    public TeamMemberRolesRel add(TeamMember member, TeamMemberRole role) {
        TeamMemberRolesRel rolesRel = ao.create(TeamMemberRolesRel.class);
        rolesRel.setRole(role);
        rolesRel.setTeamMember(member);
        rolesRel.save();
        return rolesRel;
    }

    @Override
    public List<TeamMemberRolesRel> get(TeamMember member, TeamMemberRole role) {
        List<TeamMemberRolesRel> relations = Lists.newArrayList();
        ao.stream(TeamMemberRolesRel.class,
            Query.select().where("ROLE_ID = ? AND TEAM_MEMBER_ID = ?", role.getID(), member.getID()),
            new EntityStreamCallback<TeamMemberRolesRel, Integer>() {
                @Override
                public void onRowRead(TeamMemberRolesRel teamMemberRolesRel) {
                    relations.add(teamMemberRolesRel);
                }
            });
        return relations;
    }
}
