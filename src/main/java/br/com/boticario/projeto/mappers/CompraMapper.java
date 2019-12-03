package br.com.boticario.projeto.mappers;

import java.text.ParseException;

import javax.swing.text.MaskFormatter;

import org.springframework.stereotype.Component;

import br.com.boticario.projeto.dto.CompraDTO;
import br.com.boticario.projeto.entities.Compra;
import br.com.boticario.projeto.util.Util;
@Component
public class CompraMapper {

	CompraDTO dto = new CompraDTO();
	
	public CompraDTO compraEntityParaDTO(Compra compra) throws ParseException {
		dto.setCodigo(compra.getCodigo());
		dto.setData(Util.converterDataParaString(compra.getData()));
		Double teste = compra.getPorcentagemCashback()*100;
		dto.setPorcentagemCashback(teste.intValue() + "%");
		dto.setId(compra.getId());
		dto.setRevendedor(formatCnpj(compra.getRevendedor()));
		dto.setValor(String.format("R$%.2f", compra.getValor()));
		dto.setValorCashback(String.format("R$%.2f", compra.getValorCashback()));
		return dto;
	}
	
	private String formatCnpj(String cpf) throws ParseException {
        MaskFormatter mask = new MaskFormatter("###.###.###-##");
        mask.setValueContainsLiteralCharacters(false);
	        
	    return mask.valueToString(cpf);
	}
	
}
