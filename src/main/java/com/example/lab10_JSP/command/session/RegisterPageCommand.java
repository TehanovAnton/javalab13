package com.example.lab10_JSP.command.session;

import com.example.lab10_JSP.command.factory.Command;
import com.example.lab10_JSP.command.factory.CommandResult;
import com.example.lab10_JSP.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterPageCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        // отправить на форму регистрации
        CommandResult commandResult = new CommandResult(Page.REGISTER_PAGE.getPage(), false);

        return commandResult;
    }
}
