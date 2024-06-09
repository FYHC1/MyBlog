package org.example.myblog.pojo;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class User {
    Integer id;
    @NotEmpty
    String username;
    @NotEmpty
    String password;
}
