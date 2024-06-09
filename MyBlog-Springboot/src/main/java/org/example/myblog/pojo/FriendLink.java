package org.example.myblog.pojo;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class FriendLink {
    private int id;
    @NotEmpty
    private int fname;
    @NotEmpty
    private String link;

}
