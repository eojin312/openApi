package test.openapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import test.openapi.restTemplate.OpenApiServiceImpl;

@SpringBootTest
class OpenApiServiceTest {

    @Autowired
    private OpenApiServiceImpl openApiService;

    @Test
    void scheduleBroadcast() {

        // Then
        openApiService.scheduleBroadcast();
    }

    @Test
    void scheduleBroadcastForObject() throws JsonProcessingException {
        openApiService.scheduleBroadcastForObject();
    }

    @Test
    @DisplayName("레스트템플릿테스트")
    public void 레스트템플릿테스트 () {

        // then
        openApiService.boradcast();

    }
}
