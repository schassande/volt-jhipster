import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';
import { of, Subject, from } from 'rxjs';

import { EvaluationService } from '../service/evaluation.service';
import { IEvaluation, Evaluation } from '../evaluation.model';

import { IUser } from 'app/entities/user/user.model';
import { UserService } from 'app/entities/user/user.service';
import { IProject } from 'app/entities/project/project.model';
import { ProjectService } from 'app/entities/project/service/project.service';

import { EvaluationUpdateComponent } from './evaluation-update.component';

describe('Evaluation Management Update Component', () => {
  let comp: EvaluationUpdateComponent;
  let fixture: ComponentFixture<EvaluationUpdateComponent>;
  let activatedRoute: ActivatedRoute;
  let evaluationService: EvaluationService;
  let userService: UserService;
  let projectService: ProjectService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule, RouterTestingModule.withRoutes([])],
      declarations: [EvaluationUpdateComponent],
      providers: [
        FormBuilder,
        {
          provide: ActivatedRoute,
          useValue: {
            params: from([{}]),
          },
        },
      ],
    })
      .overrideTemplate(EvaluationUpdateComponent, '')
      .compileComponents();

    fixture = TestBed.createComponent(EvaluationUpdateComponent);
    activatedRoute = TestBed.inject(ActivatedRoute);
    evaluationService = TestBed.inject(EvaluationService);
    userService = TestBed.inject(UserService);
    projectService = TestBed.inject(ProjectService);

    comp = fixture.componentInstance;
  });

  describe('ngOnInit', () => {
    it('Should call User query and add missing value', () => {
      const evaluation: IEvaluation = { id: 456 };
      const author: IUser = { id: 78184 };
      evaluation.author = author;
      const reviewer: IUser = { id: 24194 };
      evaluation.reviewer = reviewer;

      const userCollection: IUser[] = [{ id: 93546 }];
      jest.spyOn(userService, 'query').mockReturnValue(of(new HttpResponse({ body: userCollection })));
      const additionalUsers = [author, reviewer];
      const expectedCollection: IUser[] = [...additionalUsers, ...userCollection];
      jest.spyOn(userService, 'addUserToCollectionIfMissing').mockReturnValue(expectedCollection);

      activatedRoute.data = of({ evaluation });
      comp.ngOnInit();

      expect(userService.query).toHaveBeenCalled();
      expect(userService.addUserToCollectionIfMissing).toHaveBeenCalledWith(userCollection, ...additionalUsers);
      expect(comp.usersSharedCollection).toEqual(expectedCollection);
    });

    it('Should call Project query and add missing value', () => {
      const evaluation: IEvaluation = { id: 456 };
      const project: IProject = { id: 68493 };
      evaluation.project = project;

      const projectCollection: IProject[] = [{ id: 17821 }];
      jest.spyOn(projectService, 'query').mockReturnValue(of(new HttpResponse({ body: projectCollection })));
      const additionalProjects = [project];
      const expectedCollection: IProject[] = [...additionalProjects, ...projectCollection];
      jest.spyOn(projectService, 'addProjectToCollectionIfMissing').mockReturnValue(expectedCollection);

      activatedRoute.data = of({ evaluation });
      comp.ngOnInit();

      expect(projectService.query).toHaveBeenCalled();
      expect(projectService.addProjectToCollectionIfMissing).toHaveBeenCalledWith(projectCollection, ...additionalProjects);
      expect(comp.projectsSharedCollection).toEqual(expectedCollection);
    });

    it('Should update editForm', () => {
      const evaluation: IEvaluation = { id: 456 };
      const author: IUser = { id: 68948 };
      evaluation.author = author;
      const reviewer: IUser = { id: 28490 };
      evaluation.reviewer = reviewer;
      const project: IProject = { id: 10391 };
      evaluation.project = project;

      activatedRoute.data = of({ evaluation });
      comp.ngOnInit();

      expect(comp.editForm.value).toEqual(expect.objectContaining(evaluation));
      expect(comp.usersSharedCollection).toContain(author);
      expect(comp.usersSharedCollection).toContain(reviewer);
      expect(comp.projectsSharedCollection).toContain(project);
    });
  });

  describe('save', () => {
    it('Should call update service on save for existing entity', () => {
      // GIVEN
      const saveSubject = new Subject<HttpResponse<Evaluation>>();
      const evaluation = { id: 123 };
      jest.spyOn(evaluationService, 'update').mockReturnValue(saveSubject);
      jest.spyOn(comp, 'previousState');
      activatedRoute.data = of({ evaluation });
      comp.ngOnInit();

      // WHEN
      comp.save();
      expect(comp.isSaving).toEqual(true);
      saveSubject.next(new HttpResponse({ body: evaluation }));
      saveSubject.complete();

      // THEN
      expect(comp.previousState).toHaveBeenCalled();
      expect(evaluationService.update).toHaveBeenCalledWith(evaluation);
      expect(comp.isSaving).toEqual(false);
    });

    it('Should call create service on save for new entity', () => {
      // GIVEN
      const saveSubject = new Subject<HttpResponse<Evaluation>>();
      const evaluation = new Evaluation();
      jest.spyOn(evaluationService, 'create').mockReturnValue(saveSubject);
      jest.spyOn(comp, 'previousState');
      activatedRoute.data = of({ evaluation });
      comp.ngOnInit();

      // WHEN
      comp.save();
      expect(comp.isSaving).toEqual(true);
      saveSubject.next(new HttpResponse({ body: evaluation }));
      saveSubject.complete();

      // THEN
      expect(evaluationService.create).toHaveBeenCalledWith(evaluation);
      expect(comp.isSaving).toEqual(false);
      expect(comp.previousState).toHaveBeenCalled();
    });

    it('Should set isSaving to false on error', () => {
      // GIVEN
      const saveSubject = new Subject<HttpResponse<Evaluation>>();
      const evaluation = { id: 123 };
      jest.spyOn(evaluationService, 'update').mockReturnValue(saveSubject);
      jest.spyOn(comp, 'previousState');
      activatedRoute.data = of({ evaluation });
      comp.ngOnInit();

      // WHEN
      comp.save();
      expect(comp.isSaving).toEqual(true);
      saveSubject.error('This is an error!');

      // THEN
      expect(evaluationService.update).toHaveBeenCalledWith(evaluation);
      expect(comp.isSaving).toEqual(false);
      expect(comp.previousState).not.toHaveBeenCalled();
    });
  });

  describe('Tracking relationships identifiers', () => {
    describe('trackUserById', () => {
      it('Should return tracked User primary key', () => {
        const entity = { id: 123 };
        const trackResult = comp.trackUserById(0, entity);
        expect(trackResult).toEqual(entity.id);
      });
    });

    describe('trackProjectById', () => {
      it('Should return tracked Project primary key', () => {
        const entity = { id: 123 };
        const trackResult = comp.trackProjectById(0, entity);
        expect(trackResult).toEqual(entity.id);
      });
    });
  });
});
