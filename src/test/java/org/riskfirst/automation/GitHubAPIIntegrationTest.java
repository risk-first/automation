package org.riskfirst.automation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GitHubAPIIntegrationTest {

	@Autowired
	private GithubAPI api;
	
	@Test
	public void testAddMember() {
	
		api.invite("bretweinraub");
		
	}
	
	
}
