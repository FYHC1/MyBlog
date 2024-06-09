package org.example.myblog.pojo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class Article {
    @NotEmpty
    private String title;
    private Integer id;
    @NotNull
    private String content;
    private LocalDateTime createTime;//创建时间
    private LocalDateTime updateTime;//更新时间
}
