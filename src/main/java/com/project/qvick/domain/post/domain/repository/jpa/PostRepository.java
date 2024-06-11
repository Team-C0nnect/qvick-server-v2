package com.project.qvick.domain.post.domain.repository.jpa;

import com.project.qvick.domain.post.domain.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity, Long> {

    void deleteById(Long id);

}
