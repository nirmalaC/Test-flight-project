package com.api.example.fixture.helpers;

import com.api.example.database.example.ChannelPropertiesDao;
import com.api.example.database.example.models.ChannelPropertiesModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by dwebb on 1/11/2017.
 */
@Component
public class ChannelPropertiesHelper {

    private ChannelPropertiesDao channelDao;

    @Autowired
    public ChannelPropertiesHelper(ChannelPropertiesDao channelDao) {
        this.channelDao = channelDao;
    }

    public List<ChannelPropertiesModel> getAllChannelProperties()
    {
        return channelDao.returnChannelProperties();
    }

    public List<ChannelPropertiesModel> getChannelProperties(String channel)
    {
        return channelDao.returnChannelProperties();
    }

}
