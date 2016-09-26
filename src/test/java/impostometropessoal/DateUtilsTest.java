package impostometropessoal;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

import br.com.art4dev.iples.impostometropessoal.utils.DateUtils;

public class DateUtilsTest {
	
	
	@Test
	public void testSegundosEntreDatas() {
		
		Calendar dataInicial = Calendar.getInstance();
		try {
			Thread.sleep(2000);
		} catch(Exception e) {}
		Calendar dataFinal = Calendar.getInstance();
		
		long result = DateUtils.segundosEntreDatas(dataInicial,dataFinal);
		System.out.println(result);
		Assert.assertTrue(result == 2);
	}
	
	@Test
	public void testSegundosPassadosNoAnoAtual() {
		long result = DateUtils.segundosPassadosNoAnoAtual();
		System.out.println(result);
		Assert.assertTrue(result > 0) ;
	}
	
}
