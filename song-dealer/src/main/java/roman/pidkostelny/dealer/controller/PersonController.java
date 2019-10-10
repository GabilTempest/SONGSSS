package roman.pidkostelny.dealer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import roman.pidkostelny.dealer.dto.request.PersonRequest;
import roman.pidkostelny.dealer.dto.respons.DataResponse;
import roman.pidkostelny.dealer.dto.respons.PersonRespons;
import roman.pidkostelny.dealer.entity.Person;
import roman.pidkostelny.dealer.exception.WrongInp;
import roman.pidkostelny.dealer.service.PersonService;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping
    public DataResponse<PersonRespons> getPersons(@RequestParam(required = false) String value,
                                                  @RequestParam Integer page,
                                                  @RequestParam Integer size,
                                                  @RequestParam String sortFieldName,
                                                  @RequestParam Sort.Direction direction) {
        System.out.println("GET ALL PERSONS");
        return personService.findAll(value, page, size, sortFieldName, direction);
    }

    @GetMapping("/{id}")
    public PersonRespons getPersonById(@PathVariable Integer id) {
        System.out.println("Get person by id : " + id);
        return personService.findOne(id);
    }

    @PostMapping
    public Integer createPerson(@RequestBody @Valid PersonRequest personRequest) {
        System.out.println("SAVE PERSON IN DB with first name -> " + personRequest.getFirstName());
        return personService.save(personRequest);
    }

    @DeleteMapping("/{id}")
    public void search(@PathVariable Integer id) {
        System.out.println("Delete person by id " + id);
        personService.delete(id);
    }


}
