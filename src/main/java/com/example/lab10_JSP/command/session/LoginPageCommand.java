package com.example.lab10_JSP.command.session;

import com.example.lab10_JSP.command.factory.Command;
import com.example.lab10_JSP.command.factory.CommandResult;
import com.example.lab10_JSP.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginPageCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        //отправить на login

        CommandResult commandResult = new CommandResult(Page.LOGIN_PAGE.getPage(), false);

        return  commandResult;
    }
}
