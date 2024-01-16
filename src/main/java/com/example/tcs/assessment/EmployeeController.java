package com.example.tcs.assessment;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeRepository repo;

    @GetMapping("/employee")
    public Employee getEmployee(@RequestParam int id) {
        return repo.findById(id).get();
    }

    @GetMapping("/list")
    public Iterable<Employee> getAll() {
        return repo.findAll();
    }

    @PostMapping("/employee")
    public int postEmployee(@Valid @RequestBody Employee e) {
        repo.save(e);

        return e.getId();
    }

    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee e) {
        if (repo.existsById(e.getId())) {
            repo.save(e);
        }

        return e;
    }

    @DeleteMapping("employee")
    public int deleteEmployee(@RequestParam int id) {
        repo.deleteById(id);

        return 1;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex) {

        List<String> details = new ArrayList<>();
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            details.add(error.getDefaultMessage());
        }
        ErrorResponse error = new ErrorResponse("Validation Failed", details);
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }

}
