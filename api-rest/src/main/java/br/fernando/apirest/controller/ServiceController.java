/**
 * Classe responsável por expor os métodos para serem acessados
 * via http
 * 
 * @path - caminho para chamada da classe que vai 
 * representar o nosso serviço
 * @author Fernando Nascimento <fernando_dev@outlook.com.br>
 * @since 21:28:04
 * @versio 1.0
 */
package br.fernando.apirest.controller;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

import br.fernando.apirest.model.Resposta;
import br.fernando.apirest.repositorio.RespostaRepository;
import br.fernando.apirest.repository.entity.RespostaEntity;

/**
 * @author Fernando Nascimento <fernando_dev@outlook.com.br>
 * @since 21:28:04
 */

@Path("/service")
public class ServiceController {

	private final RespostaRepository repository = new RespostaRepository();

	/**
	 * Método responsável por cadastrar uma nova resposta
	 * 
	 * @consumes - determina o formato dos dados que vamos postar
	 * @produces - determina o formato dos dados que vamos retornar
	 *
	 * @author Fernando Nascimento <fernando_dev@outlook.com.br>
	 * @since 1 de mar de 2020
	 * @versio 1.0
	 */

	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/cadastrar")
	public String Cadastrar(Resposta resposta) {

		RespostaEntity entity = new RespostaEntity();

		try {
			entity.setRespostaCol(resposta.getRespostaCol());
			repository.Salvar(entity);
			return "registro cadastrado com sucesso!";
		} catch (Exception e) {
			// TODO: handle exception
			return "Erro ao cadastrar uma resposta " + e.getMessage();
		}

	}

	/**
	 * Método responsável por alterar uma resposta já cadastrada
	 * 
	 * @author Fernando Nascimento <fernando_dev@outlook.com.br>
	 * @since 1 de mar de 2020
	 * @versio 1.0
	 */

	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/alterar/{codigo}")
	public String Alterar(@PathParam("codigo") Integer codigo, Resposta resposta) {
		RespostaEntity entity = new RespostaEntity();
		try {

			entity = repository.getResposta(codigo);

			entity.setRespostaCol(resposta.getRespostaCol());
			repository.Alterar(entity);
			return "Registro alterado com sucesso!";
		} catch (Exception e) {
			// TODO: handle exception
			return "Erro ao alterar o registro " + e.getMessage();
		}
	}

	/**
	 * Método responsável por listar todas as respostas já cadastradas
	 * 
	 * @author Fernando Nascimento <fernando_dev@outlook.com.br>
	 * @since 1 de mar de 2020
	 * @versio 1.0
	 */

	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/todasRespostas")
	public List<Resposta> TodasRespostas() {

		List<Resposta> respostas = new ArrayList<Resposta>();
		List<RespostaEntity> listaEntityRespostas = repository.TodasRespostas();
		for (RespostaEntity entity : listaEntityRespostas) {
			respostas.add(new Resposta(entity.getIdResposta(), entity.getRespostaCol()));
		}
		return respostas;
	}

	/**
	 * Método responsável por buscar uma resposta cadastrada pelo id
	 * 
	 * @author Fernando Nascimento <fernando_dev@outlook.com.br>
	 * @since 1 de mar de 2020
	 * @versio 1.0
	 */

	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/getResposta/{codigo}")
	public Resposta getResposta(@PathParam("codigo") Integer codigo) {

		RespostaEntity entity = repository.getResposta(codigo);

		if (entity != null)
			return new Resposta(entity.getIdResposta(), entity.getRespostaCol());
		return null;
	}

	/**
	 * Método responsável por excluir uma resposta cadastrada pelo id
	 * 
	 * @author Fernando Nascimento <fernando_dev@outlook.com.br>
	 * @since 1 de mar de 2020
	 * @versio 1.0
	 */
	@DELETE
	@Produces("application/json; charset=UTF-8")
	@Path("/excluir/{codigo}")
	public String Excluir(@PathParam("codigo") Integer codigo) {
		try {
			repository.Excluir(codigo);
			return "Registro excluído com sucesso!";
		} catch (Exception e) {
			// TODO: handle exception
			throw new WebApplicationException(Status.NOT_FOUND);
			// return "Erro ao excluir o registro! " + e.getMessage();
		}
	}

}
