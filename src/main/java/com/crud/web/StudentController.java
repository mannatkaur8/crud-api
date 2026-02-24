package com.crud.web;

import com.crud.dto.StudentCreateRequest;
import com.crud.dto.StudentUpdateRequest;
import com.crud.dto.StudentResponse;
import com.crud.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    // CREATE -> 201 Created
    @PostMapping
    public ResponseEntity<StudentResponse> create(@Valid @RequestBody StudentCreateRequest req) {
        StudentResponse res = service.create(req);
        return ResponseEntity.created(URI.create("/api/students/" + res.getId()))
                .body(res);
    }

    // READ one -> 200 OK (404 handled globally)
    @GetMapping("/{id}")
    public ResponseEntity<StudentResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    // READ all -> 200 OK
    @GetMapping
    public ResponseEntity<List<StudentResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    // UPDATE -> 200 OK (404/400 handled globally)
    @PutMapping("/{id}")
    public ResponseEntity<StudentResponse> update(@PathVariable Long id,
                                                  @Valid @RequestBody StudentUpdateRequest req) {
        return ResponseEntity.ok(service.update(id, req));
    }

    // DELETE -> 204 No Content (404 handled globally)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}