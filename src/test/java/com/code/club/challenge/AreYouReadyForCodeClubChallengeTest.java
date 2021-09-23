package com.code.club.challenge;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AreYouReadyForCodeClubChallengeTest {

    @Test
    void testIsChallengeAccepted() {
        assertThat(new Challenge().isAccepted()).isTrue();
    }
}
