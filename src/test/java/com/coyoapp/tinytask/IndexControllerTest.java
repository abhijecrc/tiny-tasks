package com.coyoapp.tinytask;

import com.coyoapp.tinytask.store.TaskStore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class IndexControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean TaskStore taskStore;

  @Test
  public void shouldReturnIndexContent() throws Exception {
    this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
      .andExpect(content().string(containsString("Tiny Task Server is up and running.")));
  }

}
