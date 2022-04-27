package gerenciador.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Empresa {

	private Integer id;
	private String nome;
	private Date dataAbertura = new Date();
	private String cnpj;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataAbertura() {
		return dataAbertura;
	}
	
	public void setDataAbertura(Date dataAbertura){
		this.dataAbertura = dataAbertura;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	@Override
	public String toString() {
		return "Empresa [nome=" + nome + ", cnpj=" + cnpj + "]";
	}
	
	
	
	
}
