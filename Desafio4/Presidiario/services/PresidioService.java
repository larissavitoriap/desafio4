package br.com.Desafio4.Presidiario.services;

import br.com.Desafio4.Presidiario.models.PresidioModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PresidioService {

    ArrayList<PresidioModel> listaDePresidio= new ArrayList<PresidioModel>();

    public List<PresidioModel> listarTodos(){
        return listaDePresidio;
    }
    public void adicionar(PresidioModel P){
        listaDePresidio.add(P);
    }

    public Optional<PresidioModel> buscarPorCodigo(Integer codigoPresidio){

        return listaDePresidio.stream().filter(c-> codigoPresidio.equals(c.getCodigoPresidio())).findFirst();
    }
}
