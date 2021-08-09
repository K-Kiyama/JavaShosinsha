package jp.kobe_u.cs.daikibo.ghost.service;


import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.kobe_u.cs.daikibo.ghost.dto.ShiftForm;
import jp.kobe_u.cs.daikibo.ghost.entity.Shift;
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
    public Shift createShift(String mid, ShiftForm form) throws ParseException {
        mService.getMember(mid); //実在メンバーか確認
        Shift shift = form.toEntity(mid);
        shift.setMid(mid);
        return sRepo.save(shift);
    }

    /**
     * Shiftを1つ取得する (R)
     * @param seq
     * @return
     */
    public Shift getShift(Long seq) {
        Shift shift = sRepo.findBySeq(seq);
        return shift;
    }

    /**
     * あるメンバーのshiftリストを取得する (R)
     * @param mid
     * @return
     */
    public List<Shift> getShiftList(String mid) {
        return sortShiftList(sRepo.findByMid(mid));
    }

    /**
     * 全員のShiftリストを取得する (R)
     * @return
     */
    public List<Shift> getShiftList() {
        return sortShiftList(sRepo.findAll());
    }

    /**
     * 確定しているShiftを取得する
     * @param date
     * @param flag
     * @return
     */
    public List<Shift> getTrueShift(){
        return sortShiftList(sRepo.findByFlag(true));
    }

    /**
     * 確定していないShiftを取得
     * @return
     */
    public List<Shift> getFalseShift() {
        return sortShiftList(sRepo.findByFlag(false));
    }

    /**
     * あるメンバーの確定shiftリストを取得する (R)
     * @param mid
     * @return
     */
    public List<Shift> getTrueShiftList(String mid) {
        return sortShiftList(sRepo.findByMidAndFlag(mid, true));
    }

    /**
     * あるメンバーの確定していないshiftリストを取得する (R)
     * @param mid
     * @return
     */
    public List<Shift> getFalseShiftList(String mid) {
        return sortShiftList(sRepo.findByMidAndFlag(mid, false));
    }

    /**
     * Shiftを確定させる
     * @param mid 完了者
     * @param seq 確定するShiftの番号
     * @return
     */
    public Shift done(Long seq) {
        Shift shift = getShift(seq);
        shift.setFlag(true);
        return sRepo.save(shift);
    }

    /**
     * シフトリストを日付順にソートする
     * @param list
     * @return
     */
    public List<Shift> sortShiftList(List<Shift> list) {
        list.sort((a, b) -> (int)a.getDate().getTime() - (int)b.getDate().getTime());
        return list;
    }


}
