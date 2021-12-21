package com.example.games.controllersTest;

import com.example.games.config.WebConfig;
import com.example.games.entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {WebConfig.class})
@TestPropertySource(locations = "classpath:application.properties")
@WebAppConfiguration
public class ShoppingCartControllerTest {

    private MockMvc mockMvc;

    String globalProduct = "{\n" +
            "        \"productId\": 1,\n" +
            "        \"productName\": \"Sonic the Hedgehog\",\n" +
            "        \"productCategory\": \"Game\",\n" +
            "        \"genre\": \"Platform\",\n" +
            "        \"productDescription\": \"Bust the video game speed barrrier wide open with Sonic the Hedgehog. Blaze by in a blur using the super sonic spin attack. Loop the loop by defying gravity. Plummet down tunnels. Then dash to safety with Sonic's power sneakers. All at a frenzied pace.\",\n" +
            "        \"productRarity\": \"Common\",\n" +
            "        \"developer\": \"Sonic Team\",\n" +
            "        \"publisher\": \"Sega\",\n" +
            "        \"releaseDate\": 1991,\n" +
            "        \"productPrice\": 10.00,\n" +
            "        \"systemRestriction\": \"Sega Genesis\",\n" +
            "        \"inStock\": true\n" +
            "    }";


    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
        mockMvc.perform(post("/shoppingcart").contentType(MediaType.APPLICATION_JSON).content(globalProduct));
    }

    //create shopping cart
    @Test
    public void createShoppingCart_withValidProduct_success() throws Exception {

        mockMvc.perform(post("/shoppingcart").contentType(MediaType.APPLICATION_JSON).content(globalProduct));

        String expectedShoppingCart = "{\n" +
                "    \"shoppingCartId\": 3,\n" +
                "    \"createdDate\": \"2021-12-20\",\n" +
                "    \"shoppingCartTotal\": 10.0,\n" +
                "    \"productList\": [\n" +
                "        {\n" +
                "            \"productId\": 1,\n" +
                "            \"productName\": \"Sonic the Hedgehog\",\n" +
                "            \"productCategory\": \"Game\",\n" +
                "            \"genre\": \"Platform\",\n" +
                "            \"productDescription\": \"Bust the video game speed barrrier wide open with Sonic the Hedgehog. Blaze by in a blur using the super sonic spin attack. Loop the loop by defying gravity. Plummet down tunnels. Then dash to safety with Sonic's power sneakers. All at a frenzied pace.\",\n" +
                "            \"productRarity\": \"Common\",\n" +
                "            \"developer\": \"Sonic Team\",\n" +
                "            \"publisher\": \"Sega\",\n" +
                "            \"releaseDate\": 1991,\n" +
                "            \"productPrice\": 10.00,\n" +
                "            \"systemRestriction\": \"Sega Genesis\",\n" +
                "            \"inStock\": true\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        this.mockMvc.perform(post("/shoppingcart").contentType(MediaType.APPLICATION_JSON).content(globalProduct))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(expectedShoppingCart));
    }

    //get all shopping carts
    @Test
    public void getAllShoppingCarts_success() throws Exception {

        mockMvc.perform(post("/shoppingcart").contentType(MediaType.APPLICATION_JSON).content(globalProduct));

        String expectedShoppingCart = "[\n" +
                "    {\n" +
                "        \"shoppingCartId\": 1,\n" +
                "        \"createdDate\": \"2021-12-20\",\n" +
                "        \"shoppingCartTotal\": 10.00,\n" +
                "        \"productList\": [\n" +
                "            {\n" +
                "                \"productId\": 1,\n" +
                "                \"productName\": \"Sonic the Hedgehog\",\n" +
                "                \"productCategory\": \"Game\",\n" +
                "                \"genre\": \"Platform\",\n" +
                "                \"productDescription\": \"Bust the video game speed barrrier wide open with Sonic the Hedgehog. Blaze by in a blur using the super sonic spin attack. Loop the loop by defying gravity. Plummet down tunnels. Then dash to safety with Sonic's power sneakers. All at a frenzied pace.\",\n" +
                "                \"productRarity\": \"Common\",\n" +
                "                \"developer\": \"Sonic Team\",\n" +
                "                \"publisher\": \"Sega\",\n" +
                "                \"releaseDate\": 1991,\n" +
                "                \"productPrice\": 10.00,\n" +
                "                \"systemRestriction\": \"Sega Genesis\",\n" +
                "                \"inStock\": true\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "        \"shoppingCartId\": 2,\n" +
                "        \"createdDate\": \"2021-12-20\",\n" +
                "        \"shoppingCartTotal\": 10.00,\n" +
                "        \"productList\": [\n" +
                "            {\n" +
                "                \"productId\": 1,\n" +
                "                \"productName\": \"Sonic the Hedgehog\",\n" +
                "                \"productCategory\": \"Game\",\n" +
                "                \"genre\": \"Platform\",\n" +
                "                \"productDescription\": \"Bust the video game speed barrrier wide open with Sonic the Hedgehog. Blaze by in a blur using the super sonic spin attack. Loop the loop by defying gravity. Plummet down tunnels. Then dash to safety with Sonic's power sneakers. All at a frenzied pace.\",\n" +
                "                \"productRarity\": \"Common\",\n" +
                "                \"developer\": \"Sonic Team\",\n" +
                "                \"publisher\": \"Sega\",\n" +
                "                \"releaseDate\": 1991,\n" +
                "                \"productPrice\": 10.00,\n" +
                "                \"systemRestriction\": \"Sega Genesis\",\n" +
                "                \"inStock\": true\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "]";

        this.mockMvc.perform(get("/shoppingcart"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(expectedShoppingCart));
    }

    //find shopping cart
    @Test
    public void findShoppingCart_withValidShoppingCartId_success() throws Exception {

        mockMvc.perform(post("/shoppingcart").contentType(MediaType.APPLICATION_JSON).content(globalProduct));

        String expectedShoppingCart = "{\n" +
                "    \"shoppingCartId\": 1,\n" +
                "    \"createdDate\": \"2021-12-20\",\n" +
                "    \"shoppingCartTotal\": 10.0,\n" +
                "    \"productList\": [\n" +
                "        {\n" +
                "            \"productId\": 1,\n" +
                "            \"productName\": \"Sonic the Hedgehog\",\n" +
                "            \"productCategory\": \"Game\",\n" +
                "            \"genre\": \"Platform\",\n" +
                "            \"productDescription\": \"Bust the video game speed barrrier wide open with Sonic the Hedgehog. Blaze by in a blur using the super sonic spin attack. Loop the loop by defying gravity. Plummet down tunnels. Then dash to safety with Sonic's power sneakers. All at a frenzied pace.\",\n" +
                "            \"productRarity\": \"Common\",\n" +
                "            \"developer\": \"Sonic Team\",\n" +
                "            \"publisher\": \"Sega\",\n" +
                "            \"releaseDate\": 1991,\n" +
                "            \"productPrice\": 10.00,\n" +
                "            \"systemRestriction\": \"Sega Genesis\",\n" +
                "            \"inStock\": true\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        this.mockMvc.perform(get("/shoppingcart/{shoppingCartId}", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(expectedShoppingCart));
    }

    //add product to shopping cart
    @Test
    public void addProductToShoppingCart_withValidProduct_success() throws Exception {

        mockMvc.perform(post("/shoppingcart").contentType(MediaType.APPLICATION_JSON).content(globalProduct));

        String expectedShoppingCart = "{\n" +
                "    \"shoppingCartId\": 1,\n" +
                "    \"createdDate\": \"2021-12-20\",\n" +
                "    \"shoppingCartTotal\": 20.00,\n" +
                "    \"productList\": [\n" +
                "        {\n" +
                "            \"productId\": 1,\n" +
                "            \"productName\": \"Sonic the Hedgehog\",\n" +
                "            \"productCategory\": \"Game\",\n" +
                "            \"genre\": \"Platform\",\n" +
                "            \"productDescription\": \"Bust the video game speed barrrier wide open with Sonic the Hedgehog. Blaze by in a blur using the super sonic spin attack. Loop the loop by defying gravity. Plummet down tunnels. Then dash to safety with Sonic's power sneakers. All at a frenzied pace.\",\n" +
                "            \"productRarity\": \"Common\",\n" +
                "            \"developer\": \"Sonic Team\",\n" +
                "            \"publisher\": \"Sega\",\n" +
                "            \"releaseDate\": 1991,\n" +
                "            \"productPrice\": 10.00,\n" +
                "            \"systemRestriction\": \"Sega Genesis\",\n" +
                "            \"inStock\": true\n" +
                "        },\n" +
                "        {\n" +
                "            \"productId\": 1,\n" +
                "            \"productName\": \"Sonic the Hedgehog\",\n" +
                "            \"productCategory\": \"Game\",\n" +
                "            \"genre\": \"Platform\",\n" +
                "            \"productDescription\": \"Bust the video game speed barrrier wide open with Sonic the Hedgehog. Blaze by in a blur using the super sonic spin attack. Loop the loop by defying gravity. Plummet down tunnels. Then dash to safety with Sonic's power sneakers. All at a frenzied pace.\",\n" +
                "            \"productRarity\": \"Common\",\n" +
                "            \"developer\": \"Sonic Team\",\n" +
                "            \"publisher\": \"Sega\",\n" +
                "            \"releaseDate\": 1991,\n" +
                "            \"productPrice\": 10.00,\n" +
                "            \"systemRestriction\": \"Sega Genesis\",\n" +
                "            \"inStock\": true\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        this.mockMvc.perform(put("/shoppingcart/{shoppingCartId}/product", 1).contentType(MediaType.APPLICATION_JSON).content(globalProduct))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(expectedShoppingCart));
    }

    //delete product from shopping cart
    @Test
    public void deleteProductFromShoppingCart_withValidProductId_success() throws Exception {

//        this.mockMvc.perform(delete("/shoppingcart/{shoppingCartId}/product/{productId}", 1, 1))
//                .andExpect(status().isNoContent());

        this.mockMvc.perform(delete("/shoppingcart/{shoppingCartId}/product/{productId}",  1, 1))
                .andExpect(status().isNoContent());


    }


}


