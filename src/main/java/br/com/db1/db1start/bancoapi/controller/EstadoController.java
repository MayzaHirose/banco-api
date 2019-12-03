package br.com.db1.db1start.bancoapi.controller;

import br.com.db1.db1start.bancoapi.adapter.EstadoAdapter;
import br.com.db1.db1start.bancoapi.dto.EstadoDTO;
import br.com.db1.db1start.bancoapi.dto.EstadoFormDTO;
import br.com.db1.db1start.bancoapi.entity.Estado;
import br.com.db1.db1start.bancoapi.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @GetMapping("/estados")
    public List<EstadoDTO> buscarTodosEstados() {
        List<Estado> entidadesEstado = estadoService.buscarTodos();
        return entidadesEstado.stream()
                .map(EstadoAdapter::converteEntidadeEstadoParaDTO).collect(Collectors.toList());
    }

    @PostMapping("/estados")
    public EstadoDTO criarEstado(@RequestBody EstadoFormDTO estadoFormDTO) {
        Estado estadoCriado = estadoService.criar(estadoFormDTO.getNome());
        return EstadoAdapter.converteEntidadeEstadoParaDTO(estadoCriado);
    }

    @PutMapping("/estados/{estadoId}")
    public EstadoDTO alterarEstado(@PathVariable Long estadoId, @RequestBody EstadoFormDTO formDTO) {
        Estado estadoAlterado = estadoService.atualizar(estadoId, formDTO);
        return EstadoAdapter.converteEntidadeEstadoParaDTO(estadoAlterado);
    }

    @DeleteMapping("/estados/{estadoId}")
    public void deletarEstado(@PathVariable Long estadoId) {
        estadoService.deletarPorId(estadoId);
    }
}
