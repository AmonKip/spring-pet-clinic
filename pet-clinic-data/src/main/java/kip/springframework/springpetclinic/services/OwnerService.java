package kip.springframework.springpetclinic.services;

import kip.springframework.springpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

}
