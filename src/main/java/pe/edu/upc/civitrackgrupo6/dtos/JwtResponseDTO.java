package pe.edu.upc.civitrackgrupo6.dtos;

import java.io.Serializable;

public class JwtResponseDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String token;

    public JwtResponseDTO(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
