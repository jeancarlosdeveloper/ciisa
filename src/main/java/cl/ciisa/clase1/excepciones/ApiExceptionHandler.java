package cl.ciisa.clase1.excepciones;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	ResponseEntity<ErrorMessage> satisfactoryRequest(HttpServletRequest request, Exception exception) {
		ErrorMessage response = ErrorMessage.builder().exception(exception.getClass().getSimpleName())
				.message(exception.getMessage()).timestamp(LocalDateTime.now()).path(request.getRequestURI()).build();
		return new ResponseEntity<ErrorMessage>(response, HttpStatus.CREATED);
	}


	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ 
		org.springframework.dao.InvalidDataAccessApiUsageException.class,
		//org.springframework.web.bind.MissingRequestHeaderException.class
	})
	@ResponseBody
	public ResponseEntity<ErrorMessage> badRequest(HttpHeaders headers, HttpStatus status, WebRequest request,
			Exception ex ) {

		ErrorMessage response = ErrorMessage.builder().status(status.toString()).exception(ex.getClass().getSimpleName())
					.message(ex.getLocalizedMessage()).timestamp(LocalDateTime.now())
					.path(request.getContextPath()).build();
		

		return ResponseEntity.badRequest().body(response);

	}
	


	

	/**Valida que el pathVariable sea el tipo de valor correcto*/
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	protected ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex,
			WebRequest request) {
		
		ErrorMessage response = ErrorMessage.builder()
				.status(HttpStatus.BAD_REQUEST.toString()).exception(ex.getClass().getSimpleName())
				.message(String.format("El parametro '%s' con el valor '%s' no puede ser convertido a '%s', que es el tipo de dato esperado.",
						ex.getName(), ex.getValue(), ex.getRequiredType().getSimpleName()))
				.timestamp(LocalDateTime.now())
				.path(request.getContextPath()).build();

		return ResponseEntity.badRequest().body(response);

	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler({ 
		NotFoundException.class, 
		NoSuchElementException.class,
		javax.persistence.EntityNotFoundException.class
	})
	@ResponseBody
	public ResponseEntity<Object> notFoundRequest(HttpServletRequest request, Exception exception) {
		ErrorMessage response= ErrorMessage.builder()
				.status(HttpStatus.NOT_FOUND.toString())
				.exception(exception.getClass().getSimpleName())
				.message(exception.getMessage())
				.timestamp(LocalDateTime.now())
				.path(request.getRequestURI()).build();
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}
	
//
//	@Override
//	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
//			HttpStatus status, WebRequest request) {
//		
//		
//		ErrorMessage response=ErrorMessage.builder()
//		.status(status.toString())
//		.exception(ex.getClass().getSimpleName())
//		.message(ex.getMessage())
//		.fecha(LocalDateTime.now())
//		.path("").build();
//		
//		return ResponseEntity.badRequest().body(response) ;
//	}

	@ResponseStatus(HttpStatus.FORBIDDEN)
	@ExceptionHandler({ ForbiddenException.class })
	@ResponseBody
	public ErrorMessage forbiddenRequest(HttpServletRequest request, Exception exception) {
		return ErrorMessage.builder().exception(exception.getClass().getSimpleName()).message(exception.getMessage())
				.timestamp(LocalDateTime.now()).path(request.getRequestURI()).build();
	}

	

	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ExceptionHandler({ UnauthorizedException.class })
	@ResponseBody
	public ErrorMessage unauthorizedRequest(HttpServletRequest request, Exception exception) {
		return ErrorMessage.builder().exception(exception.getClass().getSimpleName()).message(exception.getMessage())
				.timestamp(LocalDateTime.now()).path(request.getRequestURI()).build();
	}
	
	//VALIDADO
	@ResponseStatus(HttpStatus.CONFLICT)
	@ExceptionHandler({ 
		ConflictException.class, 
		DuplicateKeyException.class,
		DataIntegrityViolationException.class,
		JpaObjectRetrievalFailureException.class
	})
	@ResponseBody
	public ResponseEntity<Object> conflictRequest(HttpServletRequest request, Exception exception) {
		
		ErrorMessage response =null;
	
		String mensaje="";
		if(exception instanceof DataIntegrityViolationException) {
			String mensajeFormateado=exception.getMessage().split("constraint")[1].substring(2).split("]")[0].replaceFirst("\" *$", "");
			mensaje = "Inconvenientes para realizar operación en base de datos. El atributo ["+mensajeFormateado +"] ya se encuentra en los registros, intente ingresar otro por favor.";
		}
		
		
		if(exception instanceof JpaObjectRetrievalFailureException) {
			mensaje= exception.getMessage();
		}
		

		response = ErrorMessage.builder()
						.status(HttpStatus.CONFLICT.toString())
						.exception(exception.getClass().getSimpleName())
						.message(mensaje)
						.timestamp(LocalDateTime.now())
						.path(request.getContextPath()).build();

		return ResponseEntity.status(HttpStatus.CONFLICT).body(response);	
	}
	

	//VALIDADO
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorMessage response = ErrorMessage.builder().status(status.toString())
				.exception(ex.getClass().getSimpleName())
				.message(
						"La estructura del json que envia en el cuerpo de la petición es sintaxicamente incorrecto. Por favor revise nuevamente.")
				.timestamp(LocalDateTime.now()).path(request.getContextPath()).build();
		return ResponseEntity.badRequest().body(response);
	}

	
	//VALIDADO
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorMessage response = ErrorMessage.builder().status(status.toString())
				.exception(ex.getClass().getSimpleName())
				.message("El verbo HTTP (" + ex.getMethod()+ ") o el endpoint que esta apuntando, no esta soportado en el servidor.")
				.timestamp(LocalDateTime.now()).path(request.getContextPath()).build();
		return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(response);
		
	
	}
	


	//VALIDADO
	@Override
	protected ResponseEntity<Object> handleServletRequestBindingException(ServletRequestBindingException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
			ErrorMessage response= null;
			MissingRequestHeaderException missingException = (MissingRequestHeaderException) ex;
			response = ErrorMessage.builder()
					.status(status.toString())
					.exception(ex.getClass().getSimpleName())
					.message("El header ("+missingException.getHeaderName()+") se debe ingresar para la petición.")
					.timestamp(LocalDateTime.now())
					.path(request.getContextPath()).build();

		return ResponseEntity.badRequest().body(response);
	}

	
	@ExceptionHandler({ 
		Exception.class, 
		javax.validation.ConstraintViolationException.class
		})
	@ResponseBody
	public ResponseEntity<ErrorMessage> fatalErrorUnexpectedExceptionRequest(HttpServletRequest request,
			Exception exception, ConstraintViolationException constraintException) {

		Map<String, List<String>> map = new HashMap<>();
	
		constraintException.getConstraintViolations().forEach(m -> {
			String property = m.getPropertyPath().toString();
			String mensaje = m.getMessage();
			if (map.containsKey(property)) {
				List<String> msg = map.get(property);
				msg.add(mensaje);
				map.put(property, msg);
			} else {
				map.put(property, new ArrayList<String>(Arrays.asList(mensaje)));
			}
		});
		
		

		if (exception instanceof ConstraintViolationException) {
			ErrorMessage response = ErrorMessage.builder()
					.status(HttpStatus.INTERNAL_SERVER_ERROR.toString())
					.exception(exception.getClass().getSimpleName())
					.message(map.toString())
					.timestamp(LocalDateTime.now())
					.path(request.getRequestURI())
					.build();

			return ResponseEntity.badRequest().body(response);

		} else {

			ErrorMessage response = ErrorMessage.builder().exception(exception.getClass().getSimpleName())
					.message(constraintException.getMessage()).timestamp(LocalDateTime.now()).path(request.getRequestURI())
					.build();

			return ResponseEntity.internalServerError().body(response);
		}

	}

}
