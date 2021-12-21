package com.example.games.controllersTest;

import com.example.games.config.WebConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {WebConfig.class})
@TestPropertySource(locations = "classpath:application.properties")
@WebAppConfiguration
public class ProductControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    //find all products
    @Test
    public void findAllProducts_withoutNameQueryParameter_success() throws Exception {
        String expectedProductsJson = "[\n" +
                "    {\n" +
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
                "    },\n" +
                "    {\n" +
                "        \"productId\": 2,\n" +
                "        \"productName\": \"Sonic the Hedgehog 2\",\n" +
                "        \"productCategory\": \"Game\",\n" +
                "        \"genre\": \"Platform\",\n" +
                "        \"productDescription\": \"Sonic's back and better than ever. He's a blur in blue! A blaze of action! With his new Super Spin Dash. And a new, fabulous friend, Tails the Fox.\",\n" +
                "        \"productRarity\": \"Common\",\n" +
                "        \"developer\": \"Sega Technical Institute\",\n" +
                "        \"publisher\": \"Sega\",\n" +
                "        \"releaseDate\": 1992,\n" +
                "        \"productPrice\": 20.00,\n" +
                "        \"systemRestriction\": \"Sega Genesis\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 3,\n" +
                "        \"productName\": \"Sonic the Hedgehog 3\",\n" +
                "        \"productCategory\": \"Game\",\n" +
                "        \"genre\": \"Platform\",\n" +
                "        \"productDescription\": \"Swing from vines, launch new attacks, survive deadly traps and summon Tails to airlift Sonic out of danger.\",\n" +
                "        \"productRarity\": \"Uncommon\",\n" +
                "        \"developer\": \"Sega Technical Institute\",\n" +
                "        \"publisher\": \"Sega\",\n" +
                "        \"releaseDate\": 1994,\n" +
                "        \"productPrice\": 30.00,\n" +
                "        \"systemRestriction\": \"Sega Genesis\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 4,\n" +
                "        \"productName\": \"Liberty or Death\",\n" +
                "        \"productCategory\": \"Game\",\n" +
                "        \"genre\": \"Turn-based Strategy\",\n" +
                "        \"productDescription\": \"It's the summer of 1775 and the colonists in America are fed up with higher taxes, no representation and pledging loyalty to a King an ocean away.\",\n" +
                "        \"productRarity\": \"Uncommon\",\n" +
                "        \"developer\": \"Sega Technical Institute\",\n" +
                "        \"publisher\": \"Sega\",\n" +
                "        \"releaseDate\": 1994,\n" +
                "        \"productPrice\": 85.00,\n" +
                "        \"systemRestriction\": \"Sega Genesis\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 5,\n" +
                "        \"productName\": \"Mortal Kombat\",\n" +
                "        \"productCategory\": \"Game\",\n" +
                "        \"genre\": \"Fighting\",\n" +
                "        \"productDescription\": \"Prepare yourself for Mortal Kombat on Sega CD: Bigger. Better. Louder. Meaner. Incredible bone-shattering graphics, new animations and pulse-pounding sound-track.\",\n" +
                "        \"productRarity\": \"Uncommon\",\n" +
                "        \"developer\": \"Midway\",\n" +
                "        \"publisher\": \"Sunsoft\",\n" +
                "        \"releaseDate\": 1993,\n" +
                "        \"productPrice\": 50.00,\n" +
                "        \"systemRestriction\": \"Sega CD\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 6,\n" +
                "        \"productName\": \"Sonic CD\",\n" +
                "        \"productCategory\": \"Game\",\n" +
                "        \"genre\": \"Platform\",\n" +
                "        \"productDescription\": \"In his first CD adventure, Sonic goes head to head with The Metal Sonic, Dr. Robotnik's evil Hedgehog creation!\",\n" +
                "        \"productRarity\": \"Common\",\n" +
                "        \"developer\": \"Sega\",\n" +
                "        \"publisher\": \"Sega\",\n" +
                "        \"releaseDate\": 1993,\n" +
                "        \"productPrice\": 60.00,\n" +
                "        \"systemRestriction\": \"Sega CD\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 7,\n" +
                "        \"productName\": \"Snatcher\",\n" +
                "        \"productCategory\": \"Game\",\n" +
                "        \"genre\": \"Graphic Adventure\",\n" +
                "        \"productDescription\": \"A.D. 2047 Neo Kobe City, Japan, a place of madness and decadence...A mysterious Bio-roid life form has appeared. Its true nature and purpose are unknown.\",\n" +
                "        \"productRarity\": \"Rare\",\n" +
                "        \"developer\": \"Konami\",\n" +
                "        \"publisher\": \"Konami\",\n" +
                "        \"releaseDate\": 1994,\n" +
                "        \"productPrice\": 1200.00,\n" +
                "        \"systemRestriction\": \"Sega CD\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 8,\n" +
                "        \"productName\": \"Little Samson\",\n" +
                "        \"productCategory\": \"Game\",\n" +
                "        \"genre\": \"Platform\",\n" +
                "        \"productDescription\": \"The Imperial Forgy has been invaded by Ta-Keed the Prince of Darkness! Only the owners of the Magic Bells can stop his forces from destroying the realm.\",\n" +
                "        \"productRarity\": \"Rare\",\n" +
                "        \"developer\": \"Taito\",\n" +
                "        \"publisher\": \"Taito\",\n" +
                "        \"releaseDate\": 1992,\n" +
                "        \"productPrice\": 2000.00,\n" +
                "        \"systemRestriction\": \"Nintendo\",\n" +
                "        \"inStock\": false\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 9,\n" +
                "        \"productName\": \"Super Mario Bros.\",\n" +
                "        \"productCategory\": \"Game\",\n" +
                "        \"genre\": \"Platform\",\n" +
                "        \"productDescription\": \"Do you have what it takes to save the Mushroom Princess? You'll have to think fast and move even faster to complete this quest! The Mushroom Princess is being held captive by the evil Koopa tribe of turtles.\",\n" +
                "        \"productRarity\": \"Common\",\n" +
                "        \"developer\": \"Nintendo R&D4\",\n" +
                "        \"publisher\": \"Nintendo\",\n" +
                "        \"releaseDate\": 1985,\n" +
                "        \"productPrice\": 10.00,\n" +
                "        \"systemRestriction\": \"Nintendo\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 10,\n" +
                "        \"productName\": \"Baseball Stars 2\",\n" +
                "        \"productCategory\": \"Game\",\n" +
                "        \"genre\": \"Sports\",\n" +
                "        \"productDescription\": \"Baseball\",\n" +
                "        \"productRarity\": \"Uncommon\",\n" +
                "        \"developer\": \"SNK\",\n" +
                "        \"publisher\": \"Romstar\",\n" +
                "        \"releaseDate\": 1992,\n" +
                "        \"productPrice\": 35.00,\n" +
                "        \"systemRestriction\": \"Nintendo\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 11,\n" +
                "        \"productName\": \"Super Mario Bros All Stars\",\n" +
                "        \"productCategory\": \"Game\",\n" +
                "        \"genre\": \"Platform\",\n" +
                "        \"productDescription\": \"The complete Super Mario Bros 4 in 1 Game Pak!\",\n" +
                "        \"productRarity\": \"Common\",\n" +
                "        \"developer\": \"Nintendo EAD\",\n" +
                "        \"publisher\": \"Nintendo\",\n" +
                "        \"releaseDate\": 1993,\n" +
                "        \"productPrice\": 35.00,\n" +
                "        \"systemRestriction\": \"Super Nintendo\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 12,\n" +
                "        \"productName\": \"Super Mario RPG\",\n" +
                "        \"productCategory\": \"Game\",\n" +
                "        \"genre\": \"RPG\",\n" +
                "        \"productDescription\": \"Mario returns in this incredible new role-playing adventure! His latest rival is Smithy, a menacing creature who causes fear and treachery in the Mushroom Kingdom.\",\n" +
                "        \"productRarity\": \"Uncommon\",\n" +
                "        \"developer\": \"Square\",\n" +
                "        \"publisher\": \"Nintendo\",\n" +
                "        \"releaseDate\": 1996,\n" +
                "        \"productPrice\": 85.00,\n" +
                "        \"systemRestriction\": \"Super Nintendo\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 13,\n" +
                "        \"productName\": \"Mega Man X\",\n" +
                "        \"productCategory\": \"Game\",\n" +
                "        \"genre\": \"Action\",\n" +
                "        \"productDescription\": \"Near the end of his life, Dr. Light succeeds in creating the first of a new series of robots which will change the world. Able to think and make decisions, this new robot holds great danger as well as great possibilities.\",\n" +
                "        \"productRarity\": \"Common\",\n" +
                "        \"developer\": \"Capcom\",\n" +
                "        \"publisher\": \"Capcom\",\n" +
                "        \"releaseDate\": 1993,\n" +
                "        \"productPrice\": 35.00,\n" +
                "        \"systemRestriction\": \"Super Nintendo\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 14,\n" +
                "        \"productName\": \"Mega Man X2\",\n" +
                "        \"productCategory\": \"Game\",\n" +
                "        \"genre\": \"Action\",\n" +
                "        \"productDescription\": \"Just when Mega Man X thought he had brought down all the X-Hunters, several months later an uprising moves from within an abandoned factory.\",\n" +
                "        \"productRarity\": \"Rare\",\n" +
                "        \"developer\": \"Capcom\",\n" +
                "        \"publisher\": \"Capcom\",\n" +
                "        \"releaseDate\": 1994,\n" +
                "        \"productPrice\": 150.00,\n" +
                "        \"systemRestriction\": \"Super Nintendo\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 15,\n" +
                "        \"productName\": \"Mega Man X3\",\n" +
                "        \"productCategory\": \"Game\",\n" +
                "        \"genre\": \"Action\",\n" +
                "        \"productDescription\": \"Mega Man X and his trusty partner Zero have a new force to reckon with. Who or what has caused a riot of Mavericks to break out in the experimental utopia known as Doppler Town?\",\n" +
                "        \"productRarity\": \"Rare\",\n" +
                "        \"developer\": \"Capcom\",\n" +
                "        \"publisher\": \"Capcom\",\n" +
                "        \"releaseDate\": 1995,\n" +
                "        \"productPrice\": 35.00,\n" +
                "        \"systemRestriction\": \"Super Nintendo\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 16,\n" +
                "        \"productName\": \"Super Mario 64\",\n" +
                "        \"productCategory\": \"Game\",\n" +
                "        \"genre\": \"Adventure\",\n" +
                "        \"productDescription\": \"Mario is super in a whole new way! Combining the finest 3-D graphics ever developed for a video game and an explosive sound track.\",\n" +
                "        \"productRarity\": \"Common\",\n" +
                "        \"developer\": \"Nintendo EAD\",\n" +
                "        \"publisher\": \"Nintendo\",\n" +
                "        \"releaseDate\": 1996,\n" +
                "        \"productPrice\": 30.00,\n" +
                "        \"systemRestriction\": \"Nintendo 64\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 17,\n" +
                "        \"productName\": \"Super Smash Bros.\",\n" +
                "        \"productCategory\": \"Game\",\n" +
                "        \"genre\": \"Fighting\",\n" +
                "        \"productDescription\": \"It's a Bumpin, Bruisin, Brawlin Bash! The many worlds of Nintendo collide in the ultimate showdown of strength and skill!\",\n" +
                "        \"productRarity\": \"Uncommon\",\n" +
                "        \"developer\": \"HAL Laboratory\",\n" +
                "        \"publisher\": \"Nintendo\",\n" +
                "        \"releaseDate\": 1999,\n" +
                "        \"productPrice\": 45.00,\n" +
                "        \"systemRestriction\": \"Nintendo 64\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 18,\n" +
                "        \"productName\": \"StarCraft 64\",\n" +
                "        \"productCategory\": \"Game\",\n" +
                "        \"genre\": \"Strategy\",\n" +
                "        \"productDescription\": \"In the distant future, a small group of human exiles have been found doomed to fight for their survival on the edge of the universe.\",\n" +
                "        \"productRarity\": \"Rare\",\n" +
                "        \"developer\": \"Blizzard Entertainment\",\n" +
                "        \"publisher\": \"Nintendo\",\n" +
                "        \"releaseDate\": 2000,\n" +
                "        \"productPrice\": 100.00,\n" +
                "        \"systemRestriction\": \"Nintendo 64\",\n" +
                "        \"inStock\": false\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 19,\n" +
                "        \"productName\": \"Twisted Metal\",\n" +
                "        \"productCategory\": \"Game\",\n" +
                "        \"genre\": \"Vehicular Combat\",\n" +
                "        \"productDescription\": \"YOU ARE WHAT YOU DRIVE. Big and tough, fast and deadly, or just plain crazy! 12 deadly machines in all! Stalk highways! Hunt suburbia! Take your pick. One just says you all over!\",\n" +
                "        \"productRarity\": \"Common\",\n" +
                "        \"developer\": \"Single Trac\",\n" +
                "        \"publisher\": \"Sony Computer Entertainment\",\n" +
                "        \"releaseDate\": 1995,\n" +
                "        \"productPrice\": 35.00,\n" +
                "        \"systemRestriction\": \"Sony Playstation\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 20,\n" +
                "        \"productName\": \"Mega Man X4\",\n" +
                "        \"productCategory\": \"Game\",\n" +
                "        \"genre\": \"Action\",\n" +
                "        \"productDescription\": \"Battle armies of Maverick Reploid Robots while mastering all-new strategic moves like the Air hover and Zero's Saber Tactic system.\",\n" +
                "        \"productRarity\": \"Uncommon\",\n" +
                "        \"developer\": \"Capcom\",\n" +
                "        \"publisher\": \"Capcom\",\n" +
                "        \"releaseDate\": 1997,\n" +
                "        \"productPrice\": 30.00,\n" +
                "        \"systemRestriction\": \"Sony Playstation\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 21,\n" +
                "        \"productName\": \"Suikoden 2\",\n" +
                "        \"productCategory\": \"Game\",\n" +
                "        \"genre\": \"JRPG\",\n" +
                "        \"productDescription\": \"Experience An Epic Tale Of Warfare, Magic, Friendship And Betrayal. New tactical map battles add a whole new level of strategy.\",\n" +
                "        \"productRarity\": \"Rare\",\n" +
                "        \"developer\": \"SNK\",\n" +
                "        \"publisher\": \"Romstar\",\n" +
                "        \"releaseDate\": 1992,\n" +
                "        \"productPrice\": 350.00,\n" +
                "        \"systemRestriction\": \"Sony Playstation\",\n" +
                "        \"inStock\": false\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 22,\n" +
                "        \"productName\": \"Nintendo\",\n" +
                "        \"productCategory\": \"System\",\n" +
                "        \"genre\": \"NA\",\n" +
                "        \"productDescription\": \"Console used to play Nintendo games\",\n" +
                "        \"productRarity\": \"Common\",\n" +
                "        \"developer\": \"Nintendo\",\n" +
                "        \"publisher\": \"Nintendo\",\n" +
                "        \"releaseDate\": 1983,\n" +
                "        \"productPrice\": 75.00,\n" +
                "        \"systemRestriction\": \"Nintendo\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 23,\n" +
                "        \"productName\": \"Super Nintendo\",\n" +
                "        \"productCategory\": \"System\",\n" +
                "        \"genre\": \"NA\",\n" +
                "        \"productDescription\": \"Console used to play Super Nintendo games\",\n" +
                "        \"productRarity\": \"Common\",\n" +
                "        \"developer\": \"Nintendo\",\n" +
                "        \"publisher\": \"Nintendo\",\n" +
                "        \"releaseDate\": 1990,\n" +
                "        \"productPrice\": 80.00,\n" +
                "        \"systemRestriction\": \"Super Nintendo\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 24,\n" +
                "        \"productName\": \"Nintendo 64\",\n" +
                "        \"productCategory\": \"System\",\n" +
                "        \"genre\": \"NA\",\n" +
                "        \"productDescription\": \"Console used to play Nintendo 64 games\",\n" +
                "        \"productRarity\": \"Common\",\n" +
                "        \"developer\": \"Nintendo\",\n" +
                "        \"publisher\": \"Nintendo\",\n" +
                "        \"releaseDate\": 1996,\n" +
                "        \"productPrice\": 100.00,\n" +
                "        \"systemRestriction\": \"Nintendo 64\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 25,\n" +
                "        \"productName\": \"Sega Genesis\",\n" +
                "        \"productCategory\": \"System\",\n" +
                "        \"genre\": \"NA\",\n" +
                "        \"productDescription\": \"Console used to play Sega Genesis games\",\n" +
                "        \"productRarity\": \"Common\",\n" +
                "        \"developer\": \"Sega\",\n" +
                "        \"publisher\": \"Sega\",\n" +
                "        \"releaseDate\": 1989,\n" +
                "        \"productPrice\": 75.00,\n" +
                "        \"systemRestriction\": \"Sega Genesis\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 26,\n" +
                "        \"productName\": \"Sega CD\",\n" +
                "        \"productCategory\": \"System\",\n" +
                "        \"genre\": \"NA\",\n" +
                "        \"productDescription\": \"Console used to play Sega CD games\",\n" +
                "        \"productRarity\": \"Uncommon\",\n" +
                "        \"developer\": \"Sega\",\n" +
                "        \"publisher\": \"Sega\",\n" +
                "        \"releaseDate\": 1991,\n" +
                "        \"productPrice\": 100.00,\n" +
                "        \"systemRestriction\": \"Sega CD\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 27,\n" +
                "        \"productName\": \"Sony Playstation\",\n" +
                "        \"productCategory\": \"System\",\n" +
                "        \"genre\": \"NA\",\n" +
                "        \"productDescription\": \"Console used to play Sony Playstation games\",\n" +
                "        \"productRarity\": \"Common\",\n" +
                "        \"developer\": \"Sony\",\n" +
                "        \"publisher\": \"Sony\",\n" +
                "        \"releaseDate\": 1994,\n" +
                "        \"productPrice\": 100.00,\n" +
                "        \"systemRestriction\": \"Sony Playstation\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 28,\n" +
                "        \"productName\": \"Sega Genesis Controller\",\n" +
                "        \"productCategory\": \"Controller\",\n" +
                "        \"genre\": \"NA\",\n" +
                "        \"productDescription\": \"Controller used to play Sega Genesis games\",\n" +
                "        \"productRarity\": \"Common\",\n" +
                "        \"developer\": \"Sega\",\n" +
                "        \"publisher\": \"Sega\",\n" +
                "        \"releaseDate\": 1991,\n" +
                "        \"productPrice\": 10.00,\n" +
                "        \"systemRestriction\": \"Sega Genesis\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 29,\n" +
                "        \"productName\": \"Sega CD Controller\",\n" +
                "        \"productCategory\": \"Controller\",\n" +
                "        \"genre\": \"NA\",\n" +
                "        \"productDescription\": \"Controller used to play Sega CD games\",\n" +
                "        \"productRarity\": \"Common\",\n" +
                "        \"developer\": \"Sega\",\n" +
                "        \"publisher\": \"Sega\",\n" +
                "        \"releaseDate\": 1991,\n" +
                "        \"productPrice\": 10.00,\n" +
                "        \"systemRestriction\": \"Sega CD\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 30,\n" +
                "        \"productName\": \"Nintendo Controller\",\n" +
                "        \"productCategory\": \"Controller\",\n" +
                "        \"genre\": \"NA\",\n" +
                "        \"productDescription\": \"Controller used to play Nintendo games\",\n" +
                "        \"productRarity\": \"Common\",\n" +
                "        \"developer\": \"Nintendo\",\n" +
                "        \"publisher\": \"Nintendo\",\n" +
                "        \"releaseDate\": 1983,\n" +
                "        \"productPrice\": 10.00,\n" +
                "        \"systemRestriction\": \"Nintendo\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 31,\n" +
                "        \"productName\": \"Super Nintendo Controller\",\n" +
                "        \"productCategory\": \"Controller\",\n" +
                "        \"genre\": \"NA\",\n" +
                "        \"productDescription\": \"Controller used to play Super Nintendo games\",\n" +
                "        \"productRarity\": \"Common\",\n" +
                "        \"developer\": \"Nintendo\",\n" +
                "        \"publisher\": \"Nintendo\",\n" +
                "        \"releaseDate\": 1990,\n" +
                "        \"productPrice\": 10.00,\n" +
                "        \"systemRestriction\": \"Super Nintendo\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 32,\n" +
                "        \"productName\": \"Nintendo 64 Controller\",\n" +
                "        \"productCategory\": \"Controller\",\n" +
                "        \"genre\": \"NA\",\n" +
                "        \"productDescription\": \"Controller used to play Nintendo 64 games\",\n" +
                "        \"productRarity\": \"Common\",\n" +
                "        \"developer\": \"Nintendo\",\n" +
                "        \"publisher\": \"Nintendo\",\n" +
                "        \"releaseDate\": 1996,\n" +
                "        \"productPrice\": 30.00,\n" +
                "        \"systemRestriction\": \"Nintendo 64\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 33,\n" +
                "        \"productName\": \"Playstation Controller\",\n" +
                "        \"productCategory\": \"Controller\",\n" +
                "        \"genre\": \"NA\",\n" +
                "        \"productDescription\": \"Controller used to play Sony Playstation games\",\n" +
                "        \"productRarity\": \"Common\",\n" +
                "        \"developer\": \"Sony\",\n" +
                "        \"publisher\": \"Sony\",\n" +
                "        \"releaseDate\": 1994,\n" +
                "        \"productPrice\": 20.00,\n" +
                "        \"systemRestriction\": \"Sony Playstation\",\n" +
                "        \"inStock\": true\n" +
                "    }\n" +
                "]";

        this.mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(expectedProductsJson));
    }

    //find all product with valid query parameter
    @Test
    public void findAllProducts_withNameQueryParameter_success() throws Exception {
        String expectedProductJson = "[\n" +
                "    {\n" +
                "        \"productId\": 33,\n" +
                "        \"productName\": \"Playstation Controller\",\n" +
                "        \"productCategory\": \"Controller\",\n" +
                "        \"genre\": \"NA\",\n" +
                "        \"productDescription\": \"Controller used to play Sony Playstation games\",\n" +
                "        \"productRarity\": \"Common\",\n" +
                "        \"developer\": \"Sony\",\n" +
                "        \"publisher\": \"Sony\",\n" +
                "        \"releaseDate\": 1994,\n" +
                "        \"productPrice\": 20.00,\n" +
                "        \"systemRestriction\": \"Sony Playstation\",\n" +
                "        \"inStock\": true\n" +
                "    }\n" +
                "]";

        this.mockMvc.perform(get("/products").queryParam("productName", "Playstation Controller"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(expectedProductJson));

    }

    //find product by category
    @Test
    public void findProductsByCategory_withValidCategory_success() throws Exception {
        String expectedProductJson = "[\n" +
                "    {\n" +
                "        \"productId\": 28,\n" +
                "        \"productName\": \"Sega Genesis Controller\",\n" +
                "        \"productCategory\": \"Controller\",\n" +
                "        \"genre\": \"NA\",\n" +
                "        \"productDescription\": \"Controller used to play Sega Genesis games\",\n" +
                "        \"productRarity\": \"Common\",\n" +
                "        \"developer\": \"Sega\",\n" +
                "        \"publisher\": \"Sega\",\n" +
                "        \"releaseDate\": 1991,\n" +
                "        \"productPrice\": 10.00,\n" +
                "        \"systemRestriction\": \"Sega Genesis\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 29,\n" +
                "        \"productName\": \"Sega CD Controller\",\n" +
                "        \"productCategory\": \"Controller\",\n" +
                "        \"genre\": \"NA\",\n" +
                "        \"productDescription\": \"Controller used to play Sega CD games\",\n" +
                "        \"productRarity\": \"Common\",\n" +
                "        \"developer\": \"Sega\",\n" +
                "        \"publisher\": \"Sega\",\n" +
                "        \"releaseDate\": 1991,\n" +
                "        \"productPrice\": 10.00,\n" +
                "        \"systemRestriction\": \"Sega CD\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 30,\n" +
                "        \"productName\": \"Nintendo Controller\",\n" +
                "        \"productCategory\": \"Controller\",\n" +
                "        \"genre\": \"NA\",\n" +
                "        \"productDescription\": \"Controller used to play Nintendo games\",\n" +
                "        \"productRarity\": \"Common\",\n" +
                "        \"developer\": \"Nintendo\",\n" +
                "        \"publisher\": \"Nintendo\",\n" +
                "        \"releaseDate\": 1983,\n" +
                "        \"productPrice\": 10.00,\n" +
                "        \"systemRestriction\": \"Nintendo\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 31,\n" +
                "        \"productName\": \"Super Nintendo Controller\",\n" +
                "        \"productCategory\": \"Controller\",\n" +
                "        \"genre\": \"NA\",\n" +
                "        \"productDescription\": \"Controller used to play Super Nintendo games\",\n" +
                "        \"productRarity\": \"Common\",\n" +
                "        \"developer\": \"Nintendo\",\n" +
                "        \"publisher\": \"Nintendo\",\n" +
                "        \"releaseDate\": 1990,\n" +
                "        \"productPrice\": 10.00,\n" +
                "        \"systemRestriction\": \"Super Nintendo\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 32,\n" +
                "        \"productName\": \"Nintendo 64 Controller\",\n" +
                "        \"productCategory\": \"Controller\",\n" +
                "        \"genre\": \"NA\",\n" +
                "        \"productDescription\": \"Controller used to play Nintendo 64 games\",\n" +
                "        \"productRarity\": \"Common\",\n" +
                "        \"developer\": \"Nintendo\",\n" +
                "        \"publisher\": \"Nintendo\",\n" +
                "        \"releaseDate\": 1996,\n" +
                "        \"productPrice\": 30.00,\n" +
                "        \"systemRestriction\": \"Nintendo 64\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 33,\n" +
                "        \"productName\": \"Playstation Controller\",\n" +
                "        \"productCategory\": \"Controller\",\n" +
                "        \"genre\": \"NA\",\n" +
                "        \"productDescription\": \"Controller used to play Sony Playstation games\",\n" +
                "        \"productRarity\": \"Common\",\n" +
                "        \"developer\": \"Sony\",\n" +
                "        \"publisher\": \"Sony\",\n" +
                "        \"releaseDate\": 1994,\n" +
                "        \"productPrice\": 20.00,\n" +
                "        \"systemRestriction\": \"Sony Playstation\",\n" +
                "        \"inStock\": true\n" +
                "    }\n" +
                "]";

        this.mockMvc.perform(get("/productCategory/{productCategory}", "Controller"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(expectedProductJson));
    }

    //find by system restriction
    @Test
    public void findAllBySystemRestriction_withValidSystemRestriction_success() throws Exception {
        String expectedProductJson = "[\n" +
                "    {\n" +
                "        \"productId\": 19,\n" +
                "        \"productName\": \"Twisted Metal\",\n" +
                "        \"productCategory\": \"Game\",\n" +
                "        \"genre\": \"Vehicular Combat\",\n" +
                "        \"productDescription\": \"YOU ARE WHAT YOU DRIVE. Big and tough, fast and deadly, or just plain crazy! 12 deadly machines in all! Stalk highways! Hunt suburbia! Take your pick. One just says you all over!\",\n" +
                "        \"productRarity\": \"Common\",\n" +
                "        \"developer\": \"Single Trac\",\n" +
                "        \"publisher\": \"Sony Computer Entertainment\",\n" +
                "        \"releaseDate\": 1995,\n" +
                "        \"productPrice\": 35.00,\n" +
                "        \"systemRestriction\": \"Sony Playstation\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 20,\n" +
                "        \"productName\": \"Mega Man X4\",\n" +
                "        \"productCategory\": \"Game\",\n" +
                "        \"genre\": \"Action\",\n" +
                "        \"productDescription\": \"Battle armies of Maverick Reploid Robots while mastering all-new strategic moves like the Air hover and Zero's Saber Tactic system.\",\n" +
                "        \"productRarity\": \"Uncommon\",\n" +
                "        \"developer\": \"Capcom\",\n" +
                "        \"publisher\": \"Capcom\",\n" +
                "        \"releaseDate\": 1997,\n" +
                "        \"productPrice\": 30.00,\n" +
                "        \"systemRestriction\": \"Sony Playstation\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 21,\n" +
                "        \"productName\": \"Suikoden 2\",\n" +
                "        \"productCategory\": \"Game\",\n" +
                "        \"genre\": \"JRPG\",\n" +
                "        \"productDescription\": \"Experience An Epic Tale Of Warfare, Magic, Friendship And Betrayal. New tactical map battles add a whole new level of strategy.\",\n" +
                "        \"productRarity\": \"Rare\",\n" +
                "        \"developer\": \"SNK\",\n" +
                "        \"publisher\": \"Romstar\",\n" +
                "        \"releaseDate\": 1992,\n" +
                "        \"productPrice\": 350.00,\n" +
                "        \"systemRestriction\": \"Sony Playstation\",\n" +
                "        \"inStock\": false\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 27,\n" +
                "        \"productName\": \"Sony Playstation\",\n" +
                "        \"productCategory\": \"System\",\n" +
                "        \"genre\": \"NA\",\n" +
                "        \"productDescription\": \"Console used to play Sony Playstation games\",\n" +
                "        \"productRarity\": \"Common\",\n" +
                "        \"developer\": \"Sony\",\n" +
                "        \"publisher\": \"Sony\",\n" +
                "        \"releaseDate\": 1994,\n" +
                "        \"productPrice\": 100.00,\n" +
                "        \"systemRestriction\": \"Sony Playstation\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 33,\n" +
                "        \"productName\": \"Playstation Controller\",\n" +
                "        \"productCategory\": \"Controller\",\n" +
                "        \"genre\": \"NA\",\n" +
                "        \"productDescription\": \"Controller used to play Sony Playstation games\",\n" +
                "        \"productRarity\": \"Common\",\n" +
                "        \"developer\": \"Sony\",\n" +
                "        \"publisher\": \"Sony\",\n" +
                "        \"releaseDate\": 1994,\n" +
                "        \"productPrice\": 20.00,\n" +
                "        \"systemRestriction\": \"Sony Playstation\",\n" +
                "        \"inStock\": true\n" +
                "    }\n" +
                "]";

        this.mockMvc.perform(get("/systemRestriction/{systemRestriction}", "Sony Playstation"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(expectedProductJson));
    }

    //find all products in stock is true
    @Test
    public void findAllProductsInStockIsTrue_success() throws Exception {
        String expectedProductJson = "[\n" +
                "    {\n" +
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
                "    },\n" +
                "    {\n" +
                "        \"productId\": 2,\n" +
                "        \"productName\": \"Sonic the Hedgehog 2\",\n" +
                "        \"productCategory\": \"Game\",\n" +
                "        \"genre\": \"Platform\",\n" +
                "        \"productDescription\": \"Sonic's back and better than ever. He's a blur in blue! A blaze of action! With his new Super Spin Dash. And a new, fabulous friend, Tails the Fox.\",\n" +
                "        \"productRarity\": \"Common\",\n" +
                "        \"developer\": \"Sega Technical Institute\",\n" +
                "        \"publisher\": \"Sega\",\n" +
                "        \"releaseDate\": 1992,\n" +
                "        \"productPrice\": 20.00,\n" +
                "        \"systemRestriction\": \"Sega Genesis\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 3,\n" +
                "        \"productName\": \"Sonic the Hedgehog 3\",\n" +
                "        \"productCategory\": \"Game\",\n" +
                "        \"genre\": \"Platform\",\n" +
                "        \"productDescription\": \"Swing from vines, launch new attacks, survive deadly traps and summon Tails to airlift Sonic out of danger.\",\n" +
                "        \"productRarity\": \"Uncommon\",\n" +
                "        \"developer\": \"Sega Technical Institute\",\n" +
                "        \"publisher\": \"Sega\",\n" +
                "        \"releaseDate\": 1994,\n" +
                "        \"productPrice\": 30.00,\n" +
                "        \"systemRestriction\": \"Sega Genesis\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 4,\n" +
                "        \"productName\": \"Liberty or Death\",\n" +
                "        \"productCategory\": \"Game\",\n" +
                "        \"genre\": \"Turn-based Strategy\",\n" +
                "        \"productDescription\": \"It's the summer of 1775 and the colonists in America are fed up with higher taxes, no representation and pledging loyalty to a King an ocean away.\",\n" +
                "        \"productRarity\": \"Uncommon\",\n" +
                "        \"developer\": \"Sega Technical Institute\",\n" +
                "        \"publisher\": \"Sega\",\n" +
                "        \"releaseDate\": 1994,\n" +
                "        \"productPrice\": 85.00,\n" +
                "        \"systemRestriction\": \"Sega Genesis\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 5,\n" +
                "        \"productName\": \"Mortal Kombat\",\n" +
                "        \"productCategory\": \"Game\",\n" +
                "        \"genre\": \"Fighting\",\n" +
                "        \"productDescription\": \"Prepare yourself for Mortal Kombat on Sega CD: Bigger. Better. Louder. Meaner. Incredible bone-shattering graphics, new animations and pulse-pounding sound-track.\",\n" +
                "        \"productRarity\": \"Uncommon\",\n" +
                "        \"developer\": \"Midway\",\n" +
                "        \"publisher\": \"Sunsoft\",\n" +
                "        \"releaseDate\": 1993,\n" +
                "        \"productPrice\": 50.00,\n" +
                "        \"systemRestriction\": \"Sega CD\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 6,\n" +
                "        \"productName\": \"Sonic CD\",\n" +
                "        \"productCategory\": \"Game\",\n" +
                "        \"genre\": \"Platform\",\n" +
                "        \"productDescription\": \"In his first CD adventure, Sonic goes head to head with The Metal Sonic, Dr. Robotnik's evil Hedgehog creation!\",\n" +
                "        \"productRarity\": \"Common\",\n" +
                "        \"developer\": \"Sega\",\n" +
                "        \"publisher\": \"Sega\",\n" +
                "        \"releaseDate\": 1993,\n" +
                "        \"productPrice\": 60.00,\n" +
                "        \"systemRestriction\": \"Sega CD\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 7,\n" +
                "        \"productName\": \"Snatcher\",\n" +
                "        \"productCategory\": \"Game\",\n" +
                "        \"genre\": \"Graphic Adventure\",\n" +
                "        \"productDescription\": \"A.D. 2047 Neo Kobe City, Japan, a place of madness and decadence...A mysterious Bio-roid life form has appeared. Its true nature and purpose are unknown.\",\n" +
                "        \"productRarity\": \"Rare\",\n" +
                "        \"developer\": \"Konami\",\n" +
                "        \"publisher\": \"Konami\",\n" +
                "        \"releaseDate\": 1994,\n" +
                "        \"productPrice\": 1200.00,\n" +
                "        \"systemRestriction\": \"Sega CD\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 9,\n" +
                "        \"productName\": \"Super Mario Bros.\",\n" +
                "        \"productCategory\": \"Game\",\n" +
                "        \"genre\": \"Platform\",\n" +
                "        \"productDescription\": \"Do you have what it takes to save the Mushroom Princess? You'll have to think fast and move even faster to complete this quest! The Mushroom Princess is being held captive by the evil Koopa tribe of turtles.\",\n" +
                "        \"productRarity\": \"Common\",\n" +
                "        \"developer\": \"Nintendo R&D4\",\n" +
                "        \"publisher\": \"Nintendo\",\n" +
                "        \"releaseDate\": 1985,\n" +
                "        \"productPrice\": 10.00,\n" +
                "        \"systemRestriction\": \"Nintendo\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 10,\n" +
                "        \"productName\": \"Baseball Stars 2\",\n" +
                "        \"productCategory\": \"Game\",\n" +
                "        \"genre\": \"Sports\",\n" +
                "        \"productDescription\": \"Baseball\",\n" +
                "        \"productRarity\": \"Uncommon\",\n" +
                "        \"developer\": \"SNK\",\n" +
                "        \"publisher\": \"Romstar\",\n" +
                "        \"releaseDate\": 1992,\n" +
                "        \"productPrice\": 35.00,\n" +
                "        \"systemRestriction\": \"Nintendo\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 11,\n" +
                "        \"productName\": \"Super Mario Bros All Stars\",\n" +
                "        \"productCategory\": \"Game\",\n" +
                "        \"genre\": \"Platform\",\n" +
                "        \"productDescription\": \"The complete Super Mario Bros 4 in 1 Game Pak!\",\n" +
                "        \"productRarity\": \"Common\",\n" +
                "        \"developer\": \"Nintendo EAD\",\n" +
                "        \"publisher\": \"Nintendo\",\n" +
                "        \"releaseDate\": 1993,\n" +
                "        \"productPrice\": 35.00,\n" +
                "        \"systemRestriction\": \"Super Nintendo\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 12,\n" +
                "        \"productName\": \"Super Mario RPG\",\n" +
                "        \"productCategory\": \"Game\",\n" +
                "        \"genre\": \"RPG\",\n" +
                "        \"productDescription\": \"Mario returns in this incredible new role-playing adventure! His latest rival is Smithy, a menacing creature who causes fear and treachery in the Mushroom Kingdom.\",\n" +
                "        \"productRarity\": \"Uncommon\",\n" +
                "        \"developer\": \"Square\",\n" +
                "        \"publisher\": \"Nintendo\",\n" +
                "        \"releaseDate\": 1996,\n" +
                "        \"productPrice\": 85.00,\n" +
                "        \"systemRestriction\": \"Super Nintendo\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 13,\n" +
                "        \"productName\": \"Mega Man X\",\n" +
                "        \"productCategory\": \"Game\",\n" +
                "        \"genre\": \"Action\",\n" +
                "        \"productDescription\": \"Near the end of his life, Dr. Light succeeds in creating the first of a new series of robots which will change the world. Able to think and make decisions, this new robot holds great danger as well as great possibilities.\",\n" +
                "        \"productRarity\": \"Common\",\n" +
                "        \"developer\": \"Capcom\",\n" +
                "        \"publisher\": \"Capcom\",\n" +
                "        \"releaseDate\": 1993,\n" +
                "        \"productPrice\": 35.00,\n" +
                "        \"systemRestriction\": \"Super Nintendo\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 14,\n" +
                "        \"productName\": \"Mega Man X2\",\n" +
                "        \"productCategory\": \"Game\",\n" +
                "        \"genre\": \"Action\",\n" +
                "        \"productDescription\": \"Just when Mega Man X thought he had brought down all the X-Hunters, several months later an uprising moves from within an abandoned factory.\",\n" +
                "        \"productRarity\": \"Rare\",\n" +
                "        \"developer\": \"Capcom\",\n" +
                "        \"publisher\": \"Capcom\",\n" +
                "        \"releaseDate\": 1994,\n" +
                "        \"productPrice\": 150.00,\n" +
                "        \"systemRestriction\": \"Super Nintendo\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 15,\n" +
                "        \"productName\": \"Mega Man X3\",\n" +
                "        \"productCategory\": \"Game\",\n" +
                "        \"genre\": \"Action\",\n" +
                "        \"productDescription\": \"Mega Man X and his trusty partner Zero have a new force to reckon with. Who or what has caused a riot of Mavericks to break out in the experimental utopia known as Doppler Town?\",\n" +
                "        \"productRarity\": \"Rare\",\n" +
                "        \"developer\": \"Capcom\",\n" +
                "        \"publisher\": \"Capcom\",\n" +
                "        \"releaseDate\": 1995,\n" +
                "        \"productPrice\": 35.00,\n" +
                "        \"systemRestriction\": \"Super Nintendo\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 16,\n" +
                "        \"productName\": \"Super Mario 64\",\n" +
                "        \"productCategory\": \"Game\",\n" +
                "        \"genre\": \"Adventure\",\n" +
                "        \"productDescription\": \"Mario is super in a whole new way! Combining the finest 3-D graphics ever developed for a video game and an explosive sound track.\",\n" +
                "        \"productRarity\": \"Common\",\n" +
                "        \"developer\": \"Nintendo EAD\",\n" +
                "        \"publisher\": \"Nintendo\",\n" +
                "        \"releaseDate\": 1996,\n" +
                "        \"productPrice\": 30.00,\n" +
                "        \"systemRestriction\": \"Nintendo 64\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 17,\n" +
                "        \"productName\": \"Super Smash Bros.\",\n" +
                "        \"productCategory\": \"Game\",\n" +
                "        \"genre\": \"Fighting\",\n" +
                "        \"productDescription\": \"It's a Bumpin, Bruisin, Brawlin Bash! The many worlds of Nintendo collide in the ultimate showdown of strength and skill!\",\n" +
                "        \"productRarity\": \"Uncommon\",\n" +
                "        \"developer\": \"HAL Laboratory\",\n" +
                "        \"publisher\": \"Nintendo\",\n" +
                "        \"releaseDate\": 1999,\n" +
                "        \"productPrice\": 45.00,\n" +
                "        \"systemRestriction\": \"Nintendo 64\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 19,\n" +
                "        \"productName\": \"Twisted Metal\",\n" +
                "        \"productCategory\": \"Game\",\n" +
                "        \"genre\": \"Vehicular Combat\",\n" +
                "        \"productDescription\": \"YOU ARE WHAT YOU DRIVE. Big and tough, fast and deadly, or just plain crazy! 12 deadly machines in all! Stalk highways! Hunt suburbia! Take your pick. One just says you all over!\",\n" +
                "        \"productRarity\": \"Common\",\n" +
                "        \"developer\": \"Single Trac\",\n" +
                "        \"publisher\": \"Sony Computer Entertainment\",\n" +
                "        \"releaseDate\": 1995,\n" +
                "        \"productPrice\": 35.00,\n" +
                "        \"systemRestriction\": \"Sony Playstation\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 20,\n" +
                "        \"productName\": \"Mega Man X4\",\n" +
                "        \"productCategory\": \"Game\",\n" +
                "        \"genre\": \"Action\",\n" +
                "        \"productDescription\": \"Battle armies of Maverick Reploid Robots while mastering all-new strategic moves like the Air hover and Zero's Saber Tactic system.\",\n" +
                "        \"productRarity\": \"Uncommon\",\n" +
                "        \"developer\": \"Capcom\",\n" +
                "        \"publisher\": \"Capcom\",\n" +
                "        \"releaseDate\": 1997,\n" +
                "        \"productPrice\": 30.00,\n" +
                "        \"systemRestriction\": \"Sony Playstation\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 22,\n" +
                "        \"productName\": \"Nintendo\",\n" +
                "        \"productCategory\": \"System\",\n" +
                "        \"genre\": \"NA\",\n" +
                "        \"productDescription\": \"Console used to play Nintendo games\",\n" +
                "        \"productRarity\": \"Common\",\n" +
                "        \"developer\": \"Nintendo\",\n" +
                "        \"publisher\": \"Nintendo\",\n" +
                "        \"releaseDate\": 1983,\n" +
                "        \"productPrice\": 75.00,\n" +
                "        \"systemRestriction\": \"Nintendo\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 23,\n" +
                "        \"productName\": \"Super Nintendo\",\n" +
                "        \"productCategory\": \"System\",\n" +
                "        \"genre\": \"NA\",\n" +
                "        \"productDescription\": \"Console used to play Super Nintendo games\",\n" +
                "        \"productRarity\": \"Common\",\n" +
                "        \"developer\": \"Nintendo\",\n" +
                "        \"publisher\": \"Nintendo\",\n" +
                "        \"releaseDate\": 1990,\n" +
                "        \"productPrice\": 80.00,\n" +
                "        \"systemRestriction\": \"Super Nintendo\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 24,\n" +
                "        \"productName\": \"Nintendo 64\",\n" +
                "        \"productCategory\": \"System\",\n" +
                "        \"genre\": \"NA\",\n" +
                "        \"productDescription\": \"Console used to play Nintendo 64 games\",\n" +
                "        \"productRarity\": \"Common\",\n" +
                "        \"developer\": \"Nintendo\",\n" +
                "        \"publisher\": \"Nintendo\",\n" +
                "        \"releaseDate\": 1996,\n" +
                "        \"productPrice\": 100.00,\n" +
                "        \"systemRestriction\": \"Nintendo 64\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 25,\n" +
                "        \"productName\": \"Sega Genesis\",\n" +
                "        \"productCategory\": \"System\",\n" +
                "        \"genre\": \"NA\",\n" +
                "        \"productDescription\": \"Console used to play Sega Genesis games\",\n" +
                "        \"productRarity\": \"Common\",\n" +
                "        \"developer\": \"Sega\",\n" +
                "        \"publisher\": \"Sega\",\n" +
                "        \"releaseDate\": 1989,\n" +
                "        \"productPrice\": 75.00,\n" +
                "        \"systemRestriction\": \"Sega Genesis\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 26,\n" +
                "        \"productName\": \"Sega CD\",\n" +
                "        \"productCategory\": \"System\",\n" +
                "        \"genre\": \"NA\",\n" +
                "        \"productDescription\": \"Console used to play Sega CD games\",\n" +
                "        \"productRarity\": \"Uncommon\",\n" +
                "        \"developer\": \"Sega\",\n" +
                "        \"publisher\": \"Sega\",\n" +
                "        \"releaseDate\": 1991,\n" +
                "        \"productPrice\": 100.00,\n" +
                "        \"systemRestriction\": \"Sega CD\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 27,\n" +
                "        \"productName\": \"Sony Playstation\",\n" +
                "        \"productCategory\": \"System\",\n" +
                "        \"genre\": \"NA\",\n" +
                "        \"productDescription\": \"Console used to play Sony Playstation games\",\n" +
                "        \"productRarity\": \"Common\",\n" +
                "        \"developer\": \"Sony\",\n" +
                "        \"publisher\": \"Sony\",\n" +
                "        \"releaseDate\": 1994,\n" +
                "        \"productPrice\": 100.00,\n" +
                "        \"systemRestriction\": \"Sony Playstation\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 28,\n" +
                "        \"productName\": \"Sega Genesis Controller\",\n" +
                "        \"productCategory\": \"Controller\",\n" +
                "        \"genre\": \"NA\",\n" +
                "        \"productDescription\": \"Controller used to play Sega Genesis games\",\n" +
                "        \"productRarity\": \"Common\",\n" +
                "        \"developer\": \"Sega\",\n" +
                "        \"publisher\": \"Sega\",\n" +
                "        \"releaseDate\": 1991,\n" +
                "        \"productPrice\": 10.00,\n" +
                "        \"systemRestriction\": \"Sega Genesis\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 29,\n" +
                "        \"productName\": \"Sega CD Controller\",\n" +
                "        \"productCategory\": \"Controller\",\n" +
                "        \"genre\": \"NA\",\n" +
                "        \"productDescription\": \"Controller used to play Sega CD games\",\n" +
                "        \"productRarity\": \"Common\",\n" +
                "        \"developer\": \"Sega\",\n" +
                "        \"publisher\": \"Sega\",\n" +
                "        \"releaseDate\": 1991,\n" +
                "        \"productPrice\": 10.00,\n" +
                "        \"systemRestriction\": \"Sega CD\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 30,\n" +
                "        \"productName\": \"Nintendo Controller\",\n" +
                "        \"productCategory\": \"Controller\",\n" +
                "        \"genre\": \"NA\",\n" +
                "        \"productDescription\": \"Controller used to play Nintendo games\",\n" +
                "        \"productRarity\": \"Common\",\n" +
                "        \"developer\": \"Nintendo\",\n" +
                "        \"publisher\": \"Nintendo\",\n" +
                "        \"releaseDate\": 1983,\n" +
                "        \"productPrice\": 10.00,\n" +
                "        \"systemRestriction\": \"Nintendo\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 31,\n" +
                "        \"productName\": \"Super Nintendo Controller\",\n" +
                "        \"productCategory\": \"Controller\",\n" +
                "        \"genre\": \"NA\",\n" +
                "        \"productDescription\": \"Controller used to play Super Nintendo games\",\n" +
                "        \"productRarity\": \"Common\",\n" +
                "        \"developer\": \"Nintendo\",\n" +
                "        \"publisher\": \"Nintendo\",\n" +
                "        \"releaseDate\": 1990,\n" +
                "        \"productPrice\": 10.00,\n" +
                "        \"systemRestriction\": \"Super Nintendo\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 32,\n" +
                "        \"productName\": \"Nintendo 64 Controller\",\n" +
                "        \"productCategory\": \"Controller\",\n" +
                "        \"genre\": \"NA\",\n" +
                "        \"productDescription\": \"Controller used to play Nintendo 64 games\",\n" +
                "        \"productRarity\": \"Common\",\n" +
                "        \"developer\": \"Nintendo\",\n" +
                "        \"publisher\": \"Nintendo\",\n" +
                "        \"releaseDate\": 1996,\n" +
                "        \"productPrice\": 30.00,\n" +
                "        \"systemRestriction\": \"Nintendo 64\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 33,\n" +
                "        \"productName\": \"Playstation Controller\",\n" +
                "        \"productCategory\": \"Controller\",\n" +
                "        \"genre\": \"NA\",\n" +
                "        \"productDescription\": \"Controller used to play Sony Playstation games\",\n" +
                "        \"productRarity\": \"Common\",\n" +
                "        \"developer\": \"Sony\",\n" +
                "        \"publisher\": \"Sony\",\n" +
                "        \"releaseDate\": 1994,\n" +
                "        \"productPrice\": 20.00,\n" +
                "        \"systemRestriction\": \"Sony Playstation\",\n" +
                "        \"inStock\": true\n" +
                "    }\n" +
                "]";

        this.mockMvc.perform(get("/inStock"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(expectedProductJson));
    }

    //find all products by rarity
    @Test
    public void findAllProductsByRarity_withValidRarity_success() throws Exception {
        String expectedProductsJson = "[\n" +
                "    {\n" +
                "        \"productId\": 7,\n" +
                "        \"productName\": \"Snatcher\",\n" +
                "        \"productCategory\": \"Game\",\n" +
                "        \"genre\": \"Graphic Adventure\",\n" +
                "        \"productDescription\": \"A.D. 2047 Neo Kobe City, Japan, a place of madness and decadence...A mysterious Bio-roid life form has appeared. Its true nature and purpose are unknown.\",\n" +
                "        \"productRarity\": \"Rare\",\n" +
                "        \"developer\": \"Konami\",\n" +
                "        \"publisher\": \"Konami\",\n" +
                "        \"releaseDate\": 1994,\n" +
                "        \"productPrice\": 1200.00,\n" +
                "        \"systemRestriction\": \"Sega CD\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 8,\n" +
                "        \"productName\": \"Little Samson\",\n" +
                "        \"productCategory\": \"Game\",\n" +
                "        \"genre\": \"Platform\",\n" +
                "        \"productDescription\": \"The Imperial Forgy has been invaded by Ta-Keed the Prince of Darkness! Only the owners of the Magic Bells can stop his forces from destroying the realm.\",\n" +
                "        \"productRarity\": \"Rare\",\n" +
                "        \"developer\": \"Taito\",\n" +
                "        \"publisher\": \"Taito\",\n" +
                "        \"releaseDate\": 1992,\n" +
                "        \"productPrice\": 2000.00,\n" +
                "        \"systemRestriction\": \"Nintendo\",\n" +
                "        \"inStock\": false\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 14,\n" +
                "        \"productName\": \"Mega Man X2\",\n" +
                "        \"productCategory\": \"Game\",\n" +
                "        \"genre\": \"Action\",\n" +
                "        \"productDescription\": \"Just when Mega Man X thought he had brought down all the X-Hunters, several months later an uprising moves from within an abandoned factory.\",\n" +
                "        \"productRarity\": \"Rare\",\n" +
                "        \"developer\": \"Capcom\",\n" +
                "        \"publisher\": \"Capcom\",\n" +
                "        \"releaseDate\": 1994,\n" +
                "        \"productPrice\": 150.00,\n" +
                "        \"systemRestriction\": \"Super Nintendo\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 15,\n" +
                "        \"productName\": \"Mega Man X3\",\n" +
                "        \"productCategory\": \"Game\",\n" +
                "        \"genre\": \"Action\",\n" +
                "        \"productDescription\": \"Mega Man X and his trusty partner Zero have a new force to reckon with. Who or what has caused a riot of Mavericks to break out in the experimental utopia known as Doppler Town?\",\n" +
                "        \"productRarity\": \"Rare\",\n" +
                "        \"developer\": \"Capcom\",\n" +
                "        \"publisher\": \"Capcom\",\n" +
                "        \"releaseDate\": 1995,\n" +
                "        \"productPrice\": 35.00,\n" +
                "        \"systemRestriction\": \"Super Nintendo\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 18,\n" +
                "        \"productName\": \"StarCraft 64\",\n" +
                "        \"productCategory\": \"Game\",\n" +
                "        \"genre\": \"Strategy\",\n" +
                "        \"productDescription\": \"In the distant future, a small group of human exiles have been found doomed to fight for their survival on the edge of the universe.\",\n" +
                "        \"productRarity\": \"Rare\",\n" +
                "        \"developer\": \"Blizzard Entertainment\",\n" +
                "        \"publisher\": \"Nintendo\",\n" +
                "        \"releaseDate\": 2000,\n" +
                "        \"productPrice\": 100.00,\n" +
                "        \"systemRestriction\": \"Nintendo 64\",\n" +
                "        \"inStock\": false\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 21,\n" +
                "        \"productName\": \"Suikoden 2\",\n" +
                "        \"productCategory\": \"Game\",\n" +
                "        \"genre\": \"JRPG\",\n" +
                "        \"productDescription\": \"Experience An Epic Tale Of Warfare, Magic, Friendship And Betrayal. New tactical map battles add a whole new level of strategy.\",\n" +
                "        \"productRarity\": \"Rare\",\n" +
                "        \"developer\": \"SNK\",\n" +
                "        \"publisher\": \"Romstar\",\n" +
                "        \"releaseDate\": 1992,\n" +
                "        \"productPrice\": 350.00,\n" +
                "        \"systemRestriction\": \"Sony Playstation\",\n" +
                "        \"inStock\": false\n" +
                "    }\n" +
                "]";

        this.mockMvc.perform(get("/productRarity/{productRarity}", "Rare"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(expectedProductsJson));
    }

    //find all by publisher
    @Test
    public void findAllByPublisher_withValidPublisher_success() throws Exception {
        String expectedProductsJson = "[\n" +
                "    {\n" +
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
                "    },\n" +
                "    {\n" +
                "        \"productId\": 2,\n" +
                "        \"productName\": \"Sonic the Hedgehog 2\",\n" +
                "        \"productCategory\": \"Game\",\n" +
                "        \"genre\": \"Platform\",\n" +
                "        \"productDescription\": \"Sonic's back and better than ever. He's a blur in blue! A blaze of action! With his new Super Spin Dash. And a new, fabulous friend, Tails the Fox.\",\n" +
                "        \"productRarity\": \"Common\",\n" +
                "        \"developer\": \"Sega Technical Institute\",\n" +
                "        \"publisher\": \"Sega\",\n" +
                "        \"releaseDate\": 1992,\n" +
                "        \"productPrice\": 20.00,\n" +
                "        \"systemRestriction\": \"Sega Genesis\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 3,\n" +
                "        \"productName\": \"Sonic the Hedgehog 3\",\n" +
                "        \"productCategory\": \"Game\",\n" +
                "        \"genre\": \"Platform\",\n" +
                "        \"productDescription\": \"Swing from vines, launch new attacks, survive deadly traps and summon Tails to airlift Sonic out of danger.\",\n" +
                "        \"productRarity\": \"Uncommon\",\n" +
                "        \"developer\": \"Sega Technical Institute\",\n" +
                "        \"publisher\": \"Sega\",\n" +
                "        \"releaseDate\": 1994,\n" +
                "        \"productPrice\": 30.00,\n" +
                "        \"systemRestriction\": \"Sega Genesis\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 4,\n" +
                "        \"productName\": \"Liberty or Death\",\n" +
                "        \"productCategory\": \"Game\",\n" +
                "        \"genre\": \"Turn-based Strategy\",\n" +
                "        \"productDescription\": \"It's the summer of 1775 and the colonists in America are fed up with higher taxes, no representation and pledging loyalty to a King an ocean away.\",\n" +
                "        \"productRarity\": \"Uncommon\",\n" +
                "        \"developer\": \"Sega Technical Institute\",\n" +
                "        \"publisher\": \"Sega\",\n" +
                "        \"releaseDate\": 1994,\n" +
                "        \"productPrice\": 85.00,\n" +
                "        \"systemRestriction\": \"Sega Genesis\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 6,\n" +
                "        \"productName\": \"Sonic CD\",\n" +
                "        \"productCategory\": \"Game\",\n" +
                "        \"genre\": \"Platform\",\n" +
                "        \"productDescription\": \"In his first CD adventure, Sonic goes head to head with The Metal Sonic, Dr. Robotnik's evil Hedgehog creation!\",\n" +
                "        \"productRarity\": \"Common\",\n" +
                "        \"developer\": \"Sega\",\n" +
                "        \"publisher\": \"Sega\",\n" +
                "        \"releaseDate\": 1993,\n" +
                "        \"productPrice\": 60.00,\n" +
                "        \"systemRestriction\": \"Sega CD\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 25,\n" +
                "        \"productName\": \"Sega Genesis\",\n" +
                "        \"productCategory\": \"System\",\n" +
                "        \"genre\": \"NA\",\n" +
                "        \"productDescription\": \"Console used to play Sega Genesis games\",\n" +
                "        \"productRarity\": \"Common\",\n" +
                "        \"developer\": \"Sega\",\n" +
                "        \"publisher\": \"Sega\",\n" +
                "        \"releaseDate\": 1989,\n" +
                "        \"productPrice\": 75.00,\n" +
                "        \"systemRestriction\": \"Sega Genesis\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 26,\n" +
                "        \"productName\": \"Sega CD\",\n" +
                "        \"productCategory\": \"System\",\n" +
                "        \"genre\": \"NA\",\n" +
                "        \"productDescription\": \"Console used to play Sega CD games\",\n" +
                "        \"productRarity\": \"Uncommon\",\n" +
                "        \"developer\": \"Sega\",\n" +
                "        \"publisher\": \"Sega\",\n" +
                "        \"releaseDate\": 1991,\n" +
                "        \"productPrice\": 100.00,\n" +
                "        \"systemRestriction\": \"Sega CD\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 28,\n" +
                "        \"productName\": \"Sega Genesis Controller\",\n" +
                "        \"productCategory\": \"Controller\",\n" +
                "        \"genre\": \"NA\",\n" +
                "        \"productDescription\": \"Controller used to play Sega Genesis games\",\n" +
                "        \"productRarity\": \"Common\",\n" +
                "        \"developer\": \"Sega\",\n" +
                "        \"publisher\": \"Sega\",\n" +
                "        \"releaseDate\": 1991,\n" +
                "        \"productPrice\": 10.00,\n" +
                "        \"systemRestriction\": \"Sega Genesis\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 29,\n" +
                "        \"productName\": \"Sega CD Controller\",\n" +
                "        \"productCategory\": \"Controller\",\n" +
                "        \"genre\": \"NA\",\n" +
                "        \"productDescription\": \"Controller used to play Sega CD games\",\n" +
                "        \"productRarity\": \"Common\",\n" +
                "        \"developer\": \"Sega\",\n" +
                "        \"publisher\": \"Sega\",\n" +
                "        \"releaseDate\": 1991,\n" +
                "        \"productPrice\": 10.00,\n" +
                "        \"systemRestriction\": \"Sega CD\",\n" +
                "        \"inStock\": true\n" +
                "    }\n" +
                "]";

        this.mockMvc.perform(get("/publisher/{publisher}", "Sega"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(expectedProductsJson));
    }

    //find all by developer
    @Test
    public void findAllByDeveloper_withValidDeveloper_success() throws Exception {
        String expectedProductsJson = "[\n" +
                "    {\n" +
                "        \"productId\": 22,\n" +
                "        \"productName\": \"Nintendo\",\n" +
                "        \"productCategory\": \"System\",\n" +
                "        \"genre\": \"NA\",\n" +
                "        \"productDescription\": \"Console used to play Nintendo games\",\n" +
                "        \"productRarity\": \"Common\",\n" +
                "        \"developer\": \"Nintendo\",\n" +
                "        \"publisher\": \"Nintendo\",\n" +
                "        \"releaseDate\": 1983,\n" +
                "        \"productPrice\": 75.00,\n" +
                "        \"systemRestriction\": \"Nintendo\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 23,\n" +
                "        \"productName\": \"Super Nintendo\",\n" +
                "        \"productCategory\": \"System\",\n" +
                "        \"genre\": \"NA\",\n" +
                "        \"productDescription\": \"Console used to play Super Nintendo games\",\n" +
                "        \"productRarity\": \"Common\",\n" +
                "        \"developer\": \"Nintendo\",\n" +
                "        \"publisher\": \"Nintendo\",\n" +
                "        \"releaseDate\": 1990,\n" +
                "        \"productPrice\": 80.00,\n" +
                "        \"systemRestriction\": \"Super Nintendo\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 24,\n" +
                "        \"productName\": \"Nintendo 64\",\n" +
                "        \"productCategory\": \"System\",\n" +
                "        \"genre\": \"NA\",\n" +
                "        \"productDescription\": \"Console used to play Nintendo 64 games\",\n" +
                "        \"productRarity\": \"Common\",\n" +
                "        \"developer\": \"Nintendo\",\n" +
                "        \"publisher\": \"Nintendo\",\n" +
                "        \"releaseDate\": 1996,\n" +
                "        \"productPrice\": 100.00,\n" +
                "        \"systemRestriction\": \"Nintendo 64\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 30,\n" +
                "        \"productName\": \"Nintendo Controller\",\n" +
                "        \"productCategory\": \"Controller\",\n" +
                "        \"genre\": \"NA\",\n" +
                "        \"productDescription\": \"Controller used to play Nintendo games\",\n" +
                "        \"productRarity\": \"Common\",\n" +
                "        \"developer\": \"Nintendo\",\n" +
                "        \"publisher\": \"Nintendo\",\n" +
                "        \"releaseDate\": 1983,\n" +
                "        \"productPrice\": 10.00,\n" +
                "        \"systemRestriction\": \"Nintendo\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 31,\n" +
                "        \"productName\": \"Super Nintendo Controller\",\n" +
                "        \"productCategory\": \"Controller\",\n" +
                "        \"genre\": \"NA\",\n" +
                "        \"productDescription\": \"Controller used to play Super Nintendo games\",\n" +
                "        \"productRarity\": \"Common\",\n" +
                "        \"developer\": \"Nintendo\",\n" +
                "        \"publisher\": \"Nintendo\",\n" +
                "        \"releaseDate\": 1990,\n" +
                "        \"productPrice\": 10.00,\n" +
                "        \"systemRestriction\": \"Super Nintendo\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 32,\n" +
                "        \"productName\": \"Nintendo 64 Controller\",\n" +
                "        \"productCategory\": \"Controller\",\n" +
                "        \"genre\": \"NA\",\n" +
                "        \"productDescription\": \"Controller used to play Nintendo 64 games\",\n" +
                "        \"productRarity\": \"Common\",\n" +
                "        \"developer\": \"Nintendo\",\n" +
                "        \"publisher\": \"Nintendo\",\n" +
                "        \"releaseDate\": 1996,\n" +
                "        \"productPrice\": 30.00,\n" +
                "        \"systemRestriction\": \"Nintendo 64\",\n" +
                "        \"inStock\": true\n" +
                "    }\n" +
                "]";

        this.mockMvc.perform(get("/developer/{developer}", "Nintendo"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(expectedProductsJson));
    }

    //find all by release date
    @Test
    public void findAllByReleaseDate_withValidReleaseDate_success() throws Exception {
        String expectedProductsJson = "[\n" +
                "    {\n" +
                "        \"productId\": 12,\n" +
                "        \"productName\": \"Super Mario RPG\",\n" +
                "        \"productCategory\": \"Game\",\n" +
                "        \"genre\": \"RPG\",\n" +
                "        \"productDescription\": \"Mario returns in this incredible new role-playing adventure! His latest rival is Smithy, a menacing creature who causes fear and treachery in the Mushroom Kingdom.\",\n" +
                "        \"productRarity\": \"Uncommon\",\n" +
                "        \"developer\": \"Square\",\n" +
                "        \"publisher\": \"Nintendo\",\n" +
                "        \"releaseDate\": 1996,\n" +
                "        \"productPrice\": 85.00,\n" +
                "        \"systemRestriction\": \"Super Nintendo\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 16,\n" +
                "        \"productName\": \"Super Mario 64\",\n" +
                "        \"productCategory\": \"Game\",\n" +
                "        \"genre\": \"Adventure\",\n" +
                "        \"productDescription\": \"Mario is super in a whole new way! Combining the finest 3-D graphics ever developed for a video game and an explosive sound track.\",\n" +
                "        \"productRarity\": \"Common\",\n" +
                "        \"developer\": \"Nintendo EAD\",\n" +
                "        \"publisher\": \"Nintendo\",\n" +
                "        \"releaseDate\": 1996,\n" +
                "        \"productPrice\": 30.00,\n" +
                "        \"systemRestriction\": \"Nintendo 64\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 24,\n" +
                "        \"productName\": \"Nintendo 64\",\n" +
                "        \"productCategory\": \"System\",\n" +
                "        \"genre\": \"NA\",\n" +
                "        \"productDescription\": \"Console used to play Nintendo 64 games\",\n" +
                "        \"productRarity\": \"Common\",\n" +
                "        \"developer\": \"Nintendo\",\n" +
                "        \"publisher\": \"Nintendo\",\n" +
                "        \"releaseDate\": 1996,\n" +
                "        \"productPrice\": 100.00,\n" +
                "        \"systemRestriction\": \"Nintendo 64\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 32,\n" +
                "        \"productName\": \"Nintendo 64 Controller\",\n" +
                "        \"productCategory\": \"Controller\",\n" +
                "        \"genre\": \"NA\",\n" +
                "        \"productDescription\": \"Controller used to play Nintendo 64 games\",\n" +
                "        \"productRarity\": \"Common\",\n" +
                "        \"developer\": \"Nintendo\",\n" +
                "        \"publisher\": \"Nintendo\",\n" +
                "        \"releaseDate\": 1996,\n" +
                "        \"productPrice\": 30.00,\n" +
                "        \"systemRestriction\": \"Nintendo 64\",\n" +
                "        \"inStock\": true\n" +
                "    }\n" +
                "]";

        this.mockMvc.perform(get("/releaseDate/{releaseDate}", 1996))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(expectedProductsJson));
    }

    //find all by genre
    @Test
    public void findAllByGenre_withValidGenre_success() throws Exception {
        String expectedProductsJson = "[\n" +
                "    {\n" +
                "        \"productId\": 13,\n" +
                "        \"productName\": \"Mega Man X\",\n" +
                "        \"productCategory\": \"Game\",\n" +
                "        \"genre\": \"Action\",\n" +
                "        \"productDescription\": \"Near the end of his life, Dr. Light succeeds in creating the first of a new series of robots which will change the world. Able to think and make decisions, this new robot holds great danger as well as great possibilities.\",\n" +
                "        \"productRarity\": \"Common\",\n" +
                "        \"developer\": \"Capcom\",\n" +
                "        \"publisher\": \"Capcom\",\n" +
                "        \"releaseDate\": 1993,\n" +
                "        \"productPrice\": 35.00,\n" +
                "        \"systemRestriction\": \"Super Nintendo\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 14,\n" +
                "        \"productName\": \"Mega Man X2\",\n" +
                "        \"productCategory\": \"Game\",\n" +
                "        \"genre\": \"Action\",\n" +
                "        \"productDescription\": \"Just when Mega Man X thought he had brought down all the X-Hunters, several months later an uprising moves from within an abandoned factory.\",\n" +
                "        \"productRarity\": \"Rare\",\n" +
                "        \"developer\": \"Capcom\",\n" +
                "        \"publisher\": \"Capcom\",\n" +
                "        \"releaseDate\": 1994,\n" +
                "        \"productPrice\": 150.00,\n" +
                "        \"systemRestriction\": \"Super Nintendo\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 15,\n" +
                "        \"productName\": \"Mega Man X3\",\n" +
                "        \"productCategory\": \"Game\",\n" +
                "        \"genre\": \"Action\",\n" +
                "        \"productDescription\": \"Mega Man X and his trusty partner Zero have a new force to reckon with. Who or what has caused a riot of Mavericks to break out in the experimental utopia known as Doppler Town?\",\n" +
                "        \"productRarity\": \"Rare\",\n" +
                "        \"developer\": \"Capcom\",\n" +
                "        \"publisher\": \"Capcom\",\n" +
                "        \"releaseDate\": 1995,\n" +
                "        \"productPrice\": 35.00,\n" +
                "        \"systemRestriction\": \"Super Nintendo\",\n" +
                "        \"inStock\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"productId\": 20,\n" +
                "        \"productName\": \"Mega Man X4\",\n" +
                "        \"productCategory\": \"Game\",\n" +
                "        \"genre\": \"Action\",\n" +
                "        \"productDescription\": \"Battle armies of Maverick Reploid Robots while mastering all-new strategic moves like the Air hover and Zero's Saber Tactic system.\",\n" +
                "        \"productRarity\": \"Uncommon\",\n" +
                "        \"developer\": \"Capcom\",\n" +
                "        \"publisher\": \"Capcom\",\n" +
                "        \"releaseDate\": 1997,\n" +
                "        \"productPrice\": 30.00,\n" +
                "        \"systemRestriction\": \"Sony Playstation\",\n" +
                "        \"inStock\": true\n" +
                "    }\n" +
                "]";

        this.mockMvc.perform(get("/genre/{genre}", "Action"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(expectedProductsJson));
    }
}
