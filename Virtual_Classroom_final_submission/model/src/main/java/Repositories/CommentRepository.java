package Repositories;
import java.util.List;

import entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByLectureIdAndParentCommentIsNull(Long lectureId);
    List<Comment> findByParentCommentId(Long parentCommentId);
}
