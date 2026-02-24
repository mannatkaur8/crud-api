package com.crud.service;

import com.crud.dto.StudentCreateRequest;
import com.crud.dto.StudentUpdateRequest;
import com.crud.dto.StudentResponse;
import com.crud.entity.Student;
import com.crud.exception.ResourceNotFoundException;
import com.crud.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    // CREATE
    public StudentResponse create(StudentCreateRequest req) {
        if (repo.existsByEmail(req.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }

        Student s = new Student();
        s.setName(req.getName());
        s.setEmail(req.getEmail());
        s.setAge(req.getAge());

        Student saved = repo.save(s);
        return toResponse(saved);
    }

    // READ one
    @Transactional(readOnly = true)
    public StudentResponse getById(Long id) {
        Student s = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found: " + id));
        return toResponse(s);
    }

    // READ all
    @Transactional(readOnly = true)
    public List<StudentResponse> getAll() {
        return repo.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    // UPDATE (only update fields that are not null in the request)
    public StudentResponse update(Long id, StudentUpdateRequest req) {
        Student s = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found: " + id));

        // Update name if provided
        if (req.getName() != null) {
            s.setName(req.getName());
        }

        // Update email if provided
        if (req.getEmail() != null) {
            String newEmail = req.getEmail();
            String oldEmail = s.getEmail();

            // Only check duplicates if the email is actually changing
            boolean emailChanged = (oldEmail == null && newEmail != null)
                    || (oldEmail != null && !oldEmail.equals(newEmail));

            if (emailChanged) {
                if (repo.existsByEmail(newEmail)) {
                    throw new IllegalArgumentException("Email already exists");
                }
                s.setEmail(newEmail);
            }
        }

        // Update age if provided
        if (req.getAge() != null) {
            s.setAge(req.getAge());
        }

        Student saved = repo.save(s);
        return toResponse(saved);
    }

    // DELETE
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new ResourceNotFoundException("Student not found: " + id);
        }
        repo.deleteById(id);
    }

    // Helper: Entity -> Response DTO
    private StudentResponse toResponse(Student s) {
        return new StudentResponse(
                s.getId(),
                s.getName(),
                s.getEmail(),
                s.getAge()
        );
    }
}