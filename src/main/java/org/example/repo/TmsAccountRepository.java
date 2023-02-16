package org.example.repo;

import org.example.entity.TmsAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TmsAccountRepository extends JpaRepository<TmsAccount, Long> {
}
