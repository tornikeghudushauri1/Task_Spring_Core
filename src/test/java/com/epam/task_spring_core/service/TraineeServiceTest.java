package com.epam.task_spring_core.service;

import com.epam.task_spring_core.dao.TraineeDAO;
import com.epam.task_spring_core.model.Trainee;
import com.epam.task_spring_core.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class TraineeServiceTest {

    @Mock
    private TraineeDAO traineeDAO;

    @InjectMocks
    private TraineeService traineeService;

    @Test
    void testCreateOrUpdateTrainee() {
        Trainee trainee = new Trainee();
        trainee.setId("1");

        traineeService.createOrUpdateTrainee(trainee);

        verify(traineeDAO, times(1)).save(trainee);
    }

    @Test
    void testGetTraineeById() {
        String id = "1";
        Trainee trainee = new Trainee();
        trainee.setId(id);

        when(traineeDAO.findById(id)).thenReturn(trainee);

        Trainee result = traineeService.getTraineeById(id);

        assertEquals(trainee, result);
    }

    @Test
    void testDeleteTrainee() {
        String id = "1";

        traineeService.deleteTrainee(id);

        verify(traineeDAO, times(1)).delete(id);
    }

    @Test
    void testCreateOrUpdateTraineeProfile() {
        Trainee trainee = mock(Trainee.class);

        User user = createMockUser();

        when(trainee.getUser()).thenReturn(user);

        when(traineeDAO.findById(anyString())).thenReturn(null);

        traineeService.createOrUpdateTraineeProfile(trainee);

        verify(traineeDAO, times(1)).save(trainee);

        assertEquals("tornike.ghudushauri", trainee.getUser().getUsername());
    }

    private User createMockUser() {
        return new User("User1",
                "Tornike",
                "Ghudushauri",
                null,
                null,
                true);
    }
}