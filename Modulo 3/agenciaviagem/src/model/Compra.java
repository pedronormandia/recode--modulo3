package model;

public class Compra {
	private int id;
	private Cliente cliente;
	private Pacote pacote;
	private String formaPagamento;

	public Compra() {
	}

	public Compra(Cliente cliente, Pacote pacote, String formaPagamento) {
		this.cliente = cliente;
		this.pacote = pacote;
		this.formaPagamento = formaPagamento;
	}

	public Compra(int id, Cliente cliente, Pacote pacote, String formaPagamento) {
		this.id = id;
		this.cliente = cliente;
		this.pacote = pacote;
		this.formaPagamento = formaPagamento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Pacote getPacote() {
		return pacote;
	}

	public void setPacote(Pacote pacote) {
		this.pacote = pacote;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	
	public void show() {
		System.out.println("==================");
		System.out.println("ID: " + this.id);
		System.out.println("CLIENTE: " + this.cliente.getNome());
		System.out.println("PACOTE: " + this.pacote.getId());
		System.out.println("FORMA DE PAGAMENTO: " + this.formaPagamento);
		System.out.println("==================");

	}

}
