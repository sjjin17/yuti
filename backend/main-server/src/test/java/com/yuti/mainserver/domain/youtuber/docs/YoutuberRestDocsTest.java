package com.yuti.mainserver.domain.youtuber.docs;

import com.yuti.mainserver.domain.youtuber.Service.YoutuberService;
import com.yuti.mainserver.domain.youtuber.api.YoutuberApiController;
import com.yuti.mainserver.domain.youtuber.dto.YoutuberResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(YoutuberApiController.class)
@AutoConfigureRestDocs
public class YoutuberRestDocsTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private YoutuberService youtuberService;

    @Test
    public void youtuber_검색() throws Exception {
        // given
        String request = "삼성청년";
        List<YoutuberResponseDto> response = new ArrayList<>();
        response.add(YoutuberResponseDto.builder()
                .channelId("UC_XI3ByFO1uZIIH-g-zJZiw")
                .channelName("삼성청년SW아카데미 Youtube채널 HELLOSSAFY")
                .thumbnail("https://yt3.ggpht.com/ytc/AMLnZu9qdR9T9_9OXz27_3lZVs4hfwECef2oUSylrcQv=s800-c-k-c0x00ffffff-no-rj").build());
        given(youtuberService.searchYoutuber(anyString())).willReturn(response);

        // when, then
        mockMvc.perform(RestDocumentationRequestBuilders.get("/api/v1/youtubers/{keyword}", request))
                .andExpect(status().isOk())
                .andDo(document("youtuber-search",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        pathParameters(
                                parameterWithName("keyword").description("검색할 단어")
                        ),
                        responseFields(
                                fieldWithPath("success").description("API 요청 성공 여부").type(JsonFieldType.BOOLEAN),
                                fieldWithPath("data").description("Response data").type(JsonFieldType.ARRAY)
                        ).andWithPrefix("data[].",
                                fieldWithPath("channelId").description("유튜버 채널 id").type(JsonFieldType.STRING),
                                fieldWithPath("channelName").description("유튜버 채널명").type(JsonFieldType.STRING),
                                fieldWithPath("thumbnail").description("유튜버 썸네일 주소").type(JsonFieldType.STRING))
                        ));
    }
}
