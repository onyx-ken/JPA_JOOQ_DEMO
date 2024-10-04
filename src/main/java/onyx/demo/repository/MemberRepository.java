package onyx.demo.repository;

import onyx.demo.MemberListDTO;

import java.util.List;

public interface MemberRepository {
    List<MemberListDTO> findMemberListByTeamName(String teamName);
}
