package test.openapi.restTemplate;

import org.springframework.http.ResponseEntity;
import test.openapi.restTemplate.dto.BroadcastDto;

public interface OpenApiService {
    ResponseEntity<BroadcastDto> scheduleBroadcast();

    BroadcastDto scheduleBroadcastForObject();
}
