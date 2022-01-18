package microservices.book.gamification.game;

import microservices.book.gamification.game.domain.BadgeCard;
import microservices.book.gamification.game.domain.BadgeType;
import microservices.book.gamification.game.domain.LeaderBoardRow;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.BDDAssertions.then;

@ExtendWith(MockitoExtension.class)
public class LeaderBoardServiceImplTest {

    private LeaderBoardService leaderBoardService;

    @Mock
    private ScoreRepository scoreRepository;
    @Mock
    private BadgeRepository badgeRepository;

    @BeforeEach
    public void setUp() {
        leaderBoardService = new LeaderBoardServiceImpl(scoreRepository, badgeRepository);
    }

    @Test
    public void checkFoundingTopUserTest() {
        // given
        LeaderBoardRow leaderBoardRow = new LeaderBoardRow(1L, 1L, List.of());
        BadgeCard badgeCard = new BadgeCard(1L, BadgeType.FIRST_WON);
        given(scoreRepository.findFirst10())
                .willReturn(List.of(leaderBoardRow));
        given(badgeRepository.findByUserIdOrderByBadgeTimestampDesc(any()))
                .willReturn(List.of(badgeCard));

        // when
        var leaders = leaderBoardService.getCurrentLeaderBoard();

        // then
        LeaderBoardRow expectedLeaderBoard = new LeaderBoardRow(1L, 1L,
                List.of(BadgeType.FIRST_WON.getDescription()));
        then(leaders).isEqualTo(List.of(expectedLeaderBoard));
    }
}
