package org.riskfirst.automation;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.StreamUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GitHubAPIIntegrationTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private GithubAPI api;
	
	@Test
	public void testAddMember() {
	
		Map<String,Object> out = api.invite("bretweinraub");
		Assert.assertNotNull(out.get("url"));
		System.out.println(out);
	}
	
	@Test
	public void testWebhookWatchAction() throws Exception {
		String content = StreamUtils.copyToString(GitHubAPIIntegrationTest.class.getResourceAsStream("/started.example"), Charset.defaultCharset());
		this.mockMvc.perform(post("/webhook")
			.content(content).contentType(MediaType.APPLICATION_JSON))
			.andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void testWebhookForkAction() throws Exception {
		String content = StreamUtils.copyToString(GitHubAPIIntegrationTest.class.getResourceAsStream("/fork.example"), Charset.defaultCharset());
		this.mockMvc.perform(post("/webhook")
			.content(content).contentType(MediaType.APPLICATION_JSON))
			.andDo(print()).andExpect(status().isOk());
	}
}
