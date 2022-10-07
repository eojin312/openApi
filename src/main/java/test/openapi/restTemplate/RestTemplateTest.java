package test.openapi.restTemplate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RestTemplateTest {

    @Autowired
    private OpenApiService openApiService;


    @Test
    @DisplayName("restTemplate_테스트")
    public void restTemplate_테스트 () {
        // given
        openApiService.scheduleBroadcastForObject();
        // when

        // then
    }
}
