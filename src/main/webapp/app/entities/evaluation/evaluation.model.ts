import dayjs from 'dayjs/esm';
import { IUser } from 'app/entities/user/user.model';
import { IProject } from 'app/entities/project/project.model';
import { Impact } from 'app/entities/enumerations/impact.model';

export interface IEvaluation {
  id?: number;
  date?: dayjs.Dayjs | null;
  trend?: number | null;
  comment?: string | null;
  maintenabilityRiskLevel?: number | null;
  maintenabilityImpactLevel?: number | null;
  maintenabilityMainImpact?: Impact | null;
  maintenabilityComment?: string | null;
  maintenabilityAction?: string | null;
  performanceRiskLevel?: number | null;
  performanceImpactLevel?: number | null;
  performanceMainImpact?: Impact | null;
  performanceComment?: string | null;
  performanceAction?: string | null;
  indusRiskLevel?: number | null;
  indusImpactLevel?: number | null;
  indusMainImpact?: Impact | null;
  indusComment?: string | null;
  indusAction?: string | null;
  securityRiskLevel?: number | null;
  securityImpactLevel?: number | null;
  securityMainImpact?: Impact | null;
  securityComment?: string | null;
  securityAction?: string | null;
  skillRiskLevel?: number | null;
  skillImpactLevel?: number | null;
  skillMainImpact?: Impact | null;
  skillComment?: string | null;
  skillAction?: string | null;
  environnementRiskLevel?: number | null;
  environnementImpactLevel?: number | null;
  environnementMainImpact?: Impact | null;
  environnementComment?: string | null;
  environnementAction?: string | null;
  operabiltityRiskLevel?: number | null;
  operabiltityImpactLevel?: number | null;
  operabiltityMainImpact?: Impact | null;
  operabiltityComment?: string | null;
  operabiltityAction?: string | null;
  author?: IUser | null;
  reviewer?: IUser | null;
  project?: IProject | null;
}

export class Evaluation implements IEvaluation {
  constructor(
    public id?: number,
    public date?: dayjs.Dayjs | null,
    public trend?: number | null,
    public comment?: string | null,
    public maintenabilityRiskLevel?: number | null,
    public maintenabilityImpactLevel?: number | null,
    public maintenabilityMainImpact?: Impact | null,
    public maintenabilityComment?: string | null,
    public maintenabilityAction?: string | null,
    public performanceRiskLevel?: number | null,
    public performanceImpactLevel?: number | null,
    public performanceMainImpact?: Impact | null,
    public performanceComment?: string | null,
    public performanceAction?: string | null,
    public indusRiskLevel?: number | null,
    public indusImpactLevel?: number | null,
    public indusMainImpact?: Impact | null,
    public indusComment?: string | null,
    public indusAction?: string | null,
    public securityRiskLevel?: number | null,
    public securityImpactLevel?: number | null,
    public securityMainImpact?: Impact | null,
    public securityComment?: string | null,
    public securityAction?: string | null,
    public skillRiskLevel?: number | null,
    public skillImpactLevel?: number | null,
    public skillMainImpact?: Impact | null,
    public skillComment?: string | null,
    public skillAction?: string | null,
    public environnementRiskLevel?: number | null,
    public environnementImpactLevel?: number | null,
    public environnementMainImpact?: Impact | null,
    public environnementComment?: string | null,
    public environnementAction?: string | null,
    public operabiltityRiskLevel?: number | null,
    public operabiltityImpactLevel?: number | null,
    public operabiltityMainImpact?: Impact | null,
    public operabiltityComment?: string | null,
    public operabiltityAction?: string | null,
    public author?: IUser | null,
    public reviewer?: IUser | null,
    public project?: IProject | null
  ) {}
}

export function getEvaluationIdentifier(evaluation: IEvaluation): number | undefined {
  return evaluation.id;
}
