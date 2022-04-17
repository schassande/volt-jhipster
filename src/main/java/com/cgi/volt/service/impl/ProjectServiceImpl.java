package com.cgi.volt.service.impl;

import com.cgi.volt.domain.Project;
import com.cgi.volt.repository.ProjectRepository;
import com.cgi.volt.service.ProjectService;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Project}.
 */
@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    private final Logger log = LoggerFactory.getLogger(ProjectServiceImpl.class);

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project save(Project project) {
        log.debug("Request to save Project : {}", project);
        return projectRepository.save(project);
    }

    @Override
    public Optional<Project> partialUpdate(Project project) {
        log.debug("Request to partially update Project : {}", project);

        return projectRepository
            .findById(project.getId())
            .map(existingProject -> {
                if (project.getBu() != null) {
                    existingProject.setBu(project.getBu());
                }
                if (project.getSector() != null) {
                    existingProject.setSector(project.getSector());
                }
                if (project.getVertical() != null) {
                    existingProject.setVertical(project.getVertical());
                }
                if (project.getClient() != null) {
                    existingProject.setClient(project.getClient());
                }
                if (project.getProject() != null) {
                    existingProject.setProject(project.getProject());
                }

                return existingProject;
            })
            .map(projectRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Project> findAll() {
        log.debug("Request to get all Projects");
        return projectRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Project> findOne(Long id) {
        log.debug("Request to get Project : {}", id);
        return projectRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Project : {}", id);
        projectRepository.deleteById(id);
    }
}
