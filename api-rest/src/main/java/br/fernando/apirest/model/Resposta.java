/**
 * Classe responsável por conter os atributos do objeto resposta
 *
 * @author Fernando Nascimento <fernando_dev@outlook.com.br>
 * @since 21:20:47
 * @versio 1.0
 */
package br.fernando.apirest.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Fernando Nascimento <fernando_dev@outlook.com.br>
 * @since 21:20:47
 */

@XmlRootElement
public class Resposta {

	private Integer idResposta;
	private String respostaCol;

	public Resposta() {

	}

	/**
	 * @param idResposta
	 * @param respostaCol
	 */
	public Resposta(Integer idResposta, String respostaCol) {
		this.idResposta = idResposta;
		this.respostaCol = respostaCol;
	}

	/**
	 * @return the idResposta
	 */
	public Integer getIdResposta() {
		return idResposta;
	}

	/**
	 * @param idResposta the idResposta to set
	 */
	public void setIdResposta(Integer idResposta) {
		this.idResposta = idResposta;
	}

	/**
	 * @return the respostaCol
	 */
	public String getRespostaCol() {
		return respostaCol;
	}

	/**
	 * @param respostaCol the respostaCol to set
	 */
	public void setRespostaCol(String respostaCol) {
		this.respostaCol = respostaCol;
	}

}
