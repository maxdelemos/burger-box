package com.fiappostech.burgerbox.infraestructure.gateway;

import com.fiappostech.burgerbox.core.entity.produto.Categoria;
import com.fiappostech.burgerbox.core.entity.produto.CategoriaFactory;
import com.fiappostech.burgerbox.core.entity.produto.Produto;
import com.fiappostech.burgerbox.core.entity.produto.ProdutoFactory;
import com.fiappostech.burgerbox.core.gateway.ProdutoGateway;
import com.fiappostech.burgerbox.infraestructure.persistence.CategoriaEntity;
import com.fiappostech.burgerbox.infraestructure.persistence.ProdutoEntity;
import com.fiappostech.burgerbox.infraestructure.persistence.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProdutoGatewayImpl implements ProdutoGateway {
    private final ProdutoRepository produtoRepository;
    private final CategoriaFactory categoriaFactory;
    private final ProdutoFactory produtoFactory;

    @Override
    public Produto cadastrar(Produto produto) {
        List<CategoriaEntity> categoriasEntity = produto.getCategorias()
                .stream()
                .map(categoria -> CategoriaEntity
                        .builder()
                        .id(categoria.getId())
                        .descricao(categoria.getDescricao())
                        .codigo(categoria.getCodigo())
                        .build()
                ).toList();

        ProdutoEntity produtoEntity = ProdutoEntity
                .builder()
                .nome(produto.getNome())
                .preco(produto.getPreco())
                .descricao(produto.getDescricao())
                .imagem(produto.getImagem())
                .categorias(categoriasEntity)
                .ativo(true)
                .dataCriacao(LocalDateTime.now())
                .dataAtualizacao(LocalDateTime.now())
                .build();

        ProdutoEntity produtoEntityCadastrado = produtoRepository.saveAndFlush(produtoEntity);

        List<Categoria> categorias = produtoEntityCadastrado.getCategorias()
                .stream()
                .map(categoriaEntity -> categoriaFactory.create(
                        categoriaEntity.getId(),
                        categoriaEntity.getDescricao(),
                        categoriaEntity.getCodigo()
                )).toList();

        return produtoFactory.create(
                produtoEntityCadastrado.getId(),
                produtoEntityCadastrado.getNome(),
                produtoEntityCadastrado.getPreco(),
                produtoEntityCadastrado.getDescricao(),
                produtoEntityCadastrado.getImagem(),
                categorias,
                produtoEntityCadastrado.getAtivo(),
                produtoEntityCadastrado.getDataCriacao(),
                produtoEntityCadastrado.getDataCriacao()
        );
    }

    @Override
    public Produto editar(Produto produto) {
        List<CategoriaEntity> categoriasEntity = produto.getCategorias()
                .stream()
                .map(categoria -> CategoriaEntity
                        .builder()
                        .id(categoria.getId())
                        .descricao(categoria.getDescricao())
                        .codigo(categoria.getCodigo())
                        .build()
                ).toList();

        ProdutoEntity produtoEntity = ProdutoEntity
                .builder()
                .id(produto.getId())
                .nome(produto.getNome())
                .preco(produto.getPreco())
                .descricao(produto.getDescricao())
                .imagem(produto.getImagem())
                .categorias(categoriasEntity)
                .ativo(true)
                .dataCriacao(produto.getDataCriacao())
                .dataAtualizacao(LocalDateTime.now())
                .build();

        ProdutoEntity produtoEntityCadastrado = produtoRepository.saveAndFlush(produtoEntity);

        List<Categoria> categorias = produtoEntityCadastrado.getCategorias()
                .stream()
                .map(categoriaEntity -> categoriaFactory.create(
                        categoriaEntity.getId(),
                        categoriaEntity.getDescricao(),
                        categoriaEntity.getCodigo()
                )).toList();

        return produtoFactory.create(
                produtoEntityCadastrado.getId(),
                produtoEntityCadastrado.getNome(),
                produtoEntityCadastrado.getPreco(),
                produtoEntityCadastrado.getDescricao(),
                produtoEntityCadastrado.getImagem(),
                categorias,
                produtoEntityCadastrado.getAtivo(),
                produtoEntityCadastrado.getDataCriacao(),
                produtoEntityCadastrado.getDataAtualizacao()
        );
    }

    @Override
    public void remover(Long id) {
        produtoRepository.remover(id);
    }

    @Override
    public Boolean existePorNomeAtivo(String nome) {
        List<ProdutoEntity> produtoEntity = produtoRepository.findAllByNomeAndAtivo(nome, Boolean.TRUE);
        return !produtoEntity.isEmpty();
    }

    @Override
    public Produto buscarPorIdAtivo(Long id) {
        Optional<ProdutoEntity> produtoEntity = produtoRepository.findByIdAndAtivo(id, Boolean.TRUE);

        if (produtoEntity.isPresent()) {
            List<Categoria> categorias = produtoEntity.get().getCategorias()
                    .stream()
                    .map(categoriaEntity -> categoriaFactory.create(
                            categoriaEntity.getId(),
                            categoriaEntity.getDescricao(),
                            categoriaEntity.getCodigo()
                    )).toList();

            return produtoFactory.create(
                    produtoEntity.get().getId(),
                    produtoEntity.get().getNome(),
                    produtoEntity.get().getPreco(),
                    produtoEntity.get().getDescricao(),
                    produtoEntity.get().getImagem(),
                    categorias,
                    produtoEntity.get().getAtivo(),
                    produtoEntity.get().getDataCriacao(),
                    produtoEntity.get().getDataCriacao()
            );
        }

        return null;
    }

    @Override
    public List<Produto> buscarPorIdsAtivo(List<Long> ids) {
        List<ProdutoEntity> produtoEntity = produtoRepository.buscarPorIds(ids);
        return produtoEntity.stream().map(entity -> produtoFactory.create(
                entity.getId(),
                entity.getPreco()
        )).toList();
    }
}
