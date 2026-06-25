

package com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service;

import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto.dtocliente;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto.dtoproducto;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto.dtosecretario;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto.dtoventa;
import java.util.List;


public interface Busacaralgointerface {
    List<dtosecretario> buscarsecretario(String index,  List<dtosecretario> lista);
    List<dtocliente> buscarcliente(String index, List<dtocliente> lista);
    List<dtoproducto> buscarproducto(String index, List<dtoproducto> lista );

}
