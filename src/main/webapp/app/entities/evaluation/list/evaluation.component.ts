import { Component, OnInit } from '@angular/core';
import { HttpHeaders, HttpResponse } from '@angular/common/http';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { IEvaluation } from '../evaluation.model';

import { ASC, DESC, ITEMS_PER_PAGE } from 'app/config/pagination.constants';
import { EvaluationService } from '../service/evaluation.service';
import { EvaluationDeleteDialogComponent } from '../delete/evaluation-delete-dialog.component';
import { ParseLinks } from 'app/core/util/parse-links.service';
import { IProject } from 'app/entities/project/project.model';
import { ProjectService } from 'app/entities/project/service/project.service';
import { map } from 'rxjs';

@Component({
  selector: 'jhi-evaluation',
  templateUrl: './evaluation.component.html',
})
export class EvaluationComponent implements OnInit {
  evaluations: IEvaluation[];
  isLoading = false;
  itemsPerPage: number;
  links: { [key: string]: number };
  page: number;
  predicate: string;
  ascending: boolean;
  projectsSharedCollection: IProject[] = [];

  constructor(
    protected evaluationService: EvaluationService,
    protected modalService: NgbModal,
    protected parseLinks: ParseLinks,
    protected projectService: ProjectService
  ) {
    this.evaluations = [];
    this.itemsPerPage = ITEMS_PER_PAGE;
    this.page = 0;
    this.links = {
      last: 0,
    };
    this.predicate = 'id';
    this.ascending = true;
  }

  loadAll(): void {
    this.isLoading = true;
    this.projectService
      .query()
      .pipe(map((res: HttpResponse<IProject[]>) => res.body ?? []))
      .subscribe((projects: IProject[]) => (this.projectsSharedCollection = projects));

    this.evaluationService
      .query({
        page: this.page,
        size: this.itemsPerPage,
        sort: this.sort(),
      })
      .subscribe({
        next: (res: HttpResponse<IEvaluation[]>) => {
          this.isLoading = false;
          this.paginateEvaluations(res.body, res.headers);
        },
        error: () => {
          this.isLoading = false;
        },
      });
  }
  getProject(evaluation: IEvaluation): IProject | undefined {
    const project: IProject | undefined = this.projectsSharedCollection.find(p => p.id === evaluation.project);
    console.log('getProject():', evaluation.project, project);
    return project;
  }
  reset(): void {
    this.page = 0;
    this.evaluations = [];
    this.loadAll();
  }

  loadPage(page: number): void {
    this.page = page;
    this.loadAll();
  }

  ngOnInit(): void {
    this.loadAll();
  }

  trackId(index: number, item: IEvaluation): number {
    return item.id!;
  }
  getEvalutionRisk(evaluation: IEvaluation): number | null | undefined {
    return (
      this.getValue(evaluation.environnementRiskLevel) +
      this.getValue(evaluation.indusRiskLevel) +
      this.getValue(evaluation.maintenabilityRiskLevel) +
      this.getValue(evaluation.operabiltityRiskLevel) +
      this.getValue(evaluation.performanceRiskLevel) +
      this.getValue(evaluation.securityRiskLevel) +
      this.getValue(evaluation.skillRiskLevel)
    );
  }
  getEvalutionImpact(evaluation: IEvaluation): number | null | undefined {
    return (
      this.getValue(evaluation.environnementImpactLevel) +
      this.getValue(evaluation.indusImpactLevel) +
      this.getValue(evaluation.maintenabilityImpactLevel) +
      this.getValue(evaluation.operabiltityImpactLevel) +
      this.getValue(evaluation.performanceImpactLevel) +
      this.getValue(evaluation.securityImpactLevel) +
      this.getValue(evaluation.skillImpactLevel)
    );
  }
  getValue(n: number | null | undefined): number {
    return n || n === 0 ? n : 0;
  }
  delete(evaluation: IEvaluation): void {
    const modalRef = this.modalService.open(EvaluationDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.evaluation = evaluation;
    // unsubscribe not needed because closed completes on modal close
    modalRef.closed.subscribe(reason => {
      if (reason === 'deleted') {
        this.reset();
      }
    });
  }

  protected sort(): string[] {
    const result = [this.predicate + ',' + (this.ascending ? ASC : DESC)];
    if (this.predicate !== 'id') {
      result.push('id');
    }
    return result;
  }

  protected paginateEvaluations(data: IEvaluation[] | null, headers: HttpHeaders): void {
    const linkHeader = headers.get('link');
    if (linkHeader) {
      this.links = this.parseLinks.parse(linkHeader);
    } else {
      this.links = {
        last: 0,
      };
    }
    if (data) {
      for (const d of data) {
        this.evaluations.push(d);
      }
    }
  }
}
