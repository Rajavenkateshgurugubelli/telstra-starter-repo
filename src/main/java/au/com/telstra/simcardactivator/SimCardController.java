package au.com.telstra.simcardactivator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SimCardController {

	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("/data")
	public ResponseEntity<String> simCardDataCollector(@RequestBody User user) {
		ActuatorRequest actuatorRequest = new ActuatorRequest(user.getIccid());

		System.out.println(actuatorRequest);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<ActuatorRequest> requestEntity = new HttpEntity<>(actuatorRequest, headers);

		ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8444/actuate", requestEntity,
				String.class);

		return response;
	}

	// Inner class for the actuator request payload
	public static class ActuatorRequest {
		private String iccid;

		public ActuatorRequest(String iccid) {
			this.iccid = iccid;
		}

		public String getIccid() {
			return iccid;
		}


	}
	}
