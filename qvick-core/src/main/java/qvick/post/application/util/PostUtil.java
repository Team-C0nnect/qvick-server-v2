package qvick.post.application.util;

import lombok.RequiredArgsConstructor;
import qvick.annotation.Util;
import qvick.post.domain.mapper.PostMapper;
import qvick.post.domain.repository.jpa.PostRepository;
import qvick.post.dto.Post;
import qvick.post.exception.PostNotFoundException;
import qvick.post.request.PostRegisterRequest;
import qvick.user.application.util.UserUtil;

@Util
@RequiredArgsConstructor
public class PostUtil {

    private final PostRepository postRepository;
    private final PostMapper postMapper;
    private final UserUtil userUtil;

    public Post findPost(Long postId) {
        return postRepository
                .findById(postId)
                .map(postMapper::toPost)
                .orElseThrow(()-> PostNotFoundException.EXCEPTION);
    }

    public void savePost(PostRegisterRequest request){
        Post post = Post.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .author(userUtil.getUser().getName())
                .build();
        postRepository.save(postMapper.toEntity(post));
    }

}
