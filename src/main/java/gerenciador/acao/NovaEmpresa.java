package gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gerenciador.model.Banco;
import gerenciador.model.Empresa;

public class NovaEmpresa implements Acao {
	
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("Cadastrando nova empresa");
		
		Empresa empresa = new Empresa();
		empresa.setNome(request.getParameter("nome"));
		empresa.setCnpj(request.getParameter("cnpj"));
		
		String dataString = request.getParameter("data");
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date data = sdf.parse(dataString);
			empresa.setDataAbertura(data);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Banco banco = new Banco();
		banco.adiciona(empresa);
		
		request.setAttribute("empresa", empresa.getNome());
		request.setAttribute("cnpj", empresa.getCnpj());
		request.setAttribute("data", empresa.getDataAbertura());
		
		return "redirect:entrada?acao=ListaEmpresas";
	}
}