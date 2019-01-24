package com.project1.demo.payload;

import com.project1.demo.data.entity.Player;
import org.springframework.data.domain.Page;
import org.springframework.ui.ModelMap;

import java.util.List;

public class S42Response {
    private Page<Player> dataPlayer;
    private int currentPage;
    private int currentSize;
    private ModelMap model;

    public S42Response(Page<Player> dataPlayer, int currentPage, int currentSize, ModelMap model) {
        this.dataPlayer = dataPlayer;
        this.currentPage = currentPage;
        this.currentSize = currentSize;
        this.model = model;
    }

    public Page<Player> getDataPlayer() {
        return dataPlayer;
    }

    public void setDataPlayer(Page<Player> dataPlayer) {
        this.dataPlayer = dataPlayer;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public void setCurrentSize(int currentSize) {
        this.currentSize = currentSize;
    }

    public ModelMap getModel() {
        return model;
    }

    public void setModel(ModelMap model) {
        this.model = model;
    }
}
