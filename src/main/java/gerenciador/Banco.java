package gerenciador;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	
	private static List<Empresa> empresas = new ArrayList<Empresa>();
	
	
	
	static {
		Empresa empresa = new Empresa();
		empresa.setNome("Alura");
		empresa.setCnpj("13.458.941/0001-84");
		empresas.add(empresa);
		empresa = new Empresa();
		empresa.setNome("Caelum");
		empresa.setCnpj("11.658.167/0001-35");
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
