package com.web.frontcontroller;

import com.web.controller.*;

import java.util.HashMap;

public class HandlerMapping {
    private HashMap<String, Controller> mappings;

    public HandlerMapping() {
        mappings = new HashMap<>();
        mappings.put("/memberList.do", new MemberListController());
        mappings.put("/memberInsert.do", new MemberInsertController());
        mappings.put("/memberUpdate.do", new MemberUpdateController());
        mappings.put("/memberDelete.do", new MemberDeleteController());
        mappings.put("/memberContent.do", new MemberContentController());
        mappings.put("/memberRegister.do", new MemberRegisterController());
        mappings.put("/memberLogin.do", new MemberLoginController());
        mappings.put("/memberLogout.do", new MemberLogoutController());
    }
    // Controller 객체 반환
    public Controller getController(String key) {
        return mappings.get(key);
    }
}
