package com.listaSpesa.listaspesa.dto;

import com.listaSpesa.listaspesa.entity.ArticoloMarket;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class InventarioRequest {
    private List<ArticoloMarket> inventario;
}
