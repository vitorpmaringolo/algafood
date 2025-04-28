package com.algaworks.algafood.api.v1.model;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Relation(collectionRelation = "fotos")
@Setter
@Getter
public class FotoProdutoModel extends RepresentationModel<FotoProdutoModel> {

	@ApiModelProperty(example = "6301598a-6e1b-4c8b-88ba-beb8b49594f5_Prime-Rib.jpg")
	private String nomeArquivo;
	
	@ApiModelProperty(example = "Prime Rib ao ponto")
	private String descricao;
	
	@ApiModelProperty(example = "image/jpeg")
	private String contentType;
	
	@ApiModelProperty(example = "432550")
	private Long tamanho;
}
