package unicesumar.gerenciamento_de_fornecedores.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unicesumar.gerenciamento_de_fornecedores.Models.FornecedorModel;
import unicesumar.gerenciamento_de_fornecedores.Repositories.FornecedorRepository;

import java.util.List;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public FornecedorModel criarFornecedor(FornecedorModel pedidoModel) {
        return fornecedorRepository.save(pedidoModel);
    }

    public List<FornecedorModel> listarFornecedores() {
        return fornecedorRepository.findAll();
    }

    public FornecedorModel listarFornecedorPorId(Long id) {
        return fornecedorRepository.findById(id).get();
    }

    public void deletarFornecedorPorId(Long id) {
        fornecedorRepository.deleteById(id);
    }

}
