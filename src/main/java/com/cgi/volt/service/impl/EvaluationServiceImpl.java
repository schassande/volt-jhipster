package com.cgi.volt.service.impl;

import com.cgi.volt.domain.Evaluation;
import com.cgi.volt.repository.EvaluationRepository;
import com.cgi.volt.service.EvaluationService;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Evaluation}.
 */
@Service
@Transactional
public class EvaluationServiceImpl implements EvaluationService {

    private final Logger log = LoggerFactory.getLogger(EvaluationServiceImpl.class);

    private final EvaluationRepository evaluationRepository;

    public EvaluationServiceImpl(EvaluationRepository evaluationRepository) {
        this.evaluationRepository = evaluationRepository;
    }

    @Override
    public Evaluation save(Evaluation evaluation) {
        log.debug("Request to save Evaluation : {}", evaluation);
        return evaluationRepository.save(evaluation);
    }

    @Override
    public Optional<Evaluation> partialUpdate(Evaluation evaluation) {
        log.debug("Request to partially update Evaluation : {}", evaluation);

        return evaluationRepository
            .findById(evaluation.getId())
            .map(existingEvaluation -> {
                if (evaluation.getDate() != null) {
                    existingEvaluation.setDate(evaluation.getDate());
                }
                if (evaluation.getTrend() != null) {
                    existingEvaluation.setTrend(evaluation.getTrend());
                }
                if (evaluation.getComment() != null) {
                    existingEvaluation.setComment(evaluation.getComment());
                }
                if (evaluation.getMaintenabilityRiskLevel() != null) {
                    existingEvaluation.setMaintenabilityRiskLevel(evaluation.getMaintenabilityRiskLevel());
                }
                if (evaluation.getMaintenabilityImpactLevel() != null) {
                    existingEvaluation.setMaintenabilityImpactLevel(evaluation.getMaintenabilityImpactLevel());
                }
                if (evaluation.getMaintenabilityMainImpact() != null) {
                    existingEvaluation.setMaintenabilityMainImpact(evaluation.getMaintenabilityMainImpact());
                }
                if (evaluation.getMaintenabilityComment() != null) {
                    existingEvaluation.setMaintenabilityComment(evaluation.getMaintenabilityComment());
                }
                if (evaluation.getMaintenabilityAction() != null) {
                    existingEvaluation.setMaintenabilityAction(evaluation.getMaintenabilityAction());
                }
                if (evaluation.getPerformanceRiskLevel() != null) {
                    existingEvaluation.setPerformanceRiskLevel(evaluation.getPerformanceRiskLevel());
                }
                if (evaluation.getPerformanceImpactLevel() != null) {
                    existingEvaluation.setPerformanceImpactLevel(evaluation.getPerformanceImpactLevel());
                }
                if (evaluation.getPerformanceMainImpact() != null) {
                    existingEvaluation.setPerformanceMainImpact(evaluation.getPerformanceMainImpact());
                }
                if (evaluation.getPerformanceComment() != null) {
                    existingEvaluation.setPerformanceComment(evaluation.getPerformanceComment());
                }
                if (evaluation.getPerformanceAction() != null) {
                    existingEvaluation.setPerformanceAction(evaluation.getPerformanceAction());
                }
                if (evaluation.getIndusRiskLevel() != null) {
                    existingEvaluation.setIndusRiskLevel(evaluation.getIndusRiskLevel());
                }
                if (evaluation.getIndusImpactLevel() != null) {
                    existingEvaluation.setIndusImpactLevel(evaluation.getIndusImpactLevel());
                }
                if (evaluation.getIndusMainImpact() != null) {
                    existingEvaluation.setIndusMainImpact(evaluation.getIndusMainImpact());
                }
                if (evaluation.getIndusComment() != null) {
                    existingEvaluation.setIndusComment(evaluation.getIndusComment());
                }
                if (evaluation.getIndusAction() != null) {
                    existingEvaluation.setIndusAction(evaluation.getIndusAction());
                }
                if (evaluation.getSecurityRiskLevel() != null) {
                    existingEvaluation.setSecurityRiskLevel(evaluation.getSecurityRiskLevel());
                }
                if (evaluation.getSecurityImpactLevel() != null) {
                    existingEvaluation.setSecurityImpactLevel(evaluation.getSecurityImpactLevel());
                }
                if (evaluation.getSecurityMainImpact() != null) {
                    existingEvaluation.setSecurityMainImpact(evaluation.getSecurityMainImpact());
                }
                if (evaluation.getSecurityComment() != null) {
                    existingEvaluation.setSecurityComment(evaluation.getSecurityComment());
                }
                if (evaluation.getSecurityAction() != null) {
                    existingEvaluation.setSecurityAction(evaluation.getSecurityAction());
                }
                if (evaluation.getSkillRiskLevel() != null) {
                    existingEvaluation.setSkillRiskLevel(evaluation.getSkillRiskLevel());
                }
                if (evaluation.getSkillImpactLevel() != null) {
                    existingEvaluation.setSkillImpactLevel(evaluation.getSkillImpactLevel());
                }
                if (evaluation.getSkillMainImpact() != null) {
                    existingEvaluation.setSkillMainImpact(evaluation.getSkillMainImpact());
                }
                if (evaluation.getSkillComment() != null) {
                    existingEvaluation.setSkillComment(evaluation.getSkillComment());
                }
                if (evaluation.getSkillAction() != null) {
                    existingEvaluation.setSkillAction(evaluation.getSkillAction());
                }
                if (evaluation.getEnvironnementRiskLevel() != null) {
                    existingEvaluation.setEnvironnementRiskLevel(evaluation.getEnvironnementRiskLevel());
                }
                if (evaluation.getEnvironnementImpactLevel() != null) {
                    existingEvaluation.setEnvironnementImpactLevel(evaluation.getEnvironnementImpactLevel());
                }
                if (evaluation.getEnvironnementMainImpact() != null) {
                    existingEvaluation.setEnvironnementMainImpact(evaluation.getEnvironnementMainImpact());
                }
                if (evaluation.getEnvironnementComment() != null) {
                    existingEvaluation.setEnvironnementComment(evaluation.getEnvironnementComment());
                }
                if (evaluation.getEnvironnementAction() != null) {
                    existingEvaluation.setEnvironnementAction(evaluation.getEnvironnementAction());
                }
                if (evaluation.getOperabiltityRiskLevel() != null) {
                    existingEvaluation.setOperabiltityRiskLevel(evaluation.getOperabiltityRiskLevel());
                }
                if (evaluation.getOperabiltityImpactLevel() != null) {
                    existingEvaluation.setOperabiltityImpactLevel(evaluation.getOperabiltityImpactLevel());
                }
                if (evaluation.getOperabiltityMainImpact() != null) {
                    existingEvaluation.setOperabiltityMainImpact(evaluation.getOperabiltityMainImpact());
                }
                if (evaluation.getOperabiltityComment() != null) {
                    existingEvaluation.setOperabiltityComment(evaluation.getOperabiltityComment());
                }
                if (evaluation.getOperabiltityAction() != null) {
                    existingEvaluation.setOperabiltityAction(evaluation.getOperabiltityAction());
                }

                return existingEvaluation;
            })
            .map(evaluationRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Evaluation> findAll(Pageable pageable) {
        log.debug("Request to get all Evaluations");
        return evaluationRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Evaluation> findOne(Long id) {
        log.debug("Request to get Evaluation : {}", id);
        return evaluationRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Evaluation : {}", id);
        evaluationRepository.deleteById(id);
    }
}
