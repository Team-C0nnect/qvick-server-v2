package com.project.qvick.domain.post.client.dto;

import com.project.qvick.global.common.entity.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    private Long id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime createDateTime;
    private LocalDateTime modifiedDateTime;

}
