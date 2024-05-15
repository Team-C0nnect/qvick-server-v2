package com.project.qvick.domain.school.domain.repository.query;

import com.project.qvick.domain.school.presentation.dto.School;
import com.project.qvick.global.common.dto.request.PageRequest;
import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.project.qvick.domain.school.domain.QSchoolEntity.schoolEntity;

@Repository
@RequiredArgsConstructor
public class SchoolQueryRepositoryImpl implements SchoolQueryRespository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<School> schoolList(PageRequest request) {
        return jpaQueryFactory
                .select(schoolConstructorExpression())
                .from(schoolEntity)
                .offset((request.getPage() - 1) * request.getSize())
                .limit(request.getSize())
                .orderBy(schoolEntity.id.desc())
                .fetch();
    }

    private ConstructorExpression<School> schoolConstructorExpression() {
        return Projections.constructor(School.class,
                schoolEntity.id,
                schoolEntity.schoolName
                );
    }

}
