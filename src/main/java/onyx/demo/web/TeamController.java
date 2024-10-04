package onyx.demo.web;

import lombok.RequiredArgsConstructor;
import onyx.demo.MemberListDTO;
import onyx.demo.service.MemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/teams")
public class TeamController {

    private final MemberService memberService;

    @GetMapping("/{teamName}/members")
    public List<MemberListDTO> getMembersByTeamName(@PathVariable String teamName) {
        return memberService.getAllMemberListByTeamName(teamName);
    }
}
