package com.example.lab10_JSP.model.channel;

public interface IChannelRepository {
    public boolean exists(String channelName, String owner);
    public void addNew(String channelName, String owner);
}
