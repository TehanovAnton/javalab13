package com.example.lab10_JSP.command.factory;

import com.example.lab10_JSP.command.authorization.LoginCommand;
import com.example.lab10_JSP.command.authorization.RegisterNewUserCommand;
import com.example.lab10_JSP.command.chanels.AddNewChanelCommand;
import com.example.lab10_JSP.command.chanels.WelcomeCommand;
import com.example.lab10_JSP.command.session.LoginPageCommand;
import com.example.lab10_JSP.command.session.RegisterPageCommand;

public class CommandFactory {
    public static Command create(String command) {
        command = command.toUpperCase();
        System.out.println(command);
        CommandType commandEnum = CommandType.valueOf(command);
        Command resultCommand;

        switch (commandEnum){
            case LOGIN: {
                resultCommand = new LoginCommand(); break;
            }
            case REGISTER_NEW_USER: {
                resultCommand = new RegisterNewUserCommand(); break;
            }
            case ADD_NEW_CHANNEL: {
                resultCommand = new AddNewChanelCommand(); break;
            }
            case LOGIN_PAGE: {
                resultCommand = new LoginPageCommand(); break;
            }
            case WELCOME: {
                resultCommand = new WelcomeCommand(); break;
            }
            case REGISTRATION_PAGE: {
                resultCommand = new RegisterPageCommand(); break;
            }
            default: {
                throw new IllegalArgumentException("InvalidCommand" + commandEnum);
            }
        }

        return resultCommand;
    }
}
