package unicesumar.gerenciamento_de_fornecedores.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import unicesumar.gerenciamento_de_fornecedores.Models.FornecedorModel;
import unicesumar.gerenciamento_de_fornecedores.Services.FornecedorService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path="/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @PostMapping
    public ResponseEntity<FornecedorModel> criarFornecedor(@RequestBody FornecedorModel fornecedorModel) {
        FornecedorModel request = fornecedorService.criarFornecedor(fornecedorModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/fornecedors/{id}").buildAndExpand(request.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<FornecedorModel>> listarFornecedors() {
        List<FornecedorModel> resquest = fornecedorService.listarFornecedores();
        return ResponseEntity.ok().body(resquest);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<FornecedorModel> listarFornecedorPorId(@PathVariable Long id) {
        FornecedorModel request = fornecedorService.listarFornecedorPorId(id);
        return ResponseEntity.ok().body(request);
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<Void> deletarFornecedorPorId(@PathVariable Long id) {
        fornecedorService.deletarFornecedorPorId(id);
        return ResponseEntity.noContent().build();
    }

}
