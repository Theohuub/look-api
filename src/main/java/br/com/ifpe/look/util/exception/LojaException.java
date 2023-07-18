package br.com.ifpe.look.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class LojaException extends RuntimeException {
    
    public static final String MSG_NOME_DUPLICADO = "Já existe uma loja com o nome %s, favor informe outro nome";

    public LojaException(String msg, String nome) {

	    super(String.format(msg, nome));
    }
}