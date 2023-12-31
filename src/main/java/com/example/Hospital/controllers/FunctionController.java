package com.example.Hospital.controllers;

import jakarta.transaction.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class FunctionController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/functionPage")
    public String showFunctionPage(Model model) {
        return "functionPage";
    }

    @GetMapping("/call-function")
    @ResponseBody
    public Map<String, Integer> callFunction(@RequestParam("start_date") LocalDate startDate,
                                             @RequestParam("end_date") LocalDate endDate) {
        String sql = "SELECT public.countemployeeswithhighereducation(?::DATE, ?::DATE)";
        Integer result = jdbcTemplate.queryForObject(sql, Integer.class, startDate, endDate);

        Map<String, Integer> resultMap = new HashMap<>();
        resultMap.put("result", result);

        return resultMap;
    }

    @GetMapping("/call-doctors-function")
    @ResponseBody
    public Map<String, Integer> callDoctorsFunction(@RequestParam("start_date") LocalDate startDate,
                                                    @RequestParam("end_date") LocalDate endDate) {
        String sql = "SELECT public.countdoctors(?::DATE, ?::DATE)";
        Integer result = jdbcTemplate.queryForObject(sql, Integer.class, startDate, endDate);

        Map<String, Integer> resultMap = new HashMap<>();
        resultMap.put("result", result);

        return resultMap;
    }
    @GetMapping("/call-doctors-by-specialization")
    @ResponseBody
    public Map<String, Integer> callDoctorsBySpecializationFunction(
            @RequestParam("specialization_name") String specializationName,
            @RequestParam("start_date") LocalDate startDate,
            @RequestParam("end_date") LocalDate endDate) {
        String sql = "SELECT public.count_doctors_by_specialization(?, ?, ?)";
        Integer result = jdbcTemplate.queryForObject(sql, Integer.class, specializationName, startDate, endDate);

        Map<String, Integer> resultMap = new HashMap<>();
        resultMap.put("result", result);

        return resultMap;
    }
    @GetMapping("/call-female-patients")
    @ResponseBody
    public Map<String, Integer> callFemalePatientsFunction(@RequestParam("appointment_date") LocalDate appointmentDate) {
        String sql = "SELECT public.count_female_patients(?)";
        Integer result = jdbcTemplate.queryForObject(sql, Integer.class, appointmentDate);

        Map<String, Integer> resultMap = new HashMap<>();
        resultMap.put("result", result);

        return resultMap;
    }
    @GetMapping("/call-employees-with-education")
    @ResponseBody
    public Map<String, Integer> callEmployeesWithEducationFunction(@RequestParam("year") int year) {
        String sql = "SELECT public.count_employees_with_education(?)";
        Integer result = jdbcTemplate.queryForObject(sql, Integer.class, year);

        Map<String, Integer> resultMap = new HashMap<>();
        resultMap.put("result", result);

        return resultMap;
    }
    @GetMapping("/call-expensive-services-without-results")
    @ResponseBody
    public Map<String, Integer> callExpensiveServicesWithoutResultsFunction(
            @RequestParam("cost") int cost,
            @RequestParam("start_date_service") LocalDate startDateService,
            @RequestParam("end_date_service") LocalDate endDateService) {

        String sql = "SELECT public.count_expensive_services_without_results(?, ?, ?)";
        Integer result = jdbcTemplate.queryForObject(sql, Integer.class, cost, startDateService, endDateService);

        Map<String, Integer> resultMap = new HashMap<>();
        resultMap.put("result", result);

        return resultMap;
    }
    @GetMapping("/call-patients-without-phone-over-18")
    @ResponseBody
    public Map<String, Integer> callPatientsWithoutPhoneOver18Function(
            @RequestParam("start_date_record") LocalDate startDateRecord,
            @RequestParam("end_date_record") LocalDate endDateRecord) {

        String sql = "SELECT public.count_patients_without_phone_over_18(?, ?)";
        Integer result = jdbcTemplate.queryForObject(sql, Integer.class, startDateRecord, endDateRecord);

        Map<String, Integer> resultMap = new HashMap<>();
        resultMap.put("result", result);

        return resultMap;
    }
    @GetMapping("/call-qualified-employees")
    @ResponseBody
    public Map<String, Integer> callQualifiedEmployeesFunction(
            @RequestParam("start_date_accepted") LocalDate startDateAccepted,
            @RequestParam("end_date_accepted") LocalDate endDateAccepted) {

        String sql = "SELECT public.count_qualified_employees(?, ?)";
        Integer result = jdbcTemplate.queryForObject(sql, Integer.class, startDateAccepted, endDateAccepted);

        Map<String, Integer> resultMap = new HashMap<>();
        resultMap.put("result", result);

        return resultMap;
    }
    @GetMapping("/call-patients-more-than-2-appointments")
    @ResponseBody
    public Map<String, Integer> callPatientsWithMoreThan2AppointmentsFunction(
            @RequestParam("appointments_count") Integer appointmentsCount,
            @RequestParam("start_date_record") LocalDate startDateRecord,
            @RequestParam("end_date_record") LocalDate endDateRecord) {

        String sql = "SELECT public.count_patients_with_more_than_2_appointments(?, ?, ?)";
        Integer result = jdbcTemplate.queryForObject(sql, Integer.class, appointmentsCount, startDateRecord, endDateRecord);

        Map<String, Integer> resultMap = new HashMap<>();
        resultMap.put("result", result);

        return resultMap;
    }

    @GetMapping("/call-high-salary-positions")
    @ResponseBody
    public List<Map<String, Object>> callHighSalaryPositions() {
        String sql = "SELECT * FROM count_high_salary_positions()";
        return jdbcTemplate.queryForList(sql);
    }

    @GetMapping("/call-employee-education-info")
    @ResponseBody
    public List<Map<String, Object>> callEmployeeEducationInfo() {
        String sql = "SELECT * FROM employee_education_info()";
        return jdbcTemplate.queryForList(sql);
    }
    @GetMapping("/call-employees-count-per-education")
    @ResponseBody
    public List<Map<String, Object>> callEmployeesCountPerEducation() {
        String sql = "SELECT * FROM employees_count_per_education()";
        return jdbcTemplate.queryForList(sql);
    }
    @GetMapping("/months-with-more-than-5-appointments")
    @ResponseBody
    public List<Map<String, Object>> callMonthsWithMoreThan5Appointments() {
        String sql = "SELECT * FROM months_with_more_than_5_appointments()";
        return jdbcTemplate.queryForList(sql);
    }
    @GetMapping("/service-count-by-month")
    @ResponseBody
    public List<Map<String, Object>> callServiceCountByMonth(
            @RequestParam("year_input") int yearInput
    ) {
        String sql = "SELECT * FROM service_count_by_month(?)";
        return jdbcTemplate.queryForList(sql, yearInput);
    }
    @GetMapping("/patients-and-representatives")
    @ResponseBody
    public List<Map<String, Object>> getPatientsAndRepresentatives() {
        String sql = "SELECT * FROM patients_and_legal_representatives_with_link()";
        return jdbcTemplate.queryForList(sql);
    }
    @GetMapping("/count-appointments-adults-current-year")
    @ResponseBody
    public List<Map<String, Object>> getAppointmentsCountAdultsCurrentYear() {
        String sql = "SELECT * FROM count_appointments_adults_current_year_with_month_names()";
        return jdbcTemplate.queryForList(sql);
    }
}