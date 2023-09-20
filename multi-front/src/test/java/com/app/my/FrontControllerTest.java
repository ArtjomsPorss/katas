package com.app.my;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import static com.app.my.FrontController.BACKEND_URL;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FrontControllerTest {

    private FrontController target;
    private RestTemplate template;

    @BeforeEach
    public void init() {
        this.template = Mockito.mock(RestTemplate.class);
        this.target = new FrontController(this.template);
    }

    @Test
    public void getSome_returnsExpectedString() {
        String expected = "from front";
        String actual = target.getSome();
        assertEquals(expected, actual);
    }

    @Test
    public void getBack_returnsResponseFromTemplate() {
        String expected = "sometext";
        when(template.getForObject(eq(BACKEND_URL), eq(String.class))).thenReturn("sometext");
        String actual = target.getBack();
        assertEquals(expected, actual);
    }
}