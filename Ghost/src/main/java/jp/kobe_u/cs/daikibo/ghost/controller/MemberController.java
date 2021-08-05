package jp.kobe_u.cs.daikibo.ghost.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.kobe_u.cs.daikibo.ghost.dto.MemberForm;
import jp.kobe_u.cs.daikibo.ghost.dto.ShiftForm;
import jp.kobe_u.cs.daikibo.ghost.entity.Member;
import jp.kobe_u.cs.daikibo.ghost.service.MemberService;

@Controller
@RequestMapping("/admin")
public class MemberController {
    @Autowired
    MemberService mService;

    /**
     * 管理者用・ユーザ登録ページ HTTP-GET /admin/register
     * @param model
     * @return
     */
    @GetMapping("/master")
    String showUserForm(Model model) {
        List<Member> members = mService.getAllMembers();
        model.addAttribute("members", members);
        MemberForm form = new MemberForm();
        model.addAttribute("MemberForm", form);
        // trueだけ渡す
        
        return "master";
    }

    /**
     * 管理者用・ユーザ登録確認ページを表示 HTTP-POST /admin/check
     * @param form
     * @param model
     * @return
     */
    @PostMapping("/check") 
    String checkUserForm(@ModelAttribute(name = "MemberForm") MemberForm form,  Model model) {
        model.addAttribute("MemberForm", form);

        return "check";
    }

    /**
     * 管理者用・ユーザ登録処理 -> 完了ページ HTTP-POST /admin/register
     * @param form
     * @param model
     * @return
     */
    @PostMapping("/registered")
    String createUser(@ModelAttribute(name = "MemberForm") MemberForm form,  Model model) {
        Member m =  mService.createMember(form);
        model.addAttribute("MemberForm", m);

        return "registered";
    }
    
    @GetMapping("/delete/{mid}")
    String deleteUser(@PathVariable String mid, Model model) {
        mService.deleteMember(mid);
        return showUserForm(model);
    }

    /**
     * シフト作成フォームの表示
     * @return
     */
    @GetMapping("/create")
    String showCreateForm(Model model) {
        // trueだけのリスト
        // falseだけのリスト
        ShiftForm form = new ShiftForm();
        model.addAttribute("shiftForm", form);
        return "create_shift";
    }

    /**
     * シフト作成　→　リダイレクト
     */
    @PostMapping("/create")
    String createShift(
        @Validated @ModelAttribute
    )


}