package gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gerenciador.model.Banco;
import gerenciador.model.Empresa;

public class AlteraEmpresa  implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String nome = request.getParameter("nome");
		String cnpj = request.getParameter("cnpj");
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		
		System.out.println("acao alterando empresa "+ id);
		
		String dataString = request.getParameter("data");
		Date data;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			data = sdf.parse(dataString);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		
		Banco banco = new Banco();
		Empresa empresaAlterada = banco.buscaEmpresaPelaId(id);
		empresaAlterada.setNome(nome);
		empresaAlterada.setCnpj(cnpj);
		empresaAlterada.setDataAbertura(data);
		
		
		
		return "redirect:entrada?acao=ListaEmpresas";
	}
}
