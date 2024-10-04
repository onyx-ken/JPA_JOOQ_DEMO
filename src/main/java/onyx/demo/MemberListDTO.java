package onyx.demo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberListDTO {
    private String name;
    private long memberId;
    private int totalMemberCount; // DB에서의 반환컬럼명은 total_member_count
}
