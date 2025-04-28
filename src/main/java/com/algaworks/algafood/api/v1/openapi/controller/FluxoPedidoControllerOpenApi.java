package com.algaworks.algafood.api.v1.openapi.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.algaworks.algafood.api.exceptionhandler.Problem;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Api(tags = "Pedidos")
public interface FluxoPedidoControllerOpenApi {

	@ApiOperation("Confirmação de pedido")
	@ApiResponses({
		@ApiResponse(responseCode = "204", description = "Pedido confirmado com sucesso"),
		@ApiResponse(responseCode = "404", description = "Pedido não encontrado",
				content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
				schema = @Schema(implementation = Problem.class)))
	})
	ResponseEntity<Void> confirmar(
			@ApiParam(value = "Código do pedido", example = "5f170d9f-02bf-4b86-80dd-5498f193e4d1", required = true)
			String codigoPedido);
	
	@ApiOperation("Cancelamento de pedido")
	@ApiResponses({
		@ApiResponse(responseCode = "204", description = "Pedido cancelado com sucesso"),
		@ApiResponse(responseCode = "404", description = "Pedido não encontrado",
				content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
				schema = @Schema(implementation = Problem.class)))
	})
	ResponseEntity<Void> cancelar(
			@ApiParam(value = "Código do pedido", example = "5f170d9f-02bf-4b86-80dd-5498f193e4d1", required = true)
			String codigoPedido);
	
	@ApiOperation("Registrar entrega de pedido")
	@ApiResponses({
		@ApiResponse(responseCode = "204", description = "Entrega de pedido registrada com sucesso"),
		@ApiResponse(responseCode = "404", description = "Pedido não encontrado",
				content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
				schema = @Schema(implementation = Problem.class)))
	})
	ResponseEntity<Void> entregar(
			@ApiParam(value = "Código do pedido", example = "5f170d9f-02bf-4b86-80dd-5498f193e4d1", required = true)
			String codigoPedido);
}
