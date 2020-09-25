package br.com.tessaro.parte1;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {
		
	@Autowired
	private ProdutoService service;
	
	@GetMapping
	public ResponseEntity<List<Produto>> buscar() {
		return new ResponseEntity<List<Produto>>(service.listarAparelho(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Produto>> buscarId(@PathVariable int id){
		return new ResponseEntity<Optional<Produto>>(service.getProdutoId(id), HttpStatus.OK);
		
	}

	@PostMapping
	public ResponseEntity<Produto> addList (@RequestBody Produto produto) {
		service.salvarProduto(produto);
		return new ResponseEntity<Produto>(HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Produto> put (@RequestBody Produto produto, @PathVariable int id){
		service.put(produto, id);
		return new ResponseEntity<Produto>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Produto> delete (){
		service.delete();
		return new ResponseEntity<Produto>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Produto> deleteId (@PathVariable int id){
		service.deleteId(id);
		return new ResponseEntity<Produto>(HttpStatus.OK);
	}
	
}
