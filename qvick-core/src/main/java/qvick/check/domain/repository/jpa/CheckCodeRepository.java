package qvick.check.domain.repository.jpa;

import qvick.check.domain.CheckCodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CheckCodeRepository extends JpaRepository<CheckCodeEntity, Long> {

    @Modifying
    @Query("UPDATE CheckCodeEntity c SET c.valid=false WHERE c.userId=:userId")
    int updateAllInvalidCheckCode(@Param("userId") Long userId);

    boolean existsByCodeAndValid(String code, boolean valid);

}
