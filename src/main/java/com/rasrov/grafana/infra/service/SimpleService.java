package com.rasrov.grafana.infra.service;

import com.rasrov.grafana.infra.model.Simple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.rasrov.grafana.infra.repository.ISimpleRepository;

import java.util.Optional;

@Service
public class SimpleService {
  @Autowired
  private ISimpleRepository iSimpleRepository;

  public Simple saveSimple(Simple simple) {
    if (simple.getId() == null) {
      return iSimpleRepository.save(simple);
    }
    return null;
  }

  public Page<Simple> getAllSimple(Integer page, Integer size, Boolean enablePagination) {
    return iSimpleRepository.findAll(
        enablePagination ? PageRequest.of(page, size) : Pageable.unpaged());
  }

  public Optional<Simple> findById(Long id) {
    return iSimpleRepository.findById(id);
  }

  public void deleteSimple(Long id) {
    iSimpleRepository.deleteById(id);
  }

  public Simple editSimple(Simple simple) {
    if (simple.getId() != null && iSimpleRepository.existsById(simple.getId())) {
      return iSimpleRepository.save(simple);
    }
    return null;
  }

  public boolean existById(Long id) {
    return iSimpleRepository.existsById(id);
  }

}
