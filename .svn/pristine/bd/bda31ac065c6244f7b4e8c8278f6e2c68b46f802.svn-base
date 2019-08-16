package com.seguridad.utilidad;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author user
 */
public class OpcionMenu {

    private int id;
    private String etiqueta;
    private String comando;
    private boolean modulo;
    private OpcionMenu menu;
    private List<OpcionMenu> menus = new ArrayList<>();

    public OpcionMenu() {
        id = 0;
        etiqueta = "";
        comando = "";
    }

    public OpcionMenu(OpcionMenu menu) {
        this.id = menu.getId();
        this.etiqueta = menu.getEtiqueta();
        this.comando = menu.getComando();
    }

    public OpcionMenu search(OpcionMenu node) {
        OpcionMenu resultado = null;
        int idx = 0;
        OpcionMenu n;

        //if (!this.modulo) {
            if (node.equals(this)) {
                resultado = this;
            } else {
                while (idx < menus.size() && resultado == null) {
                    n = menus.get(idx);
                    resultado = n.search(node);
                    idx++;
                }
            }
        //}

        return resultado;
    }

    public void addChild(OpcionMenu child) {
        this.menus.add(child);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String getComando() {
        return comando;
    }

    public void setComando(String comando) {
        this.comando = comando;
    }

    public boolean isModulo() {
        return modulo;
    }

    public void setModulo(boolean modulo) {
        this.modulo = modulo;
    }

    public OpcionMenu getMenu() {
        return menu;
    }

    public void setMenu(OpcionMenu menu) {
        this.menu = menu;
    }

    public List<OpcionMenu> getMenus() {
        return menus;
    }

    public void setMenus(List<OpcionMenu> menus) {
        this.menus = menus;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.id;
        hash = 17 * hash + Objects.hashCode(this.etiqueta);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OpcionMenu other = (OpcionMenu) obj;
        if (this.id != other.id) {
            return false;
        }
        return Objects.equals(this.etiqueta, other.etiqueta);
    }
    

}
