package kodlamaio.ReCapProject.core.utilities.emailSender;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class ActivatorManager implements ActivatorService {

	@Override
	public String generateActivationCode() {
		UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();
	    return uuidAsString;
	}

	
}
