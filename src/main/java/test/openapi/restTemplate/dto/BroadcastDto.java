package test.openapi.restTemplate.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class BroadcastDto {
    private String logKey;
    private List<BroadcastInfo> data;

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @ToString
    public static class BroadcastInfo {
        private int id;
        private String broadcastId;
        private String custNum;
        private String reqChannelCd;
        private int kindCd;
        private String sendStatCd;
        private String createProgramId;
        private String updateProgramId;
    }
}
