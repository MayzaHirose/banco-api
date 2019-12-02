package br.com.db1.db1start.bancoapi.adapter;

import br.com.db1.db1start.bancoapi.dto.EstadoDTO;
import br.com.db1.db1start.bancoapi.dto.EstadoFormDTO;
import br.com.db1.db1start.bancoapi.entity.Estado;

public class EstadoAdapter {

    public static EstadoDTO converteEntidadeEstadoParaDTO(Estado estado) {
        EstadoDTO estadoDTO = new EstadoDTO();
        estadoDTO.setId(estado.getId());
        estadoDTO.setNome(estado.getNome());
        return estadoDTO;
    }

    public static Estado converteDTOParaEntidadeEstado(EstadoFormDTO dto) {
        Estado estado = new Estado();
        estado.setNome(dto.getNome());
        return estado;
    }
}
