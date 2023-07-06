package com.sistemaDeCadastros.Controller;

import java.security.NoSuchAlgorithmException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sistemaDeCadastros.Model.Usuario;
import com.sistemaDeCadastros.Repository.UsuarioRepository;
import com.sistemaDeCadastros.Service.ServiceExc;
import com.sistemaDeCadastros.Service.ServiceUsuario;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import com.sistemaDeCadastros.Util.Util;


@Controller
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

	@Autowired
	private ServiceUsuario serviceUsuario;

    @GetMapping("/")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Login/login");
		mv.addObject("usuario", new Usuario());
        return mv;
    }

    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home/index");
		mv.addObject("usuario", new Usuario());
        return mv;
    }

    @GetMapping("/cadastro")
	public ModelAndView cadastrar() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("usuario", new Usuario());
		mv.setViewName("Login/cadastro");
		return mv;
	}
	
	@PostMapping("/salvarUsuario")
	public ModelAndView cadastrar(Usuario usuario) throws Exception {
		ModelAndView mv = new ModelAndView();
		serviceUsuario.salvarUsuario(usuario);
		mv.setViewName("redirect:/");
		return mv;
	}

     @PostMapping("/login")
	public ModelAndView login(@Valid Usuario usuario, BindingResult br, HttpSession session) throws NoSuchAlgorithmException, ServiceExc {
		ModelAndView mv = new ModelAndView();
		mv.addObject("usuario", new Usuario());
		if(br.hasErrors()) {
			mv.setViewName("Login/login");	
		}
		
		Usuario userLogin = serviceUsuario.loginUser(usuario.getUser(), Util.md5(usuario.getSenha()));
		if(userLogin == null) {
			mv.addObject("msg", "Usuário não encontrado. Tente novamente");
		} else {
			session.setAttribute("usuarioLogado", userLogin);
			return index();
		}
		
		return mv;
	}


//	======= FINALIZAR SESSÃO ========= 
	@PostMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
    
}
