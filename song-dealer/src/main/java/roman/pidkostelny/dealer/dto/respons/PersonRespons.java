package roman.pidkostelny.dealer.dto.respons;

import lombok.Getter;
import lombok.Setter;
import roman.pidkostelny.dealer.entity.Person;

@Getter
@Setter
public class PersonRespons {

    private Integer id;

    private String firstName;

    private String lastName;

    private Integer age;

    public PersonRespons(Person person) {
        this.id = person.getId();
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.age = person.getAge();
    }

}
