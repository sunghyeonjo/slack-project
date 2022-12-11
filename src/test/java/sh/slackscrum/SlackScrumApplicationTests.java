package sh.slackscrum;

import com.slack.api.webhook.WebhookResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
@Slf4j
class SlackScrumApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void messageTest() throws IOException {
        Message message = new Message();
        WebhookResponse r = message.send();
        log.info("Response : {}", r.getMessage());

    }

}
