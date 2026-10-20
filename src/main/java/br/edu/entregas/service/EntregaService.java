package br.edu.entregas.service;

import java.util.List;

import br.edu.entregas.model.Endereco;
import br.edu.entregas.model.Mercadoria;
import br.edu.entregas.repository.MercadoriaRepository;
import br.edu.entregas.util.Validador;

public class EntregaService {
    private final MercadoriaRepository repository = new MercadoriaRepository();

    public Mercadoria cadastrar(long id, String nome, String descricao, double peso,
                                double valor, String status, Endereco endereco) {
        Validador.textoObrigatorio(nome, "Nome");
        Validador.textoObrigatorio(descricao, "Descrição");
        Validador.numeroPositivo(peso, "Peso");
        Validador.numeroPositivo(valor, "Valor");
        if (endereco == null) throw new IllegalArgumentException("Endereço é obrigatório.");
        Mercadoria mercadoria = new Mercadoria(id, nome, descricao, peso, valor, status, endereco);
        repository.salvar(mercadoria);
        return mercadoria;
    }

    public List<Mercadoria> listar() { return repository.listar(); }
}
