package com.jcg.struts2.jsp;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Sashini Tharuka on 10/14/2020.
 */
public class ProfileAction extends ActionSupport {
    public String execute() {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();

        String s = (String) session.getAttribute("login");
        if (s != null && !s.equals("")) {
            return "success";
        } else {
            return "error";
        }

    }
}
