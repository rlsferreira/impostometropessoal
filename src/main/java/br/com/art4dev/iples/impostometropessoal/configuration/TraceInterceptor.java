package br.com.art4dev.iples.impostometropessoal.configuration;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.springframework.aop.interceptor.CustomizableTraceInterceptor;

public class TraceInterceptor extends CustomizableTraceInterceptor {

	private static final long serialVersionUID = 287162721460370957L;
	protected static Logger logger4J = Logger.getLogger("aop");

	@Override
	protected void writeToLog(Log logger, String message, Throwable ex) {
		if (ex != null) {
			logger4J.log(Level.FINE, message, ex);
		} else {
			logger4J.log(Level.FINE, message);
		}
	}

	@Override
	protected boolean isInterceptorEnabled(MethodInvocation invocation,
			Log logger) {
		return true;
	}
}