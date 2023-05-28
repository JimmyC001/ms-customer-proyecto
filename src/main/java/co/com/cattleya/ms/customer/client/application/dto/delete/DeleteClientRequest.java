package co.com.cattleya.ms.customer.client.application.dto.delete;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class DeleteClientRequest {
    private String name;
}
