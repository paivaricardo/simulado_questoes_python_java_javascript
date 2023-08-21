package com.ricardopaiva.validadorcpf;

import java.util.ArrayList;
import java.util.List;

public class ValidadorCPF 
{	
	public static boolean validarCPF(String CPF) {
//		Lista para armazenar o números do CPF de uma pessoa
		List<Integer> digitosCPF = new ArrayList<>();
		
//		Array para armazenar os dígitos verificadores do CPF
		int[] digitosVerificadores = new int[2];
				
//		Cálculo do primeiro dígito verificador
		
//		Array para armazenar os pesos do CPF (primeiro dígito)
		int[] pesosCPFPrimeiroDigito = {10, 9, 8, 7, 6, 5, 4, 3, 2};
		
//		Array para armazenar o somatório dos digitos multiplicados pelos pesos do CPF
		int somatorioPesosCPFPrimeiroDigito = 0;
		
//		Converter a String do CPF em um array de inteiros
		for (String c : CPF.split("")) {
			try {
				int digito = Integer.valueOf(c);
				digitosCPF.add(digito);
			} catch (Exception e) {
//				Caracteres estranhos no CPF (diferente de . e -) não serão aceitos.
				if (!c.matches("[\\.-]")) {
					return false;
				}
				
				continue;
			}
		}
		
//		Devolver falso imediatamente, se for encontrado um valor diferente de 11 dígitos
		if (digitosCPF.size() != 11) {
			return false;
		}
		
//		Calcular o resultado de cada dígito multiplicado pelo seu peso (nove primeiros dígitos) e acionar o somatório
		for (int i = 0; i < 9; i++) {
			somatorioPesosCPFPrimeiroDigito += digitosCPF.get(i) * pesosCPFPrimeiroDigito[i];
		}
		
//		Com o somatório, calcular o restante da divisão por 11
		int restoDivisaoPrimeiroDigito = somatorioPesosCPFPrimeiroDigito % 11;
		
//		Se o resultado for menor do que 2, o dígito verificador será zero, do contrário será 11 - resto da divisão
		int primeiroDigitoVerificador = restoDivisaoPrimeiroDigito < 2 ? 0 : 11 - restoDivisaoPrimeiroDigito;
		
//		Adicionar o primeiro dígito verificador na lista de dígitos do CPF
		digitosVerificadores[0] = primeiroDigitoVerificador;
		
//		Cálculo do segundo dígito verificador
		int[] pesosCPFSegundoDigito = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
		
		int somatorioPesosCPFSegundoDigito = 0;
		
		for (int i = 0; i < 10; i++) {
			somatorioPesosCPFSegundoDigito += digitosCPF.get(i) * pesosCPFSegundoDigito[i];
		}
		
		int restoDivisaoSegundoDigito = somatorioPesosCPFSegundoDigito % 11;
		
		int segundoDigitoVerificador = restoDivisaoSegundoDigito < 2 ? 0 : 11 - restoDivisaoSegundoDigito;
		
//		Adicionar o segundo dígito verificador na lista de dígitos do CPF
		digitosVerificadores[1] = segundoDigitoVerificador;
		
//		Verificar se ambos os dígitos verificadores são iguais ao final do CPF. Se forem, retornar true. Se não, retornar falso.
		if (digitosCPF.get(9) == digitosVerificadores[0] && digitosCPF.get(10) == digitosVerificadores[1]) {
			return true;
		} else {
			return false;			
		}
	}
	
    public static void main( String[] args )
    {
    	System.out.println(validarCPF("1"));
    	System.out.println(validarCPF("011.253.124-05"));
    }
}
