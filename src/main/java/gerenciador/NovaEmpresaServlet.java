package gerenciador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NovaEmpresaServlet
 */
@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Cadastrando nova empresa");
		String nomeEmpresa = request.getParameter("nome");
		String cnpjEmpresa = request.getParameter("cnpj");
		
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		empresa.setCnpj(cnpjEmpresa);
		
		Banco banco = new Banco();
		banco.adiciona(empresa);
		
  		PrintWriter out = response.getWriter();
  		out.println("<html><body><h3>Empresa " + nomeEmpresa +" Cadastrada!</h3>"
  				+ "<p>CNPJ: "+cnpjEmpresa+"</p></body></html>");
	}

}
