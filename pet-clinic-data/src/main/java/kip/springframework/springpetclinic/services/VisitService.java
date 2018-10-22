package kip.springframework.springpetclinic.services;

import kip.springframework.springpetclinic.model.Visit;
import org.springframework.stereotype.Service;

@Service
public interface VisitService extends  CrudService<Visit, Long> {
}
