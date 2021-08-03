package jp.kobe_u.cs.daikibo.ghost.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import jp.kobe_u.cs.daikibo.ghost.entity.Member;
@Repository
public interface MemberRepository extends CrudRepository<Member, String>{
    List<Member> findAll();
}