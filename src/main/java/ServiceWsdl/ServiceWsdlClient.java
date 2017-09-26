package ServiceWsdl;

import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.handler.MessageContext;

public class ServiceWsdlClient {
	private static final String WS_URL =
			"http://localhost:9000/ws/insert?wsdl";

	public static void main(String[] args) throws Exception {
		URL url = new URL(WS_URL);
		QName qname = new QName(
				"http://ws.itwv.com/",
				"ServiceWsdlImpl");

		Service service = Service.create(url, qname);
		ServiceWsdl insert = service.getPort(ServiceWsdl.class);

		// The BindingProvider interface provides
		//access to the protocol binding and
		// to the associated context objects
		//for request and response message processing.
		BindingProvider provider = (BindingProvider) insert;
		Map<String, Object> req_ctx = provider.getRequestContext();
		req_ctx.put(
				BindingProvider.ENDPOINT_ADDRESS_PROPERTY, WS_URL);

		Map<String, List<String>> headers = new HashMap<String, List<String>>();
		headers.put("Username", Collections.singletonList("DevUser"));
		headers.put("Password",
				Collections.singletonList("password"));
		req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);

		System.out.println(insert.getWsdl());
	}
}