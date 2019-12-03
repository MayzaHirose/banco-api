package br.com.db1.db1start.bancoapi.service;

import br.com.db1.db1start.bancoapi.dto.EstadoFormDTO;
import br.com.db1.db1start.bancoapi.entity.Estado;
import br.com.db1.db1start.bancoapi.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public Estado criar(String nome) {
        Estado estado = new Estado();
        estado.setNome(nome);
        return estadoRepository.save(estado);
    }

    public Estado atualizar(Long estadoId, EstadoFormDTO formDTO) {
        return atualizar(estadoId, formDTO.getNome());
    }

    public Estado atualizar(Long estadoId, String novoNome) {
        Estado estado = buscarPorId(estadoId);
        estado.setNome(novoNome);
        return estadoRepository.save(estado);
    }

    public Estado buscarPorId(Long id) {
        return estadoRepository.findById(id).orElseThrow(() -> new RuntimeException("Estado não encontrado"));
    }

    public List<Estado> buscarTodos() {
        return estadoRepository.findAll();
    }

    public void deletarPorId(Long id) {
        estadoRepository.deleteById(id);
    }
    
    public void deletarTodos() {
    	estadoRepository.deleteAll();
    }
}
