package com.project.qvick.domain.post.domain.mapper;

import com.project.qvick.domain.post.client.dto.Post;
import com.project.qvick.domain.post.domain.PostEntity;
import com.project.qvick.global.annotation.Mapper;

@Mapper
public class PostMapper {

    public PostEntity toEntity(Post post) {
        return PostEntity.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .author(post.getAuthor())
                .createdDateTime(post.getCreateDateTime())
                .build();
    }

    public Post toPost(PostEntity postEntity) {
        return Post.builder()
                .id(postEntity.getId())
                .title(postEntity.getTitle())
                .content(postEntity.getContent())
                .author(postEntity.getAuthor())
                .createDateTime(postEntity.getCreatedDateTime())
                .build();
    }

}
