package com.web.frontcontroller;

import java.util.HashMap;

import com.web.controller.Controller;
import com.web.controller.MemberContentController;
import com.web.controller.MemberDeleteController;
import com.web.controller.MemberInsertController;
import com.web.controller.MemberListController;
import com.web.controller.MemberRegisterController;
import com.web.controller.MemberUpdateController;

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
    }
    // Controller 객체 반환
    public Controller getController(String key) {
        return mappings.get(key);
    }
}
