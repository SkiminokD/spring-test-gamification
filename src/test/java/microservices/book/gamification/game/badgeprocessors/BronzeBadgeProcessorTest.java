package microservices.book.gamification.game.badgeprocessors;

import microservices.book.gamification.game.domain.BadgeType;
import microservices.book.gamification.game.domain.badgeprocessors.BronzeBadgeProcessor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class BronzeBadgeProcessorTest {

    private BronzeBadgeProcessor badgeProcessor;

    @BeforeEach
    public void setUp() {
        badgeProcessor = new BronzeBadgeProcessor();
    }

    @Test
    public void shouldGiveBadgeIfScoreOverThreshold() {
        Optional<BadgeType> badgeType = badgeProcessor
                .processForOptionalBadge(51, List.of(), null);

        assertThat(badgeType).contains(BadgeType.BRONZE);
    }

    @Test
    public void shouldNotGiveBadgeIfScoreUnderThreshold() {
        Optional<BadgeType> badgeType = badgeProcessor
                .processForOptionalBadge(49, List.of(), null);

        assertThat(badgeType).isEmpty();
    }
}
