package onyx.demo.service;

import onyx.demo.MemberListDTO;
import onyx.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(@Qualifier("jooqMemberRepository") MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<MemberListDTO> getAllMemberListByTeamName(String teamName) {
        return memberRepository.findMemberListByTeamName(teamName);
    }
}
