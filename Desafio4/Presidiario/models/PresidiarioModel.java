package br.com.Desafio4.Presidiario.models;

import lombok.Data;

import java.util.Date;

@Data
public class PresidiarioModel {

    private String nome;
    private String cpf;
    private PresidioModel presidio;
    private Integer numeroRegistro;
    private Date dataNascimento;





}
