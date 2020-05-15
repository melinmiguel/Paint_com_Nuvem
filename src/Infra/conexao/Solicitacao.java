package Infra.conexao;

import java.io.Serializable;

public class Solicitacao implements Serializable {

	private static final long serialVersionUID = -2412254057380960066L;
	private String comando, com1, com2, com3, com4, com5;

	public Solicitacao(String comando) {
		this.comando = comando;
		this.com1 = null;
		this.com2 = null;
		this.com3 = null;
	}

	public Solicitacao(String comando, String com1) {
		this.comando = comando;
		this.com1 = com1;
		this.com2 = null;
		this.com3 = null;
	}

	public Solicitacao(String comando, String com1, String com2) {
		this.comando = comando;
		this.com1 = com1;
		this.com2 = com2;
		this.com3 = null;
	}

	public Solicitacao(String comando, String com1, String com2, String com3) {
		this.comando = comando;
		this.com1 = com1;
		this.com2 = com2;
		this.com3 = com3;
	}

	public Solicitacao(String comando, String com1, String com2, String com3, String com4) {
		this.comando = comando;
		this.com1 = com1;
		this.com2 = com2;
		this.com3 = com3;
		this.com4 = com4;
	}

	public Solicitacao(String comando, String com1, String com2, String com3, String com4, String com5) {
		this.comando = comando;
		this.com1 = com1;
		this.com2 = com2;
		this.com3 = com3;
		this.com4 = com4;
		this.com5 = com5;
	}

	public String getComando() {
		return this.comando;
	}

	public String getCom1() {
		return this.com1;
	}

	public String getCom2() {
		return this.com2;
	}

	public String getCom3() {
		return this.com3;
	}

	public String getCom4() {
		return this.com3;
	}

	public String getCom5() {
		return this.com3;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (this.getClass() != obj.getClass())
			return false;

		Solicitacao sol = (Solicitacao) obj;

		if (this.comando != sol.comando)
			return false;
		if (this.com1 != sol.com1)
			return false;
		if (this.com2 != sol.com2)
			return false;
		if (this.com3 != sol.com3)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int ret = 5;

		ret = 7 * ret + this.comando.hashCode();
		if (com1 != null)
			ret = 7 * ret + this.com1.hashCode();
		if (com2 != null)
			ret = 7 * ret + this.com2.hashCode();
		if (com3 != null)
			ret = 7 * ret + this.com3.hashCode();
		return ret;
	}

	@Override
	public String toString() {
		String ret = null;
		ret = this.comando;
		if (this.com1 != null)
			ret += "," + this.com1;
		if (this.com2 != null)
			ret += "," + this.com2;
		if (this.com3 != null)
			ret += "," + this.com3;

		return ret;
	}
}