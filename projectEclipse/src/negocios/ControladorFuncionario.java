package negocios;

import dados.RepositorioFuncionarios;
import negocios.basicos.Funcionario;

public class ControladorFuncionario {

	private RepositorioFuncionarios repositorioFuncionario;
	private int tamanho;

	public ControladorFuncionario() {
		this.repositorioFuncionario = new RepositorioFuncionarios();
	}

	public void cadastrar(Funcionario f) {
		if (f != null) {
			if (!this.repositorioFuncionario.existe(f)) {
				this.repositorioFuncionario.cadastrarFuncionario(f);
				System.out.println("Portanto, criado com sucesso!");
				tamanho = tamanho + 1;
			} else {
				System.out.println("Portanto, n?o foi criado!");

			}
		}
	}

	public void descadastrar(Funcionario f) {
		this.repositorioFuncionario.procurarIndice(f);
		if (f != null) {
			this.repositorioFuncionario.remover(f);
			tamanho = tamanho - 1;
			;
		} else {

		}

	}

	public Funcionario procurar(Funcionario f) {
		return this.repositorioFuncionario.procurarFuncionario(f);
	}
	public Funcionario procurarSenha(Funcionario f) {
		return this.repositorioFuncionario.procurarLoginSenha(f);
	}

	public boolean existe(Funcionario f) {
		return this.repositorioFuncionario.existe(f);
	}
	
	public boolean existeLoginSenha(Funcionario f) {
		return this.repositorioFuncionario.existeLoginSenha(f);
	}

	public void remover(Funcionario f) {
		this.repositorioFuncionario.remover(f);
	}
	

	public RepositorioFuncionarios getRepositorioFuncionario() {
		return repositorioFuncionario;
	}

	public void setRepositorioFuncionario(RepositorioFuncionarios repositorioFuncionario) {
		this.repositorioFuncionario = repositorioFuncionario;
	}
	

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	@Override
	public String toString() {
		return repositorioFuncionario.toString();
	}

}
