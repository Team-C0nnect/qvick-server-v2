package com.project.qvick.domain.user.domain.repository.querydsl;

import com.project.qvick.domain.user.dto.User;
import com.project.qvick.global.common.dto.request.PageRequest;
import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.project.qvick.domain.user.domain.QUserEntity.userEntity;

@Repository
@RequiredArgsConstructor
public class UserQueryRepositoryImpl implements UserQueryRepository{

    private final JPAQueryFactory queryFactory;

    @Override
    public List<User> findUsers(PageRequest request) {
        return queryFactory
                .select(userConstructorExpression())
                .from(userEntity)
                .offset((request.getPage() - 1) * request.getSize())
                .limit(request.getSize())
                .orderBy(userEntity.id.desc())
                .fetch();
    }

    private ConstructorExpression<User> userConstructorExpression() {
        return Projections.constructor(User.class,
                userEntity.id,
                userEntity.name);
    }

}
