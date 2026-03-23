package unicesumar.gerenciamento_de_fornecedores.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import unicesumar.gerenciamento_de_fornecedores.Models.FornecedorModel;

public interface FornecedorRepository extends JpaRepository<FornecedorModel, Long> {
}
