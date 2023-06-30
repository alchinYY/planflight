package ru.test.java.planflight.service.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.test.java.planflight.exception.NotFoundException;
import ru.test.java.planflight.model.Employee;
import ru.test.java.planflight.repository.EmployeeRepo;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.*;
import static ru.test.java.planflight.config.MessageConstants.MESSAGE_ENTITY_WITH_ID_NOT_FOUND;

@ExtendWith(MockitoExtension.class)
@DisplayName("Unit test for EmployeeDbService")
class EmployeeDbServiceTest {

    private static final Long TEST_EMPLOYEE_ID = 1L;

    @Mock
    private EmployeeRepo employeeRepo;

    @InjectMocks
    private EmployeeDbService employeeService;

    @Test
    @DisplayName("Get by id: Good answer")
    public void getById_isOk() {

        var employee = Employee.builder()
                .id(TEST_EMPLOYEE_ID)
                .build();

        when(employeeRepo.findById(TEST_EMPLOYEE_ID)).thenReturn(Optional.of(employee));

        assertThat(employeeService.getById(TEST_EMPLOYEE_ID))
                .isEqualTo(employee);
        verify(employeeRepo, times(1)).findById(TEST_EMPLOYEE_ID);
    }

    @Test
    @DisplayName("Get by id: exception NotFound")
    public void getById_isNotFound() {

        when(employeeRepo.findById(TEST_EMPLOYEE_ID)).thenReturn(Optional.empty());

        assertThatExceptionOfType(NotFoundException.class)
                .isThrownBy(() -> employeeService.getById(TEST_EMPLOYEE_ID))
                        .withMessage(String.format(MESSAGE_ENTITY_WITH_ID_NOT_FOUND, Employee.class.getSimpleName(), TEST_EMPLOYEE_ID));
        verify(employeeRepo, times(1)).findById(TEST_EMPLOYEE_ID);
    }

    @Test
    @DisplayName("Upload one Employee: Good answer")
    public void upload_isOk() {
        var employee = Employee.builder()
                .id(TEST_EMPLOYEE_ID)
                .build();

        when(employeeRepo.save(employee)).thenReturn(employee);

        assertThat(employeeService.upload(employee))
                .isEqualTo(employee);
        verify(employeeRepo, times(1)).save(employee);
    }

}