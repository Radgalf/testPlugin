package ru.alfabank.bcm.optionmanagment.services;

import com.atlassian.activeobjects.external.ActiveObjects;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import com.google.common.collect.Lists;
import net.java.ao.EntityStreamCallback;
import net.java.ao.Query;
import ru.alfabank.bcm.optionmanagment.model.TeamMemberRole;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class TeamMemberRoleServiceImpl implements TeamMemberRoleService {
    @ComponentImport
    private final ActiveObjects ao;

    @Inject
    public TeamMemberRoleServiceImpl(@ComponentImport ActiveObjects ao) {
        this.ao = ao;
    }

    @Override
    public TeamMemberRole add(long roleId) {
        TeamMemberRole role = ao.create(TeamMemberRole.class);
        role.setRoleId(roleId);
        role.save();
        return role;
    }

    @Override
    public TeamMemberRole getByRowId(int rowId) {
        return ao.get(TeamMemberRole.class, rowId);
    }

    @Override
    public TeamMemberRole getByRoleId(long roleId) {
        List<TeamMemberRole> roles = Lists.newArrayList();
        ao.stream(
            TeamMemberRole.class,
            Query.select().where("ROLE_ID = ?", roleId),
            new EntityStreamCallback<TeamMemberRole, Integer>() {
                @Override
                public void onRowRead(TeamMemberRole teamMemberRole) {
                    roles.add(teamMemberRole);
                }
            });
        return roles.stream().findFirst().orElse(null);
    }
}
