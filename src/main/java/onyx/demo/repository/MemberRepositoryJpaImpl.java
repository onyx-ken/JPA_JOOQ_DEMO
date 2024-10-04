package onyx.demo.repository;

import lombok.RequiredArgsConstructor;
import onyx.demo.MemberListDTO;
import onyx.demo.jpa.entity.MemberJpaEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Qualifier("jpaMemberRepository")
public class MemberRepositoryJpaImpl implements MemberRepository {

    private final MemberJpaRepository memberJpaRepository;

    @Override
    public List<MemberListDTO> findMemberListByTeamName(String teamName) {
        List<MemberJpaEntity> members = memberJpaRepository.findByTeamName(teamName);
        if (members.isEmpty()) {
            return List.of();
        }
        int totalCount = members.size();
        return members.stream()
                .map(member -> new MemberListDTO(member.getName(), member.getId(), totalCount))
                .toList();
    }
}
