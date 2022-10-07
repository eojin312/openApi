package test.openapi.restTemplate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import test.openapi.restTemplate.dto.BroadcastDto;

@Service
@Slf4j
public class OpenApiServiceImpl implements OpenApiService{

    private RestTemplate restTemplate;

    @Autowired
    public OpenApiServiceImpl(@Qualifier("restTemplateBean") RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }




    public void boradcast() {
        String url = UriComponentsBuilder.fromUriString("https://dev-dotcom-front-api.hanatour.com")
                .path("/hanalive/core/broadcast/applicants")
                .queryParam("customerNumber", "C200002519")
                .build().toUriString();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<BroadcastDto> forEntity = restTemplate.getForEntity(url, BroadcastDto.class);
        log.info("boradcast : {}", forEntity);
    }


    @Override
    public ResponseEntity<BroadcastDto> scheduleBroadcast() {
        return null;
    }

    @Override
    public BroadcastDto scheduleBroadcastForObject() {
        return null;
    }
}
