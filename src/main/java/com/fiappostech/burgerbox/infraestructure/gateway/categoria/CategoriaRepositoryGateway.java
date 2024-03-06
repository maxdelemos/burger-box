package com.fiappostech.burgerbox.infraestructure.gateway.categoria;

import com.fiappostech.burgerbox.core.entity.produto.Categoria;
import com.fiappostech.burgerbox.core.entity.produto.CategoriaFactory;
import com.fiappostech.burgerbox.core.gateway.CategoriaGateway;
import com.fiappostech.burgerbox.infraestructure.persistence.categoria.CategoriaEntity;
import com.fiappostech.burgerbox.infraestructure.persistence.categoria.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CategoriaRepositoryGateway implements CategoriaGateway {
    private final CategoriaRepository categoriaRepository;
    private final CategoriaFactory categoriaFactory;

    @Override
    public List<Categoria> buscarPorCodigos(List<String> codigos) {
        List<CategoriaEntity> categoriaEntity = categoriaRepository.buscarPorCodigos(codigos);
        return categoriaEntity.stream().map(entity -> categoriaFactory.create(
                entity.getId(),
                entity.getDescricao(),
                entity.getCodigo()
        )).toList();
    }
}
