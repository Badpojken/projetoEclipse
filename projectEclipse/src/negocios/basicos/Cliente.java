package negocios.basicos;

public class Cliente extends Pessoa {

	private int pontos = 0;
	private String endereco;

	public Cliente(String nome, String cpf, String endereco, int pontos) {

		super(nome, cpf);
		setEndereco(endereco);
		setPontos(pontos);

	}

	public int getPontos() {

		return pontos;

	}

	public void setPontos(int pontos) {

		if (pontos > -1) {

			this.pontos = pontos;

		}

	}

	public String getEndereco() {

		return endereco;

	}

	public void setEndereco(String endereco) {

		if (endereco != null) {

			this.endereco = endereco;

		}

	}

	// FALTANDO ESSE M�TODO.
	public void addPontos() {
		this.pontos ++;

	}

	@Override
	public boolean equals(Object obj) {

		boolean resultado = false;

		if (obj instanceof Cliente) {

			Cliente c = (Cliente) obj;

			if (super.equals(c) && this.endereco.equalsIgnoreCase(c.endereco) && this.pontos == c.pontos) {

				resultado = true;

			}

		}

		return resultado;

	}

	@Override
	public String toString() {

		return super.toString() + " | Endere�o: " + endereco + " | Pontos acumulados: " + pontos;

	}

}