package br.ifba.eduardosouza.prjSpring.controller;

import br.ifba.eduardosouza.prjSpring.facade.IUserFacade;
import br.ifba.eduardosouza.prjSpring.model.User;
import br.ifba.eduardosouza.prjSpring.service.IUserService;
import jakarta.validation.Valid;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private IUserFacade userFacade;

    //@Valid é uma validação beseada no modelo
    @PostMapping("/cadastrar")
    public RedirectView salvarUser(@ModelAttribute @Valid User user){
        //Salvando no banco de dados
        if(userFacade.saveUser(user)){
            System.out.println("salvou");
            return new RedirectView("/login");
        }else{
            return new RedirectView("/cadastrar");
        }
    }

    //Interceptar as mensagens

    //map<Nome do campo, mensagem de erro>
    @ResponseStatus(HttpStatus.BAD_REQUEST) // toda vez que eu tiver um bad request eu vou interceptar toda vez que tiver MethodArgumentNotValidException
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(MethodArgumentNotValidException ex){
        Map<String, String> erros =  new HashMap<>();

        //Aqui preciso pegar a exceção e ver as informações dentro dela
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            //aqui vou adicionar os erros na minha lista
            String fieldName = ( (FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();

            erros.put(fieldName, errorMessage);
        });

        return erros;
    }

}
