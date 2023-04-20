package br.com.Desafio4.Presidiario.services;

import br.com.Desafio4.Presidiario.controllers.PresidiarioController;
import br.com.Desafio4.Presidiario.models.PresidiarioModel;
import br.com.Desafio4.Presidiario.models.PresidioModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PresidiarioService {


    private List<PresidiarioModel> presidiarioService = new ArrayList<>();

    public void adicionar(PresidiarioModel presidiarioSalvo){

        presidiarioService.add(presidiarioSalvo);

    }

    public List<PresidiarioModel> ListaTodos(){
        return presidiarioService;

    }
    public Optional<PresidiarioModel> buscarPorResgistro(Integer registro){
        return presidiarioService.stream().filter(p-> registro.equals(p.getNumeroRegistro())).findFirst();
    }





    public PresidioModel buscarPorPresidio() {
        return null;

    }



    public void remove(String registro) {

       return new ResponseEntity<registro>(HttpStatus.NO_CONTENT);
    }
}

