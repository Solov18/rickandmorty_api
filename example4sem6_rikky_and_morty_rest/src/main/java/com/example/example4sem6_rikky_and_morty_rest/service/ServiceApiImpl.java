package com.example.example4sem6_rikky_and_morty_rest.service;

import com.example.example4sem6_rikky_and_morty_rest.domain.Characters;
import com.example.example4sem6_rikky_and_morty_rest.domain.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ServiceApiImpl implements ServiceApi {

    @Autowired
    private RestTemplate template;

    @Autowired
    private HttpHeaders headers;

  /* @Value("${api.character.url}")
    private String characterApiUrl;*/

    private  static final String characterApiUrl = "https://rickandmortyapi.com/api/character";


    @Override
    public Characters getAllCharacters() {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Characters> response = template.exchange(characterApiUrl, HttpMethod.GET, entity, Characters.class);

        return response.getBody();
    }

    @Override
    public Result getCharacterById(Integer id) {
        String url = characterApiUrl + "/" + id;
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Result> response = template.exchange(url, HttpMethod.GET, entity, Result.class);
        return response.getBody();
    }

    @Override
    public Characters getCharacterByName(String name) {
        String url = characterApiUrl + "/?name=" + name;
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Characters> response = template.exchange(url, HttpMethod.GET, entity, Characters.class);
        return response.getBody();


    }
    @Override
    public Characters getCharacterByGender(String gender) {
        String url = characterApiUrl + "/?gender=" + gender;
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Characters> response = template.exchange(url, HttpMethod.GET, entity, Characters.class);
        return response.getBody();
    }
}
