package microservices.book.gamification.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GameEventHandlerTest {

    private GameEventHandler gameEventHandler;

    @Mock
    private GameService gameService;

    @BeforeEach
    public void setUp() {
        this.gameEventHandler = new GameEventHandler(gameService);
    }

    @Test
    public void processEventHandlingTest() {

    }
}
