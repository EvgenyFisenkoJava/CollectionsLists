package pro.sky.java.collectionslists;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "EmployeeAlreadyAdded")
public class EmployeeAlreadyAddedException extends RuntimeException{
    public EmployeeAlreadyAddedException () {
        super();
    }
}
