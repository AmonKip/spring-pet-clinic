package kip.springframework.springpetclinic.bootstrap;

import kip.springframework.springpetclinic.model.*;
import kip.springframework.springpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }


    @Override
    public void run(String... args) throws Exception {

        int count = vetService.findAll().size();

        if(count == 0){
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);


        // Specialties
        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

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

        Pet susansCat = new Pet();
        susansCat.setPetType(savedCatPetType);
        susansCat.setBirthDate(LocalDate.now());
        susansCat.setName("Meow");
        owner2.getPets().add(susansCat);

        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(susansCat);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");

        visitService.save(catVisit);

        System.out.println("Loaded Owners....");

        // Vets
        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Peter");
        vet1.setLastName("Smith");
        vet1.getSpecialties().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Sally");
        vet2.setLastName("Thompson");
        vet2.getSpecialties().add(savedDentistry);

        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }
}
