package br.com.formularioPessoa.Controlle;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.formularioPessoa.Controller.DTO.PessoaDTO;
import br.com.formularioPessoa.Controller.Form.PessoaForm;
import br.com.formularioPessoa.modelo.Pessoa;
import br.com.formularioPessoa.repository.UsuarioRepository;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
	
	@Autowired
	private UsuarioRepository usuarioRepository; 
	
	
	@GetMapping
	public List<PessoaDTO> listar(String nome) {
		if (nome == null) {
			List<Pessoa> usuarios = usuarioRepository.findAll(); 
			return PessoaDTO.converter(usuarios); 			
		} else {
			List<Pessoa> usuarios = usuarioRepository.buscarPorPessoa(nome); 
			return PessoaDTO.converter(usuarios); 
		}
	}
	
	@CrossOrigin
	@GetMapping("/{nome}")
	public ResponseEntity<PessoaDTO> buscarUser(@PathVariable String nome) {
		
		Optional<Pessoa> usuario = usuarioRepository.findById(nome); 
		if (usuario.isPresent()) {
			return ResponseEntity.ok( new PessoaDTO(usuario.get())); 
		}
		return ResponseEntity.notFound().build(); 
	}

	@CrossOrigin
	@PostMapping(path = "/inserir/")
	@Transactional
	public ResponseEntity<PessoaDTO> cadastrar(@RequestBody PessoaForm userForm, UriComponentsBuilder uriBuilder) {
		Pessoa pessoa = userForm.converter(); 
		if (pessoa.getNome() == "" || pessoa.getSobrenome() == "" || pessoa.getIdade() == "" || pessoa.getSexo() == null) {
			return ResponseEntity.noContent().build();
		}
		
		usuarioRepository.save(pessoa);
		
		URI uri = uriBuilder.path("/pessoas/{nome}").buildAndExpand(pessoa.getNome()).toUri();
		
		return ResponseEntity.created(uri).body(new PessoaDTO(pessoa)); 	
	}
	
	@CrossOrigin
	@DeleteMapping("/{nome}")
	@Transactional 
	public ResponseEntity<?> remover(@PathVariable String nome){
		usuarioRepository.deleteById(nome);
		return ResponseEntity.ok().build();
	
	} 
}