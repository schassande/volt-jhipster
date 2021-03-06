package com.cgi.volt.web.rest;

import com.cgi.volt.domain.Evaluation;
import com.cgi.volt.repository.EvaluationRepository;
import com.cgi.volt.service.EvaluationService;
import com.cgi.volt.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.PaginationUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.cgi.volt.domain.Evaluation}.
 */
@RestController
@RequestMapping("/api")
public class EvaluationResource {

    private final Logger log = LoggerFactory.getLogger(EvaluationResource.class);

    private static final String ENTITY_NAME = "evaluation";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final EvaluationService evaluationService;

    private final EvaluationRepository evaluationRepository;

    public EvaluationResource(EvaluationService evaluationService, EvaluationRepository evaluationRepository) {
        this.evaluationService = evaluationService;
        this.evaluationRepository = evaluationRepository;
    }

    /**
     * {@code POST  /evaluations} : Create a new evaluation.
     *
     * @param evaluation the evaluation to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new evaluation, or with status {@code 400 (Bad Request)} if the evaluation has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/evaluations")
    public ResponseEntity<Evaluation> createEvaluation(@RequestBody Evaluation evaluation) throws URISyntaxException {
        log.debug("REST request to save Evaluation : {}", evaluation);
        if (evaluation.getId() != null) {
            throw new BadRequestAlertException("A new evaluation cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Evaluation result = evaluationService.save(evaluation);
        return ResponseEntity
            .created(new URI("/api/evaluations/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /evaluations/:id} : Updates an existing evaluation.
     *
     * @param id the id of the evaluation to save.
     * @param evaluation the evaluation to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated evaluation,
     * or with status {@code 400 (Bad Request)} if the evaluation is not valid,
     * or with status {@code 500 (Internal Server Error)} if the evaluation couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/evaluations/{id}")
    public ResponseEntity<Evaluation> updateEvaluation(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody Evaluation evaluation
    ) throws URISyntaxException {
        log.debug("REST request to update Evaluation : {}, {}", id, evaluation);
        if (evaluation.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, evaluation.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!evaluationRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Evaluation result = evaluationService.save(evaluation);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, evaluation.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /evaluations/:id} : Partial updates given fields of an existing evaluation, field will ignore if it is null
     *
     * @param id the id of the evaluation to save.
     * @param evaluation the evaluation to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated evaluation,
     * or with status {@code 400 (Bad Request)} if the evaluation is not valid,
     * or with status {@code 404 (Not Found)} if the evaluation is not found,
     * or with status {@code 500 (Internal Server Error)} if the evaluation couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/evaluations/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<Evaluation> partialUpdateEvaluation(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody Evaluation evaluation
    ) throws URISyntaxException {
        log.debug("REST request to partial update Evaluation partially : {}, {}", id, evaluation);
        if (evaluation.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, evaluation.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!evaluationRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<Evaluation> result = evaluationService.partialUpdate(evaluation);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, evaluation.getId().toString())
        );
    }

    /**
     * {@code GET  /evaluations} : get all the evaluations.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of evaluations in body.
     */
    @GetMapping("/evaluations")
    public ResponseEntity<List<Evaluation>> getAllEvaluations(@org.springdoc.api.annotations.ParameterObject Pageable pageable) {
        log.debug("REST request to get a page of Evaluations");
        Page<Evaluation> page = evaluationService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /evaluations/:id} : get the "id" evaluation.
     *
     * @param id the id of the evaluation to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the evaluation, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/evaluations/{id}")
    public ResponseEntity<Evaluation> getEvaluation(@PathVariable Long id) {
        log.debug("REST request to get Evaluation : {}", id);
        Optional<Evaluation> evaluation = evaluationService.findOne(id);
        return ResponseUtil.wrapOrNotFound(evaluation);
    }

    /**
     * {@code DELETE  /evaluations/:id} : delete the "id" evaluation.
     *
     * @param id the id of the evaluation to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/evaluations/{id}")
    public ResponseEntity<Void> deleteEvaluation(@PathVariable Long id) {
        log.debug("REST request to delete Evaluation : {}", id);
        evaluationService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
