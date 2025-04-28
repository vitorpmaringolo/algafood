package com.algaworks.algafood.api.v1.openapi.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.MediaType;

import com.algaworks.algafood.api.exceptionhandler.Problem;
import com.algaworks.algafood.api.v1.model.PedidoModel;
import com.algaworks.algafood.api.v1.model.PedidoResumoModel;
import com.algaworks.algafood.api.v1.model.input.PedidoInput;
import com.algaworks.algafood.domain.filter.PedidoFilter;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Api(tags = "Pedidos")
public interface PedidoControllerOpenApi {

	@ApiImplicitParams({
		@ApiImplicitParam(value = "Nomes das propriedades para filtrar na resposta, separados por vírgula",
				name = "campos", paramType = "query", type = "string")
		
	})
	@ApiOperation("Pesquisa os pedidos")
	PagedModel<PedidoResumoModel> pesquisar(PedidoFilter filtro, Pageable pageable);
	
	@ApiOperation("Registra um pedido")
	@ApiResponses({
		@ApiResponse(responseCode = "201", description = "Pedido registrado")
	})
	PedidoModel adicionar(
			@ApiParam(name = "corpo", value = "Representação de um novo pedido", required = true)
			PedidoInput pedidoInput);
	
	@ApiImplicitParams({
		@ApiImplicitParam(value = "Nomes das propriedades para filtrar na resposta, separados por vírgula",
				name = "campos", paramType = "query", type = "string")
		
	})
	@ApiOperation("Busca um pedido por código")
	@ApiResponses({
		@ApiResponse(responseCode = "404", description = "Pedido não encontrado",
				content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
				schema = @Schema(implementation = Problem.class)))
	})
	PedidoModel buscar(
			@ApiParam(value = "Código de um pedido", example = "5f170d9f-02bf-4b86-80dd-5498f193e4d1", required = true)
			String codigoPedido);
}
