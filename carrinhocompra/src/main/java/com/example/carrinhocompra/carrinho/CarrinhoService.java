package com.example.carrinhocompra.carrinho;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;



@Service
public class CarrinhoService {


	@Autowired
	private CarrinhoRepository carrinhoRepository;


	public Carrinho createUpdateCarrinho(Carrinho carrinho) throws Exception {
		try {

			if(carrinho.getItem() == null || carrinho.getItem().getValor() <= 0)
				throw new Exception("Não deve existir ítem no carrinho com valor <= 0");


			Optional<Carrinho> found = carrinhoRepository.findByUsuarioAndItem(carrinho.getUsuario(), carrinho.getItem());
			if (found.isPresent()) {
//				Carrinho carrinhoUpdate = found.get();
//				return carrinhoRepository.save(carrinhoUpdate);
				carrinho.setId(found.get().getId());
			} 

//			Optional<Carrinho> found2 = carrinhoRepository.findByUsuario(carrinho.getUsuario());
//			if (found2.isPresent()) {
////				Carrinho carrinhoUpdate2 = found2.get();
////				return carrinhoRepository.save(carrinhoUpdate2);
//				carrinho = found.get();
//
//			}	

			return carrinhoRepository.save(carrinho);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public List<Carrinho> getAllCarrinhos() throws Exception {
		try {
			return carrinhoRepository.findAll();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<Carrinho> getAllCarrinhosUsuario() throws Exception {
		try {
			
			return carrinhoRepository.findAll();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public void deleteCarrinho(String id) throws Exception {
		try {
			carrinhoRepository.deleteById(id);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public Carrinho getCarrinhoPorId(String id) throws Exception {
		try {
			Optional<Carrinho> t = carrinhoRepository.findById(id);
			if (t.isPresent()) {
				return t.get();
			}
			else 
				throw new Exception("não encontrado");
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
