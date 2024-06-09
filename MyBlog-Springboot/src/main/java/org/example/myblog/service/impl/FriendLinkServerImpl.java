package org.example.myblog.service.impl;

import org.example.myblog.mapper.FriendLinkMapper;
import org.example.myblog.pojo.FriendLink;
import org.example.myblog.service.FriendLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendLinkServerImpl implements FriendLinkService {
    @Autowired
    FriendLinkMapper friendLinkMapper;

    @Override
    public FriendLink[] getFriendLinkList() {
        return friendLinkMapper.getAll();
    }

    @Override
    public void addFriendLink() {
        friendLinkMapper.addFriendLink();
    }
}
