package ServiceWsdl;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

@WebService(endpointInterface = "ServiceWsdl.ServiceWsdl")
public class ServiceWsdlImpl implements ServiceWsdl {
	@Resource
	WebServiceContext wsctx;

	@Override
	public String getWsdl() {
		MessageContext mctx = wsctx.getMessageContext();

		// Use the request headers to get the details
		Map http_headers =
				(Map) mctx.get(
						MessageContext.HTTP_REQUEST_HEADERS);
		List<String> userList = (List) http_headers.get("Username");
		List<String> passList = (List) http_headers.get("Password");

		String username = "";
		String password = "";

		if (userList != null) {
			username = userList.get(0);
		}

		if (passList != null) {
			password = passList.get(0);

		}

		if (username.equals("DevUser")
				&&
				password.equals("password")) {
			return "Hello "
					+ username +
					" to world of Jax WS - Valid User!";
		} else {
			return " User No Valid!";
		}
	}
}