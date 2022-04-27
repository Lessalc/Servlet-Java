package gerenciador.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {
	
	private static List<Empresa> empresas = new ArrayList<Empresa>();
	private static List<Usuario> listaUsuarios = new ArrayList<>();
	private static Integer chaveSequencial = 1;
	
	
	static {
		Empresa empresa = new Empresa();
		empresa.setId(chaveSequencial++);
		empresa.setNome("Alura");
		empresa.setCnpj("05.555.382/0001-33");
		empresas.add(empresa);
		empresa = new Empresa();
		empresa.setId(chaveSequencial++);
		empresa.setNome("Caelum");
		empresa.setCnpj("37.335.177/0001-59");
		empresas.add(empresa);
		
		Usuario user = new Usuario();
		user.setLogin("nico");
		user.setSenha("12345");
		listaUsuarios.add(user);
		user = new Usuario();
		user.setLogin("ana");
		user.setSenha("12345");
		listaUsuarios.add(user);
		
	}
	
	
	public void adiciona(Empresa empresa) {
		// TODO Auto-generated method stub
		empresa.setId(Banco.chaveSequencial++);
		this.empresas.add(empresa);
	}
	
	
	public List<Empresa> getEmpresas(){
		return Banco.empresas;
	}


	public void removeEmpresa(Integer id) {
		Iterator<Empresa> iterator = empresas.iterator();
		
		while(iterator.hasNext()) {
			Empresa empresa = iterator.next();
			if(empresa.getId() == id)
				iterator.remove();
		}
	}


	public Empresa buscaEmpresaPelaId(Integer id) {
		for (Empresa empresa : empresas) {
			if(empresa.getId() == id)
				return empresa;
		}
		return null;
	}


	public Usuario existeUsuario(String login, String senha) {
		for(Usuario user: listaUsuarios) {
			if(user.ehIgual(login, senha))
				return user;
		}
		
		return null;
	}

}
