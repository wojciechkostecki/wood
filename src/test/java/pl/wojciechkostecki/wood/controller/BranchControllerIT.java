package pl.wojciechkostecki.wood.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import pl.wojciechkostecki.wood.exception.BadRequestException;
import pl.wojciechkostecki.wood.model.dto.BranchDTO;
import pl.wojciechkostecki.wood.repository.BranchRepository;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class BranchControllerIT {

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void saveBranchWhenNoBranchOrTrunkIdIsGiven() throws Exception {
        BranchDTO branchDTO = new BranchDTO();
        branchDTO.setLengthInCm(55.0);

        int dbSize = branchRepository.findAll().size();

        mockMvc.perform(MockMvcRequestBuilders.post("/api/branches")
                .content(objectMapper.writeValueAsString(branchDTO))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(result -> Assertions.assertTrue(result.getResolvedException() instanceof BadRequestException));

        int dbSizeAfter = branchRepository.findAll().size();

        assertThat(dbSizeAfter).isEqualTo(dbSize);
    }

    @Test
    void saveBranchWhenBranchAndTrunkIdAreGiven() throws Exception {
        BranchDTO branchDTO = new BranchDTO();
        branchDTO.setLengthInCm(55.0);
        branchDTO.setBranchId(3L);
        branchDTO.setTrunkId(4L);

        int dbSize = branchRepository.findAll().size();

        mockMvc.perform(MockMvcRequestBuilders.post("/api/branches")
                .content(objectMapper.writeValueAsString(branchDTO))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(result -> Assertions.assertTrue(result.getResolvedException() instanceof BadRequestException));

        int dbSizeAfter = branchRepository.findAll().size();

        assertThat(dbSizeAfter).isEqualTo(dbSize);
    }
}