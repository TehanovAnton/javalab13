package com.example.lab10_JSP.command.authorization;

import com.example.lab10_JSP.command.factory.Command;
import com.example.lab10_JSP.command.factory.CommandResult;
import com.example.lab10_JSP.model.user.UserRepository;
import com.example.lab10_JSP.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

import static com.example.lab10_JSP.command.authorization.constants.AuthorizationConstants.LOGIN;
import static com.example.lab10_JSP.command.authorization.constants.AuthorizationConstants.PASSWORD;
import static java.util.Optional.of;

public class LoginCommand implements Command {
    private UserRepository repository;

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        // убелиться что введены верные данные
        Optional<String> login = of(request).map(httpServletRequest -> httpServletRequest.getParameter(LOGIN)),
                         password = of(request).map(httpServletRequest -> httpServletRequest.getParameter(PASSWORD));

        CommandResult commandResult = login.isEmpty() || password.isEmpty() || login.get().isEmpty() || password.get().isEmpty() ||
                !repository.exists(login.get(), password.get()) ?
                new CommandResult(Page.ERROR_PAGE.getPage(), true) :    //  на error
                new CommandResult(Page.WElCOME_PAGE.getPage(), false);  //  на welcome

        return commandResult;
    }

    public LoginCommand() {
        this.repository = new UserRepository();
    }
}
