package it.prova.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import it.prova.model.Negozio;

public class UtilityNegozioForm {
	
	public static Negozio createNegozioFromParams(String ragioneSocialeInputParam, String partitaIvaInputParam,
			String fatturatoInputStringParam, String dataAperturaStringParam) {

		Negozio result = new Negozio(ragioneSocialeInputParam, partitaIvaInputParam);

		if (NumberUtils.isCreatable(fatturatoInputStringParam)) {
			result.setFatturato(Integer.parseInt(fatturatoInputStringParam));
		}
		result.setDataApertura(parseDateAperturaFromString(dataAperturaStringParam));

		return result;
	}

	public static boolean validateNegozioBean(Negozio negozioToBeValidated) {
		// prima controlliamo che non siano vuoti i parametri
		if (StringUtils.isBlank(negozioToBeValidated.getRagioneSociale())
				|| StringUtils.isBlank(negozioToBeValidated.getPartitaIva())
				|| negozioToBeValidated.getFatturato() == null || negozioToBeValidated.getFatturato() < 1
				|| negozioToBeValidated.getDataApertura() == null) {
			return false;
		}
		return true;
	}

	public static Date parseDateAperturaFromString(String dataAperturaStringParam) {
		if (StringUtils.isBlank(dataAperturaStringParam))
			return null;

		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(dataAperturaStringParam);
		} catch (ParseException e) {
			return null;
		}
	}

}
