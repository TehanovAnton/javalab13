package com.example.lab10_JSP.command.chanels;

import com.example.lab10_JSP.command.factory.Command;
import com.example.lab10_JSP.command.factory.CommandResult;
import com.example.lab10_JSP.model.channel.ChannelRepository;
import com.example.lab10_JSP.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

import static com.example.lab10_JSP.command.chanels.constants.ChanelConstants.NEWCHANNEL;
import static com.example.lab10_JSP.command.chanels.constants.ChanelConstants.NEWOWNER;
import static java.util.Optional.of;

public class AddNewChanelCommand implements Command {
    private ChannelRepository repository;

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        //проверить нет ли такого же
        //добавить новый канал
        Optional<String> channel = of(request).map(httpServletRequest -> httpServletRequest.getParameter(NEWCHANNEL)),
                         owner = of(request).map(httpServletRequest -> httpServletRequest.getParameter(NEWOWNER));

        CommandResult commandResult;

        if (channel.get().isEmpty() || owner.isEmpty() || repository.exists(channel.get(), owner.get())) {
            commandResult = new CommandResult(Page.ERROR_PAGE.getPage(), true);
        }
        else {
            repository.addNew(channel.get(), owner.get());
            commandResult = new CommandResult(Page.WElCOME_PAGE.getPage(), false);
        }

        return commandResult;
    }

    public AddNewChanelCommand() {
        repository = new ChannelRepository();
    }
}
