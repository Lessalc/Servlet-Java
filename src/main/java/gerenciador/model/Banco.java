package gerenciador;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	
	private static List<Empresa> empresas = new ArrayList<Empresa>();
	
	
	
	static {
		Empresa empresa = new Empresa();
		empresa.setNome("Alura");
		empresa.setCnpj("05.555.382/0001-33");
		empresas.add(empresa);
		empresa = new Empresa();
		empresa.setNome("Caelum");
		empresa.setCnpj("37.335.177/0001-59");
		empresas.add(empresa);
	}
	
	
	public void adiciona(Empresa empresa) {
		// TODO Auto-generated method stub
		this.empresas.add(empresa);
	}
	
	
	public List<Empresa> getEmpresas(){
		return Banco.empresas;
	}

}
