package br.com.db1.db1start.bancoapi.controller;

import br.com.db1.db1start.bancoapi.adapter.EstadoAdapter;
import br.com.db1.db1start.bancoapi.dto.EstadoDTO;
import br.com.db1.db1start.bancoapi.dto.EstadoFormDTO;
import br.com.db1.db1start.bancoapi.entity.Estado;
import br.com.db1.db1start.bancoapi.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
        Estado estado = estadoService.criar(estadoFormDTO.getNome());
        return EstadoAdapter.converteEntidadeEstadoParaDTO(estado);
    }
}
