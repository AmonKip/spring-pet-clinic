package kip.springframework.springpetclinic.services;

import kip.springframework.springpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findByLastName(String lastName);

    Owner findById(Long id);

    Owner Save(Owner owner);

    Set<Owner> findAll();
}
