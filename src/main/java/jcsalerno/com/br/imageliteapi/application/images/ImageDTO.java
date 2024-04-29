package jcsalerno.com.br.imageliteapi.application.images;
import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate uploadData;
    public void setUploadData(LocalDate uploadData) {
        this.uploadData = uploadData;
    }
}
