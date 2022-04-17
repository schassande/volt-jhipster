package com.cgi.volt.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * A Project.
 */
@Entity
@Table(name = "project")
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "bu")
    private String bu;

    @Column(name = "sector")
    private String sector;

    @Column(name = "vertical")
    private String vertical;

    @Column(name = "client")
    private String client;

    @NotNull
    @Column(name = "project", nullable = false)
    private String project;

    @OneToMany(mappedBy = "project")
    @JsonIgnoreProperties(value = { "author", "reviewer", "project" }, allowSetters = true)
    private Set<Evaluation> evaluations = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Project id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBu() {
        return this.bu;
    }

    public Project bu(String bu) {
        this.setBu(bu);
        return this;
    }

    public void setBu(String bu) {
        this.bu = bu;
    }

    public String getSector() {
        return this.sector;
    }

    public Project sector(String sector) {
        this.setSector(sector);
        return this;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getVertical() {
        return this.vertical;
    }

    public Project vertical(String vertical) {
        this.setVertical(vertical);
        return this;
    }

    public void setVertical(String vertical) {
        this.vertical = vertical;
    }

    public String getClient() {
        return this.client;
    }

    public Project client(String client) {
        this.setClient(client);
        return this;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getProject() {
        return this.project;
    }

    public Project project(String project) {
        this.setProject(project);
        return this;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public Set<Evaluation> getEvaluations() {
        return this.evaluations;
    }

    public void setEvaluations(Set<Evaluation> evaluations) {
        if (this.evaluations != null) {
            this.evaluations.forEach(i -> i.setProject(null));
        }
        if (evaluations != null) {
            evaluations.forEach(i -> i.setProject(this));
        }
        this.evaluations = evaluations;
    }

    public Project evaluations(Set<Evaluation> evaluations) {
        this.setEvaluations(evaluations);
        return this;
    }

    public Project addEvaluations(Evaluation evaluation) {
        this.evaluations.add(evaluation);
        evaluation.setProject(this);
        return this;
    }

    public Project removeEvaluations(Evaluation evaluation) {
        this.evaluations.remove(evaluation);
        evaluation.setProject(null);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Project)) {
            return false;
        }
        return id != null && id.equals(((Project) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Project{" +
            "id=" + getId() +
            ", bu='" + getBu() + "'" +
            ", sector='" + getSector() + "'" +
            ", vertical='" + getVertical() + "'" +
            ", client='" + getClient() + "'" +
            ", project='" + getProject() + "'" +
            "}";
    }
}
