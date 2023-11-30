package ma.baggar.bmsback.Dto.Shared;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ApiResponsePagination<T> {
int nbrOfElement;
T response;
}
