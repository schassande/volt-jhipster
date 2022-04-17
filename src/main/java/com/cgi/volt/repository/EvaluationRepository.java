package com.cgi.volt.repository;

import com.cgi.volt.domain.Evaluation;
import java.util.List;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Evaluation entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {
    @Query("select evaluation from Evaluation evaluation where evaluation.author.login = ?#{principal.username}")
    List<Evaluation> findByAuthorIsCurrentUser();

    @Query("select evaluation from Evaluation evaluation where evaluation.reviewer.login = ?#{principal.username}")
    List<Evaluation> findByReviewerIsCurrentUser();
}
