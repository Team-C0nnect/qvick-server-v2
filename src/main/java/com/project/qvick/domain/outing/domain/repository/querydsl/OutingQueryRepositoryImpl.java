package com.project.qvick.domain.outing.domain.repository.querydsl;

import com.project.qvick.domain.outing.domain.enums.OutingStatus;
import com.project.qvick.domain.outing.presentation.dto.Outing;
import com.project.qvick.domain.outing.presentation.dto.request.OutingPageRequest;
import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import java.util.List;

import static com.project.qvick.domain.outing.domain.QOutingEntity.outingEntity;

public class OutingQueryRepositoryImpl implements OutingQueryRepository{

    JPAQueryFactory queryFactory;

    @Override
    public List<Outing> findStudents(OutingPageRequest request) {
        return queryFactory
                .select(outingProjection())
                .from(outingEntity)
                .where(
                        inStatus(request.getOutingStatuses())
                )
                .offset((request.getPage() - 1) * request.getSize())
                .limit(request.getSize())
                .orderBy(outingEntity.id.asc())
                .fetch();
    }

    private ConstructorExpression<Outing> outingProjection() {
        return Projections.constructor(Outing.class,
                outingEntity.id,
                outingEntity.approval);
    }

    private BooleanExpression inStatus(List<OutingStatus> statuses) {
        if (statuses.isEmpty()) {
            return null;
        }
        return outingEntity.approval.in(statuses);
    }

}
