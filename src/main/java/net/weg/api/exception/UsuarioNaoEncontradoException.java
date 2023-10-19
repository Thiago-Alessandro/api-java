package net.weg.api.exception;

public class UsuarioNaoEncontradoException extends RuntimeException{

    public UsuarioNaoEncontradoException(Integer id){
        super("O usuario de id: " + id + " não foi encontrado!");
    }

}
