package com.project.qvick.domain.check.domain.repository.query;

import com.project.qvick.domain.check.presentation.dto.CheckList;
import com.project.qvick.domain.user.domain.enums.UserRole;
import com.project.qvick.global.common.dto.request.PageRequest;
import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

import static com.project.qvick.domain.check.domain.QCheckEntity.checkEntity;
import static com.project.qvick.domain.user.domain.QUserEntity.userEntity;

@Repository
@RequiredArgsConstructor
public class CheckQueryRepositoryImpl implements CheckQueryRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<String> findAllNonCheckUser(PageRequest pageRequest) {
        return queryFactory
                .select(userEntity.email)
                .from(userEntity)
                .leftJoin(checkEntity)
                .on(checkEntity.userId
                        .eq(userEntity.id)
                        .and(checkEntity.checkedDate.eq(LocalDate.now())))
                .where(checkEntity.id.isNull(),
                        userEntity.userRole.eq(UserRole.USER))
                .offset((pageRequest.getPage() - 1) * pageRequest.getSize())
                .limit(pageRequest.getSize())
                .fetch();
    }

    @Override
    public List<CheckList> findCheck(PageRequest pageRequest) {
        return queryFactory
                .select(checkProjection())
                .from(checkEntity, userEntity)
                .offset((pageRequest.getPage() - 1) * pageRequest.getSize())
                .limit(pageRequest.getSize())
                .orderBy(checkEntity.id.desc())
                .fetch();
    }


    private ConstructorExpression<CheckList> checkProjection() {
        return Projections.constructor(
                CheckList.class,
                userEntity.stdId,
                userEntity.name,
                userEntity.email,
                checkEntity.checkedDate
        );
    }

}
