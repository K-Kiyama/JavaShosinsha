package jp.kobe_u.cs.daikibo.ghost.dto;

import lombok.Data;
import jp.kobe_u.cs.daikibo.ghost.entity.Member;

/**
 * メンバーの登録フォーム
 */
@Data
public class MemberForm {
    String mid; //メンバーID．
    String name; //名前

    public Member toEntity() {
        Member m = new Member(mid, name);
        return m;
    }

}
