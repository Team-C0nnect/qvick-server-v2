package com.project.qvick.domain.user.domain.repository.query;

import com.project.qvick.domain.user.client.dto.User;
import com.project.qvick.domain.user.client.dto.request.UserSearchRequest;
import com.project.qvick.domain.user.domain.enums.UserRole;
import com.project.qvick.global.common.client.dto.request.PageRequest;
import com.project.qvick.global.exception.BadRequestException;
import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.project.qvick.domain.user.domain.QUserEntity.userEntity;

@Repository
@RequiredArgsConstructor
public class UserQueryRepositoryImpl implements UserQueryRepository{

    private final JPAQueryFactory jpaQueryFactory;

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
    public List<User>userSearch(UserSearchRequest request){
        return jpaQueryFactory
                .select(userListConstructorExpression())
                .from(userEntity)
                .where(eqName(request.getName()))
                .offset((request.getPage() - 1) * request.getSize())
                .limit(request.getSize())
                .orderBy(userEntity.id.asc())
                .fetch();
    }

    @Override
    public List<User>studentList(PageRequest request){
        return jpaQueryFactory
                .select(userListConstructorExpression())
                .from(userEntity)
                .where(userEntity.userRole.eq(UserRole.USER))
                .offset((request.getPage() - 1) * request.getSize())
                .limit(request.getSize())
                .orderBy(userEntity.id.asc())
                .fetch();
    }

    @Override
    public List<User> checkUsers(PageRequest request) {
        return jpaQueryFactory
                .select(userListConstructorExpression())
                .from(userEntity)
                .where(userEntity.isChecked.eq(true))
                .offset((request.getPage() - 1) * request.getSize())
                .limit(request.getSize())
                .orderBy(userEntity.id.asc())
                .fetch();
    }

    @Override
    public void updateChecked(){
            jpaQueryFactory
                    .update(userEntity)
                    .set(userEntity.isChecked, false)
                    .execute();
    }

    @Override
    public List<User> nonCheckUsers(PageRequest request) {
        return jpaQueryFactory
                .select(userListConstructorExpression())
                .from(userEntity)
                .where(userEntity.isChecked.eq(false))
                .offset((request.getPage() - 1) * request.getSize())
                .limit(request.getSize())
                .orderBy(userEntity.id.asc())
                .fetch();
    }

    private ConstructorExpression<User> userListConstructorExpression(){
        return Projections.constructor(User.class,
                userEntity.id,
                userEntity.name,
                userEntity.email,
                userEntity.password,
                userEntity.stdId,
                userEntity.room,
                userEntity.userRole,
                userEntity.isChecked,
                userEntity.checkedDate
        );
    }

    private BooleanExpression eqName(String name) {
        if(name.isEmpty()){
            throw BadRequestException.EXCEPTION;
        }
        return userEntity.name.eq(name);
    }

}
