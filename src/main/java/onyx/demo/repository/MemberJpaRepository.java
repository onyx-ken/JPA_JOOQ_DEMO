package onyx.demo.repository;

import onyx.demo.jpa.entity.MemberJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberJpaRepository extends JpaRepository<MemberJpaEntity, Long> {
    List<MemberJpaEntity> findByTeamName(String teamName);
}
