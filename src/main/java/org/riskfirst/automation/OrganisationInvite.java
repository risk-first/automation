package org.riskfirst.automation;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class OrganisationInvite {

	public static final Logger LOG = LoggerFactory.getLogger(OrganisationInvite.class);

	@Autowired
	private GithubAPI api;

	@GetMapping(path = "/invite")
	public void doOrganisationInvite(@RequestParam(name = "username", required = true) String username) {
		Map<String, Object> out = api.invite(username);
		LOG.info("/invite got " + out.toString());
	}

	@SuppressWarnings("unchecked")
	@PostMapping(path = "/webhook")
	public void doWebhook(@RequestBody Map<String, Object> eventDetails) {
		LOG.info("Webhook Event: " + eventDetails.toString());

		if ("started".equals(eventDetails.get("action"))) {
			Map<String, Object> user = (Map<String, Object>) eventDetails.get("sender");
			String login = (String) user.get("login");
			LOG.info("Webhook Watch Event From " + login);
			Map<String, Object> out = api.invite(login);
			LOG.info("/invite got " + out.toString());

		} else if (eventDetails.containsKey("forkee")) {
			Map<String, Object> forkee = (Map<String, Object>) eventDetails.get("forkee");
			Map<String, Object> owner = (Map<String, Object>) forkee.get("owner");
			String login = (String) owner.get("login");
			LOG.info("Webhook Fork Event From " + login);
			Map<String, Object> out = api.invite(login);
			LOG.info("/invite got " + out.toString());
		}
	}

}
