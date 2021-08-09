package jp.kobe_u.cs.daikibo.ghost.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.kobe_u.cs.daikibo.ghost.dto.ShiftForm;
import jp.kobe_u.cs.daikibo.ghost.entity.Member;
import jp.kobe_u.cs.daikibo.ghost.entity.Shift;
import jp.kobe_u.cs.daikibo.ghost.service.MemberService;
import jp.kobe_u.cs.daikibo.ghost.service.ShiftService;

@Controller
public class ShiftController {
    @Autowired
    MemberService mService;
    @Autowired
    ShiftService sService;
    
    /**
     * トップページ
     */
    @GetMapping("/")
    String showLoginForm(Model model) {
        return "login";
    }

    /**
     * ログイン処理
     */
    @PostMapping("/login")
    String login(@RequestParam String mid, Model model) {
        Member m = mService.getMember(mid); // 存在チェック
        return "redirect:/" + m.getMid() + "/list";
    }

    /**
     * ユーザのカレンダーページ
     */
    @GetMapping("/{mid}/calender")
    String showCalender(@PathVariable String mid, Model model) {
        Member m = mService.getMember(mid);
        model.addAttribute("member", m);
        List<Shift> shifts = sService.getShiftList();
        model.addAttribute("shifts", shifts);
        return "calender";
    }

    /**
     * ユーザのカレンダーページ超簡易版
     */
    @GetMapping("/{mid}/list")
    String showList(@PathVariable String mid, Model model) {
        Member m = mService.getMember(mid);
        model.addAttribute("member", m);
        List<Shift> myShifts = sService.getTrueShiftList(mid);
        model.addAttribute("myShifts", myShifts);
        List<Shift> mySubmitedShifts = sService.getFalseShiftList(mid);
        model.addAttribute("submitedShifts", mySubmitedShifts);
        return "list";
    }

    /**
     * シフト提出ページ
     */
    @GetMapping("/{mid}/submit")
    String showSubmitForm(@PathVariable String mid, Model model) {
        Member m = mService.getMember(mid);
        model.addAttribute("member", m);
        ShiftForm form = new ShiftForm();
        model.addAttribute("shiftForm", form);
        List<Shift> shifts = sService.getShiftList();
        model.addAttribute("shifts", shifts);
        return "submit_shift_poc";
    }

    /**
     * シフト提出　→　リダイレクト
     * @throws ParseException
     */
    @PostMapping("/{mid}/submit")
    String submitShift(
        @PathVariable String mid,
        @Validated @ModelAttribute(name = "shiftForm") ShiftForm form, 
        Model model
    ) throws ParseException { 
        sService.createShift(mid, form);
        return "redirect:/" + mid + "/list";
    }

}
