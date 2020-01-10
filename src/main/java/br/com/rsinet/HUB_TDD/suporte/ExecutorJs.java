package br.com.rsinet.HUB_TDD.suporte;

import org.openqa.selenium.JavascriptExecutor;

public class ExecutorJs {
	private JavascriptExecutor js;

	public void rolar(int qtd) {
		js.executeScript("javascript:window.scrollBy(0," + qtd + ")");
	}
}
