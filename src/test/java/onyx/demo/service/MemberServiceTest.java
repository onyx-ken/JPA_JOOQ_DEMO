package onyx.demo.service;

import onyx.demo.MemberListDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Test
    void getAllMemberListByTeamName_Aespa_ShouldReturnMembers() {
        String teamName = "에스파";
        List<MemberListDTO> members = memberService.getAllMemberListByTeamName(teamName);

        assertThat(members).hasSize(4);
        assertThat(members)
                .extracting(MemberListDTO::getName)
                .containsExactlyInAnyOrder("카리나", "지젤", "윈터", "닝닝");

        for (MemberListDTO dto : members) {
            assertThat(dto.getTotalMemberCount()).isEqualTo(4);
        }
    }

    @Test
    void getAllMemberListByTeamName_LeSSERAFIM_ShouldReturnMembers() {
        String teamName = "르세라핌";
        List<MemberListDTO> members = memberService.getAllMemberListByTeamName(teamName);

        assertThat(members).hasSize(5);
        assertThat(members)
                .extracting(MemberListDTO::getName)
                .containsExactlyInAnyOrder("사쿠라", "김채원", "허윤진", "카즈하", "홍은채");

        for (MemberListDTO dto : members) {
            assertThat(dto.getTotalMemberCount()).isEqualTo(5);
        }
    }

    @Test
    void getAllMemberListByTeamName_NonExistentTeam_ShouldReturnEmptyList() {
        String teamName = "NonExistentTeam";
        List<MemberListDTO> members = memberService.getAllMemberListByTeamName(teamName);

        assertThat(members).isEmpty();
    }
}
