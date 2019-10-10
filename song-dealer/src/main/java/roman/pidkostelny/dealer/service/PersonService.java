package roman.pidkostelny.dealer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import roman.pidkostelny.dealer.dto.request.PersonRequest;
import roman.pidkostelny.dealer.dto.respons.DataResponse;
import roman.pidkostelny.dealer.dto.respons.PersonRespons;
import roman.pidkostelny.dealer.entity.Person;
import roman.pidkostelny.dealer.repository.PersonRepository;
import roman.pidkostelny.dealer.specification.PersonSpecification;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public Integer save(PersonRequest personRequest) {
        Person person = new Person();
        person.setFirstName(personRequest.getFirstName());
        person.setLastName(personRequest.getLastName());
        person.setAge(personRequest.getAge());
        person = personRepository.save(person);
        return person.getId();
    }

    public DataResponse<PersonRespons> findAll(String value, Integer page, Integer size, String fieldName, Sort.Direction direction) {
        Sort sort = Sort.by(direction, fieldName);
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        Page<Person> pagePerson;
        if (value != null && !value.equals("")) {
            PersonSpecification specification = new PersonSpecification(value);
            pagePerson = personRepository.findAll(specification, pageRequest);
        } else {
            pagePerson = personRepository.findAll(pageRequest);
        }
        return new DataResponse<PersonRespons>(pagePerson.stream().map(PersonRespons::new).collect(Collectors.toList()), pagePerson);
    }

    @Transactional
    public PersonRespons findOne(Integer id) {
        Optional<Person> personOptional = personRepository.findById(id);
        if (personOptional.isPresent()) {
            return new PersonRespons(personOptional.get());
        } else {
            throw new IllegalArgumentException("Person with id " + id + " not found");
        }
    }

    public void delete(Integer id) {
        personRepository.deleteById(id);
    }
}
