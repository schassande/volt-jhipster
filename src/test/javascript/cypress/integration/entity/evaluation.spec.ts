import { entityItemSelector } from '../../support/commands';
import {
  entityTableSelector,
  entityDetailsButtonSelector,
  entityDetailsBackButtonSelector,
  entityCreateButtonSelector,
  entityCreateSaveButtonSelector,
  entityCreateCancelButtonSelector,
  entityEditButtonSelector,
  entityDeleteButtonSelector,
  entityConfirmDeleteButtonSelector,
} from '../../support/entity';

describe('Evaluation e2e test', () => {
  const evaluationPageUrl = '/evaluation';
  const evaluationPageUrlPattern = new RegExp('/evaluation(\\?.*)?$');
  const username = Cypress.env('E2E_USERNAME') ?? 'user';
  const password = Cypress.env('E2E_PASSWORD') ?? 'user';
  const evaluationSample = {};

  let evaluation: any;

  beforeEach(() => {
    cy.login(username, password);
  });

  beforeEach(() => {
    cy.intercept('GET', '/api/evaluations+(?*|)').as('entitiesRequest');
    cy.intercept('POST', '/api/evaluations').as('postEntityRequest');
    cy.intercept('DELETE', '/api/evaluations/*').as('deleteEntityRequest');
  });

  afterEach(() => {
    if (evaluation) {
      cy.authenticatedRequest({
        method: 'DELETE',
        url: `/api/evaluations/${evaluation.id}`,
      }).then(() => {
        evaluation = undefined;
      });
    }
  });

  it('Evaluations menu should load Evaluations page', () => {
    cy.visit('/');
    cy.clickOnEntityMenuItem('evaluation');
    cy.wait('@entitiesRequest').then(({ response }) => {
      if (response!.body.length === 0) {
        cy.get(entityTableSelector).should('not.exist');
      } else {
        cy.get(entityTableSelector).should('exist');
      }
    });
    cy.getEntityHeading('Evaluation').should('exist');
    cy.url().should('match', evaluationPageUrlPattern);
  });

  describe('Evaluation page', () => {
    describe('create button click', () => {
      beforeEach(() => {
        cy.visit(evaluationPageUrl);
        cy.wait('@entitiesRequest');
      });

      it('should load create Evaluation page', () => {
        cy.get(entityCreateButtonSelector).click();
        cy.url().should('match', new RegExp('/evaluation/new$'));
        cy.getEntityCreateUpdateHeading('Evaluation');
        cy.get(entityCreateSaveButtonSelector).should('exist');
        cy.get(entityCreateCancelButtonSelector).click();
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(200);
        });
        cy.url().should('match', evaluationPageUrlPattern);
      });
    });

    describe('with existing value', () => {
      beforeEach(() => {
        cy.authenticatedRequest({
          method: 'POST',
          url: '/api/evaluations',
          body: evaluationSample,
        }).then(({ body }) => {
          evaluation = body;

          cy.intercept(
            {
              method: 'GET',
              url: '/api/evaluations+(?*|)',
              times: 1,
            },
            {
              statusCode: 200,
              headers: {
                link: '<http://localhost/api/evaluations?page=0&size=20>; rel="last",<http://localhost/api/evaluations?page=0&size=20>; rel="first"',
              },
              body: [evaluation],
            }
          ).as('entitiesRequestInternal');
        });

        cy.visit(evaluationPageUrl);

        cy.wait('@entitiesRequestInternal');
      });

      it('detail button click should load details Evaluation page', () => {
        cy.get(entityDetailsButtonSelector).first().click();
        cy.getEntityDetailsHeading('evaluation');
        cy.get(entityDetailsBackButtonSelector).click();
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(200);
        });
        cy.url().should('match', evaluationPageUrlPattern);
      });

      it('edit button click should load edit Evaluation page', () => {
        cy.get(entityEditButtonSelector).first().click();
        cy.getEntityCreateUpdateHeading('Evaluation');
        cy.get(entityCreateSaveButtonSelector).should('exist');
        cy.get(entityCreateCancelButtonSelector).click();
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(200);
        });
        cy.url().should('match', evaluationPageUrlPattern);
      });

      it('last delete button click should delete instance of Evaluation', () => {
        cy.get(entityDeleteButtonSelector).last().click();
        cy.getEntityDeleteDialogHeading('evaluation').should('exist');
        cy.get(entityConfirmDeleteButtonSelector).click();
        cy.wait('@deleteEntityRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(204);
        });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(200);
        });
        cy.url().should('match', evaluationPageUrlPattern);

        evaluation = undefined;
      });
    });
  });

  describe('new Evaluation page', () => {
    beforeEach(() => {
      cy.visit(`${evaluationPageUrl}`);
      cy.get(entityCreateButtonSelector).click();
      cy.getEntityCreateUpdateHeading('Evaluation');
    });

    it('should create an instance of Evaluation', () => {
      cy.get(`[data-cy="date"]`).type('2022-03-29').should('have.value', '2022-03-29');

      cy.get(`[data-cy="trend"]`).type('99546').should('have.value', '99546');

      cy.get(`[data-cy="comment"]`).type('Assistant').should('have.value', 'Assistant');

      cy.get(`[data-cy="maintenabilityRiskLevel"]`).type('24651').should('have.value', '24651');

      cy.get(`[data-cy="maintenabilityImpactLevel"]`).type('20943').should('have.value', '20943');

      cy.get(`[data-cy="maintenabilityMainImpact"]`).select('Contract');

      cy.get(`[data-cy="maintenabilityComment"]`).type('withdrawal Malaisie').should('have.value', 'withdrawal Malaisie');

      cy.get(`[data-cy="maintenabilityAction"]`)
        .type('Bedfordshire feed Superviseur')
        .should('have.value', 'Bedfordshire feed Superviseur');

      cy.get(`[data-cy="performanceRiskLevel"]`).type('67293').should('have.value', '67293');

      cy.get(`[data-cy="performanceImpactLevel"]`).type('48212').should('have.value', '48212');

      cy.get(`[data-cy="performanceMainImpact"]`).select('Financial');

      cy.get(`[data-cy="performanceComment"]`).type('Frozen User-centric').should('have.value', 'Frozen User-centric');

      cy.get(`[data-cy="performanceAction"]`).type('Directeur').should('have.value', 'Directeur');

      cy.get(`[data-cy="indusRiskLevel"]`).type('29727').should('have.value', '29727');

      cy.get(`[data-cy="indusImpactLevel"]`).type('52870').should('have.value', '52870');

      cy.get(`[data-cy="indusMainImpact"]`).select('HR');

      cy.get(`[data-cy="indusComment"]`).type('copying').should('have.value', 'copying');

      cy.get(`[data-cy="indusAction"]`)
        .type('infrastructures Vanuatu application')
        .should('have.value', 'infrastructures Vanuatu application');

      cy.get(`[data-cy="securityRiskLevel"]`).type('93486').should('have.value', '93486');

      cy.get(`[data-cy="securityImpactLevel"]`).type('80307').should('have.value', '80307');

      cy.get(`[data-cy="securityMainImpact"]`).select('Client');

      cy.get(`[data-cy="securityComment"]`).type('Dauphine').should('have.value', 'Dauphine');

      cy.get(`[data-cy="securityAction"]`).type('Marcadet Innovative Limousin').should('have.value', 'Marcadet Innovative Limousin');

      cy.get(`[data-cy="skillRiskLevel"]`).type('24088').should('have.value', '24088');

      cy.get(`[data-cy="skillImpactLevel"]`).type('89835').should('have.value', '89835');

      cy.get(`[data-cy="skillMainImpact"]`).select('Contract');

      cy.get(`[data-cy="skillComment"]`).type('calculating vertical Analyste').should('have.value', 'calculating vertical Analyste');

      cy.get(`[data-cy="skillAction"]`).type('Cotton synergistic').should('have.value', 'Cotton synergistic');

      cy.get(`[data-cy="environnementRiskLevel"]`).type('707').should('have.value', '707');

      cy.get(`[data-cy="environnementImpactLevel"]`).type('89257').should('have.value', '89257');

      cy.get(`[data-cy="environnementMainImpact"]`).select('Financial');

      cy.get(`[data-cy="environnementComment"]`).type('Tasty copy intangible').should('have.value', 'Tasty copy intangible');

      cy.get(`[data-cy="environnementAction"]`).type('protocol').should('have.value', 'protocol');

      cy.get(`[data-cy="operabiltityRiskLevel"]`).type('7435').should('have.value', '7435');

      cy.get(`[data-cy="operabiltityImpactLevel"]`).type('47212').should('have.value', '47212');

      cy.get(`[data-cy="operabiltityMainImpact"]`).select('Client');

      cy.get(`[data-cy="operabiltityComment"]`).type('clicks-and-mortar').should('have.value', 'clicks-and-mortar');

      cy.get(`[data-cy="operabiltityAction"]`).type('Seychelles').should('have.value', 'Seychelles');

      cy.get(entityCreateSaveButtonSelector).click();

      cy.wait('@postEntityRequest').then(({ response }) => {
        expect(response!.statusCode).to.equal(201);
        evaluation = response!.body;
      });
      cy.wait('@entitiesRequest').then(({ response }) => {
        expect(response!.statusCode).to.equal(200);
      });
      cy.url().should('match', evaluationPageUrlPattern);
    });
  });
});
