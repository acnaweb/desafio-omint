package br.com.omni.test.api.resource;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Consts;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.junit.jupiter.api.Test;

class DepartamentoResourceTest {

	@Test
	void whenDepartamentoExisteComStatus200() throws ClientProtocolException, IOException {

		// given
		int codigo = 1;
		HttpUriRequest request = new HttpGet("http://localhost:2020/departments?code=" + codigo);

		// when
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

		// Then
		assertTrue(httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK);

	}

	@Test
	void whenCodigoInvalidoComStatus400() throws ClientProtocolException, IOException {

		// given
		HttpUriRequest request = new HttpGet("http://localhost:2020/departments?code=x");

		// when
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

		// Then
		assertTrue(httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_BAD_REQUEST);

	}

	@Test
	void whenFalhaAoExluirDepartamentoComStatus404() throws ClientProtocolException, IOException {

		// given
		int codigo = 40;
		HttpUriRequest request = new HttpDelete("http://localhost:2020/departments?code=" + codigo);

		// when
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

		// Then
		assertTrue(httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_NOT_FOUND);

	}

	@Test
	void whenSucessoAoExluirDepartamentoComStatus200() throws ClientProtocolException, IOException {

		// given
		int codigo = 2;
		HttpUriRequest request = new HttpDelete("http://localhost:2020/departments?code=" + codigo);

		// when
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

		// Then
		assertTrue(httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK);

	}

	@Test
	void whenSucessoAoAdicionarDepartamentoComStatus201() throws ClientProtocolException, IOException {
		HttpClient httpClient = HttpClientBuilder.create().build();

		// given
		HttpPost httpPost = new HttpPost("http://localhost:2020/departments");

		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("nome", "Depto Http"));
		formparams.add(new BasicNameValuePair("estado", "SP"));
		formparams.add(new BasicNameValuePair("local", "Local novo"));
		formparams.add(new BasicNameValuePair("cidade", "Piracicaba"));
		formparams.add(new BasicNameValuePair("diretoria", "RECUPERACAO"));

		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);

		httpPost.addHeader("content-type", "application/x-www-form-urlencoded");
		httpPost.setEntity(entity);

		// when
		HttpResponse httpResponse = httpClient.execute(httpPost);

		// Then
		assertTrue(httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_CREATED);

	}

	@Test
	void whenSucessoAoAlterarDepartamentoComStatus201() throws ClientProtocolException, IOException {

		HttpClient httpClient = HttpClientBuilder.create().build();

		// given
		HttpPut httpPut = new HttpPut("http://localhost:2020/departments");

		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("codigo", "1"));
		formparams.add(new BasicNameValuePair("nome", "Depto Alterado"));
		formparams.add(new BasicNameValuePair("estado", "SP"));
		formparams.add(new BasicNameValuePair("local", "Local novo"));
		formparams.add(new BasicNameValuePair("cidade", "Piracicaba"));
		formparams.add(new BasicNameValuePair("diretoria", "RECUPERACAO"));

		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);

		httpPut.addHeader("content-type", "application/x-www-form-urlencoded");
		httpPut.setEntity(entity);

		// when
		HttpResponse httpResponse = httpClient.execute(httpPut);

		// Then
		assertTrue(httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_CREATED);

	}

}
