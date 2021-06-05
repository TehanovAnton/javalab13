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

public class RegisterNewUserCommand implements Command {
    private UserRepository repository;

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        //проверить что юзера с подобным именем нет
        //на error или login

        Optional<String> login = of(request).map(httpServletRequest -> httpServletRequest.getParameter(LOGIN)),
                         password = of(request).map(httpServletRequest -> httpServletRequest.getParameter(PASSWORD));
        CommandResult commandResult;

        if (login.isEmpty() || password.isEmpty() || login.get().isEmpty() || password.get().isEmpty() || repository.exists(login.get(), password.get())) {
            commandResult = new CommandResult(Page.ERROR_PAGE.getPage(), true);
        }
        else {
            repository.addNew(login.get(), password.get());
            commandResult = new CommandResult(Page.LOGIN_PAGE.getPage(), false);
        }

        return commandResult;
    }

    public RegisterNewUserCommand() {
        this.repository = new UserRepository();
    }
}
