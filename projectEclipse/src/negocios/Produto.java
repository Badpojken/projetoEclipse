package negocios;

public class Produto {

	private String nome;
	private String descricao;
	private int quantidade;
	private double preco;
	private boolean estoque;
	private double precoFinal;

	public Produto(String nome, String descricao, int quantidade, double preco, boolean estoque) {

		setNome(nome);
		setDescricao(descricao);
		setQuantidade(quantidade);
		setPreco(preco);
		this.estoque = estoque;
		setPrecoFinal(preco * quantidade);

	}

	public String getNome() {

		return nome;

	}

	public void setNome(String nome) {

		if (nome != null) {

			this.nome = nome;

		}

	}

	public String getDescricao() {

		return descricao;

	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public void setDescricao(String descricao) {

		if (descricao != null) {

			this.descricao = descricao;

		}

	}

	public int getQuantidade() {

		return quantidade;

	}

	public void setQuantidade(int quantidade) {

		if (quantidade > -1) {

			this.quantidade = quantidade;

		}

	}

	public double getPreco() {

		return preco;

	}

	public void setPrecoFinal(double preco) {

		if (preco > 0) {

			this.precoFinal = preco;

		}

	}

	public double getPrecoFinal() {

		return preco;

	}

	public void setPrecoFinal(double preco) {

		if (preco > 0) {

			this.precoFinal = preco;

		}

	}

	public boolean isEstoque() {

		return estoque;

	}

	public void setEstoque(boolean estoque) {

		this.estoque = estoque;

	}

	@Override
	public boolean equals(Object obj) {

		boolean resultado = false;

		if (obj instanceof Produto) {

			Produto p = (Produto) obj;

			if (this.nome.equalsIgnoreCase(p.nome) && this.descricao.equalsIgnoreCase(p.descricao)
					&& this.quantidade == p.quantidade && this.preco == p.preco && this.estoque == p.estoque) {

				resultado = true;

			}

		}

		return resultado;

	}

	@Override
	public String toString() {

		return "\nNome: " + nome + " | Descri��o: " + descricao + " | Quantidade: " + quantidade + " | Pre�o: R$ "
				+ preco + " | Pre�o Final: R$ " + precoFinal + " | Tem no estoque? " + estoque;

	}

}