package test.openapi.restTemplate;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Configuration
public class RestTemplateConfig {

    @Bean(name = "anotherResttemplate")
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {

        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setMaxConnTotal(120)   // 생성할 connection 수
                .setMaxConnPerRoute(100)    //각 호스트(IP와 Port의 조합)당 커넥션 풀에 생성가능한 커넥션 수
                .setConnectionTimeToLive(5, TimeUnit.SECONDS)   // 서버 keep - alive 설정
                .build();

        // apache HttpClient를 사용해 request 생성
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setHttpClient(httpClient);  //HttpComponentsClientHttpRequestFactory 생성자에 주입

        BufferingClientHttpRequestFactory bufferingClientHttpRequestFactory = new BufferingClientHttpRequestFactory(factory);

        // HttpURLConnection을 사용해 request 생성
        // 기본생성자로 초기화시 SimpleClientHttpRequestFactory 사용
        //RestTemplate restTemplate = new RestTemplate();

        return restTemplateBuilder
                .requestFactory(() -> bufferingClientHttpRequestFactory)
                .setConnectTimeout(Duration.ofMillis(5000)) //읽기시간초과, ms
                .setReadTimeout(Duration.ofMillis(5000))    //연결시간초과, ms
                .build();
    }

    @Bean(name = "restTemplateToDefault")
    public RestTemplate restTemplateToDefault(RestTemplateBuilder restTemplateBuilder) {
        CloseableHttpClient closeableHttpClient = HttpClientBuilder.create()
                .setMaxConnTotal(100)
                .setMaxConnPerRoute(100)
                .setConnectionTimeToLive(5, TimeUnit.SECONDS)
                .build();

        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setHttpClient(closeableHttpClient);


        return restTemplateBuilder
                .requestFactory(() -> factory)
                .setReadTimeout(Duration.ofMillis(5000))
                .setConnectTimeout(Duration.ofMillis(5000))
                .errorHandler(new DefaultResponseErrorHandler())
                .build();
    }

    @Bean("restTemplateBean")
    public RestTemplate resttemplate(RestTemplateBuilder restTemplateBuilder) {
        CloseableHttpClient httpClient = HttpClientBuilder
                .create()
                .setMaxConnTotal(100)
                .setMaxConnPerRoute(100)
                .build();

        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setHttpClient(httpClient);

        return restTemplateBuilder
                .requestFactory(() -> factory)
                .setReadTimeout(Duration.ofSeconds(5))
                .setConnectTimeout(Duration.ofSeconds(5))
                .build();
    }

}
