package gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gerenciador.acao.Acao;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String paramAcao = request.getParameter("acao");
		
		HttpSession sessao = request.getSession();
		boolean usuarioNaoEstaLogado = (sessao.getAttribute("usuarioLogado") == null);
		boolean eUmaAcaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));
		
		if(usuarioNaoEstaLogado && eUmaAcaoProtegida) {
			response.sendRedirect("redirect:entrada?acao=LoginForm");
			return;
		} 
		
		
		

		String arquivoJsp = null;
		
		String nomeDaClasse = "gerenciador.acao."+paramAcao;
		
		Class classe;
		
		
		
		try {
			classe = Class.forName(nomeDaClasse);// carregue a classe com o nome da classe
			Acao acao = (Acao) classe.newInstance();
			arquivoJsp = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
				| IOException e) {
			throw new ServletException(e);
		}
		
		if(arquivoJsp.split(":")[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view"+arquivoJsp.split(":")[1]);
			rd.forward(request, response);
		} else if(arquivoJsp.split(":")[0].equals("redirect")) {
			response.sendRedirect(arquivoJsp.split(":")[1]);
		}
		
		/*
		if(paramAcao.equals("ListaEmpresas")) {
			
			ListaEmpresas acao = new ListaEmpresas();
			arquivoJsp = acao.executa(request, response);
		}
		else if(paramAcao.equals("RemoveEmpresa")) {
			
			RemoveEmpresa acao = new RemoveEmpresa();
			arquivoJsp = acao.executa(request, response);
		}
		else if(paramAcao.equals("MostraEmpresa")) {
			
			MostraEmpresa acao = new MostraEmpresa();
			arquivoJsp = acao.executa(request, response);
		}
		else if(paramAcao.equals("AlteraEmpresa")) {
			
			AlteraEmpresa acao = new AlteraEmpresa();
			arquivoJsp = acao.executa(request, response);
		}
		else if(paramAcao.equals("NovaEmpresa")) {
			
			NovaEmpresa acao = new NovaEmpresa();
			arquivoJsp = acao.executa(request, response);
		}
		else if(paramAcao.equals("NovaEmpresaForm")) {
			NovaEmpresaForm acao = new NovaEmpresaForm();
			arquivoJsp = acao.executa(request, response);
		}
		*/	
		
		
	
		
		
	}

}
