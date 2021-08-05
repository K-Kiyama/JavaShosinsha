package jp.kobe_u.cs.daikibo.ghost.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import jp.kobe_u.cs.daikibo.ghost.entity.Shift;
@Repository
public interface ShiftRepository extends CrudRepository<Shift, String>{
    List<Shift> findAll();

    Shift findById(long seq);

    List<Shift> findByMid(String mid);

    List<Shift> findByFlag(boolean flag);

    List<Shift> findByMidAndFlag(String mid,boolean flag);
}