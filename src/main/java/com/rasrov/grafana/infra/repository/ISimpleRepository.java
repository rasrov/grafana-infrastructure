package com.rasrov.grafana.infra.repository;

import com.rasrov.grafana.infra.model.Simple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISimpleRepository extends JpaRepository<Simple, Long> {
}
