package br.com.Desafio4.Presidiario.controllers;

import br.com.Desafio4.Presidiario.models.PresidiarioModel;
import br.com.Desafio4.Presidiario.models.PresidioModel;
import br.com.Desafio4.Presidiario.services.PresidiarioService;
import br.com.Desafio4.Presidiario.services.PresidioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping(value = "/presidiario")
public class PresidiarioController {




        //USANDO GET...
        @Autowired
        private PresidiarioService service;

        // usar presidio service
        @Autowired
        private PresidioService presidio;


        // ADICIONA NOVO PRESIDIARIO
        @PostMapping(value = "/add")
        public ResponseEntity novoPresidiario(@RequestParam Integer codigoPresidio,
                                              @RequestBody PresidiarioModel presidiario) {
            // busco presidio q ele pertence

            //PresidioService p = service.buscarPorPresidio();
            //p.getListaPresidiarios().add(presidiarioModel);// pego a lista e adiciona o presidiario

            // criar metodo presidio no presidioService
            presidiario.setPresidio(presidio.buscarPorCodigo(codigoPresidio));
            service.adicionar(presidiario);
            return new ResponseEntity(presidiario, HttpStatus.CREATED);

        }


        //LISTAR PRESIDIARIOS
        @GetMapping(value = "/listar")
        public ResponseEntity ListarTodos() {
            return new ResponseEntity(service.ListaTodos(), HttpStatus.OK);
//..................................................................
        }


        // LISTAR POR REGISTRO
        @GetMapping(value = "/listarRg{resgistro}")
        public ResponseEntity ListarPorRegistro(@PathVariable Integer registro) {

            Optional<PresidiarioModel> Preso = service.buscarPorResgistro(registro);
            if (Preso == null) {
                return new ResponseEntity<>("registro invalido", HttpStatus.BAD_REQUEST);

            }
            return new ResponseEntity(Preso, HttpStatus.OK);


        }

        // DELETAR
        @DeleteMapping(value = "/deletar/{registro}")
        public ResponseEntity deletar(@PathVariable String registro) {
            service.remove(registro);
            return new ResponseEntity(HttpStatus.OK);
        }


    }






