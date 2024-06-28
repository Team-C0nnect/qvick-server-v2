package qvick.post.application.service;

import qvick.post.application.util.PostUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import qvick.post.domain.mapper.PostMapper;
import qvick.post.domain.repository.jpa.PostRepository;
import qvick.post.dto.Post;
import qvick.post.request.PostDeleteRequest;
import qvick.post.request.PostEditRequest;
import qvick.post.request.PostRegisterRequest;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;
    private final PostMapper postMapper;
    private final PostUtil postUtil;

    @Override
    public void postRegister(PostRegisterRequest request) {
        postUtil.savePost(request);
    }

    @Override
    public Post postFind(Long postId) {
        return postUtil.findPost(postId);
    }

    @Override
    public void postEdit(PostEditRequest request){
        Post post = postUtil.findPost(request.getPostId());
        post.setTitle(request.getTitle());
        post.setContent(request.getContent());
        postRepository.save(postMapper.toEntity(post));
    }

    @Override
    public void postDelete(PostDeleteRequest request){
        postRepository.deleteById(request.getPostId());
    }

}
