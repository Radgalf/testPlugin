package ru.alfabank.bcm.optionmanagment.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TeamMemberDTO {
    public int id;
    public Long memberObjectId;
    public Long mainObjectForTeamId;
    public Long[] roles;

    public TeamMemberDTO() {
    }

    public TeamMemberDTO(TeamMember teamMember) {
        this.id = teamMember.getID();
        this.memberObjectId = teamMember.getMemberObjectId();
        this.mainObjectForTeamId = teamMember.getMainObjectForTeamId();
        List<TeamMemberRole> collect = Arrays.stream(teamMember.getRoles()).collect(Collectors.toList());
        this.roles = (Long[]) Arrays.stream(teamMember.getRoles()).map(TeamMemberRole::getRoleId).toArray();
    }
}
