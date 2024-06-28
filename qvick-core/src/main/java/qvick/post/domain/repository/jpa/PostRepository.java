package qvick.post.domain.repository.jpa;

import qvick.post.domain.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity, Long> {

    void deleteById(Long id);

}
