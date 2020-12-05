package com.transation.bank.entity.dto;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

public class TransactionRequest {

	@Min(value = 0, message = "O valor mínimo para a transação é 0")
	@NotNull(message = "O valor não pode ser nulo")
	private Double valor;

	@NotNull(message = "A data não pode ser nula")
	@PastOrPresent(message = "A data é inválida para a transação")
	private Date dataHora;

	public TransactionRequest() {
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

}
