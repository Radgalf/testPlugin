package ru.alfabank.bcm.optionmanagment.services;

import com.atlassian.activeobjects.tx.Transactional;
import ru.alfabank.bcm.optionmanagment.model.TeamMember;
import ru.alfabank.bcm.optionmanagment.model.TeamMemberDTO;

import java.util.List;

@Transactional
public interface TeamMemberService {
    TeamMember add(TeamMemberDTO teamMember);

    List<TeamMember> all();
}
