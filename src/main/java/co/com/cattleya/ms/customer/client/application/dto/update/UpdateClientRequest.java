package co.com.cattleya.client.application.dto.update;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateClientRequest {
    private String name;
    private int age;
    private String description;
    private String photo;
}
