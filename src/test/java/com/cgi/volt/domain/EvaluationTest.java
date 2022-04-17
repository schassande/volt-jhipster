package com.cgi.volt.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.cgi.volt.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class EvaluationTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Evaluation.class);
        Evaluation evaluation1 = new Evaluation();
        evaluation1.setId(1L);
        Evaluation evaluation2 = new Evaluation();
        evaluation2.setId(evaluation1.getId());
        assertThat(evaluation1).isEqualTo(evaluation2);
        evaluation2.setId(2L);
        assertThat(evaluation1).isNotEqualTo(evaluation2);
        evaluation1.setId(null);
        assertThat(evaluation1).isNotEqualTo(evaluation2);
    }
}
