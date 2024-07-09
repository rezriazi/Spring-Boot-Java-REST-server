package com.usm.usmobile.controller;

import com.usm.usmobile.model.User;
import com.usm.usmobile.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        userRepository.deleteAll();
    }

    @Test
    public void createUser() throws Exception {
        User user = new User();
        user.setFirstName("Oprah");
        user.setLastName("Winfrey");
        user.setEmail("oprah871@gmail.com");
        user.setPassword("lobster345");

        mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"firstName\":\"Oprah\",\"lastName\":\"Winfrey\",\"email\":\"oprah871@gmail.com\"}"));
    }

    @Test
    public void createInvalidUser() throws Exception {
        User user = new User();
        user.setFirstName("Pat");

        mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getUserById() throws Exception {
        User user = new User();
        user.setFirstName("Rez");
        user.setLastName("Riazi");
        user.setEmail("rez@riazi.com");
        user.setPassword("p@ssw0rd");

        User savedUser = userRepository.save(user);

        mockMvc.perform(get("/users/" + savedUser.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(savedUser)));
    }

    @Test
    public void updateUser() throws Exception {
        User user = new User();
        user.setFirstName("Ray");
        user.setLastName("Delray");
        user.setEmail("ra212@yahoo.com");
        user.setPassword("b@seb@11");

        User savedUser = userRepository.save(user);

        savedUser.setFirstName("Alex");
        savedUser.setLastName("Doe");
        savedUser.setEmail("alexalex@gmail.com");

        mockMvc.perform(put("/users/" + savedUser.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(savedUser)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"firstName\":\"Alex\",\"lastName\":\"Doe\",\"email\":\"alexalex@gmail.com\"}"));
    }

    @Test
    public void updateInvalidUser() throws Exception {
        User user = new User();
        user.setId("invalidId");
        user.setFirstName("XX");
        user.setLastName("YY");
        user.setEmail("XYZ@test.com");
        user.setPassword("123");

        mockMvc.perform(put("/users/" + user.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isNotFound());
    }

    @Test
    public void deleteUser() throws Exception {
        User user = new User();
        user.setFirstName("Rez");
        user.setLastName("Riazi");
        user.setEmail("rez@riazi.com");
        user.setPassword("p@ssw0rd");

        User savedUser = userRepository.save(user);

        mockMvc.perform(delete("/users/" + savedUser.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mockMvc.perform(get("/users/" + savedUser.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void getAllUsers() throws Exception {
        User user1 = new User();
        user1.setFirstName("Rez");
        user1.setLastName("Riazi");
        user1.setEmail("rez@riazi.com");
        user1.setPassword("p@ssw0rd");

        User user2 = new User();
        user2.setFirstName("Sara");
        user2.setLastName("Mo");
        user2.setEmail("sara@gmail.com");
        user2.setPassword("03852035");

        userRepository.save(user1);
        userRepository.save(user2);

        mockMvc.perform(get("/users")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(userRepository.findAll())));
    }
}
