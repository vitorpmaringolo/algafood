package com.algaworks.algafood.api.v1.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Relation(collectionRelation = "pedidos")
@Setter
@Getter
public class PedidoModel extends RepresentationModel<PedidoModel> {

	@ApiModelProperty(example = "5f170d9f-02bf-4b86-80dd-5498f193e4d1")
	private String codigo;
	
	@ApiModelProperty(example = "298.90")
	private BigDecimal subtotal;
	
	@ApiModelProperty(example = "10.00")
	private BigDecimal taxaFrete;
	
	@ApiModelProperty(example = "308.90")
	private BigDecimal valorTotal;
	
	@ApiModelProperty(example = "CRIADO")
	private String status;
	
	@ApiModelProperty(example = "2023-09-20T14:24:39Z")
	private OffsetDateTime dataCriacao;
	
	@ApiModelProperty(example = "2023-09-20T14:34:45Z")
	private OffsetDateTime dataConfirmacao;
	
	@ApiModelProperty(example = "2023-09-20T14:56:22Z")
	private OffsetDateTime dataEntrega;
	
	@ApiModelProperty(example = "2023-09-20T14:34:30Z")
	private OffsetDateTime dataCancelamento;
	
	
	private RestauranteApenasNomeModel restaurante;
	private UsuarioModel cliente;
	private FormaPagamentoModel formaPagamento;
	private EnderecoModel enderecoEntrega;
	private List<ItemPedidoModel> itens;
}
