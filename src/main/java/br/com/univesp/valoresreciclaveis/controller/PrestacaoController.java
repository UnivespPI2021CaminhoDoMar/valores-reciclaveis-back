package br.com.univesp.valoresreciclaveis.controller;

import br.com.univesp.valoresreciclaveis.controller.dto.DetalheZonaResponse;
import br.com.univesp.valoresreciclaveis.controller.dto.PrestacaoRequest;
import br.com.univesp.valoresreciclaveis.controller.dto.PrestacaoResponse;
import br.com.univesp.valoresreciclaveis.model.Prestacao;
import br.com.univesp.valoresreciclaveis.repository.PrestacaoRepository;
import br.com.univesp.valoresreciclaveis.service.PrestacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.AccessControlContext;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/prestacao-contas")
public class PrestacaoController {

    @Autowired
    private PrestacaoRepository repository;

    @Autowired
    private PrestacaoService service;

    @GetMapping
    public ResponseEntity<?> getAll(){
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Access-Control-Allow-Origin", "*");
        List<Prestacao> prestacoes = repository.findAll();
        if(prestacoes.isEmpty()) return ResponseEntity.ok("Não há prestações cadastradas");

        List<PrestacaoResponse> prestacoesResponse = prestacoes.stream().map(PrestacaoResponse::new).collect(Collectors.toList());
        return ResponseEntity.ok().headers(responseHeaders).body(prestacoesResponse);
    }

    @GetMapping(value = "/detalhes")
    public ResponseEntity<?> getDetalhes(){
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Access-Control-Allow-Origin", "*");
        List<DetalheZonaResponse> listaDto = service.detalhesPrestacao(repository);
        if(listaDto.isEmpty()) return ResponseEntity.ok("Não há prestações cadastradas");

        return ResponseEntity.ok().headers(responseHeaders).body(listaDto);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping(value = "/inserir",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> postPrestacao(@RequestBody @Valid PrestacaoRequest request){
        //HttpHeaders responseHeaders = new HttpHeaders();
        //responseHeaders.add("Access-Control-Allow-Origin", "*");
        Prestacao prestacao = request.toModel();
        repository.save(prestacao);

        return ResponseEntity.ok().body("Cadastrado com sucesso!");
    }


}
