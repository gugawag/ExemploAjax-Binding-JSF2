package com.gugawag.primeirojsf.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UF {
	
	//Chave representa a UF, valor as cidades da UF
	private Map<String, List<String>> ufsCidades;

	public UF() {
		ufsCidades = new HashMap<String, List<String>>();
		
		List<String> cidadesPB = new ArrayList<String>();
		cidadesPB.add("Cajazeiras");
		cidadesPB.add("Campina Grande");
		cidadesPB.add("Jo‹ão Pessoa");
		ufsCidades.put("PB", cidadesPB);
		
		List<String> cidadesPE = new ArrayList<String>();
		cidadesPE.add("Garanhuns");
		cidadesPE.add("Olinda");
		cidadesPE.add("Porto de Galinhas");
		cidadesPE.add("Recife");		
		ufsCidades.put("PE", cidadesPE);

		List<String> cidadesRN = new ArrayList<String>();
		cidadesRN.add("Natal");
		cidadesRN.add("Açu");
		cidadesRN.add("Caicó—");
		ufsCidades.put("RN", cidadesRN);
	}

	public Map<String, List<String>> getUfsCidades() {
		return ufsCidades;
	}

	public void setUfsCidades(Map<String, List<String>> ufsCidades) {
		this.ufsCidades = ufsCidades;
	}
	
}
