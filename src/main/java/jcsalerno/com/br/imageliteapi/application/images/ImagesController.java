package jcsalerno.com.br.imageliteapi.application.images;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@RestController
@RequestMapping("/v1/images")
@Slf4j
public class ImagesController {

    private static final Logger log = LoggerFactory.getLogger(ImagesController.class);

    @PostMapping
    public ResponseEntity save(
            @RequestParam("file") MultipartFile file,
            @RequestParam("name") String name,
            @RequestParam("tags") List<String> tags
            ){
        log.info("Imagem recebica: name: {}, size: {}", file.getOriginalFilename(), file.getSize());
        log.info("Nome defindo para a imagem: {} ", name);
        log.info("Tags: {} ", tags);
        return ResponseEntity.ok().build();


    }
}
