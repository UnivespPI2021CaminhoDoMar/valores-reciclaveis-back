package br.com.univesp.valoresreciclaveis.controller;

import br.com.univesp.valoresreciclaveis.controller.dto.DetalheZonaResponse;
import br.com.univesp.valoresreciclaveis.controller.dto.PrestacaoRequest;
import br.com.univesp.valoresreciclaveis.controller.dto.PrestacaoResponse;
import br.com.univesp.valoresreciclaveis.model.Prestacao;
import br.com.univesp.valoresreciclaveis.repository.PrestacaoRepository;
import br.com.univesp.valoresreciclaveis.service.PrestacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
        List<Prestacao> prestacoes = repository.findAll();
        if(prestacoes.isEmpty()) return ResponseEntity.ok("Não há prestações cadastradas");

        List<PrestacaoResponse> prestacoesDto = prestacoes.stream().map(PrestacaoResponse::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(prestacoesDto);
    }

    @GetMapping("/detalhes")
    public ResponseEntity<?> getDetalhes(){
        List<DetalheZonaResponse> listaDto = service.detalhesPrestacao(repository);
        if(listaDto.isEmpty()) return ResponseEntity.ok("Não há prestações cadastradas");

        return ResponseEntity.ok(listaDto);
    }

    @PostMapping(value = "/inserir", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> postPrestacao(@RequestBody @Valid PrestacaoRequest request){
        Prestacao prestacao = request.toModel();
        repository.save(prestacao);

        return ResponseEntity.ok("Cadastrado com sucesso!");
    }


}
