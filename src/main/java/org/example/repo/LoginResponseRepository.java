package org.example.repo;

import org.example.entity.LoginResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginResponseRepository extends JpaRepository<LoginResponse, String> {
}
