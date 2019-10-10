package roman.pidkostelny.dealer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class DealerApplication {


    @PostConstruct
    public void inity() {

    }


    public static void main(String[] args) {
        SpringApplication.run(DealerApplication.class, args);
    }

}

