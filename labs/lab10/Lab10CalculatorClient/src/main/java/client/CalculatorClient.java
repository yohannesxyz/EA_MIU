package client;

import generated.AddRequest;
import generated.AddResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class CalculatorClient extends WebServiceGatewaySupport {


	public int add(int a, int b) {
		AddRequest request = new AddRequest();
		request.setNumber1(a);
		request.setNumber2(b);

		AddResponse response = (AddResponse)
				getWebServiceTemplate().marshalSendAndReceive(request);
		return response.getResult();
	}

	public int subtract(int a, int b) {
		AddRequest request = new AddRequest();
		request.setNumber1(a);
		request.setNumber2(b);

		AddResponse response = (AddResponse)
				getWebServiceTemplate().marshalSendAndReceive(request);
		return response.getResult();
	}

	public int multiply(int a, int b) {
		AddRequest request = new AddRequest();
		request.setNumber1(a);
		request.setNumber2(b);

		AddResponse response = (AddResponse)
				getWebServiceTemplate().marshalSendAndReceive(request);
		return response.getResult();
	}

}


