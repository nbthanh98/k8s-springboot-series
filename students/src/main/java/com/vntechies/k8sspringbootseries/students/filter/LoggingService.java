package com.vntechies.k8sspringbootseries.students.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
@Slf4j
public class LoggingService {
    private static final String REQUEST_ID = "request_id";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public void logRequest(HttpServletRequest httpServletRequest, Object body) throws JsonProcessingException {
        if (httpServletRequest.getRequestURI().contains("medias")) {
            return;
        }
        Object requestId = httpServletRequest.getAttribute(REQUEST_ID);
        StringBuilder data = new StringBuilder();
        data.append("\nLOGGING REQUEST BODY-----------------------------------\n")
                .append("[REQUEST-ID]: ").append(requestId).append("\n")
                .append("[BODY REQUEST]: ").append("\n")
                .append(objectMapper.writeValueAsString(body))
                .append("\n")
                .append("LOGGING REQUEST BODY-----------------------------------\n");

        log.info(data.toString());
    }

    public void logResponse(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object body) throws JsonProcessingException {
        if (httpServletRequest.getRequestURI().contains("medias")) {
            return;
        }
        Object requestId = httpServletRequest.getAttribute(REQUEST_ID);
        StringBuilder data = new StringBuilder();
        data.append("\nLOGGING RESPONSE-----------------------------------\n")
                .append("[REQUEST-ID]: ").append(requestId).append("\n")
                .append("[BODY RESPONSE]: ").append("\n")
                .append(objectMapper.writeValueAsString(body))
                .append("\n")
                .append("LOGGING RESPONSE-----------------------------------\n");

        log.info(data.toString());
    }
}
