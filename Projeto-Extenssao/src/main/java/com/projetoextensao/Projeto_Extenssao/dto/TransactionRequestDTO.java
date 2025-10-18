package com.projetoextensao.Projeto_Extenssao.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequestDTO {

    @NotBlank(message = "O título da transação é obrgatório!")
    private String title;

    @NotBlank(message = "O preço da transação é obrigatório!")
    private float price;

    @NotBlank(message = "Selecionar a categoria é obrigatório!")
    private UUID categoryid;

    @NotBlank(message = "Selecionar o cliente é obrigatório!")
    private UUID userid;
}
