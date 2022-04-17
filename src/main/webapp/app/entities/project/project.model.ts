import { IEvaluation } from 'app/entities/evaluation/evaluation.model';

export interface IProject {
  id?: number;
  bu?: string | null;
  sector?: string | null;
  vertical?: string | null;
  client?: string | null;
  project?: string;
  evaluations?: IEvaluation[] | null;
}

export class Project implements IProject {
  constructor(
    public id?: number,
    public bu?: string | null,
    public sector?: string | null,
    public vertical?: string | null,
    public client?: string | null,
    public project?: string,
    public evaluations?: IEvaluation[] | null
  ) {}
}

export function getProjectIdentifier(project: IProject): number | undefined {
  return project.id;
}
