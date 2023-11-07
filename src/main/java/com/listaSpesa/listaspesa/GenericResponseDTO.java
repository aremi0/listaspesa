package com.listaSpesa.listaspesa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GenericResponseDTO<T> {
    private List<T> objects;
    private boolean isError;
    private String errorMessage;
}
