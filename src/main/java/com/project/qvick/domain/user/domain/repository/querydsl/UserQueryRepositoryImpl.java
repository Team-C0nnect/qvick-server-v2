package com.project.qvick.domain.user.domain.repository.querydsl;

import com.project.qvick.domain.user.domain.enums.Approval;
import com.project.qvick.domain.user.presentation.dto.User;
import com.project.qvick.domain.user.presentation.dto.request.SearchRequest;
import com.project.qvick.domain.user.presentation.dto.request.UserApprovalPageRequest;
import com.project.qvick.domain.user.presentation.dto.response.UserPageResponse;
import com.project.qvick.global.common.dto.request.PageRequest;
import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.project.qvick.domain.user.domain.QUserEntity.userEntity;

@Repository
@RequiredArgsConstructor
public class UserQueryRepositoryImpl implements UserQueryRepository{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<UserPageResponse> findWaitingUsers(UserApprovalPageRequest request) {
        return jpaQueryFactory
                .select(userConstructorExpression())
                .from(userEntity)
                .where(inApprovals(request.getApproval()))
                .offset((request.getPage() - 1) * request.getSize())
                .limit(request.getSize())
                .orderBy(userEntity.id.asc())
                .fetch();
    }

    @Override
    public List<User> userList(PageRequest request){
        return jpaQueryFactory
                .select(userListConstructorExpression())
                .from(userEntity)
                .offset((request.getPage() - 1) * request.getSize())
                .limit(request.getSize())
                .orderBy(userEntity.id.asc())
                .fetch();
    }

    @Override
    public List<User>userSearch(SearchRequest request){
        return jpaQueryFactory
                .select(userListConstructorExpression())
                .from(userEntity)
                .where(nameLike(request.getName()))
                .offset((request.getPage() - 1) * request.getSize())
                .limit(request.getSize())
                .orderBy(userEntity.id.asc())
                .fetch();
    }

    private ConstructorExpression<UserPageResponse> userConstructorExpression() {
        return Projections.constructor(UserPageResponse.class,
                userEntity.id,
                userEntity.name,
                userEntity.approval);
    }

    private ConstructorExpression<User> userListConstructorExpression(){
        return Projections.constructor(User.class,
                userEntity.id,
                userEntity.name,
                userEntity.email,
                userEntity.password,
                userEntity.stdId,
                userEntity.room,
                userEntity.approval,
                userEntity.userRole
        );
    }

    private BooleanExpression inApprovals(Approval approval){
        return userEntity.approval.in(approval);
    }

    private BooleanExpression nameLike(String name) {
        return StringUtils.hasText(name) ? userEntity.name.contains(name) : null;
    }

}
