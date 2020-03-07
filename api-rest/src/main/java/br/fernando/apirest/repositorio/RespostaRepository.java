/**
 * Classe responsável pelo CRUD do objeto resposta no banco de dados
 * 
 * @author Fernando Nascimento <fernando_dev@outlook.com.br>
 * @since 20:44:34
 * @versio 1.0
 */
package br.fernando.apirest.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import br.fernando.apirest.repository.entity.RespostaEntity;

/**
 * @author Fernando Nascimento <fernando_dev@outlook.com.br>
 * @since 20:44:34
 */

public class RespostaRepository {

	private final EntityManagerFactory entityManagerFactory;
	private final EntityManager entityManager;

	/**
	 * Construtor responsável por gerenciar a entidade de acordo com a propriedades
	 * do arquivo persistence.xml
	 *
	 * @author Fernando Nascimento <fernando_dev@outlook.com.br>
	 * @since 1 de mar de 2020
	 * @versio 1.0
	 */
	public RespostaRepository() {

		/**
		 * Criando nossa fábrica de gereciamento de entidade de acordo com o arquivo
		 * persistence.xml
		 * 
		 * @author Fernando Nascimento <fernando_dev@outlook.com.br>
		 */
		this.entityManagerFactory = Persistence.createEntityManagerFactory("persistence_unit_enquete");
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}

	/**
	 * Método responsável por criar um novo registro no banco de dados
	 *
	 * @author Fernando Nascimento <fernando_dev@outlook.com.br>
	 * @since 1 de mar de 2020
	 * @versio 1.0
	 */

	public void Salvar(RespostaEntity respostaEntity) {
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(respostaEntity);
		this.entityManager.getTransaction().commit();
	}

	/**
	 * Método responsável por alterar um registro cadastrado
	 *
	 * @author Fernando Nascimento <fernando_dev@outlook.com.br>
	 * @since 1 de mar de 2020
	 * @versio 1.0
	 */

	public void Alterar(RespostaEntity entity) {
		
		this.entityManager.getTransaction().begin();
		this.entityManager.merge(entity);
		this.entityManager.getTransaction().commit();
	}

	/**
	 * Método responsável por retornar todas as respostas registradas no banco
	 *
	 * @author Fernando Nascimento <fernando_dev@outlook.com.br>
	 * @since 1 de mar de 2020
	 * @versio 1.0
	 */
	public List<RespostaEntity> TodasRespostas() {
		return this.entityManager.createNamedQuery("RespostaEntity.todasRespostas", RespostaEntity.class)
				.getResultList();
	}

	/**
	 * Método responsável por buscar resposta cadastrada no banco pelo id
	 *
	 * @author Fernando Nascimento <fernando_dev@outlook.com.br>
	 * @since 1 de mar de 2020
	 * @versio 1.0
	 */
	public RespostaEntity getResposta(Integer codigo) {
		return this.entityManager.find(RespostaEntity.class, codigo);
	}

	/**
	 * Método responsável por excluir uma resposta do banco pelo id
	 *
	 * @author Fernando Nascimento <fernando_dev@outlook.com.br>
	 * @since 1 de mar de 2020
	 * @versio 1.0
	 */
	public void Excluir(Integer codigo) {
		RespostaEntity entity = this.getResposta(codigo);

		this.entityManager.getTransaction().begin();
		this.entityManager.remove(entity);
		this.entityManager.getTransaction().commit();
	}

}
