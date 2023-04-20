package br.com.Desafio4.Presidiario.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PresidioModel {

    private List <PresidiarioModel> listaPresidiarios= new ArrayList<PresidiarioModel>();
    private Integer codigoPresidio;
    private String nomePresidio;



}
