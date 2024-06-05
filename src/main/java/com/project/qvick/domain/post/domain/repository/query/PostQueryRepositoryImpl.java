package com.project.qvick.domain.post.domain.repository.query;

import com.project.qvick.domain.post.client.dto.Post;
import com.project.qvick.domain.post.client.dto.request.PostSearchRequest;
import com.project.qvick.global.common.dto.request.PageRequest;
import com.project.qvick.global.exception.BadRequestException;
import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.project.qvick.domain.post.domain.QPostEntity.postEntity;
import static com.project.qvick.domain.user.domain.QUserEntity.userEntity;

@Repository
@RequiredArgsConstructor
public class PostQueryRepositoryImpl implements PostQueryRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Post> postList(PageRequest request){
        return jpaQueryFactory
                .select(postListConstructorExpression())
                .from(postEntity)
                .offset((request.getPage() - 1) * request.getSize())
                .limit(request.getSize())
                .orderBy(postEntity.id.asc())
                .fetch();
    }

    @Override
    public List<Post>postSearch(PostSearchRequest request){
        return jpaQueryFactory
                .select(postListConstructorExpression())
                .from(userEntity)
                .where(eqTitle(request.getTitle()))
                .offset((request.getPage() - 1) * request.getSize())
                .limit(request.getSize())
                .orderBy(userEntity.id.asc())
                .fetch();
    }

    private ConstructorExpression<Post> postListConstructorExpression(){
        return Projections.constructor(Post.class,
                postEntity.id,
                postEntity.title,
                postEntity.content,
                postEntity.author
        );
    }

    private BooleanExpression eqTitle(String title) {
        if(title.isEmpty()){
            throw BadRequestException.EXCEPTION;
        }
        return userEntity.name.eq(title);
    }

}
