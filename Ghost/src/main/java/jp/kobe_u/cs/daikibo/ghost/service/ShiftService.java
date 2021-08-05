package jp.kobe_u.cs.daikibo.ghost.service;


import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.kobe_u.cs.daikibo.ghost.dto.ShiftForm;
import jp.kobe_u.cs.daikibo.ghost.entity.Shift;
//import jp.kobe_u.cs.daikibo.ghost.exception.ToDoAppException;
import jp.kobe_u.cs.daikibo.ghost.repository.ShiftRepository;

@Service
public class ShiftService {
    @Autowired
    MemberService mService;
    @Autowired
    ShiftRepository sRepo;
    /**
     * Shiftを作成する (C)
     * @param mid 作成者
     * @param form フォーム
     * @return
     * @throws ParseException
     */
    public Shift createShift(String mid, Date date, ShiftForm form) throws ParseException {
        mService.getMember(mid); //実在メンバーか確認
        Shift shift = form.toEntity();
        shift.setMid(mid);
        shift.setDate(date);
        return sRepo.save(shift);
    }

    /**
     * 
     * Shiftを1つ取得する (R)
     * @param seq
     * @return
     */
    public Shift getShift(Long seq) {
        Shift shift = sRepo.findById(seq);
        return shift;
    }

    /**
     * あるメンバーのshiftリストを取得する (R)
     * @param mid
     * @return
     */
    public List<Shift> getShiftList(String mid) {
        return sRepo.findByMid(mid);
    }
    

    /**
     * 全員のShiftリストを取得する (R)
     * @return
     */
    public List<Shift> getShiftList() {
        return sRepo.findAll();
    }

    /**
     * 確定しているShiftを取得する
     * @param date
     * @param flag
     * @return
     */
    public List<Shift> getTrueShift(){
        return sRepo.findByFlag(true);
    }


    /**
     * Shiftを確定させる
     * @param mid 完了者
     * @param seq 確定するShiftの番号
     * @return
     */
    public Shift done(String mid, Long seq) {
        Shift shift = getShift(seq);
        
        shift.setFlag(true);
        return sRepo.save(shift);
    }


}
