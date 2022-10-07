package test.openapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import test.openapi.dto.BroadcastDto;

public interface OpenApiService {
    ResponseEntity<BroadcastDto> scheduleBroadcast();

    BroadcastDto scheduleBroadcastForObject();
}
