package gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gerenciador.model.Banco;
import gerenciador.model.Usuario;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("Login chamado!");
		
		String parameterLogin = request.getParameter("login");
		String parameterSenha = request.getParameter("senha");
		
		Banco banco = new Banco();
		
		Usuario usuario = banco.existeUsuario(parameterLogin, parameterSenha);
		
		if(usuario!=null) {
			System.out.println("Funcionario Existe!");
			HttpSession sessao = request.getSession();
			sessao.setAttribute("usuarioLogado", usuario);
			return "redirect:entrada?acao=ListaEmpresas";
		} else {
			return "redirect:entrada?acao=LoginForm"; 
		}
	
		
	}

}
