package com.project.qvick.domain.check.domain.repository.query;

import com.project.qvick.domain.check.client.dto.Check;
import com.project.qvick.domain.check.domain.QCheckEntity;
import com.project.qvick.global.common.dto.request.PageRequest;
import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.project.qvick.domain.check.domain.QCheckEntity.checkEntity;

@Repository
@RequiredArgsConstructor
public class CheckQueryRepositoryImpl implements CheckQueryRepository {
    private final JPAQueryFactory queryFactory;

    @Override
    public List<Check> findAllCheckUsers(PageRequest request) {
        return queryFactory.select(constructorExpression())
                .from(checkEntity)
                .offset((request.getPage() - 1) * request.getSize())
                .limit(request.getSize())
                .fetch();
    }

    private ConstructorExpression<Check> constructorExpression(){
        return Projections.constructor(Check.class,
                checkEntity.name,
                checkEntity.stdId,
                checkEntity.room,
                checkEntity.isChecked,
                checkEntity.checkedDate);
    }
}
