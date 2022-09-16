package mish.vlad.hw_streams;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceTest {
    private final EmployeeService employeeService = new EmployeeServiceImpl();


        public Stream<Arguments> EmployeeParamsForTest() {
            return Stream.of(Arguments.of("Ivan", "Psov", 12411, 2),
                    Arguments.of("Pes", "Koshkin", 23521, 1),
                    Arguments.of("Polyak, Polyakov", 63443, 1),
                    Arguments.of("Anna", "Feodorva", 87221, 1),
                    Arguments.of("Alex", "Belyashikov", 11123, 2)
            );
        }
        @Test
        public void IncorrectAddInputTest(){
            assertThrows(InvalidInputException,)
        }

        @ParameterizedTest
        @MethodSource("EmployeeParamsForTest")
        public void positiveAddTest(String firstName, String lastName, int salary, int departmentId){
            employeeService.addEmployee(firstName, lastName, salary, departmentId);


        }






}
