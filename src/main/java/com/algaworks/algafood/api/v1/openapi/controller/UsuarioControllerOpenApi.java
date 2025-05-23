package com.algaworks.algafood.api.v1.openapi.controller;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.MediaType;

import com.algaworks.algafood.api.exceptionhandler.Problem;
import com.algaworks.algafood.api.v1.model.UsuarioModel;
import com.algaworks.algafood.api.v1.model.input.SenhaInput;
import com.algaworks.algafood.api.v1.model.input.UsuarioComSenhaInput;
import com.algaworks.algafood.api.v1.model.input.UsuarioInput;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Api(tags = "Usuários")
public interface UsuarioControllerOpenApi {
	
	@ApiOperation("Lista os usuários")
	CollectionModel<UsuarioModel> listar();

	@ApiOperation("Busca um usuário por ID")
	@ApiResponses({
		@ApiResponse(responseCode = "400", description = "ID do usuário inválido",
				content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
				schema = @Schema(implementation = Problem.class))),
		@ApiResponse(responseCode = "404", description = "Usuário não encontrado",
				content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
				schema = @Schema(implementation = Problem.class)))
	})
	UsuarioModel buscar(@ApiParam(value = "ID do usuário", example = "1", required = true) Long usuarioId);
	
	@ApiOperation("Cadastra um usuário")
	@ApiResponses({
		@ApiResponse(responseCode = "201", description = "Usuário cadastrado")
	})
	UsuarioModel adicionar(
			@ApiParam(name = "corpo", value = "Representação de um novo usuário", required = true)
			UsuarioComSenhaInput usuarioInput);
	
	@ApiOperation("Atualiza um usuário por ID")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Usuário atualizado"),
		@ApiResponse(responseCode = "404", description = "Usuário não encontrado",
				content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
				schema = @Schema(implementation = Problem.class)))
	})
	UsuarioModel atualizar(
			@ApiParam(value = "ID do usuário", example = "1", required = true)
			Long usuarioId,
			
			@ApiParam(name = "corpo", value = "Representação de um usuário com os novos dados", required = true)
			UsuarioInput usuarioInput);
	
	@ApiOperation("Atualiza a senha de um usuário")
	@ApiResponses({
		@ApiResponse(responseCode = "204", description = "Senha alterada com sucesso"),
		@ApiResponse(responseCode = "404", description = "Usuário não encontrado",
				content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
				schema = @Schema(implementation = Problem.class)))
	})
	void alterarSenha(
			@ApiParam(value = "ID do usuário", example = "1", required = true)
			Long usuarioId,
			
			@ApiParam(name = "corpo", value = "Representação de uma nova senha", required = true)
			SenhaInput senha);
}
