package com.cgi.volt.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.cgi.volt.IntegrationTest;
import com.cgi.volt.domain.Evaluation;
import com.cgi.volt.domain.enumeration.Impact;
import com.cgi.volt.domain.enumeration.Impact;
import com.cgi.volt.domain.enumeration.Impact;
import com.cgi.volt.domain.enumeration.Impact;
import com.cgi.volt.domain.enumeration.Impact;
import com.cgi.volt.domain.enumeration.Impact;
import com.cgi.volt.domain.enumeration.Impact;
import com.cgi.volt.repository.EvaluationRepository;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests for the {@link EvaluationResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class EvaluationResourceIT {

    private static final LocalDate DEFAULT_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final Integer DEFAULT_TREND = 1;
    private static final Integer UPDATED_TREND = 2;

    private static final String DEFAULT_COMMENT = "AAAAAAAAAA";
    private static final String UPDATED_COMMENT = "BBBBBBBBBB";

    private static final Integer DEFAULT_MAINTENABILITY_RISK_LEVEL = 1;
    private static final Integer UPDATED_MAINTENABILITY_RISK_LEVEL = 2;

    private static final Integer DEFAULT_MAINTENABILITY_IMPACT_LEVEL = 1;
    private static final Integer UPDATED_MAINTENABILITY_IMPACT_LEVEL = 2;

    private static final Impact DEFAULT_MAINTENABILITY_MAIN_IMPACT = Impact.Image;
    private static final Impact UPDATED_MAINTENABILITY_MAIN_IMPACT = Impact.HR;

    private static final String DEFAULT_MAINTENABILITY_COMMENT = "AAAAAAAAAA";
    private static final String UPDATED_MAINTENABILITY_COMMENT = "BBBBBBBBBB";

    private static final String DEFAULT_MAINTENABILITY_ACTION = "AAAAAAAAAA";
    private static final String UPDATED_MAINTENABILITY_ACTION = "BBBBBBBBBB";

    private static final Integer DEFAULT_PERFORMANCE_RISK_LEVEL = 1;
    private static final Integer UPDATED_PERFORMANCE_RISK_LEVEL = 2;

    private static final Integer DEFAULT_PERFORMANCE_IMPACT_LEVEL = 1;
    private static final Integer UPDATED_PERFORMANCE_IMPACT_LEVEL = 2;

    private static final Impact DEFAULT_PERFORMANCE_MAIN_IMPACT = Impact.Image;
    private static final Impact UPDATED_PERFORMANCE_MAIN_IMPACT = Impact.HR;

    private static final String DEFAULT_PERFORMANCE_COMMENT = "AAAAAAAAAA";
    private static final String UPDATED_PERFORMANCE_COMMENT = "BBBBBBBBBB";

    private static final String DEFAULT_PERFORMANCE_ACTION = "AAAAAAAAAA";
    private static final String UPDATED_PERFORMANCE_ACTION = "BBBBBBBBBB";

    private static final Integer DEFAULT_INDUS_RISK_LEVEL = 1;
    private static final Integer UPDATED_INDUS_RISK_LEVEL = 2;

    private static final Integer DEFAULT_INDUS_IMPACT_LEVEL = 1;
    private static final Integer UPDATED_INDUS_IMPACT_LEVEL = 2;

    private static final Impact DEFAULT_INDUS_MAIN_IMPACT = Impact.Image;
    private static final Impact UPDATED_INDUS_MAIN_IMPACT = Impact.HR;

    private static final String DEFAULT_INDUS_COMMENT = "AAAAAAAAAA";
    private static final String UPDATED_INDUS_COMMENT = "BBBBBBBBBB";

    private static final String DEFAULT_INDUS_ACTION = "AAAAAAAAAA";
    private static final String UPDATED_INDUS_ACTION = "BBBBBBBBBB";

    private static final Integer DEFAULT_SECURITY_RISK_LEVEL = 1;
    private static final Integer UPDATED_SECURITY_RISK_LEVEL = 2;

    private static final Integer DEFAULT_SECURITY_IMPACT_LEVEL = 1;
    private static final Integer UPDATED_SECURITY_IMPACT_LEVEL = 2;

    private static final Impact DEFAULT_SECURITY_MAIN_IMPACT = Impact.Image;
    private static final Impact UPDATED_SECURITY_MAIN_IMPACT = Impact.HR;

    private static final String DEFAULT_SECURITY_COMMENT = "AAAAAAAAAA";
    private static final String UPDATED_SECURITY_COMMENT = "BBBBBBBBBB";

    private static final String DEFAULT_SECURITY_ACTION = "AAAAAAAAAA";
    private static final String UPDATED_SECURITY_ACTION = "BBBBBBBBBB";

    private static final Integer DEFAULT_SKILL_RISK_LEVEL = 1;
    private static final Integer UPDATED_SKILL_RISK_LEVEL = 2;

    private static final Integer DEFAULT_SKILL_IMPACT_LEVEL = 1;
    private static final Integer UPDATED_SKILL_IMPACT_LEVEL = 2;

    private static final Impact DEFAULT_SKILL_MAIN_IMPACT = Impact.Image;
    private static final Impact UPDATED_SKILL_MAIN_IMPACT = Impact.HR;

    private static final String DEFAULT_SKILL_COMMENT = "AAAAAAAAAA";
    private static final String UPDATED_SKILL_COMMENT = "BBBBBBBBBB";

    private static final String DEFAULT_SKILL_ACTION = "AAAAAAAAAA";
    private static final String UPDATED_SKILL_ACTION = "BBBBBBBBBB";

    private static final Integer DEFAULT_ENVIRONNEMENT_RISK_LEVEL = 1;
    private static final Integer UPDATED_ENVIRONNEMENT_RISK_LEVEL = 2;

    private static final Integer DEFAULT_ENVIRONNEMENT_IMPACT_LEVEL = 1;
    private static final Integer UPDATED_ENVIRONNEMENT_IMPACT_LEVEL = 2;

    private static final Impact DEFAULT_ENVIRONNEMENT_MAIN_IMPACT = Impact.Image;
    private static final Impact UPDATED_ENVIRONNEMENT_MAIN_IMPACT = Impact.HR;

    private static final String DEFAULT_ENVIRONNEMENT_COMMENT = "AAAAAAAAAA";
    private static final String UPDATED_ENVIRONNEMENT_COMMENT = "BBBBBBBBBB";

    private static final String DEFAULT_ENVIRONNEMENT_ACTION = "AAAAAAAAAA";
    private static final String UPDATED_ENVIRONNEMENT_ACTION = "BBBBBBBBBB";

    private static final Integer DEFAULT_OPERABILTITY_RISK_LEVEL = 1;
    private static final Integer UPDATED_OPERABILTITY_RISK_LEVEL = 2;

    private static final Integer DEFAULT_OPERABILTITY_IMPACT_LEVEL = 1;
    private static final Integer UPDATED_OPERABILTITY_IMPACT_LEVEL = 2;

    private static final Impact DEFAULT_OPERABILTITY_MAIN_IMPACT = Impact.Image;
    private static final Impact UPDATED_OPERABILTITY_MAIN_IMPACT = Impact.HR;

    private static final String DEFAULT_OPERABILTITY_COMMENT = "AAAAAAAAAA";
    private static final String UPDATED_OPERABILTITY_COMMENT = "BBBBBBBBBB";

    private static final String DEFAULT_OPERABILTITY_ACTION = "AAAAAAAAAA";
    private static final String UPDATED_OPERABILTITY_ACTION = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/evaluations";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private EvaluationRepository evaluationRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restEvaluationMockMvc;

    private Evaluation evaluation;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Evaluation createEntity(EntityManager em) {
        Evaluation evaluation = new Evaluation()
            .date(DEFAULT_DATE)
            .trend(DEFAULT_TREND)
            .comment(DEFAULT_COMMENT)
            .maintenabilityRiskLevel(DEFAULT_MAINTENABILITY_RISK_LEVEL)
            .maintenabilityImpactLevel(DEFAULT_MAINTENABILITY_IMPACT_LEVEL)
            .maintenabilityMainImpact(DEFAULT_MAINTENABILITY_MAIN_IMPACT)
            .maintenabilityComment(DEFAULT_MAINTENABILITY_COMMENT)
            .maintenabilityAction(DEFAULT_MAINTENABILITY_ACTION)
            .performanceRiskLevel(DEFAULT_PERFORMANCE_RISK_LEVEL)
            .performanceImpactLevel(DEFAULT_PERFORMANCE_IMPACT_LEVEL)
            .performanceMainImpact(DEFAULT_PERFORMANCE_MAIN_IMPACT)
            .performanceComment(DEFAULT_PERFORMANCE_COMMENT)
            .performanceAction(DEFAULT_PERFORMANCE_ACTION)
            .indusRiskLevel(DEFAULT_INDUS_RISK_LEVEL)
            .indusImpactLevel(DEFAULT_INDUS_IMPACT_LEVEL)
            .indusMainImpact(DEFAULT_INDUS_MAIN_IMPACT)
            .indusComment(DEFAULT_INDUS_COMMENT)
            .indusAction(DEFAULT_INDUS_ACTION)
            .securityRiskLevel(DEFAULT_SECURITY_RISK_LEVEL)
            .securityImpactLevel(DEFAULT_SECURITY_IMPACT_LEVEL)
            .securityMainImpact(DEFAULT_SECURITY_MAIN_IMPACT)
            .securityComment(DEFAULT_SECURITY_COMMENT)
            .securityAction(DEFAULT_SECURITY_ACTION)
            .skillRiskLevel(DEFAULT_SKILL_RISK_LEVEL)
            .skillImpactLevel(DEFAULT_SKILL_IMPACT_LEVEL)
            .skillMainImpact(DEFAULT_SKILL_MAIN_IMPACT)
            .skillComment(DEFAULT_SKILL_COMMENT)
            .skillAction(DEFAULT_SKILL_ACTION)
            .environnementRiskLevel(DEFAULT_ENVIRONNEMENT_RISK_LEVEL)
            .environnementImpactLevel(DEFAULT_ENVIRONNEMENT_IMPACT_LEVEL)
            .environnementMainImpact(DEFAULT_ENVIRONNEMENT_MAIN_IMPACT)
            .environnementComment(DEFAULT_ENVIRONNEMENT_COMMENT)
            .environnementAction(DEFAULT_ENVIRONNEMENT_ACTION)
            .operabiltityRiskLevel(DEFAULT_OPERABILTITY_RISK_LEVEL)
            .operabiltityImpactLevel(DEFAULT_OPERABILTITY_IMPACT_LEVEL)
            .operabiltityMainImpact(DEFAULT_OPERABILTITY_MAIN_IMPACT)
            .operabiltityComment(DEFAULT_OPERABILTITY_COMMENT)
            .operabiltityAction(DEFAULT_OPERABILTITY_ACTION);
        return evaluation;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Evaluation createUpdatedEntity(EntityManager em) {
        Evaluation evaluation = new Evaluation()
            .date(UPDATED_DATE)
            .trend(UPDATED_TREND)
            .comment(UPDATED_COMMENT)
            .maintenabilityRiskLevel(UPDATED_MAINTENABILITY_RISK_LEVEL)
            .maintenabilityImpactLevel(UPDATED_MAINTENABILITY_IMPACT_LEVEL)
            .maintenabilityMainImpact(UPDATED_MAINTENABILITY_MAIN_IMPACT)
            .maintenabilityComment(UPDATED_MAINTENABILITY_COMMENT)
            .maintenabilityAction(UPDATED_MAINTENABILITY_ACTION)
            .performanceRiskLevel(UPDATED_PERFORMANCE_RISK_LEVEL)
            .performanceImpactLevel(UPDATED_PERFORMANCE_IMPACT_LEVEL)
            .performanceMainImpact(UPDATED_PERFORMANCE_MAIN_IMPACT)
            .performanceComment(UPDATED_PERFORMANCE_COMMENT)
            .performanceAction(UPDATED_PERFORMANCE_ACTION)
            .indusRiskLevel(UPDATED_INDUS_RISK_LEVEL)
            .indusImpactLevel(UPDATED_INDUS_IMPACT_LEVEL)
            .indusMainImpact(UPDATED_INDUS_MAIN_IMPACT)
            .indusComment(UPDATED_INDUS_COMMENT)
            .indusAction(UPDATED_INDUS_ACTION)
            .securityRiskLevel(UPDATED_SECURITY_RISK_LEVEL)
            .securityImpactLevel(UPDATED_SECURITY_IMPACT_LEVEL)
            .securityMainImpact(UPDATED_SECURITY_MAIN_IMPACT)
            .securityComment(UPDATED_SECURITY_COMMENT)
            .securityAction(UPDATED_SECURITY_ACTION)
            .skillRiskLevel(UPDATED_SKILL_RISK_LEVEL)
            .skillImpactLevel(UPDATED_SKILL_IMPACT_LEVEL)
            .skillMainImpact(UPDATED_SKILL_MAIN_IMPACT)
            .skillComment(UPDATED_SKILL_COMMENT)
            .skillAction(UPDATED_SKILL_ACTION)
            .environnementRiskLevel(UPDATED_ENVIRONNEMENT_RISK_LEVEL)
            .environnementImpactLevel(UPDATED_ENVIRONNEMENT_IMPACT_LEVEL)
            .environnementMainImpact(UPDATED_ENVIRONNEMENT_MAIN_IMPACT)
            .environnementComment(UPDATED_ENVIRONNEMENT_COMMENT)
            .environnementAction(UPDATED_ENVIRONNEMENT_ACTION)
            .operabiltityRiskLevel(UPDATED_OPERABILTITY_RISK_LEVEL)
            .operabiltityImpactLevel(UPDATED_OPERABILTITY_IMPACT_LEVEL)
            .operabiltityMainImpact(UPDATED_OPERABILTITY_MAIN_IMPACT)
            .operabiltityComment(UPDATED_OPERABILTITY_COMMENT)
            .operabiltityAction(UPDATED_OPERABILTITY_ACTION);
        return evaluation;
    }

    @BeforeEach
    public void initTest() {
        evaluation = createEntity(em);
    }

    @Test
    @Transactional
    void createEvaluation() throws Exception {
        int databaseSizeBeforeCreate = evaluationRepository.findAll().size();
        // Create the Evaluation
        restEvaluationMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(evaluation)))
            .andExpect(status().isCreated());

        // Validate the Evaluation in the database
        List<Evaluation> evaluationList = evaluationRepository.findAll();
        assertThat(evaluationList).hasSize(databaseSizeBeforeCreate + 1);
        Evaluation testEvaluation = evaluationList.get(evaluationList.size() - 1);
        assertThat(testEvaluation.getDate()).isEqualTo(DEFAULT_DATE);
        assertThat(testEvaluation.getTrend()).isEqualTo(DEFAULT_TREND);
        assertThat(testEvaluation.getComment()).isEqualTo(DEFAULT_COMMENT);
        assertThat(testEvaluation.getMaintenabilityRiskLevel()).isEqualTo(DEFAULT_MAINTENABILITY_RISK_LEVEL);
        assertThat(testEvaluation.getMaintenabilityImpactLevel()).isEqualTo(DEFAULT_MAINTENABILITY_IMPACT_LEVEL);
        assertThat(testEvaluation.getMaintenabilityMainImpact()).isEqualTo(DEFAULT_MAINTENABILITY_MAIN_IMPACT);
        assertThat(testEvaluation.getMaintenabilityComment()).isEqualTo(DEFAULT_MAINTENABILITY_COMMENT);
        assertThat(testEvaluation.getMaintenabilityAction()).isEqualTo(DEFAULT_MAINTENABILITY_ACTION);
        assertThat(testEvaluation.getPerformanceRiskLevel()).isEqualTo(DEFAULT_PERFORMANCE_RISK_LEVEL);
        assertThat(testEvaluation.getPerformanceImpactLevel()).isEqualTo(DEFAULT_PERFORMANCE_IMPACT_LEVEL);
        assertThat(testEvaluation.getPerformanceMainImpact()).isEqualTo(DEFAULT_PERFORMANCE_MAIN_IMPACT);
        assertThat(testEvaluation.getPerformanceComment()).isEqualTo(DEFAULT_PERFORMANCE_COMMENT);
        assertThat(testEvaluation.getPerformanceAction()).isEqualTo(DEFAULT_PERFORMANCE_ACTION);
        assertThat(testEvaluation.getIndusRiskLevel()).isEqualTo(DEFAULT_INDUS_RISK_LEVEL);
        assertThat(testEvaluation.getIndusImpactLevel()).isEqualTo(DEFAULT_INDUS_IMPACT_LEVEL);
        assertThat(testEvaluation.getIndusMainImpact()).isEqualTo(DEFAULT_INDUS_MAIN_IMPACT);
        assertThat(testEvaluation.getIndusComment()).isEqualTo(DEFAULT_INDUS_COMMENT);
        assertThat(testEvaluation.getIndusAction()).isEqualTo(DEFAULT_INDUS_ACTION);
        assertThat(testEvaluation.getSecurityRiskLevel()).isEqualTo(DEFAULT_SECURITY_RISK_LEVEL);
        assertThat(testEvaluation.getSecurityImpactLevel()).isEqualTo(DEFAULT_SECURITY_IMPACT_LEVEL);
        assertThat(testEvaluation.getSecurityMainImpact()).isEqualTo(DEFAULT_SECURITY_MAIN_IMPACT);
        assertThat(testEvaluation.getSecurityComment()).isEqualTo(DEFAULT_SECURITY_COMMENT);
        assertThat(testEvaluation.getSecurityAction()).isEqualTo(DEFAULT_SECURITY_ACTION);
        assertThat(testEvaluation.getSkillRiskLevel()).isEqualTo(DEFAULT_SKILL_RISK_LEVEL);
        assertThat(testEvaluation.getSkillImpactLevel()).isEqualTo(DEFAULT_SKILL_IMPACT_LEVEL);
        assertThat(testEvaluation.getSkillMainImpact()).isEqualTo(DEFAULT_SKILL_MAIN_IMPACT);
        assertThat(testEvaluation.getSkillComment()).isEqualTo(DEFAULT_SKILL_COMMENT);
        assertThat(testEvaluation.getSkillAction()).isEqualTo(DEFAULT_SKILL_ACTION);
        assertThat(testEvaluation.getEnvironnementRiskLevel()).isEqualTo(DEFAULT_ENVIRONNEMENT_RISK_LEVEL);
        assertThat(testEvaluation.getEnvironnementImpactLevel()).isEqualTo(DEFAULT_ENVIRONNEMENT_IMPACT_LEVEL);
        assertThat(testEvaluation.getEnvironnementMainImpact()).isEqualTo(DEFAULT_ENVIRONNEMENT_MAIN_IMPACT);
        assertThat(testEvaluation.getEnvironnementComment()).isEqualTo(DEFAULT_ENVIRONNEMENT_COMMENT);
        assertThat(testEvaluation.getEnvironnementAction()).isEqualTo(DEFAULT_ENVIRONNEMENT_ACTION);
        assertThat(testEvaluation.getOperabiltityRiskLevel()).isEqualTo(DEFAULT_OPERABILTITY_RISK_LEVEL);
        assertThat(testEvaluation.getOperabiltityImpactLevel()).isEqualTo(DEFAULT_OPERABILTITY_IMPACT_LEVEL);
        assertThat(testEvaluation.getOperabiltityMainImpact()).isEqualTo(DEFAULT_OPERABILTITY_MAIN_IMPACT);
        assertThat(testEvaluation.getOperabiltityComment()).isEqualTo(DEFAULT_OPERABILTITY_COMMENT);
        assertThat(testEvaluation.getOperabiltityAction()).isEqualTo(DEFAULT_OPERABILTITY_ACTION);
    }

    @Test
    @Transactional
    void createEvaluationWithExistingId() throws Exception {
        // Create the Evaluation with an existing ID
        evaluation.setId(1L);

        int databaseSizeBeforeCreate = evaluationRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restEvaluationMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(evaluation)))
            .andExpect(status().isBadRequest());

        // Validate the Evaluation in the database
        List<Evaluation> evaluationList = evaluationRepository.findAll();
        assertThat(evaluationList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void getAllEvaluations() throws Exception {
        // Initialize the database
        evaluationRepository.saveAndFlush(evaluation);

        // Get all the evaluationList
        restEvaluationMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(evaluation.getId().intValue())))
            .andExpect(jsonPath("$.[*].date").value(hasItem(DEFAULT_DATE.toString())))
            .andExpect(jsonPath("$.[*].trend").value(hasItem(DEFAULT_TREND)))
            .andExpect(jsonPath("$.[*].comment").value(hasItem(DEFAULT_COMMENT)))
            .andExpect(jsonPath("$.[*].maintenabilityRiskLevel").value(hasItem(DEFAULT_MAINTENABILITY_RISK_LEVEL)))
            .andExpect(jsonPath("$.[*].maintenabilityImpactLevel").value(hasItem(DEFAULT_MAINTENABILITY_IMPACT_LEVEL)))
            .andExpect(jsonPath("$.[*].maintenabilityMainImpact").value(hasItem(DEFAULT_MAINTENABILITY_MAIN_IMPACT.toString())))
            .andExpect(jsonPath("$.[*].maintenabilityComment").value(hasItem(DEFAULT_MAINTENABILITY_COMMENT)))
            .andExpect(jsonPath("$.[*].maintenabilityAction").value(hasItem(DEFAULT_MAINTENABILITY_ACTION)))
            .andExpect(jsonPath("$.[*].performanceRiskLevel").value(hasItem(DEFAULT_PERFORMANCE_RISK_LEVEL)))
            .andExpect(jsonPath("$.[*].performanceImpactLevel").value(hasItem(DEFAULT_PERFORMANCE_IMPACT_LEVEL)))
            .andExpect(jsonPath("$.[*].performanceMainImpact").value(hasItem(DEFAULT_PERFORMANCE_MAIN_IMPACT.toString())))
            .andExpect(jsonPath("$.[*].performanceComment").value(hasItem(DEFAULT_PERFORMANCE_COMMENT)))
            .andExpect(jsonPath("$.[*].performanceAction").value(hasItem(DEFAULT_PERFORMANCE_ACTION)))
            .andExpect(jsonPath("$.[*].indusRiskLevel").value(hasItem(DEFAULT_INDUS_RISK_LEVEL)))
            .andExpect(jsonPath("$.[*].indusImpactLevel").value(hasItem(DEFAULT_INDUS_IMPACT_LEVEL)))
            .andExpect(jsonPath("$.[*].indusMainImpact").value(hasItem(DEFAULT_INDUS_MAIN_IMPACT.toString())))
            .andExpect(jsonPath("$.[*].indusComment").value(hasItem(DEFAULT_INDUS_COMMENT)))
            .andExpect(jsonPath("$.[*].indusAction").value(hasItem(DEFAULT_INDUS_ACTION)))
            .andExpect(jsonPath("$.[*].securityRiskLevel").value(hasItem(DEFAULT_SECURITY_RISK_LEVEL)))
            .andExpect(jsonPath("$.[*].securityImpactLevel").value(hasItem(DEFAULT_SECURITY_IMPACT_LEVEL)))
            .andExpect(jsonPath("$.[*].securityMainImpact").value(hasItem(DEFAULT_SECURITY_MAIN_IMPACT.toString())))
            .andExpect(jsonPath("$.[*].securityComment").value(hasItem(DEFAULT_SECURITY_COMMENT)))
            .andExpect(jsonPath("$.[*].securityAction").value(hasItem(DEFAULT_SECURITY_ACTION)))
            .andExpect(jsonPath("$.[*].skillRiskLevel").value(hasItem(DEFAULT_SKILL_RISK_LEVEL)))
            .andExpect(jsonPath("$.[*].skillImpactLevel").value(hasItem(DEFAULT_SKILL_IMPACT_LEVEL)))
            .andExpect(jsonPath("$.[*].skillMainImpact").value(hasItem(DEFAULT_SKILL_MAIN_IMPACT.toString())))
            .andExpect(jsonPath("$.[*].skillComment").value(hasItem(DEFAULT_SKILL_COMMENT)))
            .andExpect(jsonPath("$.[*].skillAction").value(hasItem(DEFAULT_SKILL_ACTION)))
            .andExpect(jsonPath("$.[*].environnementRiskLevel").value(hasItem(DEFAULT_ENVIRONNEMENT_RISK_LEVEL)))
            .andExpect(jsonPath("$.[*].environnementImpactLevel").value(hasItem(DEFAULT_ENVIRONNEMENT_IMPACT_LEVEL)))
            .andExpect(jsonPath("$.[*].environnementMainImpact").value(hasItem(DEFAULT_ENVIRONNEMENT_MAIN_IMPACT.toString())))
            .andExpect(jsonPath("$.[*].environnementComment").value(hasItem(DEFAULT_ENVIRONNEMENT_COMMENT)))
            .andExpect(jsonPath("$.[*].environnementAction").value(hasItem(DEFAULT_ENVIRONNEMENT_ACTION)))
            .andExpect(jsonPath("$.[*].operabiltityRiskLevel").value(hasItem(DEFAULT_OPERABILTITY_RISK_LEVEL)))
            .andExpect(jsonPath("$.[*].operabiltityImpactLevel").value(hasItem(DEFAULT_OPERABILTITY_IMPACT_LEVEL)))
            .andExpect(jsonPath("$.[*].operabiltityMainImpact").value(hasItem(DEFAULT_OPERABILTITY_MAIN_IMPACT.toString())))
            .andExpect(jsonPath("$.[*].operabiltityComment").value(hasItem(DEFAULT_OPERABILTITY_COMMENT)))
            .andExpect(jsonPath("$.[*].operabiltityAction").value(hasItem(DEFAULT_OPERABILTITY_ACTION)));
    }

    @Test
    @Transactional
    void getEvaluation() throws Exception {
        // Initialize the database
        evaluationRepository.saveAndFlush(evaluation);

        // Get the evaluation
        restEvaluationMockMvc
            .perform(get(ENTITY_API_URL_ID, evaluation.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(evaluation.getId().intValue()))
            .andExpect(jsonPath("$.date").value(DEFAULT_DATE.toString()))
            .andExpect(jsonPath("$.trend").value(DEFAULT_TREND))
            .andExpect(jsonPath("$.comment").value(DEFAULT_COMMENT))
            .andExpect(jsonPath("$.maintenabilityRiskLevel").value(DEFAULT_MAINTENABILITY_RISK_LEVEL))
            .andExpect(jsonPath("$.maintenabilityImpactLevel").value(DEFAULT_MAINTENABILITY_IMPACT_LEVEL))
            .andExpect(jsonPath("$.maintenabilityMainImpact").value(DEFAULT_MAINTENABILITY_MAIN_IMPACT.toString()))
            .andExpect(jsonPath("$.maintenabilityComment").value(DEFAULT_MAINTENABILITY_COMMENT))
            .andExpect(jsonPath("$.maintenabilityAction").value(DEFAULT_MAINTENABILITY_ACTION))
            .andExpect(jsonPath("$.performanceRiskLevel").value(DEFAULT_PERFORMANCE_RISK_LEVEL))
            .andExpect(jsonPath("$.performanceImpactLevel").value(DEFAULT_PERFORMANCE_IMPACT_LEVEL))
            .andExpect(jsonPath("$.performanceMainImpact").value(DEFAULT_PERFORMANCE_MAIN_IMPACT.toString()))
            .andExpect(jsonPath("$.performanceComment").value(DEFAULT_PERFORMANCE_COMMENT))
            .andExpect(jsonPath("$.performanceAction").value(DEFAULT_PERFORMANCE_ACTION))
            .andExpect(jsonPath("$.indusRiskLevel").value(DEFAULT_INDUS_RISK_LEVEL))
            .andExpect(jsonPath("$.indusImpactLevel").value(DEFAULT_INDUS_IMPACT_LEVEL))
            .andExpect(jsonPath("$.indusMainImpact").value(DEFAULT_INDUS_MAIN_IMPACT.toString()))
            .andExpect(jsonPath("$.indusComment").value(DEFAULT_INDUS_COMMENT))
            .andExpect(jsonPath("$.indusAction").value(DEFAULT_INDUS_ACTION))
            .andExpect(jsonPath("$.securityRiskLevel").value(DEFAULT_SECURITY_RISK_LEVEL))
            .andExpect(jsonPath("$.securityImpactLevel").value(DEFAULT_SECURITY_IMPACT_LEVEL))
            .andExpect(jsonPath("$.securityMainImpact").value(DEFAULT_SECURITY_MAIN_IMPACT.toString()))
            .andExpect(jsonPath("$.securityComment").value(DEFAULT_SECURITY_COMMENT))
            .andExpect(jsonPath("$.securityAction").value(DEFAULT_SECURITY_ACTION))
            .andExpect(jsonPath("$.skillRiskLevel").value(DEFAULT_SKILL_RISK_LEVEL))
            .andExpect(jsonPath("$.skillImpactLevel").value(DEFAULT_SKILL_IMPACT_LEVEL))
            .andExpect(jsonPath("$.skillMainImpact").value(DEFAULT_SKILL_MAIN_IMPACT.toString()))
            .andExpect(jsonPath("$.skillComment").value(DEFAULT_SKILL_COMMENT))
            .andExpect(jsonPath("$.skillAction").value(DEFAULT_SKILL_ACTION))
            .andExpect(jsonPath("$.environnementRiskLevel").value(DEFAULT_ENVIRONNEMENT_RISK_LEVEL))
            .andExpect(jsonPath("$.environnementImpactLevel").value(DEFAULT_ENVIRONNEMENT_IMPACT_LEVEL))
            .andExpect(jsonPath("$.environnementMainImpact").value(DEFAULT_ENVIRONNEMENT_MAIN_IMPACT.toString()))
            .andExpect(jsonPath("$.environnementComment").value(DEFAULT_ENVIRONNEMENT_COMMENT))
            .andExpect(jsonPath("$.environnementAction").value(DEFAULT_ENVIRONNEMENT_ACTION))
            .andExpect(jsonPath("$.operabiltityRiskLevel").value(DEFAULT_OPERABILTITY_RISK_LEVEL))
            .andExpect(jsonPath("$.operabiltityImpactLevel").value(DEFAULT_OPERABILTITY_IMPACT_LEVEL))
            .andExpect(jsonPath("$.operabiltityMainImpact").value(DEFAULT_OPERABILTITY_MAIN_IMPACT.toString()))
            .andExpect(jsonPath("$.operabiltityComment").value(DEFAULT_OPERABILTITY_COMMENT))
            .andExpect(jsonPath("$.operabiltityAction").value(DEFAULT_OPERABILTITY_ACTION));
    }

    @Test
    @Transactional
    void getNonExistingEvaluation() throws Exception {
        // Get the evaluation
        restEvaluationMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putNewEvaluation() throws Exception {
        // Initialize the database
        evaluationRepository.saveAndFlush(evaluation);

        int databaseSizeBeforeUpdate = evaluationRepository.findAll().size();

        // Update the evaluation
        Evaluation updatedEvaluation = evaluationRepository.findById(evaluation.getId()).get();
        // Disconnect from session so that the updates on updatedEvaluation are not directly saved in db
        em.detach(updatedEvaluation);
        updatedEvaluation
            .date(UPDATED_DATE)
            .trend(UPDATED_TREND)
            .comment(UPDATED_COMMENT)
            .maintenabilityRiskLevel(UPDATED_MAINTENABILITY_RISK_LEVEL)
            .maintenabilityImpactLevel(UPDATED_MAINTENABILITY_IMPACT_LEVEL)
            .maintenabilityMainImpact(UPDATED_MAINTENABILITY_MAIN_IMPACT)
            .maintenabilityComment(UPDATED_MAINTENABILITY_COMMENT)
            .maintenabilityAction(UPDATED_MAINTENABILITY_ACTION)
            .performanceRiskLevel(UPDATED_PERFORMANCE_RISK_LEVEL)
            .performanceImpactLevel(UPDATED_PERFORMANCE_IMPACT_LEVEL)
            .performanceMainImpact(UPDATED_PERFORMANCE_MAIN_IMPACT)
            .performanceComment(UPDATED_PERFORMANCE_COMMENT)
            .performanceAction(UPDATED_PERFORMANCE_ACTION)
            .indusRiskLevel(UPDATED_INDUS_RISK_LEVEL)
            .indusImpactLevel(UPDATED_INDUS_IMPACT_LEVEL)
            .indusMainImpact(UPDATED_INDUS_MAIN_IMPACT)
            .indusComment(UPDATED_INDUS_COMMENT)
            .indusAction(UPDATED_INDUS_ACTION)
            .securityRiskLevel(UPDATED_SECURITY_RISK_LEVEL)
            .securityImpactLevel(UPDATED_SECURITY_IMPACT_LEVEL)
            .securityMainImpact(UPDATED_SECURITY_MAIN_IMPACT)
            .securityComment(UPDATED_SECURITY_COMMENT)
            .securityAction(UPDATED_SECURITY_ACTION)
            .skillRiskLevel(UPDATED_SKILL_RISK_LEVEL)
            .skillImpactLevel(UPDATED_SKILL_IMPACT_LEVEL)
            .skillMainImpact(UPDATED_SKILL_MAIN_IMPACT)
            .skillComment(UPDATED_SKILL_COMMENT)
            .skillAction(UPDATED_SKILL_ACTION)
            .environnementRiskLevel(UPDATED_ENVIRONNEMENT_RISK_LEVEL)
            .environnementImpactLevel(UPDATED_ENVIRONNEMENT_IMPACT_LEVEL)
            .environnementMainImpact(UPDATED_ENVIRONNEMENT_MAIN_IMPACT)
            .environnementComment(UPDATED_ENVIRONNEMENT_COMMENT)
            .environnementAction(UPDATED_ENVIRONNEMENT_ACTION)
            .operabiltityRiskLevel(UPDATED_OPERABILTITY_RISK_LEVEL)
            .operabiltityImpactLevel(UPDATED_OPERABILTITY_IMPACT_LEVEL)
            .operabiltityMainImpact(UPDATED_OPERABILTITY_MAIN_IMPACT)
            .operabiltityComment(UPDATED_OPERABILTITY_COMMENT)
            .operabiltityAction(UPDATED_OPERABILTITY_ACTION);

        restEvaluationMockMvc
            .perform(
                put(ENTITY_API_URL_ID, updatedEvaluation.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(updatedEvaluation))
            )
            .andExpect(status().isOk());

        // Validate the Evaluation in the database
        List<Evaluation> evaluationList = evaluationRepository.findAll();
        assertThat(evaluationList).hasSize(databaseSizeBeforeUpdate);
        Evaluation testEvaluation = evaluationList.get(evaluationList.size() - 1);
        assertThat(testEvaluation.getDate()).isEqualTo(UPDATED_DATE);
        assertThat(testEvaluation.getTrend()).isEqualTo(UPDATED_TREND);
        assertThat(testEvaluation.getComment()).isEqualTo(UPDATED_COMMENT);
        assertThat(testEvaluation.getMaintenabilityRiskLevel()).isEqualTo(UPDATED_MAINTENABILITY_RISK_LEVEL);
        assertThat(testEvaluation.getMaintenabilityImpactLevel()).isEqualTo(UPDATED_MAINTENABILITY_IMPACT_LEVEL);
        assertThat(testEvaluation.getMaintenabilityMainImpact()).isEqualTo(UPDATED_MAINTENABILITY_MAIN_IMPACT);
        assertThat(testEvaluation.getMaintenabilityComment()).isEqualTo(UPDATED_MAINTENABILITY_COMMENT);
        assertThat(testEvaluation.getMaintenabilityAction()).isEqualTo(UPDATED_MAINTENABILITY_ACTION);
        assertThat(testEvaluation.getPerformanceRiskLevel()).isEqualTo(UPDATED_PERFORMANCE_RISK_LEVEL);
        assertThat(testEvaluation.getPerformanceImpactLevel()).isEqualTo(UPDATED_PERFORMANCE_IMPACT_LEVEL);
        assertThat(testEvaluation.getPerformanceMainImpact()).isEqualTo(UPDATED_PERFORMANCE_MAIN_IMPACT);
        assertThat(testEvaluation.getPerformanceComment()).isEqualTo(UPDATED_PERFORMANCE_COMMENT);
        assertThat(testEvaluation.getPerformanceAction()).isEqualTo(UPDATED_PERFORMANCE_ACTION);
        assertThat(testEvaluation.getIndusRiskLevel()).isEqualTo(UPDATED_INDUS_RISK_LEVEL);
        assertThat(testEvaluation.getIndusImpactLevel()).isEqualTo(UPDATED_INDUS_IMPACT_LEVEL);
        assertThat(testEvaluation.getIndusMainImpact()).isEqualTo(UPDATED_INDUS_MAIN_IMPACT);
        assertThat(testEvaluation.getIndusComment()).isEqualTo(UPDATED_INDUS_COMMENT);
        assertThat(testEvaluation.getIndusAction()).isEqualTo(UPDATED_INDUS_ACTION);
        assertThat(testEvaluation.getSecurityRiskLevel()).isEqualTo(UPDATED_SECURITY_RISK_LEVEL);
        assertThat(testEvaluation.getSecurityImpactLevel()).isEqualTo(UPDATED_SECURITY_IMPACT_LEVEL);
        assertThat(testEvaluation.getSecurityMainImpact()).isEqualTo(UPDATED_SECURITY_MAIN_IMPACT);
        assertThat(testEvaluation.getSecurityComment()).isEqualTo(UPDATED_SECURITY_COMMENT);
        assertThat(testEvaluation.getSecurityAction()).isEqualTo(UPDATED_SECURITY_ACTION);
        assertThat(testEvaluation.getSkillRiskLevel()).isEqualTo(UPDATED_SKILL_RISK_LEVEL);
        assertThat(testEvaluation.getSkillImpactLevel()).isEqualTo(UPDATED_SKILL_IMPACT_LEVEL);
        assertThat(testEvaluation.getSkillMainImpact()).isEqualTo(UPDATED_SKILL_MAIN_IMPACT);
        assertThat(testEvaluation.getSkillComment()).isEqualTo(UPDATED_SKILL_COMMENT);
        assertThat(testEvaluation.getSkillAction()).isEqualTo(UPDATED_SKILL_ACTION);
        assertThat(testEvaluation.getEnvironnementRiskLevel()).isEqualTo(UPDATED_ENVIRONNEMENT_RISK_LEVEL);
        assertThat(testEvaluation.getEnvironnementImpactLevel()).isEqualTo(UPDATED_ENVIRONNEMENT_IMPACT_LEVEL);
        assertThat(testEvaluation.getEnvironnementMainImpact()).isEqualTo(UPDATED_ENVIRONNEMENT_MAIN_IMPACT);
        assertThat(testEvaluation.getEnvironnementComment()).isEqualTo(UPDATED_ENVIRONNEMENT_COMMENT);
        assertThat(testEvaluation.getEnvironnementAction()).isEqualTo(UPDATED_ENVIRONNEMENT_ACTION);
        assertThat(testEvaluation.getOperabiltityRiskLevel()).isEqualTo(UPDATED_OPERABILTITY_RISK_LEVEL);
        assertThat(testEvaluation.getOperabiltityImpactLevel()).isEqualTo(UPDATED_OPERABILTITY_IMPACT_LEVEL);
        assertThat(testEvaluation.getOperabiltityMainImpact()).isEqualTo(UPDATED_OPERABILTITY_MAIN_IMPACT);
        assertThat(testEvaluation.getOperabiltityComment()).isEqualTo(UPDATED_OPERABILTITY_COMMENT);
        assertThat(testEvaluation.getOperabiltityAction()).isEqualTo(UPDATED_OPERABILTITY_ACTION);
    }

    @Test
    @Transactional
    void putNonExistingEvaluation() throws Exception {
        int databaseSizeBeforeUpdate = evaluationRepository.findAll().size();
        evaluation.setId(count.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restEvaluationMockMvc
            .perform(
                put(ENTITY_API_URL_ID, evaluation.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(evaluation))
            )
            .andExpect(status().isBadRequest());

        // Validate the Evaluation in the database
        List<Evaluation> evaluationList = evaluationRepository.findAll();
        assertThat(evaluationList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchEvaluation() throws Exception {
        int databaseSizeBeforeUpdate = evaluationRepository.findAll().size();
        evaluation.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restEvaluationMockMvc
            .perform(
                put(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(evaluation))
            )
            .andExpect(status().isBadRequest());

        // Validate the Evaluation in the database
        List<Evaluation> evaluationList = evaluationRepository.findAll();
        assertThat(evaluationList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamEvaluation() throws Exception {
        int databaseSizeBeforeUpdate = evaluationRepository.findAll().size();
        evaluation.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restEvaluationMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(evaluation)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Evaluation in the database
        List<Evaluation> evaluationList = evaluationRepository.findAll();
        assertThat(evaluationList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateEvaluationWithPatch() throws Exception {
        // Initialize the database
        evaluationRepository.saveAndFlush(evaluation);

        int databaseSizeBeforeUpdate = evaluationRepository.findAll().size();

        // Update the evaluation using partial update
        Evaluation partialUpdatedEvaluation = new Evaluation();
        partialUpdatedEvaluation.setId(evaluation.getId());

        partialUpdatedEvaluation
            .date(UPDATED_DATE)
            .trend(UPDATED_TREND)
            .maintenabilityMainImpact(UPDATED_MAINTENABILITY_MAIN_IMPACT)
            .maintenabilityAction(UPDATED_MAINTENABILITY_ACTION)
            .performanceImpactLevel(UPDATED_PERFORMANCE_IMPACT_LEVEL)
            .performanceAction(UPDATED_PERFORMANCE_ACTION)
            .indusRiskLevel(UPDATED_INDUS_RISK_LEVEL)
            .indusMainImpact(UPDATED_INDUS_MAIN_IMPACT)
            .indusComment(UPDATED_INDUS_COMMENT)
            .securityRiskLevel(UPDATED_SECURITY_RISK_LEVEL)
            .securityComment(UPDATED_SECURITY_COMMENT)
            .environnementRiskLevel(UPDATED_ENVIRONNEMENT_RISK_LEVEL)
            .environnementComment(UPDATED_ENVIRONNEMENT_COMMENT)
            .environnementAction(UPDATED_ENVIRONNEMENT_ACTION)
            .operabiltityImpactLevel(UPDATED_OPERABILTITY_IMPACT_LEVEL)
            .operabiltityMainImpact(UPDATED_OPERABILTITY_MAIN_IMPACT)
            .operabiltityComment(UPDATED_OPERABILTITY_COMMENT)
            .operabiltityAction(UPDATED_OPERABILTITY_ACTION);

        restEvaluationMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedEvaluation.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedEvaluation))
            )
            .andExpect(status().isOk());

        // Validate the Evaluation in the database
        List<Evaluation> evaluationList = evaluationRepository.findAll();
        assertThat(evaluationList).hasSize(databaseSizeBeforeUpdate);
        Evaluation testEvaluation = evaluationList.get(evaluationList.size() - 1);
        assertThat(testEvaluation.getDate()).isEqualTo(UPDATED_DATE);
        assertThat(testEvaluation.getTrend()).isEqualTo(UPDATED_TREND);
        assertThat(testEvaluation.getComment()).isEqualTo(DEFAULT_COMMENT);
        assertThat(testEvaluation.getMaintenabilityRiskLevel()).isEqualTo(DEFAULT_MAINTENABILITY_RISK_LEVEL);
        assertThat(testEvaluation.getMaintenabilityImpactLevel()).isEqualTo(DEFAULT_MAINTENABILITY_IMPACT_LEVEL);
        assertThat(testEvaluation.getMaintenabilityMainImpact()).isEqualTo(UPDATED_MAINTENABILITY_MAIN_IMPACT);
        assertThat(testEvaluation.getMaintenabilityComment()).isEqualTo(DEFAULT_MAINTENABILITY_COMMENT);
        assertThat(testEvaluation.getMaintenabilityAction()).isEqualTo(UPDATED_MAINTENABILITY_ACTION);
        assertThat(testEvaluation.getPerformanceRiskLevel()).isEqualTo(DEFAULT_PERFORMANCE_RISK_LEVEL);
        assertThat(testEvaluation.getPerformanceImpactLevel()).isEqualTo(UPDATED_PERFORMANCE_IMPACT_LEVEL);
        assertThat(testEvaluation.getPerformanceMainImpact()).isEqualTo(DEFAULT_PERFORMANCE_MAIN_IMPACT);
        assertThat(testEvaluation.getPerformanceComment()).isEqualTo(DEFAULT_PERFORMANCE_COMMENT);
        assertThat(testEvaluation.getPerformanceAction()).isEqualTo(UPDATED_PERFORMANCE_ACTION);
        assertThat(testEvaluation.getIndusRiskLevel()).isEqualTo(UPDATED_INDUS_RISK_LEVEL);
        assertThat(testEvaluation.getIndusImpactLevel()).isEqualTo(DEFAULT_INDUS_IMPACT_LEVEL);
        assertThat(testEvaluation.getIndusMainImpact()).isEqualTo(UPDATED_INDUS_MAIN_IMPACT);
        assertThat(testEvaluation.getIndusComment()).isEqualTo(UPDATED_INDUS_COMMENT);
        assertThat(testEvaluation.getIndusAction()).isEqualTo(DEFAULT_INDUS_ACTION);
        assertThat(testEvaluation.getSecurityRiskLevel()).isEqualTo(UPDATED_SECURITY_RISK_LEVEL);
        assertThat(testEvaluation.getSecurityImpactLevel()).isEqualTo(DEFAULT_SECURITY_IMPACT_LEVEL);
        assertThat(testEvaluation.getSecurityMainImpact()).isEqualTo(DEFAULT_SECURITY_MAIN_IMPACT);
        assertThat(testEvaluation.getSecurityComment()).isEqualTo(UPDATED_SECURITY_COMMENT);
        assertThat(testEvaluation.getSecurityAction()).isEqualTo(DEFAULT_SECURITY_ACTION);
        assertThat(testEvaluation.getSkillRiskLevel()).isEqualTo(DEFAULT_SKILL_RISK_LEVEL);
        assertThat(testEvaluation.getSkillImpactLevel()).isEqualTo(DEFAULT_SKILL_IMPACT_LEVEL);
        assertThat(testEvaluation.getSkillMainImpact()).isEqualTo(DEFAULT_SKILL_MAIN_IMPACT);
        assertThat(testEvaluation.getSkillComment()).isEqualTo(DEFAULT_SKILL_COMMENT);
        assertThat(testEvaluation.getSkillAction()).isEqualTo(DEFAULT_SKILL_ACTION);
        assertThat(testEvaluation.getEnvironnementRiskLevel()).isEqualTo(UPDATED_ENVIRONNEMENT_RISK_LEVEL);
        assertThat(testEvaluation.getEnvironnementImpactLevel()).isEqualTo(DEFAULT_ENVIRONNEMENT_IMPACT_LEVEL);
        assertThat(testEvaluation.getEnvironnementMainImpact()).isEqualTo(DEFAULT_ENVIRONNEMENT_MAIN_IMPACT);
        assertThat(testEvaluation.getEnvironnementComment()).isEqualTo(UPDATED_ENVIRONNEMENT_COMMENT);
        assertThat(testEvaluation.getEnvironnementAction()).isEqualTo(UPDATED_ENVIRONNEMENT_ACTION);
        assertThat(testEvaluation.getOperabiltityRiskLevel()).isEqualTo(DEFAULT_OPERABILTITY_RISK_LEVEL);
        assertThat(testEvaluation.getOperabiltityImpactLevel()).isEqualTo(UPDATED_OPERABILTITY_IMPACT_LEVEL);
        assertThat(testEvaluation.getOperabiltityMainImpact()).isEqualTo(UPDATED_OPERABILTITY_MAIN_IMPACT);
        assertThat(testEvaluation.getOperabiltityComment()).isEqualTo(UPDATED_OPERABILTITY_COMMENT);
        assertThat(testEvaluation.getOperabiltityAction()).isEqualTo(UPDATED_OPERABILTITY_ACTION);
    }

    @Test
    @Transactional
    void fullUpdateEvaluationWithPatch() throws Exception {
        // Initialize the database
        evaluationRepository.saveAndFlush(evaluation);

        int databaseSizeBeforeUpdate = evaluationRepository.findAll().size();

        // Update the evaluation using partial update
        Evaluation partialUpdatedEvaluation = new Evaluation();
        partialUpdatedEvaluation.setId(evaluation.getId());

        partialUpdatedEvaluation
            .date(UPDATED_DATE)
            .trend(UPDATED_TREND)
            .comment(UPDATED_COMMENT)
            .maintenabilityRiskLevel(UPDATED_MAINTENABILITY_RISK_LEVEL)
            .maintenabilityImpactLevel(UPDATED_MAINTENABILITY_IMPACT_LEVEL)
            .maintenabilityMainImpact(UPDATED_MAINTENABILITY_MAIN_IMPACT)
            .maintenabilityComment(UPDATED_MAINTENABILITY_COMMENT)
            .maintenabilityAction(UPDATED_MAINTENABILITY_ACTION)
            .performanceRiskLevel(UPDATED_PERFORMANCE_RISK_LEVEL)
            .performanceImpactLevel(UPDATED_PERFORMANCE_IMPACT_LEVEL)
            .performanceMainImpact(UPDATED_PERFORMANCE_MAIN_IMPACT)
            .performanceComment(UPDATED_PERFORMANCE_COMMENT)
            .performanceAction(UPDATED_PERFORMANCE_ACTION)
            .indusRiskLevel(UPDATED_INDUS_RISK_LEVEL)
            .indusImpactLevel(UPDATED_INDUS_IMPACT_LEVEL)
            .indusMainImpact(UPDATED_INDUS_MAIN_IMPACT)
            .indusComment(UPDATED_INDUS_COMMENT)
            .indusAction(UPDATED_INDUS_ACTION)
            .securityRiskLevel(UPDATED_SECURITY_RISK_LEVEL)
            .securityImpactLevel(UPDATED_SECURITY_IMPACT_LEVEL)
            .securityMainImpact(UPDATED_SECURITY_MAIN_IMPACT)
            .securityComment(UPDATED_SECURITY_COMMENT)
            .securityAction(UPDATED_SECURITY_ACTION)
            .skillRiskLevel(UPDATED_SKILL_RISK_LEVEL)
            .skillImpactLevel(UPDATED_SKILL_IMPACT_LEVEL)
            .skillMainImpact(UPDATED_SKILL_MAIN_IMPACT)
            .skillComment(UPDATED_SKILL_COMMENT)
            .skillAction(UPDATED_SKILL_ACTION)
            .environnementRiskLevel(UPDATED_ENVIRONNEMENT_RISK_LEVEL)
            .environnementImpactLevel(UPDATED_ENVIRONNEMENT_IMPACT_LEVEL)
            .environnementMainImpact(UPDATED_ENVIRONNEMENT_MAIN_IMPACT)
            .environnementComment(UPDATED_ENVIRONNEMENT_COMMENT)
            .environnementAction(UPDATED_ENVIRONNEMENT_ACTION)
            .operabiltityRiskLevel(UPDATED_OPERABILTITY_RISK_LEVEL)
            .operabiltityImpactLevel(UPDATED_OPERABILTITY_IMPACT_LEVEL)
            .operabiltityMainImpact(UPDATED_OPERABILTITY_MAIN_IMPACT)
            .operabiltityComment(UPDATED_OPERABILTITY_COMMENT)
            .operabiltityAction(UPDATED_OPERABILTITY_ACTION);

        restEvaluationMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedEvaluation.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedEvaluation))
            )
            .andExpect(status().isOk());

        // Validate the Evaluation in the database
        List<Evaluation> evaluationList = evaluationRepository.findAll();
        assertThat(evaluationList).hasSize(databaseSizeBeforeUpdate);
        Evaluation testEvaluation = evaluationList.get(evaluationList.size() - 1);
        assertThat(testEvaluation.getDate()).isEqualTo(UPDATED_DATE);
        assertThat(testEvaluation.getTrend()).isEqualTo(UPDATED_TREND);
        assertThat(testEvaluation.getComment()).isEqualTo(UPDATED_COMMENT);
        assertThat(testEvaluation.getMaintenabilityRiskLevel()).isEqualTo(UPDATED_MAINTENABILITY_RISK_LEVEL);
        assertThat(testEvaluation.getMaintenabilityImpactLevel()).isEqualTo(UPDATED_MAINTENABILITY_IMPACT_LEVEL);
        assertThat(testEvaluation.getMaintenabilityMainImpact()).isEqualTo(UPDATED_MAINTENABILITY_MAIN_IMPACT);
        assertThat(testEvaluation.getMaintenabilityComment()).isEqualTo(UPDATED_MAINTENABILITY_COMMENT);
        assertThat(testEvaluation.getMaintenabilityAction()).isEqualTo(UPDATED_MAINTENABILITY_ACTION);
        assertThat(testEvaluation.getPerformanceRiskLevel()).isEqualTo(UPDATED_PERFORMANCE_RISK_LEVEL);
        assertThat(testEvaluation.getPerformanceImpactLevel()).isEqualTo(UPDATED_PERFORMANCE_IMPACT_LEVEL);
        assertThat(testEvaluation.getPerformanceMainImpact()).isEqualTo(UPDATED_PERFORMANCE_MAIN_IMPACT);
        assertThat(testEvaluation.getPerformanceComment()).isEqualTo(UPDATED_PERFORMANCE_COMMENT);
        assertThat(testEvaluation.getPerformanceAction()).isEqualTo(UPDATED_PERFORMANCE_ACTION);
        assertThat(testEvaluation.getIndusRiskLevel()).isEqualTo(UPDATED_INDUS_RISK_LEVEL);
        assertThat(testEvaluation.getIndusImpactLevel()).isEqualTo(UPDATED_INDUS_IMPACT_LEVEL);
        assertThat(testEvaluation.getIndusMainImpact()).isEqualTo(UPDATED_INDUS_MAIN_IMPACT);
        assertThat(testEvaluation.getIndusComment()).isEqualTo(UPDATED_INDUS_COMMENT);
        assertThat(testEvaluation.getIndusAction()).isEqualTo(UPDATED_INDUS_ACTION);
        assertThat(testEvaluation.getSecurityRiskLevel()).isEqualTo(UPDATED_SECURITY_RISK_LEVEL);
        assertThat(testEvaluation.getSecurityImpactLevel()).isEqualTo(UPDATED_SECURITY_IMPACT_LEVEL);
        assertThat(testEvaluation.getSecurityMainImpact()).isEqualTo(UPDATED_SECURITY_MAIN_IMPACT);
        assertThat(testEvaluation.getSecurityComment()).isEqualTo(UPDATED_SECURITY_COMMENT);
        assertThat(testEvaluation.getSecurityAction()).isEqualTo(UPDATED_SECURITY_ACTION);
        assertThat(testEvaluation.getSkillRiskLevel()).isEqualTo(UPDATED_SKILL_RISK_LEVEL);
        assertThat(testEvaluation.getSkillImpactLevel()).isEqualTo(UPDATED_SKILL_IMPACT_LEVEL);
        assertThat(testEvaluation.getSkillMainImpact()).isEqualTo(UPDATED_SKILL_MAIN_IMPACT);
        assertThat(testEvaluation.getSkillComment()).isEqualTo(UPDATED_SKILL_COMMENT);
        assertThat(testEvaluation.getSkillAction()).isEqualTo(UPDATED_SKILL_ACTION);
        assertThat(testEvaluation.getEnvironnementRiskLevel()).isEqualTo(UPDATED_ENVIRONNEMENT_RISK_LEVEL);
        assertThat(testEvaluation.getEnvironnementImpactLevel()).isEqualTo(UPDATED_ENVIRONNEMENT_IMPACT_LEVEL);
        assertThat(testEvaluation.getEnvironnementMainImpact()).isEqualTo(UPDATED_ENVIRONNEMENT_MAIN_IMPACT);
        assertThat(testEvaluation.getEnvironnementComment()).isEqualTo(UPDATED_ENVIRONNEMENT_COMMENT);
        assertThat(testEvaluation.getEnvironnementAction()).isEqualTo(UPDATED_ENVIRONNEMENT_ACTION);
        assertThat(testEvaluation.getOperabiltityRiskLevel()).isEqualTo(UPDATED_OPERABILTITY_RISK_LEVEL);
        assertThat(testEvaluation.getOperabiltityImpactLevel()).isEqualTo(UPDATED_OPERABILTITY_IMPACT_LEVEL);
        assertThat(testEvaluation.getOperabiltityMainImpact()).isEqualTo(UPDATED_OPERABILTITY_MAIN_IMPACT);
        assertThat(testEvaluation.getOperabiltityComment()).isEqualTo(UPDATED_OPERABILTITY_COMMENT);
        assertThat(testEvaluation.getOperabiltityAction()).isEqualTo(UPDATED_OPERABILTITY_ACTION);
    }

    @Test
    @Transactional
    void patchNonExistingEvaluation() throws Exception {
        int databaseSizeBeforeUpdate = evaluationRepository.findAll().size();
        evaluation.setId(count.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restEvaluationMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, evaluation.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(evaluation))
            )
            .andExpect(status().isBadRequest());

        // Validate the Evaluation in the database
        List<Evaluation> evaluationList = evaluationRepository.findAll();
        assertThat(evaluationList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchEvaluation() throws Exception {
        int databaseSizeBeforeUpdate = evaluationRepository.findAll().size();
        evaluation.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restEvaluationMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(evaluation))
            )
            .andExpect(status().isBadRequest());

        // Validate the Evaluation in the database
        List<Evaluation> evaluationList = evaluationRepository.findAll();
        assertThat(evaluationList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamEvaluation() throws Exception {
        int databaseSizeBeforeUpdate = evaluationRepository.findAll().size();
        evaluation.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restEvaluationMockMvc
            .perform(
                patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(TestUtil.convertObjectToJsonBytes(evaluation))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the Evaluation in the database
        List<Evaluation> evaluationList = evaluationRepository.findAll();
        assertThat(evaluationList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteEvaluation() throws Exception {
        // Initialize the database
        evaluationRepository.saveAndFlush(evaluation);

        int databaseSizeBeforeDelete = evaluationRepository.findAll().size();

        // Delete the evaluation
        restEvaluationMockMvc
            .perform(delete(ENTITY_API_URL_ID, evaluation.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Evaluation> evaluationList = evaluationRepository.findAll();
        assertThat(evaluationList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
