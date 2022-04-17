import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { finalize, map } from 'rxjs/operators';

import { IEvaluation, Evaluation } from '../evaluation.model';
import { EvaluationService } from '../service/evaluation.service';
import { IUser } from 'app/entities/user/user.model';
import { UserService } from 'app/entities/user/user.service';
import { IProject } from 'app/entities/project/project.model';
import { ProjectService } from 'app/entities/project/service/project.service';
import { Impact } from 'app/entities/enumerations/impact.model';

@Component({
  selector: 'jhi-evaluation-update',
  templateUrl: './evaluation-update.component.html',
})
export class EvaluationUpdateComponent implements OnInit {
  isSaving = false;
  impactValues = Object.keys(Impact);

  usersSharedCollection: IUser[] = [];
  projectsSharedCollection: IProject[] = [];

  editForm = this.fb.group({
    id: [],
    date: [],
    trend: [],
    comment: [],
    maintenabilityRiskLevel: [],
    maintenabilityImpactLevel: [],
    maintenabilityMainImpact: [],
    maintenabilityComment: [],
    maintenabilityAction: [],
    performanceRiskLevel: [],
    performanceImpactLevel: [],
    performanceMainImpact: [],
    performanceComment: [],
    performanceAction: [],
    indusRiskLevel: [],
    indusImpactLevel: [],
    indusMainImpact: [],
    indusComment: [],
    indusAction: [],
    securityRiskLevel: [],
    securityImpactLevel: [],
    securityMainImpact: [],
    securityComment: [],
    securityAction: [],
    skillRiskLevel: [],
    skillImpactLevel: [],
    skillMainImpact: [],
    skillComment: [],
    skillAction: [],
    environnementRiskLevel: [],
    environnementImpactLevel: [],
    environnementMainImpact: [],
    environnementComment: [],
    environnementAction: [],
    operabiltityRiskLevel: [],
    operabiltityImpactLevel: [],
    operabiltityMainImpact: [],
    operabiltityComment: [],
    operabiltityAction: [],
    author: [],
    reviewer: [],
    project: [],
  });

  constructor(
    protected evaluationService: EvaluationService,
    protected userService: UserService,
    protected projectService: ProjectService,
    protected activatedRoute: ActivatedRoute,
    protected fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ evaluation }) => {
      this.updateForm(evaluation);

      this.loadRelationshipsOptions();
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const evaluation = this.createFromForm();
    if (evaluation.id !== undefined) {
      this.subscribeToSaveResponse(this.evaluationService.update(evaluation));
    } else {
      this.subscribeToSaveResponse(this.evaluationService.create(evaluation));
    }
  }

  trackUserById(index: number, item: IUser): number {
    return item.id!;
  }

  trackProjectById(index: number, item: IProject): number {
    return item.id!;
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IEvaluation>>): void {
    result.pipe(finalize(() => this.onSaveFinalize())).subscribe({
      next: () => this.onSaveSuccess(),
      error: () => this.onSaveError(),
    });
  }

  protected onSaveSuccess(): void {
    this.previousState();
  }

  protected onSaveError(): void {
    // Api for inheritance.
  }

  protected onSaveFinalize(): void {
    this.isSaving = false;
  }

  protected updateForm(evaluation: IEvaluation): void {
    this.editForm.patchValue({
      id: evaluation.id,
      date: evaluation.date,
      trend: (evaluation.trend ?? 0) % 2,
      comment: evaluation.comment,
      maintenabilityRiskLevel: (evaluation.maintenabilityRiskLevel ?? 0) % 4,
      maintenabilityImpactLevel: (evaluation.maintenabilityImpactLevel ?? 0) % 4,
      maintenabilityMainImpact: evaluation.maintenabilityMainImpact,
      maintenabilityComment: evaluation.maintenabilityComment,
      maintenabilityAction: evaluation.maintenabilityAction,
      performanceRiskLevel: (evaluation.performanceRiskLevel ?? 0) % 4,
      performanceImpactLevel: (evaluation.performanceImpactLevel ?? 0) % 4,
      performanceMainImpact: evaluation.performanceMainImpact,
      performanceComment: evaluation.performanceComment,
      performanceAction: evaluation.performanceAction,
      indusRiskLevel: (evaluation.indusRiskLevel ?? 0) % 4,
      indusImpactLevel: (evaluation.indusImpactLevel ?? 0) % 4,
      indusMainImpact: evaluation.indusMainImpact,
      indusComment: evaluation.indusComment,
      indusAction: evaluation.indusAction,
      securityRiskLevel: (evaluation.securityRiskLevel ?? 0) % 4,
      securityImpactLevel: (evaluation.securityImpactLevel ?? 0) % 4,
      securityMainImpact: evaluation.securityMainImpact,
      securityComment: evaluation.securityComment,
      securityAction: evaluation.securityAction,
      skillRiskLevel: (evaluation.skillRiskLevel ?? 0) % 4,
      skillImpactLevel: (evaluation.skillImpactLevel ?? 0) % 4,
      skillMainImpact: evaluation.skillMainImpact,
      skillComment: evaluation.skillComment,
      skillAction: evaluation.skillAction,
      environnementRiskLevel: (evaluation.environnementRiskLevel ?? 0) % 4,
      environnementImpactLevel: (evaluation.environnementImpactLevel ?? 0) % 4,
      environnementMainImpact: evaluation.environnementMainImpact,
      environnementComment: evaluation.environnementComment,
      environnementAction: evaluation.environnementAction,
      operabiltityRiskLevel: (evaluation.operabiltityRiskLevel ?? 0) % 4,
      operabiltityImpactLevel: (evaluation.operabiltityImpactLevel ?? 0) % 4,
      operabiltityMainImpact: evaluation.operabiltityMainImpact,
      operabiltityComment: evaluation.operabiltityComment,
      operabiltityAction: evaluation.operabiltityAction,
      author: evaluation.author,
      reviewer: evaluation.reviewer,
      project: evaluation.project,
    });

    this.usersSharedCollection = this.userService.addUserToCollectionIfMissing(
      this.usersSharedCollection,
      evaluation.author,
      evaluation.reviewer
    );
    this.projectsSharedCollection = this.projectService.addProjectToCollectionIfMissing(this.projectsSharedCollection, evaluation.project);
  }

  protected loadRelationshipsOptions(): void {
    this.userService
      .query()
      .pipe(map((res: HttpResponse<IUser[]>) => res.body ?? []))
      .pipe(
        map((users: IUser[]) =>
          this.userService.addUserToCollectionIfMissing(users, this.editForm.get('author')!.value, this.editForm.get('reviewer')!.value)
        )
      )
      .subscribe((users: IUser[]) => {
        this.usersSharedCollection = users;
      });

    this.projectService
      .query()
      .pipe(map((res: HttpResponse<IProject[]>) => res.body ?? []))
      .pipe(
        map((projects: IProject[]) => this.projectService.addProjectToCollectionIfMissing(projects, this.editForm.get('project')!.value))
      )
      .subscribe((projects: IProject[]) => (this.projectsSharedCollection = projects));
  }

  protected createFromForm(): IEvaluation {
    return {
      ...new Evaluation(),
      id: this.editForm.get(['id'])!.value,
      date: this.editForm.get(['date'])!.value,
      trend: (this.editForm.get(['trend'])!.value ?? 0) % 2,
      comment: this.editForm.get(['comment'])!.value,
      maintenabilityRiskLevel: (this.editForm.get(['maintenabilityRiskLevel'])!.value ?? 0) % 4,
      maintenabilityImpactLevel: (this.editForm.get(['maintenabilityImpactLevel'])!.value ?? 0) % 4,
      maintenabilityMainImpact: this.editForm.get(['maintenabilityMainImpact'])!.value,
      maintenabilityComment: this.editForm.get(['maintenabilityComment'])!.value,
      maintenabilityAction: this.editForm.get(['maintenabilityAction'])!.value,
      performanceRiskLevel: (this.editForm.get(['performanceRiskLevel'])!.value ?? 0) % 4,
      performanceImpactLevel: (this.editForm.get(['performanceImpactLevel'])!.value ?? 0) % 4,
      performanceMainImpact: this.editForm.get(['performanceMainImpact'])!.value,
      performanceComment: this.editForm.get(['performanceComment'])!.value,
      performanceAction: this.editForm.get(['performanceAction'])!.value,
      indusRiskLevel: (this.editForm.get(['indusRiskLevel'])!.value ?? 0) % 4,
      indusImpactLevel: (this.editForm.get(['indusImpactLevel'])!.value ?? 0) % 4,
      indusMainImpact: this.editForm.get(['indusMainImpact'])!.value,
      indusComment: this.editForm.get(['indusComment'])!.value,
      indusAction: this.editForm.get(['indusAction'])!.value,
      securityRiskLevel: (this.editForm.get(['securityRiskLevel'])!.value ?? 0) % 4,
      securityImpactLevel: (this.editForm.get(['securityImpactLevel'])!.value ?? 0) % 4,
      securityMainImpact: this.editForm.get(['securityMainImpact'])!.value,
      securityComment: this.editForm.get(['securityComment'])!.value,
      securityAction: this.editForm.get(['securityAction'])!.value,
      skillRiskLevel: (this.editForm.get(['skillRiskLevel'])!.value ?? 0) % 4,
      skillImpactLevel: (this.editForm.get(['skillImpactLevel'])!.value ?? 0) % 4,
      skillMainImpact: this.editForm.get(['skillMainImpact'])!.value,
      skillComment: this.editForm.get(['skillComment'])!.value,
      skillAction: this.editForm.get(['skillAction'])!.value,
      environnementRiskLevel: (this.editForm.get(['environnementRiskLevel'])!.value ?? 0) % 4,
      environnementImpactLevel: (this.editForm.get(['environnementImpactLevel'])!.value ?? 0) % 4,
      environnementMainImpact: this.editForm.get(['environnementMainImpact'])!.value,
      environnementComment: this.editForm.get(['environnementComment'])!.value,
      environnementAction: this.editForm.get(['environnementAction'])!.value,
      operabiltityRiskLevel: (this.editForm.get(['operabiltityRiskLevel'])!.value ?? 0) % 4,
      operabiltityImpactLevel: (this.editForm.get(['operabiltityImpactLevel'])!.value ?? 0) % 4,
      operabiltityMainImpact: this.editForm.get(['operabiltityMainImpact'])!.value,
      operabiltityComment: this.editForm.get(['operabiltityComment'])!.value,
      operabiltityAction: this.editForm.get(['operabiltityAction'])!.value,
      author: this.editForm.get(['author'])!.value,
      reviewer: this.editForm.get(['reviewer'])!.value,
      project: this.editForm.get(['project'])!.value,
    };
  }
}
