package poo.ufc;

public class Animal implements Passageiro {
	private long ID;
	private String especie;
	private int peso;
	
	public Animal(long ID, String especie , int peso) {
		this.ID = ID;
		this.especie = especie;
		this.setPeso(peso);
	}
	
	@Override
	public long getID() {
		return this.ID;
	}
	@Override
	public String toString() {
		return "ID = " + this.getID() + " Especie = " + this.especie;
 	}

	public int getPeso() {
		return peso;
	}
	@Override
	public boolean equals(Object obj) {
		return ((Animal)obj).getID() == this.getID();
	}
	
	public void setPeso(int peso) {
		this.peso = peso;
	}

}
