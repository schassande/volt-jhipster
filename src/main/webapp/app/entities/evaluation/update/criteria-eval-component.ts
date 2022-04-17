import { Component, Input } from '@angular/core';

@Component({
  selector: 'jhi-criteria-eval',
  template: `
    <div class="row" id="{{ criteriaName }}">
      <div jhiTranslate="voltApp.evaluation.criteria.{{ criteriaName }}" class="mb-2 col-2"></div>
      <div class="mb-2 col-2">
        <select
          class="form-control"
          name="{{ criteriaName }}RiskLevel"
          id="field_{{ criteriaName }}RiskLevel"
          formControlName="{{ criteriaName }}RiskLevel"
        >
          <option [ngValue]="0" jhiTranslate="voltApp.evaluation.riskLevel0">0-Au top</option>
          <option [ngValue]="1" jhiTranslate="voltApp.evaluation.riskLevel1">1-Bien</option>
          <option [ngValue]="2" jhiTranslate="voltApp.evaluation.riskLevel2">2-Passable</option>
          <option [ngValue]="3" jhiTranslate="voltApp.evaluation.riskLevel3">3-Ca craint</option>
        </select>
      </div>
      <div class="mb-2 col-2">
        <select
          class="form-control"
          name="{{ criteriaName }}ImpactLevel"
          id="field_{{ criteriaName }}ImpactLevel"
          formControlName="{{ criteriaName }}ImpactLevel"
        >
          <option [ngValue]="0" jhiTranslate="voltApp.evaluation.impactLevel0">0-Aucun</option>
          <option [ngValue]="1" jhiTranslate="voltApp.evaluation.impactLevel1">1-Faible</option>
          <option [ngValue]="2" jhiTranslate="voltApp.evaluation.impactLevel2">2-Modéré</option>
          <option [ngValue]="3" jhiTranslate="voltApp.evaluation.impactLevel3">3-Elevé</option>
        </select>
      </div>
      <div class="mb-2 col-2" *ngIf="impactValues">
        <select
          class="form-control"
          name="{{ criteriaName }}MainImpact"
          formControlName="{{ criteriaName }}MainImpact"
          id="field_{{ criteriaName }}MainImpact"
        >
          <option [ngValue]="null">{{ 'voltApp.Impact.null' | translate }}</option>
          <option *ngFor="let impact of impactValues" [value]="impact">{{ 'voltApp.Impact.' + impact | translate }}</option>
        </select>
      </div>
      <div class="mb-2 col-2">
        <input
          type="text"
          class="form-control"
          name="{{ criteriaName }}Comment"
          id="field_{{ criteriaName }}Comment"
          formControlName="{{ criteriaName }}Comment"
        />
      </div>
      <div class="mb-2 col-2">
        <input
          type="text"
          class="form-control"
          name="{{ criteriaName }}Action"
          id="field_{{ criteriaName }}Action"
          formControlName="{{ criteriaName }}Action"
        />
      </div>
    </div>
  `,
})
export class CriteriaEvalComponent {
  @Input()
  public criteriaName = '';

  @Input()
  public impactValues: string[] = [];
}
