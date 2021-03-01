describe('filling a form', () => {
        it('displays thank you message after submitting the form', () => {
            cy.visit('https://formy-project.herokuapp.com/form');
            cy.get('#first-name').type('name');
            cy.get('#last-name').type('last name');
            cy.get('#job-title').type('job');
            cy.get('#radio-button-1').click();
            cy.get('#checkbox-1').click();
            cy.get('#select-menu').select('1');
            cy.get('#datepicker').type('07/08/1898');
            cy.get('.btn.btn-lg.btn-primary').click();

            cy.get('.alert.alert-success')
                .invoke('text')
                .should('contain', 'The form was successfully submitted!');

        });
});
