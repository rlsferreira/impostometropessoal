package br.com.art4dev.iples.impostometropessoal.utils;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateUtils extends org.apache.commons.lang3.time.DateUtils {
	
	public static long segundosEntreDatas(Calendar dataInicial, Calendar dataFinal) {
		return (dataFinal.getTime().getTime() - dataInicial.getTime().getTime()) / DateUtils.MILLIS_PER_SECOND;
	}
	
	public static long segundosPassadosNoAnoAtual() {
		Calendar dataInicial = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR),0,1,0,0);
		return segundosEntreDatas(dataInicial,Calendar.getInstance());
	}
	
}
