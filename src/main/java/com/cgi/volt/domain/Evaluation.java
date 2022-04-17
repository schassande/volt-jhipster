package com.cgi.volt.domain;

import com.cgi.volt.domain.enumeration.Impact;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;

/**
 * A Evaluation.
 */
@Entity
@Table(name = "evaluation")
public class Evaluation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "trend")
    private Integer trend;

    @Column(name = "comment")
    private String comment;

    @Column(name = "maintenability_risk_level")
    private Integer maintenabilityRiskLevel;

    @Column(name = "maintenability_impact_level")
    private Integer maintenabilityImpactLevel;

    @Enumerated(EnumType.STRING)
    @Column(name = "maintenability_main_impact")
    private Impact maintenabilityMainImpact;

    @Column(name = "maintenability_comment")
    private String maintenabilityComment;

    @Column(name = "maintenability_action")
    private String maintenabilityAction;

    @Column(name = "performance_risk_level")
    private Integer performanceRiskLevel;

    @Column(name = "performance_impact_level")
    private Integer performanceImpactLevel;

    @Enumerated(EnumType.STRING)
    @Column(name = "performance_main_impact")
    private Impact performanceMainImpact;

    @Column(name = "performance_comment")
    private String performanceComment;

    @Column(name = "performance_action")
    private String performanceAction;

    @Column(name = "indus_risk_level")
    private Integer indusRiskLevel;

    @Column(name = "indus_impact_level")
    private Integer indusImpactLevel;

    @Enumerated(EnumType.STRING)
    @Column(name = "indus_main_impact")
    private Impact indusMainImpact;

    @Column(name = "indus_comment")
    private String indusComment;

    @Column(name = "indus_action")
    private String indusAction;

    @Column(name = "security_risk_level")
    private Integer securityRiskLevel;

    @Column(name = "security_impact_level")
    private Integer securityImpactLevel;

    @Enumerated(EnumType.STRING)
    @Column(name = "security_main_impact")
    private Impact securityMainImpact;

    @Column(name = "security_comment")
    private String securityComment;

    @Column(name = "security_action")
    private String securityAction;

    @Column(name = "skill_risk_level")
    private Integer skillRiskLevel;

    @Column(name = "skill_impact_level")
    private Integer skillImpactLevel;

    @Enumerated(EnumType.STRING)
    @Column(name = "skill_main_impact")
    private Impact skillMainImpact;

    @Column(name = "skill_comment")
    private String skillComment;

    @Column(name = "skill_action")
    private String skillAction;

    @Column(name = "environnement_risk_level")
    private Integer environnementRiskLevel;

    @Column(name = "environnement_impact_level")
    private Integer environnementImpactLevel;

    @Enumerated(EnumType.STRING)
    @Column(name = "environnement_main_impact")
    private Impact environnementMainImpact;

    @Column(name = "environnement_comment")
    private String environnementComment;

    @Column(name = "environnement_action")
    private String environnementAction;

    @Column(name = "operabiltity_risk_level")
    private Integer operabiltityRiskLevel;

    @Column(name = "operabiltity_impact_level")
    private Integer operabiltityImpactLevel;

    @Enumerated(EnumType.STRING)
    @Column(name = "operabiltity_main_impact")
    private Impact operabiltityMainImpact;

    @Column(name = "operabiltity_comment")
    private String operabiltityComment;

    @Column(name = "operabiltity_action")
    private String operabiltityAction;

    @ManyToOne
    private User author;

    @ManyToOne
    private User reviewer;

    @ManyToOne
    @JsonIgnoreProperties(value = { "evaluations" }, allowSetters = true)
    private Project project;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Evaluation id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public Evaluation date(LocalDate date) {
        this.setDate(date);
        return this;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getTrend() {
        return this.trend;
    }

    public Evaluation trend(Integer trend) {
        this.setTrend(trend);
        return this;
    }

    public void setTrend(Integer trend) {
        this.trend = trend;
    }

    public String getComment() {
        return this.comment;
    }

    public Evaluation comment(String comment) {
        this.setComment(comment);
        return this;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getMaintenabilityRiskLevel() {
        return this.maintenabilityRiskLevel;
    }

    public Evaluation maintenabilityRiskLevel(Integer maintenabilityRiskLevel) {
        this.setMaintenabilityRiskLevel(maintenabilityRiskLevel);
        return this;
    }

    public void setMaintenabilityRiskLevel(Integer maintenabilityRiskLevel) {
        this.maintenabilityRiskLevel = maintenabilityRiskLevel;
    }

    public Integer getMaintenabilityImpactLevel() {
        return this.maintenabilityImpactLevel;
    }

    public Evaluation maintenabilityImpactLevel(Integer maintenabilityImpactLevel) {
        this.setMaintenabilityImpactLevel(maintenabilityImpactLevel);
        return this;
    }

    public void setMaintenabilityImpactLevel(Integer maintenabilityImpactLevel) {
        this.maintenabilityImpactLevel = maintenabilityImpactLevel;
    }

    public Impact getMaintenabilityMainImpact() {
        return this.maintenabilityMainImpact;
    }

    public Evaluation maintenabilityMainImpact(Impact maintenabilityMainImpact) {
        this.setMaintenabilityMainImpact(maintenabilityMainImpact);
        return this;
    }

    public void setMaintenabilityMainImpact(Impact maintenabilityMainImpact) {
        this.maintenabilityMainImpact = maintenabilityMainImpact;
    }

    public String getMaintenabilityComment() {
        return this.maintenabilityComment;
    }

    public Evaluation maintenabilityComment(String maintenabilityComment) {
        this.setMaintenabilityComment(maintenabilityComment);
        return this;
    }

    public void setMaintenabilityComment(String maintenabilityComment) {
        this.maintenabilityComment = maintenabilityComment;
    }

    public String getMaintenabilityAction() {
        return this.maintenabilityAction;
    }

    public Evaluation maintenabilityAction(String maintenabilityAction) {
        this.setMaintenabilityAction(maintenabilityAction);
        return this;
    }

    public void setMaintenabilityAction(String maintenabilityAction) {
        this.maintenabilityAction = maintenabilityAction;
    }

    public Integer getPerformanceRiskLevel() {
        return this.performanceRiskLevel;
    }

    public Evaluation performanceRiskLevel(Integer performanceRiskLevel) {
        this.setPerformanceRiskLevel(performanceRiskLevel);
        return this;
    }

    public void setPerformanceRiskLevel(Integer performanceRiskLevel) {
        this.performanceRiskLevel = performanceRiskLevel;
    }

    public Integer getPerformanceImpactLevel() {
        return this.performanceImpactLevel;
    }

    public Evaluation performanceImpactLevel(Integer performanceImpactLevel) {
        this.setPerformanceImpactLevel(performanceImpactLevel);
        return this;
    }

    public void setPerformanceImpactLevel(Integer performanceImpactLevel) {
        this.performanceImpactLevel = performanceImpactLevel;
    }

    public Impact getPerformanceMainImpact() {
        return this.performanceMainImpact;
    }

    public Evaluation performanceMainImpact(Impact performanceMainImpact) {
        this.setPerformanceMainImpact(performanceMainImpact);
        return this;
    }

    public void setPerformanceMainImpact(Impact performanceMainImpact) {
        this.performanceMainImpact = performanceMainImpact;
    }

    public String getPerformanceComment() {
        return this.performanceComment;
    }

    public Evaluation performanceComment(String performanceComment) {
        this.setPerformanceComment(performanceComment);
        return this;
    }

    public void setPerformanceComment(String performanceComment) {
        this.performanceComment = performanceComment;
    }

    public String getPerformanceAction() {
        return this.performanceAction;
    }

    public Evaluation performanceAction(String performanceAction) {
        this.setPerformanceAction(performanceAction);
        return this;
    }

    public void setPerformanceAction(String performanceAction) {
        this.performanceAction = performanceAction;
    }

    public Integer getIndusRiskLevel() {
        return this.indusRiskLevel;
    }

    public Evaluation indusRiskLevel(Integer indusRiskLevel) {
        this.setIndusRiskLevel(indusRiskLevel);
        return this;
    }

    public void setIndusRiskLevel(Integer indusRiskLevel) {
        this.indusRiskLevel = indusRiskLevel;
    }

    public Integer getIndusImpactLevel() {
        return this.indusImpactLevel;
    }

    public Evaluation indusImpactLevel(Integer indusImpactLevel) {
        this.setIndusImpactLevel(indusImpactLevel);
        return this;
    }

    public void setIndusImpactLevel(Integer indusImpactLevel) {
        this.indusImpactLevel = indusImpactLevel;
    }

    public Impact getIndusMainImpact() {
        return this.indusMainImpact;
    }

    public Evaluation indusMainImpact(Impact indusMainImpact) {
        this.setIndusMainImpact(indusMainImpact);
        return this;
    }

    public void setIndusMainImpact(Impact indusMainImpact) {
        this.indusMainImpact = indusMainImpact;
    }

    public String getIndusComment() {
        return this.indusComment;
    }

    public Evaluation indusComment(String indusComment) {
        this.setIndusComment(indusComment);
        return this;
    }

    public void setIndusComment(String indusComment) {
        this.indusComment = indusComment;
    }

    public String getIndusAction() {
        return this.indusAction;
    }

    public Evaluation indusAction(String indusAction) {
        this.setIndusAction(indusAction);
        return this;
    }

    public void setIndusAction(String indusAction) {
        this.indusAction = indusAction;
    }

    public Integer getSecurityRiskLevel() {
        return this.securityRiskLevel;
    }

    public Evaluation securityRiskLevel(Integer securityRiskLevel) {
        this.setSecurityRiskLevel(securityRiskLevel);
        return this;
    }

    public void setSecurityRiskLevel(Integer securityRiskLevel) {
        this.securityRiskLevel = securityRiskLevel;
    }

    public Integer getSecurityImpactLevel() {
        return this.securityImpactLevel;
    }

    public Evaluation securityImpactLevel(Integer securityImpactLevel) {
        this.setSecurityImpactLevel(securityImpactLevel);
        return this;
    }

    public void setSecurityImpactLevel(Integer securityImpactLevel) {
        this.securityImpactLevel = securityImpactLevel;
    }

    public Impact getSecurityMainImpact() {
        return this.securityMainImpact;
    }

    public Evaluation securityMainImpact(Impact securityMainImpact) {
        this.setSecurityMainImpact(securityMainImpact);
        return this;
    }

    public void setSecurityMainImpact(Impact securityMainImpact) {
        this.securityMainImpact = securityMainImpact;
    }

    public String getSecurityComment() {
        return this.securityComment;
    }

    public Evaluation securityComment(String securityComment) {
        this.setSecurityComment(securityComment);
        return this;
    }

    public void setSecurityComment(String securityComment) {
        this.securityComment = securityComment;
    }

    public String getSecurityAction() {
        return this.securityAction;
    }

    public Evaluation securityAction(String securityAction) {
        this.setSecurityAction(securityAction);
        return this;
    }

    public void setSecurityAction(String securityAction) {
        this.securityAction = securityAction;
    }

    public Integer getSkillRiskLevel() {
        return this.skillRiskLevel;
    }

    public Evaluation skillRiskLevel(Integer skillRiskLevel) {
        this.setSkillRiskLevel(skillRiskLevel);
        return this;
    }

    public void setSkillRiskLevel(Integer skillRiskLevel) {
        this.skillRiskLevel = skillRiskLevel;
    }

    public Integer getSkillImpactLevel() {
        return this.skillImpactLevel;
    }

    public Evaluation skillImpactLevel(Integer skillImpactLevel) {
        this.setSkillImpactLevel(skillImpactLevel);
        return this;
    }

    public void setSkillImpactLevel(Integer skillImpactLevel) {
        this.skillImpactLevel = skillImpactLevel;
    }

    public Impact getSkillMainImpact() {
        return this.skillMainImpact;
    }

    public Evaluation skillMainImpact(Impact skillMainImpact) {
        this.setSkillMainImpact(skillMainImpact);
        return this;
    }

    public void setSkillMainImpact(Impact skillMainImpact) {
        this.skillMainImpact = skillMainImpact;
    }

    public String getSkillComment() {
        return this.skillComment;
    }

    public Evaluation skillComment(String skillComment) {
        this.setSkillComment(skillComment);
        return this;
    }

    public void setSkillComment(String skillComment) {
        this.skillComment = skillComment;
    }

    public String getSkillAction() {
        return this.skillAction;
    }

    public Evaluation skillAction(String skillAction) {
        this.setSkillAction(skillAction);
        return this;
    }

    public void setSkillAction(String skillAction) {
        this.skillAction = skillAction;
    }

    public Integer getEnvironnementRiskLevel() {
        return this.environnementRiskLevel;
    }

    public Evaluation environnementRiskLevel(Integer environnementRiskLevel) {
        this.setEnvironnementRiskLevel(environnementRiskLevel);
        return this;
    }

    public void setEnvironnementRiskLevel(Integer environnementRiskLevel) {
        this.environnementRiskLevel = environnementRiskLevel;
    }

    public Integer getEnvironnementImpactLevel() {
        return this.environnementImpactLevel;
    }

    public Evaluation environnementImpactLevel(Integer environnementImpactLevel) {
        this.setEnvironnementImpactLevel(environnementImpactLevel);
        return this;
    }

    public void setEnvironnementImpactLevel(Integer environnementImpactLevel) {
        this.environnementImpactLevel = environnementImpactLevel;
    }

    public Impact getEnvironnementMainImpact() {
        return this.environnementMainImpact;
    }

    public Evaluation environnementMainImpact(Impact environnementMainImpact) {
        this.setEnvironnementMainImpact(environnementMainImpact);
        return this;
    }

    public void setEnvironnementMainImpact(Impact environnementMainImpact) {
        this.environnementMainImpact = environnementMainImpact;
    }

    public String getEnvironnementComment() {
        return this.environnementComment;
    }

    public Evaluation environnementComment(String environnementComment) {
        this.setEnvironnementComment(environnementComment);
        return this;
    }

    public void setEnvironnementComment(String environnementComment) {
        this.environnementComment = environnementComment;
    }

    public String getEnvironnementAction() {
        return this.environnementAction;
    }

    public Evaluation environnementAction(String environnementAction) {
        this.setEnvironnementAction(environnementAction);
        return this;
    }

    public void setEnvironnementAction(String environnementAction) {
        this.environnementAction = environnementAction;
    }

    public Integer getOperabiltityRiskLevel() {
        return this.operabiltityRiskLevel;
    }

    public Evaluation operabiltityRiskLevel(Integer operabiltityRiskLevel) {
        this.setOperabiltityRiskLevel(operabiltityRiskLevel);
        return this;
    }

    public void setOperabiltityRiskLevel(Integer operabiltityRiskLevel) {
        this.operabiltityRiskLevel = operabiltityRiskLevel;
    }

    public Integer getOperabiltityImpactLevel() {
        return this.operabiltityImpactLevel;
    }

    public Evaluation operabiltityImpactLevel(Integer operabiltityImpactLevel) {
        this.setOperabiltityImpactLevel(operabiltityImpactLevel);
        return this;
    }

    public void setOperabiltityImpactLevel(Integer operabiltityImpactLevel) {
        this.operabiltityImpactLevel = operabiltityImpactLevel;
    }

    public Impact getOperabiltityMainImpact() {
        return this.operabiltityMainImpact;
    }

    public Evaluation operabiltityMainImpact(Impact operabiltityMainImpact) {
        this.setOperabiltityMainImpact(operabiltityMainImpact);
        return this;
    }

    public void setOperabiltityMainImpact(Impact operabiltityMainImpact) {
        this.operabiltityMainImpact = operabiltityMainImpact;
    }

    public String getOperabiltityComment() {
        return this.operabiltityComment;
    }

    public Evaluation operabiltityComment(String operabiltityComment) {
        this.setOperabiltityComment(operabiltityComment);
        return this;
    }

    public void setOperabiltityComment(String operabiltityComment) {
        this.operabiltityComment = operabiltityComment;
    }

    public String getOperabiltityAction() {
        return this.operabiltityAction;
    }

    public Evaluation operabiltityAction(String operabiltityAction) {
        this.setOperabiltityAction(operabiltityAction);
        return this;
    }

    public void setOperabiltityAction(String operabiltityAction) {
        this.operabiltityAction = operabiltityAction;
    }

    public User getAuthor() {
        return this.author;
    }

    public void setAuthor(User user) {
        this.author = user;
    }

    public Evaluation author(User user) {
        this.setAuthor(user);
        return this;
    }

    public User getReviewer() {
        return this.reviewer;
    }

    public void setReviewer(User user) {
        this.reviewer = user;
    }

    public Evaluation reviewer(User user) {
        this.setReviewer(user);
        return this;
    }

    public Project getProject() {
        return this.project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Evaluation project(Project project) {
        this.setProject(project);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Evaluation)) {
            return false;
        }
        return id != null && id.equals(((Evaluation) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Evaluation{" +
            "id=" + getId() +
            ", date='" + getDate() + "'" +
            ", trend=" + getTrend() +
            ", comment='" + getComment() + "'" +
            ", maintenabilityRiskLevel=" + getMaintenabilityRiskLevel() +
            ", maintenabilityImpactLevel=" + getMaintenabilityImpactLevel() +
            ", maintenabilityMainImpact='" + getMaintenabilityMainImpact() + "'" +
            ", maintenabilityComment='" + getMaintenabilityComment() + "'" +
            ", maintenabilityAction='" + getMaintenabilityAction() + "'" +
            ", performanceRiskLevel=" + getPerformanceRiskLevel() +
            ", performanceImpactLevel=" + getPerformanceImpactLevel() +
            ", performanceMainImpact='" + getPerformanceMainImpact() + "'" +
            ", performanceComment='" + getPerformanceComment() + "'" +
            ", performanceAction='" + getPerformanceAction() + "'" +
            ", indusRiskLevel=" + getIndusRiskLevel() +
            ", indusImpactLevel=" + getIndusImpactLevel() +
            ", indusMainImpact='" + getIndusMainImpact() + "'" +
            ", indusComment='" + getIndusComment() + "'" +
            ", indusAction='" + getIndusAction() + "'" +
            ", securityRiskLevel=" + getSecurityRiskLevel() +
            ", securityImpactLevel=" + getSecurityImpactLevel() +
            ", securityMainImpact='" + getSecurityMainImpact() + "'" +
            ", securityComment='" + getSecurityComment() + "'" +
            ", securityAction='" + getSecurityAction() + "'" +
            ", skillRiskLevel=" + getSkillRiskLevel() +
            ", skillImpactLevel=" + getSkillImpactLevel() +
            ", skillMainImpact='" + getSkillMainImpact() + "'" +
            ", skillComment='" + getSkillComment() + "'" +
            ", skillAction='" + getSkillAction() + "'" +
            ", environnementRiskLevel=" + getEnvironnementRiskLevel() +
            ", environnementImpactLevel=" + getEnvironnementImpactLevel() +
            ", environnementMainImpact='" + getEnvironnementMainImpact() + "'" +
            ", environnementComment='" + getEnvironnementComment() + "'" +
            ", environnementAction='" + getEnvironnementAction() + "'" +
            ", operabiltityRiskLevel=" + getOperabiltityRiskLevel() +
            ", operabiltityImpactLevel=" + getOperabiltityImpactLevel() +
            ", operabiltityMainImpact='" + getOperabiltityMainImpact() + "'" +
            ", operabiltityComment='" + getOperabiltityComment() + "'" +
            ", operabiltityAction='" + getOperabiltityAction() + "'" +
            "}";
    }
}
