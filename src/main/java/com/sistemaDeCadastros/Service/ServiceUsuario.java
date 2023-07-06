package com.sistemaDeCadastros.Service;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemaDeCadastros.Exception.CriptoExist;
import com.sistemaDeCadastros.Exception.EmailExists;
import com.sistemaDeCadastros.Model.Usuario;
import com.sistemaDeCadastros.Repository.UsuarioRepository;
import com.sistemaDeCadastros.Util.Util;

@Service
public class ServiceUsuario {

    @Autowired
	private UsuarioRepository usuarioRepository;

	public void salvarUsuario(Usuario user) throws Exception  {
		
		try {
			
			if(usuarioRepository.findByEmail(user.getEmail()) != null) {
				throw new EmailExists("Já existe um email cadastrado para: " + user.getEmail());
			}
			
			user.setSenha(Util.md5(user.getSenha()));
			
		} catch (NoSuchAlgorithmException e) {
			
			throw new CriptoExist("Erro na criptografia da senha");
			
		}
		
		usuarioRepository.save(user);
		
	}
	
		public Usuario loginUser(String user, String senha) throws ServiceExc {
			
			Usuario userLogin = usuarioRepository.buscarLogin(user, senha);
			return userLogin;
			
			
		}
	
		
}
