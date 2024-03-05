package com.fiappostech.burgerbox.infraestructure.gateway.produto;

import com.fiappostech.burgerbox.core.entity.produto.*;
import com.fiappostech.burgerbox.core.entity.produto.factory.Produto;
import com.fiappostech.burgerbox.core.gateway.ProdutoGateway;
import com.fiappostech.burgerbox.infraestructure.persistence.produto.ProdutoEntity;
import com.fiappostech.burgerbox.infraestructure.persistence.produto.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProdutoRepositoryGateway implements ProdutoGateway {
    private final ProdutoRepository produtoRepository;
    private final CategoriaFactory categoriaFactory;

    @Override
    public Produto cadastrar(Produto produtoCommon) {
        ProdutoEntity produtoEntity = ProdutoEntityMapper.INSTANCE.toEntity(produtoCommon);

        ProdutoEntity produtoEntityCadastrado = produtoRepository.saveAndFlush(produtoEntity);

        List<Categoria> categorias = produtoEntityCadastrado.getCategorias().stream().map(categoriaEntity -> categoriaFactory.create(
                categoriaEntity.getId(),
                categoriaEntity.getDescricao(),
                categoriaEntity.getCodigo()
        )).collect(Collectors.toList());

        return new Produto(produtoEntityCadastrado.getId(), produtoEntityCadastrado.getNome(), produtoEntityCadastrado.getPreco(), categorias);
    }

    @Override
    public Produto editar(Produto produtoDomain) {
        ProdutoEntity produtoEntity = ProdutoEntityMapper.INSTANCE.toEntity(produtoDomain);
        ProdutoEntity produtoEntityCadastrado = produtoRepository.saveAndFlush(produtoEntity);
        return null;
    }

    @Override
    public Produto remover(Produto produtoDomain) {
        ProdutoEntity produtoEntity = ProdutoEntityMapper.INSTANCE.toEntity(produtoDomain);
        ProdutoEntity produtoEntityCadastrado = produtoRepository.saveAndFlush(produtoEntity);
        return null;
    }

    @Override
    public Boolean existe(String nome) {
        List<ProdutoEntity> produtoEntity = produtoRepository.findAllByNome(nome);
        return !produtoEntity.isEmpty();
    }
}
