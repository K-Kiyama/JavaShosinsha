package jp.kobe_u.cs.daikibo.ghost.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.kobe_u.cs.daikibo.ghost.dto.MemberForm;
import jp.kobe_u.cs.daikibo.ghost.entity.Member;
import jp.kobe_u.cs.daikibo.ghost.repository.MemberRepository;

/**
 * メンバーのCRUDを行うサービス
 */
@Service
public class MemberService {
    @Autowired
    MemberRepository mRepo;

    /**
     * メンバーを作成する (C)
     * @param form
     * @return
     */
    public Member createMember(MemberForm form) {
        String mid = form.getMid();

        Member m = form.toEntity();
        return mRepo.save(m);
    }

    /**
     * メンバーを取得する (R)
     * @param mid
     * @return
     */
    public Member getMember(String mid) {
        Member m = mRepo.findById(mid).orElseThrow(
            ()-> new NoResultException("No such person exists Person "));
        return m;
    }

    /**
     * 全メンバーを取得する (R)
     * @return
     */
    public List<Member> getAllMembers() {
        return mRepo.findAll();
    }

    /**
     * メンバーを削除する (D)
     */
    public void deleteMember(String mid) {
        Member m = getMember(mid);
        mRepo.delete(m);
    }

}
