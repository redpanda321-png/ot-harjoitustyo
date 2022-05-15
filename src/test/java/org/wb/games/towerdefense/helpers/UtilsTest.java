package org.wb.games.towerdefense.helpers;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UtilsTest {

    @Test
    public void testCalculateDurationByX() {
        int previousX = 6;
        int currentX = 9;
        int previousY = 12;
        int currentY = 12;

        float result = Utils.calculateDuration(previousX, previousY, currentX, currentY);

        assertThat(result).isEqualTo(1f);
    }

    @Test
    public void testCalculateDurationByY() {
        int previousX = 6;
        int currentX = 6;
        int previousY = 9;
        int currentY = 15;

        float result = Utils.calculateDuration(previousX, previousY, currentX, currentY);

        assertThat(result).isEqualTo(2f);
    }

}