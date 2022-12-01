package ru.alfabank.bcm.optionmanagment.services;

import com.atlassian.activeobjects.external.ActiveObjects;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import net.java.ao.EntityStreamCallback;
import ru.alfabank.bcm.optionmanagment.model.TeamMember;
import ru.alfabank.bcm.optionmanagment.model.TeamMemberDTO;
import ru.alfabank.bcm.optionmanagment.model.TeamMemberRole;
import ru.alfabank.bcm.optionmanagment.model.TeamMemberRolesRel;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class TeamMemberServiceImpl implements TeamMemberService {

    @ComponentImport
    private final ActiveObjects ao;
    private final TeamMemberRoleServiceImpl teamMemberRoleService;
    private final TeamMemberRoleRelServiceImpl teamMemberRoleRelService;

    @Inject
    public TeamMemberServiceImpl(@ComponentImport ActiveObjects ao,
                                 TeamMemberRoleServiceImpl teamMemberRoleService,
                                 TeamMemberRoleRelServiceImpl teamMemberRoleRelService) {
        this.ao = ao;
        this.teamMemberRoleService = teamMemberRoleService;
        this.teamMemberRoleRelService = teamMemberRoleRelService;
    }

    @Override
    public TeamMember add(TeamMemberDTO teamMember) {
        final TeamMember newMember = ao.create(TeamMember.class);
        newMember.setMemberObjectId(teamMember.memberObjectId);
        newMember.setMainObjectForTeamId(teamMember.mainObjectForTeamId);
        newMember.save();

        for (Long roleId : teamMember.roles) {
            TeamMemberRole role = teamMemberRoleService.getByRoleId(roleId);
            if (role == null) {
                role = teamMemberRoleService.add(roleId);
            }

            TeamMemberRolesRel subscriber = teamMemberRoleRelService.add(newMember, role);
        }

        return newMember;
    }

    @Override
    public List<TeamMember> all() {
        List<TeamMember> members = new ArrayList<>();
        ao.stream(TeamMember.class, new EntityStreamCallback<TeamMember, Integer>() {
            @Override
            public void onRowRead(TeamMember teamMember) {
                members.add(teamMember);
            }
        });
        return members;
    }
}
