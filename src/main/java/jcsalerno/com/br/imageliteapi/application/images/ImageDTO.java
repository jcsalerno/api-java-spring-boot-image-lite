package jcsalerno.com.br.imageliteapi.application.images;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;

@Data
@Builder
public class ImageDTO {

    private String url;
    private String extension;
    private String name;
    private Long size;
    private LocalDate uploadData; // Alterado para LocalDate

    // Adicionado o método setter para uploadData
    public void setUploadData(LocalDate uploadData) {
        this.uploadData = uploadData;
    }
}
