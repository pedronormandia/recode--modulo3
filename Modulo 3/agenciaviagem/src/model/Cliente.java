package model;

public class Cliente {

	private String telefone;
	private String nome;
	private String cpf;
	private int id;

	public Cliente() {

	}

	public Cliente(String telefone, String nome, String cpf) {

		this.telefone = telefone;
		this.nome = nome;
		this.cpf = cpf;
	}

	public Cliente(String telefone, String nome, String cpf, int id) {

		this.telefone = telefone;
		this.nome = nome;
		this.cpf = cpf;
		this.id = id;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void show() {
		System.out.println("==================");
		System.out.println("ID: " + this.id);
		System.out.println("NOME: " + this.nome);
		System.out.println("TELEFONE: " + this.telefone);
		System.out.println("CPF: " + this.cpf);
		System.out.println("==================");

	}

}
