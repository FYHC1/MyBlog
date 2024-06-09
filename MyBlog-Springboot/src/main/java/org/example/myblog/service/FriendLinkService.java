package org.example.myblog.service;

import org.example.myblog.pojo.FriendLink;

public interface FriendLinkService {
    FriendLink[] getFriendLinkList();

    void addFriendLink();
}
