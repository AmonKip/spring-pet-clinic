package kip.springframework.springpetclinic.bootstrap;

import kip.springframework.springpetclinic.model.Owner;
import kip.springframework.springpetclinic.model.Pet;
import kip.springframework.springpetclinic.model.PetType;
import kip.springframework.springpetclinic.model.Vet;
import kip.springframework.springpetclinic.services.OwnerService;
import kip.springframework.springpetclinic.services.VetService;
import kip.springframework.springpetclinic.services.map.PetTypeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);


        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Rich");
        owner1.setAddress("232 Fairway Dr.");
        owner1.setCity("Manassas");
        owner1.setTelephone("703-123-4567");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Chui");
        owner1.getPets().add(mikesPet);



        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Susan");
        owner2.setLastName("Johnson");
        owner2.setAddress("100 Lomond Dr.");
        owner2.setCity("Fairfax");
        owner2.setTelephone("703-222-1234");

        Pet susansPet = new Pet();
        susansPet.setPetType(savedCatPetType);
        susansPet.setBirthDate(LocalDate.now());
        susansPet.setName("Meow");
        owner2.getPets().add(susansPet);

        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Peter");
        vet1.setLastName("Smith");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Sally");
        vet2.setLastName("Thompson");

        vetService.save(vet2);

        System.out.println("Loaded Vets....");

    }
}
