import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

	@ExceptionHandler(value=Exception.class)
	public ResponseEntity<Object> errorHandler() {
		String error = "An error occured while processing request";
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
