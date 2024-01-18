package com.project.qvick.domain.sleepover.domain.repository.querydsl;

import com.project.qvick.domain.sleepover.domain.enums.SleepoverStatus;
import com.project.qvick.domain.sleepover.presentation.dto.Sleepover;
import com.project.qvick.domain.sleepover.presentation.dto.request.SleepoverPageRequest;
import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.project.qvick.domain.sleepover.domain.QSleepoverEntity.sleepoverEntity;

@Repository
@RequiredArgsConstructor
public class SleepoverQueryRepositoryImpl implements SleepoverQueryRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Sleepover> findStudents(SleepoverPageRequest request) {
        return queryFactory
                .select(sleepoverProjection())
                .from(sleepoverEntity)
                .where(
                        inStatus(request.getSleepoverStatuses())
                )
                .offset((request.getPage() - 1) * request.getSize())
                .limit(request.getSize())
                .orderBy(sleepoverEntity.id.asc())
                .fetch();
    }

    private ConstructorExpression<Sleepover> sleepoverProjection() {
        return Projections.constructor(Sleepover.class,
                sleepoverEntity.id,
                sleepoverEntity.approval);
    }

    private BooleanExpression inStatus(List<SleepoverStatus> statuses) {
        if (statuses.isEmpty()) {
            return null;
        }
        return sleepoverEntity.approval.in(statuses);
    }

}
