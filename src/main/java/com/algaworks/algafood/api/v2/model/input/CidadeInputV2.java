package com.algaworks.algafood.api.v2.model.input;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel("CidadeInput")
@Setter
@Getter
public class CidadeInputV2 {

	@ApiModelProperty(example = "Uberlândia", required = true)
	@NotBlank
	private String nomeCidade;
	
	@ApiModelProperty(example = "1", required = true)
	private Long idEstado;
}
