package com.vntechies.k8sspringbootseries.courses.clients;

import com.vntechies.k8sspringbootseries.courses.clients.configs.StudentClientConfigs;
import com.vntechies.k8sspringbootseries.courses.clients.dto.GetStudentsByIdsReq;
import com.vntechies.k8sspringbootseries.courses.clients.dto.GetStudentsByIdsResp;
import com.vntechies.k8sspringbootseries.courses.clients.dto.StudentDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@AllArgsConstructor
public class StudentClientImpl implements IStudentClient {

    private static final RestTemplate restTemplate = new RestTemplate();
    private final StudentClientConfigs configs;

    @Override
    public StudentDTO getStudentById(String studentId) {
        return restTemplate.getForObject(configs.getUri() + "/api/students/getStudentBy?studentId=" + studentId, StudentDTO.class);
    }

    @Override
    public GetStudentsByIdsResp getStudentsByIds(GetStudentsByIdsReq req) {
        return restTemplate.postForObject(configs.getUri() + "/api/students/getStudentsBy", req, GetStudentsByIdsResp.class);
    }
}
