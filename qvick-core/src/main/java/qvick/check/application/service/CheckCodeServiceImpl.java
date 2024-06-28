package qvick.check.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import qvick.check.application.response.CheckCodeResponse;
import qvick.check.domain.CheckCodeEntity;
import qvick.check.domain.mapper.CheckCodeMapper;
import qvick.check.domain.repository.jpa.CheckCodeRepository;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class CheckCodeServiceImpl implements CheckCodeService {

    private final CheckCodeRepository checkCodeRepository;
    private final CheckCodeMapper checkCodeMapper;

    @Override
    public CompletableFuture<CheckCodeResponse> generate() {
        checkCodeRepository.updateAllInvalidCheckCode(1L);
        CheckCodeEntity checkCodeEntity = checkCodeRepository
                .save(checkCodeMapper.createCheckCodeEntity(1L));
        return CompletableFuture.completedFuture(
                CheckCodeResponse.builder()
                .code(checkCodeEntity.getCode())
                .build()
        );
    }

}