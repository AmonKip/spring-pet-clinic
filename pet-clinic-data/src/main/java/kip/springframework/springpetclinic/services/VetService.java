package kip.springframework.springpetclinic.services;

import kip.springframework.springpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet Save(Vet vet);

    Set<Vet> findAll();
}
