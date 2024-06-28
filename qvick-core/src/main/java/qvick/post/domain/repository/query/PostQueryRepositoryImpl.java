package qvick.post.domain.repository.query;

import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import qvick.common.client.dto.request.PageRequest;
import qvick.exception.BadRequestException;
import qvick.post.dto.Post;
import qvick.post.request.PostSearchRequest;

import java.util.List;

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
