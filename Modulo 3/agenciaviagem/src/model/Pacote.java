package model;

import java.util.Date;

public class Pacote {
	private int id, tempoEstadia;
	private float valor;
	private Date data;
	private String destino;

	public Pacote() {
	}

	public Pacote(int tempoEstadia, float valor, Date data, String destino) {
		this.tempoEstadia = tempoEstadia;
		this.valor = valor;
		this.data = data;
		this.destino = destino;
	}

	public Pacote(int id, int tempoEstadia, float valor, Date data, String destino) {
		this.id = id;
		this.tempoEstadia = tempoEstadia;
		this.valor = valor;
		this.data = data;
		this.destino = destino;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTempoEstadia() {
		return tempoEstadia;
	}

	public void setTempoEstadia(int tempoEstadia) {
		this.tempoEstadia = tempoEstadia;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public void show() {
		System.out.println("==================");
		System.out.println("ID: " + this.id);
		System.out.println("DESTINO: " + this.destino);
		System.out.println("DATA: " + this.data);
		System.out.println("TEMPO DE ESTADIA: " + this.tempoEstadia);
		System.out.println("VALOR: " + this.valor);
		System.out.println("==================");

	}
}
