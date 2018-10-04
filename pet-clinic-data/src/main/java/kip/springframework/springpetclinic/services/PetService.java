package kip.springframework.springpetclinic.services;

import kip.springframework.springpetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet Save(Pet pet);

    Set<Pet> findAll();
}
