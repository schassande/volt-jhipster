import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import dayjs from 'dayjs/esm';

import { DATE_FORMAT } from 'app/config/input.constants';
import { Impact } from 'app/entities/enumerations/impact.model';
import { IEvaluation, Evaluation } from '../evaluation.model';

import { EvaluationService } from './evaluation.service';

describe('Evaluation Service', () => {
  let service: EvaluationService;
  let httpMock: HttpTestingController;
  let elemDefault: IEvaluation;
  let expectedResult: IEvaluation | IEvaluation[] | boolean | null;
  let currentDate: dayjs.Dayjs;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
    });
    expectedResult = null;
    service = TestBed.inject(EvaluationService);
    httpMock = TestBed.inject(HttpTestingController);
    currentDate = dayjs();

    elemDefault = {
      id: 0,
      date: currentDate,
      trend: 0,
      comment: 'AAAAAAA',
      maintenabilityRiskLevel: 0,
      maintenabilityImpactLevel: 0,
      maintenabilityMainImpact: Impact.Image,
      maintenabilityComment: 'AAAAAAA',
      maintenabilityAction: 'AAAAAAA',
      performanceRiskLevel: 0,
      performanceImpactLevel: 0,
      performanceMainImpact: Impact.Image,
      performanceComment: 'AAAAAAA',
      performanceAction: 'AAAAAAA',
      indusRiskLevel: 0,
      indusImpactLevel: 0,
      indusMainImpact: Impact.Image,
      indusComment: 'AAAAAAA',
      indusAction: 'AAAAAAA',
      securityRiskLevel: 0,
      securityImpactLevel: 0,
      securityMainImpact: Impact.Image,
      securityComment: 'AAAAAAA',
      securityAction: 'AAAAAAA',
      skillRiskLevel: 0,
      skillImpactLevel: 0,
      skillMainImpact: Impact.Image,
      skillComment: 'AAAAAAA',
      skillAction: 'AAAAAAA',
      environnementRiskLevel: 0,
      environnementImpactLevel: 0,
      environnementMainImpact: Impact.Image,
      environnementComment: 'AAAAAAA',
      environnementAction: 'AAAAAAA',
      operabiltityRiskLevel: 0,
      operabiltityImpactLevel: 0,
      operabiltityMainImpact: Impact.Image,
      operabiltityComment: 'AAAAAAA',
      operabiltityAction: 'AAAAAAA',
    };
  });

  describe('Service methods', () => {
    it('should find an element', () => {
      const returnedFromService = Object.assign(
        {
          date: currentDate.format(DATE_FORMAT),
        },
        elemDefault
      );

      service.find(123).subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'GET' });
      req.flush(returnedFromService);
      expect(expectedResult).toMatchObject(elemDefault);
    });

    it('should create a Evaluation', () => {
      const returnedFromService = Object.assign(
        {
          id: 0,
          date: currentDate.format(DATE_FORMAT),
        },
        elemDefault
      );

      const expected = Object.assign(
        {
          date: currentDate,
        },
        returnedFromService
      );

      service.create(new Evaluation()).subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'POST' });
      req.flush(returnedFromService);
      expect(expectedResult).toMatchObject(expected);
    });

    it('should update a Evaluation', () => {
      const returnedFromService = Object.assign(
        {
          id: 1,
          date: currentDate.format(DATE_FORMAT),
          trend: 1,
          comment: 'BBBBBB',
          maintenabilityRiskLevel: 1,
          maintenabilityImpactLevel: 1,
          maintenabilityMainImpact: 'BBBBBB',
          maintenabilityComment: 'BBBBBB',
          maintenabilityAction: 'BBBBBB',
          performanceRiskLevel: 1,
          performanceImpactLevel: 1,
          performanceMainImpact: 'BBBBBB',
          performanceComment: 'BBBBBB',
          performanceAction: 'BBBBBB',
          indusRiskLevel: 1,
          indusImpactLevel: 1,
          indusMainImpact: 'BBBBBB',
          indusComment: 'BBBBBB',
          indusAction: 'BBBBBB',
          securityRiskLevel: 1,
          securityImpactLevel: 1,
          securityMainImpact: 'BBBBBB',
          securityComment: 'BBBBBB',
          securityAction: 'BBBBBB',
          skillRiskLevel: 1,
          skillImpactLevel: 1,
          skillMainImpact: 'BBBBBB',
          skillComment: 'BBBBBB',
          skillAction: 'BBBBBB',
          environnementRiskLevel: 1,
          environnementImpactLevel: 1,
          environnementMainImpact: 'BBBBBB',
          environnementComment: 'BBBBBB',
          environnementAction: 'BBBBBB',
          operabiltityRiskLevel: 1,
          operabiltityImpactLevel: 1,
          operabiltityMainImpact: 'BBBBBB',
          operabiltityComment: 'BBBBBB',
          operabiltityAction: 'BBBBBB',
        },
        elemDefault
      );

      const expected = Object.assign(
        {
          date: currentDate,
        },
        returnedFromService
      );

      service.update(expected).subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'PUT' });
      req.flush(returnedFromService);
      expect(expectedResult).toMatchObject(expected);
    });

    it('should partial update a Evaluation', () => {
      const patchObject = Object.assign(
        {
          date: currentDate.format(DATE_FORMAT),
          trend: 1,
          comment: 'BBBBBB',
          maintenabilityRiskLevel: 1,
          maintenabilityMainImpact: 'BBBBBB',
          maintenabilityComment: 'BBBBBB',
          performanceRiskLevel: 1,
          performanceImpactLevel: 1,
          performanceMainImpact: 'BBBBBB',
          performanceComment: 'BBBBBB',
          indusRiskLevel: 1,
          indusImpactLevel: 1,
          indusAction: 'BBBBBB',
          securityImpactLevel: 1,
          securityAction: 'BBBBBB',
          skillImpactLevel: 1,
          skillMainImpact: 'BBBBBB',
          skillComment: 'BBBBBB',
          environnementImpactLevel: 1,
          environnementMainImpact: 'BBBBBB',
          environnementComment: 'BBBBBB',
          operabiltityRiskLevel: 1,
          operabiltityImpactLevel: 1,
          operabiltityComment: 'BBBBBB',
        },
        new Evaluation()
      );

      const returnedFromService = Object.assign(patchObject, elemDefault);

      const expected = Object.assign(
        {
          date: currentDate,
        },
        returnedFromService
      );

      service.partialUpdate(patchObject).subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'PATCH' });
      req.flush(returnedFromService);
      expect(expectedResult).toMatchObject(expected);
    });

    it('should return a list of Evaluation', () => {
      const returnedFromService = Object.assign(
        {
          id: 1,
          date: currentDate.format(DATE_FORMAT),
          trend: 1,
          comment: 'BBBBBB',
          maintenabilityRiskLevel: 1,
          maintenabilityImpactLevel: 1,
          maintenabilityMainImpact: 'BBBBBB',
          maintenabilityComment: 'BBBBBB',
          maintenabilityAction: 'BBBBBB',
          performanceRiskLevel: 1,
          performanceImpactLevel: 1,
          performanceMainImpact: 'BBBBBB',
          performanceComment: 'BBBBBB',
          performanceAction: 'BBBBBB',
          indusRiskLevel: 1,
          indusImpactLevel: 1,
          indusMainImpact: 'BBBBBB',
          indusComment: 'BBBBBB',
          indusAction: 'BBBBBB',
          securityRiskLevel: 1,
          securityImpactLevel: 1,
          securityMainImpact: 'BBBBBB',
          securityComment: 'BBBBBB',
          securityAction: 'BBBBBB',
          skillRiskLevel: 1,
          skillImpactLevel: 1,
          skillMainImpact: 'BBBBBB',
          skillComment: 'BBBBBB',
          skillAction: 'BBBBBB',
          environnementRiskLevel: 1,
          environnementImpactLevel: 1,
          environnementMainImpact: 'BBBBBB',
          environnementComment: 'BBBBBB',
          environnementAction: 'BBBBBB',
          operabiltityRiskLevel: 1,
          operabiltityImpactLevel: 1,
          operabiltityMainImpact: 'BBBBBB',
          operabiltityComment: 'BBBBBB',
          operabiltityAction: 'BBBBBB',
        },
        elemDefault
      );

      const expected = Object.assign(
        {
          date: currentDate,
        },
        returnedFromService
      );

      service.query().subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'GET' });
      req.flush([returnedFromService]);
      httpMock.verify();
      expect(expectedResult).toContainEqual(expected);
    });

    it('should delete a Evaluation', () => {
      service.delete(123).subscribe(resp => (expectedResult = resp.ok));

      const req = httpMock.expectOne({ method: 'DELETE' });
      req.flush({ status: 200 });
      expect(expectedResult);
    });

    describe('addEvaluationToCollectionIfMissing', () => {
      it('should add a Evaluation to an empty array', () => {
        const evaluation: IEvaluation = { id: 123 };
        expectedResult = service.addEvaluationToCollectionIfMissing([], evaluation);
        expect(expectedResult).toHaveLength(1);
        expect(expectedResult).toContain(evaluation);
      });

      it('should not add a Evaluation to an array that contains it', () => {
        const evaluation: IEvaluation = { id: 123 };
        const evaluationCollection: IEvaluation[] = [
          {
            ...evaluation,
          },
          { id: 456 },
        ];
        expectedResult = service.addEvaluationToCollectionIfMissing(evaluationCollection, evaluation);
        expect(expectedResult).toHaveLength(2);
      });

      it("should add a Evaluation to an array that doesn't contain it", () => {
        const evaluation: IEvaluation = { id: 123 };
        const evaluationCollection: IEvaluation[] = [{ id: 456 }];
        expectedResult = service.addEvaluationToCollectionIfMissing(evaluationCollection, evaluation);
        expect(expectedResult).toHaveLength(2);
        expect(expectedResult).toContain(evaluation);
      });

      it('should add only unique Evaluation to an array', () => {
        const evaluationArray: IEvaluation[] = [{ id: 123 }, { id: 456 }, { id: 19599 }];
        const evaluationCollection: IEvaluation[] = [{ id: 123 }];
        expectedResult = service.addEvaluationToCollectionIfMissing(evaluationCollection, ...evaluationArray);
        expect(expectedResult).toHaveLength(3);
      });

      it('should accept varargs', () => {
        const evaluation: IEvaluation = { id: 123 };
        const evaluation2: IEvaluation = { id: 456 };
        expectedResult = service.addEvaluationToCollectionIfMissing([], evaluation, evaluation2);
        expect(expectedResult).toHaveLength(2);
        expect(expectedResult).toContain(evaluation);
        expect(expectedResult).toContain(evaluation2);
      });

      it('should accept null and undefined values', () => {
        const evaluation: IEvaluation = { id: 123 };
        expectedResult = service.addEvaluationToCollectionIfMissing([], null, evaluation, undefined);
        expect(expectedResult).toHaveLength(1);
        expect(expectedResult).toContain(evaluation);
      });

      it('should return initial array if no Evaluation is added', () => {
        const evaluationCollection: IEvaluation[] = [{ id: 123 }];
        expectedResult = service.addEvaluationToCollectionIfMissing(evaluationCollection, undefined, null);
        expect(expectedResult).toEqual(evaluationCollection);
      });
    });
  });

  afterEach(() => {
    httpMock.verify();
  });
});
