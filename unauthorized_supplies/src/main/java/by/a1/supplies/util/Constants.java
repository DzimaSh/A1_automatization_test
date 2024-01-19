package by.a1.supplies.util;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class Constants {

    @Value("${data.location}")
    private String dataLocation;
}
