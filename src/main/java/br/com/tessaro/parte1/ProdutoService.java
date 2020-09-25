package br.com.tessaro.parte1;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	//POST
	public void salvarProduto (Produto produto) {
		produtoRepository.save(produto);
	}
		
	//GET
	public List<Produto> listarAparelho(){
		return produtoRepository.findAll();
	}
		
	//GET ESP
	public Optional<Produto> getProdutoId (int id){
		return produtoRepository.findById(id);
	}
	
	//PUT
	public void put (Produto produto, int id) {
		produtoRepository.deleteById(id);
		produtoRepository.save(produto);
	}
	
	//Delete
	public void delete () {
		produtoRepository.deleteAll();
	}
	
	//DeleteID
	public void deleteId(int id) {
		produtoRepository.deleteById(id);
	}
	
}


