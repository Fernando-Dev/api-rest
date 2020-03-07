/**
 * Classe responsável por conter os atributos e tags para 
 * manipulação do objeto resposta no banco de dados
 *
 * @author Fernando Nascimento <fernando_dev@outlook.com.br>
 * @since 20:31:38
 * @versio 1.0
 */
package br.fernando.apirest.repository.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author Fernando Nascimento <fernando_dev@outlook.com.br>
 * @since 20:31:38
 */

@Entity
@Table(name = "resposta")
@NamedQueries({
		@NamedQuery(name = "RespostaEntity.todasRespostas", query = "SELECT r FROM RespostaEntity r ORDER BY r.respostaCol") })
public class RespostaEntity implements Serializable {

	/**
	 * @author Fernando Nascimento <fernando_dev@oputlook.com.br>
	 * @since 23:33:02
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idresposta")
	private Integer idResposta;

	@Column(name = "respostaCol")
	private String respostaCol;

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
