package com.kloster.repository.postgres;

import com.kloster.entity.postgres.OtherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OtherRepository extends JpaRepository<OtherEntity, Long> {
}
