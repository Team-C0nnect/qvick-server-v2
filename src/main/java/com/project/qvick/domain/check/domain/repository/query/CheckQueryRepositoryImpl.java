package com.project.qvick.domain.check.domain.repository.query;

import com.project.qvick.domain.check.client.dto.Check;
import com.project.qvick.domain.user.client.dto.User;
import com.project.qvick.domain.user.domain.enums.UserRole;
import com.project.qvick.global.common.dto.request.PageRequest;
import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static com.project.qvick.domain.check.domain.QCheckEntity.checkEntity;
import static com.project.qvick.domain.user.domain.QUserEntity.userEntity;

@Repository
@RequiredArgsConstructor
public class CheckQueryRepositoryImpl implements CheckQueryRepository {

    private final JPAQueryFactory queryFactory;

    // 현재 날짜 구하기
    LocalDate today = LocalDate.now();

    // 오늘의 시작 시간 (00:00:00)
    LocalDateTime startOfDay = today.atStartOfDay();

    // 오늘의 끝 시간 (23:59:59.999999999)
    LocalDateTime endOfDay = today.atTime(LocalTime.MAX);

    @Override
    public List<String> findAllNonCheckUser(PageRequest pageRequest) {
        return queryFactory
                .select(checkEntity.email)
                .from(userEntity)
                .leftJoin(checkEntity)
                .on(checkEntity.userId
                        .eq(userEntity.id)
                        .and(checkEntity.checkedDate.between(startOfDay, endOfDay)))
                .where(checkEntity.id.isNull(),
                        userEntity.userRole.eq(UserRole.USER))
                .offset((pageRequest.getPage() - 1) * pageRequest.getSize())
                .limit(pageRequest.getSize())
                .fetch();
    }

    @Override
    public List<Check> findCheck(PageRequest pageRequest) {
        return queryFactory
                .select(checkProjection())
                .from(checkEntity)
                .offset((pageRequest.getPage() - 1) * pageRequest.getSize())
                .limit(pageRequest.getSize())
                .orderBy(checkEntity.id.desc())
                .fetch();
    }

    @Override
    public List<Check> findNonCheckUser(PageRequest pageRequest) {
        return queryFactory
                .select(checkProjection())
                .from(userEntity)
                .leftJoin(checkEntity)
                .on(checkEntity.userId
                        .eq(userEntity.id)
                        .and(checkEntity.checkedDate.between(startOfDay, endOfDay))
                )
                .where(userEntity.userRole.eq(UserRole.USER))
                .offset((pageRequest.getPage() - 1) * pageRequest.getSize())
                .limit(pageRequest.getSize())
                .fetch();
    }

    @Override
    public Check findCheckById(User user) {
        return queryFactory
                .select(checkProjection())
                .from(checkEntity)
                .where(checkEntity.userId.eq(user.getId()).and(checkEntity.checkedDate.between(startOfDay,endOfDay)))
                .fetchOne();
    }

    private ConstructorExpression<Check> checkProjection() {
        return Projections.constructor(
                Check.class,
                checkEntity.id,
                checkEntity.userId,
                checkEntity.stdId,
                checkEntity.name,
                checkEntity.email,
                checkEntity.room,
                checkEntity.checkedDate
        );
    }

}
