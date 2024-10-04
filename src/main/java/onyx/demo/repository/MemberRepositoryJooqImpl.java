package onyx.demo.repository;

import lombok.RequiredArgsConstructor;
import onyx.demo.MemberListDTO;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

import static onyx.jooq.tables.Member.MEMBER;
import static onyx.jooq.tables.Team.TEAM;

@Repository
@RequiredArgsConstructor
@Qualifier("jooqMemberRepository")
public class MemberRepositoryJooqImpl implements MemberRepository {

    private final DSLContext dsl;

    @Override
    public List<MemberListDTO> findMemberListByTeamName(String teamName) {
        return dsl.select(
                        MEMBER.NAME,
                        MEMBER.ID,
                        DSL.count().over().as("total_member_count")
                )
                .from(MEMBER)
                .join(TEAM)
                    .on(MEMBER.TEAM_ID.eq(TEAM.ID))
                .where(TEAM.NAME.eq(teamName))
                .fetchInto(MemberListDTO.class);
    }
}
