package qvick.post.domain.mapper;

import qvick.annotation.Mapper;
import qvick.post.domain.PostEntity;
import qvick.post.dto.Post;

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
